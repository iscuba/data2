/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import static Testing.TestGenerics.*;
import bags.Leaf;
import bags.RBTree;
import java.util.*;
import bags.Tree;

/**
 *
 * @author Isabella
 */
public class Test {

    public static int randNum(int min, int max) {
        Random rand = new Random();
        int randNum = rand.nextInt((max - min) + 1) + min;
        return randNum;
    }

    public static RBTree randSet(RBTree start, int length) {
        if (start.cardinality() == length) {
            return start;
        } else {
            int num = randNum(0, 100);
            return randSet(start.add(num), length);
        }
    }

    public static void checkEmpty(RBTree MT) {
        if (MT.isEmpty()) {
            System.out.println("Success for checkEmpty");
        } else {
            System.out.println("Fail for checkAdd");
        }
    }

    public static void checkAdd(RBTree set) {
        int num = randNum(0, 100);
        RBTree set2 = set.add(num);
        if (set2.member(num)) {
            System.out.println("Success for checkAdd");
        } else {
            System.out.println("Fali for checkAdd");
        }
    }

    public static void checkSubset(RBTree set) {
        int num = randNum(0, 100);
        RBTree subs = set.add(num);
        if (set.subset(subs)) {
            System.out.println("Success for CheckSubset");
        } else {
            System.out.println("Fail for CheckSubset");
        }
    }

    public static void checkRemove(RBTree set) {
        int num = randNum(0, 100);
        RBTree set2 = set.add(num);
        RBTree removed = set2.remove(num);
        if (removed.getCount(num) <= set.getCount(num)) {
            System.out.println("Success for checkRemove");
        } //        if ((!removed.member(num)) || (removed.getCount(num)< set.getCount(num))) {
        //            System.out.println("Success for checkRemove");
        //        } 
        else {
            System.out.println("Fail for checkRemove ");
        }
    }

    //doesn't work 
    public static void testUnionSubset(RBTree set1, RBTree set2) {
        RBTree testSet1 = set1.union(set2);
        if ((testSet1.subset(set1)) && (testSet1.subset(set2))) {
            System.out.println("Success for testUnionSubset");
        } else {
            System.out.println("Failure for testUnionSubset");
        }
    }

    public static void testMemberAdd(RBTree set1, int num) {
        if (set1.add(num).member(num)) {
            System.out.println("Success for testMemberAdd");
        } else {
            System.out.println("Fail for testMemberAdd");
        }
    }

    public static void testAddCardinality(RBTree set1, int num) {
        int test = set1.add(num).cardinality();
        if (((set1.cardinality() + 1) == test) || (set1.cardinality() == test)) {
            System.out.println("Success for testAddCardinality");
        } else {
            System.out.println("Fail for testAddCardinality");
        }
    }

    public static void testUnionMember(RBTree set1, RBTree set2, int num) {
        if (set1.union(set2).member(num) == (set1.member(num) || (set2.member(num)))) {
            System.out.println("Success for testUnionMember");
        } else if (!(set1.member(num) || set2.member(num))) {
            System.out.println("the number was not a member of the set: testUnionMember");
        } else {
            System.out.println("Fail for testUnionMember");
        }
    }

    public static void testAddRemoveEqual(RBTree set1, int num) {
        if (((set1.add(num)).remove(num)).equal(set1)) {
            System.out.println("Fail for testAddRemoveEqual");
        } else {
            System.out.println("Success for testAddRemoveEqual");
        }
    }

    public static void testSubset(RBTree set1, RBTree set2, RBTree set3) {
        if ((set1.union(set2)).subset(set3)
                == (set1.subset(set3) && set2.subset(set3))) {
            System.out.println("Success for testSubset");
        } else {
            System.out.println("Failure for testSubset");
        }
    }

    //doesn't work 
    public static void testEqualUnionInterDiff(RBTree set1, RBTree set2, int num) {
        if (((set1.inter(set2)).union(set2.diff(set1)).union(set1.diff(set2))).equal(set1.union(set2))) {
            System.out.println("Success for testEqualUnionInterDiff");
        } else {
            System.out.println("Fail for testEqualUnionInterDiff");
        }

    }

    public static void testUnionLeaf(RBTree set, Leaf leaf) {
        if (leaf.union(set) == set) {
            System.out.println("success for testUnionLeaf");
        } else {
            System.out.println("Fail for testUnionLeaf");
        }
    }

    public static void testEmptyInter(RBTree set, Leaf leaf) {
        if (set.inter(leaf).isEmpty()) {
            System.out.println("success for testEmptyInter");
        } else {
            System.out.println("Fail for testEmptyInter");
        }
    }

    //doesn't work
    public static void testDiffEmpty(RBTree set, Leaf leaf) {
        if (leaf.diff(set).equal(set)) {
            System.out.println("success for testDiffEmpty");
        } else {
            System.out.println("fail for testDiffEmpty");
        }
    }

    public static void testInter(RBTree set1, RBTree set2, int elt) {
        if (set1.add(elt).inter(set2.add(elt)).isEmpty()) {
            System.out.println("fail for testInter");
        } else {
            System.out.println("Success for testinter");
        }
    }

    public static void checkTransitivity(RBTree one, RBTree two, RBTree three) {
        if ((one.subset(two)) && (two.subset(three)) && !(one.subset(three))) {
            System.out.println("check Transitivity failed");
        } else {
            System.out.println("Success for checkTransitivity");
        }
    }

