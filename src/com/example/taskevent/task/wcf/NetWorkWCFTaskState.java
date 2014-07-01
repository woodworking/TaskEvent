package com.example.taskevent.task.wcf;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.example.taskevent.task.ITask;
import com.example.taskevent.task.ITaskStete;
import com.example.taskevent.tools.ConstantWCFClass;

public class NetWorkWCFTaskState implements ITaskStete {

	private static final int TIMEOUT = 15 * 1000;// 连接超时 15s

	@Override
	public boolean run(ITask task) {

		if (task instanceof BaseWCFTask) {
			BaseWCFTask wcfTask = (BaseWCFTask) task;
			return sendWCF(wcfTask);
		}

		return false;
	}

	private boolean sendWCF(BaseWCFTask task) {

		// 设置SoapObject对象
		String url = "http://183.129.204.238:9003/Services/SysService.svc";
		SoapObject soapObject = task.getRcp();
		HttpTransportSE ht = new HttpTransportSE(url, TIMEOUT);

		// 是否测试模式
		ht.debug = true;
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// 发送请求
		envelope.bodyOut = soapObject;
		envelope.dotNet = true;
		envelope.setOutputSoapObject(soapObject);
		try {
			ht.call(ConstantWCFClass.SOAPACTION_USER, envelope);
			SoapObject result = (SoapObject) envelope.bodyIn;
			return responseHandler(result, task);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 处理响应数据
	 * 
	 * @param resultObj
	 * @param task
	 * @return
	 */
	private boolean responseHandler(SoapObject resultObj, BaseWCFTask task) {
		try {
			String result = resultObj.getProperty(0).toString();
			task.setResult(result);
		} catch (Exception e) {

			return false;
		}

		return true;
	}

}
