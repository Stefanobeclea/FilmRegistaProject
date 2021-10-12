package it.prova.model;

public class Film {
	private long id;
	private String genere;
	private int durata;
	private Regista regista;

	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(long id, String genere, int durata) {
		super();
		this.id = id;
		this.genere = genere;
		this.durata = durata;
	}

	public Film(String genere, int durata, Regista regista) {
		super();
		this.genere = genere;
		this.durata = durata;
		this.regista = regista;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public Regista getRegista() {
		return regista;
	}

	public void setRegista(Regista regista) {
		this.regista = regista;
	}
}
