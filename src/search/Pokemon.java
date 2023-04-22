package search;


import java.util.Vector;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;

public class Pokemon extends SearchBasedAgent{

	
	public Pokemon() {
	//Objetivo del pokemon
			ObjetivoPokemon objetivo= new ObjetivoPokemon();
			
			EstadoPokemon estado= new EstadoPokemon();
			
			this.setAgentState(estado);
	
			Vector<SearchAction> acciones = new Vector<SearchAction>();
			
			
			// Agregar acciones
			
	}
	
	@Override
	public void see(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
