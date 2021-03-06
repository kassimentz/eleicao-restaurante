package com.teste.eleicaoRestaurante.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.teste.eleicaoRestaurante.jsonDao.VotoDao;
import com.teste.eleicaoRestaurante.modelo.Restaurante;
import com.teste.eleicaoRestaurante.modelo.Voto;

public class VotoService {

	/**
	 * a principio logica ja esta implementada. falta chamar na view e verificar
	 * o erro com.sun.faces.context.AjaxExceptionHandlerImpl
	 * handlePartialResponseError GRAVE:
	 * javax.faces.application.ViewExpiredException para poder testar
	 */

	VotoDao dao;
	List<Voto> votos;

	public VotoService() {
		dao = new VotoDao();
		votos = dao.readJson();
	}

	public void Salvar(Voto voto) {
		// leio o arquivo, add o obj ao lis que retornou e mando o list
		// novamente para salvar o list

		votos.add(voto);
		dao.saveJson(votos);
	}

	public List<Voto> getVotos() {
		// ler do json
		return dao.readJson();

	}

	public boolean verificaEleitor(Voto v) {
		// verificar se o cpf ja se encontra na relacao de votantes da semana -
		// verificar a data
		boolean encontrou = false;
		for (Voto voto : votos) {
			if ((voto.getCpf().equalsIgnoreCase(v.getCpf()))
					&& (voto.getData() == v.getData())) {
				encontrou = true;
			}
		}
		return encontrou;
	}

	public Restaurante getVencedor() {
		System.out.println("get vencedor");
		Restaurante restauranteVencedor = null;
		int freq = 0;
		for (Voto voto : votos) {

			int freqAnt = freq;
			freq = Collections.frequency(votos, voto.getRestaurante());
			if (freq > freqAnt) {
				restauranteVencedor = voto.getRestaurante();
			}

		}

		// aqui eu ja seto o vencedor como true no escolhido da semana
		setaRestauranteVencedor(restauranteVencedor);

		return restauranteVencedor;

	}

	private void setaRestauranteVencedor(Restaurante restauranteVencedor) {
		for (Voto voto : votos) {
			if (voto.getRestaurante().equals(restauranteVencedor)) {
				voto.getRestaurante().setEscolhidoSemana(true);
			}
		}

	}

	public int getNroVotos() {
		return dao.readJson().size();
	}

	public boolean verificaTerminoVotacao() {
		/*
		 * configurei o termino da votacao para 11:15. a partir deste horario os
		 * votos contam para o proximo dia
		 */

		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.HOUR_OF_DAY) == 22
				&& cal.get(Calendar.MINUTE) >= 15) {
			return true;
		} else {
			return false;
		}
	}


}
