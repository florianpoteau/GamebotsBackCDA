--
-- PostgreSQL database cluster dump
--

-- Started on 2024-08-14 15:08:31

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- User Configurations
--

--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.1

-- Started on 2024-08-14 15:08:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2024-08-14 15:08:31

--
-- PostgreSQL database dump complete
--

--
-- Database "db" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.1

-- Started on 2024-08-14 15:08:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3414 (class 1262 OID 16384)
-- Name: db; Type: DATABASE; Schema: -; Owner: dbuser
--


ALTER DATABASE db OWNER TO dbuser;

\connect db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16386)
-- Name: conversations; Type: TABLE; Schema: public; Owner: dbuser
--

CREATE TABLE IF NOT EXISTS public.conversations (
    id_conversation integer NOT NULL,
    creation_date date,
    modification_date date,
    name character varying(50),
    id_game integer,
    id_user integer
);


ALTER TABLE public.conversations OWNER TO dbuser;

--
-- TOC entry 215 (class 1259 OID 16385)
-- Name: conversations_id_conversation_seq; Type: SEQUENCE; Schema: public; Owner: dbuser
--

CREATE SEQUENCE public.conversations_id_conversation_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.conversations_id_conversation_seq OWNER TO dbuser;

--
-- TOC entry 3415 (class 0 OID 0)
-- Dependencies: 215
-- Name: conversations_id_conversation_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dbuser
--

ALTER SEQUENCE public.conversations_id_conversation_seq OWNED BY public.conversations.id_conversation;


--
-- TOC entry 218 (class 1259 OID 16393)
-- Name: games; Type: TABLE; Schema: public; Owner: dbuser
--

CREATE TABLE IF NOT EXISTS public.games (
    id_game integer NOT NULL,
    creation_date date,
    is_new boolean,
    is_online boolean,
    modification_date date,
    number_players integer,
    platform character varying(50),
    release_date date,
    story character varying(500),
    studio character varying(50),
    title character varying(50)
);


ALTER TABLE public.games OWNER TO dbuser;

--
-- TOC entry 217 (class 1259 OID 16392)
-- Name: games_id_game_seq; Type: SEQUENCE; Schema: public; Owner: dbuser
--

CREATE SEQUENCE public.games_id_game_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.games_id_game_seq OWNER TO dbuser;

--
-- TOC entry 3416 (class 0 OID 0)
-- Dependencies: 217
-- Name: games_id_game_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dbuser
--

ALTER SEQUENCE public.games_id_game_seq OWNED BY public.games.id_game;


--
-- TOC entry 220 (class 1259 OID 16402)
-- Name: images; Type: TABLE; Schema: public; Owner: dbuser
--

CREATE TABLE IF NOT EXISTS public.images (
    id_image integer NOT NULL,
    creation_date date,
    modification_date date,
    name character varying(50),
    source character varying(800),
    id_game integer,
    id_type_image integer
);


ALTER TABLE public.images OWNER TO dbuser;

--
-- TOC entry 219 (class 1259 OID 16401)
-- Name: images_id_image_seq; Type: SEQUENCE; Schema: public; Owner: dbuser
--

CREATE SEQUENCE public.images_id_image_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.images_id_image_seq OWNER TO dbuser;

--
-- TOC entry 3417 (class 0 OID 0)
-- Dependencies: 219
-- Name: images_id_image_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dbuser
--

ALTER SEQUENCE public.images_id_image_seq OWNED BY public.images.id_image;


--
-- TOC entry 222 (class 1259 OID 16411)
-- Name: messages; Type: TABLE; Schema: public; Owner: dbuser
--

CREATE TABLE IF NOT EXISTS public.messages (
    id_message integer NOT NULL,
    content character varying(255),
    content_bot character varying(100000),
    creation_date date,
    modification_date date,
    id_conversation integer
);


ALTER TABLE public.messages OWNER TO dbuser;

--
-- TOC entry 221 (class 1259 OID 16410)
-- Name: messages_id_message_seq; Type: SEQUENCE; Schema: public; Owner: dbuser
--

CREATE SEQUENCE public.messages_id_message_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.messages_id_message_seq OWNER TO dbuser;

--
-- TOC entry 3418 (class 0 OID 0)
-- Dependencies: 221
-- Name: messages_id_message_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dbuser
--

ALTER SEQUENCE public.messages_id_message_seq OWNED BY public.messages.id_message;


--
-- TOC entry 224 (class 1259 OID 16420)
-- Name: type_images; Type: TABLE; Schema: public; Owner: dbuser
--

CREATE TABLE IF NOT EXISTS public.type_images (
    id_type_image integer NOT NULL,
    creation_date date,
    modification_date date,
    name character varying(50)
);


