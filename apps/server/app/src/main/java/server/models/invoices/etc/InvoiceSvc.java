package server.models.invoices.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import server.models.RootTableSvc;
import server.models.invoices.Invoice;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
public final class InvoiceSvc extends RootTableSvc<Invoice, InvoiceRepo> {
  protected final InvoiceRepo invoiceRepo;

  public InvoiceSvc(InvoiceRepo invoiceRepo) {
    super(invoiceRepo);
    this.invoiceRepo = invoiceRepo;
  }
}