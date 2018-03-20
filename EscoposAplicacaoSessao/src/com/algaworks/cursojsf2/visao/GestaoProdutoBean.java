package com.algaworks.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@SessionScoped //Sessão do usuário
//@ApplicationScoped //Até a aplicação ser finalizada
public class GestaoProdutoBean {
	
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

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
