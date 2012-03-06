package fiveinarow.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import fiveinarow.engine.Engine;
import fiveinarow.Configuration;

public class SettingsWindow extends JFrame {
	private JPanel SettingsPanel;
	private JComboBox p1ColorSelect;
	private JComboBox p2ColorSelect;
	private JComboBox gameSizeSelect;
	
	public SettingsWindow() {
		this.setSize(400,200);
		this.setResizable(false);
		this.setTitle("Five in a row!");
		
		this.setupPanel();
		this.setupButtons();
		
		addWindowListener(new WindowAdapter() { // sulgemisel teeme peaakna aktiivseks
			public void windowClosing(WindowEvent e) {
				Engine.settingsClosed();
			}
		});
	}
	
	private void setupPanel() {
		SettingsPanel = new JPanel();
		
		SettingsPanel.setLayout(new GridLayout(4,2));
		
		this.add(SettingsPanel);
	}
	
	private void setupButtons() {
		JLabel p1ColorText = new JLabel("Esimese mängija värv:");
		SettingsPanel.add(p1ColorText);
		p1ColorSelect = new JComboBox(Configuration.getColorsArray());
		p1ColorSelect.setSelectedItem(Configuration.PLAYER_ONE_COLOR.toString()); //valime hetkel aktiivse värvi
		SettingsPanel.add(p1ColorSelect);
		
		JLabel p2ColorText = new JLabel("Teise mängija värv:");
		SettingsPanel.add(p2ColorText);
		p2ColorSelect = new JComboBox(Configuration.getColorsArray());
		p2ColorSelect.setSelectedItem(Configuration.PLAYER_TWO_COLOR.toString());
		SettingsPanel.add(p2ColorSelect);
		
		JLabel gameSizeText = new JLabel("Mänguvälja suurus:");
		SettingsPanel.add(gameSizeText);
		gameSizeSelect = new JComboBox(Configuration.getGameSizeArray());
		gameSizeSelect.setSelectedItem(Configuration.BOARDSIZE.toString()); //valime hetkel aktiivse suuruse
		SettingsPanel.add(gameSizeSelect);
		
		JButton okayButton = new JButton("OK");
		okayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Engine.saveSettings(); // ok vajutamisel salvestame valitud sätted
			}
		});
		SettingsPanel.add(okayButton);
		
		JButton cancelButton = new JButton("Tagasi");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Engine.closeSettings(); // tagasi vajutamisel paneme akna lihtsalt kinni
			}
		});
		SettingsPanel.add(cancelButton);
	}
	
	//meetodid JComboBox väärtuste saamiseks
	public String getP1Color() {
		return (String)p1ColorSelect.getSelectedItem();
	}
	
	public String getP2Color() {
		return (String)p2ColorSelect.getSelectedItem();
	}
	
	public String getGameSize() {
		return (String)gameSizeSelect.getSelectedItem();
	}
	
}
