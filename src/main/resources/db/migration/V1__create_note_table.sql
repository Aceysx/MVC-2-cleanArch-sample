CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` TIMESTAMP default current_timestamp,
  `title` VARCHAR(100),
  `content` VARCHAR(10000),
  `authorId` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;