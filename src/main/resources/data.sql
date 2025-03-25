INSERT INTO product (name, description, brand, price, category, release_date, product_available, quantity)
VALUES ('Tata Nexon', 'A compact SUV with excellent safety features and performance.', 'Tata Motors', 750000.00, 'Cars',
        '2024-01-15', TRUE, 50),
       ('Maruti Suzuki Swift', 'A popular hatchback known for its fuel efficiency and reliability.', 'Maruti Suzuki',
        550000.00, 'Cars', '2024-02-01', TRUE, 100),
       ('Hyundai Creta', 'A stylish SUV with advanced features and comfortable interior.', 'Hyundai', 950000.00, 'Cars',
        '2024-03-01', TRUE, 75),
       ('Mahindra Thar', 'A rugged off-road SUV with a powerful engine and modern amenities.', 'Mahindra', 1200000.00,
        'Cars', '2024-04-01', TRUE, 30),
       ('Honda City', 'A premium sedan with a sleek design and advanced safety features.', 'Honda', 1100000.00, 'Cars',
        '2024-05-01', TRUE, 60);

UPDATE Product 
SET image_data = FILE_READ('D:\VSCode\Aryan\SpringProjects\ecom-project-springboot\src\main\resources\static\images\nexon.jpg'),
    image_name = 'nexon',
    image_type = 'image/jpeg'
WHERE id = 1;

UPDATE Product 
SET image_data = FILE_READ('D:\VSCode\Aryan\SpringProjects\ecom-project-springboot\src\main\resources\static\images\swift.webp'),
    image_name = 'swift',
    image_type = 'image/webp'
WHERE id = 2;

UPDATE Product 
SET image_data = FILE_READ('D:\VSCode\Aryan\SpringProjects\ecom-project-springboot\src\main\resources\static\images\creta.png'),
    image_name = 'creta',
    image_type = 'image/png'
WHERE id = 3;

UPDATE Product 
SET image_data = FILE_READ('D:\VSCode\Aryan\SpringProjects\ecom-project-springboot\src\main\resources\static\images\thar.webp'),
    image_name = 'thar',
    image_type = 'image/webp'
WHERE id = 4;

UPDATE Product 
SET image_data = FILE_READ('D:\VSCode\Aryan\SpringProjects\ecom-project-springboot\src\main\resources\static\images\honda-city.webp'),
    image_name = 'city',
    image_type = 'image/webp'
WHERE id = 5;