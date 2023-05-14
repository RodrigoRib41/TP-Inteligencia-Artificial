package search;

import java.util.List;
import java.util.ArrayList;
import java.util.*;
import estructura.*;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.state.EnvironmentState;

public class EstadoAmbiente extends EnvironmentState {

	private Integer energiaPokemon;
	private Integer energiaInicial;
	private List<Boolean> poderEspecial=new ArrayList<>();
	private List<Integer> tiempoPoderEspecial=new ArrayList<Integer>(3);
	private List<Node> adyacentes=new ArrayList<Node>();
	private Integer ubicacionBoss;
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
		Node F= new Node(5);
		Node G= new Node(6);
		Node H= new Node(7);
		Node I= new Node(8); 
		Node J= new Node(9);               //Nodos iniciales de prueba
		Node K= new Node(10);
		Node L= new Node(11);
		Node LL= new Node(12);
		Node M= new Node(13);
		Node N= new Node(14);
		Node O= new Node(15);
		Node P= new Node(16); 
		Node Q= new Node(17);               //Nodos iniciales de prueba
		Node R= new Node(18);
		Node S= new Node(19);
		Node T= new Node(20);
		Node U= new Node(21);
		Node V= new Node(22); 
		Node W= new Node(23);               //Nodos iniciales de prueba
		Node X= new Node(24);
		Node Y= new Node(25);
		Node Z= new Node(26);
		Node CH= new Node(27);
		Node TheBoss= new Node(28);
		
		A.addEdge(new Edge (A,B));
		A.addEdge(new Edge (A,H));
		A.addEdge(new Edge (A,G));
		B.addEdge(new Edge (B,C));
		B.addEdge(new Edge (B,A));
		C.addEdge(new Edge (C,D));
		C.addEdge(new Edge (C,I));
		C.addEdge(new Edge (C,Q));
		C.addEdge(new Edge (C,B));
		C.addEdge(new Edge (C,O));
		D.addEdge(new Edge (D,E)); 
		D.addEdge(new Edge (D,J));
		D.addEdge(new Edge (D,C));
		E.addEdge(new Edge(E,D));
		J.addEdge(new Edge (J,R));
		J.addEdge(new Edge (J,D));
		R.addEdge(new Edge (R,J));
		R.addEdge(new Edge (R,Q));
		R.addEdge(new Edge (R,Y));
		Q.addEdge(new Edge (Q,P));
		Q.addEdge(new Edge (Q,X));
		Q.addEdge(new Edge (Q,R));
		Y.addEdge(new Edge (Y,CH));
		Y.addEdge(new Edge (Y,R));
		CH.addEdge(new Edge (CH,Y));
		CH.addEdge(new Edge (CH,Z));
		Z.addEdge(new Edge (Z,CH));
		Z.addEdge(new Edge (Z,X));
		Z.addEdge(new Edge (Z,TheBoss));
		X.addEdge(new Edge (X,Z));
		X.addEdge(new Edge (X,Q));
		P.addEdge(new Edge (P,TheBoss));
		P.addEdge(new Edge (P,Q));
		W.addEdge(new Edge (W,TheBoss));
		W.addEdge(new Edge (W,O));
		TheBoss.addEdge(new Edge (TheBoss,W));
		TheBoss.addEdge(new Edge (TheBoss,Z));
		TheBoss.addEdge(new Edge (TheBoss,P));
		O.addEdge(new Edge (O,W));
		O.addEdge(new Edge (O,I));
		O.addEdge(new Edge (O,LL));
		I.addEdge(new Edge (I,H));
		I.addEdge(new Edge (I,C));
		I.addEdge(new Edge (I,O));
		H.addEdge(new Edge (H,I));
		H.addEdge(new Edge (H,A));
		H.addEdge(new Edge (H,G));
		G.addEdge(new Edge (G,H));
		G.addEdge(new Edge (G,N));
		G.addEdge(new Edge (G,K));
		G.addEdge(new Edge (G,A));
		K.addEdge(new Edge (K,G));
		K.addEdge(new Edge (K,L));
		K.addEdge(new Edge (K,F));
		F.addEdge(new Edge (F,K));
		L.addEdge(new Edge (L,K));
		L.addEdge(new Edge (L,M));
		L.addEdge(new Edge (L,S));
		S.addEdge(new Edge (S,L));
		S.addEdge(new Edge (S,T));
		S.addEdge(new Edge (S,N));
		T.addEdge(new Edge (T,U));
		T.addEdge(new Edge (T,S));
		U.addEdge(new Edge (U,T));
		U.addEdge(new Edge (U,V));
		V.addEdge(new Edge (V,U));
		M.addEdge(new Edge (M,L));
		M.addEdge(new Edge (M,N));
		N.addEdge(new Edge (N,M));
		N.addEdge(new Edge (N,LL));
		N.addEdge(new Edge (N,G));
		N.addEdge(new Edge (N,S));
		LL.addEdge(new Edge (LL,N));
		LL.addEdge(new Edge (LL,O));
		
		
		
		A.setEntidad(entidades.POKEBOLA);
		D.setEntidad(entidades.POKEBOLA);
		M.setEntidad(entidades.POKEBOLA);
		P.setEntidad(entidades.POKEBOLA);
		CH.setEntidad(entidades.POKEBOLA);
		
		TheBoss.setEntidad(entidades.BOSS);
		
