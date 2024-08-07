CREATE TABLE IF NOT EXISTS
    games
(
    id_game           SERIAL PRIMARY KEY,
    title             VARCHAR(50),
    studio            VARCHAR(50),
    release_date      DATE,
    platform          VARCHAR(50),
    story             TEXT,
    is_online         BOOLEAN,
    number_players    INT,
    creation_date     DATE,
    modification_date DATE
);

CREATE TABLE IF NOT EXISTS
    type_images
(
    id_type_image     SERIAL PRIMARY KEY,
    name              VARCHAR(50),
    creation_date     DATE,
    modification_date DATE
);

CREATE TABLE IF NOT EXISTS
    images
(
    id_image          SERIAL PRIMARY KEY,
    name              VARCHAR(50),
    source            VARCHAR(255),
    creation_date     DATE,
    modification_date DATE,
    id_game           INT,
    id_type_image     INT,
    FOREIGN KEY (id_game) REFERENCES games (id_game),
    FOREIGN KEY (id_type_image) REFERENCES type_images (id_type_image)
);

CREATE TABLE IF NOT EXISTS
    users
(
    id_user           SERIAL PRIMARY KEY,
    username          VARCHAR(50) UNIQUE NOT NULL,
    phone             VARCHAR(50),
    email             VARCHAR(50),
    password          VARCHAR(64),
    creation_date     TIMESTAMP,
    modification_date TIMESTAMP,
    id_image          INT,
    FOREIGN KEY (id_image) REFERENCES images (id_image)
);

CREATE TABLE IF NOT EXISTS
    conversations
(
    id_conversation   SERIAL PRIMARY KEY,
    name              VARCHAR(50),
    creation_date     DATE,
    modification_date DATE,
    id_user           INT,
    id_game           INT,
    FOREIGN KEY (id_user) REFERENCES users (id_user),
    FOREIGN KEY (id_game) REFERENCES games (id_game)
);

CREATE TABLE IF NOT EXISTS
    messages
(
    id_message        SERIAL PRIMARY KEY,
    content           TEXT,
    creation_date     DATE,
    modification_date DATE,
    id_conversation   INT,
    FOREIGN KEY (id_conversation) REFERENCES conversations (id_conversation)
);

INSERT INTO type_images (name, creation_date, modification_date)
VALUES ('Avatar', '2023-01-01', '2023-01-01'),
       ('banner', '2023-01-02', '2023-01-02'),
       ('logo_gamebots', '2023-01-03', '2023-01-03'),
       ('icons_games', '2023-01-04', '2023-01-04'),
       ('image_jeu', '2023-01-05', '2023-01-05');

INSERT INTO games (title, studio, release_date, platform, story, is_online, number_players, creation_date,
                   modification_date)
