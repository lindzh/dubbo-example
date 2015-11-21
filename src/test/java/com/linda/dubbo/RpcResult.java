package com.linda.dubbo;

public class RpcResult<T> {

	private int code;

	private String msg;

	private T data;

	public RpcResult(int code, String msg) {
		this(code, msg, null);
	}

	public RpcResult(int code, String msg, T t) {
		this.code = code;
		this.msg = msg;
		this.data = t;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
