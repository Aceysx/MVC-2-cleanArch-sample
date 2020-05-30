CREATE TABLE `excellentNote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noteId` int(11),
  `teacherId` int(11),
  `createTime` TIMESTAMP default current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;