VALUES ('The Last of Us', 'Naughty Dog', '2013-06-14', 'PlayStation',
        'Dans un monde dévasté où se mêlent infectés et survivants endurcis, Joel, un protagoniste désabusé, est engagé pour faire sortir Ellie, 14 ans, dune zone de quarantaine militaire. Mais ce qui devait être une simple mission de routine se transforme vite en un dangereux périple à travers le pays.',
        false, 1, '2023-01-01', '2023-01-01'),
       ('The Last of Us Part II', 'Naughty Dog', '2020-06-19', 'PlayStation',
        'Cinq ans après leur dangereux périple à travers les États-Unis post-pandémie, Ellie et Joel se sont installés à Jackson, dans le Wyoming. La vie dans une communauté de survivants paisible leur a permis la paix et la stabilité, malgré la menace constante des infectés et des survivants plus désespérés. Lorsqu’un événement violent perturbe cette paix, Ellie se lance dans une quête implacable pour rendre justice et trouver la paix.',
        false, 1, '2023-01-02', '2023-01-02'),
       ('Halo 3', 'Microsoft Game Studios', '2007-09-25', 'Xbox 360',
        'Halo 3 se déroule durant un conflit interstellaire entre l’humanité et une coalition extraterrestre du nom d’Alliance Covenante. Le joueur occupe le rôle du Major, un super soldat, luttant contre les Covenants. Le jeu comprend des véhicules, des armes, un système de jeu absents des précédents titres de la saga, un « cinéma » permettant de regarder les matchs et parties effectués, un système de partage de fichiers et la « Forge », un éditeur de carte permettant de modifier les niveaux multijoueurs.',
        true, 16, '2023-01-03', '2023-01-03'),
       ('Ghost of Tsushima', 'Sucker Punch Productions', '2020-07-17', 'PlayStation',
        'En 1274, le guerrier samouraï Jin Sakai doit repousser l’invasion mongole sur l’île de Tsushima. Confronté à des ennemis implacables et des difficultés insurmontables, il doit abandonner les traditions samouraï et forger une nouvelle voie, celle du Fantôme, en menant une guerre non conventionnelle pour la liberté de Tsushima.',
        false, 1, '2023-01-04', '2023-01-04'),
       ('The Witcher 3: Wild Hunt', 'CD Projekt Red', '2015-05-19', 'PlayStation, Xbox, PC',
        'Le sorceleur Geralt de Riv, chasseur de monstres professionnel, se lance à la recherche de son amour perdu tout en affrontant la menace des chasseurs sauvages et autres monstres dans un monde médiéval fantastique rempli de dangers et d’intrigues politiques.',
        false, 1, '2023-01-05', '2023-01-05'),
       ('Red Dead Redemption 2', 'Rockstar Games', '2018-10-26', 'PlayStation, Xbox, PC',
        'America, 1899. L’ère de l’Ouest sauvage touche à sa fin. Après un braquage qui tourne mal dans la ville de Blackwater, Arthur Morgan et le gang Van der Linde sont contraints de fuir. Le gang doit voler, voler et se frayer un chemin à travers le cœur impitoyable de l’Amérique pour survivre.',
        true, 32, '2023-01-06', '2023-01-06'),
       ('Cyberpunk 2077', 'CD Projekt Red', '2020-12-10', 'PlayStation, Xbox, PC',
        'Dans un monde ouvert de la ville de Night City, un mercenaire nommé V cherche à obtenir un implant unique qui est la clé de l’immortalité. Vous pouvez personnaliser le cyberware, les compétences et le style de jeu de votre personnage pour façonner un monde qui réagit à vos choix.',
        true, 1, '2023-01-07', '2023-01-07'),
       ('The Legend of Zelda', 'Nintendo', '2017-03-03', 'Nintendo Switch',
        'Le jeu se déroule dans un monde ouvert où le joueur contrôle Link, qui se réveille d’un long sommeil pour vaincre Calamity Ganon et sauver le royaume d’Hyrule.',
        false, 1, '2023-01-09', '2023-01-09'),
       ('God of War', 'Santa Monica Studio', '2018-04-20', 'PlayStation',
        'Kratos, l’ancien dieu de la guerre, et son jeune fils Atreus se lancent dans un voyage pour répandre les cendres de la défunte femme de Kratos au sommet des plus hauts pics des neuf royaumes.',
        false, 1, '2023-01-10', '2023-01-10'),
       ('Horizon Zero Dawn', 'Guerrilla Games', '2017-02-28', 'PlayStation, PC',
        'Dans un monde post-apocalyptique dominé par des machines, Aloy, une jeune chasseuse, part en quête de son destin et de la vérité sur son passé.',
        false, 1, '2023-01-11', '2023-01-11'),
       ('Minecraft', 'Mojang Studios', '2011-11-18', 'PlayStation, Xbox, PC, Switch',
        'Un jeu de construction et d’aventure en monde ouvert où les joueurs peuvent explorer, extraire des ressources, fabriquer des objets et construire des structures ou des terrasses de terre dans un monde généré aléatoirement.',
        true, 8, '2023-01-12', '2023-01-12'),
       ('Apex Legends', 'Respawn Entertainment', '2019-02-04', 'PlayStation, Xbox, PC',
        'Apex Legends est un jeu de tir Battle Royale en ligne gratuit dans lequel des équipes de joueurs saffrontent pour être les derniers survivants. Situé dans lunivers de Titanfall, le jeu propose une variété de personnages légendaires avec des capacités uniques, une jouabilité rapide et des environnements immersifs.',
        true, 60, '2023-01-13', '2023-01-13');

INSERT INTO images (name, source, creation_date, modification_date, id_game, id_type_image)
VALUES ('avatar_pathfinder',
        'https://static1.thegamerimages.com/wordpress/wp-content/uploads/2019/03/pathfinder-good.jpg?q=50&fit=crop&w=767&h=431&dpr=1.5',
        '2023-01-01',
        '2023-01-01', 12, 1),
       ('avatar_lifeline',
        'https://i1.sndcdn.com/artworks-c4SgnMvCyz4EV2ew-WBdEMQ-t500x500.jpg', '2023-01-02',
        '2023-01-02', 12, 1),
       ('avatar_bangalore',
        'https://i1.sndcdn.com/artworks-1zzbzpXYXdYPusXz-FU1ysg-t1080x1080.jpg',
        '2023-01-03', '2023-01-03', 12, 1),
       ('avatar_bloodhunt',
        'https://i1.sndcdn.com/artworks-000584129213-qlm6e5-t500x500.jpg', '2023-01-04',
        '2023-01-04', 12, 1),
       ('avatar_ellie',
        'https://i1.sndcdn.com/artworks-vHSVLR8nWlUzZvJh-xOeYEA-t500x500.jpg',
        '2023-01-04',
        '2023-01-04', 1, 1);

