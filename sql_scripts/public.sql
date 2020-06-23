/*
 Navicat Premium Data Transfer

 Source Server         : shop
 Source Server Type    : PostgreSQL
 Source Server Version : 120002
 Source Host           : localhost:5432
 Source Catalog        : food
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120002
 File Encoding         : 65001

 Date: 23/06/2020 20:59:11
*/


-- ----------------------------
-- Sequence structure for carousel_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."carousel_seq";
CREATE SEQUENCE "public"."carousel_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for category_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."category_seq";
CREATE SEQUENCE "public"."category_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for customer_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customer_seq";
CREATE SEQUENCE "public"."customer_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for delivery_address_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."delivery_address_seq";
CREATE SEQUENCE "public"."delivery_address_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for hibernate_sequence
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."hibernate_sequence";
CREATE SEQUENCE "public"."hibernate_sequence" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for img_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."img_seq";
CREATE SEQUENCE "public"."img_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for merchant_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."merchant_seq";
CREATE SEQUENCE "public"."merchant_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for order_code_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."order_code_seq";
CREATE SEQUENCE "public"."order_code_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 10000
CACHE 1;

-- ----------------------------
-- Sequence structure for order_form_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."order_form_seq";
CREATE SEQUENCE "public"."order_form_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for order_item_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."order_item_seq";
CREATE SEQUENCE "public"."order_item_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for product_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."product_seq";
CREATE SEQUENCE "public"."product_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS "public"."carousel";
CREATE TABLE "public"."carousel" (
  "id" int4 NOT NULL,
  "img" varchar(255) COLLATE "pg_catalog"."default",
  "link" varchar(255) COLLATE "pg_catalog"."default",
  "title" varchar(255) COLLATE "pg_catalog"."default",
  "merchant_id" int4
)
;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO "public"."carousel" VALUES (1, '12', '121', '12', 1);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS "public"."category";
CREATE TABLE "public"."category" (
  "id" int4 NOT NULL,
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "priority" int4,
  "title" varchar(255) COLLATE "pg_catalog"."default",
  "merchant_id" int4,
  "parent_id" int4
)
;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO "public"."category" VALUES (19, NULL, 7, '甜品', 1, NULL);
INSERT INTO "public"."category" VALUES (20, NULL, 8, '饮品', 1, NULL);
INSERT INTO "public"."category" VALUES (21, NULL, 9, '酒水', 1, NULL);
INSERT INTO "public"."category" VALUES (22, NULL, 10, '礼品', 1, NULL);
INSERT INTO "public"."category" VALUES (23, NULL, 111, '测试名字', 1, NULL);
INSERT INTO "public"."category" VALUES (14, NULL, 2, '当季菜', 1, 15);
INSERT INTO "public"."category" VALUES (16, NULL, 1, '家常菜', 1, 15);
INSERT INTO "public"."category" VALUES (12, NULL, 65536, '绍兴菜', 1, NULL);
INSERT INTO "public"."category" VALUES (18, NULL, 99, '小吃', 1, NULL);
INSERT INTO "public"."category" VALUES (17, NULL, 5, '时蔬菜1212333', 1, NULL);
INSERT INTO "public"."category" VALUES (15, NULL, 3, '冷菜', 1, NULL);
INSERT INTO "public"."category" VALUES (13, NULL, 1, '必点菜', 1, NULL);
INSERT INTO "public"."category" VALUES (34, NULL, 0, '最新添加', 1, NULL);
INSERT INTO "public"."category" VALUES (1, NULL, 111, '测试名字', 1, NULL);
INSERT INTO "public"."category" VALUES (6, NULL, 111, '测试名字', 1, NULL);
INSERT INTO "public"."category" VALUES (3, NULL, 111, '测试名字', 1, NULL);

-- ----------------------------
-- Table structure for category_product
-- ----------------------------
DROP TABLE IF EXISTS "public"."category_product";
CREATE TABLE "public"."category_product" (
  "product_id" int4 NOT NULL,
  "category_id" int4 NOT NULL
)
;

