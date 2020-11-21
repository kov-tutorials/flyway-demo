# Configuration file

flyway.conf stores the default configuration for the migration library. Environment variables should be used to overwrite any values that should be different by environment or that are sensitive, as this file will be commited unencrypted

If you want flyway to own the schema (create and destroy it as necessary), add the schema name to the key:
flyway.schemas=

## Current Configuration

*The following properties are set*:

     - Connect Retries (times flyway will attempt to connect to the db) - **60**
    - Schema - **flyway_demo_db**
    - Baseline Version (where a fresh db will start) - **190903.1512**
    - Baseline on Migrate (flyway will run baseline when operating on existing db without flyway) - **true**
    - Out of Order (flyway will ensure that all scripts are run, regardless of order) - **true**
    - Ignore Missing Migrations (flyway wont error if it doesn't see a migration that it has marked as run) - **true**
