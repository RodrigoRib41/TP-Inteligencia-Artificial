package search.action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
import estructura.Edge;
import estructura.Node;
import estructura.entidades;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAmbiente;
import search.EstadoPokemon;

public class Moverse extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoPokemon estado= (EstadoPokemon) s;
		
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerLibres(adyacentes);
		
		if(posiblesNodos.size()>0) { //Si es mayor que 0 puedo moverme
		Random rand = new Random();
		
		Node nodoElegido=posiblesNodos.get(0);   //Tomo cualquier camino posible
		
		estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
	//	estado.setAdyacentes(obtenerAdyacentes(nodoElegido));	//Los nuevos nodos adyacentes
		estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
		List<Integer> tiempo = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
		estado.setTiempoPoderEspecial(tiempo);
		estado.setBossDerrotado(true);
		return estado;
		}
		// TODO Auto-generated method stub
		return estado;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return 1.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoPokemon estado= (EstadoPokemon) ast;
		EstadoAmbiente ambiente= (EstadoAmbiente)est;
		
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerLibres(adyacentes);
		
		if(posiblesNodos.size()>0) { //Si es mayor que 0 puedo moverme
		Random rand = new Random();
		
		Node nodoElegido=posiblesNodos.get(0);   //Tomo cualquier camino posible
		
		estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
	//	estado.setAdyacentes(obtenerAdyacentes(nodoElegido));	//Los nuevos nodos adyacentes
		estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
		List<Integer> tiempo = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
		estado.setTiempoPoderEspecial(tiempo);
	//	if(nodoElegido.getId()==6) {
	//	estado.setBossDerrotado(true);
	//	}
	//	else {
			estado.setBossDerrotado(false);
	//	}
		ambiente.setBossDerrotado(false);
	//	ambiente.setAdyacentes(obtenerAdyacentes(nodoElegido));
		ambiente.setCicloPercepcion(ambiente.getCicloPercepcion()+1);
		List<Integer> tiempo2 = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
		ambiente.setTiempoPoderEspecial(tiempo2);
		ambiente.setPosicion(estado.getPosicion());
		System.out.print("Me muevo al nodo " + nodoElegido.getId());
	//	System.out.print("/nTiene de adyacentes " + obtenerAdyacentes(nodoElegido));
		return ambiente;
		}
		
		// TODO Auto-generated method stub
		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Moverse";
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
	    	if (adyacen.getEntidad()==entidades.VACIO) {
	    		posiblesNodos.add(adyacen);
	    	}
	    }
	    return posiblesNodos;
	}
}
