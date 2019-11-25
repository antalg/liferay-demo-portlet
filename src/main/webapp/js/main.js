function getUsers(userListUrl, deleteUserUrlTemplate) {
	AUI().use('aui-io-request', function (A) {
		A.io.request(userListUrl, {
			method: 'get',
			on: {
				success: function () {
					var users = JSON.parse(this.get('responseData'));
					if (users && users.length > 0) {
						renderUserTable(users, deleteUserUrlTemplate);
					} else {
						renderNoUsersFoundInfoMessage();
					}
				}
			}
		});
	});
}

function renderUserTable(users, deleteUserUrlTemplate) {
	AUI().use('aui-datatable', function (A) {
		var columns = [
			{
				key: 'id',
				label: 'ID'
			},
			{
				key: 'username',
				label: 'Username'
			},
			{
				key: 'fullName',
				label: 'Full name'
			},
			{
			    label: 'Actions',
			    allowHTML: true,
			    formatter: function (cell) {
                    var user = cell.data;
                    var deleteUserUrl = deleteUserUrlTemplate.replace('--userId--', user.id);
                    return '<a class="btn" href="' + deleteUserUrl + '">Delete</a>';
			    }
			}
		];
		
		new A.DataTable({
			columns: columns,
			data: users
		}).render('#userTable');
	});
}

function renderNoUsersFoundInfoMessage() {
	AUI().use('node', function (A) {
		A.one('#noUsersFoundInfo').removeClass('hidden');
	});
}
