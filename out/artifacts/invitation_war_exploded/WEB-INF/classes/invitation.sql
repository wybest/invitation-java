CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(45) collate utf8_unicode_ci default NULL,
  `password` varchar(45) collate utf8_unicode_ci default NULL,
  `create_time` datetime default NULL,
  `last_time` datetime default NULL,
  `vip_num` int(11) default NULL,
  `is_pay` int(11) NOT NULL,
  `email` varchar(45) collate utf8_unicode_ci default NULL,
  `is_phone` int(11) default '0',
  `is_pc` int(11) default '0',
  `font_family` varchar(20) collate utf8_unicode_ci default NULL,
  `advert` varchar(30) collate utf8_unicode_ci default NULL,
  `is_advert` int(11) default '1',
  `extension` varchar(50) collate utf8_unicode_ci default NULL,
  `special_name` varchar(45) collate utf8_unicode_ci default NULL,
  `title1` varchar(20) collate utf8_unicode_ci default NULL,
  `title2` varchar(20) collate utf8_unicode_ci default NULL,
  `title3` varchar(20) collate utf8_unicode_ci default NULL,
  `title4` varchar(20) collate utf8_unicode_ci default NULL,
  `title5` varchar(20) collate utf8_unicode_ci default NULL,
  `show_num` int(11) default '20',
  `admin_id` int(11) default '0',
  `is_confirm` int(11) default '0',
  `is_show` varchar(40) collate utf8_unicode_ci default NULL,
  `style` varchar(10) collate utf8_unicode_ci NOT NULL,
  `mould` varchar(20) collate utf8_unicode_ci default NULL,
  `pc_mould` varchar(20) collate utf8_unicode_ci default NULL,
  `music` varchar(500) collate utf8_unicode_ci default NULL,
  `man` varchar(20) collate utf8_unicode_ci default NULL,
  `women` varchar(20) collate utf8_unicode_ci default NULL,
  `warn_time` varchar(30) collate utf8_unicode_ci default NULL,
  `house` varchar(1000) collate utf8_unicode_ci default NULL,
  `address` varchar(255) collate utf8_unicode_ci default NULL,
  `image` varchar(2000) collate utf8_unicode_ci default NULL,
  `message` varchar(2000) collate utf8_unicode_ci default NULL,
  `coordinate` varchar(30) collate utf8_unicode_ci default NULL,
  `show_time` varchar(45) collate utf8_unicode_ci default NULL,
  `mini_time` varchar(60) collate utf8_unicode_ci default NULL,
  `big_image` varchar(40) collate utf8_unicode_ci default NULL,
  `title` varchar(20) collate utf8_unicode_ci default NULL,
  `big_title` varchar(50) collate utf8_unicode_ci default NULL,
  `wei_xin` varchar(50) collate utf8_unicode_ci default NULL,
  `video` varchar(1000) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  KEY `index_user` (`name`),
  KEY `admin_id` (`admin_id`),
  KEY `index_create_time` (`create_time`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2454 ;