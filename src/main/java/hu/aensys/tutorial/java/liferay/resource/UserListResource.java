package hu.aensys.tutorial.java.liferay.resource;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import hu.aensys.tutorial.java.liferay.bean.UserManager;
import hu.aensys.tutorial.java.liferay.model.User;

public class UserListResource extends AbstractJsonResource<List<User>> {

	public UserListResource(ResourceRequest request, ResourceResponse response) {
		super(request, response);
	}
	
	@Override
	protected List<User> getResult() {
		return UserManager.getInstance().getUsers();
	}

}
