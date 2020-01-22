-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 22 jan. 2020 à 13:28
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `epreuve`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `id` int(11) NOT NULL,
  `theme` varchar(500) COLLATE utf8mb4_bin NOT NULL,
  `heures` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id`, `theme`, `heures`) VALUES
(1, 'Programmation orientée objet', 40),
(2, 'Base de données', 25),
(3, 'Diagramme UML', 25);

-- --------------------------------------------------------

--
-- Structure de la table `ecoles`
--

CREATE TABLE `ecoles` (
  `id` int(11) NOT NULL,
  `nom` varchar(60) COLLATE utf8mb4_bin NOT NULL,
  `mail` varchar(250) COLLATE utf8mb4_bin NOT NULL,
  `adresse` varchar(250) COLLATE utf8mb4_bin NOT NULL,
  `tel` varchar(12) COLLATE utf8mb4_bin NOT NULL,
  `directeur` varchar(100) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `ecoles`
--

INSERT INTO `ecoles` (`id`, `nom`, `mail`, `adresse`, `tel`, `directeur`) VALUES
(1, 'Ensup', 'ensup@eu.fr', '18 route du 8 mail 1954', '0603785683', 'M. Penot');

-- --------------------------------------------------------

--
-- Structure de la table `enseignants`
--

CREATE TABLE `enseignants` (
  `id` int(11) NOT NULL,
  `nom` varchar(25) COLLATE utf8mb4_bin NOT NULL,
  `prenom` varchar(25) COLLATE utf8mb4_bin NOT NULL,
  `mail` varchar(250) COLLATE utf8mb4_bin NOT NULL,
  `adresse` varchar(250) COLLATE utf8mb4_bin NOT NULL,
  `tel` varchar(13) COLLATE utf8mb4_bin NOT NULL,
  `matiere` varchar(40) COLLATE utf8mb4_bin NOT NULL,
  `mdp` varchar(255) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `enseignants`
--

INSERT INTO `enseignants` (`id`, `nom`, `prenom`, `mail`, `adresse`, `tel`, `matiere`, `mdp`) VALUES
(1, 'Mauet', 'jean', 'jean.mauret@gmail.com', '11 rue de paris', '0602384662', 'Programmation orientée objet', 'azerty');

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

CREATE TABLE `etudiants` (
  `id` int(11) NOT NULL,
  `nom` varchar(25) COLLATE utf8mb4_bin NOT NULL,
  `prenom` varchar(25) COLLATE utf8mb4_bin NOT NULL,
  `mail` varchar(250) COLLATE utf8mb4_bin NOT NULL,
  `adresse` varchar(250) COLLATE utf8mb4_bin NOT NULL,
  `tel` varchar(13) COLLATE utf8mb4_bin NOT NULL,
  `naissance` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `id_ecole` int(11) NOT NULL DEFAULT 1,
  `id_cour` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `etudiants`
--

INSERT INTO `etudiants` (`id`, `nom`, `prenom`, `mail`, `adresse`, `tel`, `naissance`, `id_ecole`, `id_cour`) VALUES
(18, 'Nozerand', 'Cédric', 'cedric.nozerand@gmail.com', '11 Rue de paris', '0602384662', '20/10/1993', 1, 3),
(20, 'test', 'test', 'test', 'test', 'test', 'test', 1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ecoles`
--
ALTER TABLE `ecoles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `enseignants`
--
ALTER TABLE `enseignants`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ecole` (`id_ecole`),
  ADD KEY `id_cour` (`id_cour`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `ecoles`
--
ALTER TABLE `ecoles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `enseignants`
--
ALTER TABLE `enseignants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `etudiants`
--
ALTER TABLE `etudiants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD CONSTRAINT `etudiants_ibfk_1` FOREIGN KEY (`id_ecole`) REFERENCES `ecoles` (`id`),
  ADD CONSTRAINT `etudiants_ibfk_2` FOREIGN KEY (`id_cour`) REFERENCES `cours` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
