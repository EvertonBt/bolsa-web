package br.com.everton.bolsa.indicadores;

import br.com.everton.bolsa.modelo.Candle;
import br.com.everton.bolsa.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private Indicador outroIndicador;

	/* (non-Javadoc)
	 * @see br.com.everton.bolsa.indicadores.Indicador#calcula(int, br.com.everton.bolsa.modelo.SerieTemporal)
	 */
	
	
	
	 public MediaMovelSimples(Indicador outroIndicador) {

	this.outroIndicador = outroIndicador;

	}
	
	
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
	  
	    double soma = 0.0;
	
	    for (int i = posicao; i > posicao - 3; i--) {
	     // Candle c = serie.getCandle(i);
	     //soma += c.getFechamento();
	     soma += this.outroIndicador.calcula(i, serie); 
	 
	    }
	    return soma / 3;
	  }
	
	 public String toString() {
		    return "MMS de Fechamento";
		  }
	
}
	
	

