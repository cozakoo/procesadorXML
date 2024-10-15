--crear tabla fliares
CREATE TABLE fliares (
    documento NUMERIC,
    codfam INTEGER,
    docfam NUMERIC,
    nya VARCHAR(255),
    fechaalta DATE,
    fechabaja DATE,
    ok INTEGER,
    sistema INTEGER,
    web INTEGER,
    vigproxper INTEGER,
    desde INTEGER,
    Hasta INTEGER,
    fechanac DATE,
    porcen INTEGER

);

--crear tabla cdedadmite
CREATE TABLE cdedadmite(
    concepto VARCHAR(250),
    descrip VARCHAR(250),
    codded INTEGER,
    topefijo (250),
    porcentajegn,
    porcentaje,
    grupognpa,
    anual,
    gni,
    gni40
)





-- -- Crear la tabla provincia
-- CREATE TABLE provincia (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );

-- -- Insertar los datos
INSERT INTO provincia (codigo, descripcion) VALUES
(1, 'Ciudad Autónoma de Buenos Aires'),
(2, 'Buenos Aires'),
(3, 'Catamarca'),
(4, 'Córdoba'),
(5, 'Corrientes'),
(6, 'Entre Ríos'),
(7, 'Jujuy'),
(8, 'Mendoza'),
(9, 'La Rioja'),
(10, 'Salta'),
(11, 'San Juan'),
(12, 'San Luis'),
(13, 'Santa Fe'),
(14, 'Santiago del Estero'),
(15, 'Tucumán'),
(16, 'Chaco'),
(17, 'Chubut'),
(18, 'Formosa'),
(19, 'Misiones'),
(20, 'Neuquén'),
(21, 'La Pampa'),
(22, 'Río Negro'),
(23, 'Santa Cruz'),
(24, 'Tierra del Fuego');

-- Crear la tabla tipo_documento
-- CREATE TABLE tipo_documento (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(50)
-- );

-- -- Insertar los datos
INSERT INTO tipo_documento (codigo, descripcion) VALUES
(80, 'CUIT'),
(86, 'CUIL'),
(87, 'CDI'),
(96, 'DNI'),
(89, 'LC'),
(90, 'LE'),
(92, 'En Trámite');

Crear la tabla parentesco
CREATE TABLE parentesco (
    codigo INTEGER PRIMARY KEY,
    descripcion VARCHAR(255),
    codfam INTEGER ,
    periodo INTEGER
);

-- -- Insertar los datos
INSERT INTO parentesco (codigo, descripcion, codfam, periodo) VALUES
(1, 'Cónyuge', 4,2019),
(3, 'Hijo/a Menor de 18 Años',1,2019),
(30, 'Hijastro/a Menor de 18 Años',1,2019),
(31, 'Hijo/a Incapacitado para el Trabajo',2,2019),
(32, 'Hijastro/a incapacitado para el Trabajo',2,2019),
-- (33, 'Padre'),
-- (34, 'Madre'),
-- (35, 'Nieto/a Menor de 24 Años'),
-- (36, 'Nieto/a Incapacitado para el Trabajo'),
-- (37, 'Bisnieto/a Menor de 24 Años'),
-- (38, 'Bisnieto/a Incapacitado para el Trabajo'),
-- (39, 'Abuelo/a'),
-- (40, 'Bisabuelo/a'),
-- (41, 'Padrastro/Madrastra'),
-- (42, 'Hermano/a Menor de 24 Años'),
-- (43, 'Hermano/a Incapacitado para el Trabajo'),
-- (44, 'Suegro/a'),
-- (45, 'Yerno/Nuera Menor de 24 Años'),
-- (46, 'Yerno/Nuera Incapacitado para el Trabajo'),
(51, 'CONVIV',4,2019),
(103, 'Hijo/a Mayor de 19 y Hasta 24 años',5,2022);


-- Crear la tabla deducciones
-- CREATE TABLE deducciones (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );

-- -- Insertar los datos
INSERT INTO deducciones (codigo, descripcion) VALUES
(1, 'Cuotas Médico-Asistenciales'),
(2, 'Primas de Seguro para el caso de muerte / riesgo de muerte'),
(3, 'Donaciones'),
(4, 'Intereses Préstamo Hipotecario'),
(5, 'Gastos de Sepelio'),
(7, 'Gastos Médicos y Paramédicos'),
(8, 'Deducción del Personal Doméstico'),
(9, 'Aporte a Sociedades de Garantía Recíproca'),
(10, 'Vehiculos de Corredores y Viajantes de Comercio'),
(11, 'Períodos 2018 y anteriores: Gastos de Movilidad, Viáticos y Representaciones e Intereses de Corredores y Viajantes de Comercio Período 2019 en adelante: Gastos de Representación e Intereses de Corredores y Viajantes de Comercio'),
(21, 'Gastos de Adquisición de Indumentaria y Equipamiento para uso Exclusivo en el Lugar de Trabajo'),
(22, 'Alquiler de Inmuebles destinados a casa habitación'),
(23, 'Primas de Ahorro correspondientes a Seguros Mixtos'),
(24, 'Aportes correspondientes a Planes de Seguro de Retiro Privados'),
(25, 'Adquisición de Cuotapartes de Fondos Comunes de Inversión con fines de retiro'),
(32, 'Gastos de Educación'),
(99, 'Otras Deducciones')
;

