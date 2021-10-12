package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.*;
import it.prova.model.*;

public class FilmDao {
	public List<Film> list() {

		Connection c = null;
		ResultSet rs = null;
		Statement s = null;
		List<Film> result = new ArrayList<Film>();

		try {

			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("select * from film f inner join regista r on r.id=f.regista_id;");

			while (rs.next()) {
				Film filmTemp = new Film();
				filmTemp.setGenere(rs.getString("f.GENERE"));
				filmTemp.setId(rs.getLong("f.id"));
				filmTemp.setDurata(rs.getInt("f.durata"));

				Regista registaTemp = new Regista();
				registaTemp = new Regista();
				registaTemp.setNome(rs.getString("r.nome"));
				registaTemp.setCognome(rs.getString("r.cognome"));
				registaTemp.setId(rs.getLong("r.id"));
				registaTemp.setNumeroOscarVinti(rs.getInt("r.numero_oscar_vinti"));

				filmTemp.setRegista(registaTemp);
				result.add(filmTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				s.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int insert(Film film) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO film (genere,durata ,regista_id) VALUES (?, ?,?);");
			ps.setString(1, film.getGenere());
			ps.setInt(2, film.getDurata());
			ps.setLong(3, film.getRegista().getId());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int update(Film input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("UPDATE film SET genere=?, durata=?, regista_id=? where id=?;");
			ps.setString(1, input.getGenere());
			ps.setInt(2, input.getDurata());
			ps.setLong(3, input.getRegista().getId());
			ps.setLong(4, input.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int delete(Film input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from film where id=?;");
			ps.setLong(1, input.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
