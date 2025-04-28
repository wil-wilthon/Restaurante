/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante.rules;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Search {

    private static List<Usuario> usuariosEncontrados;
    private static final UsuarioManager usuarioManager = new UsuarioManager();

    public static List<Usuario> getUsuariosEncontrados() {
        return usuariosEncontrados;
    }

    public static void pesquisaTempoRealUsuario(JPanel panelTable, JTextField campo, JComboBox campo2, JTable consulta, String texto) {
        usuarioManager.carregarUsuarios();
        DefaultTableModel models = new DefaultTableModel(null, new String[]{"Selecionar", "Editar", "ID", "Nome", "Login", "Permissões"}) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class; // Checkbox
                }
                if (columnIndex == 1) {
                    return JButton.class; // Botão
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0 || column == 1; // Checkbox e botão são editáveis
            }
        };
        consulta.setModel(models);
        consulta.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
        consulta.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JCheckBox(), consulta));

        consulta.getColumnModel().getColumn(0).setMinWidth(90);
        consulta.getColumnModel().getColumn(0).setPreferredWidth(90);
        consulta.getColumnModel().getColumn(0).setMaxWidth(90);
        consulta.getColumnModel().getColumn(1).setMinWidth(60);
        consulta.getColumnModel().getColumn(1).setPreferredWidth(60);
        consulta.getColumnModel().getColumn(1).setMaxWidth(60);
        consulta.getColumnModel().getColumn(2).setMinWidth(150);
        consulta.getColumnModel().getColumn(2).setPreferredWidth(150);
        consulta.getColumnModel().getColumn(2).setMaxWidth(150);
        consulta.getColumnModel().getColumn(4).setMinWidth(250);
        consulta.getColumnModel().getColumn(4).setPreferredWidth(250);
        consulta.getColumnModel().getColumn(4).setMaxWidth(250);
        consulta.getColumnModel().getColumn(5).setMinWidth(250);
        consulta.getColumnModel().getColumn(5).setPreferredWidth(250);
        consulta.getColumnModel().getColumn(5).setMaxWidth(250);

        DefaultTableModel model = (DefaultTableModel) consulta.getModel();

        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        if (campo.getText().trim().isEmpty() || campo.getText().equals(texto)) {
            panelTable.setVisible(false);
        } else {
            panelTable.setVisible(true);
            usuariosEncontrados = usuarioManager.buscarUsuarios(campo.getText(), campo2.getSelectedItem().toString());
            for (Usuario usuario : usuariosEncontrados) {
                model.addRow(new Object[]{false, "⭮", usuario.getID(), usuario.getNome(), usuario.getLogin(), usuario.getPermissoes()});
            }
        }
    }
}
