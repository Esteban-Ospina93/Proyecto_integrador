create database veterinaria

use veterinaria

select * from consulta

create proc insertar_consulta
@id_consulta int,
@fecha_ingreso datetime,
@motivo varchar(250),
@id_veterinario int,
@id_mascota int
as
begin
	insert into consulta(id_consulta, fecha_ingreso, motivo, id_veterinario, id_mascota)
	values(@id_consulta, @fecha_ingreso, @motivo, @id_veterinario, @id_mascota)
end

create table consulta(
id_consulta int primary key,
fecha_ingreso datetime,
motivo varchar(250),
id_veterinario int,
constraint consulta_veterinario foreign key (id_veterinario)
references veterinario(id_veterinario),
id_mascota int,
constraint consulta_mascota foreign key (id_mascota)
references mascota(id_mascota)
)

select * from propietario
insert into propietario values('Andres','Ospina Salcedo','1234567891','clle 49a #19-56','andres123@gmail.com','3117893458')
insert into propietario values('David','Ospina Salcedo','2345678912','clle 49a #19-56','david123@gmail.com','3014569870')
insert into propietario values('Santiago','Ospina Ciro','3456789123','clle 50 #20-10','santiago123@gmail.com','3235489642')
insert into propietario values('Adriana','Londoño Ortega','4567891234','clle 46b #23c-15','adriana123@gmail.com','3457896542')
insert into propietario values('Diego','Restrepo Giraldo','5678912345','clle 9 sur #13-25','diego123@gmail.com','3456789123')
update propietario set nombre_p='Andrés' where id_propietario=1 --para modificar y posicionarse en un campo el cúal cambiaremos un dato usando la clausula where

create table propietario(
id_propietario int primary key identity,
nombre_p varchar(100),
apellidos_p varchar(50),
cedula_p varchar(20) unique,
direccion_p varchar(50),
correo_p varchar(100),
tel_p bigint,
)
alter table propietario add id_usuario int
constraint propietario_loging foreign key (id_usuario)
references loging(id_usuario)

UPDATE propietario
SET id_usuario = 10
WHERE id_propietario = 5;

select * from mascota
insert into mascota values('Blue',4,'M',2)
insert into mascota values('Blue',4,'M',1)
insert into mascota values('Romeo',13,'M',3)
insert into mascota values('Atila',8,'F',5)
insert into mascota values('Kira',6,'F',4)

create table mascota(
id_mascota int primary key identity,
nombre_m varchar(20),
edad tinyint,
genero_m varchar(6),
id_propietario int,
constraint mascota_propietario foreign key (id_propietario)
references Propietario(id_propietario)
)

select * from veterinario
insert into veterinario values('Gregorio','Velasquez Gallego','7946134679','Veterinario ortopedista','Gregor123@gmail.com','3507894625')
insert into veterinario values('Daniela','Obregon Lopez','8956235689','Veterinaria cirujana','Dani123@gmail.com','3254478156')
insert into veterinario values('Camilo','Ramirez Osorio','7845124578','Veterinario Oncologo','Ramirez123@gmail.com','3459715358')
insert into veterinario values('Vanesa','Gimenez Rondon','8756215687','Veterinaria fisioterapeuta','Vane123@gmail.com','3768432481')
insert into veterinario values('Alejandro','Ciro Suaza','9856542156','Veterinaria dermatologo','Ciro123@gmail.com','3456734898')

create table veterinario(
id_veterinario int primary key identity,
nombre_v varchar(100),
apellido_v varchar(50),
cedula_v varchar(20) unique,
especialidad varchar(100),
correo_v varchar(100),
tel_v bigint,
id_usuario int,
constraint veterinario_loging foreign key (id_usuario)
references loging(id_usuario)
)

select * from sintoma

create proc insertar_sintoma
@id_sintoma int,
@descripcion varchar(500)
as
begin
	insert into sintoma(id_sintoma, descripcion)
	values(@id_sintoma, @descripcion)
