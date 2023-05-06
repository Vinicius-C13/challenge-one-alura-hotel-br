package modelo;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer id;
	private String dataEntrada;
	private String dataSaida;
	private double valor;
	private String formaPagamento;

	public Reserva(String dataEntrada, String dataSaida, double valor, String formaPagamento) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}
	
	public Reserva(Integer id, String dataEntrada, String dataSaida, double valor, String formaPagamento) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public Integer getId() {
		return id;
	}

	public String getDataEntrada() {
		return dataEntrada.toString();
	}

	public String getDataSaida() {
		return dataSaida.toString();
	}

	public double getValor() {
		return valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	@Override
	public String toString() {
		return "[ID: " + this.id + " Entrada: " + this.dataEntrada + " Saida: " + this.dataSaida + " Valor: "
				+ this.valor + " Pagamento: " + this.formaPagamento + "]";
	}

}
