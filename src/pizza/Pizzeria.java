package pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzeria {

	private List<Pizza> pizza;
	private List<Cliente> cliente;
	private List<Pedido> pedido;

	// Constructores

	public Pizzeria() {
		this.pizza = new ArrayList<Pizza>();
		this.cliente = new ArrayList<Cliente>();
		this.pedido = new ArrayList<Pedido>();
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
	
	public void addPedido(Pedido pedidoNuevo) {
		this.pedido.add(pedidoNuevo);
	}

	public void VerClientes() {

		System.out.println("Clientes registrados: " + cliente);
	}

	public void VerPedidos() {
		System.out.println("Pedido " + pedido);
	}

	public void addPizza(Pizza pizzaNueva) {
		if (pizzaNueva == null) {
			throw new IllegalArgumentException("No puede haber pedido sin pizza");
		}

		this.pizza.add(pizzaNueva);
	}

	public void consultarTelefono(Scanner scanner) {
		System.out.println("Dime el numero que quieres buscar");
		String tlf = scanner.next();
		for (Cliente cliente2 : cliente) {
			if (cliente2.getTelefono() == tlf) {
			}
			System.out.println("El cliente es "+cliente);

		}
	}

	public void consultarPizzaIngrediente(Scanner scanner) {
		System.out.println("Dime un ingrediente");
		String ingrediente = scanner.next();

		for (Pizza p : this.pizza) {
			if (p.getIngredientes().contains(ingrediente)) {

			}
			System.out.println("La pizza" + pizza + "si contiene ese ingrediente");	
		}

	}

	public void consultarPizzanoIngrediente(Scanner scanner) {
		System.out.println("Dime un ingrediente");
		String ingrediente = scanner.next();

		for (Pizza p : this.pizza) {
			if (p.getIngredientes() != null && p.getIngredientes().contains(ingrediente)) {

			}
				System.out.println("La pizza" + pizza + "no contiene ese ingrediente");
		
		}
		

	}

}
