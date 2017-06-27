create table resume
(
  uuid char(36) not null
    constraint resume_pkey
    primary key,
  full_name text not null
)
;
create table contact
(
  id serial not null
    constraint contact_pkey
    primary key,
  resume_uuid char(36) not null,
  type text not null,
  value text not null
)
;
create table section
(
  id serial not null
    constraint section_pkey
    primary key,
  type text not null,
  resume_uuid char(36) not null,
  value text not null
)
;




