package org.hbrs.se1.ws24.exercises.uebung2.container;

import org.hbrs.se1.ws24.exercises.uebung2.member.Member;
import org.hbrs.se1.ws24.exercises.uebung2.fehlerbehandlung.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws24.exercises.uebung3.view.MemberView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Container <E extends Member> {

    private List<E> memberList = new ArrayList<>();

    private PersistenceStrategy<E> persistenceStrategyStream;

    //Singleton Designpattern
    private static Container<? extends Member> instance;

    private Container() {
    }
    @SuppressWarnings("unchecked")
    public static <E extends Member> Container<E> getInstance() {
        if(instance == null) {
            instance = new Container<>();
        }
        return (Container<E>) instance;
    }

    public void setPersistenceStrategyStream(PersistenceStrategy<E> persistenceStrategyStream) {
        this.persistenceStrategyStream = persistenceStrategyStream;
    }

    public void addMember(E member) throws ContainerException {
        for (Member m : memberList) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + m.getID() + " ist bereits vorhanden!");
            }
        }
        memberList.add(member);
    }

    //persistente Speicherung der Member auf dem Datenträger
    public void store() throws PersistenceException {
        if (persistenceStrategyStream != null) {
                persistenceStrategyStream.save(memberList);
                //throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Speicherimplementierung nicht verfügbar");
        } else {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Keine Speicherstrategie implementiert");
        }
    }

    //lädt die gespeicherten Member
    public void load() throws PersistenceException {
        if (persistenceStrategyStream != null) {
            try {
                memberList = persistenceStrategyStream.load();
            } catch (PersistenceException pe) {
                throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Ladeimplementierung nicht verfügbar");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet,"Keine Speicherstrategie implementiert");
        }
    }

    public String deleteMember(Integer id) {
        if(memberList.removeIf(m -> m.getID().equals(id))) {
            return "Member mit " + id + "gelöscht.";
        } else {
            return"Member mit " + id + " nicht vorhanden.";
        }
    }

    public List<E> getCurrentList() {
        return memberList;
    }
    public void dump() {
        MemberView.dump(memberList);
    }

    public Integer size() {
        return memberList.size();
    }
}
