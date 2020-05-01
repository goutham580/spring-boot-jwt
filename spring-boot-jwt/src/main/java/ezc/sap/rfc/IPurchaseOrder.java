package ezc.sap.rfc;

import org.springframework.stereotype.Component;

import ezc.dto.po.EzPODetails;
import ezc.dto.po.EzPOHeader;

@Component
public interface IPurchaseOrder {

	public EzPODetails getPODetails(EzPOHeader ezPOHeader);
}