ALTER TABLE public.type_images OWNER TO dbuser;

--
-- TOC entry 223 (class 1259 OID 16419)
-- Name: type_images_id_type_image_seq; Type: SEQUENCE; Schema: public; Owner: dbuser
--

CREATE SEQUENCE public.type_images_id_type_image_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.type_images_id_type_image_seq OWNER TO dbuser;

--
-- TOC entry 3419 (class 0 OID 0)
-- Dependencies: 223
-- Name: type_images_id_type_image_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dbuser
--

ALTER SEQUENCE public.type_images_id_type_image_seq OWNED BY public.type_images.id_type_image;


--
-- TOC entry 226 (class 1259 OID 16427)
-- Name: users; Type: TABLE; Schema: public; Owner: dbuser
--

CREATE TABLE IF NOT EXISTS public.users (
    id_user integer NOT NULL,
    creation_date timestamp(6) without time zone,
    email character varying(50),
    modification_date timestamp(6) without time zone,
    password character varying(64),
    phone character varying(50),
    username character varying(50),
    id_image integer
);


ALTER TABLE public.users OWNER TO dbuser;

--
-- TOC entry 225 (class 1259 OID 16426)
-- Name: users_id_user_seq; Type: SEQUENCE; Schema: public; Owner: dbuser
--

CREATE SEQUENCE public.users_id_user_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_user_seq OWNER TO dbuser;

--
-- TOC entry 3420 (class 0 OID 0)
-- Dependencies: 225
-- Name: users_id_user_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: dbuser
--

ALTER SEQUENCE public.users_id_user_seq OWNED BY public.users.id_user;


--
-- TOC entry 3228 (class 2604 OID 16389)
-- Name: conversations id_conversation; Type: DEFAULT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.conversations ALTER COLUMN id_conversation SET DEFAULT nextval('public.conversations_id_conversation_seq'::regclass);


--
-- TOC entry 3229 (class 2604 OID 16396)
-- Name: games id_game; Type: DEFAULT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.games ALTER COLUMN id_game SET DEFAULT nextval('public.games_id_game_seq'::regclass);


--
-- TOC entry 3230 (class 2604 OID 16405)
-- Name: images id_image; Type: DEFAULT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.images ALTER COLUMN id_image SET DEFAULT nextval('public.images_id_image_seq'::regclass);


--
-- TOC entry 3231 (class 2604 OID 16414)
-- Name: messages id_message; Type: DEFAULT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.messages ALTER COLUMN id_message SET DEFAULT nextval('public.messages_id_message_seq'::regclass);


--
-- TOC entry 3232 (class 2604 OID 16423)
-- Name: type_images id_type_image; Type: DEFAULT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.type_images ALTER COLUMN id_type_image SET DEFAULT nextval('public.type_images_id_type_image_seq'::regclass);


--
-- TOC entry 3233 (class 2604 OID 16430)
-- Name: users id_user; Type: DEFAULT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.users ALTER COLUMN id_user SET DEFAULT nextval('public.users_id_user_seq'::regclass);


--
-- TOC entry 3398 (class 0 OID 16386)
-- Dependencies: 216
-- Data for Name: conversations; Type: TABLE DATA; Schema: public; Owner: dbuser
--

COPY public.conversations (id_conversation, creation_date, modification_date, name, id_game, id_user) FROM stdin;
\.


--
-- TOC entry 3400 (class 0 OID 16393)
-- Dependencies: 218
-- Data for Name: games; Type: TABLE DATA; Schema: public; Owner: dbuser
--

COPY public.games (id_game, creation_date, is_new, is_online, modification_date, number_players, platform, release_date, story, studio, title) FROM stdin;
\.


--
-- TOC entry 3402 (class 0 OID 16402)
-- Dependencies: 220
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: dbuser
--

COPY public.images (id_image, creation_date, modification_date, name, source, id_game, id_type_image) FROM stdin;
\.


--
-- TOC entry 3404 (class 0 OID 16411)
-- Dependencies: 222
-- Data for Name: messages; Type: TABLE DATA; Schema: public; Owner: dbuser
--

COPY public.messages (id_message, content, content_bot, creation_date, modification_date, id_conversation) FROM stdin;
\.


--
-- TOC entry 3406 (class 0 OID 16420)
-- Dependencies: 224
-- Data for Name: type_images; Type: TABLE DATA; Schema: public; Owner: dbuser
--

COPY public.type_images (id_type_image, creation_date, modification_date, name) FROM stdin;
\.


--
-- TOC entry 3408 (class 0 OID 16427)
-- Dependencies: 226
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: dbuser
--

