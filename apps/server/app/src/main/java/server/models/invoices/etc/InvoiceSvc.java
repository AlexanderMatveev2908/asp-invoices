package server.models.invoices.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import server.models.RootTableSvc;
import server.models.invoices.Invoice;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
@RequiredArgsConstructor
public final class InvoiceSvc extends RootTableSvc<Invoice> {
  private final InvoiceRepo invoiceRepo;

  public final InvoiceRepo withRepo() {
    return invoiceRepo;
  }

}