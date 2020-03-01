package controle;

import entidade.Cliente;
import entidade.DefensivoAgrícola;
import entidade.Fungicida;
import entidade.Herbicida;
import entidade.Inseticida;
import entidade.Venda;
import entidade.DefensivoAgrícola.Formulação;
import entidade.Herbicida.Aplicação;
import entidade.Fungicida.Atividade;
import interfaces.EntradaSaída;
import util.PersistênciaArquivo;
import util.Data;
import java.util.ArrayList;

public class VendaDefensivosAgrícolas {
    private static final String arquivo = "dados/VendaDefensivosAgricolas.bds";
    
    public static void main(String[] args) {
        recuperarAplicação();           
        imprimirClientes("\n--- Clientes Recuperados do Arquivo ---", Cliente.get());
        System.out.println("\n-------------------------------------");
        imprimirDefensivosAgrícolas("\n--- Defensivos Agrícolas Recuperados do Arquivo ---", DefensivoAgrícola.get());
        System.out.println("\n-------------------------------------");
        imprimirVendas("\n--- Vendas Recuperadas do Arquivo ---", Venda.get());
        System.out.println("\n-------------------------------------");        
        EntradaSaída.Menu();             
        imprimirClientes("\n---- Clientes salvos em Arquivo ----", Cliente.get());    
        System.out.println("\n------------------------------------");
        imprimirDefensivosAgrícolas("\n--- Defensivos salvos em Arquivo ---", DefensivoAgrícola.get());  
        System.out.println("\n------------------------------------");  
        imprimirVendas("\n--- Vendas salvas em Arquivo ---", Venda.get());
        System.out.println("\n-----------------------------------------");
        System.out.println("\n------------------ FIM ------------------");        
        salvarAplicação() ;
    }
    
