package validadores;

public class Validar_tarjeta {

	// delcaramos las variables
	private String ncuenta;
	private String inicuenta;
	private int tipotarj;

	// funcion validar tarjeta

	public Validar_tarjeta() {
	}

	// setters
	public Validar_tarjeta(String ncuenta, int tipotarj) {
		setNcuenta(ncuenta);
		setTipotarj(tipotarj);
	}

	// constructor
	public void setTipotarj(int tipotarj) {
		this.tipotarj = tipotarj;

	}

	public void setNcuenta(String ncuenta) {

		this.ncuenta = ncuenta;

	}

	public boolean validaCuenta() {

		// declaramos variables necesarias
		boolean validaCuenta = false;
		inicuenta = ncuenta.substring(0, 1);
		// creamos un array con los bloques de string separados por espacios
		String[] digicuenta = digicuenta = ncuenta.split(" ");
        
		
		// intentamos validar la tarjeta, si hay fallo no se falida
		
		try {
		switch (tipotarj) {

		
               // evaluamos el caso VISA debe cumplirse todas condiciones
		case 4: {
               
			  
			if (Integer.valueOf(inicuenta) == 4 && digicuenta[0].length() == 4 &&
					Integer.valueOf(digicuenta[1]) >= 0 && digicuenta[1].length() == 4 &&
					Integer.valueOf(digicuenta[2]) >= 0 && digicuenta[2].length() == 4&&
					Integer.valueOf(digicuenta[3]) >= 0 && digicuenta[3].length() == 4 &&
					digicuenta.length == 4) {

				validaCuenta = true;

			}
			break;
		}

		

		 // evaluamos el caso MASTERCARD debe cumplirse todas condiciones
		
		case 5:{

			if (Integer.valueOf(inicuenta) == 5 && digicuenta[0].length() == 4 &&
					Integer.valueOf(digicuenta[1]) >= 0 && digicuenta[1].length() == 4 &&
					Integer.valueOf(digicuenta[2]) >= 0 && digicuenta[2].length() == 4 &&
					Integer.valueOf(digicuenta[3]) >= 0 && digicuenta[3].length() == 4 &&
					digicuenta.length == 4) {

				validaCuenta = true;

			}
			break;
		}

		case 3: {
			
			// evaluamos el caso AMERICAN EXPRESS debe cumplirse todas condiciones
			
			if (Integer.valueOf(inicuenta) == 3 && digicuenta[0].length() == 4 &&
					Integer.valueOf(digicuenta[1]) >= 0 && digicuenta[1].length() == 6 &&
					Integer.valueOf(digicuenta[2]) >= 0 && digicuenta[2].length() == 5 &&
					digicuenta.length == 3) {

				validaCuenta = true;
			}
			break;
		}

		default:
		}
		
           }
           catch (Exception e) {
        	   validaCuenta = false;
           }
		return validaCuenta;
	}

}
