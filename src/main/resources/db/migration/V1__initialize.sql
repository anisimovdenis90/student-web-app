CREATE TABLE `students` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `age` INT NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `students` (`name`, `age`)
VALUES
('Bob', 20),
('Jack', 25);