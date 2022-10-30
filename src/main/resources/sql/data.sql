INSERT INTO `order` (status, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주소1', 1, '2022-10-31 02:27:24', null, null);
INSERT INTO `order` (status, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주소2', 1, '2022-10-31 02:27:36', null, null);
INSERT INTO `order` (status, address, item_id, created_at, modified_at, deleted_at) VALUES ('WAIT', '주소3', 1, '2022-10-31 02:27:48', null, null);
INSERT INTO item_image (type, url, name, size, item_id, created_at, modified_at, deleted_at) VALUES ('RAW', 'abc.jpg', '이미지1', 500000, 1, '2022-10-31 02:26:47', null, null);
INSERT INTO item_image (type, url, name, size, item_id, created_at, modified_at, deleted_at) VALUES ('RESIZE', 'abc_resize.jpg', '이미지1_리사이즈', 5000, 1, '2022-10-31 02:27:06', null, null);
INSERT INTO item (name, description, price, store_id, created_at, modified_at, deleted_at) VALUES ('상품1', '설명1', 50000, 1, '2022-10-31 02:26:15', null, null);
INSERT INTO store (name, description, created_at, modified_at, deleted_at) VALUES ('가게1', '설명1', '2022-10-31 02:25:48', null, null);