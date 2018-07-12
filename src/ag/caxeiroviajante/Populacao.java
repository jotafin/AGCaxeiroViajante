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
public class Populacao {
    
 
    Rota[] _rotas;
 
    
    public Populacao(int populationSize, boolean initialise) {
        _rotas = new Rota[populationSize];
        if (initialise) {
            
            for (int i = 0; i < populationSize(); i++) {
                Rota newRota = new Rota();
                newRota.generateIndividual();
                saveRota(i, newRota);
            }
        }
    }
    
    
    public void saveRota(int index, Rota tour) {
        _rotas[index] = tour;
    }
    
   
    public Rota getRota(int index) {
        return _rotas[index];
    }
 
    
    public Rota getFittest() {
        Rota fittest = getRota(0);
        for(int i = 1; i < populationSize(); i++) {
            if(fittest.getFitness() <= getRota(i).getFitness()) {
                fittest = getRota(i);
            }
        }
        return fittest;
    }
 
    
    public int populationSize() {
    	return _rotas.length;
    }
}

