package search;

import java.util.List;
import java.util.ArrayList;

import estructura.*;
import entidades.*;

import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

	private Integer energiaPokemon;
	private Integer energiaBoss;
	private Integer cantidadEnemigos;
	private boolean bossDerrotado;
	
	
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
		
		Graph graph = new Graph();
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addNode(E);
        graph.addNode(F);
        graph.addNode(G);
 
        entidad a= new Boss(1,30);                            //Id 1, energia del boss=30             
		List<entidad> b = new ArrayList<>();
		b.add(a);
		G.setEntidades(b);                                 //asigno boss a nodo G
		
		entidad p= new Pokebolas(2,numeroAleatorio(5,10));         //asigno pokebola id 2 con energia aleatoria entre 5 y 10                             
		List<entidad> b1 = new ArrayList<>();
		b1.add(p);
		E.setEntidades(b1);                //Asigno la pokebola al nodo E
        
		entidad w= new Enemigos(3,numeroAleatorio(1,3));         //asigno enemigo id 3 con numero aleatorio entre 5 y 10                             
		List<entidad> b2 = new ArrayList<>();
		b2.add(w);
		
		C.setEntidades(b2);               
		D.setEntidades(b2);
		B.setEntidades(b2);
		bossDerrotado = false;
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
	
	

}
