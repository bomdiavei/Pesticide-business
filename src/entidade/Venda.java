package entidade;
import java.io.Serializable;
import java.util.ArrayList;

import util.Data;

public class Venda implements Serializable{
    
    private static ArrayList<Venda> listaVenda = new ArrayList(); 
    
    Cliente cliente_venda;
    DefensivoAgrícola defensivo_agrícola_venda;
    Data data_venda;
    boolean entrega_rápida;
    
    public Venda(Cliente cliente_venda,DefensivoAgrícola produto_venda,Data data_venda,
                 boolean entrega_rápida){
        this.cliente_venda=cliente_venda;
        this.defensivo_agrícola_venda=produto_venda;
        this.data_venda=data_venda;
        this.entrega_rápida=entrega_rápida;
    }
    public Cliente getCliente(){
        return cliente_venda;
    }
    public DefensivoAgrícola getDefensivoAgrícola(){
        return defensivo_agrícola_venda;
    }
    public Data getData(){
        return data_venda;
    }
    public boolean isEntregaRápida(){
        return entrega_rápida;
    }
    public static ArrayList<Venda> get(){
        return listaVenda;
    }
    public static void set(ArrayList<Venda> listaVenda){
        Venda.listaVenda = (ArrayList<Venda>) listaVenda.clone();
    }
    public static void add(Venda novaVenda){
        listaVenda.add(novaVenda);
    }
    public String toString(){
        String info="-Cliente-\n"+cliente_venda.toString()+
               "\n-Defensivo Agrícola-\n"+defensivo_agrícola_venda.toString()+
               "\nData da venda: "+data_venda.toString();
        if(entrega_rápida) info+=" - entrega rápida";
        return info+"\n";
    }
}