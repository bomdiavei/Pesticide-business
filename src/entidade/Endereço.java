package entidade;
import java.io.Serializable;

public class Endereço implements Serializable{
    private String logradouro,complemento,bairro,cidade,CEP;
    private int número;
    
    public Endereço(String logradouro,int número,String complemento,
                    String bairro,String cidade,String CEP){
        this.logradouro=logradouro;
        this.número=número;
        this.complemento=complemento;
        this.bairro=bairro;
        this.cidade=cidade;
        this.CEP=CEP;
    }
    public String getLogradouro(){
        return logradouro;
    }
    public int getNúmero(){
        return número;
    }
    public String getComplemento(){
        return complemento;
    }
    public String getBairro(){
        return bairro;
    }
    public String getCidade(){
        return cidade;
    }
    public String getCEP(){
        return CEP;
    }
    public String toString(){
        String dados=logradouro+", "+número;
        if(complemento!=null) dados+=", "+complemento;
        return dados+="\nBairro: "+bairro+"\nCidade: "+cidade+"\nCEP: "+CEP;
    }
}
