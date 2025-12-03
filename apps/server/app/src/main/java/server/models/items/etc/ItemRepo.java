package server.models.items.etc;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;
import server.models.items.Item;

@Repository
public interface ItemRepo extends ReactiveCrudRepository<Item, UUID> {
  @Query("""
      INSERT INTO items (invoice_id, name, qty, price)
      VALUES (:#{#item.invoiceId}, :#{#invoice.name}, :#{#invoice.qty}, :#{#invoice.price})
      RETURNING *
      """)
  public Mono<Item> insert(Item item);
}