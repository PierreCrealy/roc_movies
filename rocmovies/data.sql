-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 14 fév. 2025 à 14:20
-- Version du serveur : 10.6.21-MariaDB
-- Version de PHP : 8.3.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bibe4387_rocmovies`
--

-- --------------------------------------------------------

--
-- Structure de la table `actors`
--

CREATE TABLE `actors` (
  `id` int(11) NOT NULL,
  `birthdate` datetime(6) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `borrows`
--

CREATE TABLE `borrows` (
  `customer_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `status` enum('En_cours','En_retard','Rendu') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `movies`
--

CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `production_year` int(11) NOT NULL,
  `productor_id` int(11) DEFAULT NULL,
  `style_id` int(11) NOT NULL,
  `image_src` varchar(255) NOT NULL,
  `ref` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `movies`
--

INSERT INTO `movies` (`id`, `production_year`, `productor_id`, `style_id`, `image_src`, `ref`, `title`) VALUES
(1, 2002, 1, 1, 'https://fr.web.img6.acsta.net/medias/nmedia/00/02/32/15/affart.jpg', 'FR-000001', 'D\'Artagnan'),
(2, 2004, 2, 2, 'https://fr.web.img6.acsta.net/medias/nmedia/00/02/32/15/affart.jpg', 'FR-000002', 'D\'Artagnan & Princesse Kèvynne');

-- --------------------------------------------------------

--
-- Structure de la table `movie_styles`
--

CREATE TABLE `movie_styles` (
  `id` int(11) NOT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `movie_styles`
--

INSERT INTO `movie_styles` (`id`, `label`) VALUES
(1, 'Action'),
(2, 'Romance'),
(3, 'Horreur'),
(4, 'Sf'),
(5, 'Fantastique');

-- --------------------------------------------------------

--
-- Structure de la table `productors`
--

CREATE TABLE `productors` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `productors`
--

INSERT INTO `productors` (`id`, `name`) VALUES
(1, 'Pierre'),
(2, 'Joé'),
(3, 'Valentin'),
(4, 'Loane'),
(5, 'Kévin');

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `actor_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `actors`
--
ALTER TABLE `actors`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `borrows`
--
ALTER TABLE `borrows`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKetfpb8t7v27mvi0piss726o7t` (`customer_id`),
  ADD KEY `FKeuf864uemqpdsg2kwvrhnv0cf` (`movie_id`);

--
-- Index pour la table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK53o5n2pxoc835xx1dv3ra2ajp` (`style_id`),
  ADD UNIQUE KEY `UKf6jh3bwkv5o3nki9cy1t1pv2f` (`productor_id`);

--
-- Index pour la table `movie_styles`
--
ALTER TABLE `movie_styles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `productors`
--
ALTER TABLE `productors`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq3lwmnvolv5yb7tqikogot73l` (`actor_id`),
  ADD KEY `FKth07k2vg8bv6xi8mp86vw1ln0` (`movie_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `actors`
--
ALTER TABLE `actors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `borrows`
--
ALTER TABLE `borrows`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `movie_styles`
--
ALTER TABLE `movie_styles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `productors`
--
ALTER TABLE `productors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `borrows`
--
ALTER TABLE `borrows`
  ADD CONSTRAINT `FKetfpb8t7v27mvi0piss726o7t` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  ADD CONSTRAINT `FKeuf864uemqpdsg2kwvrhnv0cf` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`);

--
-- Contraintes pour la table `movies`
--
ALTER TABLE `movies`
  ADD CONSTRAINT `FK3w8xa85pdwdrys316selcs906` FOREIGN KEY (`style_id`) REFERENCES `movie_styles` (`id`),
  ADD CONSTRAINT `FKljpllcu7q6ll3o4qncr63mg6w` FOREIGN KEY (`productor_id`) REFERENCES `productors` (`id`);

--
-- Contraintes pour la table `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `FKq3lwmnvolv5yb7tqikogot73l` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`),
  ADD CONSTRAINT `FKth07k2vg8bv6xi8mp86vw1ln0` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
