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

CREATE TABLE IF NOT EXISTS addresses (
  streets TEXT NOT NULL,
  city TEXT NOT NULL,
  post_code TEXT NOT NULL,
  country TEXT NOT NULL
) INHERITS (root_table);

ALTER TABLE addresses
    ADD CONSTRAINT addresses_pkey PRIMARY KEY (id);

CREATE TRIGGER trigger_timestamp_addresses
BEFORE INSERT OR UPDATE ON addresses
FOR EACH ROW
EXECUTE FUNCTION trigger_timestamp();