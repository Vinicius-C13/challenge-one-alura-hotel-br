package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import modelo.Reserva;

public class ReservaDAO {

	Connection connection;

	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}

	public Integer adicionar(Reserva reserva) {

		String sql = "INSERT INTO RESERVAS(DATA_ENTRADA, DATA_SAIDA, VALOR, FORMA_PAGAMENTO) VALUES (?, ?, ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, reserva.getDataEntrada());
			pstm.setString(2, reserva.getDataSaida());
			pstm.setDouble(3, reserva.getValor());
			pstm.setString(4, reserva.getFormaPagamento());

			pstm.execute();
			
			Integer id = 0;
			try(ResultSet rst = pstm.getGeneratedKeys()) {
				while(rst.next()) {
					id = rst.getInt(1);
					System.out.println("funcionei");
				}
			}
			
			return id;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deletar(Integer id) {
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
					Reserva reserva = new Reserva(rst.getInt(1), rst.getString(2), rst.getString(3),
							rst.getDouble(4), rst.getString(5));
					lista.add(reserva);
				}
			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
