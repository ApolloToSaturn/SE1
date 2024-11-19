package org.hbrs.se1.ws24.exercises.uebung4.Client;

import org.hbrs.se1.ws24.exercises.uebung2.container.Container;
import org.hbrs.se1.ws24.exercises.uebung2.fehlerbehandlung.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws24.exercises.uebung4.UserStory.UserStory;
import org.hbrs.se1.ws24.exercises.uebung4.UserStory.UserStoryView;

import java.util.Scanner;

/**
 * Die Klasse Client ist die Hauptklasse des User Story Management Systems.
 * Sie bietet eine textbasierte Benutzerschnittstelle zur Verwaltung von User Stories,
 * einschließlich Hinzufügen, Speichern, Laden, und Auflisten.
 */
public class Client {
    private static final Container<UserStory> container = Container.getInstance();
    private static final PersistenceStrategyStream<UserStory> persistenceStrategy = new PersistenceStrategyStream<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String speicherOrt = "UserStories.ser";

    public static void main(String[] args) {
        initializePersistence();
        processUserCommands();
    }

    private static void initializePersistence() {
        container.setPersistenceStrategyStream(persistenceStrategy);
        persistenceStrategy.setLocation(speicherOrt);
        System.out.println("Willkommen zum User Story Management System.");
    }

    private static void processUserCommands() {
        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 3);
            String command = parts[0];
            try {
                switch (command) {
                    case "enter" -> enterUserStory();
                    case "store" -> container.store();
                    case "load" -> container.load();
                    case "dump" -> {
                        UserStoryView.dump(container.getCurrentList());
                    }
                    case "exit" -> {
                        System.out.println("Auf Wiedersehen.");
                        return;
                    }
                    case "help" -> printHelp();
                    default -> System.out.println("Unbekannter Befehl. Geben Sie 'help' für eine Liste der Befehle ein.");
                }
            } catch (Exception e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }
    }

    private static void enterUserStory() throws ContainerException {
        Integer id = readInteger("ID");
        String title = readString("Titel");
        String acceptanceCriteria = readString("Akzeptanzkriterium");
        String project = readString("Projekt");

        Integer value = readBoundedInteger("Mehrwert (1=niedrig - 5=hoch)", 1, 5);
        Integer penalty = readBoundedInteger("Strafe (1=niedrig - 5=hoch)", 1, 5);
        Integer effort = readBoundedInteger("Aufwand (1=niedrig - 5=hoch)", 1, 5);
        Integer risk = readBoundedInteger("Risiko (muss größer 0 sein)", 1);

        UserStory story = new UserStory(id, title, acceptanceCriteria, project, value, penalty, effort, risk);
        container.addMember(story);
        System.out.println("User Story hinzugefügt.");
    }

    private static String readString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }

    private static Integer readInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte eine Ganzzahl eingeben.");
            }
        }
    }

    private static Integer readBoundedInteger(String prompt, int min, int max) {
        while (true) {
            int value = readInteger(prompt);
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Bitte eine Zahl zwischen " + min + " und " + max + " eingeben.");
            }
        }
    }

    private static Integer readBoundedInteger(String prompt, int min) {
        while (true) {
            int value = readInteger(prompt);
            if (value >= min){
                return value;
            } else {
                System.out.println("Bitte eine Zahl größer 0 angeben.");
            }
        }
    }


    private static void printHelp() {
        System.out.println("Verfügbare Befehle:");
        System.out.println("enter - Eingabe einer neuen User Story");
        System.out.println("store - Speichert die User Stories in einer Datei");
        System.out.println("load - Lädt User Stories aus einer Datei");
        System.out.println("dump - Ausgabe aller User Stories, sortiert nach Priorität");
        System.out.println("exit - Beendet das Programm");
        System.out.println("help - Zeigt diese Hilfe an");
    }
}