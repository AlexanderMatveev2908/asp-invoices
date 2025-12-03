package server.models.invoices;

import java.util.UUID;

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
@Table("invoices")
public final class Invoice extends RootTable {

  @Column("sender_address_id")
  private UUID senderAddressId;

  @Column("client_address_id")
  private UUID clientAddressId;

  @Column("description")
  private String description;

  @Column("payment_term")
  private int paymentTerm;

  @Column("client_name")
  private String clientName;

  @Column("client_email")
  private String clientEmail;

  @Override
  public final String toString() {
    return reflectiveToString();
  }

}
