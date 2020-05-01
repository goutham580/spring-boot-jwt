package ezc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ezc.dto.po.EzPODetails;
import ezc.dto.po.EzPOHeader;
import ezc.model.EzcPoAcknowledgement;
import ezc.sap.rfc.impl.EzPurchaseOrder;
import ezc.service.IPOService;

@RestController
@CrossOrigin
@RequestMapping("api/po")
public class PurchaseOrderController {

	@Autowired
	IPOService poService;
	
	@GetMapping({ "/list" })
	public List<EzcPoAcknowledgement> listDist() {
		return poService.findAll();
	}
	
	@GetMapping(value = "/poDetails/{poNo}") 
    public EzPODetails getPODetails(@PathVariable(value="poNo") String poNo) {
    	
    	 
    	EzPOHeader ezPOHeader = new EzPOHeader();
    	ezPOHeader.setPoNumber(poNo);
    	ezPOHeader.setSoldTo("S-1300");
    	ezPOHeader.setPurGroup("990");
    	ezPOHeader.setPurOrg("1710");
    	EzPODetails poDTLObject = poService.getPODetails(ezPOHeader);
    	
        return poDTLObject; 
    }

}