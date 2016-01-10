package com.teste.eleicaoRestaurante.modelo;

public class Restaurante {

	private Long idRestaurante;
	private String nome;
	private boolean escolhidoSemana;

	public Restaurante() {

	}

	public Long getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isEscolhidoSemana() {
		return escolhidoSemana;
	}

	public void setEscolhidoSemana(boolean escolhidoSemana) {
		this.escolhidoSemana = escolhidoSemana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRestaurante == null) ? 0 : idRestaurante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		if (idRestaurante == null) {
			if (other.idRestaurante != null)
				return false;
		} else if (!idRestaurante.equals(other.idRestaurante))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restaurante [idRestaurante=" + idRestaurante + ", nome=" + nome
				+ ", escolhidoSemana=" + escolhidoSemana + "]";
	}
}
