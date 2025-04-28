package restaurante.rules;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L; // Para compatibilidade de versões
    private int id;
    private String nome;
    private String login;
    private String senha;
    private List<Permissoes> permissoes;

    public Usuario(int id, String nome, String login, String senha, List<Permissoes> permissoes) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.permissoes = permissoes;
    }
    
    public Usuario(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public int getID(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public List<Permissoes> getPermissoes() {
        return permissoes;
    }

    @Override
    public String toString() {
        return "Usuário: " + nome + ", Login: " + login + ", Permissões: " + permissoes;
    }
}
