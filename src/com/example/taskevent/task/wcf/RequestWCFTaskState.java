package com.example.taskevent.task.wcf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ksoap2.serialization.SoapObject;

import com.example.taskevent.task.ITask;
import com.example.taskevent.task.ITaskStete;

public class RequestWCFTaskState implements ITaskStete {

	@Override
	public boolean run(ITask task) {
		// TODO Auto-generated method stub
		if (task instanceof BaseWCFTask) {
			BaseWCFTask wcfTask = (BaseWCFTask)task;
			return prepareWCFRequest(wcfTask);
		}
		return false;
	}

	private boolean prepareWCFRequest(BaseWCFTask task) {
		try {
			List<Map<String, Object>> params = task.getParames();
			SoapObject rcp = new SoapObject(task.getSpaceName(),
					task.getMrthodName());
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map = params.get(i);
				Set<String> set = map.keySet();
				Object[] keys = set.toArray();
				String key = keys[0].toString();
				rcp.addProperty(key, map.get(key).toString());
			}
			task.setRcp(rcp);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;

	}

}
