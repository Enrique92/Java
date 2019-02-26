package com.interfaces.tresenraya.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.interfaces.tresenraya.controlador.Controlador;

@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Jugar");
	private JMenuItem iniciar = new JMenuItem("Iniciar ");
	private JMenuItem guardar = new JMenuItem("Guardar Partida");
	private JMenuItem cargar = new JMenuItem("Cargar Partida");
	private JMenuItem finalizar = new JMenuItem("Finalizar");

	private JMenu menuHelp = new JMenu("Ayuda");
	private JMenuItem acercade = new JMenuItem("Acerca de");
	
	// Ventana donde se carga o guarda el fichero
    private JPanel fichero_partida;
    // Url del destino del fichero
    private JTextArea url;
    // Cargar o guardar la partida
    private JButton accion;
	
	private Controlador controlador;
	private PanelJuego panel;
	
	public Menu(Controlador controlador) {
		this.controlador = controlador;
		panel = new PanelJuego(controlador);
		añadirComponentes();
	}
	
	public void añadirComponentes() {
		this.setLayout(new BorderLayout());
		this.add(menuBar);
		/* Menu deplegable*/
		menuBar.add(menu);
		menu.add(iniciar);
		menu.add(guardar);
		menu.add(cargar);
		menu.add(finalizar);
		//-------------------------
		menuBar.add(menuHelp);
		menuHelp.add(acercade);
		
		guardar.setEnabled(false);
		finalizar.setEnabled(false);
		
		iniciar.addActionListener(this);
		guardar.addActionListener(this);
		cargar.addActionListener(this);
		finalizar.addActionListener(this);
		acercade.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == iniciar) {
			panel.limpiarTablero();
			panel.desbloquearTablero();
			guardar.setEnabled(true);
			finalizar.setEnabled(true);
			cargar.setEnabled(false);
			iniciar.setEnabled(false);
		} else if (e.getSource() == guardar) {
			guardarPartida();
		} else if (e.getSource() == cargar) {
			cargarPartida();
		} else if (e.getSource() == finalizar) {
			iniciar.setEnabled(true);
			guardar.setEnabled(false);
			cargar.setEnabled(false);
			panel.bloquearTablero();
			JOptionPane.showMessageDialog(this, "¡La patida se ha finalizado", "PARTIDA FINALIZADA", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == acercade) {
			JOptionPane.showMessageDialog(this, controlador.mostrarAyudaTXT(), "Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	/** GUARDA EL FICHERO DE TEXTO DE COMO SE UTILIZA EN EL 3 EN RAYA */
	public void guardarPartida() {
		try {
			// Creamos el objeto JFileChooser
			JFileChooser file = new JFileChooser();
			// Creamos el filtro
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
			// Le indicamos el filtro
			file.setFileFilter(filtro);
			// Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			file.showSaveDialog(this);
		    // Seleccionamos el fichero
			File guarda = file.getSelectedFile();
			if (guarda != null) {
				/* Guardamos el archivo en formato txt que es el permitido */
				FileWriter save = new FileWriter(guarda + ".txt");
				save.write(url.getText());
				controlador.guardarPartida();
//				save.write(controlador.guardarPartida());
				save.close();
				JOptionPane.showMessageDialog(null, "El archivo se a guardado exitosamente", "CORRECTO!!!", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/** ABRE EL FICHERO DE TEXTO DE COMO SE UTILIZA EN EL 3 EN RAYA */
	public String cargarPartida() {
		String aux = "";
		String texto = "";
		try {
			// Creamos el objeto JFileChooser
			JFileChooser file = new JFileChooser();
			// Indicamos lo que podemos seleccionar
			file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			// Creamos el filtro
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
			// Le indicamos el filtro
			file.setFileFilter(filtro);
			// Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			file.showOpenDialog(this);
		    //Seleccionamos el fichero
			File abre = file.getSelectedFile();
			// recorremos el archivo, lo leemos para plasmarlo en el area de texto
			if (abre != null) {
				FileReader archivos = new FileReader(abre);
				BufferedReader lee = new BufferedReader(archivos);
				while ((aux = lee.readLine()) != null) {
					texto += aux + "\n";
					
				}
				lee.close();
				JOptionPane.showMessageDialog(null, "\nPartida cargada correctamente", "CORRECTO!!!", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "\nNo se ha encontrado el archivo", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
		}
		return texto;// El texto se almacena en el JTextArea
	}

//	@Override
//	public String turnoJugador() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean cambiarJugador() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public int turnoInicial() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public boolean comprobarGanardor() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void desbloquearCasillas() {
//		panel.desbloquearTablero();
//	}
//
//	@Override
//	public void bloquearCasillas() {
//		panel.bloquearTablero();
//	}
}
