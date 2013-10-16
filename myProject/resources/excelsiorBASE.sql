-- Script de inicialización de la base de datos
-- Sistema de Evaluación de Profesores

CREATE TABLE USUARIO (
   nombre_usuario    varchar(20) NOT NULL,
   contrasenia       varchar(20) NOT NULL,
   nombre            varchar(20) NOT NULL,
   CONSTRAINT PK_USUARIO PRIMARY KEY (nombre_usuario)
);

CREATE TABLE ADMINISTRADOR (
   nombre_usuario    varchar(20) NOT NULL,
   CONSTRAINT PK_ADMINISTRADOR PRIMARY KEY (nombre_usuario)
);

CREATE TABLE DECANATO (
   nombre_dcnto      varchar(50) NOT NULL,
   CONSTRAINT PK_DECANATO PRIMARY KEY (nombre_dcnto)
);

CREATE TABLE DECANO (
   nombre_usuario    varchar(20) NOT NULL,
   nombre_dcnto      varchar(50) NOT NULL,
   CONSTRAINT PK_DECANO PRIMARY KEY (nombre_usuario)
);

CREATE TABLE COORDINACION (
   nombre_coord      varchar(50) NOT NULL,
   CONSTRAINT PK_COORDINACION PRIMARY KEY (nombre_coord)
);

CREATE TABLE COORDINADOR (
   nombre_usuario    varchar(20) NOT NULL,
   nombre_coord      varchar(50) NOT NULL,
   CONSTRAINT PK_COORDINADOR PRIMARY KEY (nombre_usuario)
);

CREATE TABLE DEPARTAMENTO (
   nombre_dpto       varchar(50) NOT NULL,
   CONSTRAINT PK_DEPARTAMENTO PRIMARY KEY (nombre_dpto)
);

CREATE TABLE JEFE_DPTO (
   nombre_usuario    varchar(20) NOT NULL,
   nombre_dpto       varchar(50) NOT NULL,
   CONSTRAINT PK_JEFE_DPTO PRIMARY KEY (nombre_usuario)
);

CREATE TABLE PROFESOR (
   nombre_usuario    varchar(20) NOT NULL,
   nivel             varchar(20) NOT NULL,
   CONSTRAINT PK_PROFESOR PRIMARY KEY (nombre_usuario)
);

CREATE TABLE CARRERA (
   codigo_carrera    numeric     NOT NULL,
   nombre_carrera    varchar(30) NOT NULL,
   nombre_dcnto      varchar(50) NOT NULL,
   nombre_coord      varchar(50) NOT NULL,
   CONSTRAINT PK_CARRERA PRIMARY KEY (codigo_carrera)
);

CREATE TABLE MATERIA (
   materia_id        bigint not null,
   codigo_materia    varchar(6)  UNIQUE NOT NULL,
   nombre_materia    varchar(30) NOT NULL,
   CONSTRAINT PK_MATERIA PRIMARY KEY (materia_id)
);

CREATE TABLE MATERIAL_APOYO (
   material_id       bigint,
   titulo_material   varchar(100) NOT NULL,
   revisor           varchar(30)  NOT NULL,
   archivo           varchar(100)  NOT NULL, 
   CONSTRAINT PK_MATERIAL_APOYO PRIMARY KEY (material_id)
);

CREATE TABLE SOLICITUD (
   codigo_solicitud     varchar(10) NOT NULL,
   periodo              date        NOT NULL,
   jubilacion           boolean     NOT NULL,
   nombre_usuario_prof  varchar(20) NOT NULL,
   nombre_usuario_jefe  varchar(20) NOT NULL,
   fecha_envio          date        NOT NULL,
   CONSTRAINT PK_SOLICITUD PRIMARY KEY (codigo_solicitud)
);

CREATE TABLE EVALUACION (
   codigo_eval             varchar(10)  NOT NULL,
   queja                   varchar(100) NOT NULL,
   resultado               varchar(20)  NOT NULL,
   codigo_solicitud        varchar(10)  NOT NULL,
   nombre_usuario_coord    varchar(20)  NOT NULL,
   fecha_emision           date         NOT NULL,
   CONSTRAINT PK_EVALUACION PRIMARY KEY (codigo_eval)
);

