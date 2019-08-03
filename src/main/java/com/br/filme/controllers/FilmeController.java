package com.br.filme.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.filme.models.Filme;
import com.br.filme.services.FilmeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

	@Autowired
	private FilmeService filmeService;

	@GetMapping
	public ResponseEntity<?> exibirFilmes() {
		if (filmeService.quantidadeFilmes() > 0) {

			return ResponseEntity.ok(filmeService.pegarTodos());
		}
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> filmePorId(@PathVariable int id) {
		try {
			return ResponseEntity.ok(filmeService.pegarPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PostMapping("/novo")
	public ResponseEntity<Filme> salvarMansagem(@Valid @RequestBody Filme filme) {
		filmeService.salvarFilme(filme);
		return ResponseEntity.status(HttpStatus.CREATED).body(filme);

	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> atualizarFilme(@PathVariable int id, @Valid @RequestBody Filme filme) {
		try {
			filme.setId(id);
			filmeService.atualizarFilme(id, filme);
			return ResponseEntity.ok().body(filme);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletarFilme(@PathVariable int id) {

		try {
			filmeService.deletarFilme(id);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/alugar/{id}")
	public ResponseEntity<?> alugarFilme(@PathVariable int id) {
		try {
			filmeService.alugarFilme(id);
			return ResponseEntity.ok().body(filmeService.pegarPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		

	}

	@GetMapping("/devolver/{id}")
	public ResponseEntity<?> devolverFilme(@PathVariable int id) {
		try {
			filmeService.devolverFilme(id);
			return ResponseEntity.ok().body(filmeService.pegarPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		

	}

}
