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
public class FullSeq<T extends Comparable<T>> implements Sequence<T>, Sequenced<T>{
    
    T here;
    int count; 
    Sequence<T> next;
    
    public FullSeq(T here, int count, Sequence<T> next){
        this.here = here;
        this.count = count;
        this.next = next;
    }
    
    public T here(){
        return this.here;
    }
    
    public boolean notEmpty(){
        return true;
    }
    
    public Sequence<T> next(){
        if (count > 1){
            return new FullSeq(here, count -1, next);
        } else {
            return next;
        }
    }
    
    public Sequence<T> seq(){
        return this;
    }
}
