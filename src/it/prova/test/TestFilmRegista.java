package it.prova.test;

import it.prova.dao.FilmDao;
import it.prova.dao.RegistaDao;
import it.prova.model.Film;
import it.prova.model.Regista;

public class TestFilmRegista {
	public static void main(String[] args) {
		FilmDao filmDaoIstance = new FilmDao();
		RegistaDao registaDaoIstance = new RegistaDao();

		Regista regista1 = new Regista("Franco", "Rossi", 2);
		Regista regista2 = new Regista("Pippo", "Bianchi", 1);
		Regista regista3 = new Regista("Lello", "Bruno", 0);

		registaDaoIstance.insert(regista1);
		registaDaoIstance.insert(regista2);
		registaDaoIstance.insert(regista3);

		regista1 = registaDaoIstance.findRegista(regista1);
		regista2 = registaDaoIstance.findRegista(regista2);
		regista3 = registaDaoIstance.findRegista(regista3);

		Film twilight = new Film("Comico", 120, regista1);
		Film scream = new Film("Horror", 150, regista2);
		Film fAndF = new Film("Avventura", 200, regista3);

		filmDaoIstance.insert(twilight);
		filmDaoIstance.insert(scream);
		filmDaoIstance.insert(fAndF);

		System.out.println(registaDaoIstance.findByNumeroDiOscarPiuVinti());

	}

}
