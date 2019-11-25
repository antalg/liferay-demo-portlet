package hu.aensys.tutorial.java.liferay.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import hu.aensys.tutorial.java.liferay.bean.UserManager;

public class SaveUserAction extends AbstractAction {

	public SaveUserAction(ActionRequest request, ActionResponse response) {
		super(request, response);
	}
	
	@Override
	public void perform() {
		String username = getRequest().getParameter("username");
		String fullName = getRequest().getParameter("fullName");
		
		UserManager.getInstance().add(username, fullName);
	}

}
