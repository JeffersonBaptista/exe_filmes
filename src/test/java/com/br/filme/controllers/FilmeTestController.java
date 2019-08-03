package com.br.filme.controllers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.br.filme.models.Filme;
import com.br.filme.services.FilmeService;

@RunWith(SpringRunner.class)
@WebMvcTest(FilmeController.class)
public class FilmeTestController {

	@Autowired
	private MockMvc mockMvc;

	// cria um service falso para teste
	@MockBean
	private FilmeService filmeService;

	private Filme filme;

	@Before
	public void prepararFilme() {

		filme = new Filme();

		filme.setId(null);

		filme.setAno(1990);
		filme.setClassificacaoIndicativa(18);
		filme.setDuracao(145);
		filme.setExemplares(20);
		filme.setGenero("Terror");
		filme.setLinkDaCapa("capa");
		filme.setNome("A casa da colina");
		filme.setQuantidadeDisponivel(20);

	}

	@Test
	public void testarPegarFilmesOK() throws Exception {

		List<Filme> filmes = Arrays.asList(filme);

		given(filmeService.pegarTodos()).willReturn(filmes);
		given(filmeService.quantidadeFilmes()).willReturn(1L);

		this.mockMvc.perform(get("/api/filmes"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[*].id").isNotEmpty());

	}

}
