
UPDATE ACT_DMN_DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = '192.168.1.5 (192.168.1.5)', LOCKGRANTED = TIMESTAMP('2019-03-13 21:57:34.199') WHERE ID = 1 AND LOCKED = 0;

UPDATE ACT_DMN_DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

