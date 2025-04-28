package restaurante.rules;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class UsuarioManager {

    private List<Usuario> usuarios;
    private static final String DIRETORIO = "C:\\Restaurante";
    private final String arquivo = DIRETORIO + "\\usuarios.dat";

    public UsuarioManager() {
        this.usuarios = new ArrayList<>();
        criarDiretorioSeNecessario(); // Cria o diretório se não existir
        carregarUsuarios(); // Carrega os usuários ao iniciar
    }

    // Cria o diretório "C:\Restaurante" se não existir
    public void criarDiretorioSeNecessario() {
        File diretorio = new File(DIRETORIO);
        if (!diretorio.exists()) {
            if (diretorio.mkdirs()) {
                System.out.println("Diretório criado: " + DIRETORIO);
            } else {
                System.err.println("Falha ao criar diretório: " + DIRETORIO);
            }
        }
    }

    // Adiciona um novo usuário à lista
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        salvarUsuarios(); // Salva automaticamente após adicionar
    }

    // Lista todos os usuários
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println(u);
            }
        }
    }

    public List<Usuario> buscarUsuarios(String nomePesquisa, String permissao) {
        List<Usuario> resultado = new ArrayList<>();
        Permissoes permissaoEnum = null;
        switch (permissao) {
            case "Todos" -> {
            }
            case "Administrador Master" ->
                permissaoEnum = Permissoes.MASTER;
            case "Administrativo" ->
                permissaoEnum = Permissoes.ADMINISTRADOR;
            case "Atendimento" ->
                permissaoEnum = Permissoes.ATENDIMENTO;
            case "Cozinha" ->
                permissaoEnum = Permissoes.COZINHA;
            case "Vendas" ->
                permissaoEnum = Permissoes.VENDAS;
            default -> {
            }
        }

        for (Usuario usuario : usuarios) {
            boolean usuarioCorresponde = usuario.getLogin().toLowerCase().contains(nomePesquisa.toLowerCase());
            boolean nomeCorresponde = usuario.getNome().toLowerCase().contains(nomePesquisa.toLowerCase());
            boolean permissaoCorresponde = (permissaoEnum == null || usuario.getPermissoes().contains(permissaoEnum));

            if (permissaoCorresponde) {
                if (usuarioCorresponde || nomeCorresponde) {
                    resultado.add(usuario);
                }
            }
        }

        return resultado;
    }

    public int atribuirID() {
        int proxId = 1;
        for (Usuario u : usuarios) {
            if (u.getID() <= proxId) {
                proxId++;
            } else {
                break;
            }
        }
        return proxId;
    }

    // Salva os usuários no arquivo usando serialização
    public void salvarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os usuários: " + e.getMessage());
        }
    }

    // Carrega os usuários do arquivo, se existir
    public void carregarUsuarios() {
        File file = new File(arquivo);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                usuarios = (List<Usuario>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erro ao carregar os usuários: " + e.getMessage());
            }
        }
    }

    public boolean removerUsuario(Usuario usuario) {
        Usuario usuarioParaRemover = null;
        for (Usuario u : usuarios) {
            if (u.getID() == usuario.getID()) {
                usuarioParaRemover = u;
                break;
            }
        }

        if (usuarioParaRemover != null) {
            usuarios.remove(usuarioParaRemover);
            salvarUsuarios();
            return true;
        }
        return false;
    }

    // Retorna a lista de usuários
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
