package controller;

import java.sql.Connection;
import java.util.List;

import conexao.ConnectionFactory;
import dao.ReservaDAO;
import modelo.Reserva;

public class ReservaController {

	ReservaDAO reservaDAO;

	public ReservaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.reservaDAO = new ReservaDAO(connection);
	}

	public void adicionar(int id, String dataEntrada, String dataSaida, double valor, String formaPagamento) {
		reservaDAO.adicionar(dataEntrada, dataSaida, valor, formaPagamento);
		System.out.println("Adicionando reserva");
	}

	public void remover(Integer id) {
		reservaDAO.remover(id);
		System.out.println("Removendo reserva");

	}

	public List<Reserva> listar() {
		System.out.println("Listando reservas");
		return reservaDAO.listar();
	}

}
