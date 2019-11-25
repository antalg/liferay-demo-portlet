package hu.aensys.tutorial.java.liferay.resource;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
public abstract class AbstractJsonResource<ResultType> {
	
	@Getter(AccessLevel.PROTECTED)
	private final ResourceRequest request;
	
	@Getter(AccessLevel.PROTECTED)
	private final ResourceResponse response;
	
	public void serve() {
		ResultType result = getResult();
		writeJsonResponse(result);
	}
	
	protected abstract ResultType getResult();
	
	protected void writeJsonResponse(ResultType result) {
		response.setContentType("application/json");
		
		try (PrintWriter writer = response.getWriter()) {
			String jsonResponse = JSONFactoryUtil.looseSerializeDeep(result);
			
			writer.write(jsonResponse);
			writer.flush();
		} catch (IOException e) {
			log.severe("Cannot write to response body.");
		}
	}

}
