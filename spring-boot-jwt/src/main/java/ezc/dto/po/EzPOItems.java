package ezc.dto.po;

import java.util.List;

public class EzPOItems {
	 private String itemNo;
	   private String material;
	   private String description;
	   private String uom;
	   private String qty;
	   private String price;
	   private String value;
	   List<EzPOSchedules> poSchedules;
	   
	public EzPOItems(String itemNo,String material,String description,String uom,String qty,String price,String value)
	{
		this.itemNo = itemNo;
		this.material = material;
		this.description = description;
		this.uom = uom;
		this.qty = qty;
		this.price = price;
		this.value = value;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
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

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<EzPOSchedules> getPoSchedules() {
		return poSchedules;
	}

	public void setPoSchedules(List<EzPOSchedules> poSchedules) {
		this.poSchedules = poSchedules;
	}

	
	
}
