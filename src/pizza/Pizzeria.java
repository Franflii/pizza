package pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzeria {

	private List<Pizza> pizza;
	private List<Cliente> cliente;
	private List<Pedido> pedido;
	private Cliente clientee;

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
		for (Pizza p : pizza) {
			System.out.println(p);
		}
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

	public void verCliente() {
		for (Cliente c : cliente) {
			System.out.println(c);
		}
	}

	public  void verPedidos() {
		for (Pedido pedi : pedido) {
			System.out.println(pedi);
		}
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
		boolean encontrado = false;

		for (Cliente cliente2 : cliente) {
			if (cliente2.getTelefono().equals(tlf)) {
				System.out.println("El cliente es: " + cliente2);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No se ha encontrado ningún cliente con ese número de teléfono.");
		}
	}

	public void consultarPizzaIngrediente(Scanner scanner) {
		System.out.println("Dime un ingrediente");
		String ingrediente = scanner.next().toLowerCase();
		boolean encontrado = false;

		for (Pizza p : pizza) {
			if (p.getIngredientes().toLowerCase().contains(ingrediente)) {

				System.out.println("La pizza" + p + "si contiene ese ingrediente");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No se ha encontrado ninguna pizza con ese ingrediente");
		}

	}

	public void consultarPizzaNOIngrediente(Scanner scanner) {
		System.out.println("Dime un ingrediente que no deba contener la pizza:");
		String ingredienteExcluido = scanner.next().toLowerCase();
		boolean encontrado = false;

		for (Pizza p : pizza) {
			if (!p.getIngredientes().toLowerCase().contains(ingredienteExcluido)) {
				System.out.println("La pizza " + p + " no contiene ese ingrediente.");
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println(
					"No se ha encontrado ninguna pizza que no contenga el ingrediente: " + ingredienteExcluido);
		}
	}

	public Cliente estaIdCliente(int idcCliente) {
		boolean esta = false;
		Cliente clienteEsta = clientee;
		for (Cliente cliente2 : this.cliente) {
			if (cliente2.getId() == idcCliente) {
				esta = true;
				clienteEsta = cliente2;
			}
		}
		return clienteEsta;
	}
	public void verPedidosConsumidosLocal() {
	    boolean encontrado = false;

	    for (Pedido pedido : pedido) {
	        if ("LOCAL".equalsIgnoreCase(pedido.getTipo())) {
	            System.out.println(pedido);
	            encontrado = true;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("No hay pedidos consumidos en el local.");
	    }
	}
	
	public void verPedidosConsumidosRecoger() {
	    boolean encontrado = false;

	    for (Pedido pedido : pedido) {
	        if ("RECOGER".equalsIgnoreCase(pedido.getTipo())) {
	            System.out.println(pedido);
	            encontrado = true;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("No hay pedidos para recoger.");
	    }
	}
	
	public void verPedidosConsumidosDomicilio() {
	    boolean encontrado = false;

	    for (Pedido pedido : pedido) {
	        if ("DOMICILIO".equalsIgnoreCase(pedido.getTipo())) {
	            System.out.println(pedido);
	            encontrado = true;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("No hay pedidos para llevar a domicilio.");
	    }
	}
	


}
