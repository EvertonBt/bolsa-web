package br.com.everton.bolsa.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.everton.bolsa.modelo.Negociacao;

public class LeitorXML {

	// Recebe um xml e retorna um objeto ou uma lista de objetos
	 public List<Negociacao> carrega(InputStream inputStream) {
		    XStream stream = new XStream(new DomDriver());
		    stream.alias("negociacao", Negociacao.class);
		    return (List<Negociacao>) stream.fromXML(inputStream);
		  }
}
