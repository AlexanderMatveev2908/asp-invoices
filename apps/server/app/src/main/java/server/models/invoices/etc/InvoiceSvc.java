package server.models.invoices.etc;

import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import server.decorators.core.ErrAPI;
import server.models.invoices.Invoice;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
@RequiredArgsConstructor
public final class InvoiceSvc {
  private final InvoiceRepo invoiceRepo;

  public final Mono<Invoice> insert(Invoice Invoice) {
    return invoiceRepo.insert(Invoice);
  }

  public final Mono<Invoice> byId(UUID id) {
    return invoiceRepo.findById(id);
  }

  public final Mono<Invoice> throwNotFound(UUID id) {
    return byId(id).switchIfEmpty(Mono.error(new ErrAPI("Invoice not found", 404)));
  }

}