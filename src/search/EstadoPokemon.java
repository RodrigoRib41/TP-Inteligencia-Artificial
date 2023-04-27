package search;

import java.util.List;

import estructura.Node;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoPokemon extends SearchBasedAgentState {
	
	private Integer cantidadEnemigos;
	private Integer posicion;
	private Integer energiaInicial;
	private Integer energiaActual;
	private Integer ubicacionBoss;           
	// Ubicacion de pokebolas y boss luego de utilizar el satelite
	private Integer cantidadEnergiaBoss;
	private Integer tiempoSatelite;
	private List<Integer> tiempoPoderEspecial;
	private boolean bossDerrotado=false;
	private List<Node> adyacentes;
	private Integer cicloPercepcion;
	
	
	
	public Integer getCantidadEnemigos() {
		return cantidadEnemigos;
	}

	public void setCantidadEnemigos(Integer cantidadEnemigos) {
		this.cantidadEnemigos = cantidadEnemigos;
	}



	public Integer getPosicion() {
		return posicion;
	}



	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
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



	public Integer getCantidadEnergiaBoss() {
		return cantidadEnergiaBoss;
	}



	public void setCantidadEnergiaBoss(Integer cantidadEnergiaBoss) {
		this.cantidadEnergiaBoss = cantidadEnergiaBoss;
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



	public boolean isBossDerrotado() {
		return bossDerrotado;
	}



	public void setBossDerrotado(boolean bossDerrotado) {
		this.bossDerrotado = bossDerrotado;
	}
	public List<Node> getAdyacentes() {
		return adyacentes;
	}



	public void setAdyacentes(List<Node> adyacentes) {
		this.adyacentes = adyacentes;
	}


	public EstadoPokemon() {

		initState();
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
		
	}



	public Integer getCicloPercepcion() {
		return cicloPercepcion;
	}



	public void setCicloPercepcion(Integer cicloPercepcion) {
		this.cicloPercepcion = cicloPercepcion;
	}



	public Integer getUbicacionBoss() {
		return ubicacionBoss;
	}



	public void setUbicacionBoss(Integer ubicacionBoss) {
		this.ubicacionBoss = ubicacionBoss;
	}



	

}
