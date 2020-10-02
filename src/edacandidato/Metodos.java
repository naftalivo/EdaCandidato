
package edacandidato;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Metodos {
    
    private Candidato candidato;
    private Candidato[] candidatos =  new Candidato[10];
    private int quantidade = 0;
    
    
    public void criarMenu(){
        do{
            
            int op = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opcao: \n"
                + "1 - Adicionar Candidato \n"
                + "2 - Pesquisar Candidato \n"
                + "3 - Ver numero total de Candidatos registados \n"
                + "4 - Remover Candidato \n"
                + "0 - sair")
            );
            
            switch(op){
                case 1: regOpcao(); break;
                case 2: pesquisar(); break;
                case 3: verTotal(); break;
                case 4: remove(); break;
                case 0: System.exit(0); break;
                    default: JOptionPane.showMessageDialog(null, "Opcao invalida!! tente novamente");
            }
            
        }while(true);
     
        
    }
    
    public void regOpcao(){
        do{
            
            int op = Integer.parseInt(JOptionPane.showInputDialog("Registar Candidato: \n"
                + "1 - No fim da lista \n"
                + "2 - Numa posicao dada \n"
                + "0 - cancelar")
            );
            
            switch(op){
                case 1: registar(getQuantidade()); break;
                case 2: pedirPos(); break;
                case 0: criarMenu(); break;
                    default: JOptionPane.showMessageDialog(null, "Opcao invalida!! tente novamente");
            }
            
        }while(true);
    }
    
    public void pedirPos(){
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Introduza a posicao:"));
        
        registar(pos);
        
    }
    
    public void pesquisar(){
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Introduza a posicao para pesquisa:"));
        
        if (verificaTamanho(pos) ==  false){
            JOptionPane.showMessageDialog(null, "Posicao introduzida nao existe! tente novamente");
            pesquisar();
        }
        if (verificaNull(pos) == false){
            JOptionPane.showMessageDialog(null, "Nenhum registo na posicao introduzida");
            criarMenu();
        }
        candidato = candidatos[pos];
        JOptionPane.showMessageDialog(null, candidato);
        
        
    }
    
    public void registar(int pos){
        String sex, nome;
        int numero =  getQuantidade();
        double val;
        
        nome  = JOptionPane.showInputDialog("Introduza o nome do Candidato: ");
        String sexAux  = JOptionPane.showInputDialog("Introduza o sexo do Candidato: \n"
                + " M -  Masculino \n"
                + " F -  Feminino");
                if(sexAux.equalsIgnoreCase("M"))
                    sex = "MASCULINO";
                else
                    sex = "FEMININO";
        //val = Double.parseDouble(JOptionPane.showInputDialog("Introduza o valor a contribuir: "));
        
        candidato = new Candidato(nome, sex, numero);
        add(candidato,pos);
      
    }
    
    public void add(Candidato socio, int pos){
        
        if (verificaTamanho(getQuantidade())){
            duplicaArray();
            
        }
        
        if (verificaNull(pos) == true)
            organizaArray(pos, quantidade);
            
        candidatos[pos] = socio;  
        
        JOptionPane.showMessageDialog(null, "Registado com sucesso");
        quantidade++;
        criarMenu();
        
            
        
    }
    
    public void remove(){
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Introduza a posicao para remover:"));
         
        if (verificaTamanho(pos) ==  false){
            JOptionPane.showMessageDialog(null, "Posicao introduzida nao existe! tente novamente");
            pesquisar();
        }
        if (verificaNull(pos) == false){
            JOptionPane.showMessageDialog(null, "Nenhum registo na posicao introduzida");
            criarMenu();
        }
        
        candidatos[pos] = null;
        organizaArrayDois(pos, quantidade);
        quantidade--;
        
        
    }
    
    public void verTotal(){
         JOptionPane.showMessageDialog(null, "Foram registados "+getQuantidade()+" Candidatos");
        
    }
    
    public boolean verificaTamanho(int pos){
        if(pos <= candidatos.length)
        return true;
        else
        return false;
    }
    
    public void duplicaArray(){
        Candidato [] socioAux = new Candidato[candidatos.length];
        System.arraycopy(candidatos, 0, socioAux, 0, candidatos.length);
        candidatos = new Candidato[2*socioAux.length];
        System.arraycopy(socioAux, 0, candidatos, 0, socioAux.length);
        
    }
    
    public boolean verificaNull(int pos){
        if(candidatos[pos] != null)
            return true;
        else
            return false;
        
    }
    private Candidato socioAux;
    public void organizaArray(int pos, int quant){
      
       if(pos != quant){
            socioAux = candidatos[quant-1];
            candidatos[quant] = socioAux;
            organizaArray(pos,quant-1);
           
       }
     
        
    }
    
    public void organizaArrayDois(int pos, int quant){
      
       if(pos != quant){
            socioAux = candidatos[pos+1];
            candidatos[pos] = socioAux;
            organizaArray(pos+1,quant);
           
       }
     
        
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
    
}
