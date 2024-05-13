package kh.mclass.test1r.member.model.dto;

public class MemberRes {
	private String memId;
	private String memPwd;
	private String memEmail;
	@Override
	public String toString() {
		return "MemberRes [memId=" + memId + ", memPwd=" + memPwd + ", memEmail=" + memEmail + "]";
	}
	public MemberRes() {
		super();
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
}
