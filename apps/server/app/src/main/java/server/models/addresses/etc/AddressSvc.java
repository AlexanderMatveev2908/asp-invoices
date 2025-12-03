package server.models.addresses.etc;

import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import server.decorators.core.ErrAPI;
import server.models.addresses.Address;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
@RequiredArgsConstructor
public final class AddressSvc {
  private final AddressRepo addressRepo;

  public final Mono<Address> insert(Address address) {
    return addressRepo.insert(address);
  }

  public final Mono<Address> byId(UUID id) {
    return addressRepo.findById(id);
  }

  public final Mono<Address> throwNotFound(UUID id) {
    return addressRepo.findById(id).switchIfEmpty(Mono.error(new ErrAPI("image not found", 404)));
  }
}
