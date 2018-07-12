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
public class App {
    public static void main(String args[]){
 
        Cidade cidade = new Cidade("Lisboa", 60, 200);
        GuardaRota.addCidade(cidade);
        Cidade cidade2 = new Cidade("Santarém", 180, 200);
        GuardaRota.addCidade(cidade2);
        Cidade cidade3 = new Cidade("Braga", 80, 180);
        GuardaRota.addCidade(cidade3);
        Cidade cidade4 = new Cidade("Bragança", 140, 180);
        GuardaRota.addCidade(cidade4);
        Cidade cidade5 = new Cidade("Porto", 20, 160);
        GuardaRota.addCidade(cidade5);
        Cidade cidade6 = new Cidade("Portalegre", 100, 160);
        GuardaRota.addCidade(cidade6);
        Cidade cidade7 = new Cidade("Viseu", 200, 160);
        GuardaRota.addCidade(cidade7);
        Cidade cidade8 = new Cidade("Setúbal", 140, 140);
        GuardaRota.addCidade(cidade8);
        Cidade cidade9 = new Cidade("Samora", 40, 120);
        GuardaRota.addCidade(cidade9);
        Cidade cidade10 = new Cidade("Beja", 100, 120);
        GuardaRota.addCidade(cidade10);
        Cidade cidade11 = new Cidade("Aveiro", 180, 100);
        GuardaRota.addCidade(cidade11);
        Cidade cidade12 = new Cidade("Barcelos", 60, 80);
        GuardaRota.addCidade(cidade12);
        Cidade cidade13 = new Cidade("Faro", 120, 80);
        GuardaRota.addCidade(cidade13);
        Cidade cidade14 = new Cidade("Guimarães", 180, 60);
        GuardaRota.addCidade(cidade14);
        Cidade cidade15 = new Cidade("Leiria", 20, 40);
        GuardaRota.addCidade(cidade15);
        Cidade cidade16 = new Cidade("Odivelas", 100, 40);
        GuardaRota.addCidade(cidade16);
        Cidade cidade17 = new Cidade("Sines", 200, 40);
        GuardaRota.addCidade(cidade17);
        Cidade cidade18 = new Cidade("Tonela", 200, 20);
        GuardaRota.addCidade(cidade18);
        Cidade cidade19 = new Cidade("Coimbra", 60, 20);
        GuardaRota.addCidade(cidade19);
        Cidade cidade20 = new Cidade("Almada", 160, 20);
        GuardaRota.addCidade(cidade20);
        Cidade cidade21 = new Cidade("Cascais", 150, 55);
        GuardaRota.addCidade(cidade21);
        Cidade cidade22 = new Cidade("Almeirim", 10, 20);
        GuardaRota.addCidade(cidade22);
        Cidade cidade23 = new Cidade("Chaves", 25, 85);
        GuardaRota.addCidade(cidade23);
        Cidade cidade24 = new Cidade("Faro", 185, 35);
        GuardaRota.addCidade(cidade24);
        Cidade cidade25 = new Cidade("Maia", 100, 95);
        GuardaRota.addCidade(cidade25);
        
        
        
        Populacao pop = new Populacao(50, true);
        
        
        System.out.println(" #DISTÂNCIA INICIAL: " + (int)pop.getFittest().getDistance());
 
        
        for (int i = 0; i < 200; i++) {
            pop = AG.evolvePopulation(pop);
        }
 
        
        System.out.println(" #DISTÂNCIA FINAL: " + (int)pop.getFittest().getDistance());
        
        System.out.println(" $SOLUÇÃO:");
        System.out.println(pop.getFittest()); 
 
 }
 

}
