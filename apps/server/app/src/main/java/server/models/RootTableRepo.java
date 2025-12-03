package server.models;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;
import server.decorators.core.ErrAPI;

@Repository
public interface RootTableRepo<T> extends ReactiveCrudRepository<T, UUID> {

  default Mono<T> insert(T entity) {
    return Mono.error(new ErrAPI("insert method must be implemented", 400));
  }
}