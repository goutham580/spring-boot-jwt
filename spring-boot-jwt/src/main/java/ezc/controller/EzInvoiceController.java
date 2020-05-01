package ezc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ezc.dto.invoice.EzInvoiceDetailsTable;
import ezc.dto.invoice.EzInvoiceListTable;
import ezc.dto.po.EzInvInputDTO;
import ezc.sap.rfc.impl.EzInvoiceDAO;


@RestController
@CrossOrigin
@RequestMapping("/invoice")
public class EzInvoiceController {

	 @Autowired
	 private EzInvoiceDAO invoiceDAO;
	
	 @RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<EzInvoiceListTable> getInvList(
			 	@PathVariable(value = "vendor") String vendor, 
			 	@PathVariable(value = "invFlag") String invFlag,
			 	@PathVariable(value = "fromDate") String fromDate,
	 			@PathVariable(value = "toDate") String toDate)
	 {
	    	System.out.println(":LIST CALL FROM :::::::ANDROID APP::::");
	    	
	    	EzInvInputDTO  invDto = new EzInvInputDTO(); 
	    	invDto.setVendor(vendor);
	    	invDto.setFlag(invFlag);
	    	invDto.setFromDate(new Date());
	    	invDto.setToDate(new Date());
	    	
	    	EzInvoiceListTable invList =  invoiceDAO.getInvoiceList(invDto);
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(invList);
	    }
	 
	 @RequestMapping(value = "/details", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<EzInvoiceDetailsTable> getInvDetails(
			 	@PathVariable(value = "vendor") String vendor, 
			 	@PathVariable(value = "invNo") String invNo,
			 	@PathVariable(value = "compCode") String compCode,
	 			@PathVariable(value = "invDate") String invDate)
	 {
	    	System.out.println(":LIST CALL FROM :::::::ANDROID APP::::");
	    	
	    	EzInvInputDTO  invDto = new EzInvInputDTO(); 
	    	invDto.setVendor(vendor);
	    	invDto.setInvNo(invNo);
	    	invDto.setCompCode(compCode);
	    	invDto.setInvDate(new Date());
	    	
	    	EzInvoiceDetailsTable invDetails =  invoiceDAO.getInvoiceDetails(invDto);
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(invDetails);
	    }
}
