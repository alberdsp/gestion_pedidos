/**
 * 
 */
package gestion_pedidos;
import java.util.Date;


/**
 * @author Alber   2023   clase Pasarela de pago
 *
 */
public class PasarelaDePago {
	
	// redondear a 2 decimales
	
	private double importe;  
	// lo generamos con gettime()
	private long codigoPago = 0; 
	// nos dira si se ha realizado el pago correctamente
	
	
	public  PasarelaDePago() {
						}
	/**
	 * realizamos un getter para saber si el pago fue correcto
	 * si se realizó el codigoPago tiene que estar relleno no puede ser
	 * cadena vacia 
	 */
 
	
	
		public long getcodigoPago() {
			return codigoPago;
			
		}
	
		/**
		 * creamos el metodo para el pago en efectivo con devolución,   
		 * usamos la clase creada de la práctica anterior Devolver_cambio
		 * 
		 */
	
	
	public String Efectivo(double total, double entregado) {
					 
		this.importe = total;
		
		Devolver_cambio devolucion = new Devolver_cambio();
		devolucion.setImporte(total);
		devolucion.setEntregado(entregado);
		
	// si el entregado es mayor que el total del pedido validamos el pago	
		 
		
		if (entregado >= total) {
			 
			 Date ahora = new Date();
			
			 this.codigoPago = ahora.getTime(); 
			 
		 }
		return devolucion.Cambio_final();
	}
	
	
	/**
	 * creamos el metodo para el pago con tarjeta,   
	 * usamos la clase creada de la práctica anterior Validar_tarjeta
	 * 
	 */
	
	 public boolean Tarjeta(String ntarjeta) {
		 boolean tarjetavalida = false;  
		  String  initarj = ntarjeta.substring(0, 1);
		  int tiptarj = Integer.valueOf(initarj);  
		  
		  // pasamos parametros ntarjeta y tipo
		  
		  Validar_tarjeta validatarjeta = new Validar_tarjeta(ntarjeta,tiptarj);
		   
		   tarjetavalida = validatarjeta.validaCuenta();
			  		  
		  if (tarjetavalida = true) {
		  
		  Date ahora = new Date();
			
			 this.codigoPago = ahora.getTime(); 
		  }
		  
		 return tarjetavalida;
		 
	 }
	 
	 
	 
	 /**
		 * creamos el metodo para el pago por banco,   
		 *
		 * 
		 */
	 public boolean Cuenta(String ncuenta) {
		    
		 boolean cuentavalida = false;
		 
		  if (ncuenta.length() == 20) {
		   
		   cuentavalida = true;
		  
		  }  	
		  
		  if (cuentavalida  = true) {
		  
		  Date ahora = new Date();
			
			 this.codigoPago = ahora.getTime(); 
		  }else {
			  cuentavalida = false;
		  }
		  
		 return cuentavalida;
	 }
		
}
	


