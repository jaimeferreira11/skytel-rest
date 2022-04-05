-- PostgreSQL
create table user (

	id serial primary key,
	name character varying,
	last_name character varying,
	email character varying,
	phone_number character varying,
);


CREATE CACHED TABLE "PUBLIC"."USER"(
    "ID" 
    "NAME" CHARACTER VARYING,
    "LAST_NAME" CHARACTER VARYING,
    "EMAIL" CHARACTER VARYING,
    "PHONE_NUMBER" CHARACTER VARYING
)