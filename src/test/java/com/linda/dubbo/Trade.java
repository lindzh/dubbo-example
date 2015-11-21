package com.linda.dubbo;

import java.io.Serializable;

public class Trade implements Serializable{

	private static final long serialVersionUID = -9047401462014932019L;
	
	private long id;
	private String tid;
	private String pid;
	private long time;
	private String mobileType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getMobileType() {
		return mobileType;
	}

	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}

}
