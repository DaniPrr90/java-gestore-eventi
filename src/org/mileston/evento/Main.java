package org.mileston.evento;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concerto concerto = new Concerto("Evento", 01, 7, 2025, 100, LocalTime.of(20, 0), 65.9);

        System.err.println(concerto.getDate());
        System.err.println(concerto.getOra());
        System.err.println(concerto.getDataEOraFormattata());
        System.err.println(concerto.getPostiTotali());
        System.err.println(concerto.toString());
        System.out.println(concerto.getPrezzoFormattato());

        try {
            // Creazione di un nuovo evento
            System.out.println("Inserisci il titolo dell'evento:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci il giorno dell'evento (1-31):");
            int giorno = scanner.nextInt();

            System.out.println("Inserisci il mese dell'evento (1-12):");
            int mese = scanner.nextInt();

            System.out.println("Inserisci l'anno dell'evento (es. 2025):");
            int anno = scanner.nextInt();

            System.out.println("Inserisci il numero totale di posti disponibili:");
            int postiTotali = scanner.nextInt();

            Evento evento = new Evento(titolo, giorno, mese, anno, postiTotali);
            System.out.println("Evento creato: " + evento);

            // Prenotazioni
            System.out.println("Vuoi fare una prenotazioni? (sì/no):");
            scanner.nextLine(); // Consuma la nuova riga rimasta dal precedente nextInt()
            String risposta = scanner.nextLine().trim().toLowerCase();

            if (risposta.equals("sì") || risposta.equals("si")) {
                System.out.println("Quanti posti vuoi prenotare?");
                int postiDaPrenotare = scanner.nextInt();
                evento.prenota(postiDaPrenotare);
            }

            // Disdette
            System.out.println("Vuoi disdire prenotazioni? (sì/no):");
            scanner.nextLine();
            risposta = scanner.nextLine().trim().toLowerCase();

            if (risposta.equals("sì") || risposta.equals("si")) {
                System.out.println("Quanti posti vuoi disdire?");
                int postiDaDisdire = scanner.nextInt();
                for (int i = 0; i < postiDaDisdire; i++) {
                    try {
                        evento.disdici();
                    } catch (IllegalStateException e) {
                        System.out.println("Errore durante la disdetta: " + e.getMessage());
                        break;
                    }
                }
                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
