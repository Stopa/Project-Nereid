package fiveinarow.gui;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import fiveinarow.Configuration;
import fiveinarow.engine.Engine;

public class TitleWindow extends JFrame {
	private JPanel TitlePanel;
	
	
	public TitleWindow() {
		this.setSize(100,110);
		this.setResizable(false);
		this.setTitle("Five in a row!");
		
		this.setupPanel();
		this.setupButtons();
	}
	
	private void setupPanel() {
		TitlePanel = new JPanel();
		
		TitlePanel.setLayout(new BoxLayout(TitlePanel, BoxLayout.Y_AXIS));
		
		this.add(TitlePanel);
	};
	
	private void setupButtons() {
		JButton StartGameButton = new JButton("Uus mäng");
		StartGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		StartGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.startNewGame(); //mängu alustamise nupp - paneme selle akna kinni ja teeme mänguakna lahti
			}
		});
		TitlePanel.add(StartGameButton);
		
		JButton SettingsButton = new JButton("Sätted");
		SettingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		SettingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.showSettingsWindow(); //sätete nupp - teeme selle akna mitteaktiivseks ja avame sätete akna
			}
		});
		TitlePanel.add(SettingsButton);
		
		JButton AboutGameButton = new JButton("Mängust");
		AboutGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		AboutGameButton.addActionListener(new ActionListener(){ //mängi informatsiooni popup
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                null,
                Configuration.READ_ME_CONTENT,
                "Loe mind",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });
		TitlePanel.add(AboutGameButton);
	};
	
}
