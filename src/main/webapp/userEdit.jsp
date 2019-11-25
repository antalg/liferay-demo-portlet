<%@ include file="init.jsp" %>

<portlet:actionURL 
	name="saveUser" 
	var="saveUserUrl">
	<portlet:param
		name="mvcPath"
		value="/users.jsp" />
</portlet:actionURL>

<portlet:renderURL var="usersUrl">
	<portlet:param
		name="mvcPath"
		value="/users.jsp" />
</portlet:renderURL>

<aui:form 
	action="${saveUserUrl}"
	method="post">
	
	<aui:fieldset>
	
		<aui:input 
			name="username" 
			label="user.username"
			placeholder="user.username" 
			required="true" />
			
		<aui:input 
			name="fullName"
			label="user.fullName"
			placeholder="user.fullName"
			required="true" />
			
	</aui:fieldset>
	
	<div class="actions">
		<aui:button
			primary="true"
			type="submit"
			value="save" />
		<aui:button
			href="${usersUrl}"
			value="back" />
	</div>

</aui:form>
