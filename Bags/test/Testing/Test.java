/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import bags.Leaf;
import bags.Set;
import java.util.*;

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

    public static Set randSet(Set start, int length) {
        if (start.cardinality() == length) {
            return start;
        } else {
            int num = randNum(0, 100);
            return randSet(start.add(num), length);
        }
    }

    public static void checkEmpty(Set MT) {
        if (MT.isEmptyHuh()) {
            System.out.println("Success for checkEmpty");
        } else {
            System.out.println("Fail for checkAdd");
        }
    }

    public static void checkAdd(Set set) {
        int num = randNum(0, 100);
        Set set2 = set.add(num);
        if (set2.member(num)) {
            System.out.println("Success for checkAdd");
        } else {
            System.out.println("Fali for checkAdd");
        }
    }
    
    public static void checkSubset(Set set){
        int num = randNum(0, 100);
        Set subs = set.add(num);
        if (set.subset(subs)){
            System.out.println("Success for CheckSubset");
        } else {
            System.out.println("Fail for CheckSubset");
        }
    }

    public static void checkRemove(Set set) {
        int num = randNum(0, 100);
        Set set2 = set.add(num);
        Set removed = set2.remove(num);
        if (removed.equal(set)) {
            System.out.println("Success for checkRemove");
        } //        if ((!removed.member(num)) || (removed.getCount(num)< set.getCount(num))) {
        //            System.out.println("Success for checkRemove");
        //        } 
        else {
            System.out.println("Fail for checkRemove ");
        }
    }
    
    //Why does this return false? 
    public static void checkSubs(Set set){
        System.out.println(set.subset(set));
    }

    //doesn't work 
    public static void testUnionSubset(Set set1, Set set2) {
        Set testSet1 = set1.union(set2);
        if ((testSet1.subset(set1)) && (testSet1.subset(set2))) {
            System.out.println("Success for testUnionSubset");
        } else {
            System.out.println("Failure for testUnionSubset");
        }
    }

    public static void testMemberAdd(Set set1, int num) {
        if (set1.add(num).member(num)) {
            System.out.println("Success for testMemberAdd");
        } else {
            System.out.println("Fail for testMemberAdd");
        }
    }

    public static void testAddCardinality(Set set1, int num) {
        int test = set1.add(num).cardinality();
        if (((set1.cardinality() + 1) == test) || (set1.cardinality() == test)) {
            System.out.println("Success for testAddCardinality");
        } else {
            System.out.println("Fail for testAddCardinality");
        }
    }

    public static void testUnionMember(Set set1, Set set2, int num) {
        if (set1.union(set2).member(num) == (set1.member(num) || (set2.member(num)))) {
            System.out.println("Success for testUnionMember");
        } else if (!(set1.member(num) || set2.member(num))) {
            System.out.println("the number was not a member of the set: testUnionMember");
        } else {
            System.out.println("Fail for testUnionMember");
        }
    }

    //doesn't work 
    public static void testAddRemoveEqual(Set set1, int num) {
        if (((set1.add(num)).remove(num)).equal(set1)) {
            System.out.println("Success for testAddRemoveEqual");
        } else {
            System.out.println("Fail for testAddRemoveEqual");
        }
    }

    public static void testSubset(Set set1, Set set2, Set set3) {
        if ((set1.union(set2)).subset(set3)
                == (set1.subset(set3) && set2.subset(set3))) {
            System.out.println("Success for testSubset");
        } else {
            System.out.println("Failure for testSubset");
        }
    }

    //doesn't work 
    public static void testEqualUnionInterDiff(Set set1, Set set2, int num) {
        if (((set1.inter(set2)).union(set2.diff(set1)).union(set1.diff(set2))).equal(set1.union(set2))) {
            System.out.println("Success for testEqualUnionInterDiff");
        } else {
            System.out.println("Fail for testEqualUnionInterDiff");
        }

    }

    public static void testUnionLeaf(Set set, Leaf leaf) {
        if (leaf.union(set) == set) {
            System.out.println("success for testUnionLeaf");
        } else {
            System.out.println("Fail for testUnionLeaf");
        }
    }

    public static void testEmptyInter(Set set, Leaf leaf) {
        if (set.inter(leaf).isEmptyHuh()) {
            System.out.println("success for testEmptyInter");
        } else {
            System.out.println("Fail for testEmptyInter");
        }
    }

    //doesn't work
    public static void testDiffEmpty(Set set, Leaf leaf) {
        if (leaf.diff(set).equal(set)) {
            System.out.println("success for testDiffEmpty");
        } else {
            System.out.println("fail for testDiffEmpty");
        }
    }

    public static void testInter(Set set1, Set set2, int elt) {
        if (set1.add(elt).inter(set2.add(elt)).isEmptyHuh()) {
            System.out.println("fail for testInter");
        } else {
            System.out.println("Success for testinter");
        }
    }

    public static void checkEqual(Set EMT, Set MT) {
        if (EMT.equal(MT)) {
            System.out.println("Success for testEqual");
        } else {
            System.out.println("Fail for testEqual");
        }
    }

    public static void checkTransitivity(Set one, Set two, Set three) {
        if ((one.subset(two)) && (two.subset(three)) && !(one.subset(three))) {
            System.out.println("check Transitivity failed");
        } else {
            System.out.println("Success for CheckTransitivity");
        }
    }

    public static void main(String[] args) {
//
//        checkEmpty(empty());
//        checkEmpty(empty());
//        checkEmpty(empty());
//        checkEmpty(empty());
//        checkEmpty(empty());
//        checkEmpty(empty());
//        checkEmpty(empty());
//        checkEmpty(empty());
//        checkEmpty(empty());
//        checkEmpty(empty());

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

//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
//        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        
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

//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        
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

//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
//        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
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

//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
//        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        
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

//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
//        checkEqual(empty(), empty());
        
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
        
        checkSubs(randSet(new Leaf(), randNum(1, 100)));
    }

}
