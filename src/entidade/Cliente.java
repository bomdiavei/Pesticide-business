package entidade;
import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{    
    private static ArrayList<Cliente> listaCliente = new ArrayList();
    
    String nome,CPF,CNPJ,email;
    Endereço endereço;
    
    public Cliente(String nome,String CPF,String CNPJ,String email, Endereço endereço){
        this.nome=nome;
        this.CPF=CPF;
        this.CNPJ=CNPJ;
        this.email=email;
        this.endereço=endereço;
    }
    public String getNome(){
        return nome;
    }
    public String getCPF(){
        return CPF;
    }
    public String getCNPJ(){
        return CNPJ;
    }
    public String getEmail(){
        return email;
    }
    public Endereço getEndereço(){
        return endereço;
    }
    public static ArrayList<Cliente> get(){
        return listaCliente;
    }
    public static void set(ArrayList<Cliente> listaCliente){
        Cliente.listaCliente = (ArrayList<Cliente>) listaCliente.clone();
    }
    public static void add(Cliente novoCliente){
        listaCliente.add(novoCliente);
    }
    public String toString(){
        String dados = "Nome: "+nome+"\nCPF: "+CPF;
        if(CNPJ!=null)dados+="\nCNPJ: "+CNPJ;
        return dados+="\nE-mail: "+email+"\n-Endereço-\n"+endereço.toString()+"\n";
    }
}