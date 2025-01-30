package pizza;

public class Cliente {

	//Atributos
	
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private double dineroDisponible;
	
	
	//Constructores
	
	public Cliente(String nombre, String direccion,String email,String telefono,String dineroDisponible) {
		
	}

	
	//Setter getter


	public String getNombre() {
		return nombre;
	}


	private void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEmail() {
		return email;
	}


	private void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	private void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public double getDineroDisponible() {
		return dineroDisponible;
	}


	private void setDineroDisponible(double dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}
	
	
	
}
