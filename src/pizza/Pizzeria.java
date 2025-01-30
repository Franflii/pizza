package pizza;

import java.util.List;

public class Pizzeria {

	private List<Pizza> pizza;
	private List<Cliente> cliente;
	private List<Pedido> pedido;
	
	//Constructores
	
	
	public Pizzeria() {
		
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
	
	
	//Metodos
	
	
	public void verPizzas() {
		
		System.out.println("Lista de Pizzas disponibles: " + pizza);
		
	}
	
	public void VerClientes() {
		
	}
	
	public void VerPedidos() {
		
	}
	public void addPizza(Pizza pizzaNueva) {
		if (pizzaNueva==null) {
			throw new IllegalArgumentException("No puede aver pedido sin pizza");
		}
		
		this.pizza.add(pizzaNueva);
	}
	
}
