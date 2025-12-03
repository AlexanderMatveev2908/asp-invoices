CREATE TABLE IF NOT EXISTS items (
  invoice_id UUID NOT NULL REFERENCES invoices(id) ON DELETE CASCADE,
  name TEXT NOT NULL,
  qty INTEGER NOT NULL,
  price FLOAT NOT NULL,
  total FLOAT NOT NULL
) INHERITS (root_table);

ALTER TABLE items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);

CREATE INDEX idx__invoices__item ON items(invoice_id);

CREATE TRIGGER trigger_timestamp_items
BEFORE INSERT OR UPDATE ON items
FOR EACH ROW
EXECUTE FUNCTION trigger_timestamp();