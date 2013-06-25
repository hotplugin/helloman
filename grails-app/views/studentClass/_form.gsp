<%@ page import="eaccount.StudentClass" %>



<div class="fieldcontain ${hasErrors(bean: studentClassInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="studentClass.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${studentClassInstance?.name}"/>
</div>

