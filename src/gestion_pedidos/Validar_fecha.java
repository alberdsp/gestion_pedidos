package gestion_pedidos;


	
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.text.ParseException;
	public class Validar_fecha{
	   public static boolean validaFecha(String strDate)
	   {
		// chequeamos si la fecha es nula
		   
		if (strDate.trim().equals(""))
		{
		    return true;
		}
		// si no es nula
		else
		{
		    // establecemos el formato de fecha a  dia mes año
			
		    SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		    formatofecha.setLenient(false);
		   // creamos el objeto fecha y lo parseamos
		    try
		    {
		        Date javaDate = formatofecha.parse(strDate); 
		       
		    }
		 // formato invalido
		    catch (ParseException e)
		    {
		        System.out.println(strDate+" es un formato de fecha invalido");
		        return false;
		    }
		    // si la fecha es correcta nos devuelve true
		    return true;
		}
	   }
	   
	   
	   //  función para devolver la fecha formateada
	   
	   public static Date fechaDate( String strDate) {
		   
		   SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		   
		   formatofecha.setLenient(false);
		   Date fechavalida;
		   
		   try
		    {
			   fechavalida = formatofecha.parse(strDate); 
			    
		       
		    }
		 // formato invalido
		    catch (ParseException e)
		    {
		      fechavalida = new Date();  
		       
		    }
		   
		   
		   return fechavalida;
		   
		   
	   }
	  
	}


