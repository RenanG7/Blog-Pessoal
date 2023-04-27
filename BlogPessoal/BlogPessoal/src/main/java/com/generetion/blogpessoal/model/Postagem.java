package com.generetion.blogpessoal.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //-> Indica ao spring que o objeto é uma tabela
@Table(name = "tb_postagens") //--> define um nome para a tabela ser criada 
public class Postagem {
	// atributos da model de postagem/compos da tabela de postagem
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Atributo texto é Obrigatorio")
	@Size(min = 5, max = 100, message = "O atributo titulo deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;

	@NotBlank(message = "Atributo texto é Obrigatorio")
	@Size(min = 10, max = 1000, message = "O atributo titulo deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;

	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}