package ezc.dto.po;

public class EzPOHeader {
   private String poNumber;
   private java.util.Date poDate;
   private String poType;
   private String compCode;
   private String purGroup;
   private String purOrg;
   private String netAmt;
   private String currency;
   private String soldTo;
   
   public EzPOHeader(String poNumber,
		   java.util.Date poDate,
				    String poType,
				    String compCode,
				    String purGroup,
				    String purOrg,
				    String netAmt,
				    String currency,String soldTo)
   {
	   this.poNumber 	= poNumber;
	   this.poDate 		= poDate;
	   this.poType 		= poType;
	   this.compCode 	= compCode;
	   this.purGroup 	= purGroup;
	   this.purOrg 		= purOrg;
	   this.netAmt 		= netAmt;
	   this.currency 	= currency;
	   this.soldTo 	    = soldTo;
   }
   
   public EzPOHeader() {
	
}

public String getPoNumber() {
	return poNumber;
}
public void setPoNumber(String poNumber) {
	this.poNumber = poNumber;
}
public java.util.Date getPoDate() {
	return poDate;
}
public void setPoDate(java.util.Date poDate) {
	this.poDate = poDate;
}
public String getPoType() {
	return poType;
}
public void setPoType(String poType) {
	this.poType = poType;
}
public String getCompCode() {
	return compCode;
}
public void setCompCode(String compCode) {
	this.compCode = compCode;
}
public String getPurGroup() {
	return purGroup;
}
public void setPurGroup(String purGroup) {
	this.purGroup = purGroup;
}
public String getPurOrg() {
	return purOrg;
}
public void setPurOrg(String purOrg) {
	this.purOrg = purOrg;
}
public String getNetAmt() {
	return netAmt;
}
public void setNetAmt(String netAmt) {
	this.netAmt = netAmt;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}

public String getSoldTo() {
	return soldTo;
}

public void setSoldTo(String soldTo) {
	this.soldTo = soldTo;
} 
}
