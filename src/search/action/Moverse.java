package search.action;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import entidades.*;
import estructura.Edge;
import estructura.Node;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoPokemon;

public class Moverse extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoPokemon estado= (EstadoPokemon) s;
		
		List<Node> adyacentes=estado.getAdyacentes();
		
		List<Node> posiblesNodos=obtenerLibres(adyacentes);
		
		Random rand = new Random();
		 
		Node nodoElegido=posiblesNodos.get(rand.nextInt(posiblesNodos.size()));   //Tomo cualquier camino posible
		 
		 estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
		 estado.setAdyacentes(obtenerAdyacentes(nodoElegido));	//Los nuevos nodos adyacentes
		 estado.setTiempoSatelite(estado.getTiempoSatelite()+1);
		 estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
	//	 estado.setTiempoPoderEspecial(null);                   //Ver de implementar los tiempos del poder especial
		// TODO Auto-generated method stub
		return estado;
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
	
	public List<Node> obtenerLibres(List<Node> node){
		
		List<Node> posiblesNodos= new ArrayList<>();
	    for (Node adyacen : node) {
	    	if (adyacen.getEntidades().getClass()==null) {
	    		posiblesNodos.add(adyacen);
	    	}
	    }
	    return posiblesNodos;
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
		return "Moverse";
	}

}
