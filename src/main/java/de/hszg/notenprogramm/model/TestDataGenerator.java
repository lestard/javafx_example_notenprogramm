package de.hszg.notenprogramm.model;

public class TestDataGenerator {


    public static void generate() {
        Lehrplan.getInstance().addFach(new Fach("Programmierparadigmen", 5, 1));
        Lehrplan.getInstance().addFach(new Fach("Wissenschaftliches Arbeiten", 4, 1));
        Lehrplan.getInstance().addFach(new Fach("Mathematische Grundlagen", 5, 1));
        Lehrplan.getInstance().addFach(new Fach("Einführung Programmierung", 5, 1));

        Lehrplan.getInstance().addFach(new Fach("Diskrete Mathematik", 4, 2));
        Lehrplan.getInstance().addFach(new Fach("Hardware und Assemblerprogrammierung", 8, 2));
        Lehrplan.getInstance().addFach(new Fach("Betriebssysteme", 5, 2));
        Lehrplan.getInstance().addFach(new Fach("Objektorientierte Programmierung", 5, 2));
        Lehrplan.getInstance().addFach(new Fach("SE 1", 5, 2));

        Lehrplan.getInstance().addFach(new Fach("BWL", 5, 3));
        Lehrplan.getInstance().addFach(new Fach("Theoretische Informatik", 10, 3));
        Lehrplan.getInstance().addFach(new Fach("XML", 4, 3));
        Lehrplan.getInstance().addFach(new Fach("SE 2", 5, 3));
        Lehrplan.getInstance().addFach(new Fach("Rechnernetzwerke 1", 5, 3));

        Lehrplan.getInstance().addFach(new Fach("Angewandte Analysis", 4, 4));
        Lehrplan.getInstance().addFach(new Fach("Algorithmen und Komplexität", 5, 4));
        Lehrplan.getInstance().addFach(new Fach("Computerarchitektur", 3, 4));
        Lehrplan.getInstance().addFach(new Fach("SE 3", 5, 4));
        Lehrplan.getInstance().addFach(new Fach("Rechnernetzwerke 2", 5, 4));
        Lehrplan.getInstance().addFach(new Fach("Relationale Datenbanken", 5, 4));
        Lehrplan.getInstance().addFach(new Fach("English UNIcert 2", 5, 4));

        Lehrplan.getInstance().addFach(new Fach("IT-Sicherheit und Datenschutz", 5, 5));
        Lehrplan.getInstance().addFach(new Fach("Entwicklung Multimedia-Anwendungen", 5, 5));
        Lehrplan.getInstance().addFach(new Fach("Netzwerkprogrammierung", 5, 5));
        Lehrplan.getInstance().addFach(new Fach("Web-Datenbanken", 5, 5));
        Lehrplan.getInstance().addFach(new Fach("Forschungsprojekt", 5, 5));
        Lehrplan.getInstance().addFach(new Fach("Knowledge Media Design", 5, 5));

        Lehrplan.getInstance().addFach(new Fach("Praxisprojekt", 20, 6));
        Lehrplan.getInstance().addFach(new Fach("Abschlussprüfung", 10, 6));
        Lehrplan.getInstance().addFach(new Fach("Bachelorarbeit-Verteidigung", 5, 6));
    }

}
