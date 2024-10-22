package org.hbrs.se1.ws24.exercises.uebung3.view;

import org.hbrs.se1.ws24.exercises.uebung2.member.Member;

import java.util.List;

public class MemberView {

    public static void dump(List<? extends Member> liste) {
        for (Member m : liste) {
            System.out.println(m);
        }
    }
}
