package pizza;

public class Cliente {

	// Atributos

	private int id;
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private double dineroDisponible;

	// Atributos estáticos
	private static int contador = 1;
	// Constructores

	public Cliente(String nombre, String direccion, String email, String telefono, double dineroDisponible) {
		this.id = contador++;

		setNombre(nombre);
		setDireccion(direccion);
		setEmail(email);
		setTelefono(telefono);
		setDineroDisponible(getDineroDisponible());
	}

	public int getId() {
		return id;
	}

	public Cliente() {

	}

	// Setter getter

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {

		if (nombre == null || nombre.isBlank() == true) {
			throw new IllegalArgumentException("El nombre no puede estar en blanco ni puede ser nulo.");
		}
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	private void setDireccion(String direccion) {

		if (direccion == null || direccion.isBlank() == true) {
			throw new IllegalArgumentException("La direccion no puede estar en blanco ni puede ser nula.");
		}
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {

		if (email == null || email.isBlank() == true) {
			throw new IllegalArgumentException("El email no puede estar en blanco ni puede ser nulo.");
		}
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	private void setTelefono(String telefono) {

		if (telefono == null || telefono.isBlank() == true) {
			throw new IllegalArgumentException("El telefono no puede estar en blanco ni puede ser nulo.");
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

	// Metodos

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono
				+ ", dineroDisponible=" + dineroDisponible + "]";
	}
}
