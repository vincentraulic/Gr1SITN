
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
		<div class="row">
			<!-- Left col -->
			<section class="col-lg-7 connectedSortable">

				<div class="box">
				
					<div class="box-header">
						<h3 class="box-title">Signalétique</h3>
					</div>
					
					<div class="box-body">

						<div class="form-group">
							<label for="name">Nom</label>
							<input class="form-control" placeholder="" type="text" required />
						</div>					

						<div class="form-group">
							<label for="name">Prénom</label>
							<input class="form-control" placeholder="" type="text" required />
						</div>		
						
						<div class="form-group">
							<label>Date de naissance</label>

							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input class="form-control" data-inputmask="'alias': 'dd/mm/yyyy'" data-mask="" type="text" required />
							</div>
							<!-- /.input group -->
						</div>					
					
						<div class="form-group">
							<label>E-mail</label>

							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-envelope"></i>
								</div>
								<input class="form-control" data-inputmask="'alias': 'email'" data-mask="" type="text" required />
							</div>
							<!-- /.input group -->
						</div>	
					
						<div class="form-group">
							<label>Téléphone</label>

							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-phone"></i>
								</div>
								<input class="form-control" data-inputmask="'mask': ['99-99-99-99-99', '+09 99 99 99 99']" data-mask="" type="text" required />
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
								<input class="form-control" data-inputmask="'alias': 'dd/mm/yyyy'" data-mask="" type="text">
							</div>
							<!-- /.input group -->
						</div>		
					
						<div class="form-group">
							<label for="name">Poste</label>
							<input class="form-control" placeholder="" type="text" required />
						</div>				

						<div class="form-group">
							<label>Projets</label>
							<select multiple="" class="form-control">
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
		<!-- /.row -->
		
	</section>

</div>
<!-- /.content-wrapper -->