/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class App {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login"); 
        // Adiciona o JPanel personalizado ao JFrame
        frame.add(new LoginPanel());
        // Configurações básicas da janela
        frame.setSize(390, 350);        // Tamanho do JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no X
        frame.setLocationRelativeTo(null);            // Centraliza na tela
        frame.setResizable(false);            // Impede o redimensionamento
        frame.setUndecorated(true); 
        
        // Cria uma barra de título personalizada
        JPanel titleBar = Personalizacoes.criarBarraDeTituloLogin();

        // Usa um JRootPane para simular uma barra de título customizada
        JRootPane rootPane = frame.getRootPane();
        rootPane.setWindowDecorationStyle(JRootPane.NONE); // Remove a decoração padrão

        // Cria um painel principal e adiciona a barra de título customizada
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(titleBar, BorderLayout.NORTH);
        contentPane.add(new LoginPanel(), BorderLayout.CENTER);
        frame.setContentPane(contentPane);
        
        // Altera o ícone da janela (coloque o ícone na pasta resources ou no mesmo diretório)
        //frame.setIconImage(new ImageIcon("/images/icon.png").getImage());

        
        frame.setVisible(true);         // Torna a janela visível
    }
}