-- -- Crear la tabla motivos
-- CREATE TABLE motivos (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );

-- -- Insertar los datos
INSERT INTO motivos (codigo, descripcion) VALUES
(1, 'Aportes para fondos de Jubilación, Retiros, Pensiones o Subsidios destinados al ANSES'),
(2, 'Cajas Provinciales o Municipales'),
(3, 'Impuesto sobre los Créditos y Débitos en Cuenta Bancaria sin CBU [nota: reemplazado por Pago a Cuenta Cód. 14 – ver Tabla 9]'),
(4, 'Beneficios Derivados de Regímenes que impliquen tratamientos Preferenciales que se Efectivicen Mediante Deducciones'),
(5, 'Beneficios Derivados de Regímenes que impliquen tratamientos Preferenciales que No se Efectivicen Mediante Deducciones'),
(6, 'Actores - Retribuciones Abonadas a Representantes - R.G. N° 2442/08'),
(7, 'Cajas Complementarias de Previsión'),
(8, 'Fondos Compensadores de Previsión'),
(9, 'Otros');

-- Crear la tabla s
-- CREATE TABLE s (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );

-- -- Insertar los datos
INSERT INTO s (codigo, descripcion) VALUES
(1, 'Montos Retroactivos'),
(2, 'Reintegros de Soc. de Garantia Recíproca Art. 79 Párrafo 2 y Párrafo 3');

-- Crear la tabla tipos_tarjeta
-- CREATE TABLE tipos_tarjeta (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );

-- -- Insertar los datos
INSERT INTO tipos_tarjeta (codigo, descripcion) VALUES
(0, 'Totalizado / No Aplica (sólo para pagos a cuenta tipo 28 y 29)'),
(1, 'Tarjeta de Crédito / Compra'),
(2, 'Tarjeta de Débito');

-- Crear la tabla id_tarjetas
-- CREATE TABLE id_tarjetas (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );

-- -- Insertar los datos
INSERT INTO id_tarjetas (codigo, descripcion) VALUES
(1, 'MasterCard'),
(2, 'Visa'),
(3, 'American Express'),
(4, 'Cabal'),
(5, 'Italcred'),
(6, 'Naranja'),
(7, 'Nativa'),
(8, 'Diners Club'),
(99, 'Otra');


-- Crear la tabla retenciones_percepciones_pagos
-- CREATE TABLE retenciones_percepciones_pagos (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );

ALTER TABLE retenciones_percepciones_pagos
ADD COLUMN concepto VARCHAR(255);


-- -- Insertar los datos
INSERT INTO retenciones_percepciones_pagos (codigo, descripcion, concepto) VALUES
(6, 'Impuestos sobre Créditos y Débitos en cuenta Bancaria', 'DEBCRED'),
(12, 'Retenciones y Percepciones Aduaneras','RETADUA'),
(13, 'Pago a Cuenta - Compras en el Exterior','COMPRAS'),
(14, 'Impuesto sobre los Movimientos de Fondos Propios o de Terceros','FONDOPR'),
(15, 'Pago a Cuenta - Compra de Paquetes Turísticos','COMPRAQ'),
(16, 'Pago a Cuenta - Compra de Pasajes','COMPRAP'),
(17, 'Pago a Cuenta - Compra de Moneda Extranjera para Turismo / Transf. al Exterior','COMPRAT'),
(18, 'Pago a Cuenta - Adquisición de moneda extranjera para tenencia de billetes extranjeros en el país','COMPRAM'),
(19, 'Pago a Cuenta - Compra de Paquetes Turísticos en efectivo','COMPRATE'),
(20, 'Pago a Cuenta - Compra de Pasajes en efectivo','COMPRAPE'),
(27, 'Pago a Cuenta - RG 4815 - Ley 27541 - Art. 35 inc. a', 'ART35A'),
(28, 'Pago a Cuenta - RG 4815 - Ley 27541 - Art. 35 inc. b', 'ART35B'),
(29, 'Pago a Cuenta - RG 4815 - Ley 27541 - Art. 35 inc. c', 'ART35C'),
(30, 'Pago a Cuenta - RG 4815 - Ley 27541 - Art. 35 inc. d', 'ART35D'),
(31, 'Pago a Cuenta - RG 4815 - Ley 27541 - Art. 35 inc. e', 'ART35E');

-- Crear la tabla tipos_norma
-- CREATE TABLE tipos_norma (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );

-- -- Insertar los datos
INSERT INTO tipos_norma (codigo, descripcion) VALUES
(0, 'Ley'),
(1, 'Decreto'),
(2, 'RG');

-- Crear la tabla tipo_gasto
-- CREATE TABLE tipo_gasto (
--     codigo INTEGER PRIMARY KEY,
--     descripcion VARCHAR(255)
-- );
-- -- Insertar los datos
INSERT INTO tipo_gasto (codigo, descripcion) VALUES
(1, 'Servicios con fines educativos'),
(2, 'Herramientas educativas');

