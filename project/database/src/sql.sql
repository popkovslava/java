CREATE SCHEMA IF NOT EXISTS business_contact;

DROP TABLE IF EXISTS business_contact.menu CASCADE ;
DROP TABLE IF EXISTS business_contact.pages CASCADE;
DROP TABLE IF EXISTS business_contact.post_category CASCADE;
DROP TABLE IF EXISTS business_contact.posts CASCADE;
DROP TABLE IF EXISTS business_contact.trademark CASCADE;
DROP TABLE IF EXISTS business_contact.license CASCADE;
DROP TABLE IF EXISTS business_contact.users CASCADE;
DROP TABLE IF EXISTS business_contact.user_role CASCADE;
DROP TABLE IF EXISTS business_contact.role CASCADE;
DROP TABLE IF EXISTS business_contact.user_license CASCADE;
DROP TABLE IF EXISTS business_contact.user_trademark CASCADE;
DROP TABLE IF EXISTS business_contact.lang CASCADE;
DROP TABLE IF EXISTS business_contact.lnag_page CASCADE;

CREATE TABLE business_contact.menu(
   id BIGSERIAL PRIMARY KEY ,
   title VARCHAR(100)
);

CREATE TABLE business_contact.lang(
   id BIGSERIAL PRIMARY KEY ,
   ln_title varchar(50),
   ln varchar(50)
);

CREATE TABLE business_contact.pages(
   id BIGSERIAL PRIMARY KEY,
   title VARCHAR(100),
   description TEXT,
   menu_id BIGINT REFERENCES business_contact.menu(id)
);

CREATE TABLE business_contact.post_category(
   id BIGSERIAL PRIMARY KEY,
   title VARCHAR(100),
   text TEXT,
   page_id BIGINT REFERENCES business_contact.pages(id)
);

CREATE TABLE business_contact.posts(
   id BIGSERIAL PRIMARY KEY,
   title CHARACTER VARYING(128),
   text TEXT,
   post_category_id BIGINT REFERENCES business_contact.post_category(id)
);

CREATE TABLE business_contact.users(
   id BIGSERIAL PRIMARY KEY,
   name VARCHAR(100),
   address VARCHAR(50)
);

CREATE TABLE business_contact.role(
   id BIGSERIAL PRIMARY KEY,
   role VARCHAR(100)
);

CREATE TABLE business_contact.user_role (
   id BIGSERIAL PRIMARY KEY,
   user_id BIGINT REFERENCES business_contact.users(id),
   role_id BIGINT  REFERENCES business_contact.role(id),
   UNIQUE (user_id, role_id)
);

CREATE TABLE business_contact.trademark(
    id BIGSERIAL PRIMARY KEY,
    title varchar(100),
    article varchar(100),
    description TEXT
);

CREATE TABLE business_contact.user_trademark (
   id BIGSERIAL PRIMARY KEY,
   user_id BIGINT REFERENCES business_contact.users(id),
   trademark_id BIGINT REFERENCES business_contact.trademark(id),
   UNIQUE (user_id, trademark_id)
);

CREATE TABLE business_contact.license(
   id BIGSERIAL PRIMARY KEY,
   title varchar(100),
   article varchar(100),
   description TEXT
);

CREATE TABLE business_contact.user_license (
   id BIGSERIAL PRIMARY KEY,
   user_id BIGINT REFERENCES business_contact.users(id),
   license_id BIGINT REFERENCES business_contact.license(id),
   UNIQUE (user_id, license_id)
);

CREATE TABLE business_contact.lnag_page (
   id BIGSERIAL PRIMARY KEY,
   lang_id BIGINT REFERENCES business_contact.lang(id),
   page_id BIGINT REFERENCES business_contact.pages(id),
   UNIQUE (lang_id, page_id)
);























