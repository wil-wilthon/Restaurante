/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.rules;

import restaurante.personalizacao.Personalizacoes;
import restaurante.panes.LoginPanel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author User
 */
public class Logout {
    public static void logout(JFrame jframe) {
        // Fecha o JFrame atual (StartPanel)
        JFrame currentFrame = jframe;
        if (currentFrame != null) {
            currentFrame.dispose(); // Fecha a janela de início
        }

        // Cria e exibe a janela de login novamente
        JFrame loginFrame = new JFrame("Login");
        loginFrame.add(new LoginPanel());
        loginFrame.setSize(400, 300);                      // Tamanho do JFrame
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no X
        loginFrame.setLocationRelativeTo(null);            // Centraliza na tela
        loginFrame.setResizable(false);            // Impede o redimensionamento
        loginFrame.setUndecorated(true);
        
        // Cria uma barra de título personalizada
        JPanel titleBar = Personalizacoes.criarBarraDeTituloLogin();

        // Usa um JRootPane para simular uma barra de título customizada
        JRootPane rootPane = loginFrame.getRootPane();
        rootPane.setWindowDecorationStyle(JRootPane.NONE); // Remove a decoração padrão

        // Cria um painel principal e adiciona a barra de título customizada
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(titleBar, BorderLayout.NORTH);
        contentPane.add(new LoginPanel(), BorderLayout.CENTER);
        loginFrame.setContentPane(contentPane);
        
        // Altera o ícone da janela (coloque o ícone na pasta resources ou no mesmo diretório)
        loginFrame.setIconImage(new ImageIcon("/images/icon.png").getImage());

        loginFrame.setVisible(true);                       // Torna a janela visível
    }
}
