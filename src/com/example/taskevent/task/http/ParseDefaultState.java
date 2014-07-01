package com.example.taskevent.task.http;

import android.util.Log;

import com.example.taskevent.task.ITask;
import com.example.taskevent.task.ITaskStete;

/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public class ParseDefaultState implements ITaskStete {

	@Override
	public boolean run(ITask task) {
		// TODO 获取返回数据并解析
		if (task instanceof BaseHttpTask) {
			BaseHttpTask httpTask = (BaseHttpTask)task;
			parseResult(httpTask.getData());
		}
		return false;
	}
	
	private boolean parseResult(String data){
		//解析数据
		Log.e("guang", "ParseDefaultState");
		Log.e("guang", data);
		return true;
	}

}
