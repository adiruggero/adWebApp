package it.geek.libreria.service;

import it.geek.libreria.factory.DaoFactory;
import it.geek.libreria.model.Ruolo;
import it.geek.libreria.util.MyConnectionJNDI;
import it.geek.libreria.DAO.IDAO;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;


public class RuoloService {
	
	private static Logger logger = Logger.getLogger(RuoloService.class);
	
	public List<Ruolo> getAll(){
		
		Connection c = null;
		List<Ruolo> lRuoli = null;
		
		try{
			
			c= MyConnectionJNDI.getConnection();
			IDAO dao = DaoFactory.getRuoloDAO();
			lRuoli = dao.findAll(c);
			
		}catch(Exception e){
			
			logger.error("Errore in esecuzione");
			e.printStackTrace();
			
		}
		finally{
			
			try{
				
				c.close();
				
			}catch(SQLException e){
				
				logger.error("Impossibile chiudere la connessione");
				e.printStackTrace();
			}
			
		}
		return lRuoli;
		
	}
	

}
