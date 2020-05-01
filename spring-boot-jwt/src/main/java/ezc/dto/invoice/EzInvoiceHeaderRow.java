package ezc.dto.invoice;

import java.util.Date;

public class EzInvoiceHeaderRow {
	private String invNo;
	private java.util.Date invDate;
	private String currency;
	
	public EzInvoiceHeaderRow(){};
	public EzInvoiceHeaderRow(String invNo, Date invDate, String currency) {
		super();
		this.invNo = invNo;
		this.invDate = invDate;
		this.currency = currency;
	}
	public String getInvNo() {
		return invNo;
	}
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	public java.util.Date getInvDate() {
		return invDate;
	}
	public void setInvDate(java.util.Date invDate) {
		this.invDate = invDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
