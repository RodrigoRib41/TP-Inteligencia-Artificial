package search;

import java.util.List;
import java.util.ArrayList;

import estructura.*;
import entidades.*;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

	private Integer energiaPokemon;
	private String posicion;
	private Integer energiaBoss;
	private Integer cantidadEnemigos;
	private boolean bossDerrotado;
	Graph graph = new Graph();
	
	public EstadoAmbiente() {
		initState();
	}
	
	@Override
	public void initState() {
		// GENERAR MAPA INICIALMENTE CON LA ESTRUCTURA DE GRAFO
		Node A= new Node("A");
		Node B= new Node("B");
		Node C= new Node("C");               //Nodos iniciales de prueba
		Node D= new Node("D");
		Node E= new Node("E");
		Node F= new Node("F");
		Node G= new Node("G");
		
		A.addEdge(new Edge (A,B));
		A.addEdge(new Edge (A,C));
		A.addEdge(new Edge (A,D));
		B.addEdge(new Edge (B,C));
		B.addEdge(new Edge (B,F));
		C.addEdge(new Edge (C,B));
		C.addEdge(new Edge (C,F));                 
		C.addEdge(new Edge (C,G));
		C.addEdge(new Edge (C,E));
		D.addEdge(new Edge (D,E));
		E.addEdge(new Edge (E,G));
		E.addEdge(new Edge (E,C));
		F.addEdge(new Edge (F,C));
		F.addEdge(new Edge (F,G));
		
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addNode(E);
        graph.addNode(F);
        graph.addNode(G);
 
        energiaPokemon=numeroAleatorio(10,20);
		posicion="A";
		
        entidad a= new Boss(1,30);   
		G.setEntidades(a);                     
		
		entidad p= new Pokebolas(2,numeroAleatorio(5,10));                                     
		E.setEntidades(p);     
        
		entidad w= new Enemigos(3,numeroAleatorio(1,3));         //asigno enemigo id 3 con numero aleatorio entre 5 y 10                             
		
		C.setEntidades(w);     
		D.setEntidades(w);
		B.setEntidades(w);
		
		//Pokemon j= new Pokemon(4,numeroAleatorio(10,20));
		//j1 = new ArrayList<>();
		//j1.add(j);												//Asigno a nuestro pokemon al nodo A
		//A.setEntidades(j1);
		
		bossDerrotado = false;
	}	
	
	public Graph getGraph() {
		return graph;
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

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public EstadoAmbiente getEstadoAmbiente() {
	return this;                                        //VER SI ANDA
	}

	
	public void actualizarEnemigos() {
		// TODO Auto-generated method stub
		
	}

}
