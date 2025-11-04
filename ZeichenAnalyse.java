/**
 * Zeichenanalyse Aufgabe D3
 * Bereinigt einen eingegebenen Text und führt vorgegebene Modifikationen aus.
 * Timo Blöchlinger, Diego Straub
 * V1.0 04.11.2025: First Run
 */
 
import ch.tbz.lib.Input;
import java.util.Scanner;
import java.util.Arrays;
 
public class ZeichenAnalyse {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Geben Sie einen Text ein:");
        String input = sc.nextLine();
 
        // 1. Leerzeichen bereinigen
        String bereinigt = input.trim().replaceAll("\\s+", " ");
 
        // 2. Dynamisches Array mit Wörtern
        String[] woerter = bereinigt.split(" ");
 
        // 3. Statisches char-Array (nur Buchstaben A-Z und a-z)
        StringBuilder buchstabenBuilder = new StringBuilder();
        for (char c : bereinigt.toCharArray()) {
            if (Character.isLetter(c)) {
                buchstabenBuilder.append(c);
            }
        }
        char[] buchstabenArray = buchstabenBuilder.toString().toCharArray();
 
        // 4. Zählvariablen
        int gross = 0;
        int klein = 0;
        int vokale = 0;
 
        for (char c : buchstabenArray) {
            if (Character.isUpperCase(c)) gross++;
            if (Character.isLowerCase(c)) klein++;
            if (istVokal(c)) vokale++;
        }
 
        // 5. Vokale im char-Array durch '*' ersetzen
        char[] ersetzt = Arrays.copyOf(buchstabenArray, buchstabenArray.length);
        for (int i = 0; i < ersetzt.length; i++) {
            if (istVokal(ersetzt[i])) {
                ersetzt[i] = '*';
            }
        }
 
        // 6. Ausgaben
        System.out.println("\n--- AUSGABE ---");
        System.out.println("Originaltext:");
        System.out.println(input);
        System.out.println("\nBereinigter Text:");
        System.out.println(bereinigt);
 
        System.out.println("\nWortliste (dynamisch):");
        System.out.println(Arrays.toString(woerter));
 
        System.out.println("\nBuchstabenarray (A-Z/a-z):");
        System.out.println(Arrays.toString(buchstabenArray));
 
        System.out.println("\nStatistik:");
        System.out.println("Grossbuchstaben: " + gross);
        System.out.println("Kleinbuchstaben: " + klein);
        System.out.println("Vokale (a,e,i,o,u): " + vokale);
 
        System.out.println("\nModifiziertes Buchstabenarray (Vokale -> '*'):");
        System.out.println(Arrays.toString(ersetzt));
 
        System.out.println("\nAls String ausgegeben:");
        System.out.println(new String(ersetzt));
 
        sc.close();
    }
    // "istVokal" Funktion definieren
    private static boolean istVokal(char c) {
        char lower = Character.toLowerCase(c);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }
}
 
 