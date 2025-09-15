/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionebanca;
import java.util.*;
/**
 *
 * @author Venerando
 */
public class Cliente 
{
    private String iban; // CHIAVE
    private int numeroFiliale;
    private String nomeIntestatario;
    private float saldo;
    private List<Movimento> listaMovimenti;
    
    public Cliente(String iban, int n, String nI, float s)
    {
        this.iban = iban;
        this.numeroFiliale = n;
        this.nomeIntestatario = nI;
        this.saldo = s;
        listaMovimenti = new LinkedList<Movimento>();
    }
    
    public String toString()
    {
        String cliente = "CLIENTE [" + iban + "; " + numeroFiliale + "; " + nomeIntestatario + "; " + saldo + "] \n";
        for(Movimento m : listaMovimenti)
        {
            cliente += m.toString();
        }
        return cliente;
    }
    
    public String getNome()
    {
        return nomeIntestatario;
    }
    
    public void aggiungiMovimento(Movimento m)
    {
        listaMovimenti.add(m);
    }
    
    public String getIBAN()
    {
        return iban;
    }
    
    public int eliminaMovimento(String iban, String data) 
    {
        int cont = 0;
        for(Movimento m: listaMovimenti)
        {
            if((m.getIban().equals(iban)) && (m.getData().equals(data)))
            {
                this.saldo -= m.getImporto();
                cont++;
            }
        }
        return cont;
    }
    
    public void stampaClienti(String data, float importo)
    {
        float totAddebiti = 0.0F;
        for(Movimento m: listaMovimenti)
        {
            if((m.getTipologia() == 0) && (m.getData().equals(data)))
            {
                totAddebiti += m.getImporto();
            }
        }
        if(totAddebiti > importo)
            System.out.println(nomeIntestatario);
    }
    
    public int numAccreditiSuperiori5000Euro()
    {
        int cont = 0;
        for(Movimento m : listaMovimenti)
        {
            if((m.getTipologia() == 1) && (m.getImporto() > 5000.0F))
                cont++;
        }
        return cont++;
    }
}
