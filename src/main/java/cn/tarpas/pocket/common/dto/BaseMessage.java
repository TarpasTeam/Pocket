package cn.tarpas.pocket.common.dto;

public class BaseMessage {
	protected String code;
	protected String Message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setMsg(String message) {
		Message = message;
	}
	
	
}
