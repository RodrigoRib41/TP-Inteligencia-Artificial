package estructura;
import java.util.ArrayList;
import java.util.List;


import entidades.entidad;

public class Node {
	  private String id;   //id del nodo
	  private entidad entidades;  //Vista de entidades en el nodo
	  private List<Edge> edges;   //Vista de destinos del nodo
	 
	    public Node(String id) {
	        this.id = id;
	    }
	 
	    public String getId() {
	        return id;
	    }
	 
	    public void setId(String id) {
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

		public entidad getEntidades() {
			return entidades;
		}

		public void setEntidades(entidad a) {
			this.entidades = a;
		}
	}
