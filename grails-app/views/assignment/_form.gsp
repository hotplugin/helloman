<%@ page import="eaccount.Assignment" %>



<div class="fieldcontain ${hasErrors(bean: assignmentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="assignment.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${assignmentInstance?.name}"/>
</div>

