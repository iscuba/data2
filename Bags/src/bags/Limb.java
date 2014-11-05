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
public class Limb<T extends Comparable> implements Set<T> {
    
    public Tree child;
    
    public Limb(Tree love) {
        this.child = love;
    }
    public Set empty() {
        return new Leaf();
    }

    public int cardinality() {
        return 1 + child.cardinality();
    }

    public boolean isEmptyHuh() {
        return false;
    }

    public boolean member(T elt) {
        return false;
    }

    //dont trust this: 
    public Set add(T elt) {
        return new Tree(new Leaf(), elt, 1, new Leaf());
    }

    public Set remove(T elt) {
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
    
    //DO not trust this 
    public int getCount(T elt){
        return 6;
    }
            
            
}
