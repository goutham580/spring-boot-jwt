package ezc.sap.rfc.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sap.mw.jco.JCO;

import ezc.dto.invoice.EzInvPaymentsRow;
import ezc.dto.invoice.EzInvoiceDetailsTable;
import ezc.dto.invoice.EzInvoiceHeaderRow;
import ezc.dto.invoice.EzInvoiceItemsRow;
import ezc.dto.invoice.EzInvoiceListTable;
import ezc.dto.invoice.EzInvoiceListTableRow;
import ezc.dto.po.EzInvInputDTO;
import ezc.sapconnection.EzSAPHandler;
@Component
public class EzInvoiceDAO {

	public EzInvoiceListTable getInvoiceList(EzInvInputDTO inputParams)
	{		
		    EzInvoiceListTable invListTable = new EzInvoiceListTable();
		    List<EzInvoiceListTableRow> invListTableRow = new ArrayList<EzInvoiceListTableRow>();
		    
			String invoiceFlag 	= inputParams.getFlag();
			Date fromDate 		= inputParams.getFromDate();
			Date toDate 		= inputParams.getToDate();
			String field1		 = inputParams.getField();
		
			JCO.Client client=null;
			JCO.Function myFunction = null;
	
			try
			{
				 client = EzSAPHandler.getSAPConnection("200~999");
				 myFunction = EzSAPHandler.getFunction("Z_EZ_GET_VENDOR_INVOICE_LIST","200~999");
				 
				 JCO.ParameterList sapVendInv = myFunction.getImportParameterList();
				 
				 
				 sapVendInv.setValue("", "VENDOR");
				 sapVendInv.setValue("", "COMPANYCODE");
				 sapVendInv.setValue(invoiceFlag, "INVFLAG");

				if (field1 != null) {
					sapVendInv.setValue(field1, "FIELD1");
				}

				GregorianCalendar tdate = new GregorianCalendar();
				if (!invoiceFlag.equals("O")) {
					GregorianCalendar fdate = new GregorianCalendar(1900, 01, 01);
					if (fromDate != null)
						sapVendInv.setValue(fromDate, "DATE_FROM");
					else
						sapVendInv.setValue(fdate.getTime(), "DATE_FROM");

					if (toDate != null)
						sapVendInv.setValue(toDate, "DATE_TO");
					else
						sapVendInv.setValue(tdate.getTime(), "DATE_TO");
				} else {
					if (toDate != null)
						sapVendInv.setValue(toDate, "KEYDATE");
					else
						sapVendInv.setValue(tdate.getTime(), "KEYDATE");
				}
				
				client.execute(myFunction);
				
				JCO.Table sapInvList = myFunction.getTableParameterList().getTable("LINEITEMS");
				int invCount = sapInvList.getNumRows();
				
				if (invCount > 0) {
					do {
						
						EzInvoiceListTableRow invListRow = new EzInvoiceListTableRow();
						
						invListRow.setInvNo((String)sapInvList.getValue("DOC_NO"));
						invListRow.setInvDate((Date)sapInvList.getValue("DOC_DATE"));
						invListRow.setRefDoc((String)sapInvList.getValue("REF_DOC_NO"));
						invListRow.setPoNo((String)sapInvList.getValue("REF_KEY_1"));
						invListRow.setAmount((String)sapInvList.getValue("AMOUNT"));
						invListRow.setCurrency((String)sapInvList.getValue("CURRENCY"));
						invListRow.setPaymentDate((Date)sapInvList.getValue("BLINE_DATE"));
						invListRow.setPaidAmount((String)sapInvList.getValue("LC_AMOUNT"));
						invListRow.setChqNo((String)sapInvList.getValue("ALLOC_NMBR"));
						invListRow.setBankName((String)sapInvList.getValue("BANK_KEY"));
						invListRow.setBankAddr((String)sapInvList.getValue("DRAW_CITY1"));
						invListRow.setBankCountry((String)sapInvList.getValue("BANK_CTRY"));
						invListRow.setCompCode((String)sapInvList.getValue("COMP_CODE"));
						invListRow.setDebCrIndicator((String)sapInvList.getValue("DB_CR_IND"));
						invListRow.setPostingDate((Date)sapInvList.getValue("PSTNG_DATE"));
						invListRow.setDocType((String)sapInvList.getValue("DOC_TYPE"));
						invListRow.setClrDocNo((String)sapInvList.getValue("CLR_DOC_NO"));
						invListRow.setExt1((String)sapInvList.getValue("NAME"));
						invListRow.setExt2((String)sapInvList.getValue("EXT2"));
						invListRow.setClearingDate((Date)sapInvList.getValue("CLEAR_DATE"));
						
						invListTableRow.add(invListRow);
						
					} while (sapInvList.nextRow());
				}
				
				 
				
			}catch(Exception e){
				System.out.println("Exception in gettting PO Details::::"+e);
			}
			
			invListTable.setInvListTableRow(invListTableRow);
			
			return invListTable;
	}	
	
