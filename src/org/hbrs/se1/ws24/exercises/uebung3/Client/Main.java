package org.hbrs.se1.ws24.exercises.uebung3.Client;

import org.hbrs.se1.ws24.exercises.uebung2.container.Container;
import org.hbrs.se1.ws24.exercises.uebung2.fehlerbehandlung.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.member.Member;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;

public class Main {
    public static void main(String[] args) throws ContainerException {

        Container<Member> container = Container.getInstance();

        PersistenceStrategy<Member> strategy = new PersistenceStrategyStream<>();

        container.setPersistenceStrategyStream(strategy);

        Client client = new Client(container);

    }
}
