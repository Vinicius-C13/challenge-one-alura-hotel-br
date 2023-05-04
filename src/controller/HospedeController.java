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
	
	public void adicionar(String nome, String sobrenome, String nascimento, String nacionalidade, String telefone,
			Integer reserva) {
		System.out.println("Adicionando hospede");
		hospedeDAO.adicionar(nome, sobrenome, nascimento, nacionalidade, telefone, reserva);
	}

	public void remover(Integer id) {
		System.out.println("Removendo hospede");
		hospedeDAO.remover(id);
	}

	public List<Hospede> listar() {
		System.out.println("Listando hospedes");
		return hospedeDAO.listar();
	}
	
}
