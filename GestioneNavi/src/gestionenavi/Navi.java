/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionenavi;
import java.util.*;
import java.io.*;
/**
 *
 * @author Venerando
 */
public class Navi
{
    private List<Nave> listaNavi;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    private String NaveConPiuPrenotazioni;
    private String NaveConPiuRicavi;
    
    public Navi()
    {
        listaNavi = new LinkedList<Nave>();
    }
    
    public void stampaTutto()
    {
        for(Nave n: listaNavi)
        {
            System.out.println(n.toString());
        }
    }
    
    public void eliminaPrenotazioni(String nomePasseggero, String nomeNave) throws PrenotazioneNonEsistenteException
    {
        int cont = 0;
        for(Nave n: listaNavi)
        {
            cont += n.eliminaPrenotazioni(nomePasseggero, nomeNave);
        }
        if(cont == 0)
            throw new PrenotazioneNonEsistenteException();
    }
    
    public void creaReport()
    {
        NaveConPiuRicavi = "";
        NaveConPiuPrenotazioni = "";
        int maxP = -1, tmpP;
        float maxR = -1.0F, tmpR;
        for(Nave n: listaNavi)
        {
            tmpP = n.getNumeroPrenotazioni();
            tmpR = n.getRicavoTotale();
            
            if(tmpP > maxP)
            {
                maxP = tmpP;
                NaveConPiuPrenotazioni = n.getNomeNave();
            }
            
            if(tmpR > maxR)
            {
                maxR = tmpR;
                NaveConPiuRicavi = n.getNomeNave();
            }
        }
    }
    
    public void stampaReport()
    {
        System.out.println("La nave con piu' ricavi e': " + NaveConPiuRicavi);
        System.out.println("La nave con piu' prenotazioni e': " + NaveConPiuPrenotazioni);
    }
    
    public void salvaSuFilePrenotazioniUtente(String nomePasseggero, String data) throws PrenotazioneNonEsistenteException
    {
        float importoTot = 0.0F;
        for(Nave n : listaNavi)
        {
            importoTot += n.calcolaImportoTotale(nomePasseggero, data);
        }
        if(importoTot == 0.0F)
        {
            throw new PrenotazioneNonEsistenteException();
        }
        else
            System.out.println("L'importo totale e' di: " + importoTot);
    }
    
    public void stampaNaveTratta(String portoPartenza, String portoArrivo)
    {
        for(Nave n: listaNavi)
        {
            n.stampaNaveTrattaDisponibile(portoPartenza, portoArrivo);
        }
    }
    
    public void caricaNavi(String nomeFile)
    {
        try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            
            String nome;
            int stazzaTonnellate;
            int capienzaMax;
            String portoPartenza;
            String portoArrivo;
            
            nome = fp.readLine();
            
            while(nome != null)
            {
                stazzaTonnellate = Integer.parseInt(fp.readLine());
                capienzaMax = Integer.parseInt(fp.readLine());
                portoPartenza = fp.readLine();
                portoArrivo = fp.readLine();
                
                listaNavi.add(new Nave(nome, stazzaTonnellate, capienzaMax, portoPartenza, portoArrivo));
                
                nome = fp.readLine();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("ERRORE SUL FILE.");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.");
            System.exit(-2);
        }
    }
    
    public void caricaPrenotazioni(String nomeFile)
    {
       try
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            
            String nome;
            String nomeNave;
            float costo;
            boolean pagamentoEffettuato;
            String dataViaggio;

            nome = fp.readLine();
            
            while(nome != null)
            {
                nomeNave = fp.readLine();
                costo = Float.parseFloat(fp.readLine());
                pagamentoEffettuato = Boolean.parseBoolean(fp.readLine());
                dataViaggio = fp.readLine();
                
                if(pagamentoEffettuato == true)
                {
                    for(Nave n : listaNavi)
                    {
                        if(n.getNomeNave().equals(nomeNave))
                        {
                            n.aggiungiPrenotazione(new Prenotazione(nome, costo, pagamentoEffettuato, dataViaggio));
                            break;
                        }
                    }
                }
                nome = fp.readLine();
            }
            fp.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("ERRORE SUL FILE.");
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.");
            System.exit(-2);
        } 
    }
}
