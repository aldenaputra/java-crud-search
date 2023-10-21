
public class Member{
	
	private String mname;
	private Integer idm;
	
	public Member(String mname, Integer idm) {
		this.mname = mname;
		this.idm = idm;
	}

	public String getMname() {
		return mname;
	}

	public Integer getIdm() {
		return idm;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setIdm(Integer idm) {
		this.idm = idm;
	}
	
}
