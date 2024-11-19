package Interfaz;

public interface IConsultaSql {

    public static String consulta_cod_empresa = "select codemp from empresas "
            + "where cuit = ";
    public static String consulta_agente_insert = "INSERT INTO agentes (documento, nya, empliq, sexo, cuil, f572, fechaf572, observ, fechapres, nropres, famok, excep, web, fechaweb, wcuit, wtipodoc, wapellido, wnombre, wdireccion, wprovincia, wcp, wlocalidad, wcalle, wnro, wpiso, wdpto, wcuitreten, wdescreten, periodo, revisado, maxejermes, cierre, minejermes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    
    
    String consulta_esLiqPorMinstEconomia = "select * from empresas\n"
            + "where codemp < 1020 AND activo = 1  and cuit "
            + "IS NOT NULL and cuit = ? ";
           

    //String consujlta_agente_delete = "delete from agentes where documento = ";
    String consulta_familiares_delete = "delete from fliares where documento = ";
    String consulta_deduccion_delete = "delete from deduccion where documento = ";
    String consulta_ganLiqOtrosEmpl_delete = "delete from otrasremu where documento = ";
    String consulta_retPerPagos_delete = "delete from ajusteimp where documento = ";

    String consulta_ganliqOtrosEmpl_insert = "INSERT INTO otrasremu (documento, codemp, mes, gneta, bruto, obrasoc, jubil, sind, nohabit, ajuste, retgan, mesorigen, sac, exenoalc, horasextgr, horasextex, matdid, movviat, bonofalla, exencovid, exenmilit, exentelet, regimen, bonoprod, fallocaja, viaticos, movilidad, simil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    String consulta_retperPagos_insert = "INSERT INTO ajusteimp (documento, concepto, monto, mes,"
            + " nroliq, codemp, mesorigen, descadicional) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    String consulta_utlima_preentacion = "select periodo, nropres, excep from agentes "
            + "where documento = ";

    String consulta_recuperacion_concepto_deuccion = "select concepto from cdedadmite where codded = ";

    String consulta_deduccion_insert = "INSERT INTO deduccion (documento, periodo, nropres, web,"
            + " concepto, monto, mes, wcuit, wdesc, fecha, admitido, tipogasto, docfliar, nyafliar,"
            + " codfliar, porcfliar)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    String consulta_familiar_insert
            = "INSERT INTO fliares"
            + "(documento, "
            + "codfam,"
            + "docfam,"
            + "nya,"
            + "fechaalta,"
            + "fechabaja,"
            + "ok,"
            + "sistema,"
            + "web,"
            + "vigproxper,"
            + "desde,"
            + "hasta,"
            + "fechanac,"
            + "porcen)"
            + "VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?)";
}
//    String consulta_mutual_modificar
//            = "UPDATE Mutual SET "
//            + "nombre = ?, "
//            + "ultima_modificacion = ? "
//            + "WHERE id = ? "
//            + "AND activo = ?";
//
//    String consulta_mutual_existe
//            = "SELECT COUNT(*) "
//            + "FROM \"mutual\" "
//            + "WHERE nombre = ?";
//
//    String consulta_mutual_baja_logica
//            = "UPDATE Mutual SET "
//            + "activo = ?, "
//            + "fecha_baja = ? ,"
//            + "ultima_modificacion = ?"
//            + "WHERE id = ?";
//
//    String consulta_mutual_baja_fisica
//            = "DELETE "
//            + "FROM Mutual "
//            + "WHERE id = ?";
//
//    String consulta_mutual_activar
//            = "UPDATE mutual\n"
//            + "SET activo = true\n"
//            + "WHERE id = ?";
//
//    String consulta_mutual_listado
//            = "Select *\n"
//            + "FROM\n"
//            + "Mutual\n"
//            + "WHERE\n"
//            + "activo = true \n"
//            + "ORDER BY 1, 2, 3;";
//
//    String consulta_mutual_listado_activo
//            = "Select nombre\n"
//            + "FROM\n"
//            + "mutual\n"
//            + "WHERE\n"
//            + "activo=true\n"
//            + "\n"
//            + "ORDER BY nombre ";
//
//    String consulta_mutual_listado_inactivo
//            = "Select nombre "
//            + "FROM Mutual "
//            + "WHERE"
//            + " activo = false ";
//
//    String consulta_mutual_id
//            = "SELECT id "
//            + "FROM mutual "
//            + "WHERE id = ?";
//
//    //---------------- CONSULTAS PARA LOS USUARIOS ---------------------- //
//    String consulta_usuario_create
//            = "CREATE TABLE IF NOT EXISTS usuario(\n"
//            + "	id integer NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),\n"
//            + "	username TEXT NOT NULL,\n"
//            + "	clave TEXT NOT NULL,\n"
//            + "	es_administrador boolean NOT NULL DEFAULT true,\n"
//            + "	fecha_alta timestamp without time zone DEFAULT CURRENT_TIMESTAMP,\n"
//            + "	CONSTRAINT usuario_pkey PRIMARY KEY (id)\n"
//            + ");";
//
//    String consulta_autenticacion
//            = "SELECT clave, es_administrador "
//            + "FROM \"usuario\" "
//            + "WHERE username = ?";
//
//    String consulta_usuario_existe
//            = "SELECT COUNT(*) "
//            + "FROM \"usuario\" "
//            + "WHERE username = ?";
//
//    String consulta_usuario_alta
//            = "INSERT INTO \"usuario\""
//            + "(username, "
//            + "clave, "
//            + "es_administrador, "
//            + "fecha_alta) "
//            + "VALUES (?, ?, ?, ?)";
//
//    String consulta_usuario_Listado
//            = "SELECT * "
//            + "FROM \"usuario\" ";
//
//    //---------------- CONSULTAS DE TABLA INFORME ---------------------- //
//    //CREACION DEL INFORME
//    String consulta_create_informe
//            = "CREATE TABLE IF NOT EXISTS informe \n"
//            + "( codigo integer,\n"
//            + "concepto integer,\n"
//            + "mutual TEXT,\n"
//            + "archivo TEXT,\n"
//            + "tipo TEXT,\n"
//            + "fecha TEXT\n"
//            + ");";
//
//    String consulta_informe_existe_condicion
//            = " WHERE "
//            + "codigo = ? "
//            + "AND archivo = ? "
//            + "AND tipo = ? "
//            + "AND fecha = ?";
//
//    String consulta_infome_Listado
//            = "SELECT * FROM informe";
//
//    //---------------- CONSULTAS DE LA COMPLEMENTARIA ---------------------- //
//    //CREACION DE LA COMPLEMENTARIA
//    String consulta_complementaria_create
//            = "CREATE TABLE IF NOT EXISTS complementaria (\n"
//            + "    id SERIAL PRIMARY KEY,\n"
//            + "    id_mutual INTEGER NOT NULL,\n"
//            + "    tipo_archivo TEXT COLLATE pg_catalog.\"default\" NOT NULL,\n"
//            + "    origen TEXT COLLATE pg_catalog.\"default\" NOT NULL,\n"
//            + "    destino TEXT COLLATE pg_catalog.\"default\" NOT NULL,\n"
//            + "    concepto1 INTEGER,\n"
//            + "    concepto2 INTEGER,\n"
//            + "    fecha_alta TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,\n"
//            + "    fecha_ultima_modificacion TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,\n"
//            + "    CONSTRAINT fk_id_mutual FOREIGN KEY (id_mutual) REFERENCES mutual(id)\n"
//            + ")";
//
//    String consulta_complementaria_alta
//            = "INSERT INTO complementaria"
//            + "(id_mutual,"
//            + "tipo_archivo,"
//            + "origen,"
//            + "destino,"
//            + "concepto1,"
//            + "concepto2,"
//            + "fecha_alta,"
//            + "fecha_ultima_modificacion"
//            + ") "
//            + "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
//
//    String consulta_complementaria_modificacion
//            = "UPDATE complementaria SET "
//            + "origen = ?,"
//            + "destino = ?,"
//            + "concepto1 = ?,"
//            + "concepto2 = ?"
//            //            + "ultima_modificacion = ?"
//            + "WHERE id = ? ";
//
//    String consulta_complementaria_obtenerConcepto1
//            = "SELECT concepto1 "
//            + "FROM complementaria "
//            + "WHERE id_mutual = ? AND tipo_archivo = ?";
//    
//    String consulta_complementaria_obtenerConcepto2
//            = "SELECT concepto2 "
//            + "FROM complementaria "
//            + "WHERE id_mutual = ? AND tipo_archivo = ?";
//    
//    String consulta_complementaria_obtenerTodosLosConceptos
//            = "SELECT concepto1, concepto2 "
//            + "FROM complementaria "
//            + "WHERE id_mutual = ? AND tipo_archivo = ?";
//    
//    String consulta_obtenerTodosLosConceptos1
//            = "SELECT count(*) "
//            + "FROM complementaria "
//            + "WHERE concepto1 = ? ";
//
//    String consulta_obtenerTodosLosConceptos2
//            = "SELECT count(*) "
//            + "FROM complementaria "
//            + "WHERE concepto2 = ? ";
//
//    String consulta_complementaria_Listado
//            = "SELECT\n"
//            + "    m.nombre as mutual,\n"
//            + "    c.tipo_archivo,\n"
//            + "    c.origen,\n"
//            + "    c.destino,\n"
//            + "    c.concepto1,\n"
//            + "    c.concepto2 \n"
//            + "\n"
//            + "FROM \n"
//            + "complementaria c\n"
//            + "            LEFT JOIN \n"
//            + "            Mutual m ON c.id_mutual = m.id\n"
//            + "            ORDER BY 1, 2";
//
//    String consulta_complementaria_informacion
//            = "SELECT\n"
//            + "\n"
//            + "id_mutual,\n"
//            + "tipo_archivo,\n"
//            + "origen,\n"
//            + "destino,concepto1,\n"
//            + "concepto2\n"
//            + "\n"
//            + "FROM complementaria \n"
//            + "WHERE id = ?";
//
//    String consulta_complementaria_existe
//            = "  SELECT\n"
//            + "  COUNT(*)\n"
//            + "  FROM complementaria\n"
//            + "  \n"
//            + "  where id_mutual =  ?\n"
//            + "  AND tipo_archivo = ?\n"
//            + "  AND concepto1 = ?";
//
//    //---------------- CONSULTAS DEL INFORME ---------------------- //
//    String consulta_informe_alta
//            = "INSERT INTO informe"
//            + "(codigo,"
//            + "concepto,"
//            + "mutual,"
//            + "archivo,"
//            + "tipo,"
//            + "fecha"
//            + ") "
//            + "VALUES (?, ?, ?, ?, ?, ?)";
//}
