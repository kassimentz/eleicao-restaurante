package com.teste.eleicaoRestaurante.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.teste.eleicaoRestaurante.modelo.Restaurante;
import com.teste.eleicaoRestaurante.modelo.Voto;
import com.teste.eleicaoRestaurante.service.RestauranteService;
import com.teste.eleicaoRestaurante.service.VotoService;
import com.teste.eleicaoRestaurante.util.FacesUtil;

@ManagedBean
@ViewScoped
public class IndexController implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Restaurante restaurante;
	private List<Restaurante> restaurantes;
	private Voto voto;
	private List<Voto> votos;
	private VotoService votoService;
	private int nroVotos;
	
	
	@ManagedProperty("#{restauranteService}")
	private RestauranteService service;

	@PostConstruct
	public void init() {
		restaurantes = service.getRestaurantes();
		limpar();
	}

	public void limpar(){
		voto = new Voto();
	}
	
//	private FacesMessages facesMessages;
	public void Salvar(){
		//salvar os votos em um json - implementar os services
		votoService = new VotoService();
		voto.setData(new Date());
		votoService.Salvar(voto);
		nroVotos = votoService.getNroVotos();
		limpar();
		
		FacesUtil.addSuccessMessage("Voto salvo com sucesso");
		//esta dando erro quando salva o terceiro 
		//com.sun.faces.context.AjaxExceptionHandlerImpl handlePartialResponseError
		//GRAVE: javax.faces.application.ViewExpiredException
//		facesMessages.info("Voto salvo com sucesso!");
	}
	
	public void verificaCpf(){
		votoService = new VotoService();
		boolean encontrou = votoService.verificaEleitor(voto);
		if(encontrou){
			FacesUtil.addErrorMessage("Este CPF já Votou hoje! Seu voto será contabilizado para amanhã!");
			limpar();
		}else{
			voto.setData(new Date());//acrescentar + 1 dia;
		}
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

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}


	public int getNroVotos() {
		return nroVotos;
	}


	public void setNroVotos(int nroVotos) {
		this.nroVotos = nroVotos;
	}
	
	

}
