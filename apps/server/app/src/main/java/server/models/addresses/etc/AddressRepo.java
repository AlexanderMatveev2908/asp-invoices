package server.models.addresses.etc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;
import server.models.RootTableRepo;
import server.models.addresses.Address;

@Repository
public interface AddressRepo extends RootTableRepo<Address> {

  @Query("""
      INSERT INTO addresses (street, city, post_code, country)
      VALUES (:#{#address.street}, :#{#address.city}, :#{#address.postCode}, :#{#address.country})
      RETURNING *
      """)
  public Mono<Address> insert(Address address);
}