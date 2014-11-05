/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import static Testing.Test.*;
import bags.Leaf;
import bags.Set;
import java.util.*;

/**
 *
 * @author Isabella
 */
public class TestGenerics {

    // make random strings:
    public static String randString() {
        Random rando = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int Length = randNum(1, 10);
        char tempChar;
        for (int i = 0; i < Length; i++) {
            tempChar = (char) (rando.nextInt(96) + 32);
            stringBuilder.append(tempChar);
        }
        return stringBuilder.toString();

    }

    //make random set containing random strings:
    public static Set randStringSet(Set start, int length) {
        if (start.cardinality() == length) {
            return start;
        } else {
            String str = randString();
            return randStringSet(start.add(str), length);
        }
    }
}
