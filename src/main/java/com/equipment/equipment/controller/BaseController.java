package com.equipment.equipment.controller;

import javax.servlet.http.HttpSession;

import com.equipment.equipment.service.exception.InsertException;
import com.equipment.equipment.service.exception.ServiceException;
import com.equipment.equipment.service.exception.UpdateException;
import com.equipment.equipment.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 当前项目中所有控制器类的基类
 */
public abstract class BaseController {
	
	/**
	 * 正确响应时的代号
	 */
	public static final String SUCCESS = "0";
	public static final String FAIL ="1";

	@ExceptionHandler({ServiceException.class})
	@ResponseBody
	public ResponseResult<Void> handleException(
			Exception e) {
		String state = null;
		
		if (e instanceof InsertException) {
			// 1-插入数据异常
			state = "1";
		}else if(e instanceof UpdateException){
			// 1-修改数据异常
			state = "1";
		}
		
		return new ResponseResult<>(state, e);
	}
}




