package it.geek.libreria.DAO.impl;

import it.geek.libreria.DAO.IDAO;

import it.geek.libreria.model.Autore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

public class AutoreDAO implements IDAO<Autore,String>{
	
	private static Logger logger = Logger.getLogger(AutoreDAO.class);

	public List<Autore> findByWhere(Autore aut,Connection c){
		
		List<Autore> lAutori = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT codice_fiscale,nome,cognome FROM Autori WHERE 1=1";
		
		if(aut.getCodiceFiscale()!=null){
			
			sql = sql + " AND " + " codice_fiscale LIKE '%"+ aut.getCodiceFiscale()+"%'";
			
		}
		if(aut.getNome()!=null){
			
			sql = sql + " AND " + " nome  LIKE '%"+ aut.getNome()+"%'";
			
		}
		
		if(aut.getCognome()!=null){
			
			sql = sql + " AND " + " cognome LIKE '%" + aut.getCognome()+"%'";
		}
		sql= sql + ";";
		
		logger.info(sql);
		
		try{
			lAutori = new Vector<Autore>();
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				Autore autore = new Autore();
				autore.setCodiceFiscale(rs.getString("codice_fiscale"));
				autore.setNome(rs.getString("nome"));
				autore.setCognome(rs.getString("cognome"));
				lAutori.add(autore);
				
				
			}
			
		}catch(Exception e){
			
			logger.error("Errore in esecuzione");
			
		}
		finally{
			
			try{
				
				rs.close();
				
			}catch(Exception e){
				
				logger.error("Impossibile chiudere il Result Set");
				
			}
			try{
				
				ps.close();
				
			}catch(Exception e){
				
				logger.error("Impossibile chiudere il Prepared Statement");
				
			}
		}
		return lAutori;

	}

	public Autore findById(String id,Connection c){
		Autore autore = null;
		
		return autore;
	}
	
	public List<Autore> findAll(Connection c){
		List<Autore> lAutori = null;
		
		
		return lAutori;
	}

	public boolean delete(Autore aut,Connection c ){
		boolean ret = false;
		
		return ret;
	}

	public boolean insert(Autore aut,Connection c){
		boolean ret = false;
		
		return ret;
	}

	public boolean update(Autore aut,String id,Connection c){
		boolean ret = false;
		
		return ret;
	}
}
