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
public class SeqLeaf<T extends Comparable<T>> implements Sequence<T>, Sequenced<T> {

    SeqLeaf() {
    }

    // what could I return other than null?
    public T here() {
        return null;
    }

    public Sequence<T> next() {
        return this;
    }

    public boolean notEmpty() {
        return false;
    }

    public Sequence<T> seq() {
        return this;
    }

}
