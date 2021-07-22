# cupon

un proyecto que identifica el monto necesario para distribuir en cupones

# Instalacion local intellij

	1 verificar su version del jdk en su ambiente local
	2 para esta version del jdk es la version 11 de amazon correto https://corretto.aws/downloads/latest/amazon-corretto-11-x64-windows-jdk.zip
	2 descargar el proyecto cupon de la rama dev
	
# docker y base de datos
	
	1 descargar docker
	
		Docker Postgres
		docker comandos

		docker version
		docker pull postgres:10.9-alpine
		docker images
		docker run -d --name postgres -e POSTGRES_PASSWORD=qwer12345 -p 5432:5432 postgres:10.9-alpine
		docker ps -a
		docker start (id de la imagen)
		
	2 descargar PGadmin 4 https://www.postgresql.org/ftp/pgadmin/pgadmin4/v4.29/windows/
	3 configurar las conexiones previamente aclarada en el numeral 1
	4 cread la siguiente tabla en el schema public
	5 	-- Table: public.item

		-- DROP TABLE public.item;

		CREATE TABLE public.item
		(
			item_id character varying COLLATE pg_catalog."default" NOT NULL,
			id character varying COLLATE pg_catalog."default",
			title character varying COLLATE pg_catalog."default",
			price double precision,
			CONSTRAINT item_pkey PRIMARY KEY (item_id)
		)

		TABLESPACE pg_default;

		ALTER TABLE public.item
			(in your space);
			
	6 run proyect en intellij
	8 dejo la coleccion de postman dentro de la carpeta src/integrationTest
	9 run java gadle in springToolSuite
	10 observaciones
		si va a correr el proyecto en spring boot
		tener cuidado con lombok hay que hacerle una configuracion adicional