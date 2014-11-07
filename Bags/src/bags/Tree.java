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
public class Tree<T extends Comparable> implements RBTree<T> {

    public RBTree left, right;
    public T data;
    public int count;
    public boolean color;

    public Tree(RBTree left, T n, int count, RBTree right, boolean color) {
        this.left = left;
        this.right = right;
        data = n;
        this.count = count;
        this.color = color;
    }
    
    public Tree(RBTree left, T n, RBTree right){
        this.left = left;
        this.data = n;
        this.count = 1;
        this.color = true;
    }
    
    public Tree(T n, int count, boolean color){
        this.left = new Leaf();
        this.data = n;
        this.count = count;
        this.right = new Leaf();
        this.color = color;
    }

    public RBTree empty() {
        return new Leaf();
    }

    public int cardinality() {
        return count + left.cardinality() + right.cardinality();
    }


    public boolean isEmpty() {
        return false;
    }

    public RBTree add(T num) {
        return this.addSome(num, 1);
    }

    public RBTree addSome(T elt, int n) {
        if (elt.compareTo(data) == 0) {
            return new Tree(this.left, data, count + n, this.right, color);
        } else if (elt.compareTo(data) < 0) {
            return new Tree(left.addSome(elt, n), data, count, right, color);
        } else {
            return new Tree(left, data, count, right.addSome(elt, n), color);
        }
    }
    
    public RBTree blacken(){
        return new Tree(left, data, count, right, false);
    }
    
    public boolean isRed(){
        return color;
    }
    
    public RBTree balance(){
        //my trees don't balance :(
    }

    public RBTree remove(T elt) {
        return this.removeSome(elt, 1);
    }

    public RBTree removeSome(T elt, int n) {
        if (elt.compareTo(data) == 0) {
            return new Tree(left, data, count - n, right, color);
        } else if (elt.compareTo(data) < 0) {
            return new Tree(left.removeSome(elt, n), data, count, right, color);
        } else {
            return new Tree(left, data, count, right.removeSome(elt, n), color);
        }
    }

    public RBTree removeAll(T elt) {
        if (elt.compareTo(this.data) == 0) {
            return this.right.union(left);
        } else if (elt.compareTo(this.data) < 0) {
            return new Tree(left.removeAll(elt), data, count, right, color);
        } else {
            return new Tree(left, data, count, right.removeAll(elt),color);
        }
    }

    public boolean member(T elt) {
        if (elt.compareTo(data)==0) {
            return true;
        } else if (elt.compareTo(data) < 0) {
            return left.member(elt);

        } else {
            return right.member(elt);
        }
    }

    public RBTree union(RBTree u) {
        return left.union(right.union(u)).add(data);

    }

    public RBTree inter(RBTree u) {
        if (u.member(this.data)) {
            int min = Math.min(u.getCount(data), this.getCount(data));
            return new Tree(this.left.inter(u), this.data, min, this.right.inter(u),color);
        } else {
            return this.left.inter(u).union(this.right.inter(u));
        }
//        if (u.member(this.data)) {
//            return new Tree(this.left.inter(u), data, count, this.right.inter(u),color);
//        } else {
//            return left.inter(u).union(right.inter(u));
//        }
    }

    public RBTree diff(RBTree u) {
        if ((u.member(data))) {
            if (this.getCount(data) > u.getCount(data)) {
                return this.removeSome(data, u.getCount(data)).diff(u.removeAll(data));
            } else {
                return left.union(right).diff(u.remove(data));
            }
        } else {
            return new Tree(left.diff(u), data, count, right.diff(u),color);
        }
        
    }

    public boolean equal(RBTree u) {
        return (this.subset(u) && u.subset(this));
    }

    public boolean subset(RBTree u) {
        return (u.getCount(data) >= this.getCount(data))
                && this.left.union(this.right).subset(u);
    }

    public int getCount(T elt) {
        if (!this.member(elt)) {
            return -1;
        } else if (elt.compareTo(data)== 0) {
            return this.count;
        } else if (elt.compareTo(data) < 0) {
            return this.left.getCount(elt);
        } else {
            return this.right.getCount(elt);
        }
    }

    public Sequence seq() {
        return new FullSeq(data, count, new SeqTree(left.seq(), right.seq()));
    }
    
    public int sumItUp(Sequence seq){
        int sum = 0;
        while(seq.notEmpty()){
            sum = sum + 1;
            seq = seq.next();
        }
        return sum;
    }
    
    public int sumIt(){
        return sumItUp(this.seq());
    }
}
