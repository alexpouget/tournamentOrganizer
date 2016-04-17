-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Dim 17 Avril 2016 à 18:57
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `TournamentOrganizer`
--

-- --------------------------------------------------------

--
-- Structure de la table `Game`
--

CREATE TABLE `Game` (
  `id` int(11) NOT NULL,
  `idTournament` int(11) NOT NULL,
  `groupe` int(11) DEFAULT NULL,
  `position` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Game`
--

INSERT INTO `Game` (`id`, `idTournament`, `groupe`, `position`) VALUES
(13, 30, 0, 1),
(14, 31, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Tournament`
--

CREATE TABLE `Tournament` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `idTypeTournament` int(11) DEFAULT NULL,
  `nbPlayer` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Tournament`
--

INSERT INTO `Tournament` (`id`, `name`, `idTypeTournament`, `nbPlayer`) VALUES
(30, 'tt', 2, 2),
(31, 'test', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `TypeTournament`
--

CREATE TABLE `TypeTournament` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `TypeTournament`
--

INSERT INTO `TypeTournament` (`id`, `name`) VALUES
(2, 'Championnat'),
(3, 'Tournoi avec groupe'),
(4, 'tournoi direct');

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE `User` (
  `id` int(11) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `User`
--

INSERT INTO `User` (`id`, `name`, `email`) VALUES
(71, 'marius', NULL),
(72, 'terroir', NULL),
(73, 'alex', NULL),
(74, 'benji', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `UserMatch`
--

CREATE TABLE `UserMatch` (
  `id` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `idUserTournament` int(11) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `UserMatch`
--

INSERT INTO `UserMatch` (`id`, `idGame`, `idUserTournament`, `score`) VALUES
(23, 13, 60, 0),
(24, 13, 59, 2),
(25, 14, 62, 2),
(26, 14, 61, 3);

-- --------------------------------------------------------

--
-- Structure de la table `UserTournament`
--

CREATE TABLE `UserTournament` (
  `id` int(11) NOT NULL,
  `idTournament` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `points` int(11) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `UserTournament`
--

INSERT INTO `UserTournament` (`id`, `idTournament`, `idUser`, `points`) VALUES
(59, 30, 71, 0),
(60, 30, 72, 0),
(61, 31, 73, 0),
(62, 31, 74, 0);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Game`
--
ALTER TABLE `Game`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idTournament` (`idTournament`);

--
-- Index pour la table `Tournament`
--
ALTER TABLE `Tournament`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idTypeTournament` (`idTypeTournament`);

--
-- Index pour la table `TypeTournament`
--
ALTER TABLE `TypeTournament`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `UserMatch`
--
ALTER TABLE `UserMatch`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_UserMatch_idGame` (`idGame`),
  ADD KEY `fk_UserMatch_idUserTournament` (`idUserTournament`);

--
-- Index pour la table `UserTournament`
--
ALTER TABLE `UserTournament`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUser` (`idUser`),
  ADD KEY `idTournament` (`idTournament`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Game`
--
ALTER TABLE `Game`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `Tournament`
--
ALTER TABLE `Tournament`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT pour la table `TypeTournament`
--
ALTER TABLE `TypeTournament`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `User`
--
ALTER TABLE `User`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=79;
--
-- AUTO_INCREMENT pour la table `UserMatch`
--
ALTER TABLE `UserMatch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT pour la table `UserTournament`
--
ALTER TABLE `UserTournament`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=67;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Game`
--
ALTER TABLE `Game`
  ADD CONSTRAINT `game_ibfk_1` FOREIGN KEY (`idTournament`) REFERENCES `Tournament` (`id`);

--
-- Contraintes pour la table `Tournament`
--
ALTER TABLE `Tournament`
  ADD CONSTRAINT `tournament_ibfk_1` FOREIGN KEY (`idTypeTournament`) REFERENCES `TypeTournament` (`id`);

--
-- Contraintes pour la table `UserMatch`
--
ALTER TABLE `UserMatch`
  ADD CONSTRAINT `fk_UserMatch_idGame` FOREIGN KEY (`idGame`) REFERENCES `Game` (`id`),
  ADD CONSTRAINT `fk_UserMatch_idUserTournament` FOREIGN KEY (`idUserTournament`) REFERENCES `UserTournament` (`id`);

--
-- Contraintes pour la table `UserTournament`
--
ALTER TABLE `UserTournament`
  ADD CONSTRAINT `usertournament_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `User` (`id`),
  ADD CONSTRAINT `usertournament_ibfk_2` FOREIGN KEY (`idTournament`) REFERENCES `Tournament` (`id`);
