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
    
    public static void stestMemberAdd(RBTree set1, String num) {
        if (set1.add(num).member(num)) {
            System.out.println("Success for testMemberAdd");
        } else {
            System.out.println("Fail for testMemberAdd");
        }
    }

    public static void stestAddCardinality(RBTree set1, String num) {
        int test = set1.add(num).cardinality();
        if (((set1.cardinality() + 1) == test) || (set1.cardinality() == test)) {
            System.out.println("Success for testAddCardinality");
        } else {
            System.out.println("Fail for testAddCardinality");
        }
    }

    public static void stestUnionMember(RBTree set1, RBTree set2, String num) {
        if (set1.union(set2).member(num) == (set1.member(num) || (set2.member(num)))) {
            System.out.println("Success for testUnionMember");
        } else if (!(set1.member(num) || set2.member(num))) {
            System.out.println("the number was not a member of the set: testUnionMember");
        } else {
            System.out.println("Fail for testUnionMember");
        }
    }

    public static void stestAddRemoveEqual(RBTree set1, String num) {
        if (((set1.add(num)).remove(num)).equal(set1)) {
            System.out.println("Fail for testAddRemoveEqual");
        } else {
            System.out.println("Success for testAddRemoveEqual");
        }
    }
    
    public static void stestInter(RBTree set1, RBTree set2, String elt) {
        if (set1.add(elt).inter(set2.add(elt)).isEmpty()) {
            System.out.println("fail for testInter");
        } else {
            System.out.println("Success for testinter");
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

    public static void checkSCardAdd() {
        int succ = 0;
        int fail = 0;
        for (int i = 0; i < 100; i++) {
            RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
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
        for (int i = 0; i < 100; i++) {
            String rand = randString();
            RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
            RBTree removed = tree.remove(rand);
            if (removed.getCount(rand) <= tree.getCount(rand)) {
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

        for (int i = 0; i < 100; i++) {
            RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
            String rand = randString();
            RBTree added = tree.addSome(rand, randNum(1, 100));
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
        for (int i = 0; i < 100; i++) {
            RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
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
        for (int i = 0; i < 100; i++) {
            RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
            String num = randString();
            RBTree removed = tree.removeAll(num);
            if (removed.getCount(num) < 0) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("S CheckRemoveAllGetCount  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkSMemberInter() {
        int succ = 0;
        int fail = 0;
        for (int i = 0; i < 100; i++) {
            RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
            RBTree tree2 = randStringSet(new Leaf(), randNum(1, 100));
            String addn = randString();
            tree.add(addn);
            tree2.add(addn);
            RBTree inter = tree.inter(tree2);
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
        for (int i = 0; i < 100; i++) {
            RBTree tree = randStringSet(new Leaf(), randNum(1, 100));
            String addn = randString();
            RBTree removed = tree.removeSome(addn, randNum(1, 100));
            if (removed.getCount(addn) < tree.getCount(addn)) {
                succ = succ + 1;
            } else {
                fail++;
            }
        }
        System.out.println("S CheckRemoveGetCount  Success: " + succ + "  Failure: " + fail);
    }
}
