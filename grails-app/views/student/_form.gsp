<%@ page import="eaccount.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="student.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${studentInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'studentClass', 'error')} required">
	<label for="studentClass">
		<g:message code="student.studentClass.label" default="Student Class" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="studentClass" name="studentClass.id" from="${eaccount.StudentClass.list()}" optionKey="id" required="" value="${studentInstance?.studentClass?.id}" class="many-to-one"/>
</div>

