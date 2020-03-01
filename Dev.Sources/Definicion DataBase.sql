-- user nerio
-- clave adminadmin

CREATE TABLE public.sabores (
	idsabor serial NOT NULL,
	sabor varchar(15) NOT NULL,
	CONSTRAINT pk_sabores PRIMARY KEY (idsabor)
);

CREATE TABLE public.usuarios (
	idusuario serial NOT NULL,
	nombre varchar(15) NOT NULL,
	apellido varchar(15) NOT NULL,
	usuario varchar(10) NOT NULL,
	clave varchar(700) NOT NULL,
	CONSTRAINT pk_usuario PRIMARY KEY (idusuario)
);

CREATE TABLE public.sorbetes (
	idsorbete serial NOT NULL,
	sorbete varchar(15) NOT NULL,
	preciounidad numeric(5,2) NOT NULL,
	idsabor int4 NOT NULL,
	CONSTRAINT pk_sorbetes PRIMARY KEY (idsorbete)
);

ALTER TABLE public.sorbetes ADD CONSTRAINT fk_sabor FOREIGN KEY (idsabor) REFERENCES sabores(idsabor);


CREATE TABLE public.ventas (
	idventa serial NOT NULL,
	cantidad int4 NOT NULL,
	total money NOT NULL,
	comprador varchar(15) NOT NULL,
	fechaventa timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	idvendedor int4 NOT NULL,
	CONSTRAINT pk_venta PRIMARY KEY (idventa)
);

ALTER TABLE public.ventas ADD CONSTRAINT fk_vendedor FOREIGN KEY (idvendedor) REFERENCES usuarios(idusuario);


CREATE TABLE public.detalle_venta (
	iddetalle serial NOT NULL,
	idsorbete int4 NOT NULL,
	cantidad int4 NOT NULL,
	preciounidad numeric(8,2) NOT NULL,
	subtotal numeric(5,2) NOT NULL,
	idventa int4 NOT NULL,
	CONSTRAINT pk_detalle PRIMARY KEY (iddetalle)
);

ALTER TABLE public.detalle_venta ADD CONSTRAINT fk_sorbete FOREIGN KEY (idsorbete) REFERENCES sorbetes(idsorbete);
ALTER TABLE public.detalle_venta ADD CONSTRAINT fk_venta FOREIGN KEY (idventa) REFERENCES ventas(idventa);


alter table ventas drop column idVendedor;
alter table usuarios drop column idusuario;
alter table usuarios add constraint pk_usuario primary key(usuario);

