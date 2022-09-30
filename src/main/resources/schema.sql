-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 29 sep. 2022 à 14:34
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `oliv`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
                             `id` int(11) NOT NULL,
                             `label` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `label`) VALUES
                                            (1, 'Basiques'),
                                            (2, 'Originales'),
                                            (3, 'Suprêmes'),
                                            (4, 'Boissons'),
                                            (5, 'Desserts');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
                            `commande_id` int(11) NOT NULL,
                            `commande_date` datetime(6) DEFAULT NULL,
                            `facture_id` int(11) DEFAULT NULL,
                            `user_id` bigint(20) DEFAULT NULL,
                            `livreur_id` int(11) DEFAULT NULL,
                            `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`commande_id`, `commande_date`, `facture_id`, `user_id`, `livreur_id`, `status`) VALUES
                                                                                                             (2, '2022-09-17 23:47:33.000000', 1, NULL, 1, NULL),
                                                                                                             (7, '2022-09-19 07:29:39.000000', 6, NULL, 2, NULL),
                                                                                                             (11, '2022-09-20 19:58:45.000000', 10, NULL, 6, NULL),
                                                                                                             (15, '2022-09-20 19:59:36.000000', 14, NULL, 1, NULL),
                                                                                                             (20, '2022-09-20 20:35:26.000000', 19, NULL, 2, NULL),
                                                                                                             (23, '2022-09-20 20:46:29.000000', 22, NULL, 5, NULL),
                                                                                                             (28, '2022-09-20 20:46:39.000000', 27, NULL, 4, NULL),
                                                                                                             (32, '2022-09-20 20:46:46.000000', 31, NULL, 1, NULL),
                                                                                                             (35, '2022-09-20 20:47:07.000000', 34, NULL, 6, NULL),
                                                                                                             (40, '2022-09-20 20:48:22.000000', 39, NULL, 2, NULL),
                                                                                                             (43, '2022-09-20 20:49:17.000000', 42, NULL, NULL, NULL),
                                                                                                             (47, '2022-09-20 20:50:03.000000', 46, NULL, NULL, NULL),
                                                                                                             (51, '2022-09-20 20:51:47.000000', 50, NULL, NULL, NULL),
                                                                                                             (55, '2022-09-20 20:51:51.000000', 54, NULL, NULL, NULL),
                                                                                                             (59, '2022-09-20 20:52:04.000000', 58, NULL, NULL, NULL),
                                                                                                             (62, '2022-09-20 20:52:14.000000', 61, NULL, NULL, NULL),
                                                                                                             (65, '2022-09-21 08:52:38.000000', 64, NULL, NULL, NULL),
                                                                                                             (81, '2022-09-21 20:26:33.000000', 80, NULL, 2, NULL),
                                                                                                             (85, '2022-09-21 20:29:28.000000', 84, NULL, 4, NULL),
                                                                                                             (89, '2022-09-21 20:31:47.000000', 88, NULL, 1, NULL),
                                                                                                             (101, '2022-09-24 21:52:42.000000', 100, 23, NULL, NULL),
                                                                                                             (104, '2022-09-24 21:53:38.000000', 103, NULL, 1, NULL),
                                                                                                             (109, '2022-09-24 22:19:09.000000', 108, 25, NULL, NULL),
                                                                                                             (112, '2022-09-24 22:19:14.000000', 111, 25, NULL, NULL),
                                                                                                             (115, '2022-09-24 22:22:22.000000', 114, 25, NULL, NULL),
                                                                                                             (121, '2022-09-24 22:22:29.000000', 120, 25, NULL, NULL),
                                                                                                             (126, '2022-09-24 22:22:43.000000', 125, 25, NULL, NULL),
                                                                                                             (129, '2022-09-24 22:27:10.000000', 128, 24, NULL, NULL),
                                                                                                             (132, '2022-09-24 22:27:14.000000', 131, 24, NULL, NULL),
                                                                                                             (135, '2022-09-24 22:27:20.000000', 134, 24, NULL, NULL),
                                                                                                             (139, '2022-09-24 22:27:30.000000', 138, 24, NULL, NULL),
                                                                                                             (144, '2022-09-24 22:27:35.000000', 143, 24, NULL, NULL),
                                                                                                             (148, '2022-09-25 10:48:05.000000', 147, 26, NULL, NULL),
                                                                                                             (151, '2022-09-25 11:35:04.000000', 150, 29, NULL, NULL),
                                                                                                             (154, '2022-09-25 20:52:02.000000', 153, 1, NULL, NULL),
                                                                                                             (157, '2022-09-25 21:02:26.000000', 156, 1, NULL, NULL),
                                                                                                             (161, '2022-09-25 21:09:16.000000', 160, 1, NULL, NULL),
                                                                                                             (165, '2022-09-25 21:11:55.000000', 164, 1, NULL, NULL),
                                                                                                             (169, '2022-09-25 21:16:07.000000', 168, 25, NULL, NULL),
                                                                                                             (175, '2022-09-26 22:13:29.000000', 174, 1, NULL, NULL),
                                                                                                             (179, '2022-09-26 23:06:48.000000', 178, 1, NULL, NULL),
                                                                                                             (184, '2022-09-28 23:35:09.000000', 183, 1, NULL, NULL),
                                                                                                             (187, '2022-09-29 00:50:40.000000', 186, 1, NULL, NULL),
                                                                                                             (192, '2022-09-29 11:57:01.000000', 191, 25, NULL, NULL),
                                                                                                             (195, '2022-09-29 12:10:25.000000', 194, 25, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
                               `id_commentaire` int(11) NOT NULL,
                               `evaluation` varchar(255) DEFAULT NULL,
                               `produit_produit_id` int(11) DEFAULT NULL,
                               `date_com` datetime DEFAULT NULL,
                               `date_eval` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id_commentaire`, `evaluation`, `produit_produit_id`, `date_com`, `date_eval`) VALUES
                                                                                                              (173, 'j\'ai trouvé la pizza très bonne', 1, '2022-09-25 21:02:26', '2022-09-26 09:22:29'),
                                                                                                              (181, 'Rien a dire patte fine prix raisonable !', 0, '2022-09-26 23:06:48', '2022-09-26 23:07:41'),
                                                                                                              (182, 'je suis fan de cette pizza', 0, '2022-09-25 21:09:16', '2022-09-26 23:08:24');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
                           `facture_id` int(11) NOT NULL,
                           `date_facturation` datetime(6) DEFAULT NULL,
                           `montant` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`facture_id`, `date_facturation`, `montant`) VALUES
                                                                        (1, '2022-09-17 23:47:33.000000', 64),
                                                                        (6, '2022-09-19 07:29:39.000000', 30),
                                                                        (10, '2022-09-20 19:58:45.000000', 21),
                                                                        (14, '2022-09-20 19:59:36.000000', 45),
                                                                        (19, '2022-09-20 20:35:26.000000', 8),
                                                                        (22, '2022-09-20 20:46:29.000000', 31),
                                                                        (27, '2022-09-20 20:46:39.000000', 41),
                                                                        (31, '2022-09-20 20:46:46.000000', 30),
                                                                        (34, '2022-09-20 20:47:07.000000', 44),
                                                                        (39, '2022-09-20 20:48:22.000000', 10),
                                                                        (42, '2022-09-20 20:49:17.000000', 21),
                                                                        (46, '2022-09-20 20:50:03.000000', 21),
                                                                        (50, '2022-09-20 20:51:47.000000', 22),
                                                                        (54, '2022-09-20 20:51:51.000000', 22),
                                                                        (58, '2022-09-20 20:52:04.000000', 22),
                                                                        (61, '2022-09-20 20:52:14.000000', 22),
                                                                        (64, '2022-09-21 08:52:38.000000', 21),
                                                                        (80, '2022-09-21 20:26:33.000000', 18),
                                                                        (84, '2022-09-21 20:29:28.000000', 21),
                                                                        (88, '2022-09-21 20:31:47.000000', 11),
                                                                        (100, '2022-09-24 21:52:42.000000', 10),
                                                                        (103, '2022-09-24 21:53:38.000000', 37),
                                                                        (108, '2022-09-24 22:19:08.000000', 10),
                                                                        (111, '2022-09-24 22:19:14.000000', 20),
                                                                        (114, '2022-09-24 22:22:22.000000', 51),
                                                                        (120, '2022-09-24 22:22:29.000000', 31),
                                                                        (125, '2022-09-24 22:22:43.000000', 8),
                                                                        (128, '2022-09-24 22:27:10.000000', 8),
                                                                        (131, '2022-09-24 22:27:14.000000', 16),
                                                                        (134, '2022-09-24 22:27:20.000000', 27),
                                                                        (138, '2022-09-24 22:27:30.000000', 29),
                                                                        (143, '2022-09-24 22:27:35.000000', 21),
                                                                        (147, '2022-09-25 10:48:05.000000', 10),
                                                                        (150, '2022-09-25 11:35:04.000000', 10),
                                                                        (153, '2022-09-25 20:52:02.000000', 8),
                                                                        (156, '2022-09-25 21:02:26.000000', 18),
                                                                        (160, '2022-09-25 21:09:16.000000', 28),
                                                                        (164, '2022-09-25 21:11:55.000000', 19),
                                                                        (168, '2022-09-25 21:16:07.000000', 21),
                                                                        (174, '2022-09-26 22:13:29.000000', 18),
                                                                        (178, '2022-09-26 23:06:48.000000', 8),
                                                                        (183, '2022-09-28 23:35:09.000000', 11),
                                                                        (186, '2022-09-29 00:50:40.000000', 25.5),
                                                                        (191, '2022-09-29 11:57:01.000000', 2),
                                                                        (194, '2022-09-29 12:10:25.000000', 23);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
    (199);

