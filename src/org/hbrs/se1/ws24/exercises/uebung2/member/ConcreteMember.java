package org.hbrs.se1.ws24.exercises.uebung2.member;

public class ConcreteMember implements Member {

    private Integer id;

    public ConcreteMember(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getID() {
        return id;
    }

    public String toString() {
        return "Member (ID = " + getID() + ")";
    }
}
