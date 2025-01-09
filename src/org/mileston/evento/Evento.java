package org.mileston.evento;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Evento {
    private String titolo;
    private int giorno;
    private int mese;
    private int anno;
    private String data;
    private final int postiTotali;
    private int postiPrenotati;

    // Costruttore
    public Evento(String titolo, int giorno, int mese, int anno, int postiTotali) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String temp = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (Integer.parseInt(timeStamp) > Integer.parseInt(temp)) {
            throw new IllegalArgumentException("La data dell'evento non è più disponibile.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        this.titolo = titolo;
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.data = giorno + "/" + mese + "/" + anno;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    // Getter e Setter
    public String getTitolo() {
        return this.titolo;
    }

    public String getDate() {
        return this.data;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    // Metodi
    public void prenota() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String temp = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (Integer.parseInt(timeStamp) > Integer.parseInt(temp)) {
            System.out.println("L'evento è già passato, non è possibile prenotare.");
            return;
        }
        if (postiPrenotati >= postiTotali) {
            System.out.println("Non ci sono posti disponibili.");
            return;
        }
        postiPrenotati++;
    }

    public void disdici() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String temp = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (Integer.parseInt(timeStamp) > Integer.parseInt(temp)) {
            System.out.println("L'evento è già passato, non è possibile disdire.");
            return;
        }
        if (postiPrenotati <= 0) {
            System.out.println("Non ci sono prenotazioni da disdire.");
            return;
        }
        postiPrenotati--;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.getDate() + " " + this.getTitolo();
    }
}