	public EzInvoiceDetailsTable getInvoiceDetails(EzInvInputDTO inputParams)
	{	
		List<EzInvoiceHeaderRow> invHdr = new ArrayList<EzInvoiceHeaderRow>();
		List<EzInvoiceItemsRow> invItems = new ArrayList<EzInvoiceItemsRow>();
		List<EzInvPaymentsRow> invPayments = new ArrayList<EzInvPaymentsRow>();
		
		JCO.Client client=null;
		JCO.Function myFunction = null;
		
		 try
		 {
				client = EzSAPHandler.getSAPConnection("200~999");
				 myFunction = EzSAPHandler.getFunction("Z_EZ_GET_INVOICE_DTL","200~999");
				 
				JCO.ParameterList sapVendInv = myFunction.getImportParameterList();
				
				Date invDate = inputParams.getInvDate();
				
				sapVendInv.setValue(inputParams.getInvNo(), "INVOICEDOCNUMBER");
				sapVendInv.setValue(inputParams.getVendor(), "VENDOR");
				sapVendInv.setValue(inputParams.getCompCode(), "COMPANYCODE");
				
				if (invDate == null) {
					invDate = Calendar.getInstance().getTime(); // Get Current Date
				}
				sapVendInv.setValue(invDate, "INVDATE");
				
				client.execute(myFunction);
				
				JCO.ParameterList expParam = myFunction.getExportParameterList();
				JCO.Structure invHeader = (JCO.Structure) expParam.getStructure("HEADERDATA");
				JCO.Table sapInvTable = myFunction.getTableParameterList().getTable("ITEMDATA");
				JCO.Table bankDetailsTable = myFunction.getTableParameterList().getTable("BANKDETAILS");
				
				int hdrCount = sapInvTable.getNumRows();
				int invCount = sapInvTable.getNumRows();
				int payCount = bankDetailsTable.getNumRows();
				

				if (hdrCount > 0) 
				{
					do {
						EzInvoiceHeaderRow lv_invHdr = new EzInvoiceHeaderRow();
						
						lv_invHdr.setInvNo((String)invHeader.getValue("INV_DOC_NO"));
						lv_invHdr.setCurrency((String)invHeader.getValue("CURRENCY"));
						lv_invHdr.setInvDate((Date)invHeader.getValue("DOC_DATE"));
						
						invHdr.add(lv_invHdr);
						
						} while (sapInvTable.nextRow());
				}
					
				
				if (invCount > 0) 
				{										
					do {
						EzInvoiceItemsRow lv_invItems = new EzInvoiceItemsRow();

						lv_invItems.setInvNo((String)invHeader.getValue("INV_DOC_NO"));
						lv_invItems.setInvDate((Date)invHeader.getValue("DOC_DATE"));
						lv_invItems.setPoNo((String)sapInvTable.getValue("PO_NUMBER"));
						lv_invItems.setItem((String)sapInvTable.getValue("PO_ITEM"));
						lv_invItems.setPoUnit((String)sapInvTable.getValue("PO_UNIT"));
						lv_invItems.setInvQuantity((String)sapInvTable.getValue("QUANTITY"));
						lv_invItems.setMaterial((String)sapInvTable.getValue("MATERIAL"));
						lv_invItems.setDescription((String)sapInvTable.getValue("SHORT_TEXT"));
						lv_invItems.setInvAmount((String)sapInvTable.getValue("ITEM_AMOUNT"));
						lv_invItems.setInvCurrency((String)sapInvTable.getValue("CURRENCY"));
						lv_invItems.setReceiptNo((String)sapInvTable.getValue("REF_DOC"));
						lv_invItems.setRefDoc((String)sapInvTable.getValue("REF_DOC"));
						lv_invItems.setDebCreInd((String)sapInvTable.getValue("DE_CRE_IND"));
						lv_invItems.setGrNo((String)sapInvTable.getValue("MAT_DOC"));
						lv_invItems.setExt1((String)sapInvTable.getValue("EXT1"));
						lv_invItems.setExt2((String)sapInvTable.getValue("EXT2"));
						
						invItems.add(lv_invItems);
												
					} while (sapInvTable.nextRow());
				}
				
				if (payCount > 0) {
					do {
						
						EzInvPaymentsRow lv_invPayments = new EzInvPaymentsRow();
						
						lv_invPayments.setInvNo((String)bankDetailsTable.getValue("DOC_NO"));
						lv_invPayments.setCurrency((String)bankDetailsTable.getValue("T_CURRENCY"));
						lv_invPayments.setNetAmt((String)bankDetailsTable.getValue("NET_AMOUNT"));
						lv_invPayments.setPaymentDate((Date)bankDetailsTable.getValue("BLINE_DATE"));
						lv_invPayments.setChequeNo((String)bankDetailsTable.getValue("CHEQUE_NO"));
						lv_invPayments.setBankName((String)bankDetailsTable.getValue("NAME"));
						lv_invPayments.setAddress1((String)bankDetailsTable.getValue("STREET"));
						lv_invPayments.setAddress2((String)bankDetailsTable.getValue("STREET"));
						lv_invPayments.setCity((String)bankDetailsTable.getValue("CITY"));
						lv_invPayments.setCountry((String)bankDetailsTable.getValue("COUNTRY"));
						lv_invPayments.setDebCreInd((String)bankDetailsTable.getValue("DB_CR_IND"));
						lv_invPayments.setClrDocNo((String)bankDetailsTable.getValue("CLR_DOC_NO"));
						
						invPayments.add(lv_invPayments);
						
					}while (bankDetailsTable.nextRow());
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
		
		 EzInvoiceDetailsTable invDtl = new EzInvoiceDetailsTable(invHdr,invItems,invPayments);
		
		return invDtl;
	}
	
}
