package com.example.taskevent.task.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.example.taskevent.task.ITask;
import com.example.taskevent.task.ITaskStete;

/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public class NetWorkTaskState implements ITaskStete {

	@Override
	public boolean run(ITask task) {
		if (task instanceof BaseHttpTask) {
			BaseHttpTask httpTask = (BaseHttpTask)task;
			return send(httpTask);
		}
		return false;
	}
	
	private boolean send(BaseHttpTask t){
		
		try {
			HttpUriRequest request = t.getHttpRequest();
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(request);
			Log.e("guang", "NetWorkTaskState");
			return responseHandle(response, t);
		} catch (Exception e) {

			Log.e("guang", "NetWorkTaskState" + e);
		}
		
		return false;
	}
	
	private boolean responseHandle(HttpResponse response,BaseHttpTask t){
		//TODO  解析数据，这里是测试。真实数据应该解析成json
		try {
			String data = EntityUtils.toString(response.getEntity(),"utf-8");
			t.setData(data);
		} catch (Exception e) {
			return false;
		}

		
		return true;
	}

}
