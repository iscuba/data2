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
public interface Sequence<T> {

    public T here();

    public boolean notEmpty();

    public Sequence next();
    // If notEmpty returns false, then next() can return anything and
    // here() can return anything
}
