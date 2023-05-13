package search;


import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.*;
import frsf.cidisi.faia.solver.search.Search;
import search.action.*;

public class Pokemon extends SearchBasedAgent{

	
	public Pokemon() {
	//Objetivo del pokemon
			ObjetivoPokemon objetivo= new ObjetivoPokemon();
			
			EstadoPokemon estado= new EstadoPokemon();
			
			this.setAgentState(estado);
	
			Vector<SearchAction> acciones = new Vector<SearchAction>();
			acciones.addElement(new RecolectarPokebola());
			acciones.addElement(new Moverse());
			//acciones.addElement(new iraA());
		//	acciones.addElement(new iraB());
		//	acciones.addElement(new iraE());
		//	acciones.addElement(new iraG());
			acciones.addElement(new Pelear()); 
		// 	acciones.addElement(new NoPelear());
			
		
			
			Problem problema =new Problem(objetivo,estado,acciones);
			     
			this.setProblem(problema);
			     
		
			 
	}
	
	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
		
	}

	@Override
	public Action selectAction() {
		
		BreathFirstSearch estrategia = new BreathFirstSearch ();
    // UniformCostSearch estrategia= new UniformCostSearch(new CostFunction());
      // AStarSearch estrategia = new AStarSearch(new CostFunction(), new Heuristic());
		
		Search searchSolver = new Search(estrategia);
		 
		  //searchSolver.setVisibleTree(Search.XML_TREE);
		  
		   this.setSolver(searchSolver);
		   
		   
		   Action selectedAction = null;
		   try {
	            selectedAction =
	                    this.getSolver().solve(new Object[]{this.getProblem()});
	        } catch (Exception ex) {
	            Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        // Return the selected action
	        return selectedAction;
		 
	}

}
