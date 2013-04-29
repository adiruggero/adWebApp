
package it.geek.libreria.DAO.impl;

import it.geek.libreria.DAO.IDAO;
import it.geek.libreria.model.Utente;
import it.geek.libreria.util.MyConnectionJNDI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.Vector;




public class UtenteDAO implements IDAO<Utente,String>{
	
	private static Logger logger = Logger.getLogger(UtenteDAO.class);
		
		
		public Utente findById(String id,Connection c){
			
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			Utente utente = null;
			String sql = "SELECT u.username,u.password,u.nome,u.cognome,r.tipo_ruolo FROM utenti u,ruoli r WHERE r.id_ruolo=u.ruolo AND u.username=?";
			
			try{
				
				ps = c.prepareStatement(sql);
				ps.setString(1,id);
				logger.debug(sql);
				rs = ps.executeQuery();
				if(rs.next()){
					utente = new Utente();
					utente.setUsername(rs.getString("username"));
					utente.setPassword(rs.getString("password"));
					utente.setNome(rs.getString("nome"));
					utente.setCognome(rs.getString("cognome"));
					utente.setRuolo(rs.getString("tipo_ruolo"));
					
					logger.info("Query eseguita");
					
				}
			}	
			catch(Exception e){
				logger.error("Query non eseguita");
				
				e.printStackTrace();
			}
			finally{
				
				try{
					rs.close();
				}catch(Exception e){
					logger.error("Impossibile chiudere il result set");
				}
				
				
				try{
					
					ps.close();
				}catch(Exception e){
					logger.error("Impossibile chiudere il prepared statement");
				}
			}
				
			return utente;
		}
	
		public List<Utente> findAll(Connection c){
			
			Utente utente = null;
			List<Utente> lUtenti = new Vector<Utente>();		
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT u.username,u.password,u.nome,u.cognome,r.tipo_ruolo FROM utenti u,ruoli r WHERE r.id_ruolo=u.ruolo";
			
			try{
				
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				logger.info("QueryEseguita");
				while ( rs.next()){
					utente = new Utente();
					utente.setUsername(rs.getString("username"));
					utente.setPassword(rs.getString("password"));
					utente.setNome(rs.getString("nome"));
					utente.setCognome(rs.getString("cognome"));
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
					logger.error("impossibile chiudere il result set");
				}
				
				try{
					ps.close();
				}catch(Exception e){
					logger.error("Impossibile chiudere il prepared statement");
				}
			}
			return lUtenti;
		}
		
		public boolean insert(Utente u,Connection c){
			
			boolean ret = false;			
			PreparedStatement ps = null;
			String sql = "INSERT INTO utenti(username,password,nome,cognome,ruolo)VALUES(?,?,?,?,?)";
			
			try{
				ps = c.prepareStatement(sql);
				ps.setString(1,u.getUsername());
				ps.setString(2,u.getPassword());
				ps.setString(3,u.getNome());
				ps.setString(4,u.getCognome());
				String ruolo = u.getRuolo();
				logger.info(ruolo);
				
				if(ruolo.equals("Amministratore")){
					ps.setInt(5,1);
					logger.info("Amministratore");
				}
				else if(ruolo.equals("Standard")){
					ps.setInt(5,2);
					logger.info("Standard");
				}
				else{
					ps.setInt(5,3);
					logger.info("Ospite");
				}
				int ritorno = ps.executeUpdate();
				
				if(ritorno>=0){
					ret = true;
					logger.info("Query eseguita");
				
				}else{
				
					logger.error("Query non eseguita");
				
				}
			}catch(Exception e){
				
				logger.error("Errore durante l'esecuzione");
			
			}
			finally{
				
				try{
					
					ps.close();
				
				}catch(Exception e){
					logger.error("impossibile chiudere il ps");
					e.printStackTrace();
				}
			}
			return ret;
		}

		public boolean delete(Utente u,Connection c){
			
			boolean ret = false;	
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
					
					logger.error("delete non eseguita");
				}
				
			}catch(Exception e){
				
				logger.error("Errore nell'esecuzione");
				e.printStackTrace();
		
			}
			finally{
				
				try{
					ps.close();
					
				}catch(Exception e){
					
					logger.error("Impossibile chiudere il ps");
				
				}
			}
			
			return ret;
		}

		public boolean update(Utente u,String oldUser,Connection c){
			
			boolean ret = false;			
			PreparedStatement ps = null;
			String sql = "UPDATE utenti SET";
			
			String username = u.getUsername();
			String password = u.getPassword();
			String nome = u.getNome();
			String cognome = u.getCognome();
			String ruolo = u.getRuolo();
			
			if(username!=null){
				sql = sql+" "+"username='"+username+"'";	
			}
			if(password!=null){
				sql=sql+","+ "password='"+password+"'";
			}
			if(nome!=null){
				sql=sql+","+ "nome='"+nome+"'";
			}
			if(cognome!=null){
				sql=sql+","+ "cognome='"+cognome+"'";
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
				logger.error("Update non eseguita");
				e.printStackTrace();
			}
			
			finally{
				try{
					
					ps.close();
				
				}catch(Exception e){
					
					logger.error("Impossibile chiudere il ps");
					e.printStackTrace();
				
				}

			}
			
			return ret;
		}
		
		public List<Utente> findByWhere(Utente u,Connection c){
			
			List<Utente> lUtenti = null;
			
			return lUtenti;
			
		}
}

