package Vistas;

import Funciones.GestionProductos;
import Funciones.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GestionProductosInternalFrame extends javax.swing.JInternalFrame {
    private DefaultTableModel modeloTabla;
    private boolean modoEdicion = false;
    private int codigoActual = -1;

    public GestionProductosInternalFrame() {
        initComponents();
        inicializarTabla();
        cargarTabla();
        configurarEventos();
        estadoInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        panelFiltro = new javax.swing.JPanel();
        lblFiltrarPor = new javax.swing.JLabel();
        comboFiltroCategoria = new javax.swing.JComboBox<>();
        scrollPane = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelFormulario = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblRubro = new javax.swing.JLabel();
        comboRubro = new javax.swing.JComboBox<>();
        lblStock = new javax.swing.JLabel();
        spinnerStock = new javax.swing.JSpinner();
        btnCerrar = new javax.swing.JButton();
        panelBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("De todo S.A. - Productos");
        setPreferredSize(new java.awt.Dimension(700, 600));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión de Productos");

        panelFiltro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFiltrarPor.setText("Filtrar por Categoría:");

        comboFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Perfumería", "Comestible", "Limpieza" }));
        comboFiltroCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFiltroCategoriaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelFiltroLayout = new javax.swing.GroupLayout(panelFiltro);
        panelFiltro.setLayout(panelFiltroLayout);
        panelFiltroLayout.setHorizontalGroup(
            panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFiltrarPor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFiltroLayout.setVerticalGroup(
            panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltrarPor)
                    .addComponent(comboFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio", "Categoría", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        panelFormulario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigo.setText("Código:");

        btnBuscar.setText("...");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblDescripcion.setText("Descripción:");

        lblPrecio.setText("Precio:");

        lblRubro.setText("Rubro:");

        comboRubro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perfumería", "Comestible", "Limpieza" }));

        lblStock.setText("Stock:");

        spinnerStock.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblDescripcion)
                            .addComponent(lblPrecio)
                            .addComponent(lblRubro)
                            .addComponent(lblStock))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormularioLayout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRubro)
                    .addComponent(comboRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock)
                    .addComponent(spinnerStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        btnNuevo.setText("Nuevo");
        btnNuevo.setPreferredSize(new java.awt.Dimension(120, 40));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelBotones.add(btnNuevo);

        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelBotones.add(btnGuardar);

        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panelBotones.add(btnActualizar);

        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelBotones.add(btnEliminar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboFiltroCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFiltroCategoriaItemStateChanged
        filtrarPorCategoria();
    }//GEN-LAST:event_comboFiltroCategoriaItemStateChanged

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        cargarProductoSeleccionado();
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tablaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarProductoPorCodigo();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
        habilitarCampos(true);
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        modoEdicion = false;
        txtCodigo.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarProducto();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarProducto();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarProducto();
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> comboFiltroCategoria;
    private javax.swing.JComboBox<String> comboRubro;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFiltrarPor;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRubro;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSpinner spinnerStock;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

    private void inicializarTabla() {
        modeloTabla = (DefaultTableModel) tabla.getModel();

        // Agregar algunos productos de ejemplo
        GestionProductos.agregarProducto(new Producto(1234, "Arroz Gallo", 1250.5, 25, "Comestible"));
        GestionProductos.agregarProducto(new Producto(2351, "Poco Robame", 8999.75, 12, "Perfumería"));
        GestionProductos.agregarProducto(new Producto(3456, "Lavandina Ayudin", 890.0, 30, "Limpieza"));
        GestionProductos.agregarProducto(new Producto(4567, "Ibuprofeno 600", 450.75, 50, "Perfumería"));
        GestionProductos.agregarProducto(new Producto(5678, "Fideos Matarazzo", 980.25, 40, "Comestible"));
        GestionProductos.agregarProducto(new Producto(645645, "Arroz piolin", 1200.0, 15, "Comestible"));
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        List<Producto> productos = GestionProductos.listarProductos();
        for (Producto p : productos) {
            Object[] fila = {
                p.getCodigo(),
                p.getDescripcion(),
                String.format("%.2f", p.getPrecio()),
                p.getRubro(),
                p.getStock()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void filtrarPorCategoria() {
        String categoriaSeleccionada = (String) comboFiltroCategoria.getSelectedItem();
        modeloTabla.setRowCount(0);

        List<Producto> productos = GestionProductos.listarProductos();
        for (Producto p : productos) {
            if (categoriaSeleccionada.equals("Todas") || p.getRubro().equals(categoriaSeleccionada)) {
                Object[] fila = {
                    p.getCodigo(),
                    p.getDescripcion(),
                    String.format("%.2f", p.getPrecio()),
                    p.getRubro(),
                    p.getStock()
                };
                modeloTabla.addRow(fila);
            }
        }
    }

    private void cargarProductoSeleccionado() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            codigoActual = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString());
            txtCodigo.setText(String.valueOf(codigoActual));
            txtDescripcion.setText(tabla.getValueAt(filaSeleccionada, 1).toString());
            txtPrecio.setText(tabla.getValueAt(filaSeleccionada, 2).toString().replace(",", "."));
            comboRubro.setSelectedItem(tabla.getValueAt(filaSeleccionada, 3).toString());
            spinnerStock.setValue(tabla.getValueAt(filaSeleccionada, 4));
            modoEdicion = true;
        }
    }

    private void buscarProductoPorCodigo() {
        try {
            if (txtCodigo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un código para buscar", "Campo vacío", JOptionPane.WARNING_MESSAGE);
                txtCodigo.requestFocus();
                return;
            }

            int codigo = Integer.parseInt(txtCodigo.getText());
            Producto producto = GestionProductos.buscarProducto(codigo);
            if (producto != null) {
                txtDescripcion.setText(producto.getDescripcion());
                txtPrecio.setText(String.valueOf(producto.getPrecio()));
                comboRubro.setSelectedItem(producto.getRubro());
                spinnerStock.setValue(producto.getStock());
                codigoActual = codigo;
                modoEdicion = true;
                btnGuardar.setEnabled(true);
                btnActualizar.setEnabled(true);
                btnEliminar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido", "Error", JOptionPane.ERROR_MESSAGE);
            txtCodigo.requestFocus();
            txtCodigo.selectAll();
        }
    }

    private void guardarProducto() {
        if (!validarCampos()) {
            return;
        }

        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String descripcion = txtDescripcion.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = (Integer) spinnerStock.getValue();
            String rubro = (String) comboRubro.getSelectedItem();

            // Verificar si el código ya existe
            if (GestionProductos.buscarProducto(codigo) != null && !modoEdicion) {
                JOptionPane.showMessageDialog(this, "El código ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                txtCodigo.requestFocus();
                txtCodigo.selectAll();
                return;
            }

            Producto producto = new Producto(codigo, descripcion, precio, stock, rubro);

            if (modoEdicion && codigo == codigoActual) {
                // Actualizar producto existente
                GestionProductos.eliminarProducto(codigo);
                GestionProductos.agregarProducto(producto);
                JOptionPane.showMessageDialog(this, "Producto actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Agregar nuevo producto
                GestionProductos.agregarProducto(producto);
                JOptionPane.showMessageDialog(this, "Producto guardado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }

            cargarTabla();
            limpiarCampos();
            estadoInicial();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato de número inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarProducto() {
        if (!validarCampos()) {
            return;
        }

        if (codigoActual == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para actualizar", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        guardarProducto();
    }

    private void eliminarProducto() {
        if (codigoActual == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar el producto?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            GestionProductos.eliminarProducto(codigoActual);
            cargarTabla();
            limpiarCampos();
            estadoInicial();
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean validarCampos() {
        // Validar código
        if (txtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El código es obligatorio", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            txtCodigo.requestFocus();
            return false;
        }

        // Validar descripción
        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripción es obligatoria", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return false;
        }

        // Validar precio
        if (txtPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El precio es obligatorio", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            txtPrecio.requestFocus();
            return false;
        }

        try {
            double precio = Double.parseDouble(txtPrecio.getText());
            if (precio <= 0) {
                JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0", "Precio inválido", JOptionPane.ERROR_MESSAGE);
                txtPrecio.requestFocus();
                txtPrecio.selectAll();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            txtPrecio.requestFocus();
            txtPrecio.selectAll();
            return false;
        }

        return true;
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        comboRubro.setSelectedIndex(0);
        spinnerStock.setValue(0);
        codigoActual = -1;
        modoEdicion = false;
    }

    private void habilitarCampos(boolean habilitar) {
        txtCodigo.setEnabled(habilitar);
        txtDescripcion.setEnabled(habilitar);
        txtPrecio.setEnabled(habilitar);
        comboRubro.setEnabled(habilitar);
        spinnerStock.setEnabled(habilitar);
    }

    private void estadoInicial() {
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        habilitarCampos(true);
    }

    private void configurarEventos() {
        // FocusLost para validación de precio
        txtPrecio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!txtPrecio.getText().trim().isEmpty()) {
                    try {
                        double precio = Double.parseDouble(txtPrecio.getText());
                        if (precio <= 0) {
                            JOptionPane.showMessageDialog(GestionProductosInternalFrame.this,
                                "El precio debe ser mayor a 0", "Precio inválido", JOptionPane.ERROR_MESSAGE);
                            txtPrecio.requestFocus();
                            txtPrecio.selectAll();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(GestionProductosInternalFrame.this,
                            "Ingrese un precio válido", "Formato inválido", JOptionPane.ERROR_MESSAGE);
                        txtPrecio.requestFocus();
                        txtPrecio.selectAll();
                    }
                }
            }
        });

        // FocusLost para validación de código
        txtCodigo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!txtCodigo.getText().trim().isEmpty()) {
                    try {
                        Integer.parseInt(txtCodigo.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(GestionProductosInternalFrame.this,
                            "Ingrese un código numérico válido", "Formato inválido", JOptionPane.ERROR_MESSAGE);
                        txtCodigo.requestFocus();
                        txtCodigo.selectAll();
                    }
                }
            }
        });
    }
}