package pizza;

import java.time.LocalDate;
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

	// Métodos

	// Método para ver todas las pizzas disponibles en la pizzería
	public void verPizzas() {
		System.out.println("Lista de Pizzas:");
		System.out.println("==============================");
		for (Pizza pizza : pizza) {
			System.out.println("ID: " + pizza.getId());
			System.out.println("Nombre: " + pizza.getNombre());
			System.out.println("Ingredientes: " + pizza.getIngredientes());
			System.out.println("Precio: " + pizza.getPrecio() + "€");
			System.out.println("------------------------------");
		}
	}

	// Agregar un nuevo cliente a la lista
	public void addCliente(Cliente clienteNuevo) {
		if (clienteNuevo == null) {
			throw new IllegalArgumentException("No puede ser null el cliente");
		}
		this.cliente.add(clienteNuevo);
	}

	// Agregar un nuevo pedido a la lista
	public void addPedido(Pedido pedidoNuevo) {
		this.pedido.add(pedidoNuevo);
	}

	// Método para ver todos los clientes registrados en la pizzería
	public void verCliente() {
		System.out.println("Lista de Clientes:");
		System.out.println("==============================");
		for (Cliente cliente : cliente) {
			System.out.println("ID: " + cliente.getId());
			System.out.println("Nombre: " + cliente.getNombre());
			System.out.println("Dirección: " + cliente.getDireccion());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Teléfono: " + cliente.getTelefono());
			System.out.println("Saldo disponible: " + cliente.getDineroDisponible() + "€");
			System.out.println("------------------------------");
		}
	}

	// Método para mostrar los pedidos realizados junto con su total
	public void verPedidos() {
		for (Pedido pedido : pedido) {
			System.out.println("Pedido ID: " + pedido.getId());
			System.out.println("Cliente: " + pedido.getCliente().getNombre());
			System.out.println("Tipo de pedido: " + pedido.getTipo());

			System.out.println("Pizzas en el pedido:");
			double total = 0; // Variable para almacenar el total del pedido
			for (Pizza pizza : pedido.getPizzas()) {
				System.out.println("  - " + pizza.getNombre() + " (" + pizza.getPrecio() + "€)");
				total += pizza.getPrecio(); // Sumar el precio de cada pizza al total
			}

			System.out.println("Total del pedido: " + total + "€");
			System.out.println("-------------------------");
		}
	}

	// Método para agregar una nueva pizza al menú
	public void addPizza(Pizza pizzaNueva) {
		if (pizzaNueva == null) {
			throw new IllegalArgumentException("No puede haber pedido sin pizza");
		}
		this.pizza.add(pizzaNueva);
	}

	// Método para buscar un cliente por su número de teléfono
	public void consultarTelefono(String telefono) {
//		System.out.println("Dime el numero que quieres buscar");
//		String tlf = scanner.next();
		boolean encontrado = false;

		for (Cliente cliente2 : cliente) {
			if (cliente2.getTelefono().contains(telefono)) {
				System.out.println("El cliente es: " + cliente2);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No se ha encontrado ningún cliente con ese número de teléfono.");
		}
	}

	// Método para buscar pizzas que contengan un ingrediente específico
	public void consultarPizzaIngrediente(Scanner scanner) {
		System.out.println("Dime un ingrediente");
		String ingrediente = scanner.next().toLowerCase();
		boolean encontrado = false;

		for (Pizza p : pizza) {
			if (p.getIngredientes().toLowerCase().contains(ingrediente)) {
				System.out.println("La pizza " + p + " sí contiene ese ingrediente");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No se ha encontrado ninguna pizza con ese ingrediente");
		}
	}

	// Método para buscar pizzas que NO contengan un ingrediente específico
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

	// Método para verificar si un cliente con un ID específico está registrado
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

	// Método para ver los pedidos consumidos en el local
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

	// Método para ver los pedidos que son para recoger en tienda
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

	// Método para ver los pedidos a domicilio
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

	// Método para ver los pedidos realizados hoy
	public void verPedidosDeHoy() {
		LocalDate hoy = LocalDate.now();
		boolean hayPedidosHoy = false;

		System.out.println("Pedidos realizados hoy:");
		for (Pedido pedido : pedido) {
			if (pedido.getFecha().equals(LocalDate.now().minusDays(1))) {
				System.out.println(pedido);
				hayPedidosHoy = true;
			}
		}

		if (!hayPedidosHoy) {
			System.out.println("No se han realizado pedidos hoy.");
		}
	}

	// Método para ver el último pedido realizado
//	public void ultimoPedido() {
//		Pedido ultimoPedido = pedido.get(pedido.size() - 1);
//		System.out.println("Último pedido realizado: " + ultimoPedido);
//	}
}
