create view  v_orderexample
as
select `order`.`id` AS `id`,`order`.`buyerId` AS `buyerId`,`order`.`providerId` AS `providerId`,`order`.`questionId` AS `questionId`,`order`.`description` AS `description`,`order`.`number` AS `number`,`order`.`createTime` AS `createTime`,`order`.`del_flag` AS `del_flag`,`user`.`name` AS `pName` from (`order` left join `user` on((`user`.`id` = `order`.`providerId`)))