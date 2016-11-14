package servlet;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Sql {
	static File archivo = Paths.get(".").toAbsolutePath().normalize().toFile();
	static String ruta = archivo.toString() + "/src/main/resources/";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver"; //org.h2.Driver
    static final String DB_URL = "jdbc:h2:" + ruta + "DBtest";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main (String[] args) {
    	
    }
    
    public static void BorrarTabla(String idioma){
    	Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();

            String sql = "DELETE FROM Paises WHERE idiomaPaises = '" + idioma + "'";
            String sql2 = "DELETE FROM Idiomas WHERE idioma = '" + idioma + "'";

            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
        } 
	} 

	private static void closeCon(Connection conn) {
		try {
		    if (conn!= null)
		        conn.close();
		} catch (SQLException se) {
		    se.printStackTrace();
		} 
	}

	private static void closeStm(Connection conn, Statement stmt) {
		try {
		    if (stmt!=null)
		        conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} 
	}
    
	public static List listar(){
    	Connection conn = null;
    	List<Paises> listPaises= new ArrayList<Paises>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
           
            stmt = conn.createStatement();
    		
			prepareStatement = conn.prepareStatement("SELECT * FROM Paises");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Paises userInDatabase = new Paises();
				userInDatabase.setPais(resultSet.getString(1));
				userInDatabase.setIdioma(resultSet.getString(2));
				
				listPaises.add(userInDatabase);
			}

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
            closeRs(resultSet);
        } 
        return listPaises;
   }
	
	public static List listarIdiomas(){
    	Connection conn = null;
    	List<Idiomas> listIdiomas = new ArrayList<Idiomas>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
           
            stmt = conn.createStatement();
    		
			prepareStatement = conn.prepareStatement("SELECT * FROM Idiomas");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Idiomas userInDatabase = new Idiomas();
				userInDatabase.setIdiomas(resultSet.getString(1));
				
				listIdiomas.add(userInDatabase);
			}

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
            closeRs(resultSet);
        } 
        return listPaises;
   }

	private static void closeRs(ResultSet resultSet) {
		if(
			resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
    
   public static void insertarTablaPaises(String pais, String Idioma){
    	Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
            stmt = conn.createStatement();

            String sql = "REPLACE INTO Paises (pais,idiomaPaises) VALUES ('" + pais + "', '" + Idioma + "')";
                   
            stmt.executeUpdate(sql);
        } catch (SQLException se) {            
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
        } 
       
    }
   
   public static void insertarTablaIdiomas(String idioma){
   	Connection conn = null;
       Statement stmt = null;

       try {
           Class.forName("org.h2.Driver");

           conn = DriverManager.getConnection(DB_URL, USER, PASS);
         
           stmt = conn.createStatement();

           String sql = "REPLACE INTO Idiomas (idioma) VALUES ('" + idioma + "')";
                  
           stmt.executeUpdate(sql);
       } catch (SQLException se) {            
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           closeStm(conn, stmt);
           closeCon(conn);
       } 
      
   }
   
   public static void crearTablaIdiomas(){
	   Connection conn = null;
       Statement stmt = null;

       try {
           Class.forName("org.h2.Driver");

           conn = DriverManager.getConnection(DB_URL, USER, PASS);
          
           stmt = conn.createStatement();

           String sql = "CREATE TABLE IF NOT EXISTS Idiomas (idioma VARCHAR(255), PRIMARY KEY (idioma))";

           stmt.executeUpdate(sql);
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
    	   closeStm(conn, stmt);
           closeCon(conn);
       } 
	}

   
   public static void crearTablaPaises(){
	   Connection conn = null;
	   Statement stmt = null;
	
	   try {
	       Class.forName("org.h2.Driver");
	
	       conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      
	       stmt = conn.createStatement();
	
	       String sql = "CREATE TABLE IF NOT EXISTS Paises(pais VARCHAR(255), idiomaPaises VARCHAR(255), PRIMARY KEY (pais))";
	
	       stmt.executeUpdate(sql);
	   } catch (SQLException se) {
	       se.printStackTrace();
	   } catch (Exception e) {
	       e.printStackTrace();
	   } finally {
		   closeStm(conn, stmt);
	       closeCon(conn);
	   } 
   }
   
}
