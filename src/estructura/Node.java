package estructura;
import java.util.ArrayList;
import java.util.List;


import entidades.entidad;

public class Node {
	  private Integer id;   //Id del nodo
	  private entidad entidad;  //Entidad en el nodo
	  private List<Edge> edges;   //Arista
	 
	    public Node(Integer id) {
	        this.id = id;
	    }
	 
	    public Integer getId() {
	        return id;
	    }
	 
	    public void setId(Integer id) {
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

		public entidad getEntidad() {
			return entidad;
		}

		public void setEntidad(entidad a) {
			this.entidad = a;
		}
	}
