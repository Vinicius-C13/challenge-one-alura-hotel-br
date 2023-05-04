package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Reserva;

public class ReservaDAO {

	Connection connection;

	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}

	public void adicionar(String entrada, String saida, double valor, String pagamento) {

		String sql = "INSERT INTO RESERVAS(DATA_ENTRADA, DATA_SAIDA, VALOR, FORMA_PAGAMENTO) VALUES (?, ?, ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, entrada);
			pstm.setString(2, saida);
			pstm.setDouble(3, valor);
			pstm.setString(4, pagamento);

			pstm.execute();
			System.out.println("Reserva feita");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remover(Integer id) {
		String sql = "DELETE FROM RESERVAS WHERE ID = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			System.out.println("Reserva removida");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reserva> listar() {
		String sql = "SELECT * FROM RESERVAS";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			List<Reserva> lista = new ArrayList<Reserva>();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Reserva reserva = new Reserva(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4),
							rst.getString(5));
					lista.add(reserva);
				}
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
