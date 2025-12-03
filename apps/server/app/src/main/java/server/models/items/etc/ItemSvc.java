package server.models.items.etc;

import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import server.decorators.core.ErrAPI;
import server.models.items.Item;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
@RequiredArgsConstructor
public final class ItemSvc {
  private final ItemRepo itemRepo;

  public final Mono<Item> insert(Item Item) {
    return itemRepo.insert(Item);
  }

  public final Mono<Item> byId(UUID id) {
    return itemRepo.findById(id);
  }

  public final Mono<Item> throwNotFound(UUID id) {
    return byId(id).switchIfEmpty(Mono.error(new ErrAPI("Item not found", 404)));
  }
}