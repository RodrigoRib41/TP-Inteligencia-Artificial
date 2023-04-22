package search;

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
	
	
	@Override
	public Perception getPercept() {
		
		//VER ANTES COMO HACER EL MOVIMIENTO DE LOS ENEMIGOS
		a.getEstadoAmbiente().actualizarEnemigos();
		
		PokemonPerception perception = new PokemonPerception();

		//Le paso su ubicacion
		perception.setPosicion(a.getPosicion());
		
		//Su energia
		perception.setEnergiaActual(a.getEnergiaPokemon());
		
		//La cantidad de enemigos
		perception.setCantidadEnemigos(a.getCantidadEnemigos());
	
		
		//Poner el indice del nodo donde se encuentra el pokemon actualmente
		//Al tener los adyacentes ya sabe la energia de cualquier entidad que tenga de adyacente
		perception.setAdyacentes(obtenerAdyacentes(a.getGraph().getNodes().get(0)));  
		
		//Como modelar los ciclos de percepcion 
	if(ciclospercepcion==random(5,10)) {	
		
		perception.setUbicaciones(obtenerUbicaciones(a.getGraph()));;
	}
		
		// TODO Auto-generated method stub
		return perception;
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
	
	
	public List<Node> obtenerUbicaciones(Graph graph){
		List<Node> nodes = graph.getNodes();
		//Tengo que devolver solo la ubicacion y que entidad esta alli, borro su energia
	    for (Node node : nodes) {
	    	node.getEntidades().setEnergia(0);
	    }    
	    return nodes;
	}
}

