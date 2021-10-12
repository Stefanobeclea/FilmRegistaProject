package it.prova.model;

public class Regista {
	private long id;
	private String nome;
	private String cognome;
	private int numeroOscarVinti;
	private Film film;

	public Regista() {
		// TODO Auto-generated constructor stub
	}

	public Regista(String nome, String cognome, int numeroOscarVinti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numeroOscarVinti = numeroOscarVinti;
	}

	public Regista(long id, String nome, String cognome, int numeroOscarVinti) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroOscarVinti = numeroOscarVinti;
	}

	public long getId() {
		return id;
	}

	public Regista(long id, String nome, String cognome, int numeroOscarVinti, Film film) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroOscarVinti = numeroOscarVinti;
		this.film = film;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getNumeroOscarVinti() {
		return numeroOscarVinti;
	}

	public void setNumeroOscarVinti(int numeroOscarVinti) {
		this.numeroOscarVinti = numeroOscarVinti;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public String toString() {
		return "Regista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", numero_oscar_vinti="
				+ numeroOscarVinti + "]";
	}
}
