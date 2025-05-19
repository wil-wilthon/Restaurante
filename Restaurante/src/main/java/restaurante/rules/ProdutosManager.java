/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.rules;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public final class ProdutosManager {
    private List<Produto> produtos;
    private static final String DIRETORIO = "C:\\Restaurante";
    private final String arquivo = DIRETORIO + "\\produtos.dat";
    
    public ProdutosManager(){
        this.produtos = new ArrayList<>();
        criarDiretorioSeNecessario(); // Cria o diretório se não existir
        carregarProdutos(); // Carrega os produtos ao iniciar
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
    
    // Adiciona um novo produto à lista
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        salvarProdutos(); // Salva automaticamente após adicionar
    }

    // Lista todos os produtos
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p: produtos) {
                System.out.println(p);
            }
        }
    }

    public int atribuirID() {
        int proxId = 1;
        for (Produto p : produtos) {
            if (p.getID() <= proxId) {
                proxId++;
            } else {
                break;
            }
        }
        return proxId;
    }

    // Salva os produtos no arquivo usando serialização
    public void salvarProdutos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os produtos: " + e.getMessage());
        }
    }

    // Carrega os produtos do arquivo, se existir
    public void carregarProdutos() {
        File file = new File(arquivo);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                produtos = (List<Produto>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erro ao carregar os usuários: " + e.getMessage());
            }
        }
    }

    public boolean removerProduto(Produto produto) {
        Produto produtoParaRemover = null;
        for (Produto p : produtos) {
            if (p.getID() == produto.getID()) {
                produtoParaRemover = p;
                break;
            }
        }

        if (produtoParaRemover != null) {
            produtos.remove(produtoParaRemover);
            salvarProdutos();
            return true;
        }
        return false;
    }

    // Retorna a lista de produtos
    public List<Produto> getProdutos() {
        return produtos;
    }
    
    /*
    

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
    */
}
