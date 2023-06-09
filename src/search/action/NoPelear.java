package search.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import estructura.Edge;
import estructura.Node;
import estructura.entidades;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAmbiente;
import search.EstadoPokemon;

public class NoPelear extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		
EstadoPokemon estado= (EstadoPokemon) s;
		
		List<Node> adyacentes=estado.getAdyacentes();
		
		List<Node> posiblesNodos=obtenerEnemigos(adyacentes);
		
		if(posiblesNodos.size()>0) { //Si es mayor que 0 puedo no pelear
	
		Node nodoElegido=posiblesNodos.get(0);
		
		for (Node objeto : posiblesNodos) {
		    if (objeto.getEnergia() < nodoElegido.getEnergia()) {
		        nodoElegido = objeto;
		    }
		} 
	
		
		if(nodoElegido.getEnergia()>estado.getEnergiaActual()) {
		estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
		estado.setAdyacentes(obtenerAdyacentes(nodoElegido));
				 
		List<Integer> tiempo = estado.getTiempoPoderEspecial().stream().map(n -> n + 1).collect(Collectors.toList());
		estado.setTiempoPoderEspecial(tiempo);
				 
		estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
				 
		estado.setEnergiaActual(estado.getEnergiaActual()-(nodoElegido.getEnergia())/4);

		estado.setBossDerrotado(true);
		// TODO Auto-generated method stub
		return estado;
		}
		
		}
		return estado;
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
	
	public List<Node> obtenerEnemigos(List<Node> node){
		
		List<Node> posiblesNodos= new ArrayList<>();
	    for (Node adyacen : node) {
	    	if (adyacen.getEntidad().equals(entidades.ENEMIGO)) {
	    		posiblesNodos.add(adyacen);
	    	}
	    }
	    return posiblesNodos;
	}
 
	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return 1.5;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoPokemon estado= (EstadoPokemon) ast;
		EstadoAmbiente ambiente= (EstadoAmbiente)est;
		
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerEnemigos(adyacentes);
		
		if(posiblesNodos.size()>0) { //Si es mayor que 0 puedo no pelear
			Node nodoElegido=posiblesNodos.get(0);
			
			for (Node objeto : posiblesNodos) {
			    if (objeto.getEnergia() < nodoElegido.getEnergia()) {
			        nodoElegido = objeto;
			    }
			} 
			
			if(nodoElegido.getEnergia()>estado.getEnergiaActual()) {
				estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
				estado.setAdyacentes(obtenerAdyacentes(nodoElegido));
						 
				List<Integer> tiempo = estado.getTiempoPoderEspecial();
				estado.setTiempoPoderEspecial(tiempo);
						 
				estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
						 
				estado.setEnergiaActual(estado.getEnergiaActual()-(nodoElegido.getEnergia())/4);
				
				estado.setBossDerrotado(false);
		
		ambiente.setBossDerrotado(false);
		ambiente.setPosicion(estado.getPosicion());
		ambiente.setEnergiaPokemon(estado.getEnergiaActual());
		ambiente.setCicloPercepcion(estado.getCicloPercepcion());
		ambiente.setAdyacentes(obtenerAdyacentes(nodoElegido));
		ambiente.setTiempoPoderEspecial(estado.getTiempoPoderEspecial());
		ambiente.setEnergiaPokemon(estado.getEnergiaActual());
		
		return ambiente;
		// TODO Auto-generated method stub
		}
		}
		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "No pelear";
	}

}
