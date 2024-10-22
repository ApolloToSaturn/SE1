package org.hbrs.se1.ws24.exercises.uebung2.member;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {

    private int id;

    public ConcreteMember(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Member (ID = " + getID() + ")";
    }
}
