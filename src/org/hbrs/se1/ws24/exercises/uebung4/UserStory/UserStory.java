package org.hbrs.se1.ws24.exercises.uebung4.UserStory;

import org.hbrs.se1.ws24.exercises.uebung2.member.Member;

public class UserStory implements Member {

    private Integer id;

    private String titel;

    private String akzeptanzKriterium;

    private String projekt;

    private Integer mehrwert;

    private Integer risiko;

    private Integer aufwand;

    private Integer nutzen;

    private Double prioritaet;

    public UserStory(Integer id, String titel, String akzeptanzKriterium,
                     String projekt, Integer mehrwert, Integer risiko,
                     Integer aufwand, Integer nutzen) {
        this.id = id;
        this.titel = titel;
        this.akzeptanzKriterium = akzeptanzKriterium;
        this.projekt = projekt;
        this.mehrwert = mehrwert;
        this.risiko = risiko;
        this.aufwand = aufwand;
        this.nutzen = nutzen;
        prioritaet = berechnePrio();
    }

    private Double berechnePrio() {
        return (double) ((mehrwert + nutzen) / (aufwand + risiko));
    }

    @Override
    public Integer getID() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getAkzeptanzKriterium() {
        return akzeptanzKriterium;
    }

    public String getProjekt() {
        return projekt;
    }

    public Integer getMehrwert() {
        return mehrwert;
    }

    public Integer getRisiko() {
        return risiko;
    }

    public Integer getAufwand() {
        return aufwand;
    }

    public Integer getNutzen() {
        return nutzen;
    }

    public Double getPrioritaet() {
        return prioritaet;
    }

    public String toString() {
        return "----- ID: " + getID() + "-----\n"
                + "Title: " + getTitel() + '\n'
                + "Akzeptanzkriterium: " + getAkzeptanzKriterium() + '\n'
                + "Projekt: " + getProjekt() + '\n'
                + "Mehrwert: " + getMehrwert() + '\n'
                + "Strafe: " + getNutzen() + '\n'
                + "Risiko: " + getRisiko() + '\n'
                + "Story Points: " + getAufwand() + '\n'
                + "Prio: " + getPrioritaet() + '\n'
                + "----------\n";
    }
}
