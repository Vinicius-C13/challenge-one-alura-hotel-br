package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexao.ConnectionFactory;
import modelo.Reserva;

public class TestaDAO {

	public static void main(String[] args) {
		Reserva reserva = new Reserva("2020-01-01", "2020-01-02", 100, "Teste");
		
		Connection connection = new ConnectionFactory().recuperarConexao();
		
		ReservaDAO dao = new ReservaDAO(connection);
		
		Integer rst = dao.adicionar(reserva);
	}

}
