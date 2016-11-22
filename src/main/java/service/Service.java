package service;

import java.util.List;

import model.*;
import repository.*;

public class Service {
	private Repository repository = new Repository();
	
	public void insertarNuevoIdioma(String nIdioma, String pais) {
		repository.insertarTablaIdiomas(nIdioma);
		repository.insertarTablaPaises(pais, nIdioma);
	}
	
	public void insertarPais(String idioma, String pais) {
		repository.insertarTablaPaises(pais, idioma);
	}
	
	public void crearTablas() {
		repository.crearTablaPaises();
		repository.crearTablaIdiomas();
	}
	
	public void BorrarIdioma(String idioma) {
		repository.BorrarTabla(idioma);
	}

	public List<Paises> listarPaises() {
		return repository.listarPaises();
	}
	
	public List<Idiomas> listarIdiomas() {
		return repository.listarIdiomas();
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
}
