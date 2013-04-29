package it.geek.libreria.factory;

import it.geek.libreria.DAO.impl.UtenteDAO;
import it.geek.libreria.DAO.impl.RuoloDAO;
import it.geek.libreria.DAO.impl.AutoreDAO;

public class DaoFactory {
	
	public static UtenteDAO getUtenteDAO(){
		
		return new UtenteDAO();
		
	}
	
	public static RuoloDAO getRuoloDAO(){
		
		return new RuoloDAO();
		
	}
	
	public static AutoreDAO getAutoreDAO(){
		
		return new AutoreDAO();
		
	}
	
}