-- --------------------------------------------------------

--
-- Structure de la table `ligne_com`
--

CREATE TABLE `ligne_com` (
                             `ligne_com_id` int(11) NOT NULL,
                             `prix_achat` double NOT NULL,
                             `quantite` int(11) NOT NULL,
                             `commande_commande_id` int(11) DEFAULT NULL,
                             `produit_produit_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ligne_com`
--

INSERT INTO `ligne_com` (`ligne_com_id`, `prix_achat`, `quantite`, `commande_commande_id`, `produit_produit_id`) VALUES
                                                                                                                     (3, 10, 3, 2, 1),
                                                                                                                     (4, 8, 1, 2, 0),
                                                                                                                     (5, 13, 2, 2, 8),
                                                                                                                     (8, 8, 1, 7, 0),
                                                                                                                     (9, 11, 2, 7, 6),
                                                                                                                     (12, 11, 1, 11, 4),
                                                                                                                     (13, 10, 1, 11, 5),
                                                                                                                     (16, 10, 1, 15, 1),
                                                                                                                     (17, 11, 2, 15, 3),
                                                                                                                     (18, 13, 1, 15, 10),
                                                                                                                     (21, 8, 1, 20, 0),
                                                                                                                     (24, 10, 1, 23, 1),
                                                                                                                     (25, 10, 1, 23, 5),
                                                                                                                     (26, 11, 1, 23, 2),
                                                                                                                     (29, 10, 3, 28, 5),
                                                                                                                     (30, 11, 1, 28, 2),
                                                                                                                     (33, 10, 3, 32, 5),
                                                                                                                     (36, 11, 1, 35, 9),
                                                                                                                     (37, 13, 1, 35, 8),
                                                                                                                     (38, 10, 2, 35, 5),
                                                                                                                     (41, 10, 1, 40, 5),
                                                                                                                     (44, 11, 1, 43, 6),
                                                                                                                     (45, 10, 1, 43, 5),
                                                                                                                     (48, 11, 1, 47, 4),
                                                                                                                     (49, 10, 1, 47, 5),
                                                                                                                     (52, 11, 1, 51, 9),
                                                                                                                     (53, 11, 1, 51, 6),
                                                                                                                     (56, 11, 1, 55, 9),
                                                                                                                     (57, 11, 1, 55, 6),
                                                                                                                     (60, 11, 2, 59, 6),
                                                                                                                     (63, 11, 2, 62, 6),
                                                                                                                     (66, 10, 1, 65, 1),
                                                                                                                     (67, 11, 1, 65, 2),
                                                                                                                     (82, 8, 1, 81, 0),
                                                                                                                     (83, 10, 1, 81, 1),
                                                                                                                     (86, 10, 1, 85, 1),
                                                                                                                     (87, 11, 1, 85, 4),
                                                                                                                     (90, 11, 1, 89, 4),
                                                                                                                     (102, 10, 1, 101, 1),
                                                                                                                     (105, 8, 2, 104, 0),
                                                                                                                     (106, 10, 1, 104, 1),
                                                                                                                     (107, 11, 1, 104, 4),
                                                                                                                     (110, 10, 1, 109, 1),
                                                                                                                     (113, 10, 2, 112, 1),
                                                                                                                     (116, 10, 2, 115, 1),
                                                                                                                     (117, 8, 1, 115, 0),
                                                                                                                     (118, 13, 1, 115, 8),
                                                                                                                     (119, 10, 1, 115, 5),
                                                                                                                     (122, 8, 1, 121, 0),
                                                                                                                     (123, 13, 1, 121, 8),
                                                                                                                     (124, 10, 1, 121, 5),
                                                                                                                     (127, 8, 1, 126, 0),
                                                                                                                     (130, 8, 1, 129, 0),
                                                                                                                     (133, 8, 2, 132, 0),
                                                                                                                     (136, 8, 2, 135, 0),
                                                                                                                     (137, 11, 1, 135, 4),
                                                                                                                     (140, 8, 1, 139, 0),
                                                                                                                     (141, 11, 1, 139, 4),
                                                                                                                     (142, 10, 1, 139, 5),
                                                                                                                     (145, 11, 1, 144, 4),
                                                                                                                     (146, 10, 1, 144, 5),
                                                                                                                     (149, 10, 1, 148, 1),
                                                                                                                     (152, 10, 1, 151, 1),
                                                                                                                     (155, 8, 1, 154, 0),
                                                                                                                     (158, 8, 1, 157, 0),
                                                                                                                     (159, 10, 1, 157, 1),
                                                                                                                     (162, 8, 1, 161, 0),
                                                                                                                     (163, 10, 2, 161, 1),
                                                                                                                     (166, 8, 1, 165, 0),
                                                                                                                     (167, 11, 1, 165, 2),
                                                                                                                     (170, 10, 1, 169, 1),
                                                                                                                     (171, 11, 1, 169, 4),
                                                                                                                     (176, 8, 1, 175, 0),
                                                                                                                     (177, 10, 1, 175, 7),
                                                                                                                     (180, 8, 1, 179, 0),
                                                                                                                     (185, 11, 1, 184, 24),
                                                                                                                     (188, 3.5, 1, 187, 14),
                                                                                                                     (189, 11, 2, 187, 2),
                                                                                                                     (193, 2, 1, 192, 18),
                                                                                                                     (196, 2, 1, 195, 18),
                                                                                                                     (197, 10, 1, 195, 1),
                                                                                                                     (198, 11, 1, 195, 4);

-- --------------------------------------------------------

--
-- Structure de la table `livreur`
--

CREATE TABLE `livreur` (
                           `id` int(11) NOT NULL,
                           `nom` varchar(255) DEFAULT NULL,
                           `adresse` varchar(255) DEFAULT NULL,
                           `prenom` varchar(255) DEFAULT NULL,
                           `tel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livreur`
--

INSERT INTO `livreur` (`id`, `nom`, `adresse`, `prenom`, `tel`) VALUES
                                                                    (1, 'Dupond', '34 rue mongallet 75012 Paris', 'Manu', '0623546789'),
                                                                    (2, 'Lepante', '14 rue mongallet 75012 Paris', 'Eric', '0723546789'),
                                                                    (3, 'Lamani', '7 rue louis blanc 75012 Paris', 'Sami', '0624346784'),
                                                                    (4, 'Berouag', '123 rue de nante 75019 Paris', 'lotfi', '0723548796'),
                                                                    (5, 'Benhamara', '19 rue bert 75010 Paris', 'Armond', '0623232187'),
                                                                    (6, 'Zlatan', '34 rue jaures 75012 Paris', 'Ibrahim', '0687654385'),
                                                                    (7, 'Diabi', '49 rue des bois 75019 Paris', 'Samuhel', '0676543298');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
                           `produit_id` int(11) NOT NULL,
                           `description` varchar(255) DEFAULT NULL,
                           `image` varchar(255) DEFAULT NULL,
                           `label` varchar(255) DEFAULT NULL,
                           `prix` double NOT NULL,
                           `categorie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`produit_id`, `description`, `image`, `label`, `prix`, `categorie_id`) VALUES
                                                                                                  (0, 'Sauce Tomate, Mozzarella, Basilic', 'images/pizza-11.jpg', 'Margarita', 8, 1),
                                                                                                  (1, 'Crème Fraîche, Mozzarella, Double Lardons, Oignons', '/images/pizza-10.jpg', 'Alsacienne', 10, 1),
                                                                                                  (2, 'Sauce Tomate, Mozzarella, Jambon, Tomates, Champignons', 'images/pizza-2.jpg', 'Reine', 11, 1),
                                                                                                  (3, 'Crème Fraîche, Mozzarella, anchois, Olives', 'images/pizza-5.jpg', 'Napolitaine', 12, 2),
                                                                                                  (4, 'Sauce Tomate, Mozzarella, Boeuf Epicé, Merguez, Poivrons, Oignons', 'images/pizza-4.jpg', 'Orientale', 11, 2),
                                                                                                  (5, 'Sauce Tomate, Sauce Salsa, Mozzarella, Boeuf Epicé, Double Merguez, Tomates Fraîches', 'images/Spicy-Pizza-pizza.jpg', 'Spicy', 10, 2),
                                                                                                  (6, 'Sauce Tomate, Mozzarella, Jambon, Ananas', 'images/pizza-7.jpg', 'Hawaienne', 11, 2),
                                                                                                  (7, 'Sauce Tomate, Mozzarella, Champignons, Poivrons, Tomates Fraîches, Oignons, Olives Noires', 'images/pizza-1.jpg', 'Végétaienne', 10, 1),
                                                                                                  (8, 'Sauce Tomate, Mozzarella, Chèvre, Bleu, Reblochon', 'images/pizza-9.jpg', '4fromages', 13, 3),
                                                                                                  (9, 'Crème Fraîche, Mozzarella, Saumon Fumé, Pommes de Terre', 'images/pizza-10.jpg', 'Saumon', 11, 3),
                                                                                                  (10, 'Sauce tomate, Mozzarella, Double reblochon, Lardons, Pomme de terre, Oignons', 'images/pizza-3.jpg', 'Compagnarde', 13, 3),
                                                                                                  (12, 'Sauce Tomate, Mozzarella, Sauce Curry, Double Emincé de Poulet rôti, Pommes de Terre', 'images/pizza-12.jpg', 'Indienne', 13, 3),
                                                                                                  (13, 'Délicieux Cookie aux pépites de chocolat noir servi chaud.', 'images/cookie.jpg', 'Cookie', 3, 5),
                                                                                                  (14, 'Coeur Fondant au chocolat.', 'images/dessert4.jpg', 'Fondant au chocolat', 3.5, 5),
                                                                                                  (15, 'Dessert à la crème de Mascarpone traditionel.', 'images/dessert1.jpg', 'Tiramisu', 3.5, 5),
                                                                                                  (16, 'l incontournable au chocolat noir et aux noix.', 'images/brownie.jpg', 'Brownie', 3, 5),
                                                                                                  (17, 'Tarte à base d amandes avec du caramel croustillant.', 'images/dessert2.jpg', 'Tarte aux daim', 3.5, 5),
                                                                                                  (18, 'un mélange unique de caféine, d eau pétillante avec une touche de caramel.', 'images/coca-cola.jpg', 'Coca-cola', 2, 4),
                                                                                                  (19, 'Le goût unique de Coca-Cola sans sucres & sans calories.', 'images/coca-cola-zero.jpg', 'Coca-cola zero', 2, 4),
                                                                                                  (20, 'Succombez à la délicieuse fusion de saveurs naturelles : thé & pêche intense.', 'images/lipton-ice-tea.jpg', 'lipton-ice-tea', 2, 4),
                                                                                                  (21, 'un cocktail à base de citron vert et de feuilles de menthe fraîche', 'images/7up-mojito.jpg', '7up-mojito', 2, 4),
                                                                                                  (22, 'Schweppes Pomme, aux saveurs irrésistibles de pommes, sans arôme artificiel', 'images/schweppes.jpg', 'Schweppes', 2, 4),
                                                                                                  (23, 'Eau minérale naturelle plate', 'images/evian.jpg', 'Evian.jpg', 2, 4),
                                                                                                  (24, 'Sauce Tomate, Mozzarella, Jambon, Ananas, Oignons', 'images/pizza-6.jpg', 'Hawaienne.jpg', 11, 1),
                                                                                                  (25, 'Crème fraîche, Mozzarella, chèvre, miel, Olives', '/images/chevre-miel.jpg', 'Chevre-miel', 11, 1),
                                                                                                  (27, 'Sauce tomate, Mozzarella, Haché au bœuf assaisonné, Poivrons', 'images/beefy-pepper.jpg', 'beefy-pepper', 12, 2);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
                         `id` bigint(20) NOT NULL,
                         `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
                                       (2, 'ROLE_ADMIN'),
                                       (1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL,
                         `address` varchar(255) NOT NULL,
                         `email` varchar(255) NOT NULL,
                         `name` varchar(255) NOT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         `tel` varchar(255) NOT NULL,
                         `is_active` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `address`, `email`, `name`, `password`, `tel`, `is_active`) VALUES
                                                                                           (1, '210 rue la fayette 75010', 'yacine@gmail.com', 'yacine saib', '$2a$10$I9PdBgpo8hzeX0eFQ75kE.GATa2ny0zqNLRFGFk1NsPP5Xrs5M1uG', '0782007527', b'1'),
                                                                                           (2, '17 rue des bois 93500 Pantin', 'aurelie@gmail.com', 'Aurelie Duval', '$2a$10$FOJ5y27t9td7NR/1NBcUQ.6gPn2DN6nLTU.ZBS3YvVp0CPjODfjgm', '0623567687', b'1'),
                                                                                           (3, '23 Rue de nantes  75019 Paris', 'admin@gmail.com', 'Jean Martin', '$2a$10$tkQrTniK0I2ApZZouQd0C.tB28/BmL4wgCMr3Td5/MF4jHQD2r8km', '0627765410', b'1'),
                                                                                           (18, '76 rue de la paix 75016', 'axel@gmail.com', 'Axel Bartez', '$2a$10$Af5QLqCfaLGICdGzXlh3B.7YUWKvnIOCnhgosTrfb.CxhjX9NR2Lq', '0682032524', b'1'),
                                                                                           (19, '12 avenue de la madelaine 75003', 'fabrice@gmal.com', 'Fabrice Joubert', '$2a$10$xTin4aK1xaGvgSbyfM3uu.K1o.k5g9wn0SoF.fRSx78tmL6LpV8dW', '0632107527', b'1'),
                                                                                           (21, '22 rue de belleville 75020 Paris', 'bouvard@gmail.com', 'Bouvard Philippe', '$2a$10$rn4eiomvFdoyo7.VO4Kg4.ZHOQGdEuGHkGeYmWj8ubxwQfoz10W6y', '0783027527', b'1'),
                                                                                           (23, '17 rue la fayette', 'rebouli@gmail.com', 'Saad Rebouli', '$2a$10$Pipn.2OysYNn9DYu20bN8OWIJTkNP48rsQRH6CzByzSbZ2hWVLnhK', '0682007527', b'1'),
                                                                                           (24, '34 rue louis blanc 75010', 'yacine.saib@gmail.com', 'Cante Ngolo', '$2a$10$J.67Q81u1y5hsSe6Spjcj.8cgFQkuzHNK4rVNDd0b52iqPjIf4Yf.', '0623158753', b'1'),
                                                                                           (25, '210 rue la fayette', 'forteen3@gmail.com', 'yacine saib', '$2a$10$4V51KTLXy1zICNSzcC/eV.F8lf3a0c9ptsrz84Y3AvWM/hP3zSFUu', '0782007527', b'1'),
                                                                                           (26, '210 rue la fayette', 'a@gmail.com', 'yacine saib', '$2a$10$MJwqrkjfgu5.AGHAxkYDkedeaxlkSWw9Ps6izcncpHquPl3yq7StO', '0782007527', b'1'),
                                                                                           (27, '210 rue la fayette', 'loll@gmail.com', 'yacine saib', '$2a$10$KEXPCc7Ump799Adu.tWcnOmnoA4oUe4QHTwBHmunay4NJUh9aoD9C', '0782007527', b'0'),
                                                                                           (28, '210 rue la fayette', 'forteen3@gmail.fr', 'yacine saib', '$2a$10$NR00X1XNe52xT0TvDE9jQO1gcGeKZevSWYopuQzEeHHJsHCI88WYi', '0782007527', b'0'),
                                                                                           (29, '210 rue la fayette', 'a@z', 'yacine saib', '$2a$10$4AD6MAcPpGdNdaIcvWpbSuZ3j0W5vWrUtjTNsj0HYcmFzSIr3Ql6q', '0782007527', b'0'),
                                                                                           (30, '210 rue la fayette', 'a@a', 'yacine saib', '$2a$10$6EVY8H6Qo6gFFnyiAQLGUegXH.zJe7Wu3OLoX/YoT1wejs6LRu5cm', '0782007527', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `users_role`
--

CREATE TABLE `users_role` (
                              `user_id` bigint(20) NOT NULL,
                              `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users_role`
--

INSERT INTO `users_role` (`user_id`, `role_id`) VALUES
                                                    (1, 1),
                                                    (2, 1),
                                                    (3, 2),
                                                    (18, 1),
                                                    (19, 1),
                                                    (21, 1),
                                                    (23, 1),
                                                    (24, 1),
                                                    (25, 1),
                                                    (26, 1),
                                                    (27, 1),
                                                    (28, 1),
                                                    (29, 1),
                                                    (30, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
    ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
    ADD PRIMARY KEY (`commande_id`),
    ADD KEY `FKo35571d53e6npqs1nn0rb5x42` (`facture_id`),
    ADD KEY `FKdoxqj5u97rh2fx400mxnviuli` (`user_id`),
    ADD KEY `FK11tarxikm1ylnu8bdpk15d5ix` (`livreur_id`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
    ADD PRIMARY KEY (`id_commentaire`),
    ADD KEY `FKt269pa5od7vnfrrh4kn6nu0jb` (`produit_produit_id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
    ADD PRIMARY KEY (`facture_id`);

--
-- Index pour la table `ligne_com`
--
ALTER TABLE `ligne_com`
    ADD PRIMARY KEY (`ligne_com_id`),
    ADD KEY `FK17f2forqr9sthficie19nf315` (`commande_commande_id`),
    ADD KEY `FK5sxmrll9mox3leywjkng3m0s5` (`produit_produit_id`);

--
-- Index pour la table `livreur`
--
ALTER TABLE `livreur`
    ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
    ADD PRIMARY KEY (`produit_id`),
    ADD KEY `FK52xhp55kbbl6u4rbluxm3g9hw` (`categorie_id`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Index pour la table `users_role`
--
ALTER TABLE `users_role`
    ADD KEY `FKeejqlb4gq1av9540jg66ju2pi` (`role_id`),
    ADD KEY `FKqpe36jsen4rslwfx5i6dj2fy8` (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
    ADD CONSTRAINT `FK11tarxikm1ylnu8bdpk15d5ix` FOREIGN KEY (`livreur_id`) REFERENCES `livreur` (`id`),
    ADD CONSTRAINT `FKdoxqj5u97rh2fx400mxnviuli` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    ADD CONSTRAINT `FKo35571d53e6npqs1nn0rb5x42` FOREIGN KEY (`facture_id`) REFERENCES `facture` (`facture_id`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
    ADD CONSTRAINT `FKt269pa5od7vnfrrh4kn6nu0jb` FOREIGN KEY (`produit_produit_id`) REFERENCES `produit` (`produit_id`);

--
-- Contraintes pour la table `ligne_com`
--
ALTER TABLE `ligne_com`
    ADD CONSTRAINT `FK17f2forqr9sthficie19nf315` FOREIGN KEY (`commande_commande_id`) REFERENCES `commande` (`commande_id`),
    ADD CONSTRAINT `FK5sxmrll9mox3leywjkng3m0s5` FOREIGN KEY (`produit_produit_id`) REFERENCES `produit` (`produit_id`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
    ADD CONSTRAINT `FK52xhp55kbbl6u4rbluxm3g9hw` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `users_role`
--
ALTER TABLE `users_role`
    ADD CONSTRAINT `FKeejqlb4gq1av9540jg66ju2pi` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    ADD CONSTRAINT `FKqpe36jsen4rslwfx5i6dj2fy8` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
