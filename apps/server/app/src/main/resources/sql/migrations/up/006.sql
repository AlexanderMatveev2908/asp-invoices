DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'status_type') THEN
        CREATE TYPE status_type AS ENUM (
            'DRAFT',
            'PENDING',
            'PAID'
          );
    END IF;
END$$;

CREATE TABLE IF NOT EXISTS invoices (
  sender_address_id UUID NOT NULL REFERENCES addresses(id) ON DELETE CASCADE,
  client_address_id UUID NOT NULL REFERENCES addresses(id) ON DELETE CASCADE,
  description TEXT NOT NULL,
  payment_term INTEGER NOT NULL,
  client_name TEXT NOT NULL,
  client_email TEXT NOT NULL,
  status status_type NOT NULL DEFAULT 'DRAFT'
) INHERITS (root_table);

ALTER TABLE invoices
    ADD CONSTRAINT invoices_pkey PRIMARY KEY (id);

CREATE INDEX idx__sender__invoice ON invoices(sender_address_id);
CREATE INDEX idx__client__invoice ON invoices(client_address_id);

CREATE TRIGGER trigger_timestamp_invoices
BEFORE INSERT OR UPDATE ON invoices
FOR EACH ROW
EXECUTE FUNCTION trigger_timestamp();