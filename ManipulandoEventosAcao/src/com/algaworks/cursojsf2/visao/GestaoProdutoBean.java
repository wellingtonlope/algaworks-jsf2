package com.algaworks.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@SessionScoped
public class GestaoProdutoBean {
	
	private List<Produto> produtos;
	private Produto produto;
	
	private Produto produtoSelecionado;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public String obterAjuda() {
		if(this.produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		} else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}
	
	public void verificarInclusao(ActionEvent event) {
		System.out.println("Verificando...");
		if ("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem fabricante");
		}
	}
	
	public void incluir() {
		System.out.println("Incluindo...");
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
}
