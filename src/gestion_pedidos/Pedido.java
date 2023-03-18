/**
 * 
 */
package gestion_pedidos;

import java.lang.System;

/**
 * @author Alber 2023 clase Pedido
 *
 */



public class Pedido {

	
	// atributos
	private Producto producto1;
	private Producto producto2;
	private Double importeTotal;
	private PasarelaDePago Pago;
	private String Estado; // PAGADO , PREPARANDO , LISTO , SERVIDO
	private int lineas;  // controlamos las lineas de pedido que hay

	// constructor
	public Pedido() {
		
		
	}

	// getters y setters

	private Cliente clienteP;

	public Cliente getClienteP() {
		return clienteP;
	}

	// cambiamos el nombre al setter para adecuar a la práctica
	public void agregarCliente(Cliente clienteP) {
		this.clienteP = clienteP;
	}

	public Producto getProducto1() {
		return producto1;
	}

	public void agregarProducto1(Producto producto1) {
		this.producto1 = producto1;
		this.importeTotal = (producto1.getPrecio()*producto1.getCantidad());
		if (producto2 != null) {
		this.importeTotal = (producto1.getPrecio()*producto1.getCantidad())+ (producto2.getPrecio()*producto2.getCantidad());
	}else {
		this.importeTotal = (producto1.getPrecio()*producto1.getCantidad());
	}
	}

	public Producto getProducto2() {
		return producto2;
		
	}
	

	public int getLineas() {
		return lineas;
	}

	public void setLineas(int lineas) {
		this.lineas = lineas;
	}

	public void agregarProducto2(Producto producto2) {
		this.producto2 = producto2;
		this.importeTotal = (producto1.getPrecio()*producto1.getCantidad());
		if (producto1 != null) {
		this.importeTotal = (producto1.getPrecio()*producto1.getCantidad())+ (producto2.getPrecio()*producto2.getCantidad());
	}else {
		this.importeTotal = (producto1.getPrecio()*producto1.getCantidad());
	}
	}

	// método para eliminar producto

	public boolean eliminarProducto(int producto) {
		boolean eliminado = false;

		System.out.println(producto1.getNombre());
		// eliminamos el producto 1
		if (producto == 1) {
			System.out.println(" Se ha eliminado " + producto1.getNombre() + " del pedido ");
			producto1 = null;
			eliminado = true;

		}
		// eliminamos el producto 2
		
		if (producto == 2) {
			System.out.println(" Se ha eliminado " + producto2.getNombre() + " del pedido ");
			producto2 = null;
			eliminado = true;

		}

//		System.out.println(producto.toUpperCase());
//		System.out.println(producto1.getNombre());
//		String aeliminar = producto1.getNombre();
//		String aeliminar2 = producto2.getNombre();
//		
//		if (producto.toUpperCase() == aeliminar) {
//             
//			producto1 = null;
//			eliminado = true;
//			System.out.println(producto.toUpperCase());
//			
//		   }    
//		
//		if (producto.toUpperCase() == aeliminar2) {
//
//				producto2 = null;
//				System.out.println("producto2 eliminado");
//				eliminado = true;
//
//			} 
//
//		
//		System.out.println(eliminado);
		return eliminado;

	}
	
	

	public Double getImporteTotal() {
		return importeTotal;
	}

	
	public PasarelaDePago getPago() {
		return Pago;
	}

	public void setPago(PasarelaDePago pago) {
		this.Pago = pago;
						
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		this.Estado = estado;
	}

	// metodos

	// metodo Pagar recibimos un entero para elegir tipo pago
	// 1 Efectivo 2 Tarjeta 3 Cuenta bancaria
	
	
	public int Pagar(int TipoPago) {

		// falta desarrollarlo

		return 0;

	}
	
	

	// método para imprimir el pedido

	@Override

