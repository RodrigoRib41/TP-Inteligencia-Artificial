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
	
	
	@Override
	 public boolean agentFailed(Action actionReturned) {
		 List<Node> nodos=this.getEstadoAmbiente().getGraph().getNodes();
		 boolean existePokebola=true;
		 for (Object objeto : nodos) {
			 if(objeto.getClass()==Pokebolas.class) {
				 existePokebola=false;                     //Mientras exista pokebola en el mapa el agente puede seguir
			 }
		 }
		Integer cantidadEnergiaPokemon=this.getEstadoAmbiente().getEnergiaPokemon();
		Integer cantidadEnergiaBoss=this.getEstadoAmbiente().getEnergiaBoss();
		//El agente falla cuando se queda sin energia o cuando no existen mas pokebolas para recolectar y no logro derrotar al boss
		//con la energia actual + los ataques especiales (Lo calculo para el mejor caso que tuviera los 3 ataques especiales)
		 return (cantidadEnergiaPokemon<=0 || ((cantidadEnergiaBoss>cantidadEnergiaPokemon*(1+0.5+0.3+0.2)) && existePokebola)); 
	 }
}

