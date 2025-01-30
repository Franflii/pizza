package pizza;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pedido {
	private static int id;
	private Cliente cliente;
	private LocalDate fecha;
	private double total;
	private TipoPedido tipo;

	private int contador = 1;

	public Pedido(Cliente cliente, double total, String tipo) {
		this.id = contador++;
		setCliente(cliente);
		setTipo(tipo);
		setTotal(total);
		this.fecha = LocalDate.now();

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getTipo() {
		return this.tipo.toString();
	}

	public void setTipo(String tipo) {
		this.tipo = TipoPedido.valueOf(tipo);
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

}
