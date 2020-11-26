create schema db_Banco;


use db_Banco;

create table contacto
(
	idContacto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	email VARCHAR(50),
	telefono INT
);

create table direccion
(
	idDireccion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	calle VARCHAR(50),
	altura VARCHAR(25),
	localidad VARCHAR(50), 
	provincia VARCHAR(50)
);

create table usuario(
	idUsuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	DNI VARCHAR(8),
	CUIL VARCHAR(11),
    nombre VARCHAR(50),
	apellido VARCHAR(50),
	sexo VARCHAR(24),
	nacionalidad VARCHAR(50),
	fechaNacimiento DATE,
	TipoUsuario VARCHAR(4),
	idDireccion INT,
	idContacto INT,
	nickUsuario VARCHAR(25),
	contraseña VARCHAR(25),
     estado bit,
    FOREIGN KEY (idDireccion) REFERENCES direccion(idDireccion),
    FOREIGN KEY (idContacto) REFERENCES contacto(idContacto)
);
create table cuentas
(
	idCuenta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	idTipo int,
	idUsuario INT,
	fechaCreacion DATETIME,
	CBU VARCHAR(22),
    Numerocuenta VARCHAR(13),
	saldo FLOAT,
	estado bit,
    FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario)
);
create table movimientos
(
	idMovimiento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	fecha DATETIME,
	detalle VARCHAR(30),
	idCuenta INT,
     estado bit,
     FOREIGN KEY (idCuenta) REFERENCES cuentas(idCuenta)
    );

create table prestamos
(
	idPrestamo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	idCliente INT,
	idMovimiento INT,
	importeConIntereses FLOAT,
	importePedido FLOAT,
	pagoMesual FLOAT,
    fechapedido date,
	cantidadCuotas INT,
	idCuenta INT,
	estado bit,
	FOREIGN KEY (idCuenta) REFERENCES cuentas(idCuenta)

);
create table Cuotas
(
	idCuota INT  NOT NULL AUTO_INCREMENT,
	idPrestamo INT NOT NULL,
	fechaMes varchar(10),
	importe FLOAT, 
	fechaVencimiento DATE NOT NULL,
    fechaPago DATE,
    estado int,
    PRIMARY KEY (idCuota,idPrestamo)
    
);
create table transferencias
(
	idTransferencia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	importe FLOAT,
	idMovimiento INT,
	cuentaDestino INT,
    idCuenta INT,
	estado bit,
	FOREIGN KEY (idCuenta) REFERENCES cuentas(idCuenta)

);



DELIMITER $$
	CREATE PROCEDURE SP_AgregarUsuario(
		IN Dni VARCHAR(8),
		IN Cuil VARCHAR(11),
		IN Nombre VARCHAR(50),
		IN Apellido VARCHAR(50),
		IN Sexo VARCHAR(24),
		IN Nacionalidad VARCHAR(50),
		IN Fecha DATE,
		IN  tipo VARCHAR(4),
        IN iDdireccion VARCHAR(50),
		IN iDcontacto VARCHAR(50),
		IN usuario VARCHAR(25),
        IN Contraseña VARCHAR(25),
        IN Estado bit
        )
        
	BEGIN

		INSERT INTO usuario (DNI,CUIL,nombre,apellido,sexo,nacionalidad,fechaNacimiento,TipoUsuario,idDireccion,idContacto,nickUsuario,contraseña,estado)
		values (dni,Cuil,Nombre,Apellido,Sexo,Nacionalidad,Fecha,tipo,iDdireccion,iDcontacto,usuario,Contraseña, Estado);
		
	END$$
    DELIMITER $$
	CREATE PROCEDURE SP_ModificarUsuario(
		IN IdUsuario INT,
        IN Dni VARCHAR(8),
		IN Cuil VARCHAR(11),
		IN Nombre VARCHAR(50),
		IN Apellido VARCHAR(50),
		IN Sexo VARCHAR(24),
		IN Nacionalidad VARCHAR(50),
		IN Fecha DATE,
		IN tipo INT,
        IN iDdireccion INT,
		IN iDcontacto INT,
		IN usuario VARCHAR(25),
        IN Contraseña VARCHAR(25),
        IN Estado bit
        )
        
	BEGIN

		UPDATE usuario set DNI = Dni, CUIL = Cuil, nombre = Nombre, apellido = Apellido, sexo = Sexo, nacionalidad = Nacionalidad,
        fechaNacimiento = Fecha, TipoUsuario = tipo, idDireccion = iDdireccion, idContacto = iDcontacto, nickUsuario = usuario,
        contraseña = Contraseña, estado = Estado
		where idUsuario = IdUsuario;
		
	END$$
DELIMITER $$
    CREATE PROCEDURE SP_EliminarUsuario(
        IN IdUsuario int
		)
    
	BEGIN
	UPDATE usuario as u set estado = 0 where u.idUsuario = IdUsuario;
