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

	public Reserva(String string, String string2, int int1, String string3) {
		// TODO Auto-generated constructor stub
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
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 12) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
