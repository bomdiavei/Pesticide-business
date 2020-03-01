package entidade;
import java.io.Serializable;

public class Inseticida extends DefensivoAgrícola implements Serializable{    
    private boolean seletivo;
    private String inseto;
    public Inseticida(String nome,float concentração,ClasseToxicológica classe_toxicológica,float preço,Formulação formulação,
            boolean seletivo,String inseto){
        super(nome,concentração,classe_toxicológica,preço,formulação);
        this.seletivo=seletivo;
        this.inseto=inseto;
    }
    public boolean getSeletivo(){
        return seletivo;
    }
    public String getInseto(){
        return inseto;
    }
    public String toStringSeletivo(){
        if(seletivo) return "sim";
        return "não";
    }
    public String toString(){
        return super.toString()+"\nSeletivo: "+toStringSeletivo()+"\nInseto: "+inseto;
    }
}
