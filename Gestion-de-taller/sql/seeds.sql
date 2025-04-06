CREATE TABLE clientes(
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(50)NOT NULL,
    dni VARCHAR(15) NOT NULL,
    telefono INT NOT NULL
);

CREATE TABLE empleados(
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(30)NOT NULL,
    dni VARCHAR(15) NOT NULL,
    puesto VARCHAR(20)NOT NULL,
    salario DEC(10.2)NOT NULL CHECK (salario > 0) 
);

CREATE TABLE vehiculos (
    id_vehiculo INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(15) NOT NULL,
    marca VARCHAR(10) NOT NULL,
    modelo VARCHAR(10) NOT NULL,
    año INT NOT NULL,
    km INT NOT NULL,
    nBastidor VARCHAR(30) NOT NULL,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE servicios(
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(150) NOT NULL,
    precio DEC(10.2) NOT NULL,
    horas INT NOT NULL
);

CREATE TABLE citas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha VARCHAR(20),
    hora VARCHAR(10),
    clienteDni VARCHAR(20),
    vehiculoMatricula VARCHAR(20),
    descripcion VARCHAR(255),
    estado VARCHAR(20) DEFAULT 'pendiente'
);

CREATE TABLE proveedores(
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    telefono INT NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE inventario(
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(20) NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DEC(10.2)NOT NULL CHECK(precio_unitario > 0),
    id_proveedor INT NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

--TABLAS CREADAS HASTA AQUI


