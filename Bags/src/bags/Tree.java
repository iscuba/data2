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
public class Tree<T extends Comparable > implements Set<T>, Sequenced, Sequence {

    public Set left, right;
    public T data;
    public int count;

    public Tree(Set left, T n, int count, Set right) {
        this.left = left;
        this.right = right;
        data = n;
        this.count = count;
    }

    public static Set empty() {
        return new Leaf();
    }

    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }
    
    public int fullCardinality(){
        return count + left.cardinality() + right.cardinality();
    }

    public boolean isEmptyHuh() {
        return false;
    }

    public Set add(T num) {
        if (num.compareTo(data) == 0) {
            return new Tree(this.left, data, count + 1, this.right);
        } else if (num.compareTo(data) < 0) {
            return new Tree(this.left.add(num), this.data, count, this.right);
        } else {
            return new Tree(this.left, this.data, count, this.right.add(num));
        }
    }

    public Set remove(T elt) {
        if (elt == data) {
            if (this.count == 1) {
                return left.union(right);
            } else {
                return new Tree(this.left, this.data, count - 1, this.right);
            }

        } else if (elt.compareTo(data) < 0) {
            return new Tree(left.remove(elt), data, count, right);
        } else {
            return new Tree(left, this.data, count, right.remove(elt));
        }
    }
    
    public Set removeSome(T elt, int num) {
        if (elt.compareTo(data) == 0){
            return new Tree(left, data, count-num, right);
        } else if (elt.compareTo(data) < 0){
            return new Tree(left.removeSome(elt, num), data, count, right);
        } else {
            return new Tree(left, data, count, right.removeSome(elt, num));
        }
    }
    
    public Set removeAll(T elt){
        if (elt.compareTo(this.data) == 0){
            return this.right.union(left);
        } else if (elt.compareTo(this.data) < 0){
            return new Tree(left.removeAll(elt), data, count, right);
        } else {
            return new Tree(left, data, count, right.removeAll(elt));
        }
    }

    public boolean member(T elt) {
        if (elt == data) {
            return true;
        } else if (elt.compareTo(data) < 0) {
            return left.member(elt);

        } else {
            return right.member(elt);
        }
    }

    public Set union(Set u) {
        return left.union(right.union(u)).add(data);

    }

    public Set inter(Set u) {
        if (u.member(this.data)) {
            return new Tree(this.left.inter(u), data, count, this.right.inter(u));
        } else {
            return left.inter(u).union(right.inter(u));
        }
    }

    public Set diff(Set u) {
        if (!u.member(this.data)) {
            return new Tree(this.left.diff(u), this.data, count, this.right.diff(u));
        } else {
            return this.left.diff(u).union(this.right.diff(u));
        }
    }

    public boolean equal(Set u) {
        return (this.subset(u) && u.subset(this));
    }

    public boolean subset(Set u) {
        if (!u.member(data)) {
            return false;
        } else {
            return this.left.subset(u) && this.right.subset(u);
        }

    }

    public int getCount(T elt) {
        if (!this.member(elt)) {
            return -1;
        } else if (elt == data) {
            return this.count;
        } else if (elt.compareTo(data) < 0) {
            return this.left.getCount(elt);
        } else {
            return this.right.getCount(elt);
        }
    }
    
    public T here(){
        return data;
    }
    
    public boolean notEmpty(){
        return 
    }
    
    public Sequence next(){
        return 
    }
    
    public Sequence seq(){
        return 
    }
}
