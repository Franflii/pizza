package pizza;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int id;
	private Cliente cliente;
	private LocalDate fecha;
	private double total;
	private TipoPedido tipo;
//	private Pizza pizzaPedida;
	private List<Pizza> pizzas;

	private static int contador = 1;
	private static Pedido ultimoPedido;

	public Pedido(Cliente cliente, String tipo) {
		this.pizzas = new ArrayList<Pizza>();

		this.id = contador++;
		setCliente(cliente);
		setTipo(tipo);
		this.fecha = LocalDate.now();
//		this.pizzaPedida = pizza;
	}

	public Pedido(Cliente cliente, String tipo, LocalDateTime fecha) {
		this.pizzas = new ArrayList<Pizza>();
		this.id = contador++;
		setCliente(cliente);
		setTipo(tipo);
		this.fecha = LocalDate.now().minusDays(1);
		ultimoPedido = this;
	}
	
	public static Pedido getUltimoPedido() {
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

	public List<Pizza> getPizzas() {
		return pizzas;
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

	public void addPizzaPedido(Pizza p) {

		pizzas.add(p);
	}

	public void agregarPizza(Pizza pizzaSeleccionada) {
		this.pizzas.add(pizzaSeleccionada);
	}

	public void eliminarPizza(int nPizza) {
		Pizza eliminada =null;
		for (Pizza pizza : pizzas) {
	
			if (pizza.getId()==nPizza) {
				eliminada=pizza;
				
			}
			
		}
		this.pizzas.remove(eliminada);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", total=" + total + ", tipo=" + tipo
				+ ", pizzas=" + pizzas + "]";
	}

}
