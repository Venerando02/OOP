/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionebanca;
import java.util.*;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class Clienti 
{
    private List<Cliente> listaClienti;
    private String ClienteConMaggiorAccrediti;
    
    public Clienti()
    {
        listaClienti = new LinkedList<Cliente>();
    }
    
    public void stampaTutto()
    {
        for(Cliente c: listaClienti)
        {
            System.out.println(c.toString());
        }
    }
    
    public void caricaClienti(String nomeFile, int filiale) 
    {
        try 
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            
            String iban;
            int numeroFiliale;
            String nomeIntestatario;
            float saldo;

            iban = fp.readLine();
            while (iban != null) 
            {
                numeroFiliale = Integer.parseInt(fp.readLine());
                nomeIntestatario = fp.readLine();
                saldo = Float.parseFloat(fp.readLine());
                
                if (numeroFiliale == filiale) 
                {
                    listaClienti.add(new Cliente(iban, numeroFiliale, nomeIntestatario, saldo));
                }
                
                iban = fp.readLine();
            }
            fp.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.");
            System.exit(-1);
        } 
        catch (IOException e)
        {
            System.out.println("ERRORE DI I/O.");
            System.exit(-2);
        }
    }
    
    public synchronized void EliminaMovimenti(String iban, String data) throws MovimentiNonEsistentiException
    {
        int cont = 0;
        for(Cliente c: listaClienti)
            cont += c.eliminaMovimento(iban, data);
        if(cont == 0)
            throw new MovimentiNonEsistentiException();
    }
    
    public synchronized void stampaClienti(String data, float importo)
    {
        for(Cliente c : listaClienti)
        {
            c.stampaClienti(data, importo);
        }
    }
    
    public synchronized void creaReport()
    {
        ClienteConMaggiorAccrediti = "";
        int max = 0, tmp;
        for(Cliente c : listaClienti)
        {
            tmp = c.numAccreditiSuperiori5000Euro();
            if(tmp > max)
            {
                max = tmp;
                ClienteConMaggiorAccrediti = c.getNome();
            }
        }
    }
    
    public synchronized void stampaReport()
    {
        System.out.println("Il cliente con il maggior numero di accrediti sopra i 5000 euro e': " + ClienteConMaggiorAccrediti);
    }
    
    public void caricaMovimenti(String nomeFile)
    {
        try 
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
           
            String iban;
            int tipologia;
            String descrizione;
            float importo;
            String data;
            
            iban = fp.readLine();
            
            while (iban != null) 
            {
                tipologia = Integer.parseInt(fp.readLine());
                descrizione = fp.readLine();
                importo = Float.parseFloat(fp.readLine());
                data = fp.readLine();
                
                for(Cliente c : listaClienti)
                {
                    if(c.getIBAN().equals(iban))
                    {
                        c.aggiungiMovimento(new Movimento(iban, tipologia, descrizione, importo, data));
                        break;
                    }
                }
                
                iban = fp.readLine();
            }
            fp.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.");
            System.exit(-1);
        }
        catch (IOException e) {
            System.out.println("ERRORE DI I/O.");
            System.exit(-2);
        }
    }
}
