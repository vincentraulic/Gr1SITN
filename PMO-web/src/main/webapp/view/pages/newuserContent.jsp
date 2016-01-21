
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Créer un compte utilisateur</h1>
		<ol class="breadcrumb">
			<li><a href="./user/home"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Créer un compte utilisateur</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<!-- Main row -->

		<form action="#" method="POST">
			<div class="row">
				<!-- Left col -->
				<section class="col-lg-7 connectedSortable">

					<div class="box">

						<div class="box-header">
							<h3 class="box-title">Signalétique</h3>
						</div>

						<div class="box-body">

							<div class="form-group">
								<label for="name">Nom</label> <input class="form-control"
									placeholder="" type="text" id="nom" name="nom" required />
							</div>

							<div class="form-group">
								<label for="name">Prénom</label> <input class="form-control"
									placeholder="" type="text" id="prenom" name="prenom" required />
							</div>

							<div class="form-group">
								<label>Date de naissance</label>

								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control" data-inputmask="'alias': 'dd/mm/yyyy'" data-mask>
									<input class="form-control"
										data-inputmask="'alias': 'dd/mm/yyyy'" data-mask=""
										type="text" id="datenaissance" name="datenaissance" required />
								</div>
								<!-- /.input group -->
							</div>

							<div class="form-group">
								<label>E-mail</label>

								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<input class="form-control" data-inputmask="'alias': 'email'"
										data-mask="" type="text" id="email" name="email" required />
								</div>
								<!-- /.input group -->
							</div>

							<div class="form-group">
								<label>Téléphone</label>

								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-phone"></i>
									</div>
									<input type="text" class="form-control" data-inputmask="'mask': ['999-999-9999 [x99999]', '+099 99 99 9999[9]-9999']" data-mask>
									<input class="form-control"
										data-inputmask="'mask': ['99-99-99-99-99', '+09 99 99 99 99']"
										data-mask="" type="text" id="telephone" name="telephone"
										required />
								</div>
								<!-- /.input group -->
							</div>

						</div>
					</div>
				</section>
				<!-- right col -->
				<section class="col-lg-5 connectedSortable">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Société</h3>
						</div>
						<div class="box-body">

							<div class="form-group">
								<label>Date d'arrivée</label>

								<div class="input-group">
								
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right" id="reservation">
									<input class="form-control"
										data-inputmask="'alias': 'dd/mm/yyyy'" data-mask=""
										type="text" id="datearrivee" name="datearrivee" />
								</div>
								<!-- /.input group -->
							</div>

							<div class="form-group">
								<label for="name">Poste</label> <input class="form-control"
									placeholder="" type="text" id="poste" name="poste" required />
							</div>

							<div class="form-group">
								<label>Projets</label> <select multiple class="form-control"
									id="projets" name="projets">
									<option>option 1</option>
									<option>option 2</option>
									<option>option 3</option>
									<option>option 4</option>
									<option>option 5</option>
								</select>
							</div>

						</div>

						<div class="box-footer">
							<button type="submit" class="btn btn-default">Annuler</button>
							<button type="submit" class="btn btn-info pull-right">Valider</button>
						</div>

					</div>
				</section>
			</div>
			
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
		<!-- /.row -->

	</section>

</div>
<!-- /.content-wrapper -->

<!-- Page script -->
<script>
  $(function () {
    //Initialize Select2 Elements
    $(".select2").select2();

    //Datemask dd/mm/yyyy
    $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
    //Datemask2 mm/dd/yyyy
    $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
    //Money Euro
    $("[data-mask]").inputmask();

    //Date range picker
    $('#reservation').daterangepicker();
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
    //Date range as a button
    $('#daterange-btn').daterangepicker(
        {
          ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
          },
          startDate: moment().subtract(29, 'days'),
          endDate: moment()
        },
        function (start, end) {
          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        }
    );

    //iCheck for checkbox and radio inputs
    $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
      checkboxClass: 'icheckbox_minimal-blue',
      radioClass: 'iradio_minimal-blue'
    });
    //Red color scheme for iCheck
    $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
      checkboxClass: 'icheckbox_minimal-red',
      radioClass: 'iradio_minimal-red'
    });
    //Flat red color scheme for iCheck
    $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
      checkboxClass: 'icheckbox_flat-green',
      radioClass: 'iradio_flat-green'
    });

    //Colorpicker
    $(".my-colorpicker1").colorpicker();
    //color picker with addon
    $(".my-colorpicker2").colorpicker();

    //Timepicker
    $(".timepicker").timepicker({
      showInputs: false
    });
  });
</script>