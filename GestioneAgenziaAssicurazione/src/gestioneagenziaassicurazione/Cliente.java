/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneagenziaassicurazione;

/**
 *
 * @author Venerando
 */
public class Cliente 
{
    private String cf;
    private String nome;
    private String idPolizza;
    private String dataScadenzaPolizza;
    private float importoRataPolizza;
    
    public Cliente(String cf, String nome, String idPolizza, String dataScadenzaPolizza, float importoRataPolizza)
    {
        this.cf = cf;
        this.nome = nome;
        this.idPolizza = idPolizza;
        this.dataScadenzaPolizza = dataScadenzaPolizza;
        this.importoRataPolizza = importoRataPolizza;
    }
    
    public float getImportoRataPolizza()
    {
        return importoRataPolizza;
    }
    
    public String getDataScadenza()
    {
        return dataScadenzaPolizza;
    }
    
    public String getCFCliente()
    {
        return cf;
    }
    
    public String toString()
    {
        return ("[" + cf + ", " + nome + ", " + idPolizza + ", " + dataScadenzaPolizza + ", " + importoRataPolizza + "]\n");
    }
}
