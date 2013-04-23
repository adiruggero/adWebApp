package it.geek.libreria.service; 

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import it.geek.libreria.model.Utente;
import it.geek.libreria.util.MyConnectionJNDI;
import it.geek.libreria.DAO.IDAO;
import it.geek.libreria.factory.DaoFactory;
import it.geek.libreria.exception.BusinessException;


public class UtenteService {
	
	private static Logger logger = Logger.getLogger(UtenteService.class);
	
	
	public Utente get(String id){
		
		Connection c = null;
		Utente ut = null;
		
		try{
			
			c = MyConnectionJNDI.getConnection();
			IDAO dao = DaoFactory.getUtenteDAO();
			ut =(Utente) dao.findById(id,c);
		}
		catch(Exception e){
			
			logger.error("Errore inaspettato");
			
		}
		finally{
			
			try{
				
				c.close();
				
			}catch(SQLException e){
				
				logger.error("Impossibile chiudere la connessione");
				e.printStackTrace();
				
			}
		}
		return ut;
	}
	
	public List<Utente> getAll(){
		
		Connection c = null;
		List<Utente> lUtenti  = null;
		
		try{
			
			c = MyConnectionJNDI.getConnection();
			IDAO dao = DaoFactory.getUtenteDAO();
			lUtenti = dao.findAll(c);

		}catch(Exception e){
			
			logger.error("Errore inaspettato");
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
		return lUtenti;
		
	}

	public void delete(Utente u){
		
		Connection c = null;
		try{
			
			c = MyConnectionJNDI.getConnection();
			IDAO dao = DaoFactory.getUtenteDAO();
			boolean ret = dao.delete(u,c);
			
			if(ret == false){
				
				throw new BusinessException("Delete non eseguita");
				
			}
	
		}catch(Exception e){
			
			logger.error("Delete non eseguita");
			e.printStackTrace();
		}
		finally{
			
			try{
				
				c.close();
				
			}catch(SQLException e){
				
				logger.error("Impossibile chiudere la connessione");
				
			}
			
		}
	}

	public void insert(Utente u){
		
		Connection c = null;
		
		try{
			
			c = MyConnectionJNDI.getConnection();
			IDAO dao = DaoFactory.getUtenteDAO();
			boolean ret = dao.insert(u,c);
			
			if(ret == false){
				
				throw new BusinessException("Impossibile eseguire inserimento");
			}
			
		}catch(Exception e){
			
			logger.error("Impossibile eseguire inserimento");
			e.printStackTrace();
			
		}
		finally{
			
			try{
				
				c.close();
				
			}catch(SQLException e){
				
				logger.error("Impossibile chiudere la connessione");
				
			}
		}
	}

	public void update(Utente u,String id){
		
		Connection c = null;
		
		try{
			
			c = MyConnectionJNDI.getConnection();
			IDAO dao = DaoFactory.getUtenteDAO();
			boolean ret = dao.update(u,id,c);
			
			if(ret == false){
				
				throw new BusinessException("Impossibile eseguire la modifica");
				
			}
			
		}catch(Exception e){
			
			logger.error("Impossibile eseguire la modifica");
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
		
	}
}
