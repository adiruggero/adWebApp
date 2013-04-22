package it.geek.libreria.DAO.impl;

import it.geek.libreria.DAO.IDAO;
import it.geek.libreria.model.Utente;
import it.geek.libreria.service.MyConnectionJNDI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.Vector;




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
	
		public List<Utente> findAll(){
			
			Utente utente = null;
			Connection c = null;
			List<Utente> lUtenti = new Vector<Utente>();
			
			try{
				
				c = MyConnectionJNDI.getConnection();
				logger.info("Connessione effettuata");
			}
			catch(Exception e){
				logger.debug("Exception");
				e.printStackTrace();
			}
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT u.username,u.password,r.tipo_ruolo FROM utenti u,ruoli r WHERE r.id_ruolo=u.ruolo";
			
			try{
				
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				logger.info("QueryEseguita");
				while ( rs.next()){
					utente = new Utente();
					utente.setUsername(rs.getString("username"));
					utente.setPassword(rs.getString("password"));
					utente.setRuolo(rs.getString("tipo_ruolo"));
					lUtenti.add(utente);
				}
			
			}catch(Exception e){
				logger.debug("Errore nell'esecuzione della query");
			}
			
			finally{
				
				try{
					rs.close();
					
				}catch(Exception e){
					logger.debug("impossibile chiudere il result set");
				}
				
				try{
					ps.close();
				}catch(Exception e){
					logger.debug("Impossibile chiudere il prepared statement");
				}
				try{
					c.close();
				}catch(Exception e){
					logger.debug("Impossibile chiudere la connessione");
				}
			}
			return lUtenti;
		}
		
		public boolean insert(Utente u){
			
			boolean ret = false;
			Connection c = null;
			
			try{
				c=MyConnectionJNDI.getConnection();
				logger.info("Connessione effettuata");
			}catch(Exception e){
				logger.debug("Connessione non riuscita");
				e.printStackTrace();
			}
			
			PreparedStatement ps = null;
			String sql = "INSERT INTO utenti(username,password,ruolo)VALUES(?,?,?)";
			
			try{
				ps = c.prepareStatement(sql);
				ps.setString(1,u.getUsername());
				ps.setString(2,u.getPassword());
				String ruolo = u.getRuolo();
				logger.info(ruolo);
				
				if(ruolo.equals("Amministrazione")){
					ps.setInt(3,1);
					logger.info("Amministrazione");
				}
				else if(ruolo.equals("Standard")){
					ps.setInt(3,2);
					logger.info("Standard");
				}
				else{
					ps.setInt(3,3);
					logger.info("Ospite");
				}
				int ritorno = ps.executeUpdate();
				
				if(ritorno>=0){
					ret = true;
					logger.info("Query eseguita");
				
				}else{
				
					logger.debug("Query non eseguita");
				
				}
			}catch(Exception e){
				
				logger.debug("Errore durante l'esecuzione");
			
			}
			finally{
				
				try{
					
					ps.close();
				
				}catch(Exception e){
					logger.debug("impossibile chiudere il ps");
					e.printStackTrace();
				}
				try{
					c.close();
					
				}catch(Exception e){
					logger.debug("impossibile chiudere la connessione");
					e.printStackTrace();
				}
			}
			return ret;
		}

		public boolean delete(Utente u){
			
			boolean ret = false;
			Connection c = null;
			
			try{
				
				c = MyConnectionJNDI.getConnection();
				logger.info("connessione effettuata");
				
			}catch(Exception e){
				
				logger.debug("Connessione non riuscita");
			}
			
			PreparedStatement ps = null;
			String sql = "DELETE FROM utenti WHERE username=?";
			
			try{
				
				ps = c.prepareStatement(sql);
				String username = u.getUsername();
				ps.setString(1,username);
				int ritorno = ps.executeUpdate();
				
				if(ritorno>=0){	
					ret=true;
					logger.info("Delete eseguita");
				}
				else{
					
					logger.debug("delete non eseguita");
				}
				
			}catch(Exception e){
				
				logger.debug("Errore nell'esecuzione");
				e.printStackTrace();
		
			}
			finally{
				
				try{
					ps.close();
					
				}catch(Exception e){
					
					logger.debug("Impossibile chiudere il ps");
				
				}
				try{
					c.close();
				
				}catch(Exception e){
					
					logger.debug("Impossibile chiudere la connessione");
				}
			}
			
			return ret;
		}

		public boolean update(Utente u,String oldUser){
			
			boolean ret = false;
			Connection c = null;
			
			try{
				
				c = MyConnectionJNDI.getConnection();
				logger.info("Connessione update eseguita");
				
			}catch(Exception e){
				
				logger.debug("Connessione update non eseguita");
			}
			
			PreparedStatement ps = null;
			String sql = "UPDATE utenti SET";
			
			String username = u.getUsername();
			String password = u.getPassword();
			String ruolo = u.getRuolo();
			
			if(username!=null){
				sql = sql+" "+"username='"+username+"'";	
			}
			if(password!=null){
				sql=sql+","+ "password='"+password+"'";
			}
			if(ruolo!=null&&ruolo.equals("Amministratore")){
				sql=sql+","+ "ruolo="+ 1;
			}
			if(ruolo!=null&&ruolo.equals("Standard")){
				sql=sql+","+"ruolo="+ 2;
			}
			if(ruolo!=null&&ruolo.equals("Ospite")){
				sql=sql+","+"ruolo="+ 3;
			}
			sql=sql+" "+"WHERE username='"+oldUser+"';";
			logger.info(sql);
			try{
				
				ps = c.prepareStatement(sql);
				int ritorno= ps.executeUpdate();
				if(ritorno>=0){
					ret = true;
					logger.info("Query eseguita");
				}
				
			}catch(Exception e){
				logger.debug("Update non eseguita");
				e.printStackTrace();
			}
			
			finally{
				try{
					
					ps.close();
				
				}catch(Exception e){
					
					logger.debug("Impossibile chiudere il ps");
					e.printStackTrace();
				
				}
				try{
					
					c.close();
					
				}catch(Exception e){
					
					logger.debug("impossibile chiudere la connessione");
					e.printStackTrace();
				
				}
			}
			
			return ret;
		}
}

