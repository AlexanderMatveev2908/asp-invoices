package server.models;

import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import server.decorators.core.ErrAPI;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
@RequiredArgsConstructor
public abstract class RootTableSvc<T> {
  public abstract RootTableRepo<T> withRepo();

  public final Mono<T> insert(T arg) {
    return withRepo().insert(arg);
  }

  public final Mono<T> byId(UUID id) {
    return withRepo().findById(id);
  }

  public final Mono<T> throwNotFound(UUID id, String nameNotFound) {
    return byId(id).switchIfEmpty(Mono.error(new ErrAPI(nameNotFound + "not found", 404)));
  }
}
