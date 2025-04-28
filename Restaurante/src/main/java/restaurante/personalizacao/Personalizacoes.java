/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.personalizacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class Personalizacoes {

    private static final Color primaryColor = new Color(150, 40, 27); // Vermelho terroso
    private static final Color secondaryColor = new Color(255, 243, 224); // Creme claro

    public void menssagemErro(JPanel jpanelAtual, String texto, String titulo, int width, int height){
         //Falha de login:
            JPanel panel = new JPanel();
            panel.setBackground(new Color(255, 243, 224)); // Fundo creme claro
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaçamento interno
            panel.setPreferredSize(new Dimension(width, height)); // Define o tamanho fixo (Largura, Altura)

            JLabel label = new JLabel(texto);
            label.setFont(new Font("SansSerif", Font.BOLD, 11)); // Fonte personalizada
            label.setForeground(new Color(150, 40, 27)); // Cor vermelha temática

            panel.add(label); // Adiciona o texto ao painel

            // Personaliza os botões do JOptionPane
            UIManager.put("OptionPane.background", new Color(255, 243, 224));
            UIManager.put("Panel.background", new Color(255, 243, 224));
            UIManager.put("Button.background", new Color(150, 40, 27));
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.font", new Font("SansSerif", Font.BOLD, 14));

            // Exibe o JOptionPane estilizado
            JOptionPane.showMessageDialog(jpanelAtual, panel, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    public void menssagemConfirma(JPanel jpanelAtual, String texto, String titulo, int width, int height){
         //Falha de login:
            JPanel panel = new JPanel();
            panel.setBackground(new Color(255, 243, 224)); // Fundo creme claro
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaçamento interno
            panel.setPreferredSize(new Dimension(width, height)); // Define o tamanho fixo (Largura, Altura)

            JLabel label = new JLabel(texto);
            label.setFont(new Font("SansSerif", Font.BOLD, 11)); // Fonte personalizada
            label.setForeground(new Color(150, 40, 27)); // Cor vermelha temática

            panel.add(label); // Adiciona o texto ao painel

            // Personaliza os botões do JOptionPane
            UIManager.put("OptionPane.background", new Color(255, 243, 224));
            UIManager.put("Panel.background", new Color(255, 243, 224));
            UIManager.put("Button.background", new Color(150, 40, 27));
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.font", new Font("SansSerif", Font.BOLD, 14));

            // Exibe o JOptionPane estilizado
            JOptionPane.showMessageDialog(jpanelAtual, panel, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static JPanel criarBarraDeTituloLogin() {
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(new Color(150, 40, 27)); // Cor do fundo (vermelho escuro)

        // Título estilizado
        JLabel titleLabel = new JLabel(" "+"Peri SurfBar");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleBar.add(titleLabel, BorderLayout.WEST);

        // Botão de fechar personalizado
        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(new Color(200, 50, 50));
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(50, 30));

        closeButton.addActionListener(e -> System.exit(0)); // Fecha a aplicação

        titleBar.add(closeButton, BorderLayout.EAST);

        return titleBar;
    }

    public static JPanel criarBarraDeTituloPadrao(JFrame frame) {
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(new Color(150, 40, 27)); // Cor do fundo (vermelho escuro)

        // Título estilizado
        JLabel titleLabel = new JLabel(" "+"Peri SurfBar");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleBar.add(titleLabel, BorderLayout.WEST);

        // Painel para organizar os botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        buttonPanel.setOpaque(false); // Fundo transparente

        // Botão Minimizar
        JButton minimizeButton = new JButton("_");
        configurarBotao(minimizeButton, new Color(50, 150, 200));
        minimizeButton.addActionListener(e -> frame.setState(JFrame.ICONIFIED)); // Minimiza a janela

        // Botão Maximizar/Restaurar
        JButton maximizeButton = new JButton("⬜");
        configurarBotao(maximizeButton, new Color(100, 200, 100));
        maximizeButton.addActionListener(e -> {
            if (frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                frame.setExtendedState(JFrame.NORMAL); // Restaura a janela
            } else {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela
            }
        });

        // Botão Fechar
        JButton closeButton = new JButton("X");
        configurarBotao(closeButton, new Color(200, 50, 50));
        closeButton.addActionListener(e -> System.exit(0)); // Fecha a aplicação

        // Adiciona os botões ao painel
        buttonPanel.add(minimizeButton);
        buttonPanel.add(maximizeButton);
        buttonPanel.add(closeButton);

        // Adiciona o painel de botões à barra de título
        titleBar.add(buttonPanel, BorderLayout.EAST);

        return titleBar;
    }

    public static JPanel criarBarraDeTituloSubJanela(String texto) {
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(new Color(150, 40, 27)); // Cor do fundo (vermelho escuro)

        // Título estilizado
        JLabel titleLabel = new JLabel(" "+texto);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleBar.add(titleLabel, BorderLayout.WEST);

        // Painel para organizar os botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        buttonPanel.setOpaque(false); // Fundo transparente

        // Botão Fechar
        JButton closeButton = new JButton("X");
        configurarBotao(closeButton, new Color(200, 50, 50));
        closeButton.addActionListener(e -> System.exit(0)); // Fecha a aplicação

        // Adiciona os botões ao painel
        buttonPanel.add(closeButton);

        // Adiciona o painel de botões à barra de título
        titleBar.add(buttonPanel, BorderLayout.EAST);

        return titleBar;
    }

    // Método auxiliar para configurar a aparência dos botões
    public static void configurarBotao(JButton button, Color bgColor) {
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(50, 30));
    }

    public static void placeHolderText(JTextField campo, String texto) {
        if (campo.getText().equals(texto)) {
            campo.setText("");
            campo.setForeground(Color.BLACK); // Define a cor normal do texto
        } else if (campo.getText().trim().isEmpty()) {
            campo.setText(texto);
            campo.setForeground(Color.GRAY); // Deixa o placeholder cinza
            campo.setCaretPosition(0);
            campo.moveCaretPosition(0);
        }
    }

    public static void placeHolderPassword(JPasswordField campo, String texto) {
        char[] password = campo.getPassword();
        if (String.valueOf(password).equals(texto)) {
            campo.setText(""); // Limpa o campo
            campo.setForeground(Color.BLACK);
            campo.setEchoChar('•'); // Retorna a máscara padrão
        } else if (String.valueOf(password).trim().isEmpty()) {
            campo.setText(texto);
            campo.setForeground(Color.GRAY);
            campo.setEchoChar((char) 0); // Remove a máscara para exibir o placeholder
            campo.setCaretPosition(0);
            campo.moveCaretPosition(0);
        }
    }

    public static void personalizarBotao(JButton button, int fontSize, boolean bordas, Integer sizeWidth, Integer sizeHeight) {
        // Personaliza o botão
        if (sizeWidth != null && sizeHeight != null) {
            button.setSize(sizeWidth, sizeHeight);
        }
        if (bordas) {
            button.setFont(new Font("SansSerif", Font.BOLD, fontSize));
            button.setBackground(Personalizacoes.primaryColor);
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        } else {
            button.setFont(new Font("SansSerif", Font.BOLD, fontSize));
            button.setBackground(null);
            button.setForeground(Personalizacoes.primaryColor);
            button.setFocusPainted(false);
            button.setBorder(null);
        }
    }

    public static void personalizarCampos(JTextField campo, int fontSize, Integer sizeWidth, Integer sizeHeight) {
        // Personaliza os campos de entrada
        campo.setFont(new Font("SansSerif", Font.PLAIN, fontSize));
        if (sizeWidth != null && sizeHeight != null) {
            campo.setSize(sizeWidth, sizeHeight);
        }
    }

    public static void personalizarComboBox(JComboBox comboBox, int fontSize, Integer sizeWidth, Integer sizeHeight) {
        // Personaliza os campos de entrada
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, fontSize));
        comboBox.setBackground(Personalizacoes.primaryColor);
        comboBox.setForeground(Color.WHITE);
        comboBox.setFocusable(false);
        comboBox.setBorder(null);
        if (sizeWidth != null && sizeHeight != null) {
            comboBox.setSize(sizeWidth, sizeHeight);
        }
    }

    public static void personalizarLabes(JLabel label, int fontSize, boolean serif) {
        // Personaliza os labels
        if (!serif) {
            label.setFont(new Font("SansSerif", Font.BOLD, fontSize));
        } else {
            label.setFont(new Font("Serif", Font.BOLD, fontSize));
        }
        label.setForeground(Personalizacoes.primaryColor);
    }

    public static void personalizarCheckBox(JCheckBox jCheckBox, int fontSize) {
        jCheckBox.setFont(new Font("SansSerif", Font.BOLD, fontSize));
        jCheckBox.setForeground(Personalizacoes.primaryColor);
        jCheckBox.setBackground(Personalizacoes.secondaryColor);
    }
}
