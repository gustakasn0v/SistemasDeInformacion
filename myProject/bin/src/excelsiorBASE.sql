-- Script de inicialización de la base de datos
-- Sistema de Evaluación de Profesores

CREATE TABLE USUARIO (
	nombre_usuario varchar (50) NOT NULL,
	contrasenia varchar (20) NOT NULL,
	nombre varchar (50) NOT NULL,
	correo varchar (30) NOT NULL,
	cedula bigint NOT NULL,
	CONSTRAINT PK_USUARIO PRIMARY KEY (nombre_usuario)
);


CREATE TABLE DECANATO (
	nombre_usuario varchar (50) NOT NULL,
	nombre_decanato varchar (50) NOT NULL,
	CONSTRAINT PK_DECANATO PRIMARY KEY (nombre_usuario)
);

CREATE TABLE COORDINACION (
	nombre_coord varchar (50) NOT NULL UNIQUE,
	nombre_usuario varchar (50) NOT NULL,
	CONSTRAINT PK_COORDINACION PRIMARY KEY (nombre_usuario)
);

CREATE TABLE CARRERA (
	nombre_usuario varchar (50) NOT NULL,
	codigo integer NOT NULL,
	nombre_carrera varchar (50) NOT NULL,
	CONSTRAINT PK_CARRERA PRIMARY KEY (nombre_usuario, codigo)
);

CREATE TABLE PROFESOR (
	nombre_usuario varchar (50) NOT NULL,
	CONSTRAINT PK_PROFESOR PRIMARY KEY (nombre_usuario)
);

CREATE TABLE MATERIAL_APOYO (
	material varchar (200) NOT NULL,
	nombre_usuario varchar (50) NOT NULL,
	CONSTRAINT PK_MATERIAL_APOYO PRIMARY KEY (nombre_usuario,material)
);

CREATE TABLE FORMACION (
	formacion varchar (200) NOT NULL,
	nombre_usuario varchar (50) NOT NULL,
	CONSTRAINT PK_FORMACION PRIMARY KEY (formacion, nombre_usuario)
);

CREATE TABLE PROGRAMA(
	programa varchar (200) NOT NULL,
	nombre_usuario varchar (50) NOT NULL,
	CONSTRAINT PK_PROGRAMAS PRIMARY KEY (programa, nombre_usuario)
);

CREATE TABLE DEPARTAMENTO (
	nombre_dpto varchar (50) NOT NULL,
	nombre_usuario varchar (50) NOT NULL UNIQUE,
	CONSTRAINT PK_DEPARTAMENTO PRIMARY KEY (nombre_dpto)
);

CREATE TABLE ADMINISTRADOR (
	nombre_usuario varchar (50) NOT NULL,
	CONSTRAINT PK_ADMINISTRADOR PRIMARY KEY (nombre_usuario)
);

CREATE TABLE SOLICITUD (
	clave integer NOT NULL,
	estado varchar (20) NOT NULL,
	periodo varchar (20) NOT NULL,
	nombre_usuario_prof varchar (50) NOT NULL,
	nombre_usuario_dpto varchar (50) NOT NULL,
	codigo_eval integer,
	fecha_envio date NOT NULL,
	CONSTRAINT PK_SOLICITUD PRIMARY KEY (clave)
);

CREATE TABLE EVALUACION (
	codigo integer NOT NULL,
	resultado varchar (20) NOT NULL,
	queja varchar (100),
	nombre_coord varchar (50),
	fecha_emision date NOT NULL,
	CONSTRAINT PK_EVALUACION PRIMARY KEY (codigo)
);

CREATE TABLE TUTORIA (
	codigo_eval integer NOT NULL,
	tutoria varchar (200),
	CONSTRAINT PK_TUTORIA PRIMARY KEY (codigo_eval,tutoria)
);

