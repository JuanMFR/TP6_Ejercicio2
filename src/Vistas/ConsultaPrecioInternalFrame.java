package Vistas;

import Funciones.GestionProductos;
import Funciones.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class ConsultaPrecioInternalFrame extends JInternalFrame {
    private JTextField txtPrecioMin;
    private JTextField txtPrecioMax;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JLabel lblResultados;

    public ConsultaPrecioInternalFrame() {
        super("Consulta por Precio", true, true, true, true);
        initComponents();
        cargarTodosLosProductos();
    }

    private void initComponents() {
        setSize(700, 500);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTitulo = new JLabel("Listado por Precio", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelSuperior.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelFiltros.add(new JLabel("Entre $"));

        txtPrecioMin = new JTextField(10);
        txtPrecioMin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarPorRangoPrecio();
            }
        });
        panelFiltros.add(txtPrecioMin);

        panelFiltros.add(new JLabel(" Y "));

        txtPrecioMax = new JTextField(10);
        txtPrecioMax.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarPorRangoPrecio();
            }
        });
        panelFiltros.add(txtPrecioMax);

        lblResultados = new JLabel("");
        panelFiltros.add(lblResultados);

        panelSuperior.add(panelFiltros, BorderLayout.CENTER);
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

    private void buscarPorRangoPrecio() {
        String minStr = txtPrecioMin.getText().trim();
        String maxStr = txtPrecioMax.getText().trim();

        modeloTabla.setRowCount(0); // Limpiar tabla

        try {
            double min = minStr.isEmpty() ? 0 : Double.parseDouble(minStr);
            double max = maxStr.isEmpty() ? Double.MAX_VALUE : Double.parseDouble(maxStr);

            if (min > max) {
                lblResultados.setText(" | Rango inválido");
                lblResultados.setForeground(Color.RED);
                return;
            }

            List<Producto> productos = GestionProductos.buscarPorRangoPrecio(min, max);

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

            lblResultados.setText(" | " + productos.size() + " productos encontrados");
            lblResultados.setForeground(Color.BLUE);

        } catch (NumberFormatException e) {
            // Si hay error en el formato, mostrar todos los productos
            cargarTodosLosProductos();
            lblResultados.setText(" | Formato inválido");
            lblResultados.setForeground(Color.RED);
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
        lblResultados.setText(" | Mostrando todos los productos");
        lblResultados.setForeground(Color.BLACK);
    }
}