package search.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import estructura.Edge;
import estructura.Graph;
import estructura.Node;
import estructura.entidades;
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
		 
		Node nodoElegido=posiblesNodos.get(0);
		
		 estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
		 estado.setAdyacentes(obtenerAdyacentes(nodoElegido));	//Los nuevos nodos adyacentes
		
		 List<Integer> tiempo = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
		 estado.setTiempoPoderEspecial(tiempo);
		 
		 estado.setEnergiaActual(estado.getEnergiaActual()+nodoElegido.getEnergia());  //Tomo la energia de la pokebola y la sumo
		 estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
		 estado.setBossDerrotado(true);
		 return estado;
		}
		// TODO Auto-generated method stub
		return estado;
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
		
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerPokebolas(adyacentes);
		
		if(posiblesNodos.size()>0) {
			
			
			Node nodoElegido=posiblesNodos.get(0);
			estado.setPosicion(nodoElegido.getId());
			estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
			List<Integer> tiempo = estado.getTiempoPoderEspecial();
			estado.setTiempoPoderEspecial(tiempo);	
		estado.setEnergiaActual(estado.getEnergiaActual()+nodoElegido.getEnergia());
		
		
		ambiente.setPosicion(estado.getPosicion());
		ambiente.setEnergiaPokemon(estado.getEnergiaActual());
		ambiente.setCicloPercepcion(estado.getCicloPercepcion());
		ambiente.setPoderEspecial(estado.getPoderEspecial());
		ambiente.getGraph().getNodes().get(estado.getPosicion()).setEntidad(entidades.VACIO);
		ambiente.setEnergiaPokemon(estado.getEnergiaActual());
		ambiente.setTiempoPoderEspecial(tiempo);
		estado.setBossDerrotado(false);
		
		System.out.print("Recolecto pokebola en nodo: " + nodoElegido.getId());
		
		
		return ambiente;
		}
		return ambiente; 
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Recolectar Pokebola"; 
	}
	
public List<Node> obtenerPokebolas(List<Node> node){
		
		List<Node> posiblesNodos= new ArrayList<>();
	    for (Node adyacen : node) {
	    	if (adyacen.getEntidad()==entidades.POKEBOLA) {  //nose si funca
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

}
