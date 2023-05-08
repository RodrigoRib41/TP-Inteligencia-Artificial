package search.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import entidades.*;
import estructura.Edge;
import estructura.Graph;
import estructura.Node;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAmbiente;
import search.EstadoPokemon;

public class RecolectarPokebola extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
	
		EstadoPokemon estado= (EstadoPokemon) s;
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerPokebolas(adyacentes);
		
		if(posiblesNodos.size()>0) { //Si es mayor que 0 puedo no pelear
		Random rand = new Random();
		 
		Node nodoElegido=posiblesNodos.get(rand.nextInt(posiblesNodos.size()));
		
		 estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
		 estado.setAdyacentes(obtenerAdyacentes(nodoElegido));	//Los nuevos nodos adyacentes
		
		 List<Integer> tiempo = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
		 estado.setTiempoPoderEspecial(tiempo);
		 
		 estado.setEnergiaActual(estado.getEnergiaActual()+nodoElegido.getEntidad().getEnergia());  //Tomo la energia de la pokebola y la sumo
		 estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
		}
		// TODO Auto-generated method stub
		return estado;
	}
	
public List<Node> obtenerPokebolas(List<Node> node){
		
		List<Node> posiblesNodos= new ArrayList<>();
	    for (Node adyacen : node) {
	    	if (adyacen.getEntidad().equals(entidades.Pokebolas.class)) {  //nose si funca
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
		return 0.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoPokemon estado= (EstadoPokemon) ast;
		EstadoAmbiente ambiente= (EstadoAmbiente)est;
		
		ambiente.setPosicion(estado.getPosicion());
		ambiente.setEnergiaPokemon(estado.getEnergiaActual());
		ambiente.setCicloPercepcion(estado.getCicloPercepcion());
		ambiente.setPoderEspecial(estado.getPoderEspecial());
		
		Graph aux=ambiente.getGraph();
		
		Integer indice=estado.getPosicion();
		aux.getNodes().get(indice).setEntidad(null);
		
		ambiente.setGraph(aux);
		
		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Recolectar Pokebola";
	}

}
