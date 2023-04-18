package estructura;
import java.util.ArrayList;
import java.util.List;

import entidades.entidad;

public class Node {
	  private String id;   //id del nodo
	  private List<entidad> entidades;  //Lista de entidades en el nodo
	    private List<Edge> edges;   //Lista de destinos del nodo
	 
	    public Node(String id) {
	        this.id = id;
	    }
	 
	    public String getCity() {
	        return id;
	    }
	 
	    public void setCity(String id) {
	        this.id = id;
	    }
	 
	    public List<Edge> getEdges() {
	        return edges;
	    }
	 
	    public void addEdge(Edge edge) {
	        if (edges == null) {
	            edges = new ArrayList<>();
	        }
	        edges.add(edge);
	    }
	 
	    @Override
	    public String toString() {
	        return "\n \tNode [Ubicacion=" + id + ", Posibles destinos=" + edges + "]";
	    }

		public List<entidad> getEntidades() {
			return entidades;
		}

		public void setEntidades(List<entidad> entidades) {
			this.entidades = entidades;
		}
	}
