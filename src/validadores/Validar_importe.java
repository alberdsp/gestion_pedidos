package validadores;

import java.text.DecimalFormat;

// Alberto Barberá 2023

// Clase que incorpora una función para validar los importes numéricos, parametro tipo String
// devuelve true si se puede validar
// metodo para devolver el importe tipo Double

public class Validar_importe {
	
	

	public static boolean validarImporte(String importe) {

		Boolean validado = false;
		String impornum = "";

		// sustituimos la coma por el punto

		if (importe.lastIndexOf(",") > -1) {

			importe = importe.replaceAll(",", ".");

		}

		// eliminamos el punto y comprobamos que solo hay números

		if (importe.lastIndexOf(".") > -1) {

			impornum = importe.replaceAll(".", "");

			if (impornum.matches("[0-9]*")) {

				validado = true;

			} else {

				if (importe.matches("[0-9]*")) {

					validado = true;

				}

			}

		}

		return validado;
	}

	
	// creamos una función para devolver el Double correcto 
	
	public static Double importeDouble(String importe) {
		
          Double importedouble = 0.0;
		
		if (validarImporte(importe)){
			
			     // si lleva coma lo pasamos a punto
			
			if (importe.lastIndexOf(",") > -1) {

				importe = importe.replaceAll(",", ".");
				
				
			}
			
			
			 
		 } else {
			 
			 // no se puede convertir y devolvemos 0
			 
			 importe = "";
			 
			 
		 }
		
		
		
		
		   
		  importedouble = Double.parseDouble(importe);
		  



		  
		  System.out.println("precio anted de redondeo " + importedouble);
		
		

		return importedouble;

	}

}
