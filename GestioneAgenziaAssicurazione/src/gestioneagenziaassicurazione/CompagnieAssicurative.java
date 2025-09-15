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
public class CompagnieAssicurative 
{
    private List<CompagniaAssicurativa> listaCompagnie;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    private String compagniaNumMaxClienti;
    
    public CompagnieAssicurative()
    {
        listaCompagnie = new LinkedList<CompagniaAssicurativa>();
    }
    
    public void stampaTutto()
    {
        for(CompagniaAssicurativa ca: listaCompagnie)
        {
            System.out.println(ca.toString());
        }
    }
    
    public void creaReport()
    {
        compagniaNumMaxClienti = "";
        int tmp, max = -1;
        for(CompagniaAssicurativa ca : listaCompagnie)
        {
            tmp = ca.numClienti();
            if(tmp > max)
            {
                max = tmp;
                compagniaNumMaxClienti = ca.getNomeCompagnia();
            }
        }
    }
    
    public void stampaReport()
    {
        System.out.println("La compagnia con il massimo numero di clienti e': " + compagniaNumMaxClienti);
    }
    
    public float stampaSommaRatePolizzeCliente(String cf, String dataScadenza)
    {
        float somma = 0.0F;
        for(CompagniaAssicurativa ca: listaCompagnie)
        {
            somma += ca.stampaSommaRatePolizze(cf, dataScadenza);
        }
        return somma;
    }
    
    public void caricaCompagnie(String nomeFile)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String nome;
            String indirizzo;
            String nomeReferente;
            
            nome = fp.readLine();
            
            while(nome != null)
            {
                indirizzo = fp.readLine();
                nomeReferente = fp.readLine();
                listaCompagnie.add(new CompagniaAssicurativa(nome, indirizzo, nomeReferente));
                nome = fp.readLine();
            }
            
            fp.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.");
            System.exit(-2);
        }
    }
    
    public void inserisciNuovaPolizza(String nomeCompagnia) throws PolizzaAttivaSullaCompagniaException
    {
        try
        {
            String cf;
            String nome;
            String idPolizza;
            String dataScadenzaPolizza;
            float importoRataPolizza;

            System.out.println("Inserisci i dati del cliente.");
            System.out.print("cf: ");
            cf = tastiera.readLine();
            System.out.print("nome: ");
            nome = tastiera.readLine();
            System.out.print("id polizza: ");
            idPolizza = tastiera.readLine();
            System.out.print("data scadenza polizza: ");
            dataScadenzaPolizza = tastiera.readLine();
            System.out.print("importo rata polizza: ");
            importoRataPolizza = Float.parseFloat(tastiera.readLine());
            
            for (CompagniaAssicurativa ca : listaCompagnie)
            {
                if (ca.getNomeCompagnia().equals(nomeCompagnia))
                {
                    if(!ca.stipulaPolizza(new Cliente(cf, nome, idPolizza, dataScadenzaPolizza, importoRataPolizza)))
                        throw new PolizzaAttivaSullaCompagniaException();
                }
            }
        }
        catch (IOException e) 
        {
            System.out.println("ERRORE DI I/O.");
            System.exit(-1);
        }
    }
    
    public void caricaClienti(String nomeFile)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            
            String nomeCompagnia;
            String cf;
            String nome;
            String idPolizza;
            String dataScadenzaPolizza;
            float importoRataPolizza;
            
            nomeCompagnia = fp.readLine();
            
            while(nomeCompagnia != null)
            {
                cf = fp.readLine();
                nome = fp.readLine();
                idPolizza = fp.readLine();
                dataScadenzaPolizza = fp.readLine();
                importoRataPolizza = Float.parseFloat(fp.readLine());
                
                for(CompagniaAssicurativa ca: listaCompagnie)
                {
                    if(ca.getNomeCompagnia().equals(nomeCompagnia))
                    {
                        ca.aggiungiCliente(new Cliente(cf, nome, idPolizza, dataScadenzaPolizza, importoRataPolizza));
                    }
                }
                nomeCompagnia = fp.readLine();
            }
            fp.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FILE NON TROVATO.");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.");
            System.exit(-2);
        }
    }
}
