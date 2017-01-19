package br.com.everton.bolsa.modelo;

import java.io.Serializable;
import java.util.Calendar;

public final class Negociacao implements Serializable {

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if(data == null){
			
			throw new IllegalArgumentException("Data não pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
			  return (Calendar) this.data.clone();
			
	}

	// Apesar de ser um get ele não é um atributo da classe, apenas calcula o
	// volume transferido da negociação
	public double getVolume() {
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar outraData) {
		  return 
				  this.data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH)
				    && this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH)
				    && this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
				  
		}
}