package br.com.everton.bolsa.indicadores;

import br.com.everton.bolsa.modelo.SerieTemporal;

public class IndicadorAbertura implements Indicador{

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		
		return serie.getCandle(posicao).getAbertura();
		
		
	}

	public String toString() {
	    return "Abertura";
	  }
	
}
