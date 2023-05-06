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
		System.out.println("Adicionando hospede");
		hospedeDAO.adicionar(hospede);
	}

	public void deletar(Integer id) {
		System.out.println("Removendo hospede");
		hospedeDAO.deletar(id);
	}

	public List<Hospede> listar() {
		System.out.println("Listando hospedes");
		return hospedeDAO.listar();
	}

}
