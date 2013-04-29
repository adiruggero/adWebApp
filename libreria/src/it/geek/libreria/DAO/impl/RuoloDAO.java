package it.geek.libreria.DAO.impl;

import it.geek.libreria.model.Ruolo;
import it.geek.libreria.DAO.IDAO;
import java.util.List;
import org.apache.log4j.Logger;
import java.util.Vector;
import java.sql.*;

public class RuoloDAO implements IDAO<Ruolo,Integer> {
	
	private static Logger logger = Logger.getLogger(RuoloDAO.class);
	
	public Ruolo findById(Integer id,Connection c){
		
		return null;
	}
	
	public List<Ruolo> findAll(Connection c){
		
		Ruolo ruolo = null;
		List<Ruolo> lRuoli = new Vector<Ruolo>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="SELECT id_ruolo,tipo_ruolo FROM ruoli";
		
		try{
			
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				ruolo = new Ruolo();
				ruolo.setCodiceRuolo(rs.getInt("id_ruolo"));
				ruolo.setTipoRuolo(rs.getString("tipo_ruolo"));
				lRuoli.add(ruolo);
				
			}
			
		
		}catch(Exception e){
			
			logger.error("Impossibile eseguire la query");
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
				
				logger.error("Impossibile chiudere il Prepared Statement");
				e.printStackTrace();
			}
			
		}
		
		
		return lRuoli;
	}
	
	public boolean delete(Ruolo r,Connection c ){
		boolean ret = false;
		
		return ret;
	}
	
	public boolean update(Ruolo r,Integer id,Connection c){
		boolean ret = false;
		
		return ret;
	}
	
	
	public boolean insert(Ruolo r,Connection c){
		boolean ret = false;
		
		return ret;
		
	}


	public List<Ruolo> findByWhere(Ruolo r,Connection c){
		List<Ruolo> lRuoli = null;
		
		return lRuoli;
		
	}
}
