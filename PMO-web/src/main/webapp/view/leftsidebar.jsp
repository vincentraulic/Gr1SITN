  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">Navigation</li>
        <!-- Optionally, you can add icons to the links -->
        <li class="active"><a href="<c:url value="/app/user/home"/>"><i class="fa fa-link"></i> <span>Home</span></a></li>
        <li><a href="<c:url value="/app/user/mycalendar"/>"><i class="fa fa-calendar"></i> <span>Calendrier</span></a></li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>Projets</span> <i class="fa fa-angle-left pull-right"></i></a>
          <ul class="treeview-menu">
            <li><a href="<c:url value="/employees"/>">Equipe</a></li>
            <li><a href="<c:url value="/tasks"/>">Taches</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>