-- ----------------------------
-- Records of category_product
-- ----------------------------
INSERT INTO "public"."category_product" VALUES (163, 12);
INSERT INTO "public"."category_product" VALUES (165, 12);
INSERT INTO "public"."category_product" VALUES (169, 12);
INSERT INTO "public"."category_product" VALUES (169, 13);
INSERT INTO "public"."category_product" VALUES (171, 17);
INSERT INTO "public"."category_product" VALUES (173, 13);
INSERT INTO "public"."category_product" VALUES (175, 13);
INSERT INTO "public"."category_product" VALUES (175, 21);
INSERT INTO "public"."category_product" VALUES (10, 13);
INSERT INTO "public"."category_product" VALUES (13, 34);
INSERT INTO "public"."category_product" VALUES (9, 34);
INSERT INTO "public"."category_product" VALUES (171, 3);
INSERT INTO "public"."category_product" VALUES (167, 1);
INSERT INTO "public"."category_product" VALUES (247, 19);
INSERT INTO "public"."category_product" VALUES (247, 22);
INSERT INTO "public"."category_product" VALUES (245, 16);
INSERT INTO "public"."category_product" VALUES (245, 21);
INSERT INTO "public"."category_product" VALUES (243, 21);
INSERT INTO "public"."category_product" VALUES (241, 15);
INSERT INTO "public"."category_product" VALUES (241, 21);
INSERT INTO "public"."category_product" VALUES (237, 21);
INSERT INTO "public"."category_product" VALUES (239, 18);
INSERT INTO "public"."category_product" VALUES (237, 22);
INSERT INTO "public"."category_product" VALUES (239, 21);
INSERT INTO "public"."category_product" VALUES (235, 13);
INSERT INTO "public"."category_product" VALUES (235, 20);
INSERT INTO "public"."category_product" VALUES (233, 20);
INSERT INTO "public"."category_product" VALUES (179, 13);
INSERT INTO "public"."category_product" VALUES (6, 13);
INSERT INTO "public"."category_product" VALUES (4, 13);
INSERT INTO "public"."category_product" VALUES (213, 18);
INSERT INTO "public"."category_product" VALUES (261, 16);
INSERT INTO "public"."category_product" VALUES (261, 22);
INSERT INTO "public"."category_product" VALUES (259, 22);
INSERT INTO "public"."category_product" VALUES (259, 3);
INSERT INTO "public"."category_product" VALUES (257, 22);
INSERT INTO "public"."category_product" VALUES (255, 22);
INSERT INTO "public"."category_product" VALUES (253, 22);
INSERT INTO "public"."category_product" VALUES (251, 22);
INSERT INTO "public"."category_product" VALUES (249, 19);
INSERT INTO "public"."category_product" VALUES (249, 22);
INSERT INTO "public"."category_product" VALUES (213, 1);
INSERT INTO "public"."category_product" VALUES (14, 34);
INSERT INTO "public"."category_product" VALUES (203, 12);
INSERT INTO "public"."category_product" VALUES (203, 17);
INSERT INTO "public"."category_product" VALUES (193, 3);
INSERT INTO "public"."category_product" VALUES (231, 16);
INSERT INTO "public"."category_product" VALUES (231, 19);
INSERT INTO "public"."category_product" VALUES (225, 19);
INSERT INTO "public"."category_product" VALUES (217, 19);
INSERT INTO "public"."category_product" VALUES (209, 18);
INSERT INTO "public"."category_product" VALUES (8, 34);
INSERT INTO "public"."category_product" VALUES (159, 34);
INSERT INTO "public"."category_product" VALUES (161, 12);
INSERT INTO "public"."category_product" VALUES (12, 34);
INSERT INTO "public"."category_product" VALUES (201, 16);
INSERT INTO "public"."category_product" VALUES (201, 18);
INSERT INTO "public"."category_product" VALUES (195, 16);
INSERT INTO "public"."category_product" VALUES (223, 19);
INSERT INTO "public"."category_product" VALUES (215, 18);
INSERT INTO "public"."category_product" VALUES (183, 1);
INSERT INTO "public"."category_product" VALUES (3, 13);
INSERT INTO "public"."category_product" VALUES (185, 15);
INSERT INTO "public"."category_product" VALUES (185, 3);
INSERT INTO "public"."category_product" VALUES (11, 13);
INSERT INTO "public"."category_product" VALUES (219, 19);
INSERT INTO "public"."category_product" VALUES (219, 1);
INSERT INTO "public"."category_product" VALUES (187, 15);
INSERT INTO "public"."category_product" VALUES (227, 19);
INSERT INTO "public"."category_product" VALUES (207, 18);
INSERT INTO "public"."category_product" VALUES (181, 13);
INSERT INTO "public"."category_product" VALUES (7, 13);
INSERT INTO "public"."category_product" VALUES (205, 17);
INSERT INTO "public"."category_product" VALUES (199, 16);
INSERT INTO "public"."category_product" VALUES (229, 19);
INSERT INTO "public"."category_product" VALUES (177, 14);
INSERT INTO "public"."category_product" VALUES (177, 3);
INSERT INTO "public"."category_product" VALUES (5, 15);
INSERT INTO "public"."category_product" VALUES (5, 16);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer";
CREATE TABLE "public"."customer" (
  "id" int4 NOT NULL,
  "avatar" varchar(255) COLLATE "pg_catalog"."default",
  "date_of_birth" timestamp(6),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "phone" varchar(255) COLLATE "pg_catalog"."default",
  "sex" varchar(255) COLLATE "pg_catalog"."default",
  "wxid" varchar(255) COLLATE "pg_catalog"."default",
  "auto_generated" bool NOT NULL,
  "associated_merchant" int4
)
;
COMMENT ON COLUMN "public"."customer"."associated_merchant" IS '与之相关的商户';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO "public"."customer" VALUES (3, NULL, NULL, '12121212', '21121321332321', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (4, NULL, NULL, '12121212', '213213213213213', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (5, NULL, NULL, '12121212', '213123213213213', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (6, NULL, NULL, '12121212', '21312321321', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (7, NULL, NULL, '21321321', '12321321312', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (8, NULL, NULL, '12121212', '21321321321321', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (9, NULL, NULL, '12121212', '213213213213', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (10, NULL, NULL, '方方', '1113123123', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (11, NULL, NULL, '12121212', '123213213213', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (12, NULL, NULL, '12121212', '151654465465465', NULL, NULL, 't', NULL);
INSERT INTO "public"."customer" VALUES (13, NULL, NULL, '12121212', '121212121212', NULL, NULL, 't', NULL);

-- ----------------------------
-- Table structure for delivery_address
-- ----------------------------
DROP TABLE IF EXISTS "public"."delivery_address";
CREATE TABLE "public"."delivery_address" (
  "id" int4 NOT NULL,
  "address" varchar(512) COLLATE "pg_catalog"."default",
  "phone" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "postcode" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" int4
)
;

-- ----------------------------
-- Records of delivery_address
-- ----------------------------
INSERT INTO "public"."delivery_address" VALUES (2, '', '21121321332321', '12121212', NULL, 3);
INSERT INTO "public"."delivery_address" VALUES (3, '', '213213213213213', '12121212', NULL, 4);
INSERT INTO "public"."delivery_address" VALUES (4, '', '213213213213213', '12121212', NULL, 4);
INSERT INTO "public"."delivery_address" VALUES (5, '', '213213213213213', '12121212', NULL, 4);
INSERT INTO "public"."delivery_address" VALUES (6, '', '213123213213213', '12121212', NULL, 5);
INSERT INTO "public"."delivery_address" VALUES (7, '', '213213213213213', '123213', NULL, 4);
INSERT INTO "public"."delivery_address" VALUES (8, '', '21312321321', '12121212', NULL, 6);
INSERT INTO "public"."delivery_address" VALUES (9, '123213213213', '12321321312', '21321321', NULL, 7);
INSERT INTO "public"."delivery_address" VALUES (10, '7 Wyndley Place', '21321321321321', '12121212', NULL, 8);
INSERT INTO "public"."delivery_address" VALUES (11, '', '21321321321321', '321321321', NULL, 8);
INSERT INTO "public"."delivery_address" VALUES (12, '', '213213213213', '12121212', NULL, 9);
INSERT INTO "public"."delivery_address" VALUES (13, '', '1113123123', '方方', NULL, 10);
INSERT INTO "public"."delivery_address" VALUES (14, '', '123213213213', '12121212', NULL, 11);
INSERT INTO "public"."delivery_address" VALUES (15, '', '21321321321321', '21312321321', NULL, 8);
INSERT INTO "public"."delivery_address" VALUES (16, '7 Wyndley Place', '123213213213', '2132132121', NULL, 11);
INSERT INTO "public"."delivery_address" VALUES (17, '', '151654465465465', '12121212', NULL, 12);
INSERT INTO "public"."delivery_address" VALUES (18, '', '213213213213213', '21321321', NULL, 4);
INSERT INTO "public"."delivery_address" VALUES (19, '', '121212121212', '12121212', NULL, 13);

-- ----------------------------
-- Table structure for img
-- ----------------------------
DROP TABLE IF EXISTS "public"."img";
CREATE TABLE "public"."img" (
  "id" int4 NOT NULL,
  "file_name" varchar(255) COLLATE "pg_catalog"."default",
  "full_url" varchar(255) COLLATE "pg_catalog"."default",
  "url" varchar(255) COLLATE "pg_catalog"."default",
  "thumbnail_url" varchar(255) COLLATE "pg_catalog"."default",
  "thumbnail_width" float4,
  "thumbnail_height" float4,
  "width" float4,
  "height" float4
)
;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO "public"."img" VALUES (41, '52aaba4210104f1fa77b33b531469c8d.jpg', NULL, '/25/86/73/d5/80/4e/52aaba4210104f1fa77b33b531469c8d.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (42, '3399ea9c8077431792dd378f1918f13c.jpg', NULL, '/dd/9d/96/05/a9/4e/3399ea9c8077431792dd378f1918f13c.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (47, '1369d2e9e198444baceef6692e700550.jpg', NULL, '/da/3f/99/d2/9c/41/1369d2e9e198444baceef6692e700550.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (48, 'cfbdd1793058444790f64ec6fd069e69.jpg', NULL, '/8b/17/85/95/cb/49/cfbdd1793058444790f64ec6fd069e69.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (49, 'ae5cd63b923144788f501aeccdc1c877.jpg', NULL, '/5c/e6/c7/a5/7d/4d/ae5cd63b923144788f501aeccdc1c877.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (50, '14d6d3e05a634ecb9f422a38f017502b.jpg', NULL, '/f0/b2/69/73/a0/40/14d6d3e05a634ecb9f422a38f017502b.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (51, 'ae55e896fedc439d8eab1d64b1bd6d23.jpg', NULL, '/c5/8a/16/f9/12/4d/ae55e896fedc439d8eab1d64b1bd6d23.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (52, '8ee9518594a743ed93ac2ba2acd59d7d.jpg', NULL, '/58/ce/33/fe/39/49/8ee9518594a743ed93ac2ba2acd59d7d.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (53, '3a28385817dd475599cb0c5fde499096.jpg', NULL, '/d4/ef/9e/bb/98/46/3a28385817dd475599cb0c5fde499096.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (43, 'f4a9a4d4d44c4589acb2b7474421e4df.jpg', NULL, '/9c/e5/f9/65/19/41/f4a9a4d4d44c4589acb2b7474421e4df.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (54, 'e25bec2ad4e446d1887478898578bf76.jpg', NULL, '/63/9c/0b/82/78/49/e25bec2ad4e446d1887478898578bf76.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (158, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (160, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (162, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (164, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (166, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (168, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (170, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (172, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (174, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (176, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (178, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (180, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (182, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (184, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (186, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (188, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (190, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (192, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (194, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (196, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (198, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (200, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (202, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (204, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (206, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (208, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (210, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (212, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (214, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (216, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (218, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (220, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (222, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (224, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (226, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (228, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (230, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (232, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (234, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (236, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (238, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (240, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (242, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (244, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (246, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (248, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (250, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (252, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (254, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (256, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (258, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (260, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (262, NULL, NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (1, '72cbb1a79e604fcca25195f032e927c0.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (2, 'f53c01c05a46499cabed413b06031f68.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (3, '615aa15661ea43e998b60528febed989.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (4, 'b2fd7c7ba8994805b18f8cbf0198f7ed.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (5, '0ecbbf5ab91045abb67d402274cbb4de.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (6, 'b48a2fb825234d0eb09eb24a8eac97a8.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (7, '77b1973efaa842d98f6e6bd0c1fa2be3.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (8, 'ed4507f403fc4d4bb80de7e1fbb00717.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (9, '1d98f56042684cccb8d73d64eaa18d5a.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (10, '2d004c4764b24d3d943729627e69a088.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (11, '0e7722657f92424f950450176cc5ca0d.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (12, '41f7252c370b448888124b459894b69f.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (13, '3574cd3fdcc4410ca6de4cba44e2b4ad.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (14, '7f1ec93665a1440197c49211d0faf00d.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (15, 'a6db8e558ff6487089f1e97fcb78c4a9.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (16, 'e63454415a044556a201153fedfec530.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (17, 'a3468dead5eb41ce8d9ab7bb2ef0de05.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (18, '2ac5d72ba0c94a2ebdc36d8c6469825c.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (19, 'c9cf41546cb047a5a62ca4aba8e19f9d.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (20, '2da486bd4b334cafb30d13e04ccc5a5e.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (21, 'b7ef78eba35347b88183a1dd432c0772.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (22, '78149f56c2d74f528873d3abbf1740d3.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (23, '0fc923abf5664c46afb216ef6ad81be7.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (24, 'e53b19f652574b549b5d288d81b8e68a.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (25, '16bb72c5165342a2bef4283b047329b8.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (26, '6a5855c09d534fbea1512618dab34c82.png', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (27, 'b99b09089adc4f2c8e9ee0ea27bc60b8.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (28, 'b8f8d840521d4d1f88b6061c8126915b.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (29, '842eaa5c3f8f44e684ca098a79acc2d5.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (30, 'a1c7e4c3637645d99be656b24a884983.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (31, '262d6e6cbdc246e4abcd435ac8e5ed37.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (32, '37bce03322b6403a8091dc40c9734b55.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (33, 'c177877939de4c62bbbdfdc677c92b0a.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (34, '6d6ba5838106468dbf60d066437dbffc.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (35, 'd681f3e211af40879b37e26e8ed93d14.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (36, '4968ebd409ff4ade8f8d54726e71907c.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (37, 'cd2c00d9512f47f9ac5f27ef01369aa0.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (38, '50595f475e5f4af881c8682f49bde4c5.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (55, '31b0bf352d634d508589534266a61304.jpg', NULL, '/6e/13/dd/6d/c2/4d/31b0bf352d634d508589534266a61304.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (39, '0928bb46512c4f2dbddb254fc238d7b8.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (40, '52946cc7f9eb4fabab0167ac3f4e75fe.jpg', NULL, 'https://picsum.photos/200', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (44, 'c2bd3aabb01d430aa6a8ae434941dca9.jpg', NULL, '/26/0e/fd/43/b3/49/c2bd3aabb01d430aa6a8ae434941dca9.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (45, 'b7e0d3c360d0437dbe6eea5525a191e0.jpg', NULL, '/da/7c/7c/ed/20/43/b7e0d3c360d0437dbe6eea5525a191e0.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (46, 'c05e1064bd2c416e9ba14fdf4e21d786.jpg', NULL, '/a1/c6/4b/96/2f/45/c05e1064bd2c416e9ba14fdf4e21d786.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (56, '088fdd3219ca4565a0f69b02e821b6b2.jpg', NULL, '/07/2c/77/41/6d/4f\088fdd3219ca4565a0f69b02e821b6b2.jpg', '/07/2c/77/41/6d/4f\thumb_088fdd3219ca4565a0f69b02e821b6b2.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (57, '82b2c3375bb04917a554aef0c23086d7.jpg', NULL, '9a\81\55\60\3c\4b\82b2c3375bb04917a554aef0c23086d7.jpg', '9a\81\55\60\3c\4b\thumb_82b2c3375bb04917a554aef0c23086d7.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (58, '99bd4047ffab4e2da503e4ff7ebf600d.jpg', NULL, '/img\38\8e\2c\35\f9\4b\99bd4047ffab4e2da503e4ff7ebf600d.jpg', '/img\38\8e\2c\35\f9\4b\thumb_99bd4047ffab4e2da503e4ff7ebf600d.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (59, '1dcf14a5cf4c4c38b80b3f816284c5a6.jpg', NULL, '/img\56\34\bb\ac\a1\49\1dcf14a5cf4c4c38b80b3f816284c5a6.jpg', '/img\56\34\bb\ac\a1\49\thumb_1dcf14a5cf4c4c38b80b3f816284c5a6.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (60, 'bbbf17b1b93d438a94d57e3b0f8d4ad5.png', NULL, '/img\db\9c\55\d7\d5\45\bbbf17b1b93d438a94d57e3b0f8d4ad5.png', '/img\db\9c\55\d7\d5\45\thumb_bbbf17b1b93d438a94d57e3b0f8d4ad5.png', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (61, 'dc148fd3c84c48d4b9ac70a4d6601f43.jpg', NULL, '/img\1c\8d\43\e1\c8\4d\dc148fd3c84c48d4b9ac70a4d6601f43.jpg', '/img\1c\8d\43\e1\c8\4d\thumb_dc148fd3c84c48d4b9ac70a4d6601f43.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (62, '4359301ad1e0480697e57a6250c4e3e5.png', NULL, '/img\ac\5a\8e\2b\59\48\4359301ad1e0480697e57a6250c4e3e5.png', '/img\ac\5a\8e\2b\59\48\thumb_4359301ad1e0480697e57a6250c4e3e5.png', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (63, '45ebf08737b948b78e8d18d5f17901bf.jpg', NULL, '/img\84\9f\4d\60\68\47\45ebf08737b948b78e8d18d5f17901bf.jpg', '/img\84\9f\4d\60\68\47\thumb_45ebf08737b948b78e8d18d5f17901bf.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (64, '5425be5f08104f5fa5316d809ee27e34.jpg', NULL, '/img\d4\d8\6b\c8\df\45\5425be5f08104f5fa5316d809ee27e34.jpg', '/img\d4\d8\6b\c8\df\45\thumb_5425be5f08104f5fa5316d809ee27e34.jpg', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (65, 'f022061f95694aa19fab37e76f3d7c84.png', NULL, '/img\24\92\e7\f4\ec\44\f022061f95694aa19fab37e76f3d7c84.png', '/img\24\92\e7\f4\ec\44\thumb_f022061f95694aa19fab37e76f3d7c84.png', NULL, NULL, NULL, NULL);
INSERT INTO "public"."img" VALUES (66, '6061e863392542d4ad098d0518927c52.jpg', NULL, '/img\cb\08\65\01\c8\44\6061e863392542d4ad098d0518927c52.jpg', '/img\cb\08\65\01\c8\44\thumb_6061e863392542d4ad098d0518927c52.jpg', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS "public"."merchant";
CREATE TABLE "public"."merchant" (
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "notice" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(255) COLLATE "pg_catalog"."default",
  "address" varchar(512) COLLATE "pg_catalog"."default",
  "availability" varchar(255) COLLATE "pg_catalog"."default",
  "phone" varchar(255) COLLATE "pg_catalog"."default",
  "wechat_payment_code_url" varchar(255) COLLATE "pg_catalog"."default",
  "wechat_url" varchar(255) COLLATE "pg_catalog"."default",
  "alipay_url" varchar(255) COLLATE "pg_catalog"."default",
  "alipay_payment_code_url" varchar(255) COLLATE "pg_catalog"."default",
  "bank_card_number" varchar(255) COLLATE "pg_catalog"."default",
  "bank_card_name" varchar(255) COLLATE "pg_catalog"."default",
  "bank_card_date" varchar(255) COLLATE "pg_catalog"."default",
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "role" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."merchant"."availability" IS 'root user 是否应该关停 当前店铺; available unavailable';

-- ----------------------------
-- Records of merchant
-- ----------------------------
INSERT INTO "public"."merchant" VALUES (2, '老师傅开车', '最近有打折哦22', 'OPENING', '中国城 103号 老师傅餐厅', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."merchant" VALUES (3, '老师傅开车', '最近有打折哦22', 'OPENING', '中国城 103号 老师傅餐厅', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO "public"."merchant" VALUES (1, '红火火 *新', '最近有打折哦', 'OPENING', '中国城 102号 红火火餐厅', 'available', '+44 2131231', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'a123321', '$2a$11$LQLwVVCRkmOEFlMGc7sO7ezm3eWvCXBiVAlAyNCjly0CXP9cm5VCO', 'ROLE_MERCHANT');

-- ----------------------------
-- Table structure for order_form
-- ----------------------------
DROP TABLE IF EXISTS "public"."order_form";
CREATE TABLE "public"."order_form" (
  "id" int4 NOT NULL,
  "expired_time" timestamp(6),
  "buyer" varchar(255) COLLATE "pg_catalog"."default",
  "comment" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "order_code" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "order_number" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "payment_method" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "phone" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "takeaway_time" timestamp(6),
  "total_count" int4,
  "total_price" numeric(19,2) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "user_id" int4 NOT NULL,
  "dining_method" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "delivery_address_id" int4 NOT NULL,
  "merchant_id" int4 NOT NULL
)
;

-- ----------------------------
-- Records of order_form
-- ----------------------------
INSERT INTO "public"."order_form" VALUES (10, NULL, '321321321', '', '2020-05-30 12:37:03.994', '10012', '20200530123710012', 'wechat', '21321321321321', 'UNPAID', NULL, 10, 740.00, '2020-05-30 12:37:03.994', 8, 'eatIn', 11, 1);
INSERT INTO "public"."order_form" VALUES (12, NULL, '方方', 'sadsadsadsadsa', '2020-05-30 13:13:25.683', '10014', '20200530131310014', 'wechat', '1113123123', 'UNPAID', NULL, 12, 934.00, '2020-05-30 13:13:25.683', 10, 'eatIn', 13, 1);
INSERT INTO "public"."order_form" VALUES (16, NULL, '12121212', '', '2020-05-30 13:30:58.77', '10018', '20200530133010018', 'cashOnDelivery', '151654465465465', 'UNPAID', NULL, 33, 2695.00, '2020-05-30 13:30:58.77', 12, 'eatIn', 17, 1);
INSERT INTO "public"."order_form" VALUES (17, NULL, '21321321', '', '2020-05-30 13:32:37.076', '10019', '20200530133210019', 'wechat', '213213213213213', 'UNPAID', NULL, 11, 791.00, '2020-05-30 13:32:37.076', 4, 'eatIn', 18, 1);
INSERT INTO "public"."order_form" VALUES (6, NULL, '123213', '21321321321', '2020-05-30 01:53:40.082', '10008', '20200530015340082', 'wechat', '213213213213213', 'UNPAID', NULL, 12, 934.00, '2020-05-30 01:53:40.082', 4, 'eatIn', 7, 1);
INSERT INTO "public"."order_form" VALUES (8, NULL, '21321321', '123213213', '2020-05-30 02:36:32.059', '10010', '20200530023610010', 'cashOnDelivery', '12321321312', 'SHIPPED', NULL, 20, 1164.00, '2020-06-20 12:51:37.692', 7, 'takeaway', 9, 1);
INSERT INTO "public"."order_form" VALUES (9, NULL, '12121212', '213213213', '2020-05-30 12:12:22.752', '10011', '20200530121210011', 'cashOnDelivery', '21321321321321', 'COMPLETE', NULL, 9, 965.00, '2020-06-20 13:01:00.532', 8, 'takeaway', 10, 1);
INSERT INTO "public"."order_form" VALUES (7, NULL, '12121212', '213213213213', '2020-05-30 02:34:54.576', '10009', '20200530023410009', 'wechat', '21312321321', 'COMPLETE', NULL, 19, 1057.00, '2020-06-20 13:10:54.419', 6, 'eatIn', 8, 1);
INSERT INTO "public"."order_form" VALUES (18, NULL, '12121212', '', '2020-06-17 00:08:07.759', '10020', '20200617000810020', 'wechat', '121212121212', 'REFUND', NULL, 5, 195.00, '2020-06-20 13:11:07.6', 13, 'eatIn', 19, 1);
INSERT INTO "public"."order_form" VALUES (13, NULL, '12121212', '', '2020-05-30 13:21:13.804', '10015', '20200530132110015', 'cashOnDelivery', '123213213213', 'CANCEL', NULL, 15, 1087.00, '2020-06-20 13:38:53.535', 11, 'eatIn', 14, 1);
INSERT INTO "public"."order_form" VALUES (14, NULL, '21312321321', '', '2020-05-30 13:25:08.624', '10016', '20200530132510016', 'wechat', '21321321321321', 'REFUND', NULL, 13, 985.00, '2020-06-20 13:38:57.13', 8, 'eatIn', 15, 1);
INSERT INTO "public"."order_form" VALUES (15, NULL, '2132132121', '', '2020-05-30 13:28:06.259', '10017', '20200530132810017', 'bankCard', '123213213213', 'CLOSED', NULL, 12, 888.00, '2020-06-20 13:38:59.792', 11, 'takeaway', 16, 1);
INSERT INTO "public"."order_form" VALUES (11, NULL, '12121212', '', '2020-05-30 12:59:25.576', '10013', '20200530125910013', 'wechat', '213213213213', 'PAID', NULL, 17, 749.00, '2020-06-20 13:39:09.618', 9, 'eatIn', 12, 1);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."order_item";
CREATE TABLE "public"."order_item" (
  "id" int4 NOT NULL,
  "img" varchar(255) COLLATE "pg_catalog"."default",
  "order_id" int4,
  "product_desc" varchar(255) COLLATE "pg_catalog"."default",
  "product_id" int4,
  "product_name" varchar(255) COLLATE "pg_catalog"."default",
  "quantity" int4,
  "sub_total" numeric(19,2),
  "uniprice" numeric(19,2),
  "thumbnail_url" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO "public"."order_item" VALUES (11, 'https://i.picsum.photos/id/10/300/200.jpg', 6, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 5, 255.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (12, 'https://i.picsum.photos/id/17/300/200.jpg', 6, '17', 191, '黄酒布丁17', 7, 679.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (13, 'https://i.picsum.photos/id/10/300/200.jpg', 7, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 6, 306.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (14, 'https://i.picsum.photos/id/14/300/200.jpg', 7, '一锅邵三鲜,地道绍兴菜14', 185, '邵三鲜14', 6, 72.00, 12.00, NULL);
INSERT INTO "public"."order_item" VALUES (15, 'https://i.picsum.photos/id/17/300/200.jpg', 7, '17', 191, '黄酒布丁17', 7, 679.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (16, 'https://i.picsum.photos/id/10/300/200.jpg', 8, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 8, 408.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (17, 'https://i.picsum.photos/id/21/300/200.jpg', 8, '大名鼎鼎绍兴标签21', 199, '油炸臭豆腐21', 6, 84.00, 14.00, NULL);
INSERT INTO "public"."order_item" VALUES (18, 'https://i.picsum.photos/id/22/300/200.jpg', 8, '湖南卫视天天向上,特别推荐22', 201, '酒酿酸奶22', 6, 672.00, 112.00, NULL);
INSERT INTO "public"."order_item" VALUES (19, 'https://i.picsum.photos/id/40/300/200.jpg', 9, '小龙虾醉美味40', 237, '花雕醉龙虾 (小分)40', 4, 540.00, 135.00, NULL);
INSERT INTO "public"."order_item" VALUES (20, 'https://i.picsum.photos/id/41/300/200.jpg', 9, '一锅邵三鲜,地道绍兴菜41', 239, '邵三鲜41', 5, 425.00, 85.00, NULL);
INSERT INTO "public"."order_item" VALUES (21, 'https://i.picsum.photos/id/10/300/200.jpg', 10, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 5, 255.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (22, 'https://i.picsum.photos/id/17/300/200.jpg', 10, '17', 191, '黄酒布丁17', 5, 485.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (23, 'https://i.picsum.photos/id/14/300/200.jpg', 11, '一锅邵三鲜,地道绍兴菜14', 185, '邵三鲜14', 7, 84.00, 12.00, NULL);
INSERT INTO "public"."order_item" VALUES (24, 'https://i.picsum.photos/id/15/300/200.jpg', 11, '大名鼎鼎绍兴标签15', 187, '油炸臭豆腐15', 5, 180.00, 36.00, NULL);
INSERT INTO "public"."order_item" VALUES (25, 'https://i.picsum.photos/id/17/300/200.jpg', 11, '17', 191, '黄酒布丁17', 5, 485.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (26, 'https://i.picsum.photos/id/10/300/200.jpg', 12, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 5, 255.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (27, 'https://i.picsum.photos/id/17/300/200.jpg', 12, '17', 191, '黄酒布丁17', 7, 679.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (28, 'https://i.picsum.photos/id/10/300/200.jpg', 13, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 8, 408.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (29, 'https://i.picsum.photos/id/17/300/200.jpg', 13, '17', 191, '黄酒布丁17', 7, 679.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (30, 'https://i.picsum.photos/id/10/300/200.jpg', 14, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 6, 306.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (31, 'https://i.picsum.photos/id/17/300/200.jpg', 14, '17', 191, '黄酒布丁17', 7, 679.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (32, 'https://i.picsum.photos/id/10/300/200.jpg', 15, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 6, 306.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (33, 'https://i.picsum.photos/id/17/300/200.jpg', 15, '17', 191, '黄酒布丁17', 6, 582.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (34, 'https://i.picsum.photos/id/10/300/200.jpg', 16, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 11, 561.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (35, 'https://i.picsum.photos/id/17/300/200.jpg', 16, '17', 191, '黄酒布丁17', 22, 2134.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (36, 'https://i.picsum.photos/id/10/300/200.jpg', 17, '小龙虾醉美味10', 177, '花雕醉龙虾 (小分)10', 6, 306.00, 51.00, NULL);
INSERT INTO "public"."order_item" VALUES (37, 'https://i.picsum.photos/id/17/300/200.jpg', 17, '17', 191, '黄酒布丁17', 5, 485.00, 97.00, NULL);
INSERT INTO "public"."order_item" VALUES (38, 'https://picsum.photos/200', 18, '小龙虾醉美味45', 247, '花雕醉龙虾 (小分)45', 3, 75.00, 25.00, NULL);
INSERT INTO "public"."order_item" VALUES (39, 'https://picsum.photos/200', 18, '一锅邵三鲜,地道绍兴菜46', 249, '邵三鲜46', 2, 120.00, 60.00, NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS "public"."product";
CREATE TABLE "public"."product" (
  "id" int4 NOT NULL,
  "create_date" timestamp(6),
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "hot" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "price" numeric(19,2) NOT NULL,
  "priceprev1" numeric(19,2),
  "priceprev2" numeric(19,2),
  "quantity_remaining" int4,
  "sales_volume" int4,
  "status" varchar(255) COLLATE "pg_catalog"."default",
  "update_date" timestamp(6),
  "merchant_id" int4,
  "weight" int4,
  "priority" int4,
  "discount" int4
)
;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO "public"."product" VALUES (14, '2020-06-15 15:25:00', '1212', NULL, '花雕醉龙虾 (小分)2', 1.00, NULL, NULL, 99, NULL, 'IN_STOCK', '2020-06-15 21:53:42.657', 1, NULL, 1, NULL);
INSERT INTO "public"."product" VALUES (5, '2020-06-15 13:48:00', '1212', NULL, '小孩', 11.00, NULL, NULL, 99, 0, 'OUT_OF_STOCK', '2020-06-15 13:48:00', 1, 11, 11, NULL);
INSERT INTO "public"."product" VALUES (185, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜14', NULL, '邵三鲜14', 12.00, NULL, NULL, 111, 58, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (231, '2020-05-17 20:06:00', '小龙虾醉美味37', NULL, '花雕醉龙虾 (小分)37', 148.00, NULL, NULL, 321, 399, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (163, '2020-05-17 20:06:22.85', '小龙虾醉美味3', NULL, '花雕醉龙虾 (小分)3', 85.00, NULL, NULL, 181, 159, 'IN_STOCK', '2020-05-17 20:06:22.85', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (165, '2020-05-17 20:06:22.86', '国际烹饪大师黄启云先生倾心打造,花雕浸醉,匀指美味4', NULL, '花雕醉龙虾大份4', 13.00, NULL, NULL, 552, 723, 'IN_STOCK', '2020-05-17 20:06:22.86', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (171, '2020-05-17 20:06:22.886', '7', NULL, '黄酒布丁7', 122.00, NULL, NULL, 771, 200, 'IN_STOCK', '2020-05-17 20:06:22.886', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (255, '2020-05-17 20:06:00', '大名鼎鼎绍兴标签49', NULL, '油炸臭豆腐49', 107.00, NULL, NULL, 789, 798, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (6, '2020-06-15 14:01:00', '最最新', NULL, '小泡泡', 11.00, NULL, NULL, 99, 0, 'OUT_OF_STOCK', '2020-06-15 14:01:00', 1, 1111, 0, NULL);
INSERT INTO "public"."product" VALUES (7, '2020-06-15 14:15:00', '122', NULL, '花雕醉龙虾 (小分)2', 0.00, NULL, NULL, 99, 0, 'OUT_OF_STOCK', '2020-06-15 14:15:00', 1, 1, 1, NULL);
INSERT INTO "public"."product" VALUES (167, '2020-05-17 20:06:22.865', '大名鼎鼎绍兴标签5', NULL, '油炸臭豆腐5', 28.00, NULL, NULL, 619, 333, 'IN_STOCK', '2020-05-17 20:06:22.865', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (169, '2020-05-17 20:06:22.875', '湖南卫视天天向上,特别推荐6', NULL, '酒酿酸奶6', 15.00, NULL, NULL, 435, 720, 'IN_STOCK', '2020-05-17 20:06:22.875', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (173, '2020-05-17 20:06:22.898', '小龙虾醉美味8', NULL, '花雕醉龙虾 (小分)8', 62.00, NULL, NULL, 548, 2, 'IN_STOCK', '2020-05-17 20:06:22.898', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (175, '2020-05-17 20:06:22.913', '国际烹饪大师黄启云先生倾心打造,花雕浸醉,匀指美味9', NULL, '花雕醉龙虾大份9', 44.00, NULL, NULL, 729, 304, 'IN_STOCK', '2020-05-17 20:06:22.913', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (161, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜2', NULL, '邵三鲜2', 136.00, NULL, NULL, 128, 367, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, 2, NULL);
INSERT INTO "public"."product" VALUES (13, '2020-06-15 14:47:00', '123', NULL, '吱吱吱吱在', 1.00, NULL, NULL, 1, NULL, 'IN_STOCK', '2020-06-15 14:47:00', 1, 1, 1, NULL);
INSERT INTO "public"."product" VALUES (12, '2020-06-15 14:45:00', '121', NULL, '花雕醉龙虾 (小分)2', 12.00, NULL, NULL, 99, NULL, 'IN_STOCK', '2020-06-15 14:45:00', 1, NULL, 12, NULL);
INSERT INTO "public"."product" VALUES (11, '2020-06-15 14:43:00', 'SSS', NULL, 'NEWLY', 1.00, NULL, NULL, 1, NULL, 'IN_STOCK', '2020-06-15 14:43:00', 1, 1, 1, NULL);
INSERT INTO "public"."product" VALUES (10, '2020-06-15 14:30:00', '123', NULL, '花雕醉龙虾 (小分)2', 213.00, NULL, NULL, 99, NULL, 'IN_STOCK', '2020-06-15 14:30:00', 1, 1, 1, NULL);
INSERT INTO "public"."product" VALUES (261, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜52', NULL, '邵三鲜52', 39.00, NULL, NULL, 123, 765, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (257, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜50', NULL, '邵三鲜50', 92.00, NULL, NULL, 403, 814, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (253, '2020-05-17 20:06:00', '湖南卫视天天向上,特别推荐48', NULL, '酒酿酸奶48', 48.00, NULL, NULL, 298, 807, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (223, '2020-05-17 20:06:00', '33', NULL, '黄酒布丁33', 49.00, NULL, NULL, 149, 621, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (213, '2020-05-17 20:06:00', '湖南卫视天天向上,特别推荐28', NULL, '酒酿酸奶28', 15.00, NULL, NULL, 778, 889, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (247, '2020-05-17 20:06:00', '小龙虾醉美味45', NULL, '花雕醉龙虾 (小分)45', 25.00, NULL, NULL, 793, 816, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (181, '2020-05-17 20:06:00', '12', NULL, '黄酒布丁12', 107.00, NULL, NULL, 848, 973, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (245, '2020-05-17 20:06:00', '44', NULL, '黄酒布丁44', 12.00, NULL, NULL, 344, 438, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (243, '2020-05-17 20:06:00', '43', NULL, '黄酒布丁43', 89.00, NULL, NULL, 966, 62, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (259, '2020-05-17 20:06:00', '湖南卫视天天向上,特别推荐51', NULL, '酒酿酸奶51', 59.00, NULL, NULL, 494, 106, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (251, '2020-05-17 20:06:00', '湖南卫视天天向上,特别推荐47', NULL, '酒酿酸奶47', 139.00, NULL, NULL, 665, 749, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (249, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜46', NULL, '邵三鲜46', 60.00, NULL, NULL, 240, 347, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (217, '2020-05-17 20:06:00', '大名鼎鼎绍兴标签30', NULL, '油炸臭豆腐30', 13.00, NULL, NULL, 96, 988, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (241, '2020-05-17 20:06:00', '小龙虾醉美味42', NULL, '花雕醉龙虾 (小分)42', 137.00, NULL, NULL, 423, 906, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (239, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜41', NULL, '邵三鲜41', 85.00, NULL, NULL, 732, 129, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (235, '2020-05-17 20:06:00', '39', NULL, '黄酒布丁39', 98.00, NULL, NULL, 28, 15, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (219, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜31', NULL, '邵三鲜31', 18.00, NULL, NULL, 416, 718, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (203, '2020-05-17 20:06:00', '湖南卫视天天向上,特别推荐23', NULL, '酒酿酸奶23', 117.00, NULL, NULL, 316, 708, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (8, '2020-06-15 14:21:00', '12', NULL, '花雕醉龙虾 (小分)2', 0.00, NULL, NULL, 99, NULL, 'OUT_OF_STOCK', '2020-06-15 14:21:00', 1, 1, NULL, NULL);
INSERT INTO "public"."product" VALUES (159, '2020-05-17 20:06:00', '小龙虾醉美味 嘻嘻', NULL, '花雕醉龙虾 (小分', 120.00, NULL, NULL, 222, 76, 'OUT_OF_STOCK', '2020-05-18 20:06:00', 1, 10, 2, NULL);
INSERT INTO "public"."product" VALUES (183, '2020-05-17 20:06:00', '湖南卫视天天向上,特别推荐13', NULL, '酒酿酸奶13', 66.00, NULL, NULL, 878, 304, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (237, '2020-05-17 20:06:00', '小龙虾醉美味40', NULL, '花雕醉龙虾 (小分)40', 135.00, NULL, NULL, 290, 5, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (179, '2020-05-17 20:06:00', '大名鼎鼎绍兴标签11', NULL, '油炸臭豆腐11', 43.00, NULL, NULL, 472, 243, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (233, '2020-05-17 20:06:00', '大名鼎鼎绍兴标签38', NULL, '油炸臭豆腐38', 77.00, NULL, NULL, 608, 194, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (229, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜36', NULL, '邵三鲜36', 120.00, NULL, NULL, 997, 588, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (225, '2020-05-17 20:06:00', '一锅邵三鲜,地道绍兴菜34', NULL, '邵三鲜34', 42.00, NULL, NULL, 591, 21, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (215, '2020-05-17 20:06:00', '国际烹饪大师黄启云先生倾心打造,花雕浸醉,匀指美味29', NULL, '花雕醉龙虾大份29', 61.00, NULL, NULL, 346, 847, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (227, '2020-05-17 20:06:00', '湖南卫视天天向上,特别推荐35', NULL, '酒酿酸奶35', 82.00, NULL, NULL, 171, 501, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (209, '2020-05-17 20:06:00', '26', NULL, '黄酒布丁26', 55.00, NULL, NULL, 513, 43, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (207, '2020-05-17 20:06:00', '小龙虾醉美味25', NULL, '花雕醉龙虾 (小分)25', 44.00, NULL, NULL, 337, 557, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (9, '2020-06-15 14:25:00', '2121', NULL, '小调调', 11.00, NULL, NULL, 99, NULL, 'IN_STOCK', '2020-06-15 14:25:00', 1, 2, 0, NULL);
INSERT INTO "public"."product" VALUES (199, '2020-05-17 20:06:00', '大名鼎鼎绍兴标签21', NULL, '油炸臭豆腐21', 14.00, NULL, NULL, 572, 331, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (193, '2020-05-17 20:06:00', '国际烹饪大师黄启云先生倾心打造,花雕浸醉,匀指美味18', NULL, '花雕醉龙虾大份18', 14.00, NULL, NULL, 814, 107, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (4, '2020-06-08 22:27:00', '1212', NULL, '12121', 1212.00, NULL, NULL, 991212, NULL, 'OUT_OF_STOCK', '2020-06-08 22:27:00', 1, 1121, 1212, NULL);
INSERT INTO "public"."product" VALUES (177, '2020-05-17 20:06:00', '小龙虾醉美味10', NULL, '花雕醉龙虾 (小分)10', 51.00, NULL, NULL, 199, 59, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (3, '2020-06-08 22:22:00', '444444', NULL, '33', 44.00, NULL, NULL, 99, 0, 'OUT_OF_STOCK', '2020-06-08 22:22:00', 1, NULL, 44, NULL);
INSERT INTO "public"."product" VALUES (205, '2020-05-17 20:06:00', '24', NULL, '黄酒布丁24', 96.00, NULL, NULL, 409, 885, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (195, '2020-05-17 20:06:00', '小龙虾醉美味19', NULL, '花雕醉龙虾 (小分)19', 64.00, NULL, NULL, 707, 265, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (201, '2020-05-17 20:06:00', '湖南卫视天天向上,特别推荐22', NULL, '酒酿酸奶22', 112.00, NULL, NULL, 785, 328, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);
INSERT INTO "public"."product" VALUES (187, '2020-05-17 20:06:00', '大名鼎鼎绍兴标签15', NULL, '油炸臭豆腐15', 36.00, NULL, NULL, 823, 268, 'OUT_OF_STOCK', '2020-05-17 20:06:00', 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for product_img
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_img";
CREATE TABLE "public"."product_img" (
  "product_id" int4 NOT NULL,
  "img_id" int4 NOT NULL
)
;

-- ----------------------------
-- Records of product_img
-- ----------------------------
INSERT INTO "public"."product_img" VALUES (163, 164);
INSERT INTO "public"."product_img" VALUES (165, 166);
INSERT INTO "public"."product_img" VALUES (167, 168);
INSERT INTO "public"."product_img" VALUES (169, 170);
INSERT INTO "public"."product_img" VALUES (171, 172);
INSERT INTO "public"."product_img" VALUES (173, 174);
INSERT INTO "public"."product_img" VALUES (175, 176);
INSERT INTO "public"."product_img" VALUES (10, 62);
INSERT INTO "public"."product_img" VALUES (14, 66);
INSERT INTO "public"."product_img" VALUES (247, 248);
INSERT INTO "public"."product_img" VALUES (245, 246);
INSERT INTO "public"."product_img" VALUES (243, 244);
INSERT INTO "public"."product_img" VALUES (241, 242);
INSERT INTO "public"."product_img" VALUES (237, 238);
INSERT INTO "public"."product_img" VALUES (239, 240);
INSERT INTO "public"."product_img" VALUES (235, 236);
INSERT INTO "public"."product_img" VALUES (233, 234);
INSERT INTO "public"."product_img" VALUES (179, 180);
INSERT INTO "public"."product_img" VALUES (6, 58);
INSERT INTO "public"."product_img" VALUES (4, 34);
INSERT INTO "public"."product_img" VALUES (4, 35);
INSERT INTO "public"."product_img" VALUES (261, 262);
INSERT INTO "public"."product_img" VALUES (259, 260);
INSERT INTO "public"."product_img" VALUES (257, 258);
INSERT INTO "public"."product_img" VALUES (255, 256);
INSERT INTO "public"."product_img" VALUES (253, 254);
INSERT INTO "public"."product_img" VALUES (251, 252);
INSERT INTO "public"."product_img" VALUES (249, 250);
INSERT INTO "public"."product_img" VALUES (213, 214);
INSERT INTO "public"."product_img" VALUES (161, 162);
INSERT INTO "public"."product_img" VALUES (12, 64);
INSERT INTO "public"."product_img" VALUES (201, 202);
INSERT INTO "public"."product_img" VALUES (195, 196);
INSERT INTO "public"."product_img" VALUES (223, 224);
INSERT INTO "public"."product_img" VALUES (215, 216);
INSERT INTO "public"."product_img" VALUES (183, 184);
INSERT INTO "public"."product_img" VALUES (3, 31);
INSERT INTO "public"."product_img" VALUES (3, 32);
INSERT INTO "public"."product_img" VALUES (3, 33);
INSERT INTO "public"."product_img" VALUES (185, 186);
INSERT INTO "public"."product_img" VALUES (11, 63);
INSERT INTO "public"."product_img" VALUES (219, 220);
INSERT INTO "public"."product_img" VALUES (187, 188);
INSERT INTO "public"."product_img" VALUES (227, 228);
INSERT INTO "public"."product_img" VALUES (207, 208);
INSERT INTO "public"."product_img" VALUES (181, 182);
INSERT INTO "public"."product_img" VALUES (7, 59);
INSERT INTO "public"."product_img" VALUES (203, 204);
INSERT INTO "public"."product_img" VALUES (193, 194);
INSERT INTO "public"."product_img" VALUES (231, 232);
INSERT INTO "public"."product_img" VALUES (225, 226);
INSERT INTO "public"."product_img" VALUES (217, 218);
INSERT INTO "public"."product_img" VALUES (209, 210);
INSERT INTO "public"."product_img" VALUES (8, 60);
INSERT INTO "public"."product_img" VALUES (159, 55);
INSERT INTO "public"."product_img" VALUES (13, 65);
INSERT INTO "public"."product_img" VALUES (9, 61);
INSERT INTO "public"."product_img" VALUES (205, 206);
INSERT INTO "public"."product_img" VALUES (199, 200);
INSERT INTO "public"."product_img" VALUES (229, 230);
INSERT INTO "public"."product_img" VALUES (177, 178);
INSERT INTO "public"."product_img" VALUES (5, 57);

-- ----------------------------
-- Table structure for product_snapshot
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_snapshot";
CREATE TABLE "public"."product_snapshot" (
  "id" int4 NOT NULL,
  "create_date" timestamp(6),
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "hot" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "price" numeric(19,2) NOT NULL,
  "priceprev1" numeric(19,2),
  "priceprev2" numeric(19,2),
  "quantity_remaining" int4,
  "sales_volume" int4,
  "status" varchar(255) COLLATE "pg_catalog"."default",
  "update_date" timestamp(6),
  "merchant_id" int4,
  "weight" int4,
  "priority" int4,
  "discount" int4
)
;

-- ----------------------------
-- Records of product_snapshot
-- ----------------------------

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."carousel_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."category_seq"', 37, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."customer_seq"', 14, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."delivery_address_seq"', 20, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."hibernate_sequence"', 264, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."img_seq"', 67, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."merchant_seq"', 4, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."order_code_seq"', 10021, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."order_form_seq"', 19, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."order_item_seq"', 40, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."product_seq"', 15, true);

-- ----------------------------
-- Primary Key structure for table carousel
-- ----------------------------
ALTER TABLE "public"."carousel" ADD CONSTRAINT "carousel_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table category
-- ----------------------------
ALTER TABLE "public"."category" ADD CONSTRAINT "category_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table customer
-- ----------------------------
ALTER TABLE "public"."customer" ADD CONSTRAINT "customer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table delivery_address
-- ----------------------------
ALTER TABLE "public"."delivery_address" ADD CONSTRAINT "delivery_address_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table img
-- ----------------------------
ALTER TABLE "public"."img" ADD CONSTRAINT "img_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table merchant
-- ----------------------------
ALTER TABLE "public"."merchant" ADD CONSTRAINT "merchant_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table order_form
-- ----------------------------
ALTER TABLE "public"."order_form" ADD CONSTRAINT "order_form_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table order_item
-- ----------------------------
ALTER TABLE "public"."order_item" ADD CONSTRAINT "order_item_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table product
-- ----------------------------
ALTER TABLE "public"."product" ADD CONSTRAINT "product_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table product_img
-- ----------------------------
ALTER TABLE "public"."product_img" ADD CONSTRAINT "uk_ln1jon8oe3omfttyygrtcryqs" UNIQUE ("img_id");

-- ----------------------------
-- Primary Key structure for table product_snapshot
-- ----------------------------
ALTER TABLE "public"."product_snapshot" ADD CONSTRAINT "product_copy1_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table carousel
-- ----------------------------
ALTER TABLE "public"."carousel" ADD CONSTRAINT "fktfosr2enu3qxcmulv6e8ya4i9" FOREIGN KEY ("merchant_id") REFERENCES "public"."merchant" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table category
-- ----------------------------
ALTER TABLE "public"."category" ADD CONSTRAINT "fk5i13tg9h9a58wudq8pj2yepta" FOREIGN KEY ("merchant_id") REFERENCES "public"."merchant" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table category_product
-- ----------------------------
ALTER TABLE "public"."category_product" ADD CONSTRAINT "fkfr6rjc04htbtc3xas2b9xmq7r" FOREIGN KEY ("category_id") REFERENCES "public"."category" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."category_product" ADD CONSTRAINT "fkssroqj2vyiaujfleklq1ifigj" FOREIGN KEY ("product_id") REFERENCES "public"."product" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table order_item
-- ----------------------------
ALTER TABLE "public"."order_item" ADD CONSTRAINT "fkj7vfaqhwsf6wu88gnwv941w1" FOREIGN KEY ("order_id") REFERENCES "public"."order_form" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table product
-- ----------------------------
ALTER TABLE "public"."product" ADD CONSTRAINT "fkk47qmalv2pg906heielteubu7" FOREIGN KEY ("merchant_id") REFERENCES "public"."merchant" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table product_img
-- ----------------------------
ALTER TABLE "public"."product_img" ADD CONSTRAINT "fk8tlbgw3d7pqtwy6novbva4wou" FOREIGN KEY ("img_id") REFERENCES "public"."img" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."product_img" ADD CONSTRAINT "fksmqh42bp8h7rj8hq70kwydijl" FOREIGN KEY ("product_id") REFERENCES "public"."product" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table product_snapshot
-- ----------------------------
ALTER TABLE "public"."product_snapshot" ADD CONSTRAINT "product_copy1_merchant_id_fkey" FOREIGN KEY ("merchant_id") REFERENCES "public"."merchant" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
