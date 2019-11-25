<%@ page import="hu.aensys.tutorial.java.liferay.resource.ResourceIds"%>
<%@ include file="init.jsp" %>

<portlet:renderURL var="newUserUrl">
	<portlet:param
		name="mvcPath"
		value="/userEdit.jsp" />
</portlet:renderURL>

<portlet:resourceURL
	var="userListUrl"
	id="<%= ResourceIds.USER_LIST %>" />

<portlet:actionURL
	name="deleteUser"
	var="deleteUserUrlTemplate">
    <portlet:param
        name="id"
        value="--userId--" />
</portlet:actionURL>
	
<aui:script>
	AUI().ready(function () {
		getUsers('${userListUrl}', '${deleteUserUrlTemplate}');
	});
</aui:script>

<div class="user-list">
	<div class="actions">
		<aui:button
			href="${newUserUrl}"
			value="user.new" />
	</div>
	
	<div id="userTable"></div>
	
	<div id="noUsersFoundInfo" class="alert alert-info hidden">
		<liferay-ui:message key="message.no.users.found" />
	</div>
</div>

