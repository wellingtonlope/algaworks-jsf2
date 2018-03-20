package com.algaworks.cursojsf2.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.algaworks.cursojsf2.dominio.Livro;

@ManagedBean
@ApplicationScoped
public class CatalogoLivrosBean {
	
	private List<Livro> livros;
	private Livro livro;
	
	public CatalogoLivrosBean() {
		livros = new ArrayList<Livro>();
		livro = new Livro();
	}
	
	public void incluir() {
		this.livros.add(this.livro);
		this.livro = new Livro();
	}
	
	public List<Livro> getLivros() {
		return livros;
	}
	public Livro getLivro() {
		return livro;
	}
	
	
}
