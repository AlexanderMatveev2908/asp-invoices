package server.models.items;

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
@Table("items")
public final class Item extends RootTable {

  @Column("invoice_id")
  private UUID invoiceId;

  @Column("name")
  private String name;

  @Column("qty")
  private int qty;

  @Column("price")
  private float price;

  @Override
  public final String toString() {
    return reflectiveToString();
  }
}
