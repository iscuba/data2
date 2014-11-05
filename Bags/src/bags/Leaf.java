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
public class Leaf<T extends Comparable > implements Set<T>{
    
      public Leaf() {
    }

    public Set empty() {
        return new Leaf();
    }

    public int cardinality() {
        return 0;
    }
    
    public int fullCardinality(){
        return 0;
    }

    public boolean isEmptyHuh() {
        return true;
    }

    public boolean member(T elt) {
        return false;
    }

    public Set add(T elt) {
        return new Tree(new Leaf(), elt, 1, new Leaf());
    }
    
    public Set addSome(T elt, int n){
        return new Tree(new Leaf(), elt, n, new Leaf());
    }
            
    public Set remove(T elt) {
        return new Leaf();
    }
    
    public Set removeSome(T elt, int n){
        return new Leaf();
    }
    
    public Set removeAll(T elt){
        return new Leaf();
    }

    public Set union(Set u) {
        return u;
    }

    public Set inter(Set u) {
        return new Leaf();
    }

    public Set diff(Set u) {
        return u;
    }

    public boolean equal(Set u) {
        return u.isEmptyHuh();
    }

    public boolean subset(Set u) {
        return u.isEmptyHuh();
    }
    
    public int getCount(T elt){
        return 0;
    }
    
}
