  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Panneau de contrôle</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Small boxes (Stat box) -->
      <div class="row">
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3>150</h3>

              <p>Jours-hommes</p>
            </div>
            <div class="icon">
              <i class="ion ion-person-add"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
      </div>
      <!-- /.row -->
    
     <div class="row">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">Planning des absences</h3>
					<div>
					<a href="<c:url value="/user/event"/>"><span>Ajouter une absence</span></a>	
					</div>
					<div class="box-tools">
						<div class="input-group input-group-sm" style="width: 150px;">
							<input type="text" name="table_search"
								class="form-control pull-right" placeholder="Search">

							<div class="input-group-btn">
								<button type="submit" class="btn btn-default">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body table-responsive no-padding">
					<table class="table table-hover">
						<tr>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Date début</th>
							<th>Date fin</th>
							<th>Status</th>
							<th>Raison</th>
						</tr>
						<c:forEach items="${absences}" var="absence">
		              	<tr>
		              		<td><c:out value="${absence.employee.lastname}"/></td>
		              		<td><c:out value="${absence.employee.firstname}"/></td>
		              		<td><c:out value="${absence.start}"/></td>
		              		<td><c:out value="${absence.end}"/></td>
		              		<td><c:out value="${absence.type}"/></td>
		              		<td><c:out value="${absence.reason}"/></td>
						</tr>
					  </c:forEach>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
      </div>

	  <!-- Main row -->
      <div class="row">
        <!-- Left col -->
        <section class="col-lg-7 connectedSortable">
        
        </section>
        <!-- /.Left col -->
        <!-- right col -->
        <section class="col-lg-5 connectedSortable">
			<div class="box">
	            <div class="box-header">
	              <h3 class="box-title">Tâches en cours</h3>
	
	              <div class="box-tools">
	                <ul class="pagination pagination-sm no-margin pull-right">
	                  <li><a href="#">&laquo;</a></li>
	                  <li><a href="#">1</a></li>
	                  <li><a href="#">2</a></li>
	                  <li><a href="#">3</a></li>
	                  <li><a href="#">&raquo;</a></li>
	                </ul>
	              </div>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body no-padding">
	              <table class="table">
	                <tr>
	                  <th style="width: 10px">#</th>
	                  <th>Tâche</th>
	                  <th>Responsable</th>
	                  <th>Progression</th>
	                  <th style="width: 40px"> </th>
	                </tr>
	              	<c:forEach items="${tasks}" var="task">
		              	<tr>
		              		<td><c:out value="${task.id_task}"/></td>
		              		<td><c:out value="${task.projectTask}"/></td>
		              		<td><c:out value="${task.employee}"/></td>
					        <td>
					          <div class="progress progress-xs">
					            <div class="progress-bar progress-bar-danger" style="width: 55%"></div>
					          </div>
					        </td>
		              		<td><span class="badge bg-red">55%</span></td>
						</tr>
	              	</c:forEach>
	              </table>
	            </div>
	            <!-- /.box-body -->
	          </div>
	          <!-- /.box -->

        </section>
        <!-- right col -->
      </div>
      <!-- /.row (main row) -->
      
    </section>      
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->