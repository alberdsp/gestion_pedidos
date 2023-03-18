/**
 * 
 */
package gestion_pedidos;

import java.util.Date;

/**
 * @author Alber    2023   clase Cliente
 *
 */
public class Cliente {
	
	// declaramos los atributos
	
	private String nombre, apellidos, direccion;
	private String historial = "";
	private Date fechaDeAlta ;
    private int telefono;
    

       
    // generamos el constructor
    
	public Cliente() {
		
		
						
		this.fechaDeAlta = new Date();
		
		}

	// generamos los getter y setters
	
	
	public String getNombre() {
		return nombre;
	}
	
	// ponemos el nombre en minúscula
	
	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
		
	}
	public String getApellidos() {
		return apellidos;
	}
	
	// ponemos los apellidos en mayúscula por defecto 
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	// no hay setter para el historial se realiza por método
	
	public String getHistorial() {
		return historial;
	}
	
	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}
	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	

	// Creamos el método agregarPedido 
	
	// hay que controlar que esté pagado antes de añadirlo
	
	public String agregarPedido(String npedido) {
		
		this.historial = this.historial + npedido + " - " ;
		
		
		return " Pedido Agregado correctamente";
	}
	
	
	
}
