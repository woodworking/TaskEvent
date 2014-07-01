package com.example.taskevent.task.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import android.util.Log;

import com.example.taskevent.task.ITask;
import com.example.taskevent.task.ITaskStete;

/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public class RequestSpiceTaskState implements ITaskStete {

	@Override
	public boolean run(ITask task) {
		if (task instanceof BaseGetHttpTask) {
			BaseGetHttpTask getHttpTask = (BaseGetHttpTask)task;
			 return prepareGetHttpRequest(getHttpTask);
		}
		if (task instanceof BasePostHttpTask) {
			BasePostHttpTask postHttpTask = (BasePostHttpTask)task;
			return preparePostHttpRequest(postHttpTask);
		}
		return false;
	}
	
	private boolean prepareGetHttpRequest(BaseGetHttpTask task){
		
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		task.setHttpRequest(httpGet);
		
		Log.e("guang", "RequestSpiceTaskState");
		return true;
	}
	
	private boolean preparePostHttpRequest(BasePostHttpTask task){
		
		HttpPost httpGet = new HttpPost("http://www.baidu.com");
		task.setHttpRequest(httpGet);
		
		return true;
	}

}
