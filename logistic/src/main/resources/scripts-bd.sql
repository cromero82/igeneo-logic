select * from type_vehicle;


---Creación de tabla "type_vehicle" (eliminacion) e insercición de algunod datos

CREATE TABLE type_vehicle (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL UNIQUE,
	pattern VARCHAR(50) NOT NULL
)

    INSERT INTO type_vehicle (name, pattern)
VALUES
    ( 'Vehiculo', '^[A-Z]{3}\d{3}$'),
    ( 'Motocicleta', '^[A-Z]{2}\d{3}$'),
    ( 'Tractocamion', '^[A-Z]{3}\d{3}$'),
    ( 'SUV', '^[A-Z]{3}\d{3}$'),
    ( 'Van', '^[A-Z]{3}\d{3}$');

-- drop table type_vehicle ;
