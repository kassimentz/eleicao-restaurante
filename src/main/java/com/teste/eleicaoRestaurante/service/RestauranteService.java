package com.teste.eleicaoRestaurante.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.teste.eleicaoRestaurante.jsonDao.RestauranteDao;
import com.teste.eleicaoRestaurante.modelo.Restaurante;

@ManagedBean(name = "restauranteService", eager = true)
@ApplicationScoped
public class RestauranteService {

	private List<Restaurante> restaurantes;
	private RestauranteDao dao = new RestauranteDao();
	
	@PostConstruct
	public void init() {
		restaurantes = dao.readJson();
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public Restaurante getRestauranteById(Integer id) {
		Restaurante restaurante = null;
		for (Restaurante r : restaurantes)
			if (r.getIdRestaurante() == id) {
				restaurante = r;
			}
		return restaurante;
	}
}
