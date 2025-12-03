package server.models.addresses.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import server.models.RootTableSvc;
import server.models.addresses.Address;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
@RequiredArgsConstructor
public final class AddressSvc extends RootTableSvc<Address> {
  private final AddressRepo addressRepo;

  public final AddressRepo withRepo() {
    return addressRepo;
  }

  public final Mono<Address> insert(Address address) {
    return addressRepo.insert(address);
  }
}