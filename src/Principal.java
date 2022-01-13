import javax.swing.*;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {
        int resp;
        do {
            resp = Integer.parseInt(JOptionPane.showInputDialog("1- Buscar Contato\n2- Inserir Contato\n3- Alterar Contato\n4- Remover Contato\n5- Listar Contatos\n6- Salvar Agenda Telefônica\n7- Recuperar Agenda Telefônica\n8- Encerrar o Programa"));
            Agenda agenda = new Agenda();
            String resposta;
            switch (resp) {
                case 1:
                    resposta = JOptionPane.showInputDialog("Digite o contato a ser buscado");
                    System.out.println(agenda.buscaContato(resposta));
                    break;
                case 2:
                    agenda.inserirContato();
                    break;
                case 3:
                    resposta = JOptionPane.showInputDialog("Digite o contato a ser alterado");
                    agenda.alterarContato(resposta);
                    break;
                case 4:
                    agenda.removerContato();
                    break;
                case 5:
                    agenda.listarContatos();
                    break;
                case 6:
                    agenda.salvarArquivo();
                    break;
                case 7:
                    agenda.abrirArquivo();

            }
        } while (resp != 8);
    }
}
