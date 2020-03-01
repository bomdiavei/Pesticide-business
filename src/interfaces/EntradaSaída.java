package interfaces;
import entidade.Cliente;
import entidade.DefensivoAgrícola;
import entidade.Endereço;
import entidade.Fungicida;
import entidade.Herbicida;
import entidade.Inseticida;
import entidade.Venda;
import entidade.DefensivoAgrícola.ClasseToxicológica;
import entidade.DefensivoAgrícola.Formulação;
import entidade.Fungicida.Atividade;
import entidade.Herbicida.Aplicação;
import controle.VendaDefensivosAgrícolas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import util.Data;

public class EntradaSaída {
    public static void Menu(){
        int x = 0, y;
        while(x != 4){
            System.out.println("\n------------ MENU ------------");
            System.out.println("\n1 - CLIENTE");
            System.out.println("\n2 - DEFENSIVO AGRÍCOLA");
            System.out.println("\n3 - VENDA");
            System.out.println("\n4 - SAIR");
            System.out.println("\n------------------------------");
            
            x = lerInteiroPositivo("a opção desejada: ");        
            y = 0;
            
            switch(x){
                case 1:
                    while(y != 4){
                        System.out.println("\n------------ Cliente ------------");
                        System.out.println("\n1 - CADASTRAR");
                        System.out.println("\n2 - IMPRIMIR");
                        System.out.println("\n3 - SELECIONAR");
                        System.out.println("\n4 - VOLTAR AO MENU ANTERIOR");
                        System.out.println("\n---------------------------------");  
                        y = lerInteiroPositivo("a opção desejada: ");                         
                        switch(y){
                            case 1:
                                loopleituraClientes();//cadastrar
                                break;
                            case 2:
                                VendaDefensivosAgrícolas.imprimirClientes("\n--- Clientes Cadastrados ---", Cliente.get()); //imprimir
                                System.out.println("\n----------------------------");
                                break;
                            case 3:
                                VendaDefensivosAgrícolas.imprimirClientes("\n--- Clientes Selecionados ---", selecionarClientes());//selecionar
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("\nOpção Inválida.\n");
                                break;
                        }
                    }
                    break;
                case 2:
                    while(y != 4){
                        System.out.println("\n------------ Defensivo Agrícola ------------");
                        System.out.println("\n1 - CADASTRAR");
                        System.out.println("\n2 - IMPRIMIR");
                        System.out.println("\n3 - SELECIONAR");
                        System.out.println("\n4 - VOLTAR AO MENU ANTERIOR");
                        System.out.println("\n--------------------------------------------");  
                        y = lerInteiroPositivo("a opção desejada: ");                        
                        switch(y){
                            case 1:
                                loopleituraDefensivosAgrícolas();
                                break;
                            case 2:
                                VendaDefensivosAgrícolas.imprimirDefensivosAgrícolas("\n--- Defensivos Agrícolas Cadastrados ---", DefensivoAgrícola.get());   
                                System.out.println("\n----------------------------------------");
                                break;
                            case 3:
                                VendaDefensivosAgrícolas.imprimirDefensivosAgrícolas("\n--- Defensivos Selecionados ---", selecionarDefensivosAgrícolas());
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("\nOpção Inválida.\n");
                                break;
                        }
                    }
                    break;
                case 3:
                    while(y != 4){
                        System.out.println("\n------------ Venda ------------");
                        System.out.println("\n1 - CADASTRAR");
                        System.out.println("\n2 - IMPRIMIR");
                        System.out.println("\n3 - SELECIONAR");
                        System.out.println("\n4 - VOLTAR AO MENU ANTERIOR");
                        System.out.println("\n-------------------------------");  
                        y = lerInteiroPositivo("a opção desejada: ");                        
                        switch(y){
                            case 1:
                                loopleituraVendas();
                                break;
                            case 2:
                                VendaDefensivosAgrícolas.imprimirVendas("\n--- Vendas Cadastradas ---", Venda.get());   
                                System.out.println("\n--------------------------"); 
                                break;
                            case 3:
                                VendaDefensivosAgrícolas.imprimirVendas("\n--- Vendas Selecionadas ---", selecionarVendas());
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("\nOpção Inválida.\n");
                                break;
                        }
                    }       
                    break;
                case 4:  
                    break;
                default:  
                    System.out.println("\nOpção Inválida.\n");
                    break;    
            }
        }        
    }    
    
