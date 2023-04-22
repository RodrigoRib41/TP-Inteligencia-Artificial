package search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoPokemon extends GoalTest {

	@Override
	public boolean isGoalState(AgentState agentState) {
		EstadoPokemon pokemon= (EstadoPokemon) agentState;
		
		
		if(pokemon.isBossDerrotado()) {
			return true;
		}
		else {
		// TODO Auto-generated method stub
		return false;
		}
	}

}
