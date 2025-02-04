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
	public void consultarTelefono(Scanner scanner) {
		System.out.println("Dime el numero que quieres buscar");
		String tlf = scanner.next();
		for (Cliente cliente2 : cliente) {
			if (cliente2.getTelefono()==tlf) {
				System.out.println(cliente2);
			}
		}
	}

	public void consultarPizzaIngrediente  (String ingrediente) {
		
		for (Pizza p : this.pizza) {
			if(p.getIngredientes().contains(ingrediente)) {
				
			}
			
			
		}
		
		
		
		
	}
	
	
public void consultarPizzanoIngrediente (String ingrediente) {
		
		for (Pizza p : this.pizza) {
			if (p.getIngredientes() != null && p.getIngredientes().contains(ingrediente)){
				
			}
			
			
		}
		
		
		
		
	}
		
	
}
