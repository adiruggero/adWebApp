package it.geek.libreria.util;


import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.SQLException;
import javax.naming.NamingException;
import org.apache.log4j.Logger;


public class MyConnectionJNDI {
	
	private static Logger logger = Logger.getLogger(MyConnectionJNDI.class);

	
	public static Connection getConnection(){
		 
		
		Connection c = null;
		
		try{
			
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/libreriaDB");
			c = ds.getConnection();
			logger.info("Connessione effettuata");
			
		}catch(NamingException e){
			logger.debug("Errore initial context");
		
		}catch(SQLException e){
			logger.debug("Non trovo la connessione");
		}
		return c;
	}

}