    public static void salvarAplicação() {
        ArrayList aplicação_listaObject = new ArrayList();
        aplicação_listaObject.add(Cliente.get());
        aplicação_listaObject.add(DefensivoAgrícola.get());
        aplicação_listaObject.add(Venda.get());
        PersistênciaArquivo.salvar(aplicação_listaObject, arquivo);
    }
    public static void recuperarAplicação() {
        ArrayList aplicação_listaObject = (ArrayList) PersistênciaArquivo.recuperar(arquivo);
        if (aplicação_listaObject != null) {
            Cliente.set((ArrayList<Cliente>) aplicação_listaObject.get(0));
            DefensivoAgrícola.set((ArrayList<DefensivoAgrícola>) aplicação_listaObject.get(1));
            Venda.set((ArrayList<Venda>) aplicação_listaObject.get(2));
        }
    }
    public static void inserirDefensivoAgrícola(DefensivoAgrícola novo_defensivo_agrícola){
        if(DefensivoAgrícola.get().contains(novo_defensivo_agrícola)) 
            System.out.println("\nEsse Defensivo Agrícola já está cadastrado.\n");
        else DefensivoAgrícola.add(novo_defensivo_agrícola);
    }
    public static ArrayList<DefensivoAgrícola> filtrarDefensivosAgrícolas(Formulação formulação, Aplicação aplicação_filtro, 
                                                                          char seletivo, Atividade atividade){
        ArrayList<DefensivoAgrícola> selecionados_listaDefensivoAgrícola = new ArrayList();
        for(DefensivoAgrícola itemDefensivoAgrícola : DefensivoAgrícola.get()){
            if((formulação != null) && (formulação != itemDefensivoAgrícola.getFormulação())) continue;
            
            if (itemDefensivoAgrícola instanceof Herbicida) {
                Herbicida itemHerbicida = (Herbicida) itemDefensivoAgrícola;
                if ((aplicação_filtro != null) && (itemHerbicida.getAplicação() != aplicação_filtro)) continue;
            }
            if (itemDefensivoAgrícola instanceof Inseticida) {
                Inseticida itemInseticida = (Inseticida) itemDefensivoAgrícola;
                if ((seletivo == 'S') && (!itemInseticida.getSeletivo())) continue;
                if ((seletivo == 'N') && (itemInseticida.getSeletivo())) continue;
                if ((seletivo == 's') && (!itemInseticida.getSeletivo())) continue;
                if ((seletivo == 'n') && (itemInseticida.getSeletivo())) continue;
            }
            if (itemDefensivoAgrícola instanceof Fungicida) {
                Fungicida itemFungicida = (Fungicida) itemDefensivoAgrícola;
                if ((atividade != null) && (itemFungicida.getAtividade() != atividade)) continue;
            }
            selecionados_listaDefensivoAgrícola.add(itemDefensivoAgrícola);
        }
        return selecionados_listaDefensivoAgrícola;
    }
    public static void imprimirDefensivosAgrícolas(String cabeçalho,ArrayList<DefensivoAgrícola> listaDefensivoAgrícola){
        if (listaDefensivoAgrícola.isEmpty()) return;
        System.out.println(cabeçalho);
        for (Object itemDefensivoAgrícola : listaDefensivoAgrícola) 
            System.out.println(itemDefensivoAgrícola.toString());        
    }
    public static void inserirCliente(Cliente novo_cliente){
        if(Cliente.get().contains(novo_cliente)) System.out.println("\nEsse cliente já está cadastrado.\n");
        else Cliente.add(novo_cliente);
    }
    public static ArrayList<Cliente> filtrarClientes(String cidade_filtro){
        ArrayList<Cliente> selecionados_listaCliente = new ArrayList();
        for(Cliente itemCliente : Cliente.get()){
            if((cidade_filtro != null) && (!itemCliente.getEndereço().getCidade().equals(cidade_filtro))) continue;
            selecionados_listaCliente.add(itemCliente);
        }
        return selecionados_listaCliente;
    }
    public static void imprimirClientes(String cabeçalho,ArrayList<Cliente> listaCliente){
        if (listaCliente.isEmpty()) return;
        System.out.println(cabeçalho);
        for (Object itemCliente : listaCliente) System.out.println(itemCliente.toString());        
    }
    public static void inserirVenda(String cpf_cliente, String nome_defensivo_agrícola,
                                    Data data_venda, boolean entrega_rápida){  
        Cliente cliente_venda = null;
        DefensivoAgrícola defensivo_agrícola_venda = null;
        for(int i=0; i<Cliente.get().size(); i++)
            if( Cliente.get().get(i).getCPF().equals(cpf_cliente) ) 
                cliente_venda = Cliente.get().get(i);
        for(int i=0;i<DefensivoAgrícola.get().size();i++)
            if( DefensivoAgrícola.get().get(i).getNome().equals(nome_defensivo_agrícola))
                defensivo_agrícola_venda = DefensivoAgrícola.get().get(i);
        if(cliente_venda == null){
            System.out.println("\n#ERRO: cliente não cadastrado.\n");
        }
        else if(defensivo_agrícola_venda == null){
            System.out.println("\n#ERRO: defensivo agrícola não cadastrado.\n");
        }        
        else if(data_venda.getAno() > 2018)
            System.out.println("\n#ERRO: ano inválido.\n");     
        else if(data_venda.getMês() > 12)
            System.out.println("\n#ERRO: mês inválido.\n");     
        else if(data_venda.getDia() > 31)
            System.out.println("\n#ERRO: dia inválido.\n");        
        else Venda.add(new Venda (cliente_venda,defensivo_agrícola_venda,data_venda,entrega_rápida));
    }
    public static ArrayList<Venda> filtrarVendas(Data data_mínima){
        ArrayList<Venda> selecionados_listaVenda = new ArrayList();
        for(Venda itemVenda : Venda.get()){
            if((data_mínima != null) && (itemVenda.getData().compareTo(data_mínima) == -1)) continue;
            selecionados_listaVenda.add(itemVenda);
        }
        return selecionados_listaVenda;
    }
    public static void imprimirVendas(String cabeçalho,ArrayList<Venda> listaVenda){
        if (listaVenda.isEmpty()) return;
        System.out.println(cabeçalho);
        for (Object itemVenda : listaVenda) {
            System.out.println("----------------- VENDA -----------------");
            System.out.println(itemVenda.toString());   
            System.out.println("-----------------------------------------");
        }
    }
}