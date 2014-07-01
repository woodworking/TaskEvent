package com.example.taskevent.task.http;

import org.apache.http.client.methods.HttpUriRequest;

import com.example.taskevent.task.Task;

/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public abstract class BaseHttpTask extends Task {
	
	private HttpUriRequest mHttpRequest;
	//TODO  这只是测试数据，真实的应该全部定义成json
	private String mData;

	
	public void setHttpRequest(HttpUriRequest request){
		mHttpRequest = request;
	}
	
	public HttpUriRequest getHttpRequest(){
		return mHttpRequest;
	}
	
	public void setData(String data){
		mData = data;
	}
	
	public String getData(){
		return mData;
	}

}
