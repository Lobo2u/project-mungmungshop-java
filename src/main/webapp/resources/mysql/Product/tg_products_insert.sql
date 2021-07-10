DELIMITER $$
CREATE TRIGGER tg_products_insert
BEFORE INSERT ON products
FOR EACH ROW
BEGIN
  INSERT INTO products_seq VALUES (NULL);
  SET NEW.p_code = CONCAT('PRD', LPAD(LAST_INSERT_ID(), 4, '0'));
END$$
DELIMITER ;
