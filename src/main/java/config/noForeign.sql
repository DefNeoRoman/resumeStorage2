DROP TABLE IF EXISTS resume;
CREATE TABLE resume
(
  id SERIAL PRIMARY KEY  NOT NULL,
  uuid CHAR(36) NOT NULL,
  full_name TEXT NOT NULL
);
ALTER TABLE resume ADD UNIQUE (uuid);
DROP TABLE IF EXISTS contact;
CREATE TABLE contact
(
  id SERIAL PRIMARY KEY  NOT NULL,
  resume_uuid CHAR(36) NOT NULL,
  type TEXT NOT NULL,
  value TEXT NOT NULL
);
CREATE UNIQUE INDEX contact_uuid_type_index ON contact (resume_uuid, type);
DROP TABLE IF EXISTS section;
CREATE TABLE section
(
  id SERIAL PRIMARY KEY NOT NULL,
  type TEXT NOT NULL,
  resume_uuid CHAR(36) NOT NULL,
  value TEXT NOT NULL

);
CREATE UNIQUE INDEX section_type_uuid_index ON section (type, resume_uuid);