package it.geek.libreria.service;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.util.List;
import it.geek.libreria.model.Autore;
import it.geek.libreria.util.MyConnectionJNDI;
import it.geek.libreria.factory.DaoFactory;
import it.geek.libreria.DAO.IDAO;


public class AutoreService {

	private static Logger logger = Logger.getLogger(AutoreService.class);
	
	public List<Autore> getWhere(Autore aut){
		
		Connection c = null;
		List<Autore> lAutori = null;
		
		try{
			
			c = MyConnectionJNDI.getConnection();
			IDAO dao = DaoFactory.getAutoreDAO();
			lAutori = dao.findByWhere(aut, c);
			
			
		}catch(Exception e){
			
			logger.error("Errore inaspettato");
			
		}
		finally{
			
			try{
				
				c.close();
				
			}catch(Exception e){
				
				logger.error("Impossibile chiudere la connessione");
				
			}
		}
		
		return lAutori;
	}
	
}
