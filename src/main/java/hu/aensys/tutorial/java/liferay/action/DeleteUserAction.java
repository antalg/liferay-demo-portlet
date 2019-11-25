package hu.aensys.tutorial.java.liferay.action;

import hu.aensys.tutorial.java.liferay.bean.UserManager;
import lombok.extern.java.Log;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Log
public class DeleteUserAction extends AbstractAction {

    public DeleteUserAction(ActionRequest request, ActionResponse response) {
        super(request, response);
    }

    @Override
    public void perform() {
        log.info("Deleting user ...");
        Long id = Long.parseLong(getRequest().getParameter("id"));

        UserManager.getInstance().delete(id);
    }

}
