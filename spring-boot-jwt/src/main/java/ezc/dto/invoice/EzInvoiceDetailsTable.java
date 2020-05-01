package ezc.dto.invoice;

import java.util.List;

public class EzInvoiceDetailsTable {

	private List<EzInvoiceHeaderRow> invHeaderRow;
	private List<EzInvoiceItemsRow> invItemsRow;
	private List<EzInvPaymentsRow> invPaymentsRow;
	
	public EzInvoiceDetailsTable(){}

	public EzInvoiceDetailsTable(List<EzInvoiceHeaderRow> invHeaderRow, List<EzInvoiceItemsRow> invItemsRow,
			List<EzInvPaymentsRow> invPaymentsRow) {
		super();
		this.invHeaderRow = invHeaderRow;
		this.invItemsRow = invItemsRow;
		this.invPaymentsRow = invPaymentsRow;
	}

	public List<EzInvoiceHeaderRow> getInvHeaderRow() {
		return invHeaderRow;
	}

	public void setInvHeaderRow(List<EzInvoiceHeaderRow> invHeaderRow) {
		this.invHeaderRow = invHeaderRow;
	}

	public List<EzInvoiceItemsRow> getInvItemsRow() {
		return invItemsRow;
	}

	public void setInvItemsRow(List<EzInvoiceItemsRow> invItemsRow) {
		this.invItemsRow = invItemsRow;
	}

	public List<EzInvPaymentsRow> getInvPaymentsRow() {
		return invPaymentsRow;
	}

	public void setInvPaymentsRow(List<EzInvPaymentsRow> invPaymentsRow) {
		this.invPaymentsRow = invPaymentsRow;
	}
	
	
}
