package server.models;

import java.util.UUID;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

@NoRepositoryBean
public interface RootTableRepo<T> extends ReactiveCrudRepository<T, UUID> {

  public abstract Mono<T> insert(T arg);
}