COPY public.users (id_user, creation_date, email, modification_date, password, phone, username, id_image) FROM stdin;
\.


--
-- TOC entry 3421 (class 0 OID 0)
-- Dependencies: 215
-- Name: conversations_id_conversation_seq; Type: SEQUENCE SET; Schema: public; Owner: dbuser
--

SELECT pg_catalog.setval('public.conversations_id_conversation_seq', 1, false);


--
-- TOC entry 3422 (class 0 OID 0)
-- Dependencies: 217
-- Name: games_id_game_seq; Type: SEQUENCE SET; Schema: public; Owner: dbuser
--

SELECT pg_catalog.setval('public.games_id_game_seq', 1, false);


--
-- TOC entry 3423 (class 0 OID 0)
-- Dependencies: 219
-- Name: images_id_image_seq; Type: SEQUENCE SET; Schema: public; Owner: dbuser
--

SELECT pg_catalog.setval('public.images_id_image_seq', 1, false);


--
-- TOC entry 3424 (class 0 OID 0)
-- Dependencies: 221
-- Name: messages_id_message_seq; Type: SEQUENCE SET; Schema: public; Owner: dbuser
--

SELECT pg_catalog.setval('public.messages_id_message_seq', 1, false);


--
-- TOC entry 3425 (class 0 OID 0)
-- Dependencies: 223
-- Name: type_images_id_type_image_seq; Type: SEQUENCE SET; Schema: public; Owner: dbuser
--

SELECT pg_catalog.setval('public.type_images_id_type_image_seq', 1, false);


--
-- TOC entry 3426 (class 0 OID 0)
-- Dependencies: 225
-- Name: users_id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: dbuser
--

SELECT pg_catalog.setval('public.users_id_user_seq', 1, false);


--
-- TOC entry 3235 (class 2606 OID 16391)
-- Name: conversations conversations_pkey; Type: CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.conversations
    ADD CONSTRAINT conversations_pkey PRIMARY KEY (id_conversation);


--
-- TOC entry 3237 (class 2606 OID 16400)
-- Name: games games_pkey; Type: CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.games
    ADD CONSTRAINT games_pkey PRIMARY KEY (id_game);


--
-- TOC entry 3239 (class 2606 OID 16409)
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT images_pkey PRIMARY KEY (id_image);


--
-- TOC entry 3241 (class 2606 OID 16418)
-- Name: messages messages_pkey; Type: CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (id_message);


--
-- TOC entry 3243 (class 2606 OID 16425)
-- Name: type_images type_images_pkey; Type: CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.type_images
    ADD CONSTRAINT type_images_pkey PRIMARY KEY (id_type_image);


--
-- TOC entry 3245 (class 2606 OID 16434)
-- Name: users uk_r43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- TOC entry 3247 (class 2606 OID 16432)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_user);


--
-- TOC entry 3252 (class 2606 OID 16455)
-- Name: messages fk15pncav1yft13vh4ir6qt6o4y; Type: FK CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fk15pncav1yft13vh4ir6qt6o4y FOREIGN KEY (id_conversation) REFERENCES public.conversations(id_conversation);


--
-- TOC entry 3248 (class 2606 OID 16440)
-- Name: conversations fkaixb36uon2lj0bq0obwak2xwa; Type: FK CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.conversations
    ADD CONSTRAINT fkaixb36uon2lj0bq0obwak2xwa FOREIGN KEY (id_user) REFERENCES public.users(id_user);


--
-- TOC entry 3250 (class 2606 OID 16445)
-- Name: images fkd8pyk8n3nvmfmbhn8yu4nw0gy; Type: FK CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT fkd8pyk8n3nvmfmbhn8yu4nw0gy FOREIGN KEY (id_game) REFERENCES public.games(id_game);


--
-- TOC entry 3249 (class 2606 OID 16435)
-- Name: conversations fkiev8wh8jyomh7e6iiw8kqlqae; Type: FK CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.conversations
    ADD CONSTRAINT fkiev8wh8jyomh7e6iiw8kqlqae FOREIGN KEY (id_game) REFERENCES public.games(id_game);


--
-- TOC entry 3253 (class 2606 OID 16460)
-- Name: users fknicdje4ts4gbdukgwtxsesxf0; Type: FK CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fknicdje4ts4gbdukgwtxsesxf0 FOREIGN KEY (id_image) REFERENCES public.images(id_image);


--
-- TOC entry 3251 (class 2606 OID 16450)
-- Name: images fkoss85kgcwf88w7fj32ymbog6t; Type: FK CONSTRAINT; Schema: public; Owner: dbuser
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT fkoss85kgcwf88w7fj32ymbog6t FOREIGN KEY (id_type_image) REFERENCES public.type_images(id_type_image);

	INSERT INTO public.type_images(
	id_type_image, creation_date, name)
	VALUES (1, '2024-06-07', 'avatar');

