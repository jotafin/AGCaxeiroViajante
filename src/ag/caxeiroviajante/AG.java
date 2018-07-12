/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag.caxeiroviajante;

/**
 *
 * @author Jefferson
 */
public class AG {
    

    private static final double _mutationRate = 0.0015;
    
    private static final int _tournamentSize = 5;
   
    private static final boolean _elitism = true;
    
    private static int _mutations = 0;
 
    
    public static Populacao evolvePopulation(Populacao pop) {
        Populacao newPopulation = new Populacao(pop.populationSize(), false);
        
        
        int elitismOffset = 0;
        if (_elitism) {
            newPopulation.saveRota(0, pop.getFittest());
            elitismOffset = 1;
        }
 
       
        for(int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            
            Rota parent1 = tournamentSelection(pop);
            Rota parent2 = tournamentSelection(pop);
          
            Rota child = crossover(parent1, parent2);
            
            newPopulation.saveRota(i, child);
        }
 
        
        _mutations = 0;
        for(int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getRota(i));
        }
        return newPopulation;
    }
 
    
    public static Rota crossover(Rota parent1, Rota parent2) {
        
        Rota child = new Rota();
 
        
        int startPos = (int)(Math.random() * parent1.rotaSize());
        int endPos = (int)(Math.random() * parent1.rotaSize());
 
        
        for (int i = 0; i < child.rotaSize(); i++) {
            
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCidade(i, parent1.getCidade(i));
            }
            else if(startPos > endPos) {
                if(!(i < startPos && i > endPos)) {
                    child.setCidade(i, parent1.getCidade(i));
                }
            }
        }
 
       
        for (int i = 0; i < parent2.rotaSize(); i++) {
            
            if (!child.containsCidade(parent2.getCidade(i))) {
               
                for (int ii = 0; ii < child.rotaSize(); ii++) {
                    
                    if (child.getCidade(ii) == null) {
                        child.setCidade(ii, parent2.getCidade(i));
                        break;
                    }
                }
            }
        }
        return child;
    }
 
    
    private static void mutate(Rota rota) {
        
        for(int rotaPos1=0; rotaPos1 < rota.rotaSize(); rotaPos1++){
            if(Math.random() < _mutationRate){
            	_mutations++;
                int rotaPos2 = (int)(rota.rotaSize() * Math.random());
 
               
                Cidade cidade1 = rota.getCidade(rotaPos1);
                Cidade cidade2 = rota.getCidade(rotaPos2);
 
                
                rota.setCidade(rotaPos2, cidade1);
                rota.setCidade(rotaPos1, cidade2);
            }
        }
    }
 
    
    private static Rota tournamentSelection(Populacao pop) {
        
        Populacao tournament = new Populacao(_tournamentSize, false);
      
        for(int i = 0; i < _tournamentSize; i++) {
            int randomId = (int)(Math.random() * pop.populationSize());
            tournament.saveRota(i, pop.getRota(randomId));
        }
        
        Rota fittest = tournament.getFittest();
        return fittest;
    }
    
    //Um getter que pode ser útil
    public static int getMutations(){
    	return _mutations;
    }
}
