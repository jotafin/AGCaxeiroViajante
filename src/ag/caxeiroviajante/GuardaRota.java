/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag.caxeiroviajante;

import java.util.ArrayList;

/**
 *
 * @author Jefferson
 */
public class GuardaRota {
    

    private static ArrayList<Cidade> destinationCidades = new ArrayList<Cidade>();
 
    
    public static void addCidade(Cidade cidade) {
        destinationCidades.add(cidade);
    }
    
    
    public static Cidade getCidade(int index){
        return destinationCidades.get(index);
    }
    
    
    public static int numberOfCidades(){
        return destinationCidades.size();
    }
}