CREATE TABLE TUTORIA (
--   tutoria_id           bigint         NOT NULL,
   titulo_tutoria       varchar(50)    NOT NULL,
--    fecha_inic           date           NOT NULL,
--    fecha_fin            date           NOT NULL,
   codigo_carrera       NUMERIC        NOT NULL,
   nombre_usuario_prof  varchar(20)    NOT NULL,
   tipo_tutoria         varchar(20)    NOT NULL, --Coop Larga, Coop Corta o Proyecto de Grado.
   nombre_estudiante    varchar(30)    NOT NULL,
   CONSTRAINT PK_TUTORIA PRIMARY KEY (titulo_tutoria)
);

-- Vamos a ignorar que el proyecto de grado puede tener varios estudiantes
-- CREATE TABLE CURSO_COOP (
--    titulo_tutoria       varchar(50)    NOT NULL,
--    nombre_estudiante    varchar(30)    NOT NULL,
--    duracion             varchar(5)     NOT NULL,
--    CONSTRAINT PK_CURSO_COOP PRIMARY KEY (titulo_tutoria)
-- );
-- 
-- CREATE TABLE PROYECTO_GRADO (
--    titulo_tutoria       varchar(50)    NOT NULL,
--    CONSTRAINT PK_PROYECTO_GRADO PRIMARY KEY (titulo_tutoria)
-- );

-- CREATE TABLE ESTUDIANTE (
--    titulo_tutoria       varchar(50)    NOT NULL,
--    nombre_estudiante    varchar(30)    NOT NULL,
--    CONSTRAINT PK_ESTUDIANTE PRIMARY KEY (titulo_tutoria, nombre_estudiante)
-- );

CREATE TABLE FORMACION (
   formacion_id         bigint         NOT NULL,
   nombre_usuario_prof  varchar(20)    NOT NULL,
   nombre_formacion     varchar(50)    NOT NULL,
   institucion          varchar(50)    NOT NULL,
   tipo_formacion       varchar(6)     NOT NULL,
   CONSTRAINT PK_FORMACION PRIMARY KEY (nombre_usuario_prof, nombre_formacion)
);

CREATE TABLE ACTIV_ACADEM_ADMIN (
   nombre_usuario_prof  varchar(20)    NOT NULL,
   cargo                varchar(20)    NOT NULL,
   fecha_inic           date           NOT NULL,
   fecha_fin            date           NOT NULL,
   CONSTRAINT PK_ACTIV_ACADEM_ADMIN PRIMARY KEY (nombre_usuario_prof, cargo, 
         fecha_inic)
);

CREATE TABLE OTRA_ACTIVIDAD (
   nombre_usuario_prof  varchar(10)    NOT NULL,
   nombre_actividad     varchar(30)    NOT NULL,
   fecha_inic           date           NOT NULL,
   fecha_fin            date           NOT NULL,
   CONSTRAINT PK_OTRA_ACTIVDAD PRIMARY KEY (nombre_usuario_prof, 
         nombre_actividad)
);

CREATE TABLE REVISA (
   nombre_usuario_decano   varchar(20) NOT NULL,
   codigo_eval             varchar(10) NOT NULL,
   CONSTRAINT PK_REVISA PRIMARY KEY (codigo_eval)
);

CREATE TABLE COMPUESTA_POR (
   codigo_carrera    numeric     NOT NULL,
   materia_id    bigint  NOT NULL,
   CONSTRAINT PK_COMPUESTA_POR PRIMARY KEY (codigo_carrera, materia_id)
);

CREATE TABLE MODIFICA (
   nombre_usuario_prof  varchar(20) NOT NULL,
   materia_id       bigint  NOT NULL,
   CONSTRAINT PK_MODIFICA PRIMARY KEY (nombre_usuario_prof, materia_id)
);

CREATE TABLE UTILIZADO_POR (
   material_id       bigint         NOT NULL,
   materia_id        bigint     NOT NULL,
   CONSTRAINT PK_UTILIZADO_POR PRIMARY KEY (material_id, materia_id)
);

CREATE TABLE REALIZADO_POR (
   material_id          bigint         NOT NULL,
   nombre_usuario_prof  varchar(20)    NOT NULL,
   CONSTRAINT PK_REALIZADO_POR PRIMARY KEY (material_id, 
         nombre_usuario_prof)
);

CREATE TABLE DICTA (
   codigo_materia   varchar(6)         NOT NULL,
   nombre_usuario_prof  varchar(20)    NOT NULL,
   trimestre            varchar(10)    NOT NULL,
   cant_nota_1          integer        NOT NULL,
   cant_nota_2          integer        NOT NULL,
   cant_nota_3          integer        NOT NULL,
   cant_nota_4          integer        NOT NULL,
   cant_nota_5          integer        NOT NULL,
   cant_retirados       integer        NOT NULL,
   CONSTRAINT PK_DICTA PRIMARY KEY (nombre_usuario_prof, codigo_materia,
         trimestre)
);

