package com.example.taskevent.task;
/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public interface ITask {

	/**
	 * 装载Task
	 * @return 是否装载成功，用以判断任务是否可以执行
	 */
	abstract boolean build();
	
	//装载TaskState
	void buildState(ITaskStete ...taskStetes);
	
	//开始执行任务
	void start();
	
}