    public static void loopleituraClientes(){
        System.out.println();
        boolean continuar = true;
        if (!continuar) return;        
        System.out.println("\n--- Leitura de Dados de Clientes ---");
        while (continuar) {
            Cliente informadoCliente = lerCliente();
            if (informadoCliente != null) VendaDefensivosAgrícolas.inserirCliente(informadoCliente);
            else System.out.println(" # Erro na leitura do Cliente\n");
            continuar = lerBoolean("se quer continuar a criar novos clientes");
            if (!continuar) break;
        }        
    }
    public static void loopleituraDefensivosAgrícolas() {
        System.out.println();
        boolean continuar = true;
        if (!continuar) return;        
        System.out.println("\n--- Leitura de Dados de Defensivos Agrícolas ---");
        while (continuar) {
            DefensivoAgrícola informadoDefensivoAgrícola = lerDefensivoAgrícola();
            if (informadoDefensivoAgrícola != null) VendaDefensivosAgrícolas.inserirDefensivoAgrícola(informadoDefensivoAgrícola);
            else System.out.println(" # Erro na leitura do Defensivo Agrícola\n");
            continuar = lerBoolean("se quer continuar a criar novos defensivos agrícolas");
            System.out.println("\n");
            if (!continuar) break;
        }
    }
    public static void loopleituraVendas() {
        System.out.println();
        boolean continuar = true;
        if (!continuar) return;        
        System.out.println("\n--- Leitura de Dados de Vendas ---");
        while (continuar) {
            String informadoCPF = lerString("o CPF do cliente");
            String informadoNomeDefensivoAgrícola = lerString("nome do defensivo agrícola");
            Data informadoData = lerData("a data da venda");
            Boolean informadaEntregaRápida = lerBoolean("se é entrega rápida");
            if(informadoCPF != null && informadoNomeDefensivoAgrícola != null && informadoData != null){
                VendaDefensivosAgrícolas.inserirVenda(informadoCPF,informadoNomeDefensivoAgrícola,informadoData,
                        informadaEntregaRápida);
            }
            else System.out.println(" # Erro na leitura da Venda\n");
            continuar = lerBoolean("se quer continuar a criar novas vendas");
            if (!continuar) break;
        }
    }
    private static Data lerData(String dado){
        String data_string = lerString(dado + "[dd/mm/aaaa]");
        if(data_string == null) return null;
        return Data.toData(data_string);
    }
    private static Cliente lerCliente(){
        String nome = lerString("o nome do cliente");
        if(nome == null) return null;
        String CPF = lerString("o CPF do cliente");
        if(CPF == null) return null;
        String CNPJ = lerString("o CNPJ do cliente");
        if(CNPJ == null) return null;
        String email = lerString("o E-mail do cliente");
        if(email == null) return null;
        Endereço endereço = lerEndereço();
        if(endereço == null) return null;
        return new Cliente(nome,CPF,CNPJ,email,endereço);        
    }
    private static Endereço lerEndereço(){
        String logradouro = lerString("o logradouro");
        if(logradouro == null) return null;
        int número = lerInteiroPositivo("o número");
        if(número < 0) return null;
        String complemento = lerString("o complemento");
        if(complemento == null) return null;
        String bairro = lerString("o bairro");
        if(bairro == null) return null;
        String cidade = lerString("a cidade");
        if(cidade == null) return null;
        String CEP = lerString("o CEP");
        if(CEP == null) return null;        
        return new Endereço(logradouro, número, complemento, bairro, cidade, CEP);        
    }
    private static DefensivoAgrícola lerDefensivoAgrícola() {
        String nome_defensivo_agrícola = lerString("o nome do defensivo agrícola");
        if (nome_defensivo_agrícola == null) return null;
        float concentração = lerFlutuantePositivo("a concentração do defensivo agrícola");
        if (concentração < 0) return null;
        ClasseToxicológica classe_toxicológica = lerClasseToxicológica("a classe toxicológica do defensivo agrícola em número romano");
        if (classe_toxicológica == null) return null;
        float preço = lerFlutuantePositivo("o preço do defensivo agrícola por hectare");
        if(preço < 0) return null;
        Formulação formulação = lerFormulação("a formulação do defensivo agrícola [WG,SC,PM,EC,SL,PS]");
        if(formulação == null) return null;
        
        String tipo_defensivo_agrícola = lerString("o tipo de defensivo [H: Herbicida - F: Fungicida - I: Inseticida]");
        if (tipo_defensivo_agrícola == null) return null;
        
        if (tipo_defensivo_agrícola.toUpperCase().equals("H")) {
            Aplicação aplicação = lerAplicação("a aplicação do herbicida [PP: pré-plantação - PRE: pré-emergente - POS: pós-emergente]");
            if(aplicação == null) return null;
            String erva_daninha = lerString("nome da erva daninha");
            if(erva_daninha == null) return null;            
            return new Herbicida(nome_defensivo_agrícola, concentração, classe_toxicológica, preço, formulação,
                                 aplicação, erva_daninha);
        }
        if (tipo_defensivo_agrícola.toUpperCase().equals("F")) {
            Atividade atividade = lerAtividade("atividade do fungicida [MS: multi-sítio - E: sítio específico]");
            if(atividade == null) return null;
            String doença = lerString("nome da doença que o fungicida combate");
            if(doença == null) return null;            
            return new Fungicida(nome_defensivo_agrícola, concentração, classe_toxicológica, preço, formulação,
                                 atividade, doença);
        }
        if (tipo_defensivo_agrícola.toUpperCase().equals("I")) {
            boolean seletivo = lerBoolean("se é um inseticida seletivo");
            String inseto = lerString("nome do inseto");
            if(inseto == null) return null;
            
            System.out.println("\n");
            
            return new Inseticida(nome_defensivo_agrícola, concentração, classe_toxicológica, preço, formulação,
                            seletivo, inseto);
        }
        return null;
    }
    public static int lerInteiroPositivo(String dado) {
        String inteiro_positivo_string = lerString(dado);
        if (inteiro_positivo_string == null) return -1;
        int inteiro_positivo = 0;
        try {
            inteiro_positivo = Integer.valueOf(inteiro_positivo_string).intValue();
        } catch (NumberFormatException exceção) {
            System.out.println("\n # Erro na conversão para inteiro de: " + dado);
        return -1;
 }
 return inteiro_positivo;
 }
    private static String lerString(String dado) {
        BufferedReader entradaBufferedReader
                       = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        System.out.print(" - Informe " + dado + " : ");
        try {
            string = entradaBufferedReader.readLine();
            if (string.isEmpty()) return null;
        } catch (IOException exceção) {
            System.out.println("\n # Erro na leitura de: " + dado);
            return null;
        }
        return string;
    }
    private static ClasseToxicológica lerClasseToxicológica(String dado){
        String classe_toxicológica_string = lerString(dado);
        if(classe_toxicológica_string == null) return null;
        ClasseToxicológica classe_toxicológica = null;
        try{
            classe_toxicológica = ClasseToxicológica.valueOf(classe_toxicológica_string.toUpperCase());
        } catch (IllegalArgumentException exceção) {
            System.out.println("\n # Erro na conversão para classe toxicológica de: " + dado);
            return null;            
        }
        return classe_toxicológica;
    }
    private static Formulação lerFormulação(String dado){
        String formulação_string = lerString(dado);
        if(formulação_string == null) return null;
        Formulação formulação = null;
        try{
            formulação = Formulação.valueOf(formulação_string.toUpperCase());
        } catch (IllegalArgumentException exceção) {
            System.out.println("\n # Erro na conversão para formulação de: " + dado);
            return null;            
        }
        return formulação;
    }
    private static Aplicação lerAplicação(String dado){
        String aplicação_string = lerString(dado);
        if(aplicação_string == null) return null;
        Aplicação aplicação = null;
        try{
            aplicação = Aplicação.valueOf(aplicação_string.toUpperCase());
        } catch (IllegalArgumentException exceção) {
            System.out.println("\n # Erro na conversão para aplicação de: " + dado);
            return null;            
        }
        return aplicação;        
    }
    private static Atividade lerAtividade(String dado){
        String atividade_string = lerString(dado);
        if(atividade_string == null) return null;
        Atividade atividade = null;
        try{
            atividade = Atividade.valueOf(atividade_string.toUpperCase());
        } catch (IllegalArgumentException exceção) {
            System.out.println("\n # Erro na conversão para atividade de: " + dado);
            return null;            
        }
        return atividade;         
    }
    private static float lerFlutuantePositivo(String dado) {
        String flutuante_positivo_string = lerString(dado);
        if (flutuante_positivo_string == null) return -1.0f;
        float flutuante_positivo = 0;
        try {
            flutuante_positivo = Float.valueOf(flutuante_positivo_string).floatValue();
        } catch (NumberFormatException exceção) {
            System.out.println("\n # Erro na conversão para ponto flutuante de: " + dado);
            return -1.0f;
        }
        return flutuante_positivo;
    }
    private static boolean lerBoolean(String dado) {
        String string_lido = lerString(dado + " [S: sim]");
        if (string_lido == null) return false;
        if (string_lido.toUpperCase().equals("S")) return true;
        return false;
    }
    private static char lerChar(String dado) {
        String string_lido = lerString(dado);
        if ((string_lido == null) || (string_lido.length() > 1)) return 'X';
        return string_lido.charAt(0);
    }
    public static ArrayList<Venda> selecionarVendas() {
        System.out.println();
        boolean continuar = true;
        if (!continuar) return new ArrayList();        
        System.out.println("\n--- Leitura de Filtros de Seleção de Vendas ---");
        Data data_mínima = lerData("a data mínima");
        System.out.println("\n--- Filtros de seleção"
                + "\n Data mínima da venda: " + data_mínima);        
        return VendaDefensivosAgrícolas.filtrarVendas(data_mínima);
    }
    public static ArrayList<DefensivoAgrícola> selecionarDefensivosAgrícolas() {
        System.out.println();
        boolean continuar = true;
        if (!continuar) return new ArrayList();        
        System.out.println("\n--- Leitura de Filtros de Seleção de Defensivos Agrícolas ---");
        Formulação formulação = lerFormulação("a formulação do defensivo agrícola[WG,SC,PM,EC,SL,PS]");
        Aplicação aplicação = lerAplicação("aplicação do herbicida [PP: préplantação - PRE: préemergente - POS: pósemergente]");
        Atividade atividade = lerAtividade("atividade do fungicida [MS: multi-sítio - E: sítio específico]");
        char seletivo = lerChar("se o inseticida é seletivo [S:sim - N:não]");       
        System.out.println("\n--- Filtros de seleção"
                + "\n formulação: " + formulação
                + "\n aplicação: "+ aplicação
                + "\n seletivo: " + seletivo
                + "\n atividade: " + atividade);  
        return VendaDefensivosAgrícolas.filtrarDefensivosAgrícolas(formulação, aplicação, seletivo, atividade);
    }
    public static ArrayList<Cliente> selecionarClientes() {
        System.out.println();
        boolean continuar = true;
        if (!continuar) return new ArrayList();        
        System.out.println("\n--- Leitura de Filtros de Seleção de Clientes ---");
        String cidade = lerString("a cidade");        
        System.out.println("\n--- Filtros de seleção"
                + "\n cidade: " + cidade);        
        return VendaDefensivosAgrícolas.filtrarClientes(cidade);
    }
}