		F.setEntidad(entidades.ENEMIGO);
		K.setEntidad(entidades.ENEMIGO);
		G.setEntidad(entidades.ENEMIGO);
		L.setEntidad(entidades.ENEMIGO);
		S.setEntidad(entidades.VACIO);
		T.setEntidad(entidades.ENEMIGO);
		U.setEntidad(entidades.ENEMIGO);
		V.setEntidad(entidades.ENEMIGO);
		N.setEntidad(entidades.ENEMIGO);
		LL.setEntidad(entidades.ENEMIGO);
		O.setEntidad(entidades.ENEMIGO);
		W.setEntidad(entidades.ENEMIGO);
		H.setEntidad(entidades.ENEMIGO);
		I.setEntidad(entidades.ENEMIGO);
		B.setEntidad(entidades.ENEMIGO);
		C.setEntidad(entidades.ENEMIGO);
		Q.setEntidad(entidades.ENEMIGO);
		J.setEntidad(entidades.ENEMIGO);
		E.setEntidad(entidades.ENEMIGO);
		R.setEntidad(entidades.ENEMIGO);
		X.setEntidad(entidades.ENEMIGO);
		Y.setEntidad(entidades.ENEMIGO);
		Z.setEntidad(entidades.ENEMIGO);
		
		Random rand = new Random();
		Node[] entidades = {F, K, G, L, S, T, U, V, N, LL, O, W, H, I, B, C, Q, J, E, R, X, Y, Z};

		// Establecer una energía aleatoria entre 1 y 3 para cada entidad
		for (int i=0; i<entidades.length; i++) {
		    entidades[i].setEnergia(7);     //rand.nextInt(3) + 1);
		}
		
		A.setEnergia(10);
		D.setEnergia(5);
		M.setEnergia(10);
		P.setEnergia(5);
		CH.setEnergia(10);
		
		TheBoss.setEnergia(40);
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
		
	//	C.setEnergia(30);
/*		G.setEntidad(entidades.ENEMIGO);
		G.setEnergia(20);
	//	C.setEnergia(10);
	//	C.setEntidad(entidades.ENEMIGO);     
	//	A.setEnergia(10);
		A.setEntidad(entidades.VACIO);
		B.setEntidad(entidades.ENEMIGO); 
		B.setEnergia(20);
		C.setEntidad(entidades.ENEMIGO); 
		C.setEnergia(10);
		D.setEntidad(entidades.ENEMIGO); 
		D.setEnergia(30);
		E.setEntidad(entidades.ENEMIGO); 
		E.setEnergia(200);
		F.setEntidad(entidades.VACIO);
		
		H.setEntidad(entidades.BOSS);
		H.setEnergia(300);
		
		*/
		energiaBoss=40;
		energiaPokemon=15;
		energiaInicial=energiaPokemon;
		posicion=19;									//Seteo la posicion del pokemon
		cicloPercepcion=0;
		bossDerrotado = false;
		cantidadEnemigos=21;
		
		poderEspecial.add(false);
		poderEspecial.add(false);
		poderEspecial.add(false);
		
		graph.addNode(A);
		graph.addNode(B);
		graph.addNode(C);
		graph.addNode(D);
		graph.addNode(E);
		graph.addNode(F);
		graph.addNode(G);
		graph.addNode(H);
		graph.addNode(I);
		graph.addNode(J);
		graph.addNode(K);
		graph.addNode(L);
		graph.addNode(LL);
		graph.addNode(M);
		graph.addNode(N);
		graph.addNode(O);
		graph.addNode(P);
		graph.addNode(Q);
		graph.addNode(R);
		graph.addNode(S);
		graph.addNode(T);
		graph.addNode(U);
		graph.addNode(V);
		graph.addNode(W);
		graph.addNode(X);
		graph.addNode(Y);
		graph.addNode(Z);
		graph.addNode(CH);
		graph.addNode(TheBoss);
        
        
        tiempoPoderEspecial.add(0);
		tiempoPoderEspecial.add(0);
		tiempoPoderEspecial.add(0);
        
    
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
		String str = "";
		str = str + "Energia Pokemon: "+ this.getEnergiaPokemon() + " Cant. Enemigos: " + this.getCantidadEnemigos() + " Ubicacion BOSS: " + this.getUbicacionBoss() + "\n";
        str = str + "[ \n";
        str = str + this.getGraph();
        str = str + " ]\n";
		return str;
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
		
		List<Node> nodos=graph.getNodes();
		List<Node> noPuedoir=new ArrayList<>();
		
		noPuedoir.add(this.getGraph().getNodes().get(posicion));
		
		for(Node nodo: nodos) {
			
			if(nodo.getEntidad()==entidades.ENEMIGO && !noPuedoir.contains(nodo)) {
				List<Node> adyacentes=obtenerAdyacentes(nodo);
				for(Node ady: adyacentes) {
					if(ady.getEntidad()==entidades.VACIO) {
						ady.setEntidad(entidades.ENEMIGO);
						ady.setEnergia(nodo.getEnergia());
						noPuedoir.add(ady);
						nodo.setEntidad(entidades.VACIO);
						nodo.setEnergia(0);
						break;
					}
				}
				
				
			}
			
		}
		// TODO Auto-generated method stub
		
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

	public List<Node> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(List<Node> adyacentes) {
		this.adyacentes = adyacentes;
	}

	public Integer getUbicacionBoss() {
		return ubicacionBoss;
	}

	public void setUbicacionBoss(Integer ubicacionBoss) {
		this.ubicacionBoss = ubicacionBoss;
	}

}
