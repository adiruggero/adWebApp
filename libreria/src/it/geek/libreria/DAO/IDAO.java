package it.geek.libreria.DAO;

public interface IDAO<E,K> {
	
	public E findById(K id);
	
	
}
