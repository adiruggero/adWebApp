package it.geek.libreria.DAO;

import java.sql.Connection;
import java.util.List;

public interface IDAO<E,K> {
	
	public E findById(K id,Connection c);
	public List<E> findByWhere(E id,Connection c);
	public List<E> findAll(Connection c);
	public boolean insert(E id,Connection c);
	public boolean delete(E id, Connection c);
	public boolean update(E id,K id2,Connection c);
	
	
}
