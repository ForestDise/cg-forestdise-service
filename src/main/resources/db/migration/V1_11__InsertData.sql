INSERT INTO category (attribute) VALUES ('Category 1');
INSERT INTO category (attribute) VALUES ('Category 2');
INSERT INTO product (title, description, main_picture, status, create_at, updated_at, category_id)
VALUES ('Product 1', 'Description 1', 'picture1.jpg', 'Active', NOW(), NOW(), 1);

INSERT INTO product (title, description, main_picture, status, create_at, updated_at, category_id)
VALUES ('Product 2', 'Description 2', 'picture2.jpg', 'Active', NOW(), NOW(), 2);
INSERT INTO variant (name, sku_code, stock_quantity, weight, price, img, product_id)
VALUES ('Variant 1', 'SKU001', 100, 0.5, 20.99, 'variant1.jpg', 1);

INSERT INTO variant (name, sku_code, stock_quantity, weight, price, img, product_id)
VALUES ('Variant 2', 'SKU002', 50, 0.7, 30.99, 'variant2.jpg', 2);
INSERT INTO image (img_path, variant_id) VALUES ('image1.jpg', 1);
INSERT INTO image (img_path, variant_id) VALUES ('image2.jpg', 2);
INSERT INTO video (video_path, variant_id) VALUES ('video1.mp4', 1);
INSERT INTO video (video_path, variant_id) VALUES ('video2.mp4', 2);
INSERT INTO option_table (name) VALUES ('Option 1');
INSERT INTO option_table (name) VALUES ('Option 2');
INSERT INTO optionValue (value, option_id) VALUES ('OptionValue 1', 1);
INSERT INTO optionValue (value, option_id) VALUES ('OptionValue 2', 2);
INSERT INTO variant_option (variant_id, optionvalue_id) VALUES (1, 1);
INSERT INTO variant_option (variant_id, optionvalue_id) VALUES (2, 2);