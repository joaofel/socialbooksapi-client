package com.joaofeliciano.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.joaofeliciano.socialbooks.client.LivrosClient;
import com.joaofeliciano.socialbooks.client.domain.Livro;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		LivrosClient livrosClient = new LivrosClient("http://localhost:8080", "admin", "admin");
		
		//Listando os livros
		List<Livro> livros = livrosClient.listar();
		
		for(Livro livro : livros) {
			System.out.println("Livro: " + livro.getNome());
		}
		
		//Criando um livro
		Livro livro = new Livro();
		livro.setNome("Livro Teste Cliente");
		livro.setEditora("Editora Teste");
		livro.setResumo("Livro fala sobre um teste.");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(format.parse("01/03/2014"));
		
		String localizacao = livrosClient.salvar(livro);
		System.out.println("Localização: " + localizacao);
		
		//Buscando Livro
		Livro livroBuscado = livrosClient.buscar(localizacao);
		System.out.println("Livro Buscado: " + livroBuscado.getNome());
	}
}
