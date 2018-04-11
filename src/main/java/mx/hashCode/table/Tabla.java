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
    
    private JTable tabla;
    private JScrollPane barras;
    private DefaultTableModel modelo;
    private JButton boton;
    private final String[] columnas = {"Indice", "Dato"};

    public Tabla() {
        tabla = new JTable();
        barras = new JScrollPane(tabla);
        modelo = new DefaultTableModel();
        boton = new JButton("Imprimir datos");

        modelo.setColumnIdentifiers(columnas);
        tabla.setModel(modelo);

        this.agregarDatos();
        this.prepararVentana();
        this.agregarElementos();
    }

    private void agregarElementos() {
		this.getContentPane().add(barras, BorderLayout.CENTER);
        this.getContentPane().add(boton, BorderLayout.SOUTH);
	}

	private void prepararVentana() {
		this.setTitle("Datos de tabla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
	}

    private void agregarDatos(){
        for(Integer i=0; i < 100; i++){
            String mensaje = i + " UNIDADES";

            String[] datos = {i.toString(), mensaje};
            modelo.addRow(datos);
        }
    }

	public void actionPerformed(ActionEvent e) {
		
	}

}