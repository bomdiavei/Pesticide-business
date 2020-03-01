package entidade;
import java.io.Serializable;

public class Herbicida extends DefensivoAgrícola implements Serializable{
    public enum Aplicação{PP,PRE,POS};
    
    private Aplicação aplicação;
    private String erva_daninha;
    
    public Herbicida(String nome,float concentração,ClasseToxicológica classe_toxicológica,float preço,Formulação formulação,
            Aplicação aplicação,String erva_daninha){
        super(nome,concentração,classe_toxicológica,preço,formulação);
        this.aplicação=aplicação;
        this.erva_daninha=erva_daninha;
    }
    public Aplicação getAplicação(){
        return aplicação;
    }
    public String getErvaDaninha(){
        return erva_daninha;
    }
    public String toStringAplicação(){
        if(aplicação == Aplicação.PP) return "pré-plantação";
        if(aplicação == Aplicação.PRE) return "pré-emergente";
        if(aplicação == Aplicação.POS) return "pós-emergente";
        return "indefinida";
    }
    public String toString(){
        return super.toString()+"\nAplicação: "+toStringAplicação()+"\nErva daninha: "+erva_daninha;
    }
}
