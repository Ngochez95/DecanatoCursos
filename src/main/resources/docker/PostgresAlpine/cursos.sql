-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.1
-- PostgreSQL version: 9.4
-- Project Site: pgmodeler.io
-- Model Author: ---


-- Database creation must be done outside a multicommand file.
-- These commands were put in this file only as a convenience.
-- -- object: cursos | type: DATABASE --
-- -- DROP DATABASE IF EXISTS cursos;
-- CREATE DATABASE cursos;
-- -- ddl-end --
-- 

-- object: public.departamento | type: TABLE --
-- DROP TABLE IF EXISTS public.departamento CASCADE;
CREATE TABLE public.departamento(
	id_departamento serial NOT NULL,
	nombre_departamento varchar(75) NOT NULL,
	codigo_departamento varchar(10) NOT NULL,
	CONSTRAINT departamento_pk PRIMARY KEY (id_departamento)

);
-- ddl-end --

-- object: public.carrera | type: TABLE --
-- DROP TABLE IF EXISTS public.carrera CASCADE;
CREATE TABLE public.carrera(
	id_carrera serial NOT NULL,
	nombre_carrera varchar(75) NOT NULL,
	codigo_carrera varchar(15) NOT NULL,
	id_departamento_fk integer NOT NULL,
	CONSTRAINT carrera_pk PRIMARY KEY (id_carrera)

);
-- ddl-end --

-- object: public.estudiante | type: TABLE --
-- DROP TABLE IF EXISTS public.estudiante CASCADE;
CREATE TABLE public.estudiante(
	id_estudiante serial NOT NULL,
	nombre_estudiante varchar(75) NOT NULL,
	apellido_estudiante varchar(75) NOT NULL,
	carnet varchar(7) NOT NULL,
	id_carrera_fk integer NOT NULL,
	sexo boolean NOT NULL,
	correo_estudiante varchar(100) NOT NULL,
	CONSTRAINT estudiante_pk PRIMARY KEY (id_estudiante)

);
-- ddl-end --

-- object: public.curso | type: TABLE --
-- DROP TABLE IF EXISTS public.curso CASCADE;
CREATE TABLE public.curso(
	id_curso serial NOT NULL,
	nombre_curso varchar(50) NOT NULL,
	codigo_curso varchar(15) NOT NULL,
	estado boolean,
	descripcion varchar(300) NOT NULL,
	cupo integer NOT NULL,
	fecha_inicio date NOT NULL,
	fecha_fin date NOT NULL,
	CONSTRAINT curso_pk PRIMARY KEY (id_curso)

);
-- ddl-end --

-- object: public.curso_estudiante | type: TABLE --
-- DROP TABLE IF EXISTS public.curso_estudiante CASCADE;
CREATE TABLE public.curso_estudiante(
	id_estudiante_curso serial NOT NULL,
	id_estudiante_fk integer,
	id_cursos_fk integer,
	estado_curso_estudiante boolean,
	CONSTRAINT curso_estudiante_pk PRIMARY KEY (id_estudiante_curso)

);
-- ddl-end --

-- object: public.administrador | type: TABLE --
-- DROP TABLE IF EXISTS public.administrador CASCADE;
CREATE TABLE public.administrador(
	id_administrador serial NOT NULL,
	nombre_administrador varchar(75) NOT NULL,
	apellido_administrador varchar(75) NOT NULL,
	nombre_usuario varchar(25) NOT NULL,
	contrasenia varchar(64) NOT NULL,
	correo_admin varchar(100) NOT NULL,
	CONSTRAINT administrador_pk PRIMARY KEY (id_administrador)

);
-- ddl-end --

-- object: id_departamento_fk | type: CONSTRAINT --
-- ALTER TABLE public.carrera DROP CONSTRAINT IF EXISTS id_departamento_fk CASCADE;
ALTER TABLE public.carrera ADD CONSTRAINT id_departamento_fk FOREIGN KEY (id_departamento_fk)
REFERENCES public.departamento (id_departamento) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_carrera_fk | type: CONSTRAINT --
-- ALTER TABLE public.estudiante DROP CONSTRAINT IF EXISTS id_carrera_fk CASCADE;
ALTER TABLE public.estudiante ADD CONSTRAINT id_carrera_fk FOREIGN KEY (id_carrera_fk)
REFERENCES public.carrera (id_carrera) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_estudiante_fk | type: CONSTRAINT --
-- ALTER TABLE public.curso_estudiante DROP CONSTRAINT IF EXISTS id_estudiante_fk CASCADE;
ALTER TABLE public.curso_estudiante ADD CONSTRAINT id_estudiante_fk FOREIGN KEY (id_estudiante_fk)
REFERENCES public.estudiante (id_estudiante) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: id_cursos_fk | type: CONSTRAINT --
-- ALTER TABLE public.curso_estudiante DROP CONSTRAINT IF EXISTS id_cursos_fk CASCADE;
ALTER TABLE public.curso_estudiante ADD CONSTRAINT id_cursos_fk FOREIGN KEY (id_cursos_fk)
REFERENCES public.curso (id_curso) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --


