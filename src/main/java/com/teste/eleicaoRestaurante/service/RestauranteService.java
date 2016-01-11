package com.teste.eleicaoRestaurante.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teste.eleicaoRestaurante.modelo.Restaurante;

@ManagedBean(name = "restauranteService", eager = true)
@ApplicationScoped
public class RestauranteService {

	private List<Restaurante> restaurantes;

	@PostConstruct
	public void init() {

		Gson gson = new Gson();
		BufferedReader reader = null;

		try {
			restaurantes = new ArrayList<Restaurante>();
			
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("data/restaurantes.json").getFile());
			
			reader = new BufferedReader(new FileReader(file.getPath()));
			gson = new GsonBuilder().create();
			Restaurante[] restaurante = gson.fromJson(reader,
					Restaurante[].class);

			for (int i = 0; i < restaurante.length; i++) {
				Restaurante r = new Restaurante();
				r.setIdRestaurante(restaurante[i].getIdRestaurante());
				r.setNome(restaurante[i].getNome());
				r.setEscolhidoSemana(restaurante[i].isEscolhidoSemana());

				restaurantes.add(r);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

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
