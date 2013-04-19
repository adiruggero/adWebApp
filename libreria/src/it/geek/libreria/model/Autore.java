package it.geek.libreria.model;
import java.util.List;
import it.geek.libreria.model.Libro;
	
	public class Autore {
		
		private String codiceFiscale;
		private String nome;
		private String cognome;
		private List<Libro> lLibro;
		
		
		public String getCodiceFiscale() {
			return codiceFiscale;
		}
		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCognome() {
			return cognome;
		}
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		public List<Libro> getlLibro() {
			return lLibro;
		}
		public void setlLibro(List<Libro> lLibro) {
			this.lLibro = lLibro;
		}
		
	}

