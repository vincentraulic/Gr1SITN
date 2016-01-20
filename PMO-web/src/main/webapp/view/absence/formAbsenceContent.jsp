  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Ajouter une absence
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Ajouter une absence</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Small boxes (Stat box) -->
      <div class="row">
        <div class="col-lg-3 col-xs-6">
        </div>
        <!-- ./col -->
      </div>
      <!-- /.row -->
    
     <div class="row">
			<div class="box">
				<div class="box-header">
Ajout de l'absence - Informations
				</div>
				<!-- /.box-header -->
				<div class="box-body table-responsive no-padding">
					<form action="/user/event/new" method="POST">
<input type="hidden" name="type" value="absence" />
Reason : <input type="text" name="reason" /> <br />
Start Date : <input type="text" name="startdate" /> <br />
End Date : <input type="text" name="enddate" /> <br />
All Day : <input type="text" name="allDay" /> <br />
<button type="submit" name="sendForm">
Ajouter l'absence
</button>
</form>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
      </div>

	  <!-- Main row -->
      <div class="row">
        <!-- /.Left col -->
        <!-- right col -->
        <section class="col-lg-5 connectedSortable">
        </section>
        <!-- right col -->
      </div>
      <!-- /.row (main row) -->
      
    </section>      
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->