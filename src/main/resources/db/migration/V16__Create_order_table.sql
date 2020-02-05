CREATE TABLE `order` (
  `id` varchar(100) NOT NULL,
  `buyerId` varchar(36) DEFAULT NULL,
  `providerId` varchar(36) DEFAULT NULL,
  `questionId` bigint DEFAULT NULL,
  `description` message_text DEFAULT NULL,
  `number` int DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `del_flag` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 