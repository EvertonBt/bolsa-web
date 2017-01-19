package br.com.everton.bolsa.indicadores;

import br.com.everton.bolsa.modelo.SerieTemporal;

public interface Indicador {

	double calcula(int posicao, SerieTemporal serie);

}