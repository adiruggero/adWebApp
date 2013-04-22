package it.geek.libreria.DAO;

import java.util.List;

public interface IDAO<E,K> {
	
	public E findById(K id);
	public List<E> findAll();
	public boolean insert(E id);
	public boolean delete(E id);
	public boolean update(E id,K id2);
	
}
