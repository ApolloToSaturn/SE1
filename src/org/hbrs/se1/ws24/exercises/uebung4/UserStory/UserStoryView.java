package org.hbrs.se1.ws24.exercises.uebung4.UserStory;

import java.util.Comparator;
import java.util.List;

public class UserStoryView {

    public static void dump(List<UserStory> userStories) {

        List<UserStory> sortedUserStories = userStories.stream()
                .sorted(Comparator.comparing(UserStory::getPrioritaet).reversed())
                .toList();

        // Tabellenkopf ausgeben
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %4s | %20s | %30s | %6s | %6s | %6s | %6s | %10s | %8s |\n",
                "ID", "Titel", "Akzeptanzkriterium", "Risiko", "Aufwand", "Nutzen", "Mehrwert", "Projekt", "Priorität");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        // User Stories in Tabellenform ausgeben
        for (UserStory userStory : sortedUserStories) {
            System.out.printf("| %4d | %20s | %30s | %6d | %6d | %6d | %6d | %10s | %8.2f |\n",
                    userStory.getID(), userStory.getTitel(), userStory.getAkzeptanzKriterium(), userStory.getRisiko(),
                    userStory.getAufwand(), userStory.getNutzen(), userStory.getMehrwert(), userStory.getProjekt(),
                    userStory.getPrioritaet());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }
}
