/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante;

import restaurante.rules.Permissoes;
import restaurante.rules.Usuario;
import restaurante.rules.UsuarioManager;
import java.util.List;

/**
 *
 * @author User
 */
public class AddNewUserManual {
    public static void main(String[] args) {
        List<Permissoes> permissoesAdminMaster = List.of(Permissoes.MASTER);
        List<Permissoes> permissoesAdmin = List.of(Permissoes.ADMINISTRADOR);
        List<Permissoes> permissoesAtendente = List.of(Permissoes.ATENDIMENTO);
        List<Permissoes> permissoesVendedor = List.of(Permissoes.VENDAS);
        List<Permissoes> permissoesCozinheiro = List.of(Permissoes.COZINHA);
        
        String nome = "Wilthon Antunes da Silva";
        String user = "Admin";
        String password = "admin";
        UsuarioManager manager = new UsuarioManager();
        Usuario newUsuario = new Usuario(manager.atribuirID(), nome,user,password,permissoesAdminMaster);
        manager.adicionarUsuario(newUsuario);
        
        nome = "Willian Antunes da Silva";
        user = "Will";
        password = "admin";
        newUsuario = new Usuario(manager.atribuirID(), nome,user,password,permissoesAdmin);
        manager.adicionarUsuario(newUsuario);
        
        nome = "Rita de Cassia";
        user = "Rita";
        password = "admin";
        newUsuario = new Usuario(manager.atribuirID(), nome,user,password,permissoesAdmin);
        manager.adicionarUsuario(newUsuario);
        
        nome = "Fulano";
        user = "Ful";
        password = "admin";
        newUsuario = new Usuario(manager.atribuirID(), nome,user,password,permissoesAtendente);
        manager.adicionarUsuario(newUsuario);
        
        nome = "Ciclano";
        user = "Cic";
        password = "admin";
        newUsuario = new Usuario(manager.atribuirID(), nome,user,password,permissoesVendedor);
        manager.adicionarUsuario(newUsuario);
        
        nome = "Beltrano";
        user = "Bel";
        password = "admin";
        newUsuario = new Usuario(manager.atribuirID(), nome,user,password,permissoesCozinheiro);
        manager.adicionarUsuario(newUsuario);
    }
}
