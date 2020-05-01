package ezc.dto.invoice;

import java.util.List;

public class EzInvoiceListTable {

	private List<EzInvoiceListTableRow> invListTableRow;
	
	public EzInvoiceListTable(){}

	public EzInvoiceListTable(List<EzInvoiceListTableRow> invListTableRow) {
		super();
		this.invListTableRow = invListTableRow;
	}

	public List<EzInvoiceListTableRow> getInvListTableRow() {
		return invListTableRow;
	}

	public void setInvListTableRow(List<EzInvoiceListTableRow> invListTableRow) {
		this.invListTableRow = invListTableRow;
	}
}
