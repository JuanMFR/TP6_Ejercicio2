package Vistas;

import Funciones.GestionProductos;
import Funciones.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class ConsultaNombreInternalFrame extends JInternalFrame {
    private JTextField txtBuscar;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public ConsultaNombreInternalFrame() {
        super("Consulta por Nombre", true, true, true, true);
        initComponents();
        cargarTodosLosProductos();
    }

    private void initComponents() {
        setSize(700, 500);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Listado por Nombre", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelSuperior.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBusqueda.add(new JLabel("Ingrese Descripción:"));
        txtBuscar = new JTextField(20);

        // Búsqueda dinámica con keyReleased
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarProductos();
            }
        });

        panelBusqueda.add(txtBuscar);
        panelSuperior.add(panelBusqueda, BorderLayout.CENTER);

        add(panelSuperior, BorderLayout.NORTH);

        // Tabla
        String[] columnas = {"Código", "Descripción", "Precio", "Categoría", "Stock"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        // Cargar todos los productos inicialmente
        cargarTodosLosProductos();
    }

    private void buscarProductos() {
        String busqueda = txtBuscar.getText().trim();
        modeloTabla.setRowCount(0); // Limpiar tabla

        List<Producto> productos;
        if (busqueda.isEmpty()) {
            productos = GestionProductos.listarProductos();
        } else {
            productos = GestionProductos.buscarPorNombre(busqueda);
        }

        for (Producto p : productos) {
            Object[] fila = {
                p.getCodigo(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getRubro(),
                p.getStock()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void cargarTodosLosProductos() {
        modeloTabla.setRowCount(0);
        List<Producto> productos = GestionProductos.listarProductos();
        for (Producto p : productos) {
            Object[] fila = {
                p.getCodigo(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getRubro(),
                p.getStock()
            };
            modeloTabla.addRow(fila);
        }
    }
}