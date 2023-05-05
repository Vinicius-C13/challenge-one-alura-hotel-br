package modelo;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private String id;
	private String dataEntrada;
	private String dataSaida;
	private double valor;
	private String formaPagamento;

	public Reserva(String dataEntrada, String dataSaida, double valor, String formaPagamento) {
		this.id = this.getRandomID();
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}
	
	public Reserva(String id, String dataEntrada, String dataSaida, double valor, String formaPagamento) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public String getId() {
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
	
	public String getRandomID() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = "R"+salt.toString();
        return saltStr;
    }

}
