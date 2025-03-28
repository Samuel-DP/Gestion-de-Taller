CREATE TABLE clientes(
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(50)NOT NULL,
    dni VARCHAR(15) NOT NULL,
    telefono INT NOT NULL
);

CREATE TABLE vehiculos(
    id_vehiculo INT PRIMARY KEY,
    matricula VARCHAR(15) NOT NULL,
    marca VARCHAR(10) NOT NULL,
    modelo VARCHAR(10),
    año INT,
    kilometros INT,
    num_bastidor VARCHAR(30) NOT NULL
);

CREATE TABLE servicios(
    id_servicio INT PRIMARY KEY,
    descripcion VARCHAR(150) NOT NULL,
    precio DEC(10.2) NOT NULL,
    horas INT NOT NULL
);

CREATE TABLE empleados(
    id_empleado INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(30)NOT NULL,
    dni VARCHAR(15) NOT NULL,
    puesto VARCHAR(20)NOT NULL,
    salario DEC(10.2)NOT NULL CHECK (salario > 0) 
);

CREATE TABLE inventario(
    id_producto INT PRIMARY KEY,
    nombre_producto VARCHAR(20) NOT NULL,
    cantidad INT NOT NULL,
    precio DEC(10.2)NOT NULL CHECK(PRECIO > 0),
    id_proveedor INT NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

CREATE TABLE proveedores(
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(50),
    telefono INT,
    email VARCHAR(100),
    cif VARCHAR(20)
);

CREATE TABLE asignaciones(
    id_asignaciones INT PRIMARY KEY,
    id_servicio INT NOT NULL,
    id_empleado INT NOT NULL,
    id_vehiculo INT NOT NULL,
    estado VARCHAR(20) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL
    FOREIGN KEY(id_servicio) REFERENCES servicios(id_servicio),
    FOREIGN KEY(id_empleado) REFERENCES empleados(id_empleado),
    FOREIGN KEY(id_vehiculo) REFERENCES vehiculos(id_vehiculo)
);

CREATE TABLE pedidos(
    id_pedido INT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    fecha_pedido DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    precio DEC(10.2) NOT NULL CHECK(precio > 0)
    FOREIGN KEY(id_proveedor) REFERENCES proveedores(id_proveedor)
);

CREATE TABLE citas(
    id_cita INT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_vehiculo INT NOT NULL,
    fecha_cita DATE NOT NULL,
    descripcion_cita VARCHAR(50) NOT NULL,
    estado_cita VARCHAR(20),
    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente)
);

