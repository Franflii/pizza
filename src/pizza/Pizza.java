package pizza;

public class Pizza {

//Atributos

	private static int id;
	private String nombre;
	private String ingredientes;
	private double precio;

	private int contador = 1;

//Constructor 

	public Pizza(String nombre, String ingredientes, double precio) {
		this.id = contador++;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.precio = precio;

		// Vladi

	}

	// Getters y setter

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
