DROP TABLE IF EXISTS city;

CREATE TABLE city (
    `id` SERIAL,
    `name` VARCHAR(64),
    `state` VARCHAR(64),
    `country` VARCHAR(64),
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
);

INSERT INTO city (NAME, state, country) VALUES

('San Francisco', 'CA', 'US'),
('San Francisco', 'CB', 'US'),
('San Francisco', 'CC', 'US'),
('San Francisco', 'CD', 'US'),
('San Francisco', 'CE', 'US'),
('San Francisco', 'CF', 'US'),
('San Francisco', 'CG', 'US'),
('San Francisco', 'CH', 'US'),
('San Francisco', 'CI', 'US'),
('San Francisco', 'CJ', 'US'),
('San Francisco', 'CK', 'US'),
('San Francisco', 'CL', 'US'),
('San Francisco', 'CM', 'US'),
('San Francisco', 'CN', 'US'),
('San Francisco', 'CO', 'US'),
('San Francisco', 'CP', 'US'),
('San Francisco', 'CQ', 'US'),
('San Francisco', 'CR', 'US'),
('San Francisco', 'CS', 'US'),
('San Francisco', 'CT', 'US'),
('San Francisco', 'CU', 'US'),
('San Francisco', 'CV', 'US'),
('San Francisco', 'CW', 'US'),
('San Francisco', 'CX', 'US'),
('San Francisco', 'CY', 'US'),
('San Francisco', 'CZ', 'US');


