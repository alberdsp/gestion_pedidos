/**
 * 
 */
package gestion_pedidos;

import java.math.*;

/**
 * @author Alber 2023 clase Pedidos
 * 
 */
public class Producto {

	// atributos

	private String Nombre;
	private Double Precio;
	private int Cantidad;

	

	// constructor

	public Producto() {

	}


	// getters y setters

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {

		// lo ponemos por defecto en mayúsculas

		this.Nombre = nombre.toUpperCase();
	}

	public Double getPrecio() {
		return Precio;
	}

	// precio redondeado a 2 decimales

	public void setPrecio(Double precio) {

		this.Precio = Math.round(precio * 100.0) / 100.0;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		this.Cantidad = cantidad;
		
	}
	
	


}
