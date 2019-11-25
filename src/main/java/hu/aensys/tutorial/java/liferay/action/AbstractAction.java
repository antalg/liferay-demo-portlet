package hu.aensys.tutorial.java.liferay.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class AbstractAction {

	@Getter(AccessLevel.PROTECTED)
	private ActionRequest request;
	
	@Getter(AccessLevel.PROTECTED)
	private ActionResponse response;
	
	public abstract void perform();
	
}
