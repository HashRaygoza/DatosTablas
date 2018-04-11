package mx.hashCode.table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame implements ActionListener {

    private static final long serialVersionUID = 7675022490591504183L;

    private final JTable tabla;
    private final JScrollPane barras;
    private final DefaultTableModel modelo;
    private final JButton boton;
    private final String[] columnas = {"Indice", "Dato"};

    public Tabla() {
        // Inicializamos los elementos de la interfaz
        tabla = new JTable();
        barras = new JScrollPane(tabla);
        modelo = new DefaultTableModel();
        boton = new JButton("Imprimir datos");

        // Ponemos el nombre de las columnas en el modelo
        modelo.setColumnIdentifiers(columnas);
        
        // Establecemos el modelo de la tabla
        tabla.setModel(modelo);

        // Agregamos datos a la tabla
        this.agregarDatos();
        
        // Configuramos la ventana principal
        this.prepararVentana();
        
        // Agregamos elementos a la interfaz
        this.agregarElementos();
        
        // Agregamos el manejador de evento al boton
        boton.addActionListener(this);
    }

    /**
     * Agregamos los elementos a la interfaz grafica
     */
    private void agregarElementos() {
        this.getContentPane().add(barras, BorderLayout.CENTER);
        this.getContentPane().add(boton, BorderLayout.SOUTH);
    }

    /**
     * Configuramos la ventana
     */
    private void prepararVentana() {
        this.setTitle("Datos de tabla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    /**
     * Agreamos datos a la tabla
     */
    private void agregarDatos() {
        for (Integer i = 0; i < 100; i++) {
            String mensaje = i + " UNIDADES";

            // Creamos un nuevo renglon para la tabla
            String[] datos = {i.toString(), mensaje};
            // Agregamos los datos a la tabla
            modelo.addRow(datos);
        }
    }

    /**
     * Manejador del evento del boton, al activarse obtiene un dato de la tabla
     * y lo imprime en la consola
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        // Obtenemos el primer dato del renglon seleccionado
        String codigo = (String) modelo.getValueAt(tabla.getSelectedRow(), 0);
        
        // Lo imprimimos en pantalla
        System.out.println(codigo);
    }

}
