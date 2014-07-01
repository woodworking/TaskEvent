package com.example.taskevent.task;
/*
 *
 *Created by Guang on 2014年6月30日
 *
 */
public interface ITaskStete {

	/**
	 * 
	 * @param task
	 * @return 该任务是否完成
	 */
	boolean run(ITask task);
}
