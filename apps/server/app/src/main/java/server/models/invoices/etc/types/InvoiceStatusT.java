package server.models.invoices.etc.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum InvoiceStatusT {
  DRAFT("DRAFT"),
  PENDING("PENDING"),
  PAID("PAID");

  private final String val;
}