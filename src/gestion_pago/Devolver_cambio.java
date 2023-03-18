package gestion_pago;

public class Devolver_cambio {

	private double importe, entregado;

	
	public Devolver_cambio() {
	}

	// setters
	public Devolver_cambio(double importe, double entregado) {
		setImporte(importe);
		setEntregado(entregado);
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setEntregado(double entregado) {
		this.entregado = entregado;
	}

	// declaramos método que devuelve el string con el cambio
	
	public String cambioFinal() {
		
		String cambio_final = "";

		// variables para almacenar las cantidades de cada billete y moneda
		//int uni50, uni20, uni10, uni5, unieuro, unicentimo;

		// declaramos las monedas y billetes disponibles y sus valores

		int b50, b20, b10, b5, meuro, mcentimo;
		b50 = 0;
		b20 = 0;
		b10 = 0;
		b5 = 0;
		meuro = 0;
		mcentimo = 0;
		double mresto = entregado - importe;

		// desglosamos los billetes de 50
       
		if (mresto / 50 >= 1) {

			do {

				mresto = mresto - 50;
				b50++;
			}

			while (mresto / 50 >= 1);

		}

		//System.out.println(mresto);

		// desglosamos los billetes de 50

		if (mresto / 20 >= 1) {

			do {

				mresto = mresto - 20;
				b20++;
//		    System.out.println(b50);		
//			System.out.println(mresto);	
			}

			while (mresto / 20 >= 1);

		}



		// desglosamos los billetes de 10

		if (mresto / 10 >= 1) {

			do {

				mresto = mresto - 10;
				b10++;
			}

			while (mresto / 10 >= 1);

		}

	

		// desglosamos los billetes de 5

		if (mresto / 5 >= 1) {

			do {

				mresto = mresto - 5;
				b5++;
			}

			while (mresto / 5 >= 1);

		}



		// desglosamos las monedas de euro

		if (mresto / 1 >= 1) {

			do {

				mresto = mresto - 1;
				meuro++;
			}

			while (mresto / 1 >= 1);

		}



		// desglosamos las monedas de euro

		if (mresto / 0.01 >= 0.01) {

			do {

				mresto = mresto - 0.01;
				mcentimo++;
			}

			while (mresto / 0.01 >= 0.00);

		}

		// montamos la cadena que mostrará el cambio, solo mostramos 
		// los tipos de billete o moneda a devolver
         if (b50>0) {
        	 cambio_final = b50 +" Billetes de 50 - ";
        	 
         }
         if (b20>0) {
        	 cambio_final = cambio_final + b20 +" Billetes de 20 - ";
        	 
         }
         
         if (b10>0) {
        	 cambio_final = cambio_final + b20 +" Billetes de 10 - ";
        	 
         }
		
         if (b5>0) {
        	 cambio_final = cambio_final + b5 +" Billetes de 5 - ";
        	 
         }
         if (meuro>0) {
        	 cambio_final = cambio_final + meuro +" Monedas de Euro - ";
        	 
         }
         if (mcentimo>0) {
        	 cambio_final = cambio_final + meuro +" Centimos ";
        	 
         }
		
//		cambio_final = b50 +" Billetes 50 " + b20+" Billetes de 20 "+
//		b10+" Billetes de 10  "+b5+" Billetes de 5  "+meuro+" Monedas de Euro  "+ mcentimo+" Centimos";
        
            if (entregado - importe ==0) {
            	cambio_final = " Importe exacto";
            }
         
		return cambio_final;
	}

}
      