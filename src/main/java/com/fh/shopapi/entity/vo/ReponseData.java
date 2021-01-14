package com.fh.shopapi.entity.vo;
//自定义的规范     ajax的请求  返回的都是json数据

//  {"status":,"info":,"data":}
public class 	ReponseData {
	private Integer status;
	
	private String info;
	
	private Object data;
	
	private ReponseData() {
		
	}
	
	
	public static ReponseData success(Object data) {
		ReponseData rs=new ReponseData();
		rs.setInfo("处理成功");
		rs.setStatus(200);
		rs.setData(data);
		return  rs;
	}
	
	public static ReponseData error(String info,Integer status) {
		ReponseData rs=new ReponseData();
		rs.setInfo(info);
		rs.setStatus(status);
		return  rs;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
