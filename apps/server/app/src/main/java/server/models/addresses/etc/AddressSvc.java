package server.models.addresses.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import server.models.RootTableSvc;
import server.models.addresses.Address;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
public final class AddressSvc extends RootTableSvc<Address, AddressRepo> {
  protected final AddressRepo addressRepo;

  public AddressSvc(AddressRepo addressRepo) {
    super(addressRepo);
    this.addressRepo = addressRepo;
  }
}