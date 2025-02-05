package pizza;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Pedido {
	private  int id;
	private Cliente cliente;
	private LocalDate fecha;
	private double total;
	private TipoPedido tipo;
	private Pizza pizzaPedida;

	private static int contador = 1;

	public Pedido(Cliente cliente, String tipo, Pizza pizza) {
		
		this.id = contador++;
		setCliente(cliente);
		setTipo(tipo);
		this.fecha = LocalDate.now();
		this.pizzaPedida=pizza;

		
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

	public void setTipo(String tipo) {
		this.tipo = TipoPedido.valueOf(tipo);
	}
	
	
	
	

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", total=" + total + ", tipo=" + tipo
				+ ", pizzaPedida=" + pizzaPedida + "]";
	}
	
	

	

}
