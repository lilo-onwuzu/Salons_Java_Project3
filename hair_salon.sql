--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE clients (
    name character varying,
    client_id integer NOT NULL
);


ALTER TABLE clients OWNER TO "Guest";

--
-- Name: clients_client_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE clients_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_client_id_seq OWNER TO "Guest";

--
-- Name: clients_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE clients_client_id_seq OWNED BY clients.client_id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE stylists (
    name character varying,
    stylist_id integer NOT NULL
);


ALTER TABLE stylists OWNER TO "Guest";

--
-- Name: stylists_stylist_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE stylists_stylist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_stylist_id_seq OWNER TO "Guest";

--
-- Name: stylists_stylist_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE stylists_stylist_id_seq OWNED BY stylists.stylist_id;


--
-- Name: client_id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY clients ALTER COLUMN client_id SET DEFAULT nextval('clients_client_id_seq'::regclass);


--
-- Name: stylist_id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY stylists ALTER COLUMN stylist_id SET DEFAULT nextval('stylists_stylist_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY clients (name, client_id) FROM stdin;
\.


--
-- Name: clients_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('clients_client_id_seq', 1, false);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY stylists (name, stylist_id) FROM stdin;
\.


--
-- Name: stylists_stylist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('stylists_stylist_id_seq', 1, false);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (client_id);


--
-- Name: stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (stylist_id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

