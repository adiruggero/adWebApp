package it.geek.libreria.DAO.impl;

import it.geek.libreria.DAO.IDAO;
import it.geek.libreria.model.Utente;
import it.geek.libreria.service.MyConnectionJNDI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;


public class UtenteDAO implements IDAO<Utente,String>{
	
	private static Logger logger = Logger.getLogger(UtenteDAO.class);
		
		
		public Utente findById(String id){
			
			Connection c = null;
			
			try{
			
				c  = MyConnectionJNDI.getConnection();
				logger.info("Connessione effettuata");
				
			}catch(Exception e){
				
				logger.debug("Impossibile effettuare la connessione");
			}
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			Utente utente = null;
			String sql = "SELECT u.username,u.password,r.tipo_ruolo FROM utenti u,ruoli r WHERE r.id_ruolo=u.ruolo AND u.username=?";
			
			try{
				
				ps = c.prepareStatement(sql);
				ps.setString(1,id);
				logger.debug(sql);
				rs = ps.executeQuery();
				if(rs.next()){
					utente = new Utente();
					utente.setUsername(rs.getString("username"));
					utente.setPassword(rs.getString("password"));
					utente.setRuolo(rs.getString("tipo_ruolo"));
					
					logger.info("Query eseguita");
					
				}
			}	
			catch(Exception e){
				logger.debug("Query non eseguita");
				
				e.printStackTrace();
			}
			finally{
				
				try{
					rs.close();
				}catch(Exception e){
					logger.debug("Impossibile chiudere il result set");
				}
				
				
				try{
					
					ps.close();
				}catch(Exception e){
					logger.debug("Impossibile chiudere il prepared statement");
				}
				
				try{
					c.close();
				}catch(Exception e){
					logger.debug("Impossibile chiudere la connection");
				}
			}
				
			return utente;
		}

}

