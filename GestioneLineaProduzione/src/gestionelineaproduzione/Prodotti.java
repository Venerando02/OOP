/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelineaproduzione;
import java.util.*;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class Prodotti
{
    private List<Prodotto> listaProdotti;
    private String ProdottoVolumeMassimo;
    
    public Prodotti()
    {
        listaProdotti = new LinkedList<Prodotto>();
    }
    
    public void caricaProdotti(String nomeFile)
    {
        try 
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String id;
            String descrizione;
            float peso;
            float volume;
            
            id = fp.readLine();
            
            while(id != null)
            {
                descrizione = fp.readLine();
                peso = Float.parseFloat(fp.readLine());
                volume = Float.parseFloat(fp.readLine());
                
                listaProdotti.add(new Prodotto(id, descrizione, peso, volume));
                id = fp.readLine();
            }
            
            fp.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("ERRORE SUL FILE.\n");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.\n");
            System.exit(-2);        
        }
    }
    
    public void creaReport()
    {
        ProdottoVolumeMassimo = "";
        float volumeMax = 0.0F, tmp;
        for(Prodotto p: listaProdotti)
        {
            tmp = p.volumeTotale();
            if(tmp > volumeMax)
            {
                volumeMax = tmp;
                ProdottoVolumeMassimo = p.getIdProdotto();
            }
        }
    }
    
    public void stampaReport()
    {
        System.out.println("Il prodotto con il massimo volume e': " + ProdottoVolumeMassimo);
    }
    
    public void resaMaggiorePercentuale()
    {
        float min = Float.MAX_VALUE, tmp;
        String prodottoResaMinore = "";
        for(Prodotto p: listaProdotti)
        {
            tmp = p.resaMaggiorePercentualeProdotto();
            if(tmp < min)
            {
                min = tmp;
                prodottoResaMinore = p.getIdProdotto();
            }
        }
        System.out.println("Il prodotto con la resa maggiore e': " + prodottoResaMinore);
    }
    
    public void EliminaRegistrazioniData(String data) throws DataNonEsistenteException
    {
        int cont = 0;
        for(Prodotto p: listaProdotti)
        {
            cont += p.EliminaRegistrazione(data);
        }
        if(cont == 0)
            throw new DataNonEsistenteException();
    }
    
    public float pesoTotale(String data, String id)
    {
        float peso = 0.0F;
        for(Prodotto p: listaProdotti)
        {
            if(p.getIdProdotto().equals(id))
            {
                peso += p.pesoComplessivo(data);
            }
        }
        return peso;
    }
    
    public void caricaRegistrazioni(String nomeFile, int quantita) 
    {
        try 
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));

            String id;
            String data;
            int quantitaProdotte;
            int numPezziDifettosi;

            id = fp.readLine();

            while (id != null) 
            {
                data = fp.readLine();
                quantitaProdotte = Integer.parseInt(fp.readLine());
                numPezziDifettosi = Integer.parseInt(fp.readLine());

                if (quantitaProdotte > quantita)
                {
                    for (Prodotto p : listaProdotti) 
                    {
                        if (p.getIdProdotto().equals(id))
                        {
                            p.inserisciRegistrazione(new Registrazione(id, data, quantitaProdotte, numPezziDifettosi));
                            break;
                        }
                    }
                }
                id = fp.readLine();
            }
            fp.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("ERRORE SUL FILE.\n");
            System.exit(-1);
        }
        catch (IOException e) 
        {
            System.out.println("ERRORE DI I/O.\n");
            System.exit(-2);
        }
    }
    
    public void stampaTutto()
    {
        for(Prodotto p: listaProdotti)
        {
            System.out.println(p.toString());
        }
    }

}
