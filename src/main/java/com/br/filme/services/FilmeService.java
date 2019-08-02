package com.br.filme.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.filme.models.Filme;
import com.br.filme.repositories.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	public long quantidadeFilmes() {
		return filmeRepository.count();

	}

	public Iterable<Filme> pegarTodos() {
		return filmeRepository.findAll();
	}

	public Filme pegarPorId(int id) {
		return filmeRepository.findById(id).get();
	}

	public void salvarFilme(Filme filme) {
		filme.setExemplares(filme.getQuantidadeDisponivel());
		filmeRepository.save(filme);

	}

	public void atualizarFilme(int id, Filme filme) {
		Optional<Filme> optionalFilme = filmeRepository.findById(id);

		
		filme.setId(id);
		filme.setExemplares(filme.getQuantidadeDisponivel());
		filmeRepository.save(filme);

	}

	public void deletarFilme(int id) {
		filmeRepository.deleteById(id);
	}

	public void alugarFilme(int id) {
		Optional<Filme> optionalFilme = filmeRepository.findById(id);

		Filme filme = filmeRepository.findById(id).get();

		if (filme.getQuantidadeDisponivel() > 0) {
			filme.setId(id);
			filme.setQuantidadeDisponivel(filme.getQuantidadeDisponivel() - 1);
			filmeRepository.save(filme);
		}

	}

	public void devolverFilme(int id) {
		Optional<Filme> optionalfilme = filmeRepository.findById(id);

		Filme filme = filmeRepository.findById(id).get();
		
		if(filme.getQuantidadeDisponivel()< filme.getExemplares()) {
			
			filme.setId(id);
			filme.setQuantidadeDisponivel(filme.getQuantidadeDisponivel() + 1);
			filmeRepository.save(filme);
		}

		

	}

}