ALTER TABLE ADMINISTRADOR 
   ADD CONSTRAINT FK_ADMINISTRADOR_USUARIO FOREIGN KEY (nombre_usuario) 
      REFERENCES USUARIO (nombre_usuario);

ALTER TABLE DECANO
   ADD CONSTRAINT FK_DECANO_USUARIO FOREIGN KEY (nombre_usuario)
      REFERENCES USUARIO (nombre_usuario),
   ADD CONSTRAINT FK_DECANO_DECANATO FOREIGN KEY (nombre_dcnto)
      REFERENCES DECANATO (nombre_dcnto);

ALTER TABLE COORDINADOR
   ADD CONSTRAINT FK_COORDINADOR_USUARIO FOREIGN KEY (nombre_usuario)
      REFERENCES USUARIO (nombre_usuario),
   ADD CONSTRAINT FK_COORDINADOR_COORDINACION FOREIGN KEY (nombre_coord)
      REFERENCES COORDINACION (nombre_coord);

ALTER TABLE JEFE_DPTO 
   ADD CONSTRAINT FK_JEFE_DPTO_USUARIO FOREIGN KEY(nombre_usuario)
      REFERENCES USUARIO (nombre_usuario),
   ADD CONSTRAINT FK_JEFE_DPTO_DEPARTAMENTO FOREIGN KEY(nombre_dpto)
      REFERENCES DEPARTAMENTO (nombre_dpto);

ALTER TABLE PROFESOR
   ADD CONSTRAINT FK_PROFESOR_USUARIO FOREIGN KEY(nombre_usuario)
      REFERENCES USUARIO (nombre_usuario);

ALTER TABLE CARRERA
   ADD CONSTRAINT FK_CARRERA_DECANATO FOREIGN KEY(nombre_dcnto)
      REFERENCES DECANATO (nombre_dcnto),
   ADD CONSTRAINT FK_CARRERA_CARRERA FOREIGN KEY(nombre_coord)
      REFERENCES COORDINACION (nombre_coord),
   ADD CONSTRAINT DOM_CODIGO_CARRERA CHECK (codigo_carrera > 0);

-- ALTER TABLE MATERIA ADD CONSTRAINT FK_MATERIA_DEPARTAMENTO FOREIGN KEY(nombre_dpto)REFERENCES DEPARTAMENTO (nombre_dpto);

ALTER TABLE SOLICITUD
   ADD CONSTRAINT FK_SOLICITUD_PROFESOR FOREIGN KEY(nombre_usuario_prof)
      REFERENCES PROFESOR (nombre_usuario),
   ADD CONSTRAINT FK_SOLICITUD_JEFE_DPTO FOREIGN KEY(nombre_usuario_jefe)
      REFERENCES JEFE_DPTO (nombre_usuario);

ALTER TABLE EVALUACION
   ADD CONSTRAINT FK_EVALUACION_SOLICITUD FOREIGN KEY(codigo_solicitud)
      REFERENCES SOLICITUD (codigo_solicitud),
   ADD CONSTRAINT FK_EVALUACION_COORDINADOR FOREIGN KEY(nombre_usuario_coord)
      REFERENCES COORDINADOR (nombre_usuario);

ALTER TABLE TUTORIA
   ADD CONSTRAINT FK_TUTORIA_CARRERA FOREIGN KEY(codigo_carrera)
      REFERENCES CARRERA (codigo_carrera),
   ADD CONSTRAINT FK_TUTORIA_PROFESOR FOREIGN KEY(nombre_usuario_prof)
      REFERENCES PROFESOR (nombre_usuario);
--   ADD CONSTRAINT TUTORIA_FECHAS CHECK (fecha_inic < fecha_fin);

-- ALTER TABLE CURSO_COOP 
--    ADD CONSTRAINT FK_CURSO_COOP_TUTORIA FOREIGN KEY(titulo_tutoria)
--       REFERENCES TUTORIA (titulo_tutoria);
--  
-- ALTER TABLE PROYECTO_GRADO 
--    ADD CONSTRAINT FK_PROYECTO_GRADO_TUTORIA FOREIGN KEY(titulo_tutoria)
--       REFERENCES TUTORIA (titulo_tutoria);
-- 
-- ALTER TABLE ESTUDIANTE
--    ADD CONSTRAINT FK_ESTUDIANTE_PROYECTO_GRADO FOREIGN KEY(titulo_tutoria)
--       REFERENCES PROYECTO_GRADO (titulo_tutoria);

