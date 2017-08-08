
-- t_sys_user
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('1', 'michael@micmiu.com', 'admin', 'Admin', null, 'admin');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('2', 'test@micmiu.com', 'user', 'User', null, 'user');

-- t_api_user
INSERT INTO t_api_user (ID, USER_NAME, PASSWORD) VALUES ('1', 'test', 'test');
INSERT INTO t_api_user (ID, USER_NAME, PASSWORD) VALUES ('2', 'micmiu', 'micmiu@ds4j');


INSERT INTO t_api_user_perm (ID, USER_NAME, DS_TYPE, TABLE_NAME, OPT_PERM) VALUES ('1', 'test', 'demo','t_blog','create');
INSERT INTO t_api_user_perm (ID, USER_NAME, DS_TYPE, TABLE_NAME, OPT_PERM) VALUES ('2', 'micmiu', 'demo','t_blog','all');