package com.example.taskevent.task;
/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public abstract class Task implements ITask {
	
	private ITaskStete[] mStetes;

	public Task(){
		
	}
	
	public Task(ITaskStete... taskStetes){
		buildState(taskStetes);
	}

	@Override
	public void buildState(ITaskStete... taskStetes) {
		mStetes = taskStetes;
	}

	@Override
	public void start() {
		startRun();
	}
	
	private void startRun(){
		if (mStetes == null && mStetes.length <= 0) return;
		
		for (int i = 0; i < mStetes.length; i++) {
			 if (!mStetes[i].run(this)) {
				return;
			}
		}
	}

}
