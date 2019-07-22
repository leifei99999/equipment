package com.equipment.equipment.util;

import java.io.Serializable;

/**
 * 服务器端向客户端响应结果的类型
 * 
 * @param <E>
 *            服务器端向客户端响应的数据的类型
 */
public class ResponseResult<E> implements Serializable {

	private static final long serialVersionUID = -1626793180717240861L;

	private String  state;
	private String message;
	private E data;

	public ResponseResult() {
		super();
	}

	public ResponseResult(String state) {
		super();
		setState(state);
	}

	public ResponseResult(String state, String message) {
		this(state);
		setMessage(message);
	}
	
	public ResponseResult(String state, Exception e) {
		this(state, e.getMessage());
	}

	public ResponseResult(String state, E data) {
		this(state);
		setData(data);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

}
