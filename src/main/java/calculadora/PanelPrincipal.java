/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author hinda
 */
public class PanelPrincipal extends JPanel implements ActionListener, MouseListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    //private int tipoOperacion;
    private String operador;
    private int numero1, numero2;

    // Constructor
    public PanelPrincipal() {
        initComponents();
       // tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();

        // Si es un botón
        if (o instanceof JButton) {
            if (((JButton) o).getText().equals("1") || ((JButton) o).getText().equals("2") || ((JButton) o).getText().equals("3")
                    || ((JButton) o).getText().equals("4") || ((JButton) o).getText().equals("5") || ((JButton) o).getText().equals("6")
                    || ((JButton) o).getText().equals("7") || ((JButton) o).getText().equals("8") || ((JButton) o).getText().equals("9")) {
                this.areaTexto.setText(this.areaTexto.getText() + ((JButton) o).getText());
            }

            if (((JButton) o).getText().equals("+")) {
                this.numero1 = Integer.parseInt(this.areaTexto.getText());
                this.areaTexto.setText("");
                operador = "+";
                
            }

            if (((JButton) o).getText().equals("-")) {
                this.numero1 = Integer.parseInt(this.areaTexto.getText());
                this.areaTexto.setText("");
                operador = "-";
                
            }
            if (((JButton) o).getText().equals("*")) {
                this.numero1 = Integer.parseInt(this.areaTexto.getText());
                this.areaTexto.setText("");
                operador = "*";
                
            }
            if (((JButton) o).getText().equals("/")) {
                this.numero1 = Integer.parseInt(this.areaTexto.getText());
                this.areaTexto.setText("");
                operador = "/";
                
            }
            if (((JButton) o).getText().equals("=")) {
                this.numero2 = Integer.parseInt(this.areaTexto.getText());
                 switch (operador) {
                    case "+":
                        this.areaTexto.setText(Integer.toString(this.numero1 + this.numero2));
                        break;
                    case "-":
                        this.areaTexto.setText(Integer.toString(this.numero1 - this.numero2));
                        break;
                    case "*":
                        this.areaTexto.setText(Integer.toString(this.numero1 * this.numero2));
                        break;
                    case "/":
                        this.areaTexto.setText(Integer.toString(this.numero1 / this.numero2));
                        break;
                }
            }

             if (((JButton) o).getText().equals("C")) {
                areaTexto.setText("");
            }
             
 
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
