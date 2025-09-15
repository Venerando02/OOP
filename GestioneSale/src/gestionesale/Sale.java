/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesale;

import java.io.*;
import java.util.*;

/**
 *
 * @author Venerando
 */
public class Sale {

    private List<Sala> listaSale;
    private String tipologiaOperaPiuPresente;
    
    public Sale() {
        listaSale = new LinkedList<Sala>();
    }
    
    public void stampaTutto()
    {
        for(Sala s : listaSale)
        {
            System.out.println(s);
        }
    }
    
    public void eliminaOpera(int codiceSala, int codiceOpera) throws OperaNonEsistenteException
    {
        boolean eliminato = false;
        
        for(Sala s : listaSale)
        {
            if(s.remove(codiceSala, codiceOpera))
            {
                eliminato = true;
            }
        }
        
        if(eliminato == false)
            throw new OperaNonEsistenteException();
    }
    
    public synchronized float valoreTotaleOpere(String nomeAutore)
    {
        float valoreTot = 0.0F;
        for(Sala s : listaSale)
        {
            valoreTot += s.valoreTotaleOpereAutore(nomeAutore);
        }
        return valoreTot;
    }
    
    public synchronized void caricaSale(String nomeFile) {
        try {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));

            String nomeSala;
            int codiceSala;
            String periodoStorico;
            String collocazione;

            nomeSala = fp.readLine();

            while (nomeSala != null) {
                codiceSala = Integer.parseInt(fp.readLine());
                periodoStorico = fp.readLine();
                collocazione = fp.readLine();

                listaSale.add(new Sala(nomeSala, codiceSala, periodoStorico, collocazione));

                nomeSala = fp.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Errore di I/O.");
            System.exit(-1);
        }
    }

    public synchronized void caricaOpere(String nomeFile)
    {
        try 
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));

            String nomeAutore;
            int codiceSala;
            int codiceOpera;
            String tipologia;
            float stima;
            
            nomeAutore = fp.readLine();
            
            while(nomeAutore != null)
            {
                codiceSala = Integer.parseInt(fp.readLine());
                codiceOpera = Integer.parseInt(fp.readLine());
                tipologia = fp.readLine();
                stima = Float.parseFloat(fp.readLine());
                
                if(!tipologia.equals("statue"))
                {
                    for(Sala s : listaSale)
                    {
                        if(codiceSala == s.getCodiceSala())
                        {
                            s.aggiungiOpera(new Opera(nomeAutore, codiceSala, codiceOpera, tipologia, stima));
                            break;
                        }
                    }
                }
                nomeAutore = fp.readLine();
            }
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("File non trovato.");
            System.exit(-1);
        }
        catch (IOException e) 
        {
            System.out.println("Errore di I/O.");
            System.exit(-2);
        }
    }
    
    public synchronized void creaReport()
    {
        tipologiaOperaPiuPresente = "";
        int max = 0, tmp;
        
        for(Sala s : listaSale)
        {
            
        }
    }
    
    public synchronized void stampaReport()
    {
        System.out.println("La tipologia di opera piu' presente al museo e': " + tipologiaOperaPiuPresente);
    } 
}
