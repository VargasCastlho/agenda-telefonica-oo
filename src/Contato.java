import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class Contato {
    private String nome, telefone, endereco, relacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    public Contato(String nome, String telefone, String endereco, String relacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.relacao = relacao;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + ", Telefone: " + telefone + ", Endereço: " + endereco + ", Relação: " + relacao;
    }
}
