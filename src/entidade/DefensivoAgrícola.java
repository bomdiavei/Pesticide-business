package entidade;
import java.io.Serializable;
import java.util.ArrayList;

public class DefensivoAgrícola implements Serializable{
    public enum ClasseToxicológica{I,II,III,IV};
    public enum Formulação {WG,SC,PM,EC,SL,PS};
    
    private static ArrayList<DefensivoAgrícola> listaDefensivoAgrícola = new ArrayList();
    
    protected String nome;
    protected float concentração;
    protected ClasseToxicológica classe_toxicológica;
    protected float preço;
    protected Formulação formulação;
    
    public DefensivoAgrícola(String nome, float concentração, ClasseToxicológica classe_toxicológica, float preço,Formulação formulação){
        this.nome=nome;
        this.concentração=concentração;
        this.classe_toxicológica=classe_toxicológica;
        this.preço=preço;
        this.formulação=formulação;
    }
    public String getNome(){
        return nome;
    }
    public float getConcentração(){
        return concentração;
    }
    public ClasseToxicológica getClasseToxicológica(){
        return classe_toxicológica;
    }
    public float getPreço(){
        return preço;
    }
    public Formulação getFormulação(){
        return formulação;
    }
    public static ArrayList<DefensivoAgrícola> get(){
        return listaDefensivoAgrícola;
    }
    public static void set(ArrayList<DefensivoAgrícola> listaDefensivoAgrícola){
        DefensivoAgrícola.listaDefensivoAgrícola = (ArrayList<DefensivoAgrícola>) listaDefensivoAgrícola.clone();
    }
    public static void add(DefensivoAgrícola novoCliente){
        listaDefensivoAgrícola.add(novoCliente);
    }
    public String toStringClasseToxicológica(){
        if(classe_toxicológica == ClasseToxicológica.I) return classe_toxicológica+" - altamente tóxico";
        if(classe_toxicológica == ClasseToxicológica.II) return classe_toxicológica+" - tóxico";
        if(classe_toxicológica == ClasseToxicológica.III) return classe_toxicológica+" - medianamente tóxico";
        if(classe_toxicológica == ClasseToxicológica.IV) return classe_toxicológica+" - pouco tóxico";
        return "indefinida";
    }
    public String toStringFormulação(){
        if(formulação == Formulação.WG) return "grânulos dispersíveis";
        if(formulação == Formulação.SC) return "suspensão concentrada";
        if(formulação == Formulação.PM) return "pó molhável";
        if(formulação == Formulação.EC) return "concentrado emulsionável";
        if(formulação == Formulação.SL) return "suspensão líquida";
        if(formulação == Formulação.PS) return "pó solúvel";
        return "indefinida";
    }
    public String toString(){
        return "\nNome: "+nome+"\nConcentração: "+concentração+"%\nClasse toxicológica: "+toStringClasseToxicológica()
                +"\nPreço: "+preço+"R$/ha\nFormulação: "+toStringFormulação();
    }
}
