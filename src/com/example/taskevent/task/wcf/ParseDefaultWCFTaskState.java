package com.example.taskevent.task.wcf;

import android.util.Log;

import com.example.taskevent.task.ITask;
import com.example.taskevent.task.ITaskStete;

public class ParseDefaultWCFTaskState implements ITaskStete{

	@Override
	public boolean run(ITask task) {
		// TODO Auto-generated method stub
		if (task instanceof BaseWCFTask) {
			BaseWCFTask wcfTask = (BaseWCFTask)task;
			return parseResult(wcfTask);
		}
		
		return false;
	}
	
	private boolean parseResult(BaseWCFTask task){
		try {
			String result = task.getResult();
			Log.e("guang", result);
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

}
