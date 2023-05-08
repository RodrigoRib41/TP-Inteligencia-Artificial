package search;

import java.util.List;

import estructura.Node;
import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoPokemon extends GoalTest {

	@Override
	public boolean isGoalState(AgentState agentState) {
		EstadoPokemon pokemon= (EstadoPokemon) agentState;
		
		
		if(pokemon.isBossDerrotado()) {
			return true;
		}
		
		List<Node> adyacentes=pokemon.getAdyacentes();
		Integer energia=pokemon.getEnergiaActual();
		
		for (Node adyacen : adyacentes) {
			if (adyacen.getEntidad().getClass()==entidades.Pokebolas.class) {  //primero busco si hay pokebolas //nose si funca
	    		return true;
	    	}
		}
		for (Node adyacen : adyacentes) {
			if (adyacen.getEntidad().equals(null)) {      //luego si hay nodos vacios, esto puede ser un problema
	    		return true;
	    	}
		}
		
		for (Node adyacen : adyacentes) {
			if ((adyacen.getEntidad().equals(entidades.Enemigos.class) && adyacen.getEntidad().getEnergia()<energia)) {  //luego si puedo ganarle a un enemigo
				return true;
	    	}
		}
		
		for (Node adyacen : adyacentes) {
			if ((adyacen.getEntidad().equals(entidades.Enemigos.class) && adyacen.getEntidad().getEnergia()<energia)) {	//luego si no le gano
				return true;
	    	}
		}
		
		for (Node adyacen : adyacentes) {
			if ((adyacen.getEntidad().equals(entidades.Enemigos.class) && adyacen.getEntidad().getEnergia()>energia)) {
				return true;
	    	}
		}
		
		
		return false;
		
		
	}

}
