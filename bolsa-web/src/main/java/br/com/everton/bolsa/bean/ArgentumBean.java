package br.com.everton.bolsa.bean;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.everton.bolsa.grafico.GeradorModeloGrafico;
import br.com.everton.bolsa.indicadores.Indicador;
import br.com.everton.bolsa.indicadores.IndicadorFechamento;
import br.com.everton.bolsa.indicadores.MediaMovelPonderada;
import br.com.everton.bolsa.indicadores.MediaMovelSimples;
import br.com.everton.bolsa.modelo.Candle;
import br.com.everton.bolsa.modelo.CandlestickFactory;
import br.com.everton.bolsa.modelo.Negociacao;
import br.com.everton.bolsa.modelo.SerieTemporal;
import br.com.everton.bolsa.ws.ClienteWebService;


//obs: sempre que um Managed Bean usar um escopo maior que o escopo de requisição (padrão) ele deverá implementar
//a interface Serializable
@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {

   private static final long serialVersionUID = 2806365279342807551L;	
   private List<Negociacao> negociacoes;
   private ChartModel modeloGrafico;
   private String nomeMedia;
   private String nomeIndicadorBase;
   private String titulo;
   
   
   public ArgentumBean() {
		  this.negociacoes = new ClienteWebService().getNegociacoes();
		  geraGrafico();
	 
	 
	  }



public void geraGrafico() {
	System.out.println("PLOTANDO: " + nomeMedia + " de " + nomeIndicadorBase);
	List<Candle> candles = new CandlestickFactory().constroiCandles(negociacoes);
	  SerieTemporal serie = new SerieTemporal(candles);

	  GeradorModeloGrafico geradorGrafico = 
	        new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao(),titulo);
	  
	  
	// geradorGrafico.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento()));
	
	  geradorGrafico.plotaIndicador(defineIndicador());
	  
	  
	  this.modeloGrafico = geradorGrafico.getModeloGrafico();
}
   
   
   
  private Indicador defineIndicador() {
   // esse if serve para definir um comportamento padrão quando os valores estão ainda nulos.
	  if (nomeIndicadorBase == null || nomeMedia == null)
		    return new MediaMovelSimples(new IndicadorFechamento());
	  try{
	  String pacote = "br.com.everton.bolsa.indicadores.";
	  Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicadorBase);
	  Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();
	  
	  Class<?> classeMedia = Class.forName(pacote + nomeMedia);
	  Constructor<?> construtorMedia = classeMedia.getConstructor(Indicador.class);
	  Indicador indicador = (Indicador) construtorMedia.newInstance(indicadorBase);
	  return indicador;
	  }catch(Exception e){
		  
		  throw new RuntimeException(e);
	  }
	   
	   
}



public String getNomeMedia() {
	return nomeMedia;
}

public void setNomeMedia(String nomeMedia) {
	this.nomeMedia = nomeMedia;
}

public String getNomeIndicadorBase() {
	return nomeIndicadorBase;
}

public void setNomeIndicadorBase(String nomeIndicadorBase) {
	this.nomeIndicadorBase = nomeIndicadorBase;
}


  
  public ChartModel getModeloGrafico() {
	return modeloGrafico;
}

public void setModeloGrafico(ChartModel modeloGrafico) {
	this.modeloGrafico = modeloGrafico;
}

public List<Negociacao> getNegociacoes() {
    return negociacoes;
  }



public String getTitulo() {
	return titulo;
}



public void setTitulo(String titulo) {
	this.titulo = titulo;
}
}
	
	

