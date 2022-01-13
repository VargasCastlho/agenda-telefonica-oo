import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Agenda {
    static ArrayList<Contato> contatos = new ArrayList();

    public Contato buscaContato(String query){
        return contatos.stream().filter((contato)->contato.getNome().contains(query)).findFirst().orElse(null);
    }

    public void alterarContato(String query){
        if(buscaContato(query)==null){
            if(JOptionPane.showConfirmDialog(null, "Contato não existe, deseja criar um novo?")==1) {
                inserirContato();
            }
        }else {
            for(Contato contato : contatos){
                if(contato.getNome().contains(query)){
                    int resp = 0, cont = 0;
                    while(resp!=5){
                        cont++;
                        resp = Integer.parseInt(JOptionPane.showInputDialog("1- Nome 2- Telefone 3-Endereço 4-Relação 5- Sair"));
                        if(resp==1)
                            contato.setNome(JOptionPane.showInputDialog("Digite o novo nome"));
                        else if(resp==2)
                            contato.setTelefone(JOptionPane.showInputDialog("Digite o novo telefone"));
                        else if(resp==3)
                            contato.setEndereco(JOptionPane.showInputDialog("Digite o novo endereço"));
                        else if(resp==4)
                            contato.setRelacao(JOptionPane.showInputDialog("Digite a nova relação"));
                        else if(resp==5 && cont>1)
                            JOptionPane.showMessageDialog(null, "Contato alterado com sucesso!");
                    }
                }
            }
            listarContatos();
        }
    }


    public void inserirContato(){
        String nome = JOptionPane.showInputDialog("Digite o nome do novo contato");

        if(buscaContato(nome)!=null){
            JOptionPane.showMessageDialog(null, "Contato já existe, neste momento sofrerá alteração");
                alterarContato(nome);
        }
        else{
            String telefone = JOptionPane.showInputDialog("Digite o telefone");
            String endereco = JOptionPane.showInputDialog("Digite o endereço");
            String relacao = JOptionPane.showInputDialog("Digite a relação");
            inserirContatoQuery(new Contato(nome, telefone, endereco, relacao));
        }
    }

    public void removerContato(){
        String nome = JOptionPane.showInputDialog("Digite o nome do contato que deseja excluir");

        if(buscaContato(nome) == null){
            JOptionPane.showMessageDialog(null, "Contato não encontrado na agenda");
        }else{
            contatos.remove(contatos.stream().filter((contato)->contato.getNome().contains(nome)).findFirst().orElse(null));
            listarContatos();
        }
    }

    public void listarContatos(){
        contatos.forEach((contato)->{
            System.out.println(contato);
        });
    }

    public void abrirArquivo() throws IOException {
        String nome = JOptionPane.showInputDialog(null, "Entre com o nome do arquivo:");
        BufferedReader br = new BufferedReader(new FileReader(nome));
        String arquivo[] = new String[1000];
        int cont = 0;
        while (br.ready()) {
            arquivo[cont] = br.readLine();
            cont++;
        }
        br.close();
        int qtdCtt = cont/4;
        for(int i = 0; i<qtdCtt;i++){
            String contato[] = new String[1000];
            for(int j = 0; j<4;j++){
                contato[j] = arquivo[i*4+j].substring(arquivo[i*4+j].indexOf(":")+2);
            }
            contatos.add(new Contato(contato[0], contato[1], contato[2], contato[3]));
        }
        listarContatos();
    }

    public void salvarArquivo() throws IOException {

        FileWriter arq = new FileWriter("contatos.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        for(Contato contato : contatos){
            gravarArq.println("Nome: "+contato.getNome());
            gravarArq.println("Telefone: "+contato.getTelefone());
            gravarArq.println("Endereço: "+contato.getEndereco());
            gravarArq.println("Relação: "+contato.getRelacao());
        }
        arq.close();
    }

    private void inserirContatoQuery(Contato contato){
        contatos.add(contato);
        listarContatos();
    }
}
