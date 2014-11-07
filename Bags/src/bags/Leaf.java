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
public class Leaf<T extends Comparable > implements RBTree<T>{
    
      boolean color;

    // since all leaves are black:
    public Leaf() {
        this.color = false;
    }

    public int getCount(T o) {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public int cardinality() {
        return 0;
    }

    public boolean member(T o) {
        return false;
    }

    public RBTree add(T o) {
        return new Tree(new Leaf(), o, 1, new Leaf(), false);
    }

    public RBTree addSome(T o, int num) {
        return new Tree(new Leaf(), o, num, new Leaf(), false);
    }

    public RBTree blacken() {
        return new Leaf();
    }

    public boolean isRed() {
        return this.color;
    }

    public RBTree balance() {
        return new Leaf();
    }

    public RBTree union(RBTree t) {
        return t;
    }

    public RBTree remove(T o) {
        return new Leaf();
    }

    public RBTree removeSome(T o, int num) {
        return new Leaf();
    }

    public RBTree removeAll(T o) {
        return new Leaf();
    }

    public RBTree inter(RBTree t) {
        return new Leaf();
    }

    public RBTree diff(RBTree t) {
        return t;
    }

    public boolean equal(RBTree t) {
        return false;
    }

    public boolean subset(RBTree t) {
        return true;
    }
    
    public Sequence seq(){
        return new SeqLeaf();
    }
    
    public int sumItUp(Sequence seq){
        return 0;
    }
    
    public int sumIt(){
        return sumItUp(this.seq());
    }
}
