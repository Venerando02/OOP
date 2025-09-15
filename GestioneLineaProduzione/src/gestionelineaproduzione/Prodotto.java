/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelineaproduzione;
import java.util.*;
/**
 *
 * @author Venerando
 */
public class Prodotto 
{
    private String id;
    private String descrizione;
    private float peso;
    private float volume;
    private List<Registrazione> listaRegistrazioni;
    
    public Prodotto(String id, String descrizione, float peso, float volume)
    {
        this.id = id;
        this.descrizione = descrizione;
        this.peso = peso;
        this.volume = volume;
        listaRegistrazioni = new LinkedList<Registrazione>();
    }
    
    public void inserisciRegistrazione(Registrazione r)
    {
        listaRegistrazioni.add(r);
    }
    
    public String getIdProdotto()
    {
        return id;
    }
    
    public String toString()
    {
        String stringa = "PRODOTTO [" + id + "; " + descrizione + "; " + peso + "; " + volume + "]\n";
        for(Registrazione r: listaRegistrazioni)
        {
            stringa += r.toString();
        }
        return stringa;
    }
    
    public float resaMaggiorePercentualeProdotto()
    {
        int numPezziTotaliDifettosi = 0, quantitaTotaleProdotta = 0;
        float percentualeResa = 0.0F;
        for(Registrazione r: listaRegistrazioni)
        {
            numPezziTotaliDifettosi += r.getPezziDifettosi();
            quantitaTotaleProdotta += r.getQuantitaProdotte();
        }
        percentualeResa = (((float)numPezziTotaliDifettosi / (float)quantitaTotaleProdotta) * 100.0F);
        return percentualeResa;
    }
    
    public int EliminaRegistrazione(String data)
    {
        int cont = 0;
        if(listaRegistrazioni.remove(new Registrazione("", data, 0, 0)))
            cont++;
        return cont;
    }
    
    public float pesoComplessivo(String data)
    {
        int cont = 0;
        float pesoTot = 0.0F;
        for(Registrazione r : listaRegistrazioni)
        {
            if(r.getData().equals(data))
            {
                cont+=r.getQuantitaProdotte();
            }
        }
        pesoTot = this.peso * (float)cont;
        return pesoTot;
    }
    
    public float volumeTotale()
    {
        float volumeTot = 0.0F;
        int quantitaTot = 0;
        for(Registrazione r : listaRegistrazioni)
        {
            quantitaTot += r.getQuantitaProdotte();
        }
        volumeTot = (this.volume * (float)quantitaTot);
        return volumeTot;
    }
}
