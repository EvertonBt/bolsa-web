package br.com.everton.bolsa.indicadores;

import br.com.everton.bolsa.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador{

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getFechamento();
	}

	public String toString() {
	    return "Fechamento";
	  }
	
}
