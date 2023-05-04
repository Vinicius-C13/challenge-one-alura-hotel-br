package modelo;

public class Hospede {
	private int id;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String nacionalidade;
	private String telefone;
	private int idReserva;

	public Hospede(int id, String nome, String sobrenome, String dataNascimento, String nacionalidade, String telefone,
			int idReserva) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.idReserva = idReserva;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getIdReserva() {
		return idReserva;
	}
	
	@Override
	public String toString() {
		return "[ID: " + this.id + " Nome: " + this.nome + " " + this.sobrenome + " Nascimento: " + this.dataNascimento + " Nacionalidade: "
				+ this.nacionalidade + " Telefone: " + this.telefone + " Reserva: " + this.idReserva + "]";
	}
}
