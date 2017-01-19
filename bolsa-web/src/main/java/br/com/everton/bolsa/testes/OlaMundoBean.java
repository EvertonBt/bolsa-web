package br.com.everton.bolsa.testes;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	
	  private String mensagem = "Quem é você?";
	  private String nome;
	  
	  public String getMensagem() {
	    return mensagem;
	  }
	
	
	  public String getNome(){
		  
		  return this.nome;
		  
	  }
	
    public void setNome(String nome){
    	this.nome = nome;
    	
    }
   
    public void nomeFoiDigitado() {
        System.out.println("\nChamou o botão");
      }
    
}
