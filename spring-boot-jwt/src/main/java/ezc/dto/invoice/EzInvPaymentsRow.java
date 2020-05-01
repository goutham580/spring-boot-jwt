package ezc.dto.invoice;

import java.util.Date;

public class EzInvPaymentsRow {

	private String invNo;
	private String currency;
	private String netAmt;
	private java.util.Date paymentDate;
	private String chequeNo;
	private String bankName;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private String debCreInd;
	private String clrDocNo;
	
	public EzInvPaymentsRow(){}
	
	public EzInvPaymentsRow(String invNo, String currency, String netAmt, Date paymentDate, String chequeNo,
			String bankName, String address1, String address2, String city, String country, String debCreInd,
			String clrDocNo) {
		super();
		this.invNo = invNo;
		this.currency = currency;
		this.netAmt = netAmt;
		this.paymentDate = paymentDate;
		this.chequeNo = chequeNo;
		this.bankName = bankName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.debCreInd = debCreInd;
		this.clrDocNo = clrDocNo;
	}
	
	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getNetAmt() {
		return netAmt;
	}

	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
	}

	public java.util.Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(java.util.Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDebCreInd() {
		return debCreInd;
	}

	public void setDebCreInd(String debCreInd) {
		this.debCreInd = debCreInd;
	}

	public String getClrDocNo() {
		return clrDocNo;
	}

	public void setClrDocNo(String clrDocNo) {
		this.clrDocNo = clrDocNo;
	}	
}
