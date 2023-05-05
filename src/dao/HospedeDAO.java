package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Hospede;

public class HospedeDAO {

	Connection connection;

	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}

	public void adicionar(Hospede hospede) {
		String sql = "INSERT INTO HOSPEDES(NOME, SOBRENOME, DATA_NASCIMENTO, NACIONALIDADE, TELEFONE, ID_RESERVA)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, hospede.getNome());
			pstm.setString(2, hospede.getSobrenome());
			pstm.setString(3, hospede.getDataNascimento());
			pstm.setString(4, hospede.getNacionalidade());
			pstm.setString(5, hospede.getTelefone());
			pstm.setString(6, hospede.getIdReserva());

			pstm.execute();
			System.out.println("hospede adicionado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Integer id) {
		String sql = "DELETE FROM HOSPEDES WHERE ID = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			System.out.println("hospede removido");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Hospede> listar() {
		String sql = "SELECT * FROM HOSPEDES";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			List<Hospede> lista = new ArrayList<Hospede>();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Hospede hospede = new Hospede(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
							rst.getString(5), rst.getString(6), rst.getString(7));
					lista.add(hospede);
				}
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
