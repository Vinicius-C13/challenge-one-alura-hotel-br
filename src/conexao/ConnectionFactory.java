package conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_alura?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("Voracou1321!");
		comboPooledDataSource.setMinPoolSize(1);

		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao() {
		try {
			Connection connection = this.dataSource.getConnection();
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
