/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesupermercati;
import java.util.*;

/**
 *
 * @author Venerando
 */
public class Cliente 
{
    private String idCliente;
    private String nomeCliente;
    private String indirizzoCliente;
    private List<Acquisto> listaAcquisti;
    
    public Cliente(String idCliente, String nomeCliente, String indirizzoCliente)
    {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.indirizzoCliente = indirizzoCliente;
        listaAcquisti = new LinkedList<Acquisto>();
    }
    
    public String toString()
    {
        String stringa = "CLIENTE [" + idCliente + ", " + nomeCliente + ", " + indirizzoCliente + "] \n\n";
        for(Acquisto a: listaAcquisti)
        {
            stringa += a.toString();
        }
        return stringa;
    }
    
    public String getID()
    {
        return idCliente;
    }
    
    public String getNome()
    {
        return nomeCliente;
    }
    
    public void inserisciAcquisto(Acquisto a)
    {
        listaAcquisti.add(a);
    }
    
    public int eliminaAcquisti(float importo) 
    {
        int cont = 0;
        for (Iterator<Acquisto> it = listaAcquisti.iterator(); it.hasNext();)
        {
            Acquisto a = it.next();
            if((a.getMerceConsegnata()) && (a.getImporto() < importo))
            {
                it.remove();
                cont++;
            }
        }
        return cont;
    }
    
    public float getImportoTotaleDaConsegnare(String data)
    {
        float importoTot = 0.0F;
        for(Iterator<Acquisto> it = listaAcquisti.iterator(); it.hasNext(); )
        {
            Acquisto a = it.next();
            if((!a.getMerceConsegnata()) && (a.getData().equals(data)))
                importoTot += a.getImporto();
        }
        return importoTot;
    }
    
    public float getSpesaTotale2020()
    {
        float spesaTot2020 = 0.0F;
        for(Acquisto a : listaAcquisti)
        {
            if((a.getData().compareTo("20200101") > 0) && (a.getData().compareTo("20201212") < 0))
                spesaTot2020 += a.getImporto();
        }
        return spesaTot2020;
    }
}
