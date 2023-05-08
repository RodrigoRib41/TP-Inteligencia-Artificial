package search;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entidades.Enemigos;
import entidades.entidad;
import estructura.Edge;
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
	private List<Integer> tiempoPoderEspecial=new ArrayList<Integer>(3);
	private List<Boolean> PoderEspecial=new ArrayList<Boolean>();
	private boolean bossDerrotado;
	private List<Node> adyacentes=new ArrayList<Node>();
	private Integer cicloPercepcion;
	

	public EstadoPokemon() {

		initState();
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EstadoPokemon))
			return false;

		EstadoPokemon pokemon = (EstadoPokemon) obj;

		if (this.getCantidadEnemigos() == pokemon.getCantidadEnemigos() 
				&& this.getPosicion()== pokemon.getPosicion() 
				&& this.getCantidadEnergiaBoss()==pokemon.getCantidadEnergiaBoss() 
				&& this.getCicloPercepcion()== pokemon.getCicloPercepcion()  
				&& this.getEnergiaActual()== pokemon.getEnergiaActual()
				&& this.getEnergiaInicial()== pokemon.getEnergiaInicial()
	// falla nose xq			&& this.getTiempoPoderEspecial().equals(pokemon.getTiempoPoderEspecial())
				&& this.getUbicacionBoss()==pokemon.getUbicacionBoss()
				&& this.getAdyacentes().equals(pokemon.getAdyacentes())
				&& this.getPoderEspecial().equals(pokemon.getPoderEspecial())
				&& this.isBossDerrotado()==pokemon.isBossDerrotado()
				)
				 {
		return true;
			
		}

		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		EstadoPokemon nuevoEstado= new EstadoPokemon();
		
		nuevoEstado.setAdyacentes(this.getAdyacentes());
		nuevoEstado.setCantidadEnemigos(this.getCantidadEnemigos());
		nuevoEstado.setCantidadEnergiaBoss(this.getCantidadEnergiaBoss());//ver de pasar la percepcion
		nuevoEstado.setEnergiaActual(this.getEnergiaActual());
		nuevoEstado.setEnergiaInicial(this.getEnergiaInicial());
		nuevoEstado.setPoderEspecial(this.getPoderEspecial());
		nuevoEstado.setPosicion(this.getPosicion());
		nuevoEstado.setTiempoPoderEspecial(this.getTiempoPoderEspecial());
		nuevoEstado.setUbicacionBoss(this.getUbicacionBoss());   //ver de implementar
		nuevoEstado.setCicloPercepcion(this.getCicloPercepcion());
		nuevoEstado.setBossDerrotado(this.isBossDerrotado());
		// TODO Auto-generated method stub
		return nuevoEstado;
	}

	@Override
	public void updateState(Perception p) {
		PokemonPerception percepcion = (PokemonPerception) p;
		
		this.setAdyacentes(percepcion.getAdyacentes());
		this.setCantidadEnemigos(percepcion.getCantidadEnemigos());
		//this.setCantidadEnergiaBoss();              Ver de crear la percepcion de encontrar al boss en nodo adyacente
		this.setEnergiaActual(percepcion.getEnergiaActual());
		this.setPoderEspecial(percepcion.getPoderEspecial());
		this.setPosicion(percepcion.getPosicion());
		this.setTiempoPoderEspecial(percepcion.getTiempoPoderEspecial());
		
		//percepcion.getUbicaciones();				Ver de hacer la busqueda del boss en todos los nodos y devolver su ubicacion
		this.setUbicacionBoss(ubicacionBoss);
		//percepcion.getTiempoSatelite()			Quizas no es necesario que el agente lo sepa
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initState() {
		
		
		bossDerrotado = false;
		bossDerrotado=false;
		cicloPercepcion=0;
		
		
		
	
		// TODO Auto-generated method stub
		
		
	}
	
public List<Node> obtenerAdyacentes(Node node){
		
		List<Node> nodosAdyacentes = new ArrayList<>();
	    List<Edge> edges = node.getEdges();
	    
	    for (Edge edge : edges) {
	        Node adyacentes = edge.getDestination(); // asumiendo que la clase Edge tiene un destino (destination)
	        nodosAdyacentes.add(adyacentes);
	    }
	    return nodosAdyacentes;
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

	public List<Boolean> getPoderEspecial() {
		return PoderEspecial;
	}

	public void setPoderEspecial(List<Boolean> poderEspecial) {
		PoderEspecial = poderEspecial;
	}



	

}
