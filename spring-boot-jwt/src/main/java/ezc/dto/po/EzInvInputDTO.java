package ezc.dto.po;

public class EzInvInputDTO {
	private String vendor;
	private String invNo;
	private String compCode;
	private java.util.Date invDate;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private String flag;
	private String field;

	public EzInvInputDTO(){}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public java.util.Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	public java.util.Date getToDate() {
		return toDate;
	}

	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public java.util.Date getInvDate() {
		return invDate;
	}

	public void setInvDate(java.util.Date invDate) {
		this.invDate = invDate;
	}
	
}

