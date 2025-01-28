package org.mileston.evento;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Classe Concerto che estende Evento
class Concerto extends Evento {
    private LocalTime ora;
    private double prezzo;

    // Costruttore
    public Concerto(String titolo, int giorno, int mese, int anno, int postiTotali, LocalTime ora, double prezzo) {
        super(titolo, giorno, mese, anno, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
       

    }

    // Getter e setter
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo per restituire data e ora formattata

    public String getDataEOraFormattata() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return (dateFormatter + " " + timeFormatter);
    }

    // Metodo per restituire il prezzo formattato con il simbolo dell'euro
    public String getPrezzoFormattato() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return currencyFormatter.format(prezzo);
    }

    @Override
    public String toString() {
        return String.format(
                "Concerto: %s\nData e Ora: %s\nPrezzo: %sEuro\nPosti Totali: %d\nPosti Prenotati: %d",
                getTitolo(),
                getDataEOraFormattata(),
                getPrezzoFormattato(),
                getPostiTotali(),
                getPostiPrenotati());
    }

}
