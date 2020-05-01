package ezc.dto.invoice;

import java.util.Date;

public class EzInvoiceListTableRow {

	private String invNo;
	private java.util.Date invDate;
	private String refDoc;
	private String poNo;
	private String amount;
	private String currency;
	private java.util.Date paymentDate;
	private String paidAmount;
	private String chqNo;
	private String bankName;
	private String bankAddr;
	private String bankCountry;
	private String compCode;
	private String debCrIndicator;
	private java.util.Date postingDate;
	private String docType;
	private String grNo;
	private String clrDocNo;
	private String ext1;
	private String ext2;
	private java.util.Date clearingDate;
	
	public EzInvoiceListTableRow(){}
	
	public EzInvoiceListTableRow(String invNo, Date invDate, String refDoc, String poNo, String amount, String currency,
			Date paymentDate, String paidAmount, String chqNo, String bankName, String bankAddr, String bankCountry,
			String compCode, String debCrIndicator, Date postingDate, String docType, String grNo, String clrDocNo,
			String ext1, String ext2, Date clearingDate) {
		super();
		this.invNo = invNo;
		this.invDate = invDate;
		this.refDoc = refDoc;
		this.poNo = poNo;
		this.amount = amount;
		this.currency = currency;
		this.paymentDate = paymentDate;
		this.paidAmount = paidAmount;
		this.chqNo = chqNo;
		this.bankName = bankName;
		this.bankAddr = bankAddr;
		this.bankCountry = bankCountry;
		this.compCode = compCode;
		this.debCrIndicator = debCrIndicator;
		this.postingDate = postingDate;
		this.docType = docType;
		this.grNo = grNo;
		this.clrDocNo = clrDocNo;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.clearingDate = clearingDate;
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
	public String getRefDoc() {
		return refDoc;
	}
	public void setRefDoc(String refDoc) {
		this.refDoc = refDoc;
	}
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public java.util.Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(java.util.Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getChqNo() {
		return chqNo;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAddr() {
		return bankAddr;
	}
	public void setBankAddr(String bankAddr) {
		this.bankAddr = bankAddr;
	}
	public String getBankCountry() {
		return bankCountry;
	}
	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getDebCrIndicator() {
		return debCrIndicator;
	}
	public void setDebCrIndicator(String debCrIndicator) {
		this.debCrIndicator = debCrIndicator;
	}
	public java.util.Date getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(java.util.Date postingDate) {
		this.postingDate = postingDate;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getGrNo() {
		return grNo;
	}
	public void setGrNo(String grNo) {
		this.grNo = grNo;
	}
	public String getClrDocNo() {
		return clrDocNo;
	}
	public void setClrDocNo(String clrDocNo) {
		this.clrDocNo = clrDocNo;
	}
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public java.util.Date getClearingDate() {
		return clearingDate;
	}
	public void setClearingDate(java.util.Date clearingDate) {
		this.clearingDate = clearingDate;
	}
	
}
