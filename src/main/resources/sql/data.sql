INSERT INTO store (name, description, created_at, modified_at, deleted_at) VALUES ('가게1', '설명1', '2022-10-31 02:25:48', null, null);

INSERT INTO item (name, description, price, store_id, created_at, modified_at, deleted_at) VALUES ('상품1', '설명1', 50000, 1, '2022-10-31 02:26:15', null, null);

INSERT INTO item_image (type, url, name, size, item_id, created_at, modified_at, deleted_at) VALUES ('RAW', 'abc.jpg', '이미지1', 500000, 1, '2022-10-31 02:26:47', null, null);
INSERT INTO item_image (type, url, name, size, item_id, created_at, modified_at, deleted_at) VALUES ('RESIZE', 'abc_resize.jpg', '이미지1_리사이즈', 5000, 1, '2022-10-31 02:27:06', null, null);

INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자1', '주소1', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자2', '주소2', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자3', '주소3', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자4', '주소4', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자5', '주소5', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자6', '주소6', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자7', '주소7', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자8', '주소8', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자9', '주소9', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자10', '주소10', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자11', '주소11', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자12', '주소12', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자13', '주소13', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자14', '주소14', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자15', '주소15', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자16', '주소16', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자17', '주소17', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자18', '주소18', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자19', '주소19', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자20', '주소20', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자21', '주소21', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자22', '주소22', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자23', '주소23', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자24', '주소24', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자25', '주소25', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자26', '주소26', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자27', '주소27', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자28', '주소28', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자29', '주소29', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO `order` (status, orderer, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주문자30', '주소30', 1, '2022-10-31 02:27:24', null, null);