package estructura;
import java.util.ArrayList;
import java.util.List;

public class Node {
	  private Integer id;   //Id del nodo
	  private entidades entidad;  //Entidad en el nodo
	  private Integer energia;
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
	        return "\nNode [Ubicacion=" + id + ",  Energia="+ energia +", Posibles destinos=" + edges + "]";
	    }

		

		public Integer getEnergia() {
			return energia;
		}

		public void setEnergia(Integer energia) {
			this.energia = energia;
		}

		public entidades getEntidad() {
			return entidad;
		}

		public void setEntidad(entidades entidad) {
			this.entidad = entidad;
		}

		public boolean equals(Object obj) {
			if(this.getEntidad()==((Node) obj).getEntidad()) {    //Lo utilizamos solamente para comparar entidades
				return true;
			}
			return false;
		}
	}
