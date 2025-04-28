package restaurante.rules;

import java.io.*;
import java.util.List;

public class Login {
    private static final String DIRETORIO = "C:\\Restaurante";
    private final String arquivo = DIRETORIO+"\\usuarios.dat";
    private List<Usuario> usuarios;

    public Login() {
        carregarUsuarios();
    }

    // Carrega os usuários do arquivo
    private void carregarUsuarios() {
        File file = new File(arquivo);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                usuarios = (List<Usuario>) ois.readObject();
                System.out.println("Usuários carregados para autenticação.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erro ao carregar os usuários: " + e.getMessage());
            }
        }
    }

    // Método para autenticar o usuário
    // Método para autenticar e retornar o nome do usuário
    public String autenticar(String login, String senha) {
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return null;
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                System.out.println("Usuário autenticado: " + usuario.getNome());
                return usuario.getNome(); // Retorna o nome do usuário autenticado
            }
        }

        System.out.println("Falha na autenticação: Credenciais inválidas.");
        return null; // Retorna null se o login falhar
    }
    
    // Método para retornar as permissões do usuário autenticado
    public List<Permissoes> getPermissoes(String login, String senha) {
        if (usuarios == null || usuarios.isEmpty()) {
            return null;
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario.getPermissoes(); // Retorna as permissões do usuário autenticado
            }
        }
        return null;
    }
}
