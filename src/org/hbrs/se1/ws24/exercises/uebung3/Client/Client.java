package org.hbrs.se1.ws24.exercises.uebung3.Client;

import org.hbrs.se1.ws24.exercises.uebung2.container.Container;
import org.hbrs.se1.ws24.exercises.uebung2.fehlerbehandlung.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.member.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.member.Member;
import org.hbrs.se1.ws24.exercises.uebung3.view.MemberView;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public Client(Container<Member> container) throws ContainerException {
        List<Member> memberList = new ArrayList<>();
        for (int i = 0;i<3;i++) {
            container.addMember(new ConcreteMember(i));
        }

        List<Member> listedMember = container.getCurrentList();

        MemberView.dump(listedMember);
    }
}
