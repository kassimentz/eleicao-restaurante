package com.teste.eleicaoRestaurante.service;

import java.util.List;

import com.teste.eleicaoRestaurante.modelo.Restaurante;
import com.teste.eleicaoRestaurante.modelo.Voto;

public class VotoService {
	
	public void Salvar(Voto voto){
		//salvar em um json
	}
	
	public List<Voto> getVotos(){
		//ler do json
		return null;
		
	}
	
	public boolean verificaCpf(String cpf){
		//verificar se o cpf ja se encntra na relacao de votantes da semana
		return false;
	}
	
	public Restaurante getVencedor(){
		//aqui eu ja seto o vencedor como true no escolhido da semana
		return null;
		
	}
	
	public int getNroVotos(){
		return 0;
		
	}

}