INSERT INTO public.type_images(
	id_type_image, creation_date, name)
	VALUES (2, '2024-06-07', 'image_jeu');

INSERT INTO public.type_images(
	id_type_image, creation_date, name)
	VALUES (3, '2024-06-07', 'banner');

INSERT INTO public.images(
	id_image, creation_date, name, source, id_type_image)
	VALUES (1, '2024-06-07', 'Pathfinder', 'https://imgs.search.brave.com/cykUN_8f9H684VeZKf4QFr2agv-Mq8MHP8bKkUPeV34/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9jZG4u/bW9zLmNtcy5mdXR1/cmVjZG4ubmV0L3NU/eFhuQnh6bmdRc212/Y3FlSGtUdUstMzIw/LTgwLmpwZw', 1);

INSERT INTO public.games(
	id_game, creation_date, is_new, is_online, number_players, platform, release_date, story, studio, title)
	VALUES (1, '2024-06-07', true, false, 1, 'Playstation 4', '2022-06-07', 'Dans une civilisation ravagée où les infectés et les survivants prolifèrent, Joel, un protagoniste désabusé, est embauché pour faire sortir Ellie, une adolescente de 14 ans, d une zone de quarantaine militaire. Ce qui commence comme un boulot se transforme vite en une aventure dangereuse à travers tout le pays.', 'The naughty Dog', 'The last of us');

INSERT INTO public.games(
	id_game, creation_date, is_new, is_online, number_players, platform, release_date, story, studio, title)
	VALUES (2, '2024-06-07', true, true, 4, 'PC', '2011-06-07', 'Minecraft est un jeu de construction et d aventure où ta créativité est la seule limite. Imaginé par Mojang Studios, il te plonge dans un univers ouvert en blocs où tu peux tout faire : construire des bâtiments, explorer des cavernes mystérieuses, combattre des créatures dangereuses et cultiver des ressources.', 'Mojang Studios', 'Minecraft');

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (2, '2024-06-07', 'The last of us', 'https://imgs.search.brave.com/2Cea8OnrsvdvLeEA3_iC5f_FR9AnPcsxszPtEr8NAiU/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9ibG9n/LmZyLnBsYXlzdGF0/aW9uLmNvbS91cGxv/YWRzL3NpdGVzLzEw/LzIwMjIvMDkvNGIw/M2E1ZjFmM2UzYTg3/MzgxMzU0NGUxZDg4/YzY2ZWQ2NzdjZWUx/Ny5qcGc', 1, 3);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (3, '2024-06-07', 'Minecraft', 'https://imgs.search.brave.com/wC-218VvjMq0UldSXLR7VDAiGJa3Z1GnByobMoBD4uc/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9hc3Nl/dHMubmludGVuZG8u/ZXUvaW1hZ2UvdXBs/b2FkL2ZfYXV0by9x/X2F1dG8vdF9wcm9k/dWN0X3RpbGVfZGVz/a3RvcC92MS9NTlMv/Tk9FLzcwMDEwMDAw/MDAwOTYzL1NRX05T/d2l0Y2hfTWluZWNy/YWZ0P19hPUFUQUs5/WlEw', 2, 3);

INSERT INTO public.games(
	id_game, creation_date, is_new, is_online, number_players, platform, release_date, story, studio, title)
	VALUES (3, '2024-06-07', true, true, 4, 'PC', '2007-06-07', 'Dans un avenir lointain, l’humanité se retrouve au bord de l’extinction. Une alliance de races extraterrestres fanatiques, connue sous le nom de Covenant, mène une guerre sans pitié contre les humains. Leur but : l’éradication totale de l’espèce humaine pour honorer leurs dieux.', 'Bungie', 'Halo 3');

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (4, '2024-06-07', 'Halo 3', 'https://imgs.search.brave.com/5wKq-rntG5MGy0BdBpGaPGDEGj0QYD7BXbdarO32LCM/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9uZXct/Z2FtZS1wbHVzLmZy/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDIw/LzA1L2hhbG8tMy1w/Yy02NzJ4NDA5Lmpw/Zw', 3, 3);

