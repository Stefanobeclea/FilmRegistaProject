package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Regista;

public class RegistaDao {
	public List<Regista> list() {

		Connection c = null;
		ResultSet rs = null;
		Statement s = null;
		Regista temp = null;
		List<Regista> result = new ArrayList<>();

		try {

			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("select * from regista;");

			while (rs.next()) {
				temp = new Regista();
				temp.setNome(rs.getString("nome"));
				temp.setCognome(rs.getString("cognome"));
				temp.setId(rs.getLong("id"));
				temp.setNumeroOscarVinti(rs.getInt("numero_oscar_vinti"));
				result.add(temp);

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

	// =============================================== INSERT
	public int insert(Regista input) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO regista (nome, cognome, numero_oscar_vinti) VALUES (?, ?, ?)");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setInt(3, input.getNumeroOscarVinti());

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

	// =============================================== UPDATE
	public int update(Regista input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("UPDATE regista SET nome=?, cognome=?, numero_oscar_vinti=? where id=?;");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setInt(3, input.getNumeroOscarVinti());
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

	// =============================================== DELETE
	public int delete(Regista input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from regista where id=?;");
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

	public Regista findByNumeroDiOscarPiuVinti() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Regista result = null;

		try {
			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"Select * from regista where numero_oscar_vinti = (select max(numero_oscar_vinti) from regista)");
			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Regista();
				result.setNome(rs.getString("nome"));
				result.setCognome(rs.getString("cognome"));
				result.setNumeroOscarVinti(rs.getInt("numero_oscar_vinti"));
				result.setId(rs.getLong("id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				c.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public Regista findRegista(Regista input) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Regista result = null;

		try {
			c = MyConnection.getConnection();
			ps = c.prepareStatement("Select * from regista where nome = ? and cognome = ? and numero_oscar_vinti = ?");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setInt(3, input.getNumeroOscarVinti());
			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Regista();
				result.setNome(rs.getString("nome"));
				result.setCognome(rs.getString("cognome"));
				result.setNumeroOscarVinti(rs.getInt("numero_oscar_vinti"));
				result.setId(rs.getLong("id"));
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				c.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
}
