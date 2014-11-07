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
public interface RBTree<T extends Comparable> extends Sequenced<T> {

    public int getCount(T o);

    public boolean isEmpty();

    public int cardinality();

    public boolean member(T o);

    public RBTree add(T o);

    public RBTree addSome(T o, int num);

    public RBTree blacken();

    public boolean isRed();

    public RBTree balance();

    public RBTree union(RBTree t);

    public RBTree remove(T o);

    public RBTree removeSome(T o, int num);

    public RBTree removeAll(T o);

    public RBTree inter(RBTree t);

    public RBTree diff(RBTree t);

    public boolean equal(RBTree t);

    public boolean subset(RBTree t);
    
    public int sumItUp(Sequence seq);
    
    public int sumIt();
}
