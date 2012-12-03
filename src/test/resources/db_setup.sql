create database dartsstat default character set utf8 collate utf8_bin;
grant all on dartsstat.* to 'dartsstat'@'localhost' identified by 'dartsstat' with grant option;
grant all on dartsstat.* to 'dartsstat'@'localhost.localdomain' identified by 'dartsstat' with grant option;