/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag.caxeiroviajante;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jefferson
 */
public class Rota {
    

 private ArrayList<Cidade> _rota = new ArrayList<Cidade>();
 
    private double _fitness = 0;
    
    private double _distance = 0;
    
    
    public Rota(){
        for (int i = 0; i < GuardaRota.numberOfCidades(); i++) {
            _rota.add(null);
        }
    }
    
    public Rota(ArrayList<Cidade> rota){
        _rota = rota;
    }
 
    
    public void generateIndividual() {
        for(int cidadeIndex = 0; cidadeIndex < GuardaRota.numberOfCidades(); cidadeIndex++) {
        	setCidade(cidadeIndex, GuardaRota.getCidade(cidadeIndex));
        }
        Collections.shuffle(_rota); 
    }
    
    
    public Cidade getCidade(int index){
        return _rota.get(index);
    }
 
    
    public void setCidade(int position, Cidade cidade) {
        _rota.set(position, cidade);
       
        _fitness = 0;
        _distance = 0;
    }
    
    
    public double getFitness(){
        if (_fitness == 0) {
        	_fitness = 1/(double)getDistance();
        }
        return _fitness;
    }
    
    
    public double getDistance(){
        if (_distance == 0){
            double rotaDistance = 0;
            for (int cidadeIndex=0; cidadeIndex < rotaSize(); cidadeIndex++) {
                Cidade fromCidade = getCidade(cidadeIndex);
                Cidade destinationCidade;
                
                if(cidadeIndex+1 < rotaSize()){
                    destinationCidade = getCidade(cidadeIndex+1);
                }else{
                    destinationCidade = getCidade(0);
                }
               
                rotaDistance += fromCidade.distanceTo(destinationCidade);
            }
            _distance = rotaDistance;
        }
        return _distance;
    }
 
    
    public int rotaSize() {
        return _rota.size();
    }
    
    
    public boolean containsCidade(Cidade cidade){
        return _rota.contains(cidade);
    }
    
    
    public boolean equals(Object object){
    	Rota rota2;
    	if(object instanceof Rota){
     rota2 = (Rota) object;
    	}else{
     return false;
    	}
    	if(rotaSize() == rota2.rotaSize()){
     Cidade cidade1, cidade2;
     for(int cidadeIndex = 0; cidadeIndex < rotaSize(); cidadeIndex++){
     cidade1 = getCidade(cidadeIndex);
     cidade2 = rota2.getCidade(cidadeIndex);
     if(!cidade1.equals(cidade2)){
     return false;
     }
     }
     return true;
    	}
    	return false;
    }
    
    //Representação textual de uma rota
    @Override
    public String toString() {
        String geneString = new String();
        for (int i = 0; i < rotaSize(); i++) {
            geneString += getCidade(i)+" -> ";
        }
        return geneString;
    }
}
