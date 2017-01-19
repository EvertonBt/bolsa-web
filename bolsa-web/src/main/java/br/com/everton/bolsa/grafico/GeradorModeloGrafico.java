package br.com.everton.bolsa.grafico;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.everton.bolsa.indicadores.Indicador;
import br.com.everton.bolsa.indicadores.MediaMovelSimples;
import br.com.everton.bolsa.modelo.SerieTemporal;

public class GeradorModeloGrafico {

	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;
    private String tituloGrafico;
	
	public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim, String tituloGrafico) {
	    this.serie = serie;
	    this.comeco = comeco;
	    this.fim = fim;
	    this.modeloGrafico = new LineChartModel();
	    this.tituloGrafico = tituloGrafico;
	}
	

	
	public void plotaIndicador(Indicador indicador) {
		  LineChartSeries chartSeries = new LineChartSeries(indicador.toString());

		  for (int i = comeco; i <= fim; i++) {
		    double valor = indicador.calcula(i, serie);
		    chartSeries.set(i, valor);
		  }
		  this.modeloGrafico.addSeries(chartSeries);
		  this.modeloGrafico.setLegendPosition("w");
		  this.modeloGrafico.setTitle(tituloGrafico);
		}
	

	 public ChartModel getModeloGrafico() {
		    return this.modeloGrafico;
		  }
	 
	
}