package it.geek.libreria.factory;

import it.geek.libreria.service.UtenteService;
import it.geek.libreria.service.RuoloService;

public class ServiceFactory {

	public static UtenteService getUtenteService(){
		
		return new UtenteService();
	}
	
	public static RuoloService getRuoloService(){
		
		return new RuoloService();
		
	}
	
	
}
