package org.hbrs.se1.ws24.exercises.uebung2.container;

import org.hbrs.se1.ws24.exercises.uebung2.member.Member;
import org.hbrs.se1.ws24.exercises.uebung2.fehlerbehandlung.ContainerException;

import java.util.ArrayList;

public class Container {

    ArrayList<Member> memberList = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        for (Member m : memberList) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + m.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(member);
    }

    public String deleteMember(Integer id) {
        if(memberList.removeIf(m -> m.getID().equals(id))) {
            return "Member mit " + id + "gelöscht.";
        } else {
            return"Member mit " + id + " nicht vorhanden.";
        }
    }

    public void dump() {
        System.out.println(memberList);
    }

    public Integer size() {
        return memberList.size();
    }
}
