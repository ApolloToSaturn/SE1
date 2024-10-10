package org.hbrs.se1.ws24.exercises.uebung2.container;

import org.hbrs.se1.ws24.exercises.uebung2.member.Member;
import org.hbrs.se1.ws24.exercises.uebung2.fehlerbehandlung.ContainerException;

import java.util.ArrayList;

public class Container {

    private Integer size = 0;
    ArrayList<Member> memberList = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        for (Member m : memberList) {
            if (m.getID() == member.getID()) {
                throw new ContainerException("Das Member-Objekt mit der ID " + m.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(member);
        this.size++;
    }

    public void deleteMember(Integer id) {
        if(memberList.removeIf(m -> m.getID() == id)) {
            this.size--;
        } else {
            System.out.println("Member mit " + id + " nicht vorhanden.");
        }
    }

    public void dump() {
        for(Member m : memberList) {
            System.out.println(m);
        }
    }

    public Integer size() {
        return size;
    }
}
