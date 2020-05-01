package ezc.dto.invoice;

import java.util.Date;

public class EzInvoiceItemsRow {

	private String invNo;
	private java.util.Date invDate;
	private String poNo;
	private String poItem;
	private String poUnit;
	private String invquantity;
	private String item;
	private String material;
	private String description;
	private String invAmount;
	private String invCurrency;
	private String receiptNo;
	private String refDoc;
	private String debCreInd;
	private String grNo;
	private String ext1;
	private String ext2;
	
	
	public EzInvoiceItemsRow(){}

	public EzInvoiceItemsRow(String invNo, Date invDate, String poNo, String poItem, String poUnit, String invquantity,
			String item, String material, String description, String invAmount, String invCurrency, String receiptNo,
			String refDoc, String debCreInd, String grNo, String ext1, String ext2) {
		super();
		this.invNo = invNo;
		this.invDate = invDate;
		this.poNo = poNo;
		this.poItem = poItem;
		this.poUnit = poUnit;
		this.invquantity = invquantity;
		this.item = item;
		this.material = material;
		this.description = description;
		this.invAmount = invAmount;
		this.invCurrency = invCurrency;
		this.receiptNo = receiptNo;
		this.refDoc = refDoc;
		this.debCreInd = debCreInd;
		this.grNo = grNo;
		this.ext1 = ext1;
		this.ext2 = ext2;
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

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getPoItem() {
		return poItem;
	}

	public void setPoItem(String poItem) {
		this.poItem = poItem;
	}

	public String getPoUnit() {
		return poUnit;
	}

	public void setPoUnit(String poUnit) {
		this.poUnit = poUnit;
	}

	public String getInvQuantity() {
		return invquantity;
	}

	public void setInvQuantity(String quantity) {
		this.invquantity = invquantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInvAmount() {
		return invAmount;
	}

	public void setInvAmount(String invAmount) {
		this.invAmount = invAmount;
	}

	public String getInvCurrency() {
		return invCurrency;
	}

	public void setInvCurrency(String invCurrency) {
		this.invCurrency = invCurrency;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getRefDoc() {
		return refDoc;
	}

	public void setRefDoc(String refDoc) {
		this.refDoc = refDoc;
	}

	public String getDebCreInd() {
		return debCreInd;
	}

	public void setDebCreInd(String debCreInd) {
		this.debCreInd = debCreInd;
	}

	public String getGrNo() {
		return grNo;
	}

	public void setGrNo(String grNo) {
		this.grNo = grNo;
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
}

