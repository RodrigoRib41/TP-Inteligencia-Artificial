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
		
		System.out.print(estado.getPosicion());
		List<Node> posiblesNodos=obtenerEnemigos(adyacentes); 
		List<Boolean> listaPoder = estado.getPoderEspecial();
		List<Integer> listaTiempo = estado.getTiempoPoderEspecial();
		obtenerEspeciales(listaPoder,listaTiempo); //Obtengo en listaPoder los poderes que puedo utilizar
	if(posiblesNodos.size()>0) { //Si es mayor que 0 puedo pelear
		Node nodoElegido=posiblesNodos.get(0);
		Node boss=new Node(1);
		boss.setEntidad(entidades.BOSS);
		if(posiblesNodos.contains(boss) && puedoDerrotar(estado,nodoElegido,listaPoder)) {
		nodoElegido=posiblesNodos.stream().filter(objeto -> objeto.getEntidad().equals(entidades.BOSS)).findFirst().orElse(null);
		Integer porcentajeEnergia=(nodoElegido.getEnergia()*100)/estado.getEnergiaActual();
		 
		usarEspecial(porcentajeEnergia, listaPoder, listaTiempo);   //Devolvemos en listaPoder los poderes a utilizar
																	//Se setea en 0 la listaTiempo de los poderes utilizados
																	//Y se le suma +1 al tiempo de los poderes no utilizados
		Integer energiaActual=estado.getEnergiaActual();
		actualizarEnergia(nodoElegido,energiaActual, listaPoder);
		
		estado.setEnergiaActual(energiaActual);
		estado.setTiempoPoderEspecial(listaTiempo);
		estado.setBossDerrotado(true);								//Condicion de victoria
		estado.setPosicion(nodoElegido.getId());				
		estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
		estado.setCantidadEnemigos(estado.getCantidadEnemigos()-1);
		 
		return estado;
		
		}
		else{
			for (Node objeto : posiblesNodos) {
			    if (objeto.getEnergia() < nodoElegido.getEnergia()) {		//Si no hay boss, busco el menor enemigo de menor energia
			        nodoElegido = objeto;
			    }
			} 
		
			if(puedoDerrotar(estado,nodoElegido,listaPoder)) {			//Si puedo derrotarlo
				Integer porcentajeEnergia=(nodoElegido.getEnergia()*100)/estado.getEnergiaActual();
			 
				usarEspecial(porcentajeEnergia, listaPoder, listaTiempo);   //Devolvemos en listaPoder los poderes a utilizar
																			//Se setea en 0 la listaTiempo de los poderes utilizados
																			//Y se le suma +1 al tiempo de los poderes no utilizados
				Integer energiaActual=estado.getEnergiaActual();
				actualizarEnergia(nodoElegido,energiaActual, listaPoder);
				
				estado.setEnergiaActual(energiaActual);
				estado.setTiempoPoderEspecial(listaTiempo);
				estado.setBossDerrotado(true);								//Condicion de victoria
				estado.setPosicion(nodoElegido.getId());				
				estado.setAdyacentes(obtenerAdyacentes(nodoElegido));
				estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
				estado.setCantidadEnemigos(estado.getCantidadEnemigos()-1);
				
				return estado;
				
			}
			else {
				return estado;
			}
		}
	
	}
	return estado;
	
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
		List<Boolean> listaPoder = estado.getPoderEspecial();
		List<Integer> listaTiempo = estado.getTiempoPoderEspecial();
		obtenerEspeciales(listaPoder,listaTiempo); //Obtengo en listaPoder los poderes que puedo utilizar
		Node nodoElegido=posiblesNodos.get(0);
	if(posiblesNodos.size()>0) { //Si es mayor que 0 puedo pelear
		Node boss=new Node(1);
		boss.setEntidad(entidades.BOSS);
		if(posiblesNodos.contains(boss)) {
			if(puedoDerrotar(estado,nodoElegido,listaPoder)) {
		nodoElegido=posiblesNodos.stream().filter(objeto -> objeto.getEntidad().equals(entidades.BOSS)).findFirst().orElse(null);
		Integer porcentajeEnergia=(nodoElegido.getEnergia()*100)/estado.getEnergiaActual();
		 
		usarEspecial(porcentajeEnergia, listaPoder, listaTiempo);   //Devolvemos en listaPoder los poderes a utilizar
																	//Se setea en 0 la listaTiempo de los poderes utilizados
																	//Y se le suma +1 al tiempo de los poderes no utilizados
		Integer energiaActual=estado.getEnergiaActual();
		actualizarEnergia(nodoElegido,energiaActual, listaPoder);
		System.out.print(energiaActual);
		estado.setEnergiaActual(energiaActual);
		estado.setTiempoPoderEspecial(listaTiempo);
		estado.setBossDerrotado(true);								//Condicion de victoria
		estado.setPosicion(nodoElegido.getId());				
		
		estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
		estado.setCantidadEnemigos(estado.getCantidadEnemigos()-1);
		
		ambiente.setEnergiaPokemon(energiaActual);
		ambiente.setTiempoPoderEspecial(listaTiempo);
		ambiente.setBossDerrotado(true);								//Condicion de victoria
		ambiente.setPosicion(nodoElegido.getId());				
		ambiente.setCicloPercepcion(estado.getCicloPercepcion()+1);
		ambiente.setCantidadEnemigos(estado.getCantidadEnemigos()-1);
		System.out.print("Energia despues de derrorar al boss" +estado.getEnergiaActual());
		return ambiente;
			}
			else{
			ambiente.setEnergiaBoss(nodoElegido.getEnergia());		//Si no puedo vencer al boss pero lo tengo adyacente,
			ambiente.setUbicacionBoss(nodoElegido.getId());			//Guardo su ubicacion y energia  VER DESPUES
		}}
		
		
			int valorMinimo = posiblesNodos.get(0).getEnergia();
			for (Node objeto : posiblesNodos) {
			    if (objeto.getEnergia() < valorMinimo) {					//Si no tengo boss, sigue al ejecucion
			        valorMinimo = objeto.getEnergia();						//busco el enemigo con menos energia
			        nodoElegido = objeto;
			    }
			}
			
			if(puedoDerrotar(estado,nodoElegido,listaPoder)) {			//Si puedo derrotarlo
				Integer porcentajeEnergia=(nodoElegido.getEnergia()*100)/estado.getEnergiaActual();
			 
				usarEspecial(porcentajeEnergia, listaPoder, listaTiempo);   //Devolvemos en listaPoder los poderes a utilizar
																			//Se setea en 0 la listaTiempo de los poderes utilizados
																			//Y se le suma +1 al tiempo de los poderes no utilizados
				Integer energiaActual=estado.getEnergiaActual();
				System.out.print("ESCUDO UTILIZADO : " +energiaActual);
				actualizarEnergia(nodoElegido,energiaActual, listaPoder);
				 System.out.print("ESCUDO UTILIZADO : " +energiaActual);
				estado.setEnergiaActual(energiaActual);
				estado.setTiempoPoderEspecial(listaTiempo);
				estado.setBossDerrotado(false);								//Condicion de victoria
				estado.setPosicion(nodoElegido.getId());				
				estado.setAdyacentes(obtenerAdyacentes(nodoElegido));
				estado.setCicloPercepcion(estado.getCicloPercepcion()+1);
				estado.setCantidadEnemigos(estado.getCantidadEnemigos()-1);
				
				ambiente.getGraph().getNodes().get(estado.getPosicion()).setEntidad(entidades.VACIO);
				ambiente.setEnergiaPokemon(energiaActual);
				ambiente.setTiempoPoderEspecial(listaTiempo);
				ambiente.setBossDerrotado(false);								//Condicion de victoria
				ambiente.setPosicion(nodoElegido.getId());				
				ambiente.setAdyacentes(obtenerAdyacentes(nodoElegido));
				ambiente.setCicloPercepcion(estado.getCicloPercepcion()+1);
				ambiente.setCantidadEnemigos(estado.getCantidadEnemigos()-1);
				 System.out.print(nodoElegido.getId());
				 
				return ambiente;
				
			}
		}
	return ambiente;
	
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "Pelear ";
	}
	private void actualizarEnergia(Node nodoElegido, Integer energiaActual, List<Boolean> listaPoder) {
		 int energiaPoder=0;
		 if(listaPoder.get(0)) {
			 energiaPoder=(int) (energiaActual*0.2);  //Redondeo hacia arriba, por eso el +1
		 }
		 
		 if(listaPoder.get(1)) {
			 energiaPoder=(int) (energiaActual*0.3);
		 }

		 if(listaPoder.get(2)) {
			 energiaPoder=(int) (energiaActual*0.5);
		 }
		
		 if(energiaPoder>nodoElegido.getEnergia()) {		//Si lo derroto solo con el escudo del poder especial
			 Integer aux=Integer.valueOf((int) (nodoElegido.getEnergia()*0.2+1));
			 energiaActual=energiaActual+aux;		//Sumo a mi energia el 20% de la energia del enemigo
			
		 }
		 
		 else {		             //Si no lo derroto solo con el escudo, la energia faltante la resto de la energia actual
			 Integer aux=Integer.valueOf((int) (nodoElegido.getEnergia()*0.2+1));
			 energiaActual=energiaActual+energiaPoder-aux;
			 
		 }
		
	}

	private boolean puedoDerrotar(EstadoPokemon estado, Node nodoElegido, List<Boolean> listaPoder) {
		int energiaActual=estado.getEnergiaActual();
		 int energiaPoder=0;
		 
		 if(listaPoder.get(0)) {
			 energiaPoder+=(int) ((energiaActual*0.2)+1);
		 }
		 
		 if(listaPoder.get(1)) {
			 energiaPoder+=(int) ((energiaActual*0.3)+1);
		 }

		 if(listaPoder.get(2)) {
			 energiaPoder+=(int) ((energiaActual*0.5)+1);
		 }
		
		 if(energiaPoder+energiaActual>nodoElegido.getEnergia()) {
			 return true;
		 }
		 else {
			 return false;
		 }

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
}