	public String toString() {

		// si existe producto 1

		double totln1 = 0;
		double totln2 = 0;
		int cant1 = 0;
		int cant2 = 0;
		String blprod1 = "";
		String blprec1 = "";
		String bltotln1 = "";
		String blcant1 = "";
		String blcant2 = "";
		String blprod2 = "";
		String blprec2 = "";
		String bltotln2 = "";
		double total = 0;

		// si el objeto producto1 existe rellenamos las variables
		if (producto1 != null) {

			cant1 = producto1.getCantidad();
			totln1 = producto1.getCantidad() * (Math.round(producto1.getPrecio() * 100.0) / 100.0);
			blcant1 = completar("cantidad", Integer.toString(cant1));
			blprod1 = completar("producto", producto1.getNombre());
			blprec1 = completar("precio", Double.toString(producto1.getPrecio()));
			bltotln1 = completar("totln", Double.toString(totln1));

		}

		// si el objeto producto 2 existe

		if (producto2 != null) {
			cant2 = producto2.getCantidad();

			// calculamos los totales

			totln2 = producto2.getCantidad() * (Math.round(producto2.getPrecio() * 100.0) / 100.0);

			// preparamos los bloques

			blcant2 = completar("cantidad", Integer.toString(cant2));

			blprod2 = completar("producto", producto2.getNombre());

			blprec2 = completar("precio", Double.toString(producto2.getPrecio()));

			bltotln2 = completar("totln", Double.toString(totln2));
		}
		total = (Math.round((totln1 + totln2) * 100.0) / 100.0);

		// asignamos total al atributo del pedido

		importeTotal = total;
		// String linea1 = "";

		System.out.println("CANT.               PRODUCTO                PRECIO UD.       TOTAL");
		System.out.println("*****               ********             *************    **********");
		if (producto1 != null) {

			System.out.println(blcant1 + blprod1 + blprec1 + " EUR" + bltotln1 + " EUR");
		}
		if (producto2 != null) {
			System.out.println(blcant2 + blprod2 + blprec2 + " EUR" + bltotln2 + " EUR");
		}
		System.out.println("\n");
		System.out.println("TOTAL ----------------------------------------------->"
				+ completar("precio", Double.toString(total)) + " EUR");

		return "";

		// falta implementar

	}

	// función completar para formatear en bloques de texto la salida de cada
	// elemento
	// parametros campo = al bloque al que corresponde y valor el texto a formatear
	
	
	
	private String completar(String campo, String valor) {

		int tbloqcant = 20;
		int tbloqprod = 20;
		int tbloqpre = 10;
		int tbloqtotln = 10;
		int acompletar = 0;
		int longitudcad = 0;
		String completado = valor;

		// evaluamos si es un campo cantidad

		if (campo == "cantidad") {

			// evaluamos si es mayor el texto de entrada que la salida
			if (tbloqcant >= valor.length()) {
				longitudcad = valor.length();
				acompletar = tbloqcant - longitudcad;

				for (int i = 1; i <= acompletar; i = i + 1) {

					completado = completado + " ";

				}

			} else {

				// si es mayor recortamos cadena
				completado = valor.substring(0, tbloqcant);
			}

		}

		// evaluamos si el campo es producto

		if (campo == "producto") {

			// evaluamos si es mayor el texto de entrada que la salida
			if (tbloqprod >= valor.length()) {

				acompletar = tbloqprod - valor.length();

				for (int i = 1; i <= acompletar; i = i + 1) {

					completado = completado + " ";

				}

			} else {

				// si es mayor recortamos cadena
				completado = valor.substring(0, tbloqcant);
			}

		}

		// evaluamos si el campo es precio
		if (campo == "precio") {

			// evaluamos si es mayor el texto de entrada que la salida
			if (tbloqpre >= valor.length()) {
				longitudcad = valor.length();

				acompletar = tbloqpre - longitudcad;

				for (int i = 1; i <= acompletar; i = i + 1) {

					completado = " " + completado;

				}

			} else {

				// si es mayor recortamos cadena
				completado = valor.substring(0, tbloqcant);
			}

		}

		// evaluamos si el campo es total de la linea
		if (campo == "totln") {

			// evaluamos si es mayor el texto de entrada que la salida
			if (tbloqtotln >= valor.length()) {
				longitudcad = valor.length();
				acompletar = tbloqtotln - longitudcad;

				for (int i = 1; i <= acompletar; i = i + 1) {

					completado = " " + completado;

				}

			} else {

				// si es mayor recortamos cadena
				completado = valor.substring(0, tbloqcant);
			}

		}
		return completado;
	}

}
