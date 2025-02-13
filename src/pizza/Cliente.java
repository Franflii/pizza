package pizza;

public class Cliente {

	// Atributos
	private int id;
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private double dineroDisponible;

	// Atributo estático
	private static int contador = 1;

	// Constructor
	public Cliente(String nombre, String direccion, String email, String telefono, double dineroDisponible) {
		this.id = contador++;

		setNombre(nombre);
		setDireccion(direccion);
		setEmail(email);
		setTelefono(telefono);
		setDineroDisponible(dineroDisponible);
	}

	public Cliente() {
	}

	public int getId() {
		return id;
	}

	// Getters y Setters

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede estar en blanco ni puede ser nulo.");
		}
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	private void setDireccion(String direccion) {
		if (direccion == null || direccion.isBlank()) {
			throw new IllegalArgumentException("La dirección no puede estar en blanco ni puede ser nula.");
		}
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("El email no puede estar en blanco ni puede ser nulo.");
		}
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	private void setTelefono(String telefono) {
		if (telefono == null || telefono.isBlank()) {
			throw new IllegalArgumentException("El teléfono no puede estar en blanco ni puede ser nulo.");
		}
		this.telefono = telefono;
	}

	public double getDineroDisponible() {
		return dineroDisponible;
	}

	private void setDineroDisponible(double dineroDisponible) {
		if (dineroDisponible < 0) {
			throw new IllegalArgumentException("No tienes dinero disponible");
		}
		this.dineroDisponible = dineroDisponible;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email
				+ ", telefono=" + telefono + ", dineroDisponible=" + dineroDisponible + "]";
	}

}