INSERT INTO public.games(
	id_game, creation_date, is_new, is_online, number_players, platform, release_date, story, studio, title)
	VALUES (4, '2024-06-07', false, false, 1, 'PC', '2020-06-07', 'Sur l île de Tsushima, en l an 1274, un calme inquiétant précède la tempête. Les samouraïs de la région se préparent à défendre leur terre contre une invasion imminente des Mongols. Jin Sakai, un jeune samouraï et neveu du Seigneur Shimura, regarde l horizon avec appréhension. Il sait que l avenir de son île repose sur leurs lames et leur honneur.', 'Sucker Punch Productions', 'Ghost of tsushima');

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (5, '2024-06-07', 'Ghost of tsushima', 'https://imgs.search.brave.com/2hfDSO24v2j9bHVMIFijyEx7VFfiMX7MRVLP5vlxkls/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMuYWN0dWdhbWlu/Zy5uZXQvbWVkaWEv/MjAyMC8xMS9naG9z/dC1vZi10c3VzaGlt/YS1jb3V2ZXJ0dXJl/LTg4OXg1MDAuanBn', 4, 3);

INSERT INTO public.games(
	id_game, creation_date, is_new, is_online, number_players, platform, release_date, story, studio, title)
	VALUES (5, '2024-06-07', false, false, 1, 'PC', '2015-06-07', 'Geralt de Riv, un sorceleur légendaire connu pour ses compétences inégalées en chasse aux monstres et ses cheveux blancs distinctifs, est en quête de sa fille adoptive, Ciri. Ciri, dotée de pouvoirs anciens et d une lignée mystérieuse, est pourchassée par la Chasse Sauvage, une armée spectrale menée par le roi Eredin, déterminée à utiliser ses pouvoirs pour leurs sombres desseins.', 'CD Projekt Red', 'the witcher 3 : Wild hunt');


INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (6, '2024-06-07', 'The witchers 3', 'https://imgs.search.brave.com/s-II_peS9RdDQoE11MaQeRiNd20W4p2pmrefQGEOkgE/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9jZG4t/dXBsb2Fkcy5nYW1l/YmxvZy5mci9pbWcv/bmV3cy80MDk5ODhf/NjM3NGM3MWEyMjdi/NC5qcGc_dmVyPTE', 5, 3);

INSERT INTO public.games(
	id_game, creation_date, is_new, is_online, number_players, platform, release_date, story, studio, title)
	VALUES (6, '2024-06-12', true, true, 4, 'PC', '2023-06-22', 'Dans le monde mystique de Eryndor, le royaume de Vesperia prospérait grâce à la magie ancienne et aux cristaux sacrés. Cependant, un jour, un mystérieux cataclysme plongea le royaume dans le chaos, éteignant la lumière des cristaux et semant la désolation.', 'Square Enix', 'Final Fantasy XVI');

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (7, '2024-06-12', 'Final Fantasy XVI', 'https://imgs.search.brave.com/flULOhoHUP2dqe5RxRVHEhBWUiQ3Pb6Wupzq2st0Thg/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9ibG9n/LmZyLnBsYXlzdGF0/aW9uLmNvbS91cGxv/YWRzL3NpdGVzLzEw/LzIwMjMvMTIvNTQ4/YjdlYTQ1MTE1Yzgx/NDRmNTRkNzZjOWY1/ODQyNTdlYWQ2ZDY2/MC5qcGc', 6, 3);

INSERT INTO public.games(
	id_game, creation_date, is_new, is_online, number_players, platform, release_date, story, studio, title)
	VALUES (7, '2024-06-12', false, true, 8, 'PC', '2009-06-12', 'Dans le monde fantastique de Runeterra, une terre où la magie et les mystères abondent, les nations et les factions se disputent le pouvoir et la survie. Parmi ces factions, la Ligue des Légendes a été créée pour résoudre les conflits par des batailles épiques entre champions, des guerriers aux pouvoirs uniques et extraordinaires.', 'Riot Games', 'League of Legends');

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (8, '2024-06-12', 'League of Legends', 'https://imgs.search.brave.com/1HlcCxZOsF5ENRO6Pq8ZA-kO3g0QYkzkt-yJodLNAeI/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9nZXR3/YWxscGFwZXJzLmNv/bS93YWxscGFwZXIv/ZnVsbC8wL2IvMS8x/NDk1ODE3LWFtYXpp/bmctbGVhZ3VlLW9m/LWxlZ2VuZHMtNGst/d2FsbHBhcGVyLTE5/MjB4MTA4MC13aW5k/b3dzLTcuanBn', 7, 3);

