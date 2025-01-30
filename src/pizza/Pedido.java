package pizza;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
	private static int id;
	private Cliente cliente;
	private LocalDate fecha;
	private double total;
	private TipoPedido tipo;
	private List<Pizza> pizzaPedida;


	private int contador = 1;

	public Pedido(Cliente cliente,  String tipo) {
		this.id = contador++;
		setCliente(cliente);
		setTipo(tipo);
		this.fecha = LocalDate.now();

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


	
	
	public void addPizza(Pizza pizzaNueva) {
		if (pizzaNueva==null) {
			throw new IllegalArgumentException("No puede aver pedido sin pizza");
		}
		
		this.pizzaPedida.add(pizzaNueva);
		this.total+=pizzaNueva.getPrecio();
	}

}
