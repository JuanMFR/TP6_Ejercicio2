package Vistas;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author nahuelguerra
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        lblFondo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuAdministracion = new javax.swing.JMenu();
        itemGestionProductos = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        itemConsultaNombre = new javax.swing.JMenuItem();
        itemConsultaPrecio = new javax.swing.JMenuItem();
        itemConsultaRubro = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TP6 De todo S.A.");

        desktopPane.setBackground(new java.awt.Color(240, 240, 250));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        lblFondo.setText("jLabel1");

        desktopPane.setLayer(lblFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuAdministracion.setText("Administración");

        itemGestionProductos.setText("Gestión de Productos");
        itemGestionProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGestionProductosActionPerformed(evt);
            }
        });
        menuAdministracion.add(itemGestionProductos);

        menuBar.add(menuAdministracion);

        menuConsultas.setText("Consultas");

        itemConsultaNombre.setText("Consulta por Nombre");
        itemConsultaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaNombreActionPerformed(evt);
            }
        });
        menuConsultas.add(itemConsultaNombre);

        itemConsultaPrecio.setText("Consulta por Precio");
        itemConsultaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaPrecioActionPerformed(evt);
            }
        });
        menuConsultas.add(itemConsultaPrecio);

        itemConsultaRubro.setText("Consulta por Rubro");
        itemConsultaRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaRubroActionPerformed(evt);
            }
        });
        menuConsultas.add(itemConsultaRubro);

        menuBar.add(menuConsultas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemGestionProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGestionProductosActionPerformed
        abrirGestionProductos();
    }//GEN-LAST:event_itemGestionProductosActionPerformed

    private void itemConsultaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaNombreActionPerformed
        abrirConsultaNombre();
    }//GEN-LAST:event_itemConsultaNombreActionPerformed

    private void itemConsultaPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaPrecioActionPerformed
        abrirConsultaPrecio();
    }//GEN-LAST:event_itemConsultaPrecioActionPerformed

    private void itemConsultaRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaRubroActionPerformed
        abrirConsultaRubro();
    }//GEN-LAST:event_itemConsultaRubroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemConsultaNombre;
    private javax.swing.JMenuItem itemConsultaPrecio;
    private javax.swing.JMenuItem itemConsultaRubro;
    private javax.swing.JMenuItem itemGestionProductos;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConsultas;
    // End of variables declaration//GEN-END:variables

    private void abrirGestionProductos() {
        GestionProductosInternalFrame frame = new GestionProductosInternalFrame();
        desktopPane.add(frame);
        centrarVentanaInterna(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void abrirConsultaNombre() {
        ConsultaNombreInternalFrame frame = new ConsultaNombreInternalFrame();
        desktopPane.add(frame);
        centrarVentanaInterna(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void abrirConsultaPrecio() {
        ConsultaPrecioInternalFrame frame = new ConsultaPrecioInternalFrame();
        desktopPane.add(frame);
        centrarVentanaInterna(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void abrirConsultaRubro() {
        ConsultaRubroInternalFrame frame = new ConsultaRubroInternalFrame();
        desktopPane.add(frame);
        centrarVentanaInterna(frame);
        frame.setVisible(true);
        try {
            frame.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void centrarVentanaInterna(JInternalFrame frame) {
        Dimension desktopSize = desktopPane.getSize();
        Dimension frameSize = frame.getSize();
        int x = (desktopSize.width - frameSize.width) / 2;
        int y = (desktopSize.height - frameSize.height) / 2;
        frame.setLocation(x, y);
    }
    
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}