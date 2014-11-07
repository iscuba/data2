/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bags;

/**
 *
 * @author Isabella
 * @param <T>
 */
public class SeqTree<T extends Comparable<T>> implements Sequence<T>, Sequenced<T>{
    
    Sequence<T> left, right;
    
    public SeqTree(Sequence<T> left, Sequence<T> right){
        this.left = left;
        this.right = right;
    }
    
    public T here(){
        if (left.notEmpty()){
            return left.here();
        } else {
            return right.here();
        } 
    }
    
    public boolean notEmpty(){
        return left.notEmpty() || right.notEmpty();
    }
    
    public Sequence<T> next() {
        if (left.notEmpty()){
            return new SeqTree(left.next(), right);
        } else {
            return this.right.next();
        }
    }
    
    public Sequence<T> seq(){
        return this;
    }
}
