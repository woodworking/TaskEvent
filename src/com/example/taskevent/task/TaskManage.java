package com.example.taskevent.task;

import java.util.concurrent.LinkedBlockingQueue;

import android.util.Log;

/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public class TaskManage {
	private static final String LOG_TAG = "TaskManage";
	
	private  static TaskManage mInstance;
	private LinkedBlockingQueue<ITask> mTasks = new LinkedBlockingQueue<ITask>();
	
	private TaskManage() {
		init();
	}

	private void init(){
		new Thread(new TaskWorker(), "Task thread").start();
	}
	
	public static TaskManage getInstance(){
		if (mInstance == null) {
			mInstance = new TaskManage();
		}
		return mInstance;
	}
	
	public void addTask(ITask t){
		try {
			mTasks.put(t);
		} catch (InterruptedException e) {
			Log.e(LOG_TAG, "addTask : " +e);
		}
	}
	
	private class TaskWorker implements Runnable{

		@Override
		public void run() {
			while (true) {
				ITask t = null;
				try {
					t = mTasks.take();
					
				} catch (Exception e) {
					Log.e(LOG_TAG, "TaskWorker :" + e);
				}
				
				if (t != null) {
					if (t.build()) {
						t.start();
					}
				}
			}
		}
		
		
	}
	
}
