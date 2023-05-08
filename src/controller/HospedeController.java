package controller;

import java.sql.Connection;
import java.util.List;

import conexao.ConnectionFactory;
import dao.HospedeDAO;
import modelo.Hospede;

public class HospedeController {

	HospedeDAO hospedeDAO;

	public HospedeController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.hospedeDAO = new HospedeDAO(connection);
	}

	public void adicionar(Hospede hospede) {
		hospedeDAO.adicionar(hospede);
	}

	public void deletar(Integer id) {
		hospedeDAO.deletar(id);
	}

	public List<Hospede> listar() {
		return hospedeDAO.listar();
	}
	
	public List<Hospede> listarPorReserva(Integer reservaID) {
		return hospedeDAO.listarPorReserva(reservaID);
	}
	
	public List<Hospede> listarComFiltro(Integer chave) {
		return hospedeDAO.listarComFiltro(chave);
	}

}
