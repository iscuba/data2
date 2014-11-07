/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import static Testing.Test.*;
import bags.Leaf;
import bags.RBTree;
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
    public static RBTree randStringSet(RBTree start, int length) {
        if (start.cardinality() == length) {
            return start;
        } else {
            String str = randString();
            return randStringSet(start.add(str), length);
        }
    }
    
        public static void checkSSubs() {
        int countSucc = 0;
        int countFail = 0;
        for (int i = 0; i < 100; i++) {
            RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
            if (tree.subset(tree)) {
                countSucc = countSucc + 1;
            } else {
                countFail = countFail + 1;
            }
        }
        System.out.println("S checkSubset  Success: " + countSucc + "  Failure: " + countFail);
    }

    public static void checkDepth() {
        int succ = 0;
        int fail = 0;
        RBTree tree = randSet(new Leaf(), randNum(1, 100));
        for (int i = 0; i < 100; i++) {
            if () {
                
            }
        }
        System.out.println("S CheckRemoveGetCount  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkSCardAdd() {
        int succ = 0;
        int fail = 0;
        RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
        for (int i = 0; i < 100; i++) {
            if (tree.add(randString()).cardinality() > tree.cardinality()) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("S checkCardAdd  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkSRemoveGetCount() {
        int succ = 0;
        int fail = 0;
        String rand = randString();
        RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
        RBTree removed = tree.remove(rand);
        for (int i = 0; i < 100; i++) {
            if (removed.getCount(rand) > tree.getCount(rand)) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("S CheckRemoveGetCount  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkSAddSomeGetCount() {
        int succ = 0;
        int fail = 0;
        RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
        String rand = randString();
        RBTree added = tree.addSome(rand, randNum(1,100));
        for (int i = 0; i < 100; i++) {
            if (added.getCount(rand) > added.getCount(rand)) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("S CheckAddSomeGetCount  Success: " + succ + "  Failure: " + fail);
    }
    
    public static void checkSSumCard() {
        int succ = 0;
        int fail = 0;
        RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
        for (int i = 0; i < 100; i++) {
            if (!(tree.sumIt() > tree.cardinality())) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("S checkSumCard  Success: " + succ + "  Failure: " + fail);
    }
    
    public static void checkSRemoveAllGetCount() {
        int succ = 0;
        int fail = 0;
        RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
        String num = randString();
        RBTree removed = tree.removeAll(num);
        for (int i = 0; i < 100; i++) {
            if (removed.getCount(num) < 0) {
                succ = succ +1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("S CheckRemoveAllGetCount  Success: " + succ + "  Failure: " + fail);
    }
    
    public static void checkSMemberInter() {
        int succ = 0;
        int fail = 0;
        RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
        RBTree tree2 = randStringSet(new Leaf(), randNum(1, 100));
        String addn = randString();
        tree.add(addn);
        tree2.add(addn);
        RBTree inter = tree.inter(tree2);
        for (int i = 0; i < 100; i++) {
            if (inter.member(addn)) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("S CheckMemberInter  Success: " + succ + "  Failure: " + fail);
    }
    
    public static void checkSremoveSomeGetCount() {
        int succ = 0;
        int fail = 0;
        RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
        String addn = randString();
        RBTree removed = tree.removeSome(addn, randNum(1,100));
        for (int i = 0; i < 100; i++) {
            if (removed.getCount(addn) < tree.getCount(addn)) {
                succ = succ + 1;
            } else {
                fail++;
            }
        }
        System.out.println("S CheckRemoveGetCount  Success: " + succ + "  Failure: " + fail);
    }
}
