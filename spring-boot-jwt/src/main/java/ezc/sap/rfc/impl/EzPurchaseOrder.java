package ezc.sap.rfc.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sap.mw.jco.JCO;

import ezc.dto.po.EzPODetails;
import ezc.dto.po.EzPOHeader;
import ezc.dto.po.EzPOItems;
import ezc.dto.po.EzPOSchedules;
import ezc.model.EzcPoAcknowledgement;
import ezc.sap.rfc.IPurchaseOrder;
import ezc.sapconnection.EzSAPHandler;


@Component
public class EzPurchaseOrder implements IPurchaseOrder{

	@Override
	public EzPODetails getPODetails(EzPOHeader ezPOHeader){
		
		EzPOHeader poHeader = new EzPOHeader();
		List<EzPOItems> poItems = new ArrayList<EzPOItems>();
		List<EzPOSchedules> poSchedules = new ArrayList<EzPOSchedules>();
		
		JCO.Client client=null;
		JCO.Function myFunction = null;
		
		 try
		 {
				client = EzSAPHandler.getSAPConnection("200~999");
				 myFunction = EzSAPHandler.getFunction("Z_EZ_GET_PURCHASE_ORDER_DTL","200~999");
				 
				JCO.ParameterList sapPurOrd = myFunction.getImportParameterList();
	
				sapPurOrd.setValue(ezPOHeader.getPoNumber(),"PURCHASEORDER");
				sapPurOrd.setValue("X","ITEMS");
				sapPurOrd.setValue("X","SCHEDULES");
				sapPurOrd.setValue(ezPOHeader.getSoldTo(),"VENDOR");
				sapPurOrd.setValue("","CO_CODE");
				sapPurOrd.setValue(ezPOHeader.getPurOrg(),"PURCH_ORG");
				sapPurOrd.setValue(ezPOHeader.getPurGroup(),"PUR_GROUP");
				
				client.execute(myFunction);
				
				JCO.ParameterList expParam = myFunction.getExportParameterList();

				JCO.Structure headerData =(JCO.Structure)expParam.getStructure("PO_HEADER");
				JCO.Table retOutItem  = myFunction.getTableParameterList().getTable("PO_ITEMS");
				
				int retOutItemCount = 0;
				if(retOutItem!=null)
					retOutItemCount = retOutItem.getNumRows();
					
				JCO.Table retItemSchd  = myFunction.getTableParameterList().getTable("PO_ITEM_SCHEDULES");
				
				int retItemSchdCount = 0;
				if(retItemSchd!=null)
					retItemSchdCount = retItemSchd.getNumRows();
				
		

				poHeader = new EzPOHeader((String)headerData.getValue("PO_NUMBER"),(Date)headerData.getValue("CREATED_ON"),(String)headerData.getValue("DOC_TYPE"),(String)headerData.getValue("PURCH_ORG"),(String)headerData.getValue("PUR_GROUP"),(String)headerData.getValue("CO_CODE"),"20000",(String)headerData.getValue("CURRENCY"),"");
		
		if(retOutItemCount>0)
		{
			do
			{
				poItems.add(new EzPOItems((String)retOutItem.getValue("PO_ITEM"),(String)retOutItem.getValue("MATERIAL"),(String)retOutItem.getValue("SHORT_TEXT"),(String)retOutItem.getValue("UNIT"),(String)retOutItem.getValue("QUANTITY"),(String)retOutItem.getValue("NET_PRICE"),(String)retOutItem.getValue("NET_VALUE")));
			}
			while(retOutItem.nextRow());
		}	
		
		if(retItemSchdCount>0)
		{
			do
			{
				poSchedules.add(new EzPOSchedules((String)retItemSchd.getValue("PO_ITEM"),(String)retItemSchd.getValue("SERIAL_NO"),(Date)retItemSchd.getValue("DELIV_DATE"),(String)retItemSchd.getValue("QUANTITY")));
			}
			while(retItemSchd.nextRow());
		}	
		
		 }catch(Exception e){
				System.out.println("Exception in gettting PO Details::::"+e);
			}
			finally
			{
				   if (client!=null)
				   {
					JCO.releaseClient(client);
					client = null;
					myFunction=null;

				    }
			}
		 
		for(EzPOItems poItem:poItems)
		{
			String poItemNo = poItem.getItemNo(); 
			List<EzPOSchedules> poSchedList = poSchedules.stream()
	                .filter(poSchedule -> poSchedule.getItemNo().equals(poItemNo))
	                .collect(Collectors.toList());
			poItem.setPoSchedules(poSchedList);
		}
		EzPODetails poDtl = new EzPODetails(poHeader,poItems);
		
		return poDtl;
	}

}