END$$
CREATE PROCEDURE SP_ListarClientes(
        
		)

	BEGIN
	
	select u.idUsuario, u.nombre, u.apellido,u.nickUsuario, u.DNI, u.CUIL,
	u.sexo, u.nacionalidad, u.fechaNacimiento, d.calle, d.altura, d.localidad, d.provincia, c.email, c.telefono  from usuario as u
	inner join direccion as d on d.idDireccion=u.idDireccion
	inner join contacto as c on c.idContacto = u.idContacto
	where u.estado = 1;
    END$$
DELIMITER $$
    CREATE PROCEDURE SP_BuscarUsuario(
        IN dni VARCHAR(25)
		)
    
	BEGIN
	
	select  u.idUsuario,u.nombre, u.apellido,u.nickUsuario, u.DNI, u.CUIL,
	u.sexo, u.nacionalidad, u.fechaNacimiento, d.calle, d.altura, d.localidad, d.provincia, c.email, c.telefono  from usuario as u
	inner join direccion as d on d.idDireccion=u.idDireccion
	inner join contacto as c on c.idContacto = u.idContacto
	where u.DNI = dni;
END$$
DELIMITER $$
    CREATE PROCEDURE SP_BuscarUsuarioxId(
        IN IdUsuario VARCHAR(25)
		)
    
	BEGIN
	
	select  u.idUsuario, u.nombre, u.apellido, u.nickUsuario, u.DNI, u.CUIL,
	u.sexo, u.nacionalidad, u.fechaNacimiento, d.calle, d.altura, d.localidad, d.provincia, c.email, c.telefono  from usuario as u
	inner join direccion as d on d.idDireccion=u.idDireccion
	inner join contacto as c on c.idContacto = u.idContacto
	where u.idUsuario = IdUsuario;
END$$
	DELIMITER $$
    CREATE PROCEDURE SP_AgregarContacto (
    
		IN Email VARCHAR(50),
		IN Telefono VARCHAR(25)
)
 BEGIN
	INSERT INTO  contacto(email ,telefono)
    values( Email ,Telefono);
END$$

DELIMITER $$
CREATE PROCEDURE SP_AgregarDireccion  (

		IN Calle VARCHAR(50),
		IN Altura VARCHAR(25),
		IN Localidad VARCHAR(50), 
		IN Provincia VARCHAR(50)
        
)
 BEGIN
	INSERT INTO  direccion(calle ,altura ,localidad ,provincia)
    values (Calle, Altura , Localidad ,Provincia);
END$$

DELIMITER $$
    CREATE PROCEDURE SP_BuscarDireccion()
    
	BEGIN
	
	select idDireccion  from direccion  order by idDireccion desc limit 1;
END$$

DELIMITER $$
    CREATE PROCEDURE SP_BuscarContacto()
    
	BEGIN
	
	select idContacto  from contacto order by idContacto desc limit 1;
END$$

DELIMITER $$
	CREATE PROCEDURE SP_AltaCuenta(

		IN Tipo INT,
		IN IdUsuario INT,
		IN cbu VARCHAR(22),
        IN numeroCuenta VARCHAR(13),
		IN Saldo FLOAT,
		IN FechaCreacion DATE,		
		IN Estado BIT

        )
        
	BEGIN
		INSERT INTO cuentas(idtipo, idUsuario, CBU,Numerocuenta, saldo, fechaCreacion, estado)
		values (Tipo, IdUsuario, cbu,numeroCuenta, Saldo, FechaCreacion, Estado);
	END$$
DELIMITER $$
CREATE PROCEDURE SP_ListarCuentas()
BEGIN
		select  c.idTipo, c.idUsuario, c.Numerocuenta, c.CBU, c.saldo , c.fechaCreacion,c.idCuenta, u.nombre, u.apellido,u.DNI from cuentas as c
		inner join usuario as u on u.idUsuario = c.idUsuario
where c.Estado = 1;
   END$$
   DELIMITER $$
       CREATE PROCEDURE SP_EliminarCuenta(
       IN idcuenta int
)
BEGIN
UPDATE cuentas as c set estado = 0 where c.idCuenta = Idcuenta;
END$$
DELIMITER $$
    CREATE PROCEDURE SP_BuscarCuenta(
        IN numerocuenta VARCHAR(25)
		)
    
	BEGIN
	
	Select * from cuentas as c
	where  c.Numerocuenta  =  numerocuenta;
