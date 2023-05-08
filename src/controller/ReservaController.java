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

	public Integer adicionar(Reserva reserva) {
		return reservaDAO.adicionar(reserva);
	}

	public void deletar(Integer id) {
		reservaDAO.deletar(id);
	}

	public List<Reserva> listar() {
		return reservaDAO.listar();
	}
	
	public List<Reserva> listarComFiltro(Integer chave) {
		return reservaDAO.listarComFiltro(chave);
	}
}
