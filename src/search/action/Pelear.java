package search.action;

import java.util.ArrayList;
import java.util.List;

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

public class Pelear extends SearchAction {

	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoPokemon estado= (EstadoPokemon) s;
		
		List<Node> adyacentes=estado.getAdyacentes();
		List<Node> posiblesNodos=obtenerEnemigos(adyacentes); 
		System.out.print(posiblesNodos.get(1).getEntidad().toString());
	//	if(posiblesNodos.size()>0) { //Si es mayor que 0 puedo no pelear
		Node boss=new Node(1);
		boss.setEntidad(entidades.BOSS);
		posiblesNodos.contains(boss);
		boss=posiblesNodos.stream().filter(objeto -> objeto.getEntidad().equals(entidades.BOSS)).findFirst().orElse(null);
		
		
		System.out.print(boss.getEnergia());
		Node nodoElegido=posiblesNodos.get(0);
	
		int valorMinimo = posiblesNodos.get(0).getEnergia();
		for (Node objeto : posiblesNodos) {
		    if (objeto.getEnergia() < valorMinimo) {
		        valorMinimo = objeto.getEnergia();
		        nodoElegido = objeto;
		    }
		}
		
		
		estado.setBossDerrotado(true);
		 estado.setPosicion(nodoElegido.getId());				//seteo la nueva posicion del agente
		 estado.setAdyacentes(obtenerAdyacentes(nodoElegido));
		 
		
		 List<Boolean> listaPoder = estado.getPoderEspecial();
		 List<Integer> listaTiempo = estado.getTiempoPoderEspecial();
		 obtenerEspeciales(listaPoder,listaTiempo);
		 
		 System.out.print(nodoElegido.getEntidad().toString());
		 Integer porcentajeEnergia=(nodoElegido.getEnergia()*100)/estado.getEnergiaActual();
		 
		 List<Integer> tiempo=estado.getTiempoPoderEspecial();
		 usarEspecial(porcentajeEnergia, listaPoder, tiempo);   //Devolvemos en listaPoder los poderes a utilizar
		 estado.setTiempoPoderEspecial(tiempo);    //Seteo el tiempo del poder especial actualizado
		 
		 
		 int energiaActual=estado.getEnergiaActual();
		 int energiaPoder=0;
		 if(listaPoder.get(0)) {
			 energiaPoder=(int) (energiaActual*0.2+1);
		 }
		 
		 if(listaPoder.get(1)) {
			 energiaPoder=(int) (energiaActual*0.3+1);
		 }
 
		 if(listaPoder.get(2)) {
			 energiaPoder=(int) (energiaActual*0.5+1);
		 }
		
		 if(energiaPoder>nodoElegido.getEnergia()) {
			 
			 energiaActual+=(int)(nodoElegido.getEnergia())*0.2;
		 }
		 
		 else {
			 energiaActual+=energiaPoder-(nodoElegido.getEnergia())*0.2;
		 }
		 
		
		 
		 estado.setEnergiaActual(energiaActual);
		 estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
		 estado.setCantidadEnemigos(estado.getCantidadEnemigos()-1);
		 
		// TODO Auto-generated method stub
	//	}
		return estado;
	}
	
	private void usarEspecial(Integer porcentajeEnergia, List<Boolean> listaPoder, List<Integer> tiempo) {
	Integer aux=porcentajeEnergia;
	
	if(listaPoder.get(0)) {
		tiempo.set(0, 0);
		aux-=20;	
	}
	else {
		tiempo.set(0, tiempo.get(0)+1);
		listaPoder.set(0, false);
	}
	
	if(listaPoder.get(1) && aux>15) {
		tiempo.set(1, 0);
		aux-=30;
	}
	else {
		tiempo.set(1, tiempo.get(1)+1);
		listaPoder.set(1, false);
	}
	
	if(listaPoder.get(2) && aux>25) {
		tiempo.set(2, 0);
		aux-=50;
	}
	else {
		tiempo.set(2, tiempo.get(2)+1);
		listaPoder.set(2, false);
	}
		
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
	
	public List<Node> obtenerEnemigos(List<Node> node){
		
		List<Node> posiblesNodos= new ArrayList<>();
	    for (Node adyacen : node) {
	    	if (adyacen.getEntidad()==entidades.ENEMIGO) {
	    		posiblesNodos.add(adyacen);
	    	}
	    	if (adyacen.getEntidad()==entidades.BOSS) {
	    		posiblesNodos.add(adyacen);
	    	}
	    }
	    return posiblesNodos;
	}
	
	public List<Boolean> obtenerEspeciales (List<Boolean> listaPoder, List<Integer> tiempo){
		if(tiempo.get(0)>=3) {
			listaPoder.set(0, true);
		 }
		if(tiempo.get(1)>=3) {
			listaPoder.set(1, true);
		 }
		if(tiempo.get(2)>=3) {
			listaPoder.set(2, true);
		 }
		return listaPoder;
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
		
		ambiente.setPosicion(estado.getPosicion());
		ambiente.setEnergiaPokemon(estado.getEnergiaActual());
		ambiente.setCicloPercepcion(estado.getCicloPercepcion());
		ambiente.setCantidadEnemigos(estado.getCantidadEnemigos());
		ambiente.setPoderEspecial(estado.getPoderEspecial());
		
		Graph aux=ambiente.getGraph();
		Integer indice=estado.getPosicion();
		
		
		aux.getNodes().get(indice).setEntidad(entidades.VACIO);
		
		ambiente.setGraph(aux);
		
		return ambiente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pelear";
	}

}
