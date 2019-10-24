package fr.ut2j.m1ice.ci.tpmaven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXBusyLabel;


/** 
 * @author Thomas COLETTE.
 */

/**
 * JXBusyLabelTest - Génère une fenêtre contenant un Busy Label customisable grâce à des combobox
 * et des boutons.
 */
public class JXBusyLabelTest extends JFrame implements ActionListener {

	/**
	 * Le JXBusyLabel de l'application.
	 */
    JXBusyLabel bLabel1;
    
    /**
     * Les deux JComboBox permettant de changer la couleur de background et foreground.
     */
	JComboBox comboBackground, comboForeground;
	
	/**
	 * Les deux JButton permettant de démarrer et de stopper l'animation du JXBusyLabel.
	 */
	JButton btnStart, btnStop;
	
	/**
	 * Le tableau de couleurs qui sont utilisées par les JComboBox.
	 */
	Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.YELLOW};

	/**
	 * Constructeur de la classe JXBusyLabelTest.
	 */
	public JXBusyLabelTest() {
		bLabel1 = new JXBusyLabel(new Dimension(60, 60));
		bLabel1.setBusy(true);

		String[] colorsName = {"Choose a color", "BLACK", "WHITE", "RED", "BLUE", "GREEN", "GRAY", "YELLOW"};
		comboBackground = new JComboBox(colorsName);
		comboForeground = new JComboBox(colorsName);
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");

		comboBackground.addActionListener(this);
		comboForeground.addActionListener(this);
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);

		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		panelSouth.add(new JLabel("Background"));
		panelSouth.add(comboBackground);
		panelSouth.add(new JLabel("Foreground"));
		panelSouth.add(comboForeground);
		panelNorth.add(btnStart);
		panelNorth.add(btnStop);

		add(panelNorth, BorderLayout.NORTH);
		add(bLabel1, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		setSize(400, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * @param e L'ActionEvent envoyé par les combobox et les boutons
	 * 
	 * Cette méthode traite les événements d'action sur les comboboxx et les boutons et change le comportement
	 * du busylabel en fonction.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBackground) {
			bLabel1.getBusyPainter().setBaseColor(colors[comboBackground.getSelectedIndex() - 1]);
		} else if (e.getSource() == comboForeground) {
			bLabel1.getBusyPainter().setHighlightColor(colors[comboForeground.getSelectedIndex() - 1]);
		} else if (e.getSource() == btnStart) {
			bLabel1.setBusy(true);
		} else if (e.getSource() == btnStop) {
			bLabel1.setBusy(false);
		}
	}

	/**
	 * Fonction principale de l'application.
	 * 
	 * @param args Les arguments de la fonction main.
	 */
	public static void main(String[] args) {
		new JXBusyLabelTest();
	}

}
