package modelo;

public class Reserva {

	private int id;
	private String dataEntrada;
	private String dataSaida;
	private double valor;
	private String formaPagamento;
	
	public Reserva(int id, String dataEntrada, String dataSaida, double valor, String formaPagamento) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public int getId() {
		return id;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public double getValor() {
		return valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}
	
	
	
}
