package ezc.dto.po;
import java.util.ArrayList;
import java.util.List;

public class EzPODetails {
	
	private EzPOHeader poHeader;
	private List<EzPOItems> poItems;
	
	public EzPODetails(EzPOHeader poHeader, List<EzPOItems> poItems){
		this.poHeader = poHeader;
		this.poItems = poItems;
	}
    
    public EzPOHeader getPOHeader() {
        return poHeader;
    }
  
    public void setPOHeader(EzPOHeader poHeader) {
        this.poHeader = poHeader;
    }
    
    public List<EzPOItems> getPOItems() {
        if(poItems == null) {
        	poItems = new ArrayList<>();
        }
        return poItems;
    }
  
    public void setPOItems(List<EzPOItems> poItems) {
        this.poItems = poItems;
    }
    
}
