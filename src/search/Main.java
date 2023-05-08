package search;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class Main {
	

public static void main(String[] args) {
	
	 
	
	Pokemon pokemon = new Pokemon();

    Ambiente ambiente = new Ambiente();

    SearchBasedAgentSimulator simulador = new SearchBasedAgentSimulator(ambiente, pokemon);
  
    simulador.start();
    
}
	

     
 
      
}