CREATE TABLE REPORTE (
	codigo_eval integer NOT NULL,
	trimestre varchar (20) NOT NULL,
	cod_materia varchar(6) NOT NULL,
	nombre_materia varchar (30) NOT NULL,
	cant_nota_1 integer NOT NULL,
	cant_nota_2 integer NOT NULL,
	cant_nota_3 integer NOT NULL,
	cant_nota_4 integer NOT NULL,
	cant_nota_5 integer NOT NULL,
	CONSTRAINT PK_REPORTE PRIMARY KEY (codigo_eval, trimestre, nombre_materia)
);

CREATE TABLE REVISA (
	nombre_usuario varchar (30) NOT NULL,
	codigo_eval integer NOT NULL,
	CONSTRAINT PK_REVISA PRIMARY KEY (nombre_usuario, codigo_eval)
);

CREATE TABLE ATIENDE (
    nombre_usuario varchar (50) NOT NULL,
    clave integer NOT NULL,
    fecha_limite date NOT NULL,
    CONSTRAINT PK_ATIENDE PRIMARY KEY(nombre_usuario, clave)
);

-- Claves foraneas y restricciones de dominio---------------
ALTER TABLE DECANATO ADD
	CONSTRAINT FK_DECANATO_USUARIO FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario);

ALTER TABLE COORDINACION ADD
	CONSTRAINT FK_COORDINACION_USUARIO FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario);

ALTER TABLE CARRERA ADD
	CONSTRAINT FK_CARRERA_COORDINACION FOREIGN KEY (nombre_usuario) REFERENCES COORDINACION (nombre_usuario);

ALTER TABLE CARRERA ADD
	CONSTRAINT RANGO_CODIGO_CARRERA CHECK (codigo > 0);

ALTER TABLE PROFESOR ADD
	CONSTRAINT FK_PROFESOR_USUARIO FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario);

ALTER TABLE FORMACION ADD
	CONSTRAINT FK_FORMACION_PROFESOR FOREIGN KEY (nombre_usuario) REFERENCES PROFESOR (nombre_usuario);

ALTER TABLE PROGRAMA ADD
	CONSTRAINT FK_PROGRAMAS_PROFESOR FOREIGN KEY (nombre_usuario) REFERENCES PROFESOR (nombre_usuario);

ALTER TABLE MATERIAL_APOYO ADD
	CONSTRAINT FK_MATERIAL_APOYO_PROFESOR FOREIGN KEY (nombre_usuario) REFERENCES PROFESOR (nombre_usuario);

ALTER TABLE DEPARTAMENTO ADD
	CONSTRAINT FK_DEPARTAMENTO_USUARIO FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario);

ALTER TABLE ADMINISTRADOR ADD
	CONSTRAINT FK_ADMINISTRADOR_USUARIO FOREIGN KEY (nombre_usuario) REFERENCES USUARIO (nombre_usuario);

ALTER TABLE SOLICITUD ADD
	CONSTRAINT FK_SOLICITUD_PROFESOR FOREIGN KEY (nombre_usuario_prof) REFERENCES PROFESOR (nombre_usuario);

ALTER TABLE SOLICITUD ADD
	CONSTRAINT FK_SOLICITUD_EVALUACION FOREIGN KEY (codigo_eval) REFERENCES EVALUACION (codigo);

ALTER TABLE SOLICITUD ADD
	CONSTRAINT FK_SOLICITUD_DEPARTAMENTO FOREIGN KEY (nombre_usuario_dpto) REFERENCES DEPARTAMENTO (nombre_usuario);

ALTER TABLE SOLICITUD ADD
	CONSTRAINT RANGO_CLAVE_SOLICITUD CHECK (clave > 0);

ALTER TABLE SOLICITUD ADD 
	CONSTRAINT RANGO_ESTADO_SOLICITUD CHECK (estado IN ('POR ATENDER', 'ATENDIDA'));

ALTER TABLE EVALUACION ADD
	CONSTRAINT RANGO_CODIGO_EVALUACION CHECK (codigo > 0);

ALTER TABLE EVALUACION ADD 
	CONSTRAINT RANGO_RESULTADO_EVALUACION CHECK (resultado IN ('MUY SATISFACTORIA', 'SATISFACTORIA', 'SOBRESALIENTE', 'INSUFICIENTE'));

