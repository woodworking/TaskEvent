package com.example.taskevent.task.wcf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ksoap2.serialization.SoapObject;

import com.example.taskevent.task.Task;

public abstract class BaseWCFTask extends Task {

	private SoapObject rcp;
	private String result;
	private List<Map<String, Object>> parames = new ArrayList<Map<String, Object>>();
	private String MrthodName;
	private String SpaceName;
	private String SoapAction;

	public SoapObject getRcp() {
		return rcp;
	}

	public void setRcp(SoapObject rcp) {
		this.rcp = rcp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Map<String, Object>> getParames() {
		return parames;
	}

	public void setParames(List<Map<String, Object>> parames) {
		this.parames = parames;
	}

	public String getMrthodName() {
		return MrthodName;
	}

	public void setMrthodName(String mrthodName) {
		MrthodName = mrthodName;
	}

	public String getSpaceName() {
		return SpaceName;
	}

	public void setSpaceName(String spaceName) {
		SpaceName = spaceName;
	}

	public String getSoapAction() {
		return SoapAction;
	}

	public void setSoapAction(String soapAction) {
		SoapAction = soapAction;
	}
	

}
