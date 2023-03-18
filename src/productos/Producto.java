/**
 * 
 */
package productos;

import java.math.*;

/**
 * @author Alber 2023 clase Pedidos
 * 
 */
public class Producto {

	// atributos

	private String nombre;
	private Double precio;
	private int cantidad;

	

	// constructor

	public Producto() {

	}


	// getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		// lo ponemos por defecto en mayúsculas

		this.nombre = nombre.toUpperCase();
	}

	public Double getPrecio() {
		return precio;
	}

	// precio redondeado a 2 decimales

	public void setPrecio(Double precio) {

		this.precio = Math.round(precio * 100.0) / 100.0;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		
	}
	
	


}
