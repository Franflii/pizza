package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {

	private List<Pizza> pizza;
	private List<Cliente> cliente;
	private List<Pedido> pedido;

	// Constructores

	public Pizzeria() {
		this.pizza = new ArrayList<Pizza>();
	}

	public List<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	// Metodos

	public void verPizzas() {

		System.out.println("Lista de Pizzas disponibles: " + pizza);

	}

	public void addCliente(Cliente clienteNuevo) {
		if (clienteNuevo == null) {
			throw new IllegalArgumentException("No puede ser null el cliente");
		}

		this.cliente.add(clienteNuevo);
	}

	
	public void VerClientes() {
		
		System.out.println("Clientes registrados: " + cliente);
	}

	public void VerPedidos() {

	}

	public void addPizza(Pizza pizzaNueva) {
		if (pizzaNueva == null) {
			throw new IllegalArgumentException("No puede haber pedido sin pizza");
		}

		this.pizza.add(pizzaNueva);
	}

}
