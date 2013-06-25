<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
    <title>:: Helloman ::</title>
  </head>
  <body>
    <div id="page-body" role="main">
      <div class="row-fluid">
        <section id="main" class="span9">


          <div class="row-fluid">

            <div class="span4">
              <h2>Navigate</h2>
              <ul class="nav nav-list">
                <li><g:link controller="user">    Users</g:link></li>
                  <li><g:link controller="student">    Students</g:link></li>
               <li><g:link controller="studentClass">    Student Classes</g:link></li>
                <g:link controller="logout" action="index">Logout</g:link>
              </ul>
            </div>
<!--            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>-->

            <div class="span4">
              <h2>About Us</h2>
              <p>A recently established food court located in one of the most popular shopping mall in 							   Kathmandu, Star Mall.</p>
              <p>The food court is expected to have at least 8 Food stalls with the maximum catering capacity of 							100 customers at once.</p>
              <p>Each Stall and the Cash Counter will have a RFID Card Reader, a dot-matrix Bill Printer and a POS application.</p>
            </div>

            <div class="span4">
              <h2>Location</h2>
              <p>Starr Mall, Kathmandu</p>
            </div>

          </div>

        </section>
      </div>
    </div>
  </body>
</html>
