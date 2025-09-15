/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelibreria;

import java.util.*;

/**
 *
 * @author Venerando
 */
public class Scaffale {

    private String tema;
    private String descrizione;
    private float scontoPercentuale;
    private List<Libro> listaLibri;

    public Scaffale(String tema, String descrizione, float scontoPercentuale) 
    {
        this.tema = tema;
        this.descrizione = descrizione;
        this.scontoPercentuale = scontoPercentuale;
        listaLibri = new LinkedList<Libro>();
    }
    
    public void AggiungiLibro(Libro l)
    {
        listaLibri.add(l);
    }
    
    public String getTema()
    {
        return tema;
    }
    
    public String toString()
    {
        String scaffale = "SCAFFALE - [" + tema + ", " + descrizione + ", " + scontoPercentuale + "]\n";
        for(Libro l : listaLibri)
        {
            scaffale += l.toString();
        }
        return scaffale;
    }
    
    public void stampaLibri(String nomeAutore, String dataPubblicazione)
    {
        for(Libro l : listaLibri)
        {
            if((l.getAutore().equals(nomeAutore)) && (l.getDataPubblicazione().compareTo(dataPubblicazione)) > 0)
            {
                System.out.println(l.toString());
            }
        }
    }
    
    public boolean EliminaLibro(float prezzo)
    {
        return (listaLibri.remove(new Libro("", "", "", "", prezzo, "", true)));
    }
    
    public float prezzoMedioTotaleLibriScontati()
    {
        float somma = 0.0F;
        
        for(Libro l: listaLibri)
        {
            somma += (l.getPrezzo() * (1 - (this.scontoPercentuale / 100)));
        }
        return (somma / listaLibri.size());
    }
}
