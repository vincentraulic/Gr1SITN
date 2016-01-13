<!-- fullCalendar 2.2.5 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="../plugins/fullcalendar/fullcalendar.min.js"></script>
<!-- Page specific script -->
<script>
	$(function() {

		/* initialize the external events
		 -----------------------------------------------------------------*/
		function ini_events(ele) {
			ele.each(function() {

				// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
				// it doesn't need to have a start or end
				var eventObject = {
					title : $.trim($(this).text())
				// use the element's text as the event title
				};

				// store the Event Object in the DOM element so we can get to it later
				$(this).data('eventObject', eventObject);

				// make the event draggable using jQuery UI
				$(this).draggable({
					zIndex : 1070,
					revert : true, // will cause the event to go back to its
					revertDuration : 0
				//  original position after the drag
				});

			});
		}

		ini_events($('#external-events div.external-event'));

		/* initialize the calendar
		 -----------------------------------------------------------------*/
		//init data
		//init data
		/* probleme pour les couleurs */
		$.ajax({
			url : '<c:url value="/event/events"/>',
			type : 'POST',
			data : '',
			async : false,
			success : function(response) {
				json_events = response;
			}
		});

		$('#calendar').fullCalendar({
			   events: JSON.parse(json_events)
		});

		/*$('#calendar').fullCalendar({

		    events: {
		        url: '<c:url value="/event/events"/>',
		        type: 'POST',
		        data: {
		        },
		        error: function() {
		            alert('there was an error while fetching events!');
		        },
		        color: 'yellow',   // a non-ajax option
		        textColor: 'black' // a non-ajax option
		        backgroundColor: "#f56954", //red
		        borderColor: "#f56954"
		    }

		});*/

		
		 
		//Date for the calendar events (dummy data)
		var date = new Date();
		var d = date.getDate(), m = date.getMonth(), y = date.getFullYear();
		$('#calendar')
				.fullCalendar(
						{
							header : {
								left : 'prev,next today',
								center : 'title',
								right : 'month,agendaWeek,agendaDay'
							},
							buttonText : {
								today : 'today',
								month : 'month',
								week : 'week',
								day : 'day'
							},
							editable : true,
							droppable : true, // this allows things to be dropped onto the calendar !!!
							drop : function(date, allDay) { // this function is called when something is dropped

								// retrieve the dropped element's stored Event Object
								var originalEventObject = $(this).data(
										'eventObject');

								// we need to copy it, so that multiple events don't have a reference to the same object
								var copiedEventObject = $.extend({},
										originalEventObject);

								// assign title and type
								var type = copiedEventObject.title;
								copiedEventObject.type = copiedEventObject.title;
								copiedEventObject.title = copiedEventObject.title
										+ ("#motifEvent").val();
								// assign it the date that was reported
								copiedEventObject.start = date;
								copiedEventObject.allDay = allDay;
								copiedEventObject.backgroundColor = $(this)
										.css("background-color");
								copiedEventObject.borderColor = $(this).css(
										"border-color");
								
								/*set start and end date*/
								copiedEventObject.start = date;
								var end = new Date(date);
								end.setHours(date.getHours() + 1); //default + 1h
								copiedEventObject.end = end;

								$.ajax({
											url : '<c:url value="/event/new"/>',
											data : 'type=' + type + '&title='
													+ title + '&startdate='
													+ start + '&enddate=' + end,
											type : 'POST',
											dataType : 'json',
											success : function(response) {
												copiedEventObject.id = response.eventid;
												$('#calendar').fullCalendar(
														'renderEvent',
														copiedEventObject, true);
											},
											error : function(e) {
												console.log(e.responseText);
											}
										});

								// render the event on the calendar
								// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
								
								//$('#calendar').fullCalendar('renderEvent',
									//	copiedEventObject, true);

								// is the "remove after drop" checkbox checked?
								if ($('#drop-remove').is(':checked')) {
									// if so, remove the element from the "Draggable Events" list
									$(this).remove();
								}

							},
							eventResize : function(event, delta, revertFunc) {

								alert(event.title + " end is now "
										+ event.end.format());

								$.ajax({
									url : '<c:url value="/event/update"/>"',
									data : 'eventid=' + event.id
											+ '&startdate=' + event.start
											+ '&enddate=' + event.end,
									type : 'POST',
									dataType : 'json',
									success : function(response) {
										if (response.status == 200)
											$('#calendar').fullCalendar(
													'updateEvent', event);
									},
									error : function(e) {
										alert('Error processing your request: '
												+ e.responseText);
									}
								});

							},
							eventDrop: function(event, delta, revertFunc) {
								   var title = event.title;
								   var start = event.start.format();
								   var end = (event.end == null) ? start : event.end.format();
								   u$.ajax({
								     url: '<c:url value="/event/update"/>"',
								     data: 'eventid=' + event.id
										+ '&startdate=' + event.start
										+ '&enddate=' + event.end,
								     type: 'POST',
								     dataType: 'json',
								     success: function(response){
								       if(response.status != 'success')
								       revertFunc();
								     },
								     error: function(e){
								       revertFunc();
								       alert('Error processing your request: '+e.responseText);
								     }
								     });
								}

						});

		

		/* ADDING EVENTS */
		var currColor = "#3c8dbc"; //Red by default
		//Color chooser button
		var colorChooser = $("#color-chooser-btn");
		$("#color-chooser > li > a").click(function(e) {
			e.preventDefault();
			//Save color
			currColor = $(this).css("color");
			//Add color effect to button
			$('#add-new-event').css({
				"background-color" : currColor,
				"border-color" : currColor
			});
		});
		$("#add-new-event").click(function(e) {
			e.preventDefault();
			//Get value and make sure it is not null
			var val = $("#new-event").val();
			if (val.length == 0) {
				return;
			}

			//Create events
			var event = $("<div />");
			event.css({
				"background-color" : currColor,
				"border-color" : currColor,
				"color" : "#fff"
			}).addClass("external-event");
			event.html(val);

			$('#external-events').prepend(event);

			//Add draggable funtionality
			ini_events(event);

			//Remove event from text input
			$("#new-event").val("");
		});
	});
</script>