INSERT INTO clientes (nombre, apellido, dni, telefono) VALUES
('Juan', 'Pérez', '12345678', 123456789),
('Ana', 'Gómez', '87654321', 987654321),
('Luis', 'Martínez', '11223344', 456789123),
('María', 'López', '44332211', 321654987),
('Pedro', 'Sánchez', '55667788', 789123456);

INSERT INTO empleados (nombre, apellido, dni, puesto, salario) VALUES
('Carlos', 'Ramírez', '12345678', 'Mecánico', 2500.00),
('Laura', 'Fernández', '87654321', 'Recepcionista', 2000.00),
('Javier', 'García', '11223344', 'Vendedor', 2200.00),
('Sofía', 'Martín', '44332211', 'Contable', 2400.00),
('Diego', 'Hernández', '55667788', 'Gerente', 3000.00);

INSERT INTO vehiculos (matricula, marca, modelo, año, km, nBastidor) VALUES
('ABC1234', 'Toyota', 'Corolla', 2020, 15000, '1HGBH41JXMN109186'),
('XYZ5678', 'Honda', 'Civic', 2019, 20000, '2HGEJ661XKH123456'),
('LMN9101', 'Ford', 'Focus', 2021, 5000, '3FAFP313X6R123456'),
('QRS2345', 'Chevrolet', 'Cruze', 2018, 30000, '1G1BE5SM7J7112345'),
('TUV6789', 'Nissan', 'Sentra', 2022, 1000, '1N4AL3AP7CC123456');

SELECT * FROM vehiculos;
DROP TABLE empleados;
SHOW tables;