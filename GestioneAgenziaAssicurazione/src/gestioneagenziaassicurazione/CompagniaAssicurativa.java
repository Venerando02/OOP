/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneagenziaassicurazione;
import java.io.*;
import java.util.*;
/**
 *
 * @author Venerando
 */
public class CompagniaAssicurativa 
{
    private String nome;
    private String indirizzo;
    private String nomeReferente;
    private List<Cliente> listaClienti;
    
    public CompagniaAssicurativa(String nome, String indirizzo, String nomeReferente)
    {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.nomeReferente = nomeReferente;
        listaClienti = new LinkedList<Cliente>();
    }
    
    public String getNomeCompagnia()
    {
        return nome;
    }
    
    public void aggiungiCliente(Cliente c)
    {
        listaClienti.add(c);
    }
    
    public String toString()
    {
        String stringa = "COMPAGNIA ASSICURATIVA [" + nome + ", " + indirizzo + ", " + nomeReferente + "]\n\n";
        for(Cliente c: listaClienti)
        {
            stringa += c.toString();
        }
        return stringa;
    }
    
    public int numClienti()
    {
        return listaClienti.size();
    }
    
    public boolean polizzaAttiva(String cf)
    {
        boolean polizzaAttiva = false;
        for(Cliente c : listaClienti)
        {
            if(c.getCFCliente().equals(cf))
            {
                polizzaAttiva = true;
                break;
            }
        }
        return polizzaAttiva;
    }
    
    public boolean stipulaPolizza(Cliente c)
    {
        boolean inserito = false;
        if(!polizzaAttiva(c.getCFCliente()))
        {
            aggiungiCliente(c);
            inserito = true;
        }
        return inserito;
    }
    
    public float stampaSommaRatePolizze(String cf, String dataScadenza)
    {
        float sommaTot = 0.0F;
        for(Cliente c: listaClienti)
        {
            if((c.getCFCliente().equals(cf)) && (c.getDataScadenza().compareTo(dataScadenza)>0))
            {
                sommaTot += c.getImportoRataPolizza();
            }
        }
        return sommaTot;
    }
}
