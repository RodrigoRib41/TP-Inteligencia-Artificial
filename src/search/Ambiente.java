package search;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

import java.util.ArrayList;
import java.util.List;

import estructura.*;

public class Ambiente extends Environment {
 
	
public Ambiente() {
		
		this.environmentState= new EstadoAmbiente();
}
	
public EstadoAmbiente getEstadoAmbiente() {
	
	return (EstadoAmbiente) super.getEnvironmentState();
	
}
	
	@Override
	public Perception getPercept() {
		
		EstadoAmbiente a=this.getEstadoAmbiente();
		
		PokemonPerception perception = new PokemonPerception();

		//Antes de pasar la percepcion, actualizamos el movimiento de los enemigos
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		//Le paso su ubicacion
		perception.setPosicion(a.getPosicion());
		System.out.println("Ciclo Percepcion: \n"+a.getCicloPercepcion());
		if((a.getCicloPercepcion()+1)%3==0) {             //Setear de forma random entre 1 y 3 luego de las pruebas
			a.getEstadoAmbiente().actualizarEnemigos();
			} 
		
	//	System.out.print(a.getGraph());
		//Su energia
		perception.setEnergiaActual(a.getEnergiaPokemon());
		
		//La cantidad de enemigos
		perception.setCantidadEnemigos(a.getCantidadEnemigos());
		
		perception.setBossDerrotado(a.isBossDerrotado());
		
		//Al tener los adyacentes ya sabe la energia de cualquier entidad que tenga de adyacente
		Integer posicion=a.getPosicion();
		
		List<Node> adyacentes = obtenerAdyacentes(a.getGraph().getNodes().get(posicion));
		perception.setAdyacentes(adyacentes);  
		
			
	if(a.getCicloPercepcion()%5==0) {	
		perception.setUbicaciones(obtenerUbicaciones(a.getGraph()));          
	} 
	
	 List<Boolean> listaPoder = a.getPoderEspecial();
	 List<Integer> listaTiempo = a.getTiempoPoderEspecial();
		if(((125*a.getEnergiaInicial())/100)<=a.getEnergiaPokemon()) {
			if(!listaPoder.get(0)) {
			listaTiempo.set(0, 0);
			 listaPoder.set(0, true);
			}
		}
		
		if(((175*a.getEnergiaInicial())/100)<=a.getEnergiaPokemon()) {
			if(!listaPoder.get(1)) {
			listaPoder.set(1, true);
			 listaTiempo.set(1, 0);
			}
		}
		
		if(((220*a.getEnergiaInicial())/100)<=a.getEnergiaPokemon()) {
			if(!listaPoder.get(2)) {
			listaPoder.set(2, true); 
			 listaTiempo.set(2, 0);
			}
		}
		
		
		perception.setPoderEspecial(listaPoder);
		
		
		perception.setTiempoPoderEspecial(listaTiempo);
		// TODO Auto-generated method stub
		return perception;
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
	
	
	public List<Node> obtenerUbicaciones(Graph graph){
		List<Node> nodes = new ArrayList<Node>();
		List<Node> aux = new ArrayList<Node>();
		nodes = graph.getNodes();
		aux=nodes;
	
	    return aux;
	}
	
	
	@Override
	 public boolean agentFailed(Action actionReturned) {
		
		boolean AgenteFalla=false;
		boolean pokebolas=false;
		Integer miEnergia=this.getEstadoAmbiente().getEnergiaPokemon();
		pokebolas=this.getEstadoAmbiente().getGraph().getNodes().stream().anyMatch(nodo -> nodo.getEntidad()==entidades.POKEBOLA);
		
		if(miEnergia<0 || (!pokebolas && miEnergia<this.getEstadoAmbiente().getEnergiaBoss() )) {
			AgenteFalla=true;
		}
		return AgenteFalla;
		
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
	/*	 List<Node> nodos=this.getEstadoAmbiente().getGraph().getNodes();
		 boolean existePokebola=true;
		 for (Node objeto : nodos) {
			 if(objeto.getEntidad().equals(entidades.POKEBOLA)) {
				 existePokebola=false;                     //Mientras exista pokebola en el mapa el agente puede seguir
			 }
		 }
	
		Integer cantidadEnergiaPokemon=this.getEstadoAmbiente().getEnergiaPokemon();
		Integer cantidadEnergiaBoss=this.getEstadoAmbiente().getEnergiaBoss();
		
		Integer cantidadMaxEnergia=cantidadEnergiaPokemon;
		 
		if(this.getEstadoAmbiente().getPoderEspecial().get(0)) {
			cantidadMaxEnergia+= (int) Math.ceil(cantidadMaxEnergia*0.2);
		}
		
		if(this.getEstadoAmbiente().getPoderEspecial().get(1)) {
			cantidadMaxEnergia+= (int) Math.ceil(cantidadMaxEnergia*0.3);
		}
		
		if(this.getEstadoAmbiente().getPoderEspecial().get(2)) {
			cantidadMaxEnergia+= (int) Math.ceil(cantidadMaxEnergia*0.5);
		}
		System.out.print("Agente falla?");
		//El agente falla cuando se queda sin energia o cuando no existen mas pokebolas para recolectar y no logro derrotar al boss
		//con la energia actual + los ataques especiales (Lo calculo para el mejor caso que tuviera los 3 ataques especiales)
		 return (cantidadEnergiaPokemon<=0 || ((cantidadEnergiaBoss>cantidadMaxEnergia) && existePokebola)); 
	 }*/
	
		
	
}

