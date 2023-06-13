SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for swipes
-- ----------------------------
DROP TABLE IF EXISTS `swipes`;
CREATE TABLE `swipes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `current_user_id` int(11) NOT NULL,
  `other_user_id` int(11) NOT NULL,
  `direction` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `current_user_id` (`current_user_id`),
  KEY `other_user_id` (`other_user_id`),
  CONSTRAINT `swipes_ibfk_1` FOREIGN KEY (`current_user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `swipes_ibfk_2` FOREIGN KEY (`other_user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of swipes
-- ----------------------------
BEGIN;
INSERT INTO `swipes` (`id`, `current_user_id`, `other_user_id`, `direction`) VALUES (1, 2, 1, 'right');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `birth_date` date NOT NULL,
  `gender` varchar(255) NOT NULL,
  `bio` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` (`id`, `name`, `email`, `birth_date`, `gender`, `bio`) VALUES (1, 'Mary', 'mary@pure.com', '2000-07-06', 'female', 'I\'m a virgin, I\'m not sure how I got here.');
INSERT INTO `users` (`id`, `name`, `email`, `birth_date`, `gender`, `bio`) VALUES (2, 'John', 'john@pure.com', '1998-01-24', 'male', 'I\'m a smith, John Smith.');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