    public static void checkSubs() {
        int countSucc = 0;
        int countFail = 0;
        for (int i = 0; i < 100; i++) {
            RBTree tree = randSet(new Leaf(), randNum(1, 100));
            if (tree.subset(tree)) {
                countSucc = countSucc + 1;
            } else {
                countFail = countFail + 1;
            }
        }
        System.out.println("checkSubset  Success: " + countSucc + "  Failure: " + countFail);
    }

    public static void checkCardAdd() {
        int succ = 0;
        int fail = 0;
        for (int i = 0; i < 100; i++) {
            RBTree tree = randSet(new Leaf(), randNum(1, 100));
            if (tree.add(randNum(1, 100)).cardinality() > tree.cardinality()) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("checkCardAdd  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkRemoveGetCount() {
        int succ = 0;
        int fail = 0;
        for (int i = 0; i < 100; i++) {
            int rand = randNum(1, 100);
            RBTree tree = randSet(new Leaf(), randNum(1, 100));
            RBTree removed = tree.remove(rand);
            if (removed.getCount(rand) <= tree.getCount(rand)) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("CheckRemoveGetCount  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkAddSomeGetCount() {
        int succ = 0;
        int fail = 0;
        for (int i = 0; i < 100; i++) {
            RBTree tree = randSet(new Leaf(), randNum(1, 100));
        int rand = randNum(1, 100);
        RBTree added = tree.addSome(rand, rand);
            if (added.getCount(rand) > added.getCount(rand)) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("CheckAddSomeGetCount  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkSumCard() {
        int succ = 0;
        int fail = 0;
        for (int i = 0; i < 100; i++) {
            RBTree tree = randSet(new Leaf(), randNum(1, 100));
            if ((tree.sumIt() == tree.cardinality())) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("checkSumCard  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkRemoveAllGetCount() {
        int succ = 0;
        int fail = 0;
        for (int i = 0; i < 100; i++) {
            RBTree tree = randSet(new Leaf(), randNum(1, 100));
        int num = randNum(1, 100);
        RBTree removed = tree.removeAll(num);
            if (removed.getCount(num) < 0) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("CheckRemoveAllGetCount  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkMemberInter() {
        int succ = 0;
        int fail = 0;
        
        for (int i = 0; i < 100; i++) {
            RBTree tree = randSet(new Leaf(), randNum(1, 100));
        RBTree tree2 = randSet(new Leaf(), randNum(1, 100));
        int addn = randNum(1, 100);
        tree.add(addn);
        tree2.add(addn);
        RBTree inter = tree.inter(tree2);
            if (inter.member(addn)) {
                succ = succ + 1;
            } else {
                fail = fail + 1;
            }
        }
        System.out.println("CheckMemberInter  Success: " + succ + "  Failure: " + fail);
    }

    public static void checkremoveSomeGetCount() {
        int succ = 0;
        int fail = 0;
        
        for (int i = 0; i < 100; i++) {
            RBTree tree = randSet(new Leaf(), randNum(1, 100));
        int addn = randNum(1, 100);
        RBTree removed = tree.removeSome(addn, addn);
            if (removed.getCount(addn) < tree.getCount(addn)) {
                succ = succ + 1;
            } else {
                fail++;
            }
        }
        System.out.println("CheckRemoveGetCount  Success: " + succ + "  Failure: " + fail);
    }

    public static void main(String[] args) {

        System.out.println("  TESTING FOR INT FINITE BAGS: ");

        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        checkEmpty(Tree.empty());
        
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));

        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));
        checkSubset(randSet(new Leaf(), randNum(1, 100)));

        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));

        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));

        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));

        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());

        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());

        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());

        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));

        checkSubs();
        checkCardAdd();
        checkRemoveGetCount();
        checkAddSomeGetCount();
        checkSumCard();
        checkRemoveAllGetCount();
        checkMemberInter();
        checkremoveSomeGetCount();

        System.out.println();
        System.out.println("TESTING FOR STRING FINITE BAGS: ");
        System.out.println();
        
        
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));
        scheckAdd(randStringSet(new Leaf(), randNum(1, 100)));

        
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        scheckSubset(randStringSet(new Leaf(), randNum(1, 100)));
        
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));
        scheckRemove(randStringSet(new Leaf(), randNum(1, 100)));

        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        testUnionSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1,100)));
        
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestMemberAdd(randStringSet(new Leaf(), randNum(1, 100)), randString());

        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddCardinality(randStringSet(new Leaf(), randNum(1, 100)), randString());
        
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestUnionMember(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());

        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestAddRemoveEqual(randStringSet(new Leaf(), randNum(1, 100)), randString());
        
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        testSubset(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));

        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());

        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randStringSet(new Leaf(), randNum(1, 100)), new Leaf());
        
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        stestInter(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randString());
        
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        checkTransitivity(randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)), randStringSet(new Leaf(), randNum(1, 100)));
        
        checkSSubs();
        checkSCardAdd();
        checkSRemoveGetCount();
        checkSAddSomeGetCount();
        checkSSumCard();
        checkSRemoveAllGetCount();
        checkSMemberInter();
        checkSremoveSomeGetCount();
    }

}
