package pizza;

public class Pizza {

//Atributos

	private String nombre;
	private String ingredientes;
	double precio;

//Constructor 

	public Pizza(String nombre, String ingredientes, double precio) {

		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.precio = precio;
		
		//Vladi

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

		if (this.ingredientes == null || this.ingredientes.isBlank()) {
			throw new IllegalArgumentException("La pizza tiene que tener ingredientes");

		}

		this.ingredientes = ingredientes;

	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {

		if (this.precio > 0) {

		}

		this.precio = precio;
	}

//Métodos

	@Override
	public String toString() {
		return "Pizza: " + nombre;
	}

}
