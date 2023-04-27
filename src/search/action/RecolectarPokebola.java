package search.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entidades.*;
import estructura.Edge;
import estructura.Node;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoPokemon;

public class RecolectarPokebola extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
	
		EstadoPokemon estado= (EstadoPokemon) s;
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerPokebolas(adyacentes);
		Random rand = new Random();
		 
		Node nodoElegido=posiblesNodos.get(rand.nextInt(posiblesNodos.size()));
		
		 estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
		 estado.setAdyacentes(obtenerAdyacentes(nodoElegido));	//Los nuevos nodos adyacentes
		 estado.setTiempoSatelite(estado.getTiempoSatelite()+1);
	//	 estado.setTiempoPoderEspecial(null);                   //Ver de implementar los tiempos del poder especial
		 estado.setEnergiaActual(estado.getEnergiaActual()+nodoElegido.getEntidades().getEnergia());  //Tomo la energia de la pokebola y la sumo
		 estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
		 //VER COMO ELIMINAR LA POKEBOLA, posiblemente eliminarla desde el ambiente
		
		// TODO Auto-generated method stub
		return estado;
	}
	
public List<Node> obtenerPokebolas(List<Node> node){
		
		List<Node> posiblesNodos= new ArrayList<>();
	    for (Node adyacen : node) {
	    	if (adyacen.getEntidades().getClass()==entidades.Pokebolas.class) {  //nose si funca
	    		posiblesNodos.add(adyacen);
	    	}
	    }
	    return posiblesNodos;
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

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
