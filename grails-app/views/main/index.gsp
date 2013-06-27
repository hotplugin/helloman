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


            <div class="nav" role="navigation">
              <sec:ifAllGranted roles="ROLE_ADMIN">
                <ul>
                  <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                  <li><g:link controller="user">    Users</g:link></li>
                  <li><g:link controller="student">    Students</g:link></li>
                  <li><g:link controller="studentClass">    Student Classes</g:link></li>
                  <li><g:link controller="assignment">    Assignments</g:link></li>
                  <g:link controller="logout" action="index">Logout</g:link>
                </ul>
              </sec:ifAllGranted>
              <sec:ifAllGranted roles="ROLE_STUDENT">
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link controller="assignment" action="myAssShow">Mero Assignment</g:link></li>
                <g:link controller="logout" action="index">Logout</g:link>
              </sec:ifAllGranted>
            </div>
<!--            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>-->

            <div class="span4">
              <h2>Helloman test</h2>
            </div>

        </section>
      </div>
    </div>
  </body>
</html>
