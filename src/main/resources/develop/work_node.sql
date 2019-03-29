-- postgresql
CREATE TABLE WORKER_NODE
(
ID BIGSERIAL NOT NULL,
HOST_NAME VARCHAR(64) NOT NULL,
PORT VARCHAR(64) NOT NULL,
TYPE INTEGER NOT NULL,
LAUNCH_DATE DATE NOT NULL,
MODIFIED timestamp without time zone NOT NULL,
CREATED timestamp without time zone NOT NULL,
PRIMARY KEY(ID)
);
COMMENT ON COLUMN WORKER_NODE.ID IS 'auto increment id';
COMMENT ON COLUMN WORKER_NODE.HOST_NAME IS 'host name';
COMMENT ON COLUMN WORKER_NODE.PORT IS 'port';
COMMENT ON COLUMN WORKER_NODE.TYPE IS 'node type: ACTUAL or CONTAINER';
COMMENT ON COLUMN WORKER_NODE.LAUNCH_DATE IS 'launch date';
COMMENT ON COLUMN WORKER_NODE.MODIFIED IS 'modified time';
COMMENT ON COLUMN WORKER_NODE.CREATED IS 'created time';

-- mysql
-- DROP TABLE IF EXISTS WORKER_NODE;
-- CREATE TABLE WORKER_NODE
-- (
-- ID BIGINT NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
-- HOST_NAME VARCHAR(64) NOT NULL COMMENT 'host name',
-- PORT VARCHAR(64) NOT NULL COMMENT 'port',
-- TYPE INT NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
-- LAUNCH_DATE DATE NOT NULL COMMENT 'launch date',
-- MODIFIED TIMESTAMP NOT NULL COMMENT 'modified time',
-- CREATED TIMESTAMP NOT NULL COMMENT 'created time',
-- PRIMARY KEY(ID)
-- )
--  COMMENT='DB WorkerID Assigner for UID Generator',ENGINE = INNODB;