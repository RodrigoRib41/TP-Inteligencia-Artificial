package search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class Ambiente extends Environment {

public Ambiente() {
		
		this.environmentState= new EstadoAmbiente();
}
	
	
	
	
	@Override
	public Perception getPercept() {
		// TODO Auto-generated method stub
		return null;
	}

}
