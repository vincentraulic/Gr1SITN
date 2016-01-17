<!-- fullCalendar 2.2.5 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="<c:url value="/resources/plugins/fullcalendar/fullcalendar.min.js"/>"></script>
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

		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");

		/* initialize the calendar
		 -----------------------------------------------------------------*/
		//init data
		$.ajax({
			url : '<c:url value="/user/event/events"/>',
			type : 'POST',
			data : header + '=' + token,
			async : false,
			success : function(response) {
				json_events = response;
			}
		});

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
							/* probleme pour les couleurs */
							events: json_events,
							editable : true,
							droppable : true, // this allows things to be dropped onto the calendar !!!
							drop : function( date, jsEvent, ui, resourceId ) { // this function is called when something is dropped

								// retrieve the dropped element's stored Event Object
								var originalEventObject = $(this).data('eventObject');
								originalEventObject.reason = $("#motifEvent").val();
								
								// we need to copy it, so that multiple events don't have a reference to the same object
								var copiedEventObject = $.extend({},
										originalEventObject);

								// assign title and type
								var type = copiedEventObject.title;
								copiedEventObject.type = copiedEventObject.title;
								copiedEventObject.title = copiedEventObject.title + " : "
										+ copiedEventObject.reason;
								// assign it the date that was reported
								copiedEventObject.start = date;
								if (typeof date._ambigTime !== 'undefined') {
									copiedEventObject.allDay = date._ambigTime;
								}
								else
									copiedEventObject.allDay = false;
								copiedEventObject.backgroundColor = $(this)
										.css("background-color");
								copiedEventObject.borderColor = $(this).css(
										"border-color");
								
								/*set start and end date*/
								var start = new Date(date);
								copiedEventObject.start = start;
								var end = new Date(date);
								end.setHours(end.getHours() + 1); //default + 1h
								copiedEventObject.end = end;

								$.ajax({
											url : '<c:url value="/user/event/new"/>',
											data : header + '=' + token +
													'&type=' + type + '&reason='
													+ copiedEventObject.reason + '&startdate='
													+ copiedEventObject.start.getTime() + '&enddate=' 
													+ copiedEventObject.end.getTime() + '&allDay='
													+ copiedEventObject.allDay,
											type : 'POST',
											dataType : 'json',
											success : function(response) {
												if(response > 0){
													copiedEventObject.id_event = response;
													$('#calendar').fullCalendar('renderEvent',
																		copiedEventObject, true);
												}
											},
											error : function(e) {
												console.log("ERROR: ", e);
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
									url : '<c:url value="/user/event/update"/>',
									data : 	header + '=' + token +
											'&eventid=' + event.id_event
											+ '&startdate=' + event.start
											+ '&enddate=' + event.end
											+ '&allDay=' + event.allDay,
									type : 'POST',
									dataType : 'json',
									success : function(response) {
										if(response > 0)
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
								   var start = event.start;
								   var end = (event.end == null) ? start : event.end;
								   $.ajax({
								     url: '<c:url value="/user/event/update"/>',
								     data: 	header + '=' + token +
									     	'&eventid=' + event.id_event
											+ '&startdate=' + start
											+ '&enddate=' + end
											+ '&allDay=' + event.allDay,
								     type: 'POST',
								     dataType: 'json',
								     success: function(response){
								    	 if(response > 0)
								    		 $('#calendar').fullCalendar(
														'updateEvent', event);
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