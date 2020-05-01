package ezc.dto.po;

public class EzPOSchedules {
	 private String itemNo;
	   private String sNo;
	   private java.util.Date deliveryDate;
	   private String qty;
	   
	public EzPOSchedules(String itemNo,String sNo,java.util.Date deliveryDate,String qty)
	{
		this.itemNo = itemNo;
		this.sNo = sNo;
		this.deliveryDate = deliveryDate;
		this.qty = qty;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}



	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public java.util.Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}
}