ALTER TABLE FORMACION
   ADD CONSTRAINT FK_FORMACION_PROFESOR FOREIGN KEY(nombre_usuario_prof)
      REFERENCES PROFESOR (nombre_usuario);

ALTER TABLE ACTIV_ACADEM_ADMIN
   ADD CONSTRAINT FK_ACTIV_ACADEM_ADMIN FOREIGN KEY(nombre_usuario_prof)
      REFERENCES PROFESOR (nombre_usuario),
   ADD CONSTRAINT ACTIV_ACADEM_ADMIN_FECHAS CHECK (fecha_inic < fecha_fin);

ALTER TABLE OTRA_ACTIVIDAD
   ADD CONSTRAINT FK_OTRA_ACTIVIDAD_PROFESOR FOREIGN KEY(nombre_usuario_prof)
      REFERENCES PROFESOR (nombre_usuario),
   ADD CONSTRAINT OTRA_ACTIVIDAD_FECHAS CHECK (fecha_inic < fecha_fin);

ALTER TABLE REVISA 
   ADD CONSTRAINT FK_REVISA_DECANO FOREIGN KEY(nombre_usuario_decano)
      REFERENCES DECANO (nombre_usuario),
   ADD CONSTRAINT FK_REVISA_EVALUACION FOREIGN KEY(codigo_eval)
      REFERENCES EVALUACION (codigo_eval);

ALTER TABLE COMPUESTA_POR 
   ADD CONSTRAINT FK_COMPUESTA_POR_CARRERA FOREIGN KEY(codigo_carrera)
      REFERENCES CARRERA (codigo_carrera),
   ADD CONSTRAINT FK_COMPUESTA_POR_MATERIA FOREIGN KEY(materia_id)
      REFERENCES MATERIA (materia_id);

ALTER TABLE MODIFICA
   ADD CONSTRAINT FK_MODIFICA_PROFESOR FOREIGN KEY(nombre_usuario_prof)
      REFERENCES PROFESOR (nombre_usuario);

ALTER TABLE MODIFICA 
   ADD CONSTRAINT FK_MODIFICA_MATERIA FOREIGN KEY(materia_id) REFERENCES MATERIA (materia_id);

ALTER TABLE UTILIZADO_POR
   ADD CONSTRAINT FK_UTILIZADO_POR_MATERIAL_APOYO FOREIGN KEY(material_id)
      REFERENCES MATERIAL_APOYO (material_id),
   ADD CONSTRAINT FK_UTILIZADO_POR_MATERIA FOREIGN KEY(materia_id)
      REFERENCES MATERIA (materia_id);

ALTER TABLE REALIZADO_POR
   ADD CONSTRAINT FK_REALIZADO_POR_MATERIAL_APOYO FOREIGN KEY(material_id)
      REFERENCES MATERIAL_APOYO (material_id),
   ADD CONSTRAINT FK_REALIZADO_PROFESOR FOREIGN KEY(nombre_usuario_prof)
      REFERENCES PROFESOR (nombre_usuario);

ALTER TABLE DICTA
   ADD CONSTRAINT FK_DICTA_PROFESOR FOREIGN KEY(nombre_usuario_prof)
      REFERENCES PROFESOR (nombre_usuario),
   ADD CONSTRAINT FK_DICTA_MATERIA FOREIGN KEY(codigo_materia)
      REFERENCES MATERIA (codigo_materia),
   ADD CONSTRAINT DOM_DICTA_CANT_NOTA_1 CHECK (cant_nota_1 >= 0),
   ADD CONSTRAINT DOM_DICTA_CANT_NOTA_2 CHECK (cant_nota_2 >= 0),
   ADD CONSTRAINT DOM_DICTA_CANT_NOTA_3 CHECK (cant_nota_3 >= 0),
   ADD CONSTRAINT DOM_DICTA_CANT_NOTA_4 CHECK (cant_nota_4 >= 0),
   ADD CONSTRAINT DOM_DICTA_CANT_NOTA_5 CHECK (cant_nota_5 >= 0),
   ADD CONSTRAINT DOM_DICTA_CANT_RETIRADOS CHECK (cant_retirados >= 0);