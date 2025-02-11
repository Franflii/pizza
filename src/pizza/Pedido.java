package pizza;

import java.time.LocalDate;

public class Pedido {
	private int id;
	private Cliente cliente;
	private LocalDate fecha;
	private double total;
	private TipoPedido tipo;
	private Pizza pizzaPedida;

	private static int contador = 1;
	private int ultimoPedido = 0;

	public Pedido(Cliente cliente, String tipo, Pizza pizza) {

		this.id = contador++;
		setCliente(cliente);
		setTipo(tipo);
		this.fecha = LocalDate.now();
		this.pizzaPedida = pizza;

	}

	public int getUltimoPedido() {
		return ultimoPedido;
	}

	public int getId() {
		return id;
	}

	public Pedido(int idCliente, String tipo) {

	}

	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public String getTipo() {
		return this.tipo.toString();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setTipo(String tipo) {
		this.tipo = TipoPedido.valueOf(tipo);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", total=" + total + ", tipo=" + tipo
				+ ", pizzaPedida=" + pizzaPedida + "]";
	}

}
