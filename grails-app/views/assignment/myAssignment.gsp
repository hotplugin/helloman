
<%@ page import="eaccount.Assignment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'assignment.label', default: 'Assignment')}" />
		<title>Mero Assignment</title>
	</head>
	<body>
		<a href="#show-assignment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="show-assignment" class="content scaffold-show" role="main">
			<h1>Mero Assignment</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list assignment">

				<g:if test="${assignmentInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="assignment.name.label" default="Name" /></span>

						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${assignmentInstance}" field="name"/></span>

				</li>
				</g:if>


				<g:if test="${assignmentInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="assignment.created.label" default="Created" /></span>

						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${assignmentInstance?.created}" /></span>

				</li>
				</g:if>

				<g:if test="${assignmentInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="assignment.active.label" default="Active" /></span>

						<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${assignmentInstance?.active}" /></span>

				</li>
				</g:if>

			</ol>
		</div>
	</body>
</html>
