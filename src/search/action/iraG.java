package search.action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import estructura.Edge;
import estructura.Node;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAmbiente;
import search.EstadoPokemon;

public class iraG extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoPokemon estado= (EstadoPokemon) s;
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerDestino(adyacentes);
		
		if(posiblesNodos.size()>0) {
			Node nodoElegido=posiblesNodos.get(0); 
			estado.setPosicion(nodoElegido.getId());
			estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
			List<Integer> tiempo = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
			estado.setTiempoPoderEspecial(tiempo);
			estado.setBossDerrotado(true);
			return estado;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoPokemon estado= (EstadoPokemon) ast;
		EstadoAmbiente ambiente= (EstadoAmbiente)est;
		
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerDestino(adyacentes);
		
		if(posiblesNodos.size()>0) {
			Node nodoElegido=posiblesNodos.get(0); 
			estado.setPosicion(nodoElegido.getId());
			estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
			List<Integer> tiempo = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
			estado.setTiempoPoderEspecial(tiempo);
			estado.setBossDerrotado(true);
			
			ambiente.setBossDerrotado(true);
			ambiente.setCicloPercepcion(ambiente.getCicloPercepcion()+1);
			List<Integer> tiempo2 = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
			ambiente.setTiempoPoderEspecial(tiempo2);
			ambiente.setPosicion(estado.getPosicion());
			System.out.print("Me muevo al nodo " + nodoElegido.getId());
			return ambiente;
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
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
	
	public List<Node> obtenerDestino(List<Node> node){
		
		List<Node> posiblesNodos= new ArrayList<>();
	    for (Node adyacen : node) {
	    	if (adyacen.getId()==6) {
	    		posiblesNodos.add(adyacen);
	    	}
	    }
	    return posiblesNodos;
	}

}
