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
public class Cidade {
    
    private int _x;
    
    private int _y;
     
    private String _name;
    
    
    public Cidade(String name, int x, int y){
    	_name = name;
        _x = x;
        _y = y;
    }
    
    
    public int getX(){
        return _x;
    }
    
    public int getY(){
        return _y;
    }
    public String getName(){
    	return _name;
    }
    
    
    public double distanceTo(Cidade cidade){
        int xDif = Math.abs(this._x - cidade._x);
        int yDif = Math.abs(this._y - cidade._y);
        double distance = Math.sqrt(Math.pow(xDif, 2) + Math.pow(yDif, 2));
        return distance;
    }
    
    
    @Override
    public String toString(){
        return ""+_name+"("+_x+","+_y+")";
    }
}
