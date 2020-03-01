package entidade;
import java.io.Serializable;

public class Fungicida extends DefensivoAgrícola implements Serializable{    
    public enum Atividade{MS,E};
    private Atividade atividade;
    private String doença;
    
    public Fungicida(String nome,float concentração,ClasseToxicológica classe_toxicológica,float preço,
            Formulação formulação,Atividade atividade,String doença){
        super(nome,concentração,classe_toxicológica,preço,formulação);
        this.atividade=atividade;
        this.doença=doença;
    }
    public Atividade getAtividade(){
        return atividade;
    }
    public String getDoença(){
        return doença;
    }
    private String toStringAtividade(){
        if(atividade == Atividade.E) return "sítio específico";
        if(atividade == Atividade.MS) return "multi-sítio";
        return "indefinido";
    }
    public String toString(){
        return super.toString()+"\nAtividade: "+toStringAtividade()+"\nDoença: "+doença;
    }
}
