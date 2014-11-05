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
public interface Set<T extends Comparable> {

    public int cardinality();
    
    public int fullCardinality();

    public boolean isEmptyHuh();

    public boolean member(T elt);

    public Set add(T elt);
    
    public Set addSome(T elt, int n);

    public Set remove(T elt);

    public Set removeSome(T elt, int n);
    
    public Set removeAll(T elt);
    
    public Set union(Set u);

    public Set inter(Set u);

    public Set diff(Set u);

    public boolean equal(Set u);

    public boolean subset(Set u);
    
    public int getCount(T elt);
    
}
