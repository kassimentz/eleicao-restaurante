package com.teste.eleicaoRestaurante.modelo;

public class Voto {

	private String cpf;
	private Restaurante restaurante;
	
	public Voto(){
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	

	@Override
	public String toString() {
		return "Voto [ cpf=" + cpf + ", restaurante="
				+ restaurante + "]";
	}
	
	
	
}
