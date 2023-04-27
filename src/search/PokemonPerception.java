package search;

import java.util.List;

import estructura.*;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonPerception extends Perception {
	
	private Integer cantidadEnemigos;
	private Integer posicion;
	private Integer energiaInicial;
	private Integer energiaActual;
	// Ubicacion de pokebolas y boss luego de utilizar el satelite
	private Integer tiempoSatelite;
	private List<Integer> tiempoPoderEspecial;
	private List<Node> adyacentes;
	private List<Node> ubicacionesSatelite;
	
	
	
	public PokemonPerception() {

	}
	
	@Override
	public void initPerception(Agent agent, Environment environment) {
		// TODO Auto-generated method stub
		
	}

	public Integer getCantidadEnemigos() {
		return cantidadEnemigos;
	}

	public void setCantidadEnemigos(Integer cantidadEnemigos) {
		this.cantidadEnemigos = cantidadEnemigos;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer integer) {
		this.posicion = integer;
	}

	public Integer getEnergiaInicial() {
		return energiaInicial;
	}

	public void setEnergiaInicial(Integer energiaInicial) {
		this.energiaInicial = energiaInicial;
	}

	public Integer getEnergiaActual() {
		return energiaActual;
	}

	public void setEnergiaActual(Integer energiaActual) {
		this.energiaActual = energiaActual;
	}

	public Integer getTiempoSatelite() {
		return tiempoSatelite;
	}

	public void setTiempoSatelite(Integer tiempoSatelite) {
		this.tiempoSatelite = tiempoSatelite;
	}

	public List<Integer> getTiempoPoderEspecial() {
		return tiempoPoderEspecial;
	}

	public void setTiempoPoderEspecial(List<Integer> tiempoPoderEspecial) {
		this.tiempoPoderEspecial = tiempoPoderEspecial;
	}

	public List<Node> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(List<Node> adyacentes) {
		this.adyacentes = adyacentes;
	}

	public List<Node> getUbicaciones() {
		return ubicacionesSatelite;
	}

	public void setUbicaciones(List<Node> ubicaciones) {
		this.ubicacionesSatelite = ubicaciones;
	}
}
