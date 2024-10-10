package org.hbrs.se1.ws24.exercises.uebung2.container;

import org.hbrs.se1.ws24.exercises.uebung2.fehlerbehandlung.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.member.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.member.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container;
    Member member1;
    Member member2;

    @BeforeEach
    void setUp() {
        container = new Container();
        member1 = new ConcreteMember(1);
        member2 = new ConcreteMember(2);
    }

    @AfterEach
    void tearDown() {
        container = null;
        member1 = null;
        member2 = null;
    }

    /*  Bei der addMember(Member)-Methode wird, sofern der Container die MemberID noch nicht gespeichert hat,
        die size-Variable im Container um eins erhöht.
     */
    @Test
    void addMember() throws ContainerException {
        assertEquals(0, container.size(), "Containergröße stimmt nicht überein");

        container.addMember(member1);
        assertEquals(1, container.size(), "Containergröße stimmt nicht überein");

        container.addMember(member2);
        assertEquals(2, container.size(), "Containergröße stimmt nicht überein");

        /*  Es wird geprüft, ob die Exception geworfen wird, wenn ein Member mit derselben ID schon vorhanden ist
            und das die size-Variable nicht erhöht wird
         */
        assertThrows(ContainerException.class,() -> container.addMember(member1));
        assertEquals(2, container.size(), "Containergröße stimmt nicht überein");
    }
    /*  Bei der deleteMember(Integer)-Methode wird, sofern der Container die MemberID hat,
        die size-Variable im Container um eins vermindert und das Memberobjekt aus dem Container gelöscht.
     */
    @Test
    void deleteMember() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        assertEquals(2, container.size(), "Containergröße stimmt nicht überein");

        container.deleteMember(2);
        assertEquals(1, container.size(), "Containergröße stimmt nicht überein");

        /* Es wird nochmal die gleiche MemberID gelöscht --> sollte nicht im Container vorhanden sein,
          daher bleibt die Größe bestehen
        */
        container.deleteMember(2);
        assertEquals(1, container.size(), "Containergröße stimmt nicht überein");

        container.deleteMember(1);
        assertEquals(0, container.size(), "Containergröße stimmt nicht überein");
    }
}