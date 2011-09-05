# DROP database IF EXISTS mail_demo

# CREATE database mail_demo;

USE mail_demo;

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  product_id INTEGER NOT NULL PRIMARY KEY auto_increment,
  product_id VARCHAR(256) NOT NULL UNIQUE,
  product_name VARCHAR(256) NOT NULL
);

CREATE TABLE test (
  product_id INTEGER NOT NULL PRIMARY KEY auto_increment,
  product_id VARCHAR(256) NOT NULL UNIQUE,
  product_name VARCHAR(256) NOT NULL,
  hash VARCHAR(256) NOT NULL UNIQUE,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
);

INSERT INTO test (product_id, product_name, hash, created_at, updated_at) VALUES  ('1', 'Ruby', uuid(), '2011-06-25T15:41:47', '2011-06-25T15:41:48');
INSERT INTO test (product_id, product_name, hash, created_at, updated_at) VALUES  ('2', 'Perl', uuid(), '2011-06-25T15:41:48', '2011-06-25T15:42:48');
INSERT INTO test (product_id, product_name, hash, created_at, updated_at) VALUES  ('3', 'Python', uuid(), '2011-06-25T15:41:49', '2011-06-25T15:43:48');
