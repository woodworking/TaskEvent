package com.example.taskevent.task.wcf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.taskevent.task.TaskManage;

public class GetUserInfo extends BaseWCFTask {

	private String MRTHODNAME = "GetUserBasic";
	private String NAMESPACE = "http://tempuri.org/";
	private String SOAPACTION = "http://tempuri.org/ISysService/GetUserBasic";

	@Override
	public boolean build() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("strUserName", "wjd");
		params.add(map);
		setParames(params);
		setMrthodName(MRTHODNAME);
		setSpaceName(NAMESPACE);
		setSoapAction(SOAPACTION);
		buildState(new RequestWCFTaskState(), new NetWorkWCFTaskState(),
				new ParseDefaultWCFTaskState());

		return true;
	}

	public static void startTask() {
		GetUserInfo userInfo = new GetUserInfo();
		TaskManage.getInstance().addTask(userInfo);
	}

}
