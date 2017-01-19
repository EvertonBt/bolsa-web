package br.com.everton.bolsa.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
public class NegociacaoTest {

	// Testa se a data do objeto negociação é imutável 
	@Test
	public void dataDaNegociacaoEhImutavel() {
	    // se criar um negocio no dia 15...
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.DAY_OF_MONTH, 15);
	    Negociacao n = new Negociacao(10, 5, c);
	    

	    // ainda que eu tente mudar a data para 20...
	    n.getData().set(Calendar.DAY_OF_MONTH, 20);
	    
	    // ele continua no dia 15.
	    assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	  }
	
	// Indica que o objeto negociação não deve aceitar valores null para a data, portanto ele deve lançar uma
	//exceção caso isso aconteça (nesse caso lançar uma exceção quer dizer que deu certo!
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
	  new Negociacao(10, 5, null);
	}
	
	//Testa se as datas são iguais, nesse caso basta usar o equals lá no método isMesmoDia
	@Test
	public void mesmoMilissegundoEhDoMesmoDia() {
	  Calendar agora = Calendar.getInstance();
	  Calendar mesmoMomento = (Calendar) agora.clone();

	  Negociacao negociacao = new Negociacao(40.0, 100, agora);
	  Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	
	
	}
	
	// Compara datas iguais, mas em horários diferentes, nesse caso não basta usar o equals, pois o Calendar contém um timestamp que contém além da data tb a hora
	// Nesse caso deve dar true.
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
	  // usando GregorianCalendar(ano, mes, dia, hora, minuto)
	  Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
	  Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

	  Negociacao negociacao = new Negociacao(40.0, 100, manha);
	  Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}

	// dias iguais mas meses diferentes dever dar falso
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
	  // usando GregorianCalendar(ano, mes, dia, hora, minuto)
	  Calendar novembro = new GregorianCalendar(2011, 11, 20, 8, 30);
	  Calendar outubro = new GregorianCalendar(2011, 10, 20, 15, 30);

	  Negociacao negociacao = new Negociacao(40.0, 100, novembro);
	  Assert.assertFalse(negociacao.isMesmoDia(outubro));
	}
	
	// Dia e mês iguais, mas anos diferentes, deve dar falso.
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
	  // usando GregorianCalendar(ano, mes, dia, hora, minuto)
	  Calendar ano_passado = new GregorianCalendar(2015, 11, 20, 15, 30);
	  Calendar ano_atual = new GregorianCalendar(2016, 11, 20, 15, 30);

	  Negociacao negociacao = new Negociacao(40.0, 100, ano_passado);
	  Assert.assertFalse(negociacao.isMesmoDia(ano_atual));
	}
	
	
	
}
