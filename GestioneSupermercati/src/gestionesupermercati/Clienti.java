/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionesupermercati;
import java.util.*;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class Clienti 
{
    private List<Cliente> listaClienti;
    private String ClienteSpesaMax2020;
    
    public Clienti()
    {
        listaClienti = new LinkedList<Cliente>();
    }
    
    public void stampaTutto()
    {
        for(Cliente c : listaClienti)
        {
            System.out.println(c.toString());
        }
    }
    
    public int eliminaAcquistiClienti(float importo)
    {
        int cont = 0;
        for(Cliente c : listaClienti)
        {
            cont += c.eliminaAcquisti(importo);
        }
        return cont;
    }
    
    public void stampaClientiMerceNonConsegnata(String data, float importo)
    {
        float importoTot = 0.0F;
        for(Cliente c: listaClienti)
        {
            importoTot = c.getImportoTotaleDaConsegnare(data);
            if(importoTot > importo)
            {
                System.out.println(c.getNome());
            }
        }
    }
    
    public void creaReport()
    {
        ClienteSpesaMax2020 = "";
        float max = -1, tmp; 
        for(Cliente c : listaClienti)
        {
            tmp = c.getSpesaTotale2020();
            if(tmp > max)
            {
                max = tmp;
                ClienteSpesaMax2020 = c.getNome();
            }
        }
    }
    
    public void stampaReport()
    {
        System.out.println("Il cliente che ha speso di piu' nel 2020 e': " + ClienteSpesaMax2020);
    }
    
    public void caricaClienti(String nomeFile)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String idCliente;
            String nomeCliente;
            String indirizzoCliente;
            
            idCliente = fp.readLine();
            while(idCliente != null)
            {
                nomeCliente = fp.readLine();
                indirizzoCliente = fp.readLine();
                listaClienti.add(new Cliente(idCliente, nomeCliente, indirizzoCliente));
                idCliente = fp.readLine();
            }
            fp.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.\n");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.\n");
            System.exit(-2);
        }
    }
    
    public void caricaAcquisti(String nomeFile, String data)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String idCliente;
            String descrizioneAcquisto;
            String idScontrinoFiscale;
            float importo;
            String dataAcquisto;
            boolean merceConsegnata;

            idCliente = fp.readLine();
            
            while(idCliente != null)
            {
                descrizioneAcquisto = fp.readLine();
                idScontrinoFiscale = fp.readLine();
                importo = Float.parseFloat(fp.readLine());
                dataAcquisto = fp.readLine();
                merceConsegnata = Boolean.parseBoolean(fp.readLine());
                
                for(Cliente c: listaClienti)
                {
                    if((c.getID().equals(idCliente)) && (dataAcquisto.compareTo(data)>0))
                    {
                        c.inserisciAcquisto(new Acquisto(descrizioneAcquisto, idScontrinoFiscale, importo, dataAcquisto, merceConsegnata));
                        break;
                    }
                }
                
                idCliente = fp.readLine();
            }
            fp.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.\n");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.\n");
            System.exit(-2);
        }
    }
}
