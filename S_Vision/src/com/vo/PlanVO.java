package com.vo;

import java.util.List;
import java.util.Map;

public class PlanVO {
	private String mem_id    =  "";
	private String p_date 	 =  "";
	private List<Map<String, Object>> r_result = null;
	private List<Map<String, Object>> r_result1 = null;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public List<Map<String, Object>> getR_result() {
		return r_result;
	}
	public void setR_result(List<Map<String, Object>> r_result) {
		this.r_result = r_result;
	}
	public List<Map<String, Object>> getR_result1() {
		return r_result;
	}
	public void setR_result1(List<Map<String, Object>> r_result) {
		this.r_result = r_result;
	}
}
