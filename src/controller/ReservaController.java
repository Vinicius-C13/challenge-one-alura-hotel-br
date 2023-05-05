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

	public void adicionar(Reserva reserva) {
		reservaDAO.adicionar(reserva);
		System.out.println("Adicionando reserva");
	}

	public void remover(String id) {
		reservaDAO.remover(id);
		System.out.println("Removendo reserva");

	}

	public List<Reserva> listar() {
		System.out.println("Listando reservas");
		return reservaDAO.listar();
	}
}
