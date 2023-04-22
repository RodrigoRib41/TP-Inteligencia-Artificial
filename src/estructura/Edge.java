package estructura;

public class Edge {
	    private Node origin;
	    private Node destination;
	    
	 
	    public Edge(Node origin, Node destination) {
	        this.origin = origin;
	        this.destination = destination;
	    }
	 
	    public Node getOrigin() {
	        return origin;
	    }
	 
	    public void setOrigin(Node origin) {
	        this.origin = origin;
	    }
	 
	    public Node getDestination() {
	        return destination;
	    }
	 
	    public void setDestination(Node destination) {
	        this.destination = destination;
	    }
	 
	 
	    @Override
	    public String toString() {
	        return "\n Edge [origin=" + origin.getId() + ", destination=" + destination.getId()+ "]";
	    }
	}
	