end

create table sintoma(
id_sintoma int primary key,
descripcion varchar(500)
)

select * from tratamiento

create proc insertar_tratamiento
@id_tratamiento int,
@descripcion varchar(500)
as
begin
	insert into tratamiento(id_tratamiento, descripcion)
	values(@id_tratamiento, @descripcion)
end

create table tratamiento(
id_tratamiento int primary key,
descripcion varchar(500)
)

select * from medicamento

create proc insertar_medicamento
@id_medicamento int,
@nombre_med varchar(50),
@tipo_animal varchar(20),
@receta varchar(500),
@periodicidad varchar(50)
as
begin
	insert into medicamento(id_medicamento, nombre_med, tipo_animal, receta, periodicidad)
	values(@id_medicamento, @nombre_med, @tipo_animal, @receta, @periodicidad)
end

create table medicamento(
id_medicamento int primary key,
nombre_med varchar(50),
tipo_animal varchar(20),
receta varchar(500),
periodicidad varchar(50)
)

--TABLAS FUERTES

select * from consulta_sintoma

create proc insertar_consulta_sintoma
@id_consulta int,
@id_sintoma int
as
begin
	insert into consulta_sintoma(id_consulta, id_sintoma)
	values(@id_consulta, @id_sintoma)
end

create table consulta_sintoma(
id_consulta int,
id_sintoma int,
constraint cs_consulta foreign key(id_consulta) references consulta(id_consulta),
constraint cs_sintoma foreign key(id_sintoma) references sintoma(id_sintoma)
)

select * from consulta_tratamiento

create proc insertar_consulta_tratamiento
@id_consulta int,
@id_tratamiento int
as
begin
	insert into consulta_tratamiento(id_consulta, id_tratamiento)
	values(@id_consulta, @id_tratamiento)
end

create table consulta_tratamiento(
id_consulta int,
id_tratamiento int,
constraint ct_consulta foreign key(id_consulta) references consulta(id_consulta),
constraint ct_tratamiento foreign key(id_tratamiento) references tratamiento(id_tratamiento)
)

select * from tratamiento_medicamento

create proc insertar_tratamiento_medicamento
@id_tratamiento int,
@id_medicamento int
as
begin
	insert into tratamiento_medicamento(id_tratamiento, id_medicamento)
	values(@id_tratamiento, @id_medicamento)
end

create table tratamiento_medicamento(
id_tratamiento int,
id_medicamento int,
constraint tm_tratamiento foreign key(id_tratamiento) references tratamiento(id_tratamiento),
constraint tm_medicamento foreign key(id_medicamento) references medicamento(id_medicamento)
)

--FORMULARIO

create table formulario_servicios(
id_form int primary key,
nombre_f varchar(100),
correo_f varchar(100),
mensaje_f varchar(500)
)
exec sp_rename 'formulario_servicios', 'formulario'

--Loging

select * from loging

create proc insertar_datos
@id_usuario int,
@nombre_usuario varchar(50),
@contraseña_usuario varchar(100),
@rol_usuario varchar(20),
@fecha_creacion datetime
as
begin
	insert into usuario (id_usuario, nombre_usuario, contraseña_usuario, rol_usuario, fecha_creacion)
	values (@id_usuario, @nombre_usuario, @contraseña_usuario, @rol_usuario, @fecha_creacion)
end

create table loging(
id_usuario int primary key,
nombre_usuario varchar(50),
contraseña_usuario varchar(100),
rol_usuario varchar(20),
fecha_creacion datetime
)

create proc modificar_usuarios
@id_usuario int,
@nombre_usuario varchar(50),
@contraseña_usuario varchar(100),
@rol_usuario varchar(20)
as
begin
	update usuario 
	set   
        nombre_usuario = @nombre_usuario,
        contraseña_usuario = @contraseña_usuario,
        rol_usuario = @rol_usuario
    where
        id_usuario = @id_usuario;
end