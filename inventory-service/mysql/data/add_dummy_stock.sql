-- Insert dummy inventory items
I-- Use the inventory_service database
USE inventory_service;

-- Create the t_inventory table
CREATE TABLE IF NOT EXISTS t_inventory (
                                           id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Auto-incrementing ID
                                           sku_code VARCHAR(255) NOT NULL UNIQUE, -- Unique SKU code
    quantity INT NOT NULL                 -- Quantity in stock
    );

-- Insert dummy data into t_inventory
INSERT INTO t_inventory (sku_code, quantity) VALUES
                                                 ('MOBILE_IPHONE13', 50),   -- iPhone 13
                                                 ('MOBILE_SAMSUNGS21', 100), -- Samsung Galaxy S21
                                                 ('MOBILE_PIXEL7', 75),      -- Google Pixel 7
                                                 ('CAR_TOYOTA_COROLLA', 20), -- Toyota Corolla
                                                 ('CAR_HONDA_CIVIC', 15),    -- Honda Civic
                                                 ('CAR_TESLA_MODEL3', 10),   -- Tesla Model 3
                                                 ('LAPTOP_DELL_XPS15', 30),  -- Dell XPS 15
                                                 ('LAPTOP_MACBOOK_PRO', 25), -- MacBook Pro
                                                 ('LAPTOP_HP_SPECTRE', 40),  -- HP Spectre
                                                 ('TV_SAMSUNG_55', 20),      -- Samsung 55" TV
                                                 ('HEADPHONES_BOSE700', 60), -- Bose 700 Headphones
                                                 ('SMARTWATCH_APPLE', 80);   -- Apple Watch Series 8

-- Verify the data
SELECT * FROM t_inventory;
