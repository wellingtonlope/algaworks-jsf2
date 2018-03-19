package com.algaworks.cursojsf2;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SomaBean {
	
	private int valor1;
	private int valor2;
	private int resultado;
	
	public int getValor1() {
		return valor1;
	}
	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}
	public int getValor2() {
		return valor2;
	}
	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	public void somar() {
		this.setResultado(this.getValor1() + this.getValor2());
	}
	
}
