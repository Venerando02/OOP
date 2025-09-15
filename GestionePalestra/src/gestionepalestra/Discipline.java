/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionepalestra;

import java.util.*;
import java.io.*;

/**
 *
 * @author Venerando
 */
public class Discipline {

    private List<Disciplina> listaDiscipline;
    BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
    private String disciplinaMaxRicavo;

    public Discipline()
    {
        listaDiscipline = new LinkedList<Disciplina>();
    }

    public void stampaTutto() 
    {
        for (Disciplina d : listaDiscipline) 
        {
            System.out.println(d.toString());
        }
    }

    public void caricaDiscipline(String nomeFile) 
    {
        try 
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));
            String nome;
            String responsabile;
            int capienzaMax;
            float tariffa;

            nome = fp.readLine();

            while (nome != null) 
            {
                responsabile = fp.readLine();
                capienzaMax = Integer.parseInt(fp.readLine());
                tariffa = Float.parseFloat(fp.readLine());

                listaDiscipline.add(new Disciplina(nome, responsabile, capienzaMax, tariffa));
                nome = fp.readLine();
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

    public void eliminaIscritto(String cf) throws PersonaNonEsistenteException
    {
        // boolean flag = true;
        float perdita = 0.0F;
        for(Disciplina d: listaDiscipline)
        {
            if(d.eliminaIscritto(cf))
            {
                // flag = true;
                perdita += d.getTariffa();
            }
        }
        
        if(perdita == 0) // if(flag == false)
        {
            throw new PersonaNonEsistenteException();
        }
    }
    
    public void caricaIscritti(String nomeFile, String dataSoglia)
    {
        try 
        {
            BufferedReader fp = new BufferedReader(new FileReader(nomeFile));

            String nome;
            String cf;
            String dataFineAbbonamento;
            String nomeDisciplina;
            
            nome = fp.readLine();
            
            while (nome != null) 
            {
                cf = fp.readLine();
                dataFineAbbonamento = fp.readLine();
                nomeDisciplina = fp.readLine();
                
                if((dataFineAbbonamento.compareTo(dataSoglia) > 0))
                {
                    for(Disciplina d : listaDiscipline)
                    {
                        if(nomeDisciplina.equals(d.getNome()))
                        {
                            d.inserisciIscritto(new Iscritto(nome, cf, dataFineAbbonamento));
                            break;
                        }
                    }
                }
                
                nome = fp.readLine();
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
    
    public void disciplinaMaggioreRicavo()
    {
        float max = 0.0F, tmp;
        disciplinaMaxRicavo = "";
        for(Disciplina d: listaDiscipline)
        {
            tmp = d.calcoloRicavo();
            if(tmp > max)
            {
                max = tmp;
                disciplinaMaxRicavo = d.getNome();
            }
        }
    }
    
    public void stampaReport()
    {
        System.out.println("La disciplina col il max Guadagno e': " + disciplinaMaxRicavo);
    }
    
    public void inserisciIscritto() throws CapienzaMaxException
    {
        try
        {
            String nome;
            String cf;
            String dataFineAbbonamento;
            String nomeDisciplina;
            
            System.out.print("Nome: ");
            nome = tastiera.readLine();
            System.out.print("cf: ");
            cf = tastiera.readLine();
            System.out.print("data fine abbonamento: ");
            dataFineAbbonamento = tastiera.readLine();
            
            System.out.print("Inserisci il nome disciplina(invio per finire): ");
            nomeDisciplina = tastiera.readLine();
            
            while(nomeDisciplina != null)
            {
                for(Disciplina d: listaDiscipline)
                {
                    if(nomeDisciplina.equals(nomeDisciplina))
                    {
                        d.inserisciIscritto(new Iscritto(nome, cf, dataFineAbbonamento));
                        if(d.isFull())
                            throw new CapienzaMaxException();
                        break;
                    }
                }
                System.out.print("Inserisci il nome disciplina(invio per finire): ");
                nomeDisciplina = tastiera.readLine();
            }

        }
        catch(IOException e)
        {
            System.out.println("ERRORE DI I/O.\n");
            System.exit(-1);
        }
    }
    
}
