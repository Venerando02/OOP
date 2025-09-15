/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneopere;
import java.util.*;
/**
 *
 * @author Venerando
 */
public class Sala 
{
    private String nomeSala;
    private int codiceSala;
    private String periodoStorico;
    private String collocazioneEdificio;
    private List<Opera> listaOpere;
    
    public Sala(String nome, int codice, String periodoStorico, String collocazioneEdificio)
    {
        this.nomeSala = nome;
        this.codiceSala = codice;
        this.periodoStorico = periodoStorico;
        this.collocazioneEdificio = collocazioneEdificio;
        listaOpere = new LinkedList<Opera>();
    }
    
    public int getCodiceSala()
    {
        return codiceSala;
    }
    
    public boolean inserisciOpera(Opera o)
    {
        return listaOpere.add(o);
    }
    
    public String toString()
    {
        String stringa = "SALA [" + nomeSala + "; " + codiceSala + "; " + periodoStorico + "; " + collocazioneEdificio + "]\n\n";
        for(Opera o: listaOpere)
        {
            stringa += o.toString();
        }
        return stringa;
    }
    
    public int eliminaOpera(int codiceOpera)
    {
        int cont = 0;
        for(Iterator<Opera> it = listaOpere.iterator(); it.hasNext(); )
        {
            Opera o = it.next();
            if(o.getCodiceOpera() == codiceOpera)
            {
                it.remove();
                cont++;
            }
        }
        return cont;
    }
    
    public float valoreTotaleOpereAutore(String nomeAutore)
    {
        float valoreTot = 0.0F;
        
        for(Opera o: listaOpere)
        {
            if(o.getNomeAutore().equals(nomeAutore))
                valoreTot += o.getValoreOpera();
        }
        
        return valoreTot;
    }
    
    public String contaTipologiaMax()
    {
        String operaMaxTipologia = "";
        Opera o1, o2;
        int max = -1, cont;
        for(Iterator<Opera> it = listaOpere.iterator(); it.hasNext();)
        {
            o1 = it.next();
            cont = 0;
            for(Iterator<Opera> it2 = listaOpere.iterator(); it2.hasNext();)
            {
                o2 = it2.next();
                if(o1.getTipologiaOpera().equals(o2.getTipologiaOpera()))
                {
                    cont++;
                }
            }
            if(cont > max)
            {
                max = cont;
                operaMaxTipologia = o1.getTipologiaOpera();
            }
        }
        return operaMaxTipologia;
    }
}
