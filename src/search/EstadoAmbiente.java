package search;

import java.util.List;
import java.util.ArrayList;

import estructura.*;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

	private Integer energiaPokemon;
	private Integer energiaInicial;
	private List<Boolean> poderEspecial=new ArrayList<>();
	private List<Integer> tiempoPoderEspecial=new ArrayList<Integer>(3);

	private Integer posicion;
	private Integer energiaBoss;
	private Integer cantidadEnemigos;
	private boolean bossDerrotado;
	private Integer cicloPercepcion;
	private Graph graph=new Graph();
	
	public EstadoAmbiente() {
		initState();
	}
	
	@Override
	public void initState() {
		// GENERAR MAPA INICIALMENTE CON LA ESTRUCTURA DE GRAFO
		Node A= new Node(0);
		Node B= new Node(1); 
		Node C= new Node(2);               //Nodos iniciales de prueba
		Node D= new Node(3);
		Node E= new Node(4);
	//	Node F= new Node(5);
	//	Node G= new Node(6);
		
		A.addEdge(new Edge (A,B));
		A.addEdge(new Edge (A,C));
		A.addEdge(new Edge (A,D));
		B.addEdge(new Edge (B,C));
//		B.addEdge(new Edge (B,F));
		C.addEdge(new Edge (C,B));
//		C.addEdge(new Edge (C,F));                 
//		C.addEdge(new Edge (C,G));
	//	C.addEdge(new Edge (C,E));
//		D.addEdge(new Edge (D,E));
//		E.addEdge(new Edge (E,G));
//		E.addEdge(new Edge (E,C));
//		F.addEdge(new Edge (F,C));
//		F.addEdge(new Edge (F,G));
		
//        entidad a= new Boss(6,30);   
//		G.setEntidad(a);                     
		
//		entidad p= new Pokebolas(4,numeroAleatorio(5,10));                                     
//		F.setEntidad(p);     
        
	//	B.addEdge(new Edge (B,E));
		
		C.setEnergia(30);
		C.setEntidad(entidades.BOSS);
	//	C.setEnergia(10);
	//	C.setEntidad(entidades.ENEMIGO);     
		D.setEnergia(10);
		D.setEntidad(entidades.ENEMIGO); 
		B.setEnergia(10);
		B.setEntidad(entidades.ENEMIGO);
		
		
		energiaPokemon=numeroAleatorio(10,20);
		energiaInicial=energiaPokemon;
		posicion=0;									//Seteo la posicion del pokemon
		cicloPercepcion=0;
		bossDerrotado = false;
		
		poderEspecial.add(false);
		poderEspecial.add(false);
		poderEspecial.add(false);
		
		graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        
        tiempoPoderEspecial.add(0);
		tiempoPoderEspecial.add(0);
		tiempoPoderEspecial.add(0);
        
        System.out.print(C.getEnergia());
  //      graph.addNode(E);
   //     graph.addNode(F);
   //     graph.addNode(G);
	}	
	
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph=graph;
	}
	
	public Integer getEnergiaPokemon() {
		return energiaPokemon;
	}

	public void setEnergiaPokemon(Integer energiaPokemon) {
		this.energiaPokemon = energiaPokemon;
	}

	public Integer getEnergiaBoss() {
		return energiaBoss;
	}

	public void setEnergiaBoss(Integer energiaBoss) {
		this.energiaBoss = energiaBoss;
	}

	public Integer getCantidadEnemigos() {
		return cantidadEnemigos;
	}

	public void setCantidadEnemigos(Integer cantidadEnemigos) {
		this.cantidadEnemigos = cantidadEnemigos;
	}

	public boolean isBossDerrotado() {
		return bossDerrotado;
	}

	public void setBossDerrotado(boolean bossDerrotado) {
		this.bossDerrotado = bossDerrotado;
	}

	private int numeroAleatorio(int min, int max) {
		int rango = max - min + 1;
		return (int) (Math.random() * rango) + min;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	
	public EstadoAmbiente getEstadoAmbiente() {
	return this;                                        //VER SI ANDA
	}

	
	public void actualizarEnemigos() {
		// TODO Auto-generated method stub
		
	}

	public Integer getCicloPercepcion() {
		return cicloPercepcion;
	}

	public void setCicloPercepcion(Integer cicloPercepcion) {
		this.cicloPercepcion = cicloPercepcion;
	}

	public List<Boolean> getPoderEspecial() {
		return poderEspecial;
	}

	public void setPoderEspecial(List<Boolean> poderEspecial) {
		this.poderEspecial = poderEspecial;
	}

	public Integer getEnergiaInicial() {
		return energiaInicial;
	}

	public void setEnergiaInicial(Integer energiaInicial) {
		this.energiaInicial = energiaInicial;
	}
	
	public List<Integer> getTiempoPoderEspecial() {
		return tiempoPoderEspecial;
	}

	public void setTiempoPoderEspecial(List<Integer> tiempoPoderEspecial) {
		this.tiempoPoderEspecial = tiempoPoderEspecial;
	}

}