ALTER TABLE EVALUACION ADD
	CONSTRAINT FK_EVALUACION_COORDINACION FOREIGN KEY (nombre_coord) REFERENCES COORDINACION (nombre_usuario);

ALTER TABLE TUTORIA ADD
	CONSTRAINT FK_TUTORIA_EVALUACION FOREIGN KEY (codigo_eval) REFERENCES EVALUACION (codigo);

ALTER TABLE REPORTE ADD
	CONSTRAINT RANGO_CANT_NOTA_1 CHECK (cant_nota_1 >= 0);

ALTER TABLE REPORTE ADD
	CONSTRAINT RANGO_CANT_NOTA_2 CHECK (cant_nota_2 >= 0);

ALTER TABLE REPORTE ADD
	CONSTRAINT RANGO_CANT_NOTA_3 CHECK (cant_nota_3 >= 0);

ALTER TABLE REPORTE ADD
	CONSTRAINT RANGO_CANT_NOTA_4 CHECK (cant_nota_4 >= 0);

ALTER TABLE REPORTE ADD
	CONSTRAINT RANGO_CANT_NOTA_5 CHECK (cant_nota_5 >= 0);

ALTER TABLE REPORTE ADD
	CONSTRAINT FK_REPORTE_EVALUACION FOREIGN KEY (codigo_eval) REFERENCES EVALUACION (codigo);

ALTER TABLE REPORTE ADD 
	CONSTRAINT RANGO_TRIMESTRE_REPORTE CHECK (trimestre IN ('ENE-MAR', 'ABR-JUL', 'SEP-DIC', 'VERANO'));
ALTER TABLE REVISA ADD
	CONSTRAINT FK_REVISA_EVALUACION FOREIGN KEY (codigo_eval) REFERENCES EVALUACION (codigo);

ALTER TABLE REVISA ADD
    CONSTRAINT FK_REVISA_DECANATO FOREIGN KEY (nombre_usuario) REFERENCES DECANATO (nombre_usuario);

ALTER TABLE ATIENDE ADD
    CONSTRAINT FK_ATIENDE_COORDINACION FOREIGN KEY (nombre_usuario) REFERENCES COORDINACION (nombre_usuario);

ALTER TABLE ATIENDE ADD
    CONSTRAINT FK_ATIENDE_SOLICITUD FOREIGN KEY (clave) REFERENCES SOLICITUD (clave);



-- Triggers

CREATE OR REPLACE FUNCTION func_verificarClaveDecanato() RETURNS TRIGGER
AS $func_verificarClaveDecanato$

DECLARE
    
    nombre VARCHAR (50) DEFAULT NULL;        

BEGIN

    SELECT nombre_usuario INTO nombre FROM COORDINACION C 
    WHERE C.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de decanato ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM PROFESOR P 
    WHERE P.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de decanato ya existe en otro usuario.';
        RETURN NULL;

    END IF;


    SELECT nombre_usuario INTO nombre FROM ADMINISTRADOR A 
    WHERE A.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de decanato ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM DEPARTAMENTO D 
    WHERE D.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de decanato ya existe en otro usuario.';
        RETURN NULL;

    END IF;

	RETURN NEW;

END;
$func_verificarClaveDecanato$ LANGUAGE plpgsql;

CREATE TRIGGER trig_verificarClaveDecanato 
BEFORE INSERT ON DECANATO
FOR EACH ROW
EXECUTE PROCEDURE func_verificarClaveDecanato();



CREATE OR REPLACE FUNCTION func_verificarClaveCoordinacion() RETURNS TRIGGER
AS $func_verificarClaveCoordinacion$

DECLARE
    
    nombre VARCHAR (50) DEFAULT NULL;        

