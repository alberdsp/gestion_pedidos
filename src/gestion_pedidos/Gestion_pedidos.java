
//   gestión de pedidos    Alberto Barberá      01-01-2023

// realizo la practica unicamente con clases aunque se hace dificil 
// para manejarlas y sería mejor con arrays pero aun no las hemos
//visto y mejor no las utilizaré aunco sepa algo de ellas.

package gestion_pedidos;

import java.text.ParseException;
import java.text.DateFormat;

// importamos utilidad para formatear la fecha

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import cliente.Cliente;
import gestion_pago.PasarelaDePago;
import productos.Producto;
import validadores.Validar_fecha;
import validadores.Validar_importe;

public class Gestion_pedidos {

	public static void main(String[] args) {

		// establecemos el formato de fecha a utilizar

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 PasarelaDePago pasarelaPago = new PasarelaDePago();
		// declaramos las variables

		double importe = 0, entregado = 0, cambio = 0, precio = 0;

		String importestr, preciostr;
		int opcionmenu, tiptarj, opcionproducto;
		String initarj = "";
		String ncuenta = "";
		String pagostr;
		boolean cuentavalidada = false;
		boolean salir = false;
		boolean importeok = false;
		boolean menuok = false;
		String devolucion = "";
		int numero = 1, opcionmenu1 = 0, opcionmenu2 = 0;
		String nombre = "";
		String apellidos = "";
		String pedido = "";
		int telefono;
		Double total;
		boolean nombreok = false;
		
		boolean pedidocompleto = false;
		boolean imporvalido = false;
		String adate = "";

		// variable para controlar si se han introducido los datos mínimos para
		// pasar al menú 2

		boolean clientesok = false;
		boolean productosok = false;
		boolean fechaok = false;
	
		Date date;

		// instanciamos la clase cliente y la clase producto para poder usarlas
		// posteriormente
		// intanciamos 3 clientes y 5 productos como dice el enunciado

		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();
		Producto producto4 = new Producto();
		Producto producto5 = new Producto();
		Pedido pedido1 = new Pedido();

		// Menú inicial de la aplicación

		do {

			System.out.println("      Gestion de pedidos 2023");
			System.out.println("***********************************");
			System.out.println("----------MENU PRINCIPAL-----------");
			System.out.println("***********************************");
			System.out.println("  Introduzca los datos iniciales");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("1. Alta de Clientes");
			System.out.println("2. Alta de Productos");
			System.out.println("99. Salir");
			System.out.println("\n");
			System.out.println("\n");

			Scanner sci = new Scanner(System.in);
			opcionmenu = Integer.parseInt(sci.next());

			switch (opcionmenu) {
			//

			case 1: {

				System.out.println("ha elegido alta de clientes");
				menuok = true;
				opcionmenu1 = 1;
				break;
			}

			case 2: {

				System.out.println("Debe rellenar primero los clientes");
				System.out.println("----------------------------------");
				menuok = false;
				opcionmenu1 = 2;
				break;

			}
			case 99: {

				menuok = true;
				System.out.println("_____________________");
				System.out.println("Saliendo del programa");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Opcion incorrecta");

			}
		} while (menuok == false);

		// Evaluamos la opción elegida

		// si el usuario elige opción 1 pasamos a alta de clientes

		if (opcionmenu1 == 1) {

			if (cliente1.getTelefono() == 0) {

				// cliente 1

				System.out.println("Introduzca Nombre del cliente 1");
				Scanner sci = new Scanner(System.in);
				cliente1.setNombre(sci.next());

				System.out.println("Introduzca Apellidos del Cliente 1");

				Scanner sci1 = new Scanner(System.in);
				cliente1.setApellidos(sci1.next());

				System.out.println("Introduzca Dirección Cliente1");

				Scanner sci2 = new Scanner(System.in);
				cliente1.setDireccion(sci2.next());

				// validamos el n de telefono
				boolean tlfok = false;
				String texttlf;

				do {

					System.out.println("Introduzca Telefono Cliente1 9 digitos ");
					Scanner sci3 = new Scanner(System.in);
					tlfok = false;
					texttlf = sci3.next();
					tlfok = telefonoOk(texttlf);

					if (tlfok == true) {

						telefono = Integer.parseInt(texttlf);

						cliente1.setTelefono(telefono);

					}

					if (tlfok == false) {

						System.out.println("formato de telefono no valido");
					}

				} while (tlfok == false);

				// vamos a validar la fecha de alta

				do {

					System.out.println("Introduzca fecha de alta ");
					System.out.println("Formato de  fecha tipo 01/01/2022");
					Scanner sci4 = new Scanner(System.in);
					adate = sci4.nextLine();
					fechaok = Validar_fecha.validaFecha(adate);

				} while (fechaok == false);

				date = Validar_fecha.fechaDate(adate);

				cliente1.setFechaDeAlta(date);
				System.out.println("fecha de Alta:" + formatter.format(date));

				System.out.println("Cliente numero 1 agregado correctamente");
				System.out.println("---------------------------------------");
				System.out.println("Pasamos a dar de alta el cliente 2");
			}

			// pasamos a dar de alta el cliente 2

			// cliente 2 si tlf es vacio

			if (cliente2.getTelefono() == 0) {

				System.out.println("Introduzca Nombre del cliente 2 ");
				Scanner sci = new Scanner(System.in);
				cliente2.setNombre(sci.next());

				System.out.println("Introduzca Apellidos del cliente2");

				Scanner sci1 = new Scanner(System.in);
				cliente2.setApellidos(sci1.next());

				System.out.println("Introduzca Dirección cliente2");

				Scanner sci2 = new Scanner(System.in);
				cliente2.setDireccion(sci2.next());

				// validamos el n de telefono

				boolean tlfok = false;
				String texttlf;

				do {

					System.out.println("Introduzca Telefono cliente2 9 digitos ");
					Scanner sci3 = new Scanner(System.in);
					tlfok = false;
					texttlf = sci3.next();

					tlfok = telefonoOk(texttlf);

					telefono = Integer.parseInt(texttlf);

					if (cliente1.getTelefono() == telefono) {
						tlfok = false;

					}

					if (tlfok == true) {

						telefono = Integer.parseInt(texttlf);

						// comprobamos que no existe el telefono en cliente 1
						// si no se repite lo agregmos
						if (telefono == cliente1.getTelefono()) {
							tlfok = false;
						} else {
							cliente2.setTelefono(telefono);

						}

					}

					if (tlfok == false) {

						System.out.println("formato de telefono no va1lido o en uso");
					}

				} while (tlfok == false);

				// vamos a validar la fecha de alta

				do {

					System.out.println("Introduzca fecha de alta ");
					System.out.println("Formato de  fecha tipo 01/01/2022");
					Scanner sci4 = new Scanner(System.in);
					adate = sci4.nextLine();
					fechaok = Validar_fecha.validaFecha(adate);

				} while (fechaok == false);

				date = Validar_fecha.fechaDate(adate);

				cliente2.setFechaDeAlta(date);
				System.out.println("fecha de Alta:" + formatter.format(date));

				System.out.println("Cliente numero 2 agregado correctamente");
				System.out.println("---------------------------------------");
				System.out.println("Pasamos a dar de alta el cliente 3");
			}

			// fin de alta cliente 2

			if (cliente3.getTelefono() == 0) {

				// cliente 3

				System.out.println("Introduzca Nombre del cliente 3 ");
				Scanner sci = new Scanner(System.in);
				cliente3.setNombre(sci.next());

				System.out.println("Introduzca Apellidos del cliente3");

				Scanner sci1 = new Scanner(System.in);
				cliente3.setApellidos(sci1.next());

				System.out.println("Introduzca Dirección cliente3");

				Scanner sci2 = new Scanner(System.in);
				cliente3.setDireccion(sci2.next());

				// validamos el n de telefono

				boolean tlfok = false;
				String texttlf;

				do {

					System.out.println("Introduzca Telefono cliente3  9 digitos ");
					Scanner sci3 = new Scanner(System.in);
					tlfok = false;
					texttlf = sci3.next();
					tlfok = telefonoOk(texttlf);

					if (tlfok == true) {

						telefono = Integer.parseInt(texttlf);

						// comprobamos que no existe el telefono en cliente 2
						// si no se repite lo agregmos
						if ((telefono == cliente2.getTelefono()) || (telefono == cliente1.getTelefono())) {
							tlfok = false;
						} else {
							cliente3.setTelefono(telefono);

						}

					}

					if (tlfok == false) {

						System.out.println("formato de telefono no valido");
					}

				} while (tlfok == false);

				// vamos a validar la fecha de alta

				do {

					System.out.println("Introduzca fecha de alta ");
					System.out.println("Formato de  fecha tipo 01/01/2022");
					Scanner sci4 = new Scanner(System.in);
					adate = sci4.nextLine();
					fechaok = Validar_fecha.validaFecha(adate);

				} while (fechaok == false);

				date = Validar_fecha.fechaDate(adate);

				cliente3.setFechaDeAlta(date);
				System.out.println("fecha de Alta:" + formatter.format(date));

				System.out.println("Cliente numero 3 agregado correctamente");
				System.out.println("---------------------------------------");
				System.out.println("    Pasamos a dar de alta productos");

				if ((cliente1.getTelefono() != 0) && (cliente2.getTelefono() != 0) && (cliente3.getTelefono() != 0)) {

					// ya tenemos los 3 clientes
					clientesok = true;
				}
			}
		}

		// opción menu 2 productos

		// if ((opcionmenu1 == 2) || (clientesok = true) ) {
		if ((opcionmenu1 == 2) || clientesok == true) {

			// alta del producto 1

			if (producto1.getNombre() == null) {

				System.out.println("Introduzca Nombre del Producto 1 ");

				Scanner sci = new Scanner(System.in);
				nombre = sci.next();

				// comprobamos que nombre sea introducido
				if (nombre.length() < 1) {
					nombreok = false;
				} else {
					producto1.setNombre(nombre);
					nombreok = true;
				}

				// vamos a validar el precio

				do {

					System.out.println("Introduzca precio del Producto 1 ejemplo 12.23 ");

					Scanner sci2 = new Scanner(System.in);

					preciostr = sci2.next();
					imporvalido = false;

					if (Validar_importe.validarImporte(preciostr)) {

						producto1.setPrecio(Validar_importe.importeDouble(preciostr));
						imporvalido = true;

					} else {

						System.out.println("    -----  Importe  erroneo   ------");

						imporvalido = false;

					}

				} while (imporvalido == false);
				
				System.out.println("precio del producto 1" + producto1.getPrecio());
				

			}
			// fin alta prodcuto1

//		}

			// alta producto 2

			if (producto2.getNombre() == null) {

				do {

					System.out.println("Introduzca Nombre del Producto 2 ");
					nombreok = false;
					Scanner sci = new Scanner(System.in);

					nombre = new String(sci.next());
					// nombre = nombre.trim();
					String compara = new String(producto1.getNombre());

					// compara = compara.trim();
					// comprobamos que no se repite nombre

					if (nombre.equalsIgnoreCase(compara)) {
						nombreok = false;
						System.out.println("el nombre ya está en uso");

					} else {
						producto2.setNombre(nombre);
						nombreok = true;

					}

					if (nombreok == false) {

						System.out.println("introduzca un nombre diferente");
					}

				} while (nombreok == false);

				// vamos a validar el precio

				do {

					System.out.println("Introduzca precio del Producto 1 ejemplo 12.23 ");

					Scanner sci2 = new Scanner(System.in);

					preciostr = sci2.next();
					imporvalido = false;

					if (Validar_importe.validarImporte(preciostr)) {

						producto2.setPrecio(Validar_importe.importeDouble(preciostr));
						imporvalido = true;

					} else {

						System.out.println("    -----  Importe  erroneo   ------");

						imporvalido = false;

					}

				} while (imporvalido == false);

			}
			// fin alta prodcuto2

			// alta producto 3

			if (producto3.getNombre() == null) {

				nombreok = false;
				do {

					System.out.println("Introduzca Nombre del Producto 3 ");

					Scanner sci = new Scanner(System.in);

					nombre = sci.next();
					String compara = new String(producto1.getNombre());

					// comprobamos que no se repite nombre

					if ((nombre.equalsIgnoreCase(compara)) || (nombre.equalsIgnoreCase(producto2.getNombre()))) {
						nombreok = false;
						System.out.println("el nombre ya está en uso");
					} else {
						producto3.setNombre(nombre);
						nombreok = true;

					}

					if (nombreok == false) {

						System.out.println("introduzca un nombre diferente");
					}

				} while (nombreok == false);

				// vamos a validar el precio

				do {

					System.out.println("Introduzca precio del Producto 1 ejemplo 12.23 ");

					Scanner sci2 = new Scanner(System.in);

					preciostr = sci2.next();
					imporvalido = false;

					if (Validar_importe.validarImporte(preciostr)) {

						producto3.setPrecio(Validar_importe.importeDouble(preciostr));
						imporvalido = true;

					} else {

						System.out.println("    -----  Importe  erroneo   ------");

						imporvalido = false;

					}

				} while (imporvalido == false);

			}
			// fin alta prodcuto3

			// alta producto 4

			if (producto4.getNombre() == null) {
				nombreok = false;

				do {

					System.out.println("Introduzca Nombre del Producto 4 ");

					Scanner sci = new Scanner(System.in);

					nombre = sci.next();

					String compara = new String(producto1.getNombre());
					// comprobamos que no se repite nombre
					if ((nombre.equalsIgnoreCase(compara)) || (nombre.equalsIgnoreCase(producto2.getNombre()))
							|| (nombre.equalsIgnoreCase(producto3.getNombre()))) {
						nombreok = false;
						System.out.println("el nombre ya está en uso");
					} else {
						producto4.setNombre(nombre);
						nombreok = true;

					}

					if (nombreok == false) {

						System.out.println("introduzca un nombre diferente");
					}

				} while (nombreok == false);

				// vamos a validar el precio

				do {

					System.out.println("Introduzca precio del Producto 1 ejemplo 12.23 ");

					Scanner sci2 = new Scanner(System.in);

					preciostr = sci2.next();
					imporvalido = false;

					if (Validar_importe.validarImporte(preciostr)) {

						producto4.setPrecio(Validar_importe.importeDouble(preciostr));
						imporvalido = true;

					} else {

						System.out.println("    -----  Importe  erroneo   ------");

						imporvalido = false;

					}

				} while (imporvalido == false);

			}
			// fin alta prodcuto4

			// alta producto 5

			if (producto5.getNombre() == null) {
				nombreok = false;

				do {

					System.out.println("Introduzca Nombre del Producto 5 ");

					Scanner sci = new Scanner(System.in);

					nombre = sci.next();

					String compara = new String(producto1.getNombre());

					// comprobamos que no se repite nombre

					if ((nombre.equalsIgnoreCase(compara)) || (nombre.equalsIgnoreCase(producto2.getNombre()))
							|| (nombre.equalsIgnoreCase(producto3.getNombre()))
							|| (nombre.equalsIgnoreCase(producto4.getNombre()))) {
						nombreok = false;
						System.out.println("el nombre ya está en uso");

					} else {
						producto5.setNombre(nombre);
						nombreok = true;

					}

					if (nombreok == false) {

						System.out.println("introduzca un nombre diferente");
					}

				} while (nombreok == false);

				// vamos a validar el precio

				do {

					System.out.println("Introduzca precio del Producto 1 ejemplo 12.23 ");

					Scanner sci2 = new Scanner(System.in);

					preciostr = sci2.next();
					imporvalido = false;

					if (Validar_importe.validarImporte(preciostr)) {

						producto5.setPrecio(Validar_importe.importeDouble(preciostr));
						imporvalido = true;

					} else {

						System.out.println("    -----  Importe  erroneo   ------");

						imporvalido = false;

					}

				} while (imporvalido == false);

				productosok = true;
			}
		}

		// fin alta prodcuto5

		// fin de alta de productos

		if (clientesok == true && productosok == true) {

			do {

				opcionmenu = 0;
				System.out.println("      Gestion de pedidos 2023");
				System.out.println("***********************************");
				System.out.println("----------MENU PEDIDOS-----------");
				System.out.println("***********************************");
				System.out.println("      Seleccione una opcion");
				System.out.println("***********************************");
				System.out.println("\n");
				System.out.println("\n");
				System.out.println("1. Nuevo pedido");
				System.out.println("99. Salir");

				Scanner sci = new Scanner(System.in);
				opcionmenu = Integer.parseInt(sci.next());

				switch (opcionmenu) {
				//

				case 1: {

					System.out.println("Crear nuevo pedido");
					menuok = true;
					opcionmenu1 = 1;
					break;
				}

				case 99: {

					menuok = true;
					System.out.println("_____________________");
					System.out.println("Saliendo del programa");
					System.exit(0);
					break;
				}
				default:
					System.out.println("Opcion incorrecta");

				}
			} while (menuok == false);

		}

		// introducción de pedidos

		if (opcionmenu1 == 1) {

			// Imprimimos clientes

			System.out.println("     Seleccione cliente:      ");
			System.out.println("------------------------------");
			System.out.println("\n");
			System.out.println("1. " + cliente1.getNombre() + "      " + cliente1.getApellidos() + "    Tlef. "
					+ cliente1.getTelefono());
			System.out.println("2. " + cliente2.getNombre() + "      " + cliente2.getApellidos() + "    Tlef. "
					+ cliente2.getTelefono());
			System.out.println("3. " + cliente3.getNombre() + "      " + cliente3.getApellidos() + "    Tlef. "
					+ cliente3.getTelefono());
			System.out.println("\n");

			do {

				clientesok = false;
				Scanner sci = new Scanner(System.in);

				opcionmenu = Integer.parseInt(sci.next());

				// selector cliente

				switch (opcionmenu) {
				//

				case 1: {

					pedido1.agregarCliente(cliente1);
					clientesok = true;

					break;
				}

				case 2: {

					pedido1.agregarCliente(cliente2);
					clientesok = true;
					break;
				}
				case 3: {

					pedido1.agregarCliente(cliente3);
					clientesok = true;
					break;
				}
				default:
					System.out.println("Opcion incorrecta");

				}

			} while (clientesok == false);

			System.out.println("        Cliente añadido   ");

			// fin añadir cliente

			// menú selector productos

			System.out.println("\n");
			System.out.println("\n");
			System.out.println("----------------------------------");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Listado de  Procuctos para añadir:");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("----------------------------------");
			System.out.println("1. " + producto1.getNombre() + "   precio " + producto1.getPrecio());
			System.out.println("2. " + producto2.getNombre() + "   precio " + producto2.getPrecio());
			System.out.println("3. " + producto3.getNombre() + "   precio " + producto3.getPrecio());
			System.out.println("4. " + producto4.getNombre() + "   precio " + producto4.getPrecio());
			System.out.println("5. " + producto5.getNombre() + "   precio " + producto5.getPrecio());
			System.out.println("99. " + " Finalizar el pedido");
			System.out.println("\n");
			System.out.println("\n");

			// cantidad productos añadidos
			int cant_carro = 0;
			int cantidad = 0;

			// introducimos productos

			do {

				System.out.println(" introducir codigo de producto 1");
				Scanner sci = new Scanner(System.in);

				opcionproducto = Integer.parseInt(sci.next());

				System.out.println("seleccione cantidad");

				Scanner sci2 = new Scanner(System.in);

				cantidad = Integer.parseInt(sci.next());

				switch (opcionproducto) {
				//

				case 1: {

					producto1.setCantidad(cantidad);
					pedido1.agregarProducto1(producto1);

					break;
				}

				case 2: {

					producto1.setCantidad(cantidad);
					pedido1.agregarProducto1(producto2);

					break;
				}
				case 3: {

					producto1.setCantidad(cantidad);
					pedido1.agregarProducto1(producto3);

					break;

				}
				case 4: {

					producto1.setCantidad(cantidad);
					pedido1.agregarProducto1(producto4);

					break;
				}

				case 5: {

					producto1.setCantidad(cantidad);
					pedido1.agregarProducto1(producto5);

					break;

				}

				case 99: {
					// forzamos a salir
					pedidocompleto = true;
					break;

				}

				default:
					System.out.println("Opcion incorrecta");

				}

				// fin Switch

			} while (pedidocompleto = false);

			// fin selector primer producto

			// selector segundo producto
			pedidocompleto = false;
			do {

				System.out.println(" introducir codigo de producto 2");
				Scanner sci = new Scanner(System.in);

				opcionproducto = Integer.parseInt(sci.next());

				System.out.println("seleccione cantidad");

				Scanner sci2 = new Scanner(System.in);

				cantidad = Integer.parseInt(sci.next());

				switch (opcionproducto) {
				//

				case 1: {

					pedido1.agregarProducto2(producto1);
					pedido1.getProducto2().setCantidad(cantidad);

					break;
				}

				case 2: {

					pedido1.agregarProducto2(producto2);
					pedido1.getProducto2().setCantidad(cantidad);

					break;
				}
				case 3: {

					pedido1.agregarProducto2(producto3);
					pedido1.getProducto2().setCantidad(cantidad);

					break;

				}
				case 4: {

					pedido1.agregarProducto2(producto4);
					pedido1.getProducto2().setCantidad(cantidad);

					break;
				}

				case 5: {

					pedido1.agregarProducto2(producto5);
					pedido1.getProducto2().setCantidad(cantidad);

					break;

				}

				case 99: {
					// forzamos a salir
					pedidocompleto = true;
					break;

				}

				default:
					System.out.println("Opcion incorrecta");

				}

				// fin Switch

			} while (pedidocompleto = false);

			System.out.println("       Pedido completado");
			System.out.println("-------------------------------");
			pedido1.toString();

		} // fin opción menu alta producto 2

		
		
		// pasamos a pagar en efectivo no puedo implementar más de momento
	
	
	do { 
		
		
		

		System.out.println("-------------------------------  ");
		
		System.out.println("Procesando pago en efectivo");

		total = pedido1.getImporteTotal();
		
		System.out.println("Introduzca importe entregado ejemplo 50.50   ");
		Scanner sci3 = new Scanner(System.in);
		
		 entregado = Validar_importe.importeDouble(sci3.next());
		
	     pasarelaPago.Efectivo(total, entregado);
	     System.out.println(pasarelaPago.Efectivo(total, entregado));
	     System.out.println("Su código de pago es : "+pasarelaPago.getcodigoPago());
		
		
	       if (pasarelaPago.getcodigoPago()>0) {
	    	   
	    	   imporvalido = true; 
	    	   pagostr = String.valueOf(pasarelaPago.getcodigoPago());
	    	   pedido1.getClienteP().agregarPedido(pagostr);
	    	   
	    	   System.out.println("Pedido pagado");   
	    	   
	       }
	     
	    

		
		
		

	} while (imporvalido == false);
	
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// fin programa

	// función para validar el telefono

	private static boolean telefonoOk(String numero) {
		boolean telefonook = false;
		if (numero.length() == 9) {
			if (numero.substring(0, 9).matches("[0-9]*")) {

				if (numero.substring(0, 1).matches("[6-9]*")) {

					telefonook = true;
				}

			}

		}

		return telefonook;

	}

	// función para validar el nombre
	private static boolean nombreOk(String texto, int largo) {
		boolean nombreok = false;

		if (texto.substring(0, largo).matches("[A-Z]*")) {

			nombreok = true;
		}

		return nombreok;

	}

}