INSERT INTO public.games(
	id_game, creation_date, is_new, is_online, number_players, platform, release_date, story, studio, title)
	VALUES (8, '2024-06-12', true, true, 1, 'PC', '2024-06-12', 'Dans le monde sombre et impitoyable de Sanctuaire, les forces du Ciel et de l Enfer sont enfermées dans une lutte éternelle pour la domination. Après les événements cataclysmiques de Diablo III, une nouvelle menace émerge des ténèbres : Lilith, la fille de Méphisto et la "Mère des Démons", est invoquée dans le monde des mortels.', 'Blizzard Entertainment', 'Diablo Immortal');

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (12, '2024-06-07', 'The last of us Part 1', 'https://imgs.search.brave.com/cbOJ-70NJY8AaDaf61F7MgV17bKapQSZD5J3JLnwzgc/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9ibG9n/LmZyLnBsYXlzdGF0/aW9uLmNvbS90YWNo/eW9uL3NpdGVzLzEw/LzIwMjIvMDkvY2M3/MDAyODY3MTljNmI4/OWM1MzZkOTM1NmQ3/OWQxYmZhNzlhM2Jk/ZS1zY2FsZWQuanBn/P3Jlc2l6ZT0xMDg4/LDYxMiZjcm9wX3N0/cmF0ZWd5PXNtYXJ0', 1, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (13, '2024-06-07', 'Minecraft', 'https://imgs.search.brave.com/0U3QShftPG8iKOgmx-cns5s6z94kiIRyLFrye8CF40Y/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJzLmNvbS9p/bWFnZXMvZmVhdHVy/ZWQvbWluZWNyYWZ0/LWhkLXBpY3R1cmVz/LWYwazloYWltdXR2/dDIxbjguanBn', 2, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (9, '2024-06-07', 'The last of us', 'https://imgs.search.brave.com/6_WFBY6RY6iLIWSfj1-TOSexQch4X00Gq9_dbzdIjXo/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93d3cu/dHJ5YWdhbWUuZnIv/d3AtY29udGVudC91/cGxvYWRzLzIwMjIv/MDkvVGhlLUxhc3Qt/b2YtVXMlRTIlODQl/QTItUGFydC1JXzIw/MjIwODMxMjAzMTEx/LTc4MHg0MzkuanBn', 1, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (10, '2024-06-07', 'The last of us', 'https://imgs.search.brave.com/f8Q3bythA7803Ba1oVau3OsSIVVS4kpIoIKKZ35luus/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pMC53/cC5jb20vd3d3Lm5h/dWdodHlkb2dtYWcu/ZnIvd3AtY29udGVu/dC91cGxvYWRzLzIw/MjIvMDkvVGhlLUxh/c3Qtb2YtVXMtUGFy/dC1JLUpvZWwtZXQt/RWxsaWUtMS5qcGc_/cmVzaXplPTg0MCw0/NzMmc3NsPTE', 1, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (14, '2024-06-07', 'Minecraft', 'https://imgs.search.brave.com/3jb5f7MrZSAnlrZ_R07ZLsGA6h24YOaBg1xehVBz-_I/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJzLmNvbS9p/bWFnZXMvZmVhdHVy/ZWQvYmVzdC1taW5l/Y3JhZnQtcGljdHVy/ZXMtbXAzMTJ1YTFo/dTRteGw5OC5qcGc', 2, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (15, '2024-06-07', 'Minecraft', 'https://imgs.search.brave.com/YFKbK9sWslyZQH2zoa-BAQeOe6wL2a0n4iexJP7wABE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJzLmNvbS9p/bWFnZXMvZmVhdHVy/ZWQvbWluZWNyYWZ0/LWNyZWVwZXItcGlj/dHVyZXMtNmZqd2lv/c253a3EzcGoyMS5q/cGc', 2, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (16, '2024-06-07', 'Minecraft', 'https://imgs.search.brave.com/J7-zkFix82AhmtkJh15ZvPzRykrexVezDmEqnyEO9S0/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1Qk1qZzVZalUx/TURJdFkySXpNaTAw/TVRSbExUazNNVE10/TlRkak9EVXpNRGc1/T0dGa1hrRXlYa0Zx/Y0dkZVFYVnlNalUy/TkRnek9EVUAuanBn', 2, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (17, '2024-06-07', 'Minecraft', 'https://imgs.search.brave.com/W0w0FywiqgLZpk0LPABrbROOsFaZCGXjaLBMXRKDleY/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzLzZjLzNk/L2MyLzZjM2RjMmMw/YTkyNmJjZjM3MWFi/NzQ3MTQ5MGJmYTdi/LmpwZw', 2, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (18, '2024-06-07', 'Halo 3', 'https://imgs.search.brave.com/QW6OBEUdCt15_EFOu9AGfJYRts9urL-Aq0D-RrcaTAA/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93d3cu/Y25ldC5jb20vYS9p/bWcvcmVzaXplLzQw/NWM3ZTVjODQ4ODNi/ODZiMjVjZGI4ZGVh/MTU4ZjI5NGNhZWQw/MDEvaHViLzIwMTAv/MDkvMTMvZDJhNzUw/OGYtZjBmOS0xMWUy/LThjN2MtZDRhZTUy/ZTYyYmNjL0hhbG9f/M19zY3JlZW5zaG90/XzEuanBnP2F1dG89/d2VicCZ3aWR0aD0x/MjAw', 3, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (19, '2024-06-07', 'Halo 3', 'https://imgs.search.brave.com/Be1HPQT_PcDSgAdxxpkDwHoGtd1hjqFWQsw07BKoJAE/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9nYW1p/bmctY2RuLmNvbS9p/bWFnZXMvcHJvZHVj/dHMvNTgyOC9zY3Jl/ZW5zaG90L2hhbG8t/My1wYy1qZXUtc3Rl/YW0td2FsbHBhcGVy/LTEtYmlnLmpwZz92/PTE3MTA1MTAxMjg', 3, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (20, '2024-06-07', 'Halo 3', 'https://imgs.search.brave.com/ojsusBnNeDWxPE7xZZeBVJVYSWbUZRW4_fvTtzNOoaI/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9zdG9y/ZS1pbWFnZXMucy1t/aWNyb3NvZnQuY29t/L2ltYWdlL2FwcHMu/MzE2NzEuNjk5OTAx/NDM3Mjc5OTI5NzQu/MTZiZmY3NTItNTM3/Mi00NmNkLTgxY2It/NzcxN2M5NjA0MGZl/LjUxMzllOTNhLWEy/ZDItNDM3Ny1iYWU1/LWM2MGUzNzczNDEx/Nj9xPTkwJnc9NDgw/Jmg9Mjcw', 3, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (21, '2024-06-07', 'Final fantasy 16', 'https://imgs.search.brave.com/S3zVFSDf83e_wfIfMvpB96QmhoKHNo6zzoGQa3OV1E8/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJhY2Nlc3Mu/Y29tL2Z1bGwvOTEx/MTI0NC5qcGc', 6, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (22, '2024-06-07', 'Final fantasy 16', 'https://imgs.search.brave.com/Gdy1rEmqhUU_MZQkktQEvj7pr_Q8fGx6yhMk0XBGUTo/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9meXJl/LmNkbi5zZXdlc3Qu/bmV0L2ZmLXh2aS82/Mzg1NGFkZjRkYzg4/MGEwZGI2MmYxMzMv/LV8xLTB5UjI2N1la/Yy5qcGc_cXVhbGl0/eT04NSZ3aWR0aD0z/ODQw', 6, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (23, '2024-06-07', 'Final fantasy 16', 'https://imgs.search.brave.com/sDKty9DxD6vbHUhJrOAMTEhdazk6h3fK-i1G7uEW_PQ/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9saXZl/LnN0YXRpY2ZsaWNr/ci5jb20vNjU1MzUv/NTA1NDIyMDk3MTdf/YmM0MDNiOGU4OV9o/LmpwZw', 6, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (24, '2024-06-07', 'Final fantasy 16', 'https://imgs.search.brave.com/nBZ5cxnpOLsfzjqr8xbWL6AebLpjW4Op4bUvAr1Y1tA/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9hc3Nl/dHNpby5nbndjZG4u/Y29tL0ZGMTYtZW52/aXJvbmVtbnQuanBn/P3dpZHRoPTY5MCZx/dWFsaXR5PTcwJmZv/cm1hdD1qcGcmYXV0/bz13ZWJw', 6, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (25, '2024-06-07', 'Ghost of tsushima', 'https://imgs.search.brave.com/gyKrMCenn7PA_-9q4ebrzGdnLub22ZYdHSdNRAZkurw/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9kMWZz/OGxqeHd5emJhNi5j/bG91ZGZyb250Lm5l/dC9hc3NldHMvZWRp/dG9yaWFsLzIwMjAv/MDcvamF3LWRyb3Bw/aW5nLWdob3N0LW9m/LXRzdXNoaW1hLXBo/b3RvLW1vZGUtaW1h/Z2VzLmpwZw', 4, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (26, '2024-06-07', 'Ghost of tsushima', 'https://imgs.search.brave.com/L4-nwfo3A9LVo-TjdFN2-8G7TbwkGduO7-LDnIfuUc0/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL00v/TVY1Qk1UWXdaRFl3/WWpRdFlqUmpOeTAw/WlROaExUZzFOMk10/WmpJeFkyVmtZemc0/T1RRM1hrRXlYa0Zx/Y0dkZVFWUm9hWEpr/VUdGeWRIbEpibWRs/YzNScGIyNVhiM0py/Wm14dmR3QEAuX1Yx/X1FMNzVfVVkyODFf/Q1IwLDAsNTAwLDI4/MV8uanBn', 4, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (27, '2024-06-07', 'Ghost of tsushima', 'https://imgs.search.brave.com/E3s51J6vu4hZ5j9QCS1v5vnayCyiasMvgTMmu_9QJk8/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9nYW1p/bmctY2RuLmNvbS9p/bWFnZXMvbmV3cy9h/cnRpY2xlcy82NDU5/L2NvdmVyLzEwMDB4/NTYzL2dob3N0LW9m/LXRzdXNoaW1hLWRp/cmVjdG9yLXMtY3V0/LXJlYWxpc2UtbGUt/bWVpbGxldXItZGV1/eGllbWUtbGFuY2Vt/ZW50LXBvdXItdW4t/amV1LXBjLWVkaXRl/LXBhci1wbGF5c3Rh/dGlvbi1jb3ZlcjY2/NGIyMTQzMzE2MjUu/anBn', 4, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (28, '2024-06-07', 'Ghost of tsushima', 'https://imgs.search.brave.com/ovhyqxqe_D1h-Hgo1WM65cf6AGxnGdrVdIjVLd-Ez5E/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJjYXZlLmNv/bS93cC93cDcyMTA1/NTkuanBn', 4, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (29, '2024-06-07', 'The witcher 3', 'https://imgs.search.brave.com/YxV1Ql9hGcRVYIqLeUa9oZXj_eQf0AxLyj1oyh5yzGQ/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJzLmNvbS9p/bWFnZXMvZmVhdHVy/ZWQvdGhlLXdpdGNo/ZXItMy1pNjR4NmRm/eGtsbHl3MHFwLmpw/Zw', 5, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (30, '2024-06-07', 'The witcher 3', 'https://imgs.search.brave.com/HjF-Y73B5tZadAKgNUZvl4_q5YTfhxlNQGs6hu347B8/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pLmpl/dXhhY3R1cy5jb20v/ZGF0YXMvamV1eC90/L2gvdGhlLXdpdGNo/ZXItMy13aWxkLWh1/bnQvbC90aGUtd2l0/Y2hlci0zLXdpbGQt/aHVudC01ZDAxMjA2/NTE5ZmFmLmpwZw', 5, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (31, '2024-06-07', 'The witcher 3', 'https://imgs.search.brave.com/2EMBSGu4AKZQzg4YesiHEMAekmggRKhT_1cFUKouqlM/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pLmpl/dXhhY3R1cy5jb20v/ZGF0YXMvamV1eC90/L2gvdGhlLXdpdGNo/ZXItMy13aWxkLWh1/bnQvbC90aGUtd2l0/Y2hlci0zLXdpbGQt/aHVudC01MTMwYzA1/Mzg4MjlkLmpwZw', 5, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (32, '2024-06-07', 'League of legends', 'https://imgs.search.brave.com/k_q7dPerl8oIfbS14iRcrS-ghSESqT5gHJP4Rm5vDN0/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9sZWNs/YWlyZXVyLmZuYWMu/Y29tL3dwLWNvbnRl/bnQvdXBsb2Fkcy8y/MDIzLzEwL2xlYWd1/ZS1vZi1sZWdlbmRz/LmpwZw', 7, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (33, '2024-06-07', 'League of legends', 'https://imgs.search.brave.com/j3NeSe_U_VT3HE2wPMtFAuA-uOQL7eqMcpiyjG9CrNE/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9tbW9z/LmNvbS93cC1jb250/ZW50L2dhbGxlcnkv/bGVhZ3VlLW9mLWxl/Z2VuZHMvY2FjaGUv/TGVhZ3VlLW9mLUxl/Z2VuZHMtYmxpdHpj/cmFuay5qcGctbmdn/aWQwNDMwNDEtbmdn/MGR5bi02MDB4MzM4/eDEwMC0wMGYwdzAx/MGMwMTByMTEwZjEx/MHIwMTB0MDEwLmpw/Zw', 7, 2);

INSERT INTO public.images(
	id_image, creation_date, name, source, id_game, id_type_image)
	VALUES (34, '2024-06-07', 'League of legends', 'https://imgs.search.brave.com/Y2ETGKMCeJIMi2FyDZvx3LFsPMwpWpq6w-cAGf5ozQc/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzL2U2L2Zj/L2I2L2U2ZmNiNmYw/Mzk1OWU5N2I3MzUw/M2I4Yjc0Zjk5YTE2/LmpwZw', 7, 2);




-- Completed on 2024-08-14 15:08:31

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.1

-- Started on 2024-08-14 15:08:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2024-08-14 15:08:31

--
-- PostgreSQL database dump complete
--

-- Completed on 2024-08-14 15:08:31

--
-- PostgreSQL database cluster dump complete
--

