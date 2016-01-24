<%@ page pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Project Management Online</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="/resources/dist/css/PMO.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/dist/css/skins/skin-blue.min.css"/>">
  <!-- Calendar style -->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/daterangepicker/daterangepicker-bs3.css"/>">
  <!-- fullCalendar 2.2.5-->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/fullcalendar/fullcalendar.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/plugins/fullcalendar/fullcalendar.print.css"/>" media="print">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/timepicker/bootstrap-timepicker.min.css"/>">
  <!-- iCheck -->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/iCheck/all.css"/>">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/colorpicker/bootstrap-colorpicker.min.css"/>">
  <!-- Select2 -->
  <link rel="stylesheet" href="<c:url value="/resources/plugins/select2/select2.min.css"/>">
  
  <!-- PMO Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="<c:url value="/resources/dist/css/skins/_all-skins.min.css"/>">

  <meta name="_csrf" content="${_csrf.token}"/>
  <!-- default header name is X-CSRF-TOKEN -->
  <meta name="_csrf_header" content="${_csrf.parameterName}"/>

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
  <!-- REQUIRED JS SCRIPTS -->

	<!-- jQuery 2.1.4 -->
	<script src="<c:url value="/resources/plugins/jQuery/jQuery-2.1.4.min.js"/>"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
	<!-- PMO App -->
	<script src="<c:url value="/resources/dist/js/app.min.js"/>"></script>
	<!-- PMO for demo purposes -->
	<script src="<c:url value="/resources/dist/js/demo.js"/>"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<!-- Slimscroll -->
	<script src="<c:url value="/resources/plugins/slimScroll/jquery.slimscroll.min.js"/>"></script>
	<!-- FastClick -->
	<script src="<c:url value="/resources/plugins/fastclick/fastclick.js"/>"></script>
	<!-- InputMask -->
	<script src="<c:url value="/resources/plugins/input-mask/jquery.inputmask.js"/>"></script>
	<script src="<c:url value="/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"/>"></script>
	<script src="<c:url value="/resources/plugins/input-mask/jquery.inputmask.extensions.js"/>"></script>
	<!-- date-range-picker -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
	<script src="<c:url value="/resources/plugins/daterangepicker/daterangepicker.js"/>"></script>
    <!-- iCheck 1.0.1 -->
	<script src="<c:url value="/resources/plugins/iCheck/icheck.min.js"/>"></script>
	<!-- bootstrap time picker -->
    <script src="<c:url value="/resources/plugins/timepicker/bootstrap-timepicker.min.js"/>"></script>
    <!-- Select2 -->
    <script src="<c:url value="/resources/plugins/select2/select2.full.min.js"/>"></script>
    <!-- bootstrap color picker -->
    <script src="<c:url value="/resources/plugins/colorpicker/bootstrap-colorpicker.min.js"/>"></script>
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="<c:url value="/app/user/home"/>" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>PMO</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>PMO</b></span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">

          <!-- Tasks Menu -->
          <li class="dropdown tasks-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger"><c:out value="${fn:length(tasks)}"/></span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">Vous avez <c:out value="${fn:length(tasks)}"/> taches</li>
              <c:forEach items="${tasks}" var="task">
				  <li>
					<!-- Inner menu: contains the tasks -->
					<ul class="menu">
					  <li><!-- Task item -->
						<a href="<c:url value="/task?id='${task.id_task}'"/>">
						  <!-- Task title -->
						  <h3>
							<c:out value="${task.projectTask.name}"/>
						  </h3>
						</a>
					  </li>
					  <!-- end task item -->
					</ul>
				  </li>
			  </c:forEach>
              <li class="footer">
                <a href="<c:url value="/tasks"/>">View all tasks</a>
              </li>
            </ul>
          </li>
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="<c:url value="/resources/dist/img/avatar5.png"/>" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs"><c:out value="${user.firstname}"/> <c:out value="${user.lastname}"/></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="<c:url value="/resources/dist/img/avatar5.png"/>" class="img-circle" alt="User Image">

              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="<c:url value="/team"/>">Equipe</a>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="<c:url value="/employee/details"/>" class="btn btn-default btn-flat">Profil</a>
                </div>
                <div class="pull-right">
                  <a href="<c:url value="/logout"/>" onclick="document.getElementById("logoutForm").submit()" class="btn btn-default btn-flat">D&#233;connexion</a>
				  
				  	<form action="<c:url value="/logout"/>" method="post" id="logoutForm" class="hide">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				  
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>