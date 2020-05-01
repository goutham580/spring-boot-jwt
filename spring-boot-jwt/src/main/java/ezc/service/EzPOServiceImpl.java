package ezc.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezc.dao.PurchaseOrderRepo;
import ezc.dto.po.EzPODetails;
import ezc.dto.po.EzPOHeader;
import ezc.model.EzcPoAcknowledgement;
import ezc.sap.rfc.IPurchaseOrder;
@Service
@Transactional
public class EzPOServiceImpl implements IPOService {

	@Autowired
	PurchaseOrderRepo purchaseOrderRepo;
	@Autowired
	IPurchaseOrder iPurchaseOrder;

	@Override
	public List<EzcPoAcknowledgement> findAll() {
		List<EzcPoAcknowledgement> distList = new ArrayList<EzcPoAcknowledgement>();
		distList.addAll(purchaseOrderRepo.findAll());
		return distList;
	}

	@Override
	public EzPODetails getPODetails(EzPOHeader ezPOHeader) {
		return iPurchaseOrder.getPODetails(ezPOHeader);
	}

}