BEGIN

    SELECT nombre_usuario INTO nombre FROM DECANATO D 
    WHERE D.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de coordinacion ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM PROFESOR P 
    WHERE P.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de coordinacion ya existe en otro usuario.';
        RETURN NULL;

    END IF;


    SELECT nombre_usuario INTO nombre FROM ADMINISTRADOR A 
    WHERE A.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de coordinacion ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM DEPARTAMENTO D 
    WHERE D.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de coordinacion ya existe en otro usuario.';
        RETURN NULL;

    END IF;

	RETURN NEW;

END;
$func_verificarClaveCoordinacion$ LANGUAGE plpgsql;

CREATE TRIGGER trig_verificarClaveCoordinacion 
BEFORE INSERT ON COORDINACION
FOR EACH ROW
EXECUTE PROCEDURE func_verificarClaveCoordinacion();


CREATE OR REPLACE FUNCTION func_verificarClaveProfesor() RETURNS TRIGGER
AS $func_verificarClaveProfesor$

DECLARE
    
    nombre VARCHAR (50) DEFAULT NULL;        

BEGIN

    SELECT nombre_usuario INTO nombre FROM DECANATO D 
    WHERE D.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de profesor ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM COORDINACION C 
    WHERE C.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de profesor ya existe en otro usuario.';
        RETURN NULL;

    END IF;


    SELECT nombre_usuario INTO nombre FROM ADMINISTRADOR A 
    WHERE A.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de profesor ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM DEPARTAMENTO D 
    WHERE D.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de profesor ya existe en otro usuario.';
        RETURN NULL;

    END IF;

	RETURN NEW;

END;
$func_verificarClaveProfesor$ LANGUAGE plpgsql;

CREATE TRIGGER trig_verificarClaveProfesor
BEFORE INSERT ON PROFESOR
FOR EACH ROW
EXECUTE PROCEDURE func_verificarClaveProfesor();


CREATE OR REPLACE FUNCTION func_verificarClaveDepartamento() RETURNS TRIGGER
AS $func_verificarClaveDepartamento$

DECLARE
    
    nombre VARCHAR (50) DEFAULT NULL;        

BEGIN

    SELECT nombre_usuario INTO nombre FROM DECANATO D 
    WHERE D.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de departamento ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM COORDINACION C 
    WHERE C.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de departamento ya existe en otro usuario.';
        RETURN NULL;

    END IF;


    SELECT nombre_usuario INTO nombre FROM ADMINISTRADOR A 
    WHERE A.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de departamento ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM PROFESOR P 
    WHERE P.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de departamento ya existe en otro usuario.';
        RETURN NULL;

    END IF;

	RETURN NEW;

END;
$func_verificarClaveDepartamento$ LANGUAGE plpgsql;

CREATE TRIGGER trig_verificarClaveDepartamento
BEFORE INSERT ON DEPARTAMENTO
FOR EACH ROW
EXECUTE PROCEDURE func_verificarClaveDepartamento();

CREATE OR REPLACE FUNCTION func_verificarClaveAdministrador() RETURNS TRIGGER
AS $func_verificarClaveAdministrador$

DECLARE
    
    nombre VARCHAR (50) DEFAULT NULL;        

BEGIN

    SELECT nombre_usuario INTO nombre FROM DECANATO D 
    WHERE D.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de administrador ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM COORDINACION C 
    WHERE C.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de administrador ya existe en otro usuario.';
        RETURN NULL;

    END IF;


    SELECT nombre_usuario INTO nombre FROM DEPARTAMENTO D 
    WHERE D.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de administrador ya existe en otro usuario.';
        RETURN NULL;

    END IF;

    SELECT nombre_usuario INTO nombre FROM PROFESOR P 
    WHERE P.nombre_usuario = NEW.nombre_usuario;

    IF nombre IS NOT NULL THEN

        RAISE EXCEPTION 'La clave de administrador ya existe en otro usuario.';
        RETURN NULL;

    END IF;

	RETURN NEW;

END;
$func_verificarClaveAdministrador$ LANGUAGE plpgsql;

CREATE TRIGGER trig_verificarClaveAdministrador
BEFORE INSERT ON ADMINISTRADOR
FOR EACH ROW
EXECUTE PROCEDURE func_verificarClaveAdministrador();
