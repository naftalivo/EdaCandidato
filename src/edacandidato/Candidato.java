
package edacandidato;

/**
 *
 * @author User
 */
public class Candidato {
    private String nome,sexo;
    private double valor;
    private int numero;

    public Candidato(String nome, String sexo, int numero) {
        this.nome = nome;
        this.sexo = sexo;
     
        this.numero = numero;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Numero: "+ numero+"\n"
                + "Nome: "+nome+"\n"
                + "Valor a contribuir: "+valor+" MZN \n";
    }
    
    
    
    
}
