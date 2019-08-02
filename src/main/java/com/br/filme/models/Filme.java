package com.br.filme.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Filme implements Serializable {
	private static final long serilVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Compo nome Obrigatodirio")
	private String nome;

	@NotBlank(message = "Compo link da capa Obrigatodirio")
	private String linkDaCapa;

	@NotNull(message = "Compo ano Obrigatodirio")
	private int ano;

	@NotNull(message = "Compo duração Obrigatodirio")
	private int duracao;

	@NotBlank(message = "Compo genero Obrigatodirio")
	private String genero;

	@NotNull(message = "Compo classificação indicativa Obrigatodirio")
	private int classificacaoIndicativa;

	@NotNull(message = "Compo quantidade disponivel Obrigatodirio")
	private int quantidadeDisponivel;

	public Filme() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLinkDaCapa() {
		return linkDaCapa;
	}

	public void setLinkDaCapa(String linkDaCapa) {
		this.linkDaCapa = linkDaCapa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

}