END$$
DELIMITER $$
	CREATE PROCEDURE SP_ModificarCuenta(
		IN idcuenta INT,
        IN Tipo INT,
		IN IdUsuario INT,
		IN cbu VARCHAR(22),
        IN numeroCuenta VARCHAR(13),
		IN Saldo FLOAT,
		IN FechaCreacion DATE,		
		IN Estado BIT
        )
        
	BEGIN

		UPDATE cuentas set idtipo =Tipo, idUsuario = IdUsuario, CBU =cbu, Numerocuenta = numeroCuenta, saldo = Saldo, fechaCreacion = FechaCreacion,estado = Estado
		where IdCuenta = idCuenta;
		
	END$$
    DELIMITER $$
    CREATE PROCEDURE SP_BuscarCuentaxId(
        IN Idcuenta INT
		)
    
	BEGIN
	select cu.idCuenta, cu.idTipo, cu.idUsuario, cu.CBU, cu.Numerocuenta, cu.saldo, cu.fechaCreacion, u.idUsuario, u.idDireccion,
    u.nombre, u.apellido, u.nickUsuario, u.idContacto, u.DNI, u.CUIL, u.sexo, u.nacionalidad, u.fechaNacimiento, u.estado,
    d.calle, d.altura, d.localidad, d.provincia, c.email, c.telefono  from cuentas as cu
    inner join usuario as u on u.idUsuario = cu.idUsuario
    inner join contacto as c on u.idContacto = c.idContacto
    inner join direccion as d on u.idDireccion = d.idDireccion
	where cu.idCuenta = idcuenta;
END$$
DELIMITER $$
CREATE PROCEDURE SP_ListarCuentasXId(
	IN IdUsuario INT
)
BEGIN
		select  c.idTipo, c.idUsuario, c.Numerocuenta, c.CBU, c.saldo , c.fechaCreacion,c.idCuenta, u.nombre, u.apellido,u.DNI from cuentas as c
		inner join usuario as u on u.idUsuario = c.idUsuario
		where u.idUsuario = IdUsuario;
   END$$
   DELIMITER $$
    CREATE PROCEDURE SP_BuscarUsuarioxNick(
        IN Nick VARCHAR(25)
		)
    
	BEGIN
	
	select  u.idUsuario, u.nombre,u.TipoUsuario, u.apellido, u.nickUsuario,u.Contraseña, u.DNI, u.CUIL,
	u.sexo, u.nacionalidad, u.fechaNacimiento, d.calle, d.altura, d.localidad, d.provincia, c.email, c.telefono  from usuario as u
	inner join direccion as d on d.idDireccion=u.idDireccion
	inner join contacto as c on c.idContacto = u.idContacto
	where u.nickUsuario = Nick;
END$$
 DELIMITER $$
       CREATE PROCEDURE SP_AltaPrestamo(
       
       IN IDCliente int,
       IN IDMovimiento int,
       IN importeIntereses float,
       IN ImportePedido float,
       IN PagoMesual float,
       IN Fechapedido date,
       IN CantidadCuotas int,
       IN IDCuenta int,
       IN Estado int
      
)
BEGIN
INSERT prestamos (idPrestamo,idCliente,idMovimiento,importeConIntereses,importePedido,pagoMesual,fechapedido,cantidadCuotas,idCuenta,estado)
values(IDPrestamo,IDCliente,IDMovimiento,importeIntereses,ImportePedido,PagoMesual,Fechapedido,CantidadCuotas,IDCuenta,Estado);
END$$
DELIMITER $$
       CREATE PROCEDURE SP_ModificarPrestamo(
       IN IDPrestamo int,
       IN Estado int
)
BEGIN
UPDATE prestamos set estado = Estado where idPrestamo = IDPrestamo;
END$$
DELIMITER $$
       CREATE PROCEDURE SP_AltaMovimiento(
       IN IdMovimiento int,
       IN Fecha DATE,
       IN Detalle VARCHAR(30),
       IN IDCuenta int,
       IN Estado int
	
)
BEGIN
INSERT prestamos (idMovimiento,fecha,detalle,idCuenta,estado)
values(IdMovimiento,Fecha,Detalle,IDCuenta,Estado);
END$$
DELIMITER $$
CREATE PROCEDURE SP_ListarPrestamos()
BEGIN
		select p.idPrestamo,p.idCliente,p.idMovimiento,p.importeConIntereses,p.importePedido,p.pagoMesual,p.fechapedido,p.cantidadCuotas,p.idCuenta,p.estado,u.DNI from prestamos as p
        inner join usuario as u;
END$$
DELIMITER $$
    CREATE PROCEDURE SP_BuscarPrestamoxId(
        IN Idprestamo INT
		)
    
	BEGIN
	select p.idPrestamo,p.idCliente,p.idMovimiento,p.importeConIntereses,p.importePedido,p.pagoMesual,p.fechapedido,p.cantidadCuotas,p.idCuenta,p.estado,u.DNI,u.nombre,u.apellido,c.Numerocuenta from prestamos as p
	inner join usuario as u
    inner join cuentas as c
	where p.idPrestamo = Idprestamo;
  END$$