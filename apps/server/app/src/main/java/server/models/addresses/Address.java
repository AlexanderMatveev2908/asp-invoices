package server.models.addresses;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import server.models.RootTable;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table("addresses")
public final class Address extends RootTable {

  @Column("street")
  private String street;

  @Column("city")
  private String city;

  @Column("post_code")
  private String postCode;

  @Column("country")
  private String country;

  @Override
  public final String toString() {
    return reflectiveToString();
  }
}
