package br.com.everton.bolsa.indicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.everton.bolsa.modelo.Candle;
import br.com.everton.bolsa.modelo.SerieTemporal;

public class GeradorDeSerie {

	public static SerieTemporal criaSerie(double... valores) {
		  List<Candle> candles = new ArrayList<Candle>();
		  for (double d : valores) {
		    candles.add(new Candle(d, d, d, d, 1000, 
		                    Calendar.getInstance()));
		  }
		  return new SerieTemporal(candles);
		}
	
	
}
