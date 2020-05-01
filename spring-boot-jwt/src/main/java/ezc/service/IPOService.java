package ezc.service;

import java.util.List;

import ezc.dto.po.EzPODetails;
import ezc.dto.po.EzPOHeader;
import ezc.model.EzcPoAcknowledgement;

public interface IPOService {

	
	List<EzcPoAcknowledgement> findAll();
	public EzPODetails getPODetails(EzPOHeader ezPOHeader);

}
