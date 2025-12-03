package server.models.invoices.etc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;
import server.models.RootTableRepo;
import server.models.invoices.Invoice;

@Repository
public interface InvoiceRepo extends RootTableRepo<Invoice> {
  @Query("""
      INSERT INTO invoices (sender_address_id, client_address_id, description, payment_term, client_name, client_email, status)
      VALUES (:#{#invoice.sender_address_id}, :#{#invoice.client_address_id}, :#{#invoice.description}, :#{#invoice.payment_term}, :#{#invoice.client_name}, :#{#invoice.client_email}, CAST(:#{#invoice.status} AS status_type))
      RETURNING *
      """)
  public Mono<Invoice> insert(Invoice invoice);
}