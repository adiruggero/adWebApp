package it.geek.libreria.model;

import it.geek.libreria.model.Autore;
import java.util.List;

public class Libro {
	
	private String nomeLibro;
	private String casaEditrice;
	private int numeroPagine;
	private List<Autore> lAutori;
	
	
	
	public String getNomeLibro() {
		return nomeLibro;
	}
	public void setNomeLibro(String nomeLibro) {
		this.nomeLibro = nomeLibro;
	}
	public String getCasaEditrice() {
		return casaEditrice;
	}
	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}
	public int getNumeroPagine() {
		return numeroPagine;
	}
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	public List<Autore> getlAutori() {
		return lAutori;
	}
	public void setlAutori(List<Autore> lAutori) {
		this.lAutori = lAutori;
	}
}
