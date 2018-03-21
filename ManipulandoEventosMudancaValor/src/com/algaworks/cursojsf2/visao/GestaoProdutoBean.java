package com.algaworks.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@SessionScoped
public class GestaoProdutoBean {

	private String nomePesquisa;
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	private Produto produto;
	
	private Produto produtoSelecionado;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produtosFiltrados = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void nomePesquisaAlterada(ValueChangeEvent event) {
		System.out.println("Valor atual: " + this.nomePesquisa);
		System.out.println("Novo valor: " + event.getNewValue());
		
		this.produtosFiltrados.clear();
		for (Produto produto : this.produtos) {
			if(produto.getNome() != null && produto.getNome().toLowerCase().startsWith(event.getNewValue().toString().toLowerCase())) {
				this.produtosFiltrados.add(produto);
			}
		}
	}
	
	public String obterAjuda() {
		if(this.produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		} else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}
	
	public void verificarInclusao(ActionEvent event) { 
		if("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem fabricante");
		}
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
		
		this.produtosFiltrados.clear();
		for (Produto produto : this.produtos) {
			if(produto.getNome() != null && produto.getNome().toLowerCase().startsWith(this.nomePesquisa.toString().toLowerCase())) {
				this.produtosFiltrados.add(produto);
			}
		}
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
}
