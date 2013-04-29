package it.geek.prenotazioni.util;

import it.geek.prenotazioni.model.Studente;
import it.geek.prenotazioni.model.Corso;
import java.util.Vector;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
public class GenericDAO {
	
	private static Logger logger = Logger.getLogger(GenericDAO.class);

	public Studente findById(String matricola){
		
		Connection c = null;
		Studente studente = null;
		
		try {
			
			c = MyJNDIConnection.getConnection();
			logger.info("Connessione effettuata");
			
		}catch(Exception sql){
			
			logger.error("Impossibile effettuare la connessione");
			sql.printStackTrace();
			
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT matricola,nome,cognome FROM studenti WHERE matricola=?";
		
		try{
			
			ps = c.prepareStatement(sql);
			ps.setString(1, matricola);
			rs=ps.executeQuery();
			
			if(rs.next()){
				studente = new Studente();
				studente.setMatricola(rs.getString("matricola"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				logger.info("Studente trovato");
			}
			
		}catch(Exception e){
			
			logger.error("Query findByID non eseguita");
			e.printStackTrace();
			
		}
		
		finally{
			
			try{
				
				rs.close();
			
			}catch(Exception e){
				
				logger.error("Impossibile chiudere il result set");
				e.printStackTrace();
				
			}
			
			try{
				
				ps.close();
				
			}catch(Exception e){
				
				logger.error("impossibile chiudere il prepared statement");
				e.printStackTrace();
				
			}
			
			try{
				
				c.close();
			
			}catch(Exception e){
				
				logger.error("impossibile chiudere la connessione");
				e.printStackTrace();
				
			}
			
		}
		return studente;
		
	}
	
	
	public List<Corso> findAllCorsi(){
		
		Connection c = null;
		List<Corso> lCorsi = null;
		Corso corso = null;
		try{
			
			c = MyJNDIConnection.getConnection();
			logger.info("Connessione effettuata");
		
		}catch(Exception e){
			
			logger.error("Impossibile effettuare la connessione");
			e.printStackTrace();
			
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id,materia FROM corsi";
		
		try{
			
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			lCorsi = new Vector<Corso>();
			
			while(rs.next()){
				
				corso = new Corso();
				corso.setCodiceCorso(rs.getInt("id"));
				corso.setNomeCorso(rs.getString("materia"));
				lCorsi.add(corso);
				
				
			}
		}catch(Exception e){
			
			logger.error("Impossibile effettuare findAllCorsi");
			e.printStackTrace();
			
		}
		finally{
			
			try{
				
				rs.close();
			
			}catch(Exception e){
				
				logger.error("Impossibile chiudere il result set");
				e.printStackTrace();
				
			}
			try{
				
				ps.close();
				
			}catch(Exception e){
				
				logger.error("Impossibile chiudere il prepared statement");
				e.printStackTrace();
				
			}
			try{
				
				c.close();
				
			}catch(Exception e){
				
				logger.error("impossibile chiudere la connessione");
				e.printStackTrace();
				
			}
		}
		
		return lCorsi;
	}
	
	
	public boolean insertPrenotazione(String matricola,int codice){
		
		boolean ret = false;
	    Connection c = null;
	    
	    try{
	    	
	    	c = MyJNDIConnection.getConnection();
	    	
	    }catch(Exception e){
	    	
	    	logger.error("Impossibile effettuare connessione");
	    	e.printStackTrace();
	    
	    }
	    
	    PreparedStatement ps = null;
	    String sql = "INSERT INTO prenotazioni(cod_studente,cod_corso)VALUES(?,?)";
	    
	    try{
	    	
	    	ps = c.prepareStatement(sql);
	    	ps.setString(1,matricola);
	    	ps.setInt(2,codice);
	    	int ritorno = ps.executeUpdate();
	    	
	    	if(ritorno>=0){
	    		
	    		ret = true;
	    		logger.info("Insert eseguita");
	    		
	    	}else{
	    		
	    		logger.info("Insert non eseguita");
	    	}
	    	
	    }catch(Exception e){
	    	
	    	logger.error("Problemi nella insert");
	    	e.printStackTrace();
	    	
	    }
	    
	    finally{
	    	
	    	try{
	    		
	    		ps.close();
	    		
	    	}catch(Exception e){
	    		
	    		logger.error("Impossibile chiudere il prepared statement");
	    		e.printStackTrace();
	    		
	    	}
	    	
	    	try{
	    		
	    		c.close();
	    		
	    	}catch(Exception e){
	    		
	    		logger.error("Impossibile chiudere la connessione");
	    		e.printStackTrace();
	    		
	    	}
	    	
	    } 
		
	    return ret;
	}
	
	
	public List<Corso> findIdPrenotazioni(String matricola){
		
		List<Corso> lCorsi = null;
		Connection c = null;
		
		try{
			
			c=MyJNDIConnection.getConnection();
			
		}catch(Exception e){
			
			logger.error("Impossibile aprire la connessione");
			e.printStackTrace();
			
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Corso corso = null;
		String sql ="SELECT c.id,c.materia FROM corsi c,prenotazioni p WHERE p.cod_corso=c.id AND cod_studente=?";
		
		try{
			
			ps = c.prepareStatement(sql);
			ps.setString(1,matricola);
			rs=ps.executeQuery();
			lCorsi = new Vector<Corso>();
			
			while(rs.next()){
				
				corso = new Corso();
				corso.setCodiceCorso(rs.getInt("id"));
				corso.setNomeCorso(rs.getString("materia"));
				lCorsi.add(corso);
			}
			
		}catch(Exception e){
			
			logger.error("Query non eseguita");
			e.printStackTrace();
			
		}
		finally{
			
			try{
				
				rs.close();
				
			}catch(Exception e){
			
				logger.error("Impossibile chiudere il result set");
				e.printStackTrace();
				
			}
			try{
				
				ps.close();
				
			}catch(Exception e){
				
				logger.error("Impossibile chiudere il prepared statement");
				e.printStackTrace();
				
			}
			try{
				
				c.close();
				
			}catch(Exception e){
				
				logger.error("Impossibile chiudere la connection");
				e.printStackTrace();
				
			}
		}
		return lCorsi;
	}

	
	public boolean delete(String matricola,int id){
		
		boolean ret = false;
		Connection c = null;
		
		try{
			
			c = MyJNDIConnection.getConnection();
			
		}catch(Exception e){
			
			logger.error("Impossibile aprire la connessione");
			e.printStackTrace();
		
		}
		
		PreparedStatement ps = null;
		String sql = "DELETE FROM prenotazioni WHERE cod_studente=? AND cod_corso=?";
		
		try{
			
			ps = c.prepareStatement(sql);
			ps.setString(1, matricola);
			ps.setInt(2,id);
			int ritorno = ps.executeUpdate();
			if(ritorno>=0){
				
				ret = true;
				logger.info("Query eseguita");
			}
			else{
				
				logger.info("query non eseguita");
				
			}
		}catch(Exception e){
			
			logger.error("Query delete non eseguita");
			e.printStackTrace();
			
		}
		finally{
			
			try{
				
				ps.close();
				
			}catch(Exception e){
				
				logger.error("Impossibile chiudere il prepared statement");
				e.printStackTrace();
				
			}
			try{
				
				c.close();
				
			}catch(Exception e){
				
				logger.error("Impossibile chiudere la connessione");
				e.printStackTrace();
				
			}
		}
		
		return ret;
		
	}
}
