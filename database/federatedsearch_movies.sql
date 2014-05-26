CREATE DATABASE  IF NOT EXISTS `federatedsearch` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `federatedsearch`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: federatedsearch
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `genre` text,
  `language` varchar(200) DEFAULT NULL,
  `poster` text,
  `released` varchar(45) DEFAULT NULL,
  `runtime` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `network` varchar(45) DEFAULT NULL,
  `plot` text,
  `rated` varchar(45) DEFAULT NULL,
  `air_day` varchar(45) DEFAULT NULL,
  `air_time` varchar(45) DEFAULT NULL,
  `imdb_id` varchar(45) DEFAULT NULL,
  `tracktv_url` varchar(200) DEFAULT NULL,
  `tvrage_id` varchar(45) DEFAULT NULL,
  `imdb_rating` varchar(45) DEFAULT NULL,
  `imdb_votes` varchar(45) DEFAULT NULL,
  `query` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `query` (`query`),
  CONSTRAINT `query` FOREIGN KEY (`query`) REFERENCES `queries` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (96,'Switched at Birth','2011','United States','Drama, Family',NULL,'http://slurm.trakt.us/images/posters/9297.3.jpg',NULL,NULL,'Continuing','ABC Family','Switched at Birth, a one-hour scripted drama, tells the story of two teenage girls who discover they were accidentally switched as newborns in the hospital. Bay Kennish grew up in a wealthy family with two parents and a brother, while Daphne Vasquez, who lost her hearing at an early age due to a case of meningitis, grew up with a single mother in a working-class neighborhood. Things come to a dramatic head when both families meet and struggle to learn how to live together for the sake of the girls.',NULL,'Monday','8:00pm','tt1758772','http://trakt.tv/show/switched-at-birth','27701',NULL,NULL,NULL),(97,'Stargate Atlantis','2004','United States','Action, Adventure, Science Fiction',NULL,'http://slurm.trakt.us/images/posters/329.3.jpg',NULL,NULL,'Ended','Syfy','The story of Stargate Atlantis follows the cliffhanger episode on Stargate SG-1\'s seventh season finale \"Lost City\", where SG-1 found an outpost made by the race known as the Ancients in Antarctica. After the events of Stargate SG-1 season eight premiere \"New Order\", the Stargate Command sends an international team to investigate the outpost. Soon, Dr. Daniel Jackson discovers the location of the greatest city created by the Ancients, Atlantis. The story unfolds when the members of the expedition encounter the Wraith, the race that defeated the Ancients ten thousand years ago.',NULL,'Friday','9:00pm','tt0374455','http://trakt.tv/show/stargate-atlantis','5324',NULL,NULL,NULL),(98,'Lost','2004','United States','Action, Adventure, Drama, Science Fiction','English, Portuguese, Spanish, Arabic, French, Korean, German, Latin, Russian, Japanese','http://slurm.trakt.us/images/posters/234.jpg','Sep/22/2004','42 min','Ended','ABC','After their plane, Oceanic Air flight 815, tore apart whilst thousands of miles off course, the survivors find themselves on a mysterious deserted island where they soon find out they are not alone.','TV-14','Wednesday','9:00pm','tt0411008','http://trakt.tv/show/lost','4284','8.6','268,092',NULL),(99,'Arrow','2012','United States','Action, Adventure, Crime','English, Spanish, Chinese','http://slurm.trakt.us/images/posters/16327.16.jpg',NULL,'42 min','Continuing','The CW','Oliver Queen and his father are lost at sea when their luxury yacht sinks, apparently in a storm. His father dies, but Oliver survives for five years on an uncharted island and eventually returns home. But he wasn\'t alone on the island where he learned not only how to fight and survive but also of his father\'s corruption and unscrupulous business dealings. He returns to civilization a changed man, determined to put things right. He disguises himself with the hood of one of his mysterious island mentors, arms himself with a bow and sets about hunting down the men and women who have corrupted his city.','TV-14','Wednesday','8:00pm','tt2193021','http://trakt.tv/show/arrow','30715','8.2','118,648',NULL),(100,'Believe','2014','United States','Action, Drama, Science Fiction',NULL,'http://slurm.trakt.us/images/posters/21873.2.jpg',NULL,NULL,'Continuing','NBC','Levitation, telekinesis, the ability to control nature, see the future... since she was born, Bo has had gifts she could neither fully understand nor control. But now that she is 10 years old, her powers have become stronger and the threat from malevolent forces that would use her abilities to control the world has grown more dangerous. With her life and future in jeopardy, Bo\'s protector, Milton Winter, turns to an unlikely source to keep her safe - Tate, a wrongfully imprisoned death row inmate who\'s lost his will.\n\nTate and Bo begin an extraordinary journey, one in which trust must be earned. On the run and traveling from city to city, every place they stop and everyone they meet will be changed forever. But they\'ll have to keep going to stay one step ahead of the sinister forces after Bo\'s power... because it will take a miracle to keep them safe forever.',NULL,'Monday','9:00pm','tt2592094','http://trakt.tv/show/believe','34327',NULL,NULL,NULL),(101,'Femme Fatales','2011','United States','Drama, Special Interest',NULL,'http://slurm.trakt.us/images/posters/9183.1.jpg',NULL,NULL,'Ended','Cinemax','A New Late-Night Series from Cinemax From the creators of Femme Fatales Magazine comes a new late-night anthology series about powerful, sexy and dangerous women.\n\nIn each of the 13 stand-alone episodes, women find extraordinary ways of coping with their problems, channeling their survival instincts and bringing out their inner guile. The show is inspired by and styled in the tradition of pulp stories, film noir and graphic novels, and takes place in contemporary settings.\n\nEach episode is introduced by a mysterious and enigmatic host Lilith, played by Tanit Phoenix (\'Death Race 2,\' \'Lost Boys 3\'), and features different casts and storylines, some of which are intertwined.',NULL,'Friday','11:00pm','tt1841108','http://trakt.tv/show/femme-fatales','28282',NULL,NULL,NULL),(102,'Once Upon a Time in Wonderland','2013','United States','Drama, Fantasy, Adventure',NULL,'http://slurm.trakt.us/images/posters/23386.5.jpg',NULL,NULL,'Continuing','ABC','In Victorian England, the young and beautiful Alice tells a tale of a strange new land that exists on the other side of a rabbit hole.  An invisible cat, a hookah-smoking caterpillar and playing cards that talk are just some of the fantastic things shes seen during this impossible adventure.  Surely this troubled girl must be insane and her doctors aim to cure her with a treatment that will make her forget everything.  Alice seems ready to put it all behind her, especially the painful memory of the genie she fell in love with and lost forever  the handsome and mysterious Cyrus.  But deep down Alice knows this world is real and just in the nick of time, the sardonic Knave of Hearts and the irrepressible White Rabbit arrive to save her from a doomed fate. Together, the trio will take a tumble down the rabbit hole to this Wonderland where nothing is impossible.',NULL,'Thursday','8:00pm','tt2802008','http://trakt.tv/show/once-upon-a-time-in-wonderland','35215',NULL,NULL,NULL),(103,'Elementary','2012','United States','Drama, Crime',NULL,'http://slurm.trakt.us/images/posters/16469.19.jpg',NULL,NULL,'Continuing','CBS','Following his fall from grace in London and a stint in rehab, eccentric Sherlock escapes to Manhattan where his wealthy father forces him to live with his worst nightmare  a sober companion, Dr. Watson. A successful surgeon until she lost a patient and her license three years ago, Watson views her current job as another opportunity to help people, as well as paying a penance. Holmes resumes his work as a police consultant in New York City and Watson has no choice but to accompany her irascible new charge on his jobs. But Sherlock finds her medical background helpful, and Watson realizes she has a knack for playing investigator.\n\nWith the mischievous Sherlock Holmes now running free in New York solving crimes, its simple deduction that hes going to need someone to keep him grounded, and its elementary that its a job for Watson. ',NULL,'Thursday','10:00pm','tt2191671','http://trakt.tv/show/elementary','30750',NULL,NULL,NULL),(104,'Lost Girl','2010','Canada','Drama, Fantasy, Crime, Horror','English','http://slurm.trakt.us/images/posters/207.30.jpg','Sep/12/2010','60 min','Continuing','Showcase','Lost Girl focuses on the gorgeous and charismatic Bo, a supernatural being called a succubus who feeds on the energy of humans, sometimes with fatal results. Refusing to embrace her supernatural clan and its rigid hierarchy, Bo is a renegade who takes up the fight for the underdog while searching for the truth about her own mysterious origins.','N/A','Sunday','10:00pm','tt1429449','http://trakt.tv/show/lost-girl','26401','7.9','15,066',NULL),(105,'White Collar','2009','United States','Drama, Action, Adventure, Crime',NULL,'http://slurm.trakt.us/images/posters/25.17.jpg',NULL,NULL,'Continuing','USA Network','White Collar is about the unlikely partnership of a con artist and an FBI agent who have been playing cat and mouse for years.\n\nNeal Caffrey, a charming criminal mastermind, is finally caught by his nemesis, FBI Agent Peter Burke. When Neal escapes from a maximum-security prison to find his lost love, Peter nabs him once again. Rather than returning to jail, Neal suggests an alternative plan: He\'ll provide his criminal expertise to assist the Feds in catching other elusive criminals. Initially wary, Peter quickly finds that Neal provides insight and intuition that can\'t be found on the right side of the law.',NULL,'Friday','9:00pm','tt1358522','http://trakt.tv/show/white-collar','20720',NULL,NULL,NULL),(106,'Haven','2010-','Canada, USA','Crime, Drama, Fantasy','English','http://ia.media-imdb.com/images/M/MV5BMTk2MzM4MjA5Nl5BMl5BanBnXkFtZTcwNjk5Njk1Mw@@._V1_SX300.jpg',NULL,'60 min',NULL,NULL,'A shrewd FBI agent with a lost past who arrives in the small town of Haven, Maine, to solve the murder of a local ex-con only to discover that the curious enclave is a longtime refuge for ...','N/A',NULL,NULL,'tt1519931',NULL,NULL,'7.6','19,475',NULL),(107,'$#*! My Dad Says','2010-','USA','Comedy','English','http://ia.media-imdb.com/images/M/MV5BMTk1ODM3OTgyMF5BMl5BanBnXkFtZTcwNDU4MTAwNA@@._V1_SX300.jpg',NULL,'30 min',NULL,NULL,'Henry Goodson was a 27-year-old writer who lost his job when the magazine he worked for went under. Now...See full synopsis&nbsp;&raquo;','N/A',NULL,NULL,'tt1612578',NULL,NULL,'6.3','3,998',NULL),(108,'Free Agents','2011-','USA, UK','Comedy','English','http://ia.media-imdb.com/images/M/MV5BMTM4MjAwMjIzNF5BMl5BanBnXkFtZTcwNjc2NzQzNg@@._V1_SX300.jpg',NULL,'30 min',NULL,NULL,'Alex is recently divorced, and Helen lost her fiance a year ago. Obviously, these two are definitely not ready to be dating again. So naturally, they end up in bed together one night. Oops....','N/A',NULL,NULL,'tt1839481',NULL,NULL,'5.6','1,340',NULL);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-26 17:24:50
