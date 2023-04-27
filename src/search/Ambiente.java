package search;
import entidades.*;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.util.ArrayList;
import java.util.List;

import estructura.*;

public class Ambiente extends Environment {

	private EstadoAmbiente a;
	
public Ambiente() {
		
		this.environmentState= new EstadoAmbiente();
}
	
public EstadoAmbiente getEstadoAmbiente() {
	
	return (EstadoAmbiente) super.getEnvironmentState();
	
}
	
	@Override
	public Perception getPercept() {
		
		//Antes de pasar la percepcion, actualizamos el movimiento de los enemigos
		if(a.getCicloPercepcion()%3==0) {             //Setear de forma random entre 1 y 3 luego de las pruebas
		a.getEstadoAmbiente().actualizarEnemigos();
		}
		
		PokemonPerception perception = new PokemonPerception();

		//Le paso su ubicacion
		perception.setPosicion(a.getPosicion());
		
		//Su energia
		perception.setEnergiaActual(a.getEnergiaPokemon());
		
		//La cantidad de enemigos
		perception.setCantidadEnemigos(a.getCantidadEnemigos());
	
		//Al tener los adyacentes ya sabe la energia de cualquier entidad que tenga de adyacente
		Integer posicion=a.getPosicion();
		perception.setAdyacentes(obtenerAdyacentes(a.getGraph().getNodes().get(posicion)));  
			
	if(a.getCicloPercepcion()%5==0) {	
		perception.setUbicaciones(obtenerUbicaciones(a.getGraph()));          
	} 
		// TODO Auto-generated method stub
		return perception;
	}
	public List<Node> obtenerAdyacentes(Node node){
	
		List<Node> nodosAdyacentes = new ArrayList<>();
	    List<Edge> edges = node.getEdges();
	    
	    for (Edge edge : edges) {
	        Node adyacentes = edge.getDestination(); 
	        nodosAdyacentes.add(adyacentes);
	    }
	    return nodosAdyacentes;
	}
	
	
	public List<Node> obtenerUbicaciones(Graph graph){
		List<Node> nodes = graph.getNodes();
		//Tengo que devolver solo la ubicacion y que entidad esta alli, borro su energia
	    for (Node node : nodes) {
	    	node.getEntidad().setEnergia(0);
	    }    
	    return nodes;
	}
	
	
	@Override
	 public boolean agentFailed(Action actionReturned) {
		 List<Node> nodos=this.getEstadoAmbiente().getGraph().getNodes();
		 boolean existePokebola=true;
		 for (Node objeto : nodos) {
			 if(objeto.getEntidad().getClass()==Pokebolas.class) {
				 existePokebola=false;                     //Mientras exista pokebola en el mapa el agente puede seguir
			 }
		 }
	
		Integer cantidadEnergiaPokemon=this.getEstadoAmbiente().getEnergiaPokemon();
		Integer cantidadEnergiaBoss=this.getEstadoAmbiente().getEnergiaBoss();
		
		Integer cantidadMaxEnergia=cantidadEnergiaPokemon;
		 
		if(this.getEstadoAmbiente().getPoderEspecial().get(0)) {
			cantidadMaxEnergia+= (int) Math.ceil(cantidadMaxEnergia*0.2);
		}
		
		if(this.getEstadoAmbiente().getPoderEspecial().get(1)) {
			cantidadMaxEnergia+= (int) Math.ceil(cantidadMaxEnergia*0.3);
		}
		
		if(this.getEstadoAmbiente().getPoderEspecial().get(2)) {
			cantidadMaxEnergia+= (int) Math.ceil(cantidadMaxEnergia*0.5);
		}
		
		//El agente falla cuando se queda sin energia o cuando no existen mas pokebolas para recolectar y no logro derrotar al boss
		//con la energia actual + los ataques especiales (Lo calculo para el mejor caso que tuviera los 3 ataques especiales)
		 return (cantidadEnergiaPokemon<=0 || ((cantidadEnergiaBoss>cantidadMaxEnergia) && existePokebola)); 
	 }
	
	
}