INSERT INTO images (name, source, creation_date, modification_date, id_game, id_type_image)
VALUES ('img_1_the_last_of_us',
        'https://www.micromania.fr/on/demandware.static/-/Sites-Micromania-Library/default/dw15156f40/fanzone/dossier/thelastofus/tlou-remaster-guitare.jpg',
        '2023-01-07', '2023-01-07', 1, 5),
       ('img_2_the_last_of_us',
        'https://static.actugaming.net/media/2020/06/The-Last-of-Us-2-Screenshot-2020-06-05-08-54-16-889x500.jpg',
        '2023-01-08', '2023-01-08', 1, 5),
       ('img_3_the_last_of_us',
        'https://cdn.gamekult.com/images/gallery/10/107579/the-last-of-us-part-ii-ps4-28072503.jpg', '2023-01-09',
        '2023-01-09', 1, 5);

INSERT INTO images (name, source, creation_date, modification_date, id_game, id_type_image)
VALUES ('icon_the_last_of_us',
        'https://cdn1.epicgames.com/offer/0c40923dd1174a768f732a3b013dcff2/EGS_TheLastofUsPartIDigitalDeluxeEdition_NaughtyDogLLC_Editions_S1_2560x1440-c8c0c43aa0157f1236735a0508e59c0d',
        '2023-01-10', '2023-01-10', 1, 2),
       ('icon_the_last_of_us_2',
        'https://image.api.playstation.com/vulcan/ap/rnd/202311/1717/fb1aa189abceb083f190ec45f84a6b021b116e7afbd44672.jpg',
        '2023-01-12', '2023-01-12', 2, 2),
       ('icon_Halo_3',
        'https://store-images.s-microsoft.com/image/apps.58523.14183232939782852.b643400c-9b4c-45c3-bd3f-79af6fd6ba17.769e7607-bb66-47ae-9d3a-410c044c0e79?q=90&w=480&h=270',
        '2023-01-11', '2023-01-11', 3, 2),
       ('banner_ghost_of_tsushima', 'https://www.gamereactor.fr/media/94/ghosttsushima_3209423b.jpg', '2023-01-13',
        '2023-01-13', 4, 2),
       ('icon_the_witcher_3',
        'https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/292030/header.jpg?t=1721646225',
        '2023-01-10', '2023-01-10', 5, 2),
       ('icon_red_dead_redemption_2',
        'https://www.rockstarmag.fr/wp-content/uploads/2023/05/ventes-rdr-2-2023.jpg',
        '2023-01-12', '2023-01-12', 6, 2),
       ('icon_cyberpunk_2077',
        'https://gaming-cdn.com/images/products/840/616x353/cyberpunk-2077-pc-jeu-gog-com-cover.jpg?v=1701271565',
        '2023-01-11', '2023-01-11', 7, 2),
       ('icon_The_Legend_of_Zelda_Breath_of_the_Wild',
        'https://assets.nintendo.com/image/upload/c_fill,w_1200/q_auto:best/f_auto/dpr_2.0/ncom/software/switch/70010000000025/7137262b5a64d921e193653f8aa0b722925abc5680380ca0e18a5cfd91697f58',
        '2023-01-11', '2023-01-11', 8, 2),
       ('banner_god_of_war',
        'https://breakcultureblog.wordpress.com/wp-content/uploads/2019/05/105-god-of-war.jpg?w=1080', '2023-01-13',
        '2023-01-13', 9, 2),
       ('banner_horizon_zero_dawn', 'https://cdn.dlcompare.com/game_tetiere/upload/gameimage/file/7502.jpeg.webp',
        '2023-01-13',
        '2023-01-13', 10, 2),
       ('banner_minecraft', 'https://i.ytimg.com/vi/pHXPAA0DREs/maxresdefault.jpg', '2023-01-13',
        '2023-01-13', 11, 2),
       ('banner_apex_legends',
        'https://media.contentapi.ea.com/content/dam/apex-legends/common/apex-price-change-key-art.jpg.adapt.crop16x9.431p.jpg',
        '2023-01-13',
        '2023-01-13', 12, 2);