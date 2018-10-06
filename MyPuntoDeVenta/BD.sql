CREATE DATABASE Multum;

USE Multum;

CREATE TABLE Usuario (
  ID_Usuario INT NOT NULL AUTO_INCREMENT,
  Login VARCHAR(20) NOT NULL,
  Contrasena BLOB NOT NULL,
  NombreUsuario VARCHAR(40) NOT NULL,
  TelefonoUsuario VARCHAR(10),
  TipoUsuario VARCHAR(13) NOT NULL,
  EmailUsuario VARCHAR(40),
  PRIMARY KEY(ID_Usuario)
);

CREATE TABLE Producto (
  ID_Producto INT NOT NULL AUTO_INCREMENT,
  NombreProducto VARCHAR(40) NOT NULL,
  ExistenciaProducto INT,
  Categoria VARCHAR(20),
  TipoProducto VARCHAR(20),
  FechaCaducidad DATE,
  PrecioProducto DOUBLE NOT NULL,
  PRIMARY KEY(ID_Producto)
);

CREATE TABLE Cliente (
  ID_Cliente INT NOT NULL AUTO_INCREMENT,
  NombreCliente VARCHAR(40) NOT NULL,
  TelefonoCliente VARCHAR(10) NOT NULL,
  Saldo DOUBLE NOT NULL,
  PRIMARY KEY(ID_Cliente)
);

CREATE TABLE DetalleVenta (
  ID_Venta INT NOT NULL AUTO_INCREMENT,
  ID_Usuario INT,
  ID_Cliente INT,
  FechaVenta DATE,
  TotalVenta DOUBLE,
  PRIMARY KEY(ID_Venta),
  FOREIGN KEY(ID_Cliente) REFERENCES Cliente(ID_Cliente),
  FOREIGN KEY(ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

CREATE TABLE Proveedor (
  ID_Proveedor INT NOT NULL AUTO_INCREMENT,
  NombreProveedor VARCHAR(40) NOT NULL,
  TelefonoProveedor VARCHAR(10),
  DireccionProveedor VARCHAR(60),
  EmailProveedor VARCHAR(40),
  Deuda DOUBLE,
  PRIMARY KEY(ID_Proveedor)
);

CREATE TABLE DetalleCompra (
  ID_Compra INT NOT NULL AUTO_INCREMENT,
  ID_Usuario INT,
  ID_Proveedor INT,
  FechaCompra DATE,
  TotalCompra DOUBLE,
  PRIMARY KEY(ID_Compra),
  FOREIGN KEY(ID_Usuario) REFERENCES Usuario(ID_Usuario),
  FOREIGN KEY(ID_Proveedor) REFERENCES Proveedor(ID_Proveedor)
);

CREATE TABLE Pago (
  ID_Pago INT NOT NULL AUTO_INCREMENT,
  ID_Cliente INT NOT NULL,
  ID_Usuario INT,
  FechaPago DATE,
  Monto DOUBLE NOT NULL,
  PRIMARY KEY(ID_Pago),
  FOREIGN KEY(ID_Cliente) REFERENCES Cliente(ID_Cliente),
  FOREIGN KEY(ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

CREATE TABLE Venta (
  ID_Venta INT NOT NULL,
  ID_Producto INT NOT NULL,
  CatidadVenta INT NOT NULL,
  SubtotalVenta DOUBLE NOT NULL,
  PRIMARY KEY(ID_Venta, ID_Producto),
  FOREIGN KEY(ID_Venta) REFERENCES DetalleVenta(ID_Venta),
  FOREIGN KEY(ID_Producto) REFERENCES Producto(ID_Producto)
);

CREATE TABLE Compra (
  ID_Compra INT NOT NULL,
  ID_Producto INT NOT NULL,
  CantidadCompra INT NOT NULL,
  SubtotalCompra DOUBLE NOT NULL,
  PRIMARY KEY(ID_Compra, ID_Producto),
  FOREIGN KEY(ID_Compra) REFERENCES DetalleCompra(ID_Compra),
  FOREIGN KEY(ID_Producto) REFERENCES Producto(ID_Producto)
);
