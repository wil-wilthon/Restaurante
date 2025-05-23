/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package restaurante.panes;

import restaurante.rules.Login;
import restaurante.rules.Permissoes;
import restaurante.personalizacao.Personalizacoes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form AppPainel
     */
    public LoginPanel() {
        initComponents();
        personalizarInterface();
        userInput.setText("Digite seu usuário");
        userInput.setForeground(Color.GRAY); // Deixa o placeholder cinza
        passwordInput.setText("Digite sua senha");
        passwordInput.setForeground(Color.GRAY);
        passwordInput.setEchoChar((char) 0); // Remove a máscara para exibir o placeholder

        // Adiciona o KeyListener ao painel para capturar a tecla Enter
        passwordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                // Verifica se a tecla pressionada é a tecla Enter
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    // Aciona o clique do botão de login
                    loginButton.doClick();
                }
            }
        });
        focus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userInput = new javax.swing.JTextField();
        UserLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        LoginLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordInput = new javax.swing.JPasswordField();

        userInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userInputKeyTyped(evt);
            }
        });

        UserLabel.setText("Usuário:");

        PasswordLabel.setText("Senha:");

        LoginLabel.setText("Login");

        loginButton.setText("Entrar");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });

        passwordInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordInputKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PasswordLabel)
                            .addComponent(UserLabel)
                            .addComponent(userInput)
                            .addComponent(passwordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(loginButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(LoginLabel)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LoginLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(loginButton)
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // Captura as entradas de usuário e senha
        String login = userInput.getText();
        String senha = new String(passwordInput.getPassword()); // Pega a senha corretamente
        Login loginManager = new Login();
        String usuario = loginManager.autenticar(login, senha);

        // Tenta autenticar o usuário
        if (usuario != null) {
            // Carrega as permissões do usuário
            List<Permissoes> permissoes = loginManager.getPermissoes(login, senha);
            // Exibe o painel StartPanel de acordo com as permissões
            StartPanel startPanel = new StartPanel(permissoes, usuario);
            JFrame startFrame = new JFrame("Início");
            startFrame.setSize(400, 300);
            startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startFrame.setLocationRelativeTo(null);
            startFrame.add(startPanel);
            startFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza o JFrame
            startFrame.setUndecorated(true);

            // Cria uma barra de título personalizada
            JPanel titleBar = Personalizacoes.criarBarraDeTituloPadrao(startFrame);

            // Usa um JRootPane para simular uma barra de título customizada
            JRootPane rootPane = startFrame.getRootPane();
            rootPane.setWindowDecorationStyle(JRootPane.NONE); // Remove a decoração padrão

            // Cria um painel principal e adiciona a barra de título customizada
            JPanel contentPane = new JPanel(new BorderLayout());
            contentPane.add(titleBar, BorderLayout.NORTH);
            contentPane.add(new StartPanel(permissoes, usuario), BorderLayout.CENTER);
            startFrame.setContentPane(contentPane);

            // Altera o ícone da janela (coloque o ícone na pasta resources ou no mesmo diretório)
            startFrame.setIconImage(new ImageIcon("/images/icon.png").getImage());

            startFrame.setVisible(true);
            JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            loginFrame.dispose();
        } else {
            //Falha de login:
            Personalizacoes mensagem = new Personalizacoes();
            mensagem.menssagemErro(this, "Falha no login: Usuário ou senha inválidos!", "Erro de Autenticação",240,50);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyPressed

    }//GEN-LAST:event_loginButtonKeyPressed

    private void userInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userInputKeyTyped
        Personalizacoes.placeHolderText(userInput, "Digite seu usuário");
    }//GEN-LAST:event_userInputKeyTyped

    private void passwordInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordInputKeyTyped
        Personalizacoes.placeHolderPassword(passwordInput, "Digite sua senha");
    }//GEN-LAST:event_passwordInputKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JTextField userInput;
    // End of variables declaration//GEN-END:variables

    private void personalizarInterface() {
        // Cores temáticas de restaurante
        Color secondaryColor = new Color(255, 243, 224); // Creme claro

        // Personaliza os labels
        Personalizacoes.personalizarLabes(LoginLabel, 32, true);

        Personalizacoes.personalizarLabes(UserLabel, 16, false);

        Personalizacoes.personalizarLabes(PasswordLabel, 16, false);

        // Personaliza os campos de entrada
        Personalizacoes.personalizarCampos(userInput, 14, null, null);
        Personalizacoes.personalizarCampos(passwordInput, 14, null, null);

        // Personaliza o botão
        Personalizacoes.personalizarBotao(loginButton, 16, true, null, null);

        // Fundo do painel
        setBackground(secondaryColor);
    }

    private void focus() {
        SwingUtilities.invokeLater(() -> {
            loginButton.setFocusable(false); // Impede que o botão pegue o foco
            userInput.requestFocus();
            userInput.setFocusable(true);
        });
    }
}
