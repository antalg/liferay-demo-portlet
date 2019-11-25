package hu.aensys.tutorial.java.liferay;

import java.io.IOException;

import javax.portlet.*;

import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.aensys.tutorial.java.liferay.action.DeleteUserAction;
import hu.aensys.tutorial.java.liferay.action.SaveUserAction;
import hu.aensys.tutorial.java.liferay.resource.ResourceIds;
import hu.aensys.tutorial.java.liferay.resource.UserListResource;

public class UserDemoPortlet extends MVCPortlet {
	
	public void saveUser(ActionRequest request, ActionResponse response) {
		new SaveUserAction(request, response).perform();
	}

	public void deleteUser(ActionRequest request, ActionResponse response) {
		new DeleteUserAction(request, response).perform();
	}
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {
		
		String resourceId = request.getResourceID();
		
		switch (resourceId) {
			case ResourceIds.USER_LIST:
				new UserListResource(request, response).serve();
				break;
		}
		
		super.serveResource(request, response);
	}

}
