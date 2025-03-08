
-- 后台管理员表
CREATE TABLE admin (
  aid                  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  username             TEXT,
  password             TEXT,
  lastdate             TEXT,--最后一次登录日
  flag                 INTEGER,
  status               INTEGER
);

-- 借书用户表
CREATE TABLE member (
  mid                  TEXT NOT NULL PRIMARY KEY,
  name                 TEXT,
  age                  INTEGER,
  sex                  INTEGER,
  phone                TEXT
);

-- 图书类别表
CREATE TABLE  item(
  iid                  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  name                 TEXT,
  note                 TEXT
);

-- 书籍表
CREATE TABLE books (
  bid                  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  iid                  INTEGER,
  aid                  INTEGER,
  name                 TEXT,
  credate              TEXT,
  status               INTEGER,
  note                 TEXT
);

-- 借书记录表
CREATE TABLE lenbook (
  leid                 INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  bid                  INTEGER,
  mid                  TEXT,
  credate              TEXT,
  retdate              TEXT
);

-- 增加测试数据
-- 管理员ID:admin ,管理员密码:ylcto
INSERT INTO admin(username,password,flag,status)VALUES ('admin','09BDE7C801111CB40BFD47EBAA6C4343',1,1)