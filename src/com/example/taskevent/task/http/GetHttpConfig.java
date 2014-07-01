package com.example.taskevent.task.http;

import com.example.taskevent.task.TaskManage;

/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public class GetHttpConfig extends BaseGetHttpTask {

	@Override
	public boolean build() {
		buildState(new RequestSpiceTaskState(),new NetWorkTaskState(),new ParseDefaultState());
		return true;
	}
	
	public static void startTask(){
		GetHttpConfig t = new GetHttpConfig();
		TaskManage.getInstance().addTask(t);
	}

}
