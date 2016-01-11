package com.teste.eleicaoRestaurante.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.teste.eleicaoRestaurante.modelo.Restaurante;
import com.teste.eleicaoRestaurante.service.RestauranteService;

@ManagedBean
public class IndexController {

	private Restaurante restaurante;
	private List<Restaurante> restaurantes;

	@ManagedProperty("#{restauranteService}")
	private RestauranteService service;

	@PostConstruct
	public void init() {
		restaurantes = service.getRestaurantes();
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public void setService(RestauranteService service) {
		this.service = service;
	}

}
