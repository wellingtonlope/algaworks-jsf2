package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@ViewScoped //Enquanto a tela estiver aberta
//@RequestScoped //A cada requisição a finalizado o managedbean
//@NoneScoped //Inicia por demanda a cada requisição ele vai iniciar e matar #{}
public class GestaoProdutoBean implements Serializable{
	
	private List<Produto> produtos;
	private Produto produto;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	@PostConstruct //usado para inicializar algum recurso que o managedbean precisa
	public void inicializar() {
		System.out.println("Inicializou bean");
	}
	
	@PreDestroy //antes do managebean ser destruido
	public void finalizar() {
		System.out.println("Finalizando bean");
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProduto() {
		return produto;
	}
	
}
