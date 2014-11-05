/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bags;

/**
 *
 * @author Isabella
 */
public class Wood<T> implements Sequence<T>{
    
    Sequence left, right;
    
    public Wood(Sequence left, Sequence right){
        this.left = left;
        this.right = right;
    }
    
    //I dont think this is what I'm supposed to do
    public T here(){
        if (left.notEmpty()){
            return left.here();
        } else {
            return right.here();
        }
    }
    
    //does this actually work or? 
    public boolean notEmpty(){
        return left.notEmpty() || right.notEmpty();
    }
    
    //but what if there is nothing next?
    public Sequence next(){
        if (left.notEmpty()){
            return new Wood(left.next(), right);
        } else {
            return new Wood(left, right.next());
        }
    }
}
