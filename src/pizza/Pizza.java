package pizza;

public class Pizza {

//Atributos

	private  int id;
	private String nombre;
	private String ingredientes;
	private double precio;
	private static Pizza pizzaMasCara;
	private static Pizza pizzaMasBarata;

	private  static int contador = 1;

//Constructor 

	public Pizza(String nombre, String ingredientes, double precio) {
		this.id = contador++;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.precio = precio;
		if (pizzaMasCara==null) {
			pizzaMasCara=this;
			
		}
		if (pizzaMasCara == null || this.precio > pizzaMasCara.precio) {
			pizzaMasCara=this;
		}
		if (pizzaMasBarata==null || this.precio < pizzaMasBarata.precio) {
			pizzaMasBarata=this;
			
		}
		if (this.precio>pizzaMasBarata.precio) {
			pizzaMasBarata=this;
		}
		
		
		

	}

	// Getters y setter

	public static Pizza getPizzaMasBarata() {
		return pizzaMasBarata;
	}

	public int getId() {
		return id;
	}

	public static Pizza getPizzaMasCara() {
		return pizzaMasCara;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {

		if (this.ingredientes == null || ingredientes.isBlank()) {

			throw new IllegalArgumentException("La pizza tiene que tener ingredientes");

		}

		this.ingredientes = ingredientes;

	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {

		if (this.precio > 0) {
			throw new IllegalArgumentException("El precio de las pizzas debe ser más de 0€");
		}

		this.precio = precio;

	}

//Métodos

	@Override
	public String toString() {
		return "Pizza [nombre=" + nombre + ", ingredientes=" + ingredientes + ", precio=" + precio + ", contador="
				+ contador + "]";
	}

}
