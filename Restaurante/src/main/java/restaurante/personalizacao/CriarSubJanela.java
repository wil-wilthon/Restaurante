/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.personalizacao;

import java.awt.BorderLayout;
import restaurante.rules.Logout;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author User
 */
public class CriarSubJanela {

    private static JFrame subJanela = null;
    private static int sizeWidth;
    private static int sizeHeight;

    private static void criaSubMenu() {
        subJanela = new JFrame();
        subJanela.setSize(sizeWidth, sizeHeight);
        subJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha só a subjanela
        subJanela.setUndecorated(true);
        subJanela.getContentPane().setBackground(new Color(255, 240, 220));
    }

    private static void criaJanela(String texto) {
        subJanela = new JFrame();
        subJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no X
        subJanela.setSize(sizeWidth, sizeHeight);
        subJanela.setLocationRelativeTo(null);            // Centraliza na tela
        subJanela.setResizable(false);            // Impede o redimensionamento
        subJanela.setUndecorated(true);

        // Cria uma barra de título personalizada
        JPanel titleBar = Personalizacoes.criarBarraDeTituloSubJanela(texto, subJanela);

        // Usa um JRootPane para simular uma barra de título customizada
        JRootPane rootPane = subJanela.getRootPane();
        rootPane.setWindowDecorationStyle(JRootPane.NONE); // Remove a decoração padrão

        // Cria um painel principal e adiciona a barra de título customizada
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(titleBar, BorderLayout.NORTH);
        subJanela.setContentPane(contentPane);
    }

    public static void subMenuLougout(JButton usuarioButton, JFrame jFrameAtual) {
        if (subJanela != null && subJanela.isVisible()) {
            subJanela.dispose(); // Fecha a subjanela se já estiver aberta
            subJanela = null;    // Limpa a referência
            return;              // Sai do método
        }

        // Cria a subjanela
        CriarSubJanela.sizeWidth = 80;
        CriarSubJanela.sizeHeight = 100;
        criaSubMenu();

        // Calcula a posição abaixo do botão que acionou
        int x = usuarioButton.getLocationOnScreen().x + usuarioButton.getWidth() - sizeWidth;  // Posição X do botão na tela
        int y = usuarioButton.getLocationOnScreen().y + usuarioButton.getHeight(); // Posição abaixo do botão
        subJanela.setLocation(x, y);

        // Cria o botão de logout
        JButton logoutButton = new JButton("Sair");
        Personalizacoes.personalizarBotao(logoutButton, 16, false, null, null);
        logoutButton.addActionListener(e -> {
            subJanela.dispose(); // Fecha a subjanela
            Logout.logout(jFrameAtual);
        });

        // Adiciona o botão na subjanela
        subJanela.add(logoutButton);
        subJanela.setVisible(true);
    }

    public static void subJanelaPadrao(JPanel jpanel, int sizeWidth, int sizeHeight) {
        if (subJanela != null && subJanela.isVisible()) {
            subJanela.dispose(); // Fecha a subjanela se já estiver aberta
            subJanela = null;    // Limpa a referência
            return;              // Sai do método
        }

        CriarSubJanela.sizeWidth = sizeWidth;
        CriarSubJanela.sizeHeight = sizeHeight;
        criaJanela("Cadastro de Usuário");
        //subJanela.setBounds(1,1,2,2);

        subJanela.add(jpanel);
        subJanela.setVisible(true);
    }
}
