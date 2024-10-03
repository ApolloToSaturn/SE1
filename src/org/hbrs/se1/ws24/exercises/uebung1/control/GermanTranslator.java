package org.hbrs.se1.ws24.exercises.uebung1.control;

import java.util.Map;

public class GermanTranslator implements Translator {

	public String date = "Okt/2024"; // Default-Wert

	private final Map<Integer, String> translateNumber = Map.of(
			1, "eins",
			2, "zwei",
			3, "drei",
			4, "vier",
			5, "fünf",
			6, "sechs",
			7, "sieben",
			8, "acht",
			9, "neun",
			10,"zehn"
	);

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		String uebersetzung = translateNumber.get(number);
		if(uebersetzung == null) {
			return ("Übersetzung der Zahl " + number + " nicht möglich.\n" + "Translatorversion: " + version);
		}
		return uebersetzung;
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2024"))
	 * Das Datum sollte system-intern durch eine Factory-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
