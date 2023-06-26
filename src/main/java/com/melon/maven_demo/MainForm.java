package com.melon.maven_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class MainForm {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();

		Image img = Toolkit.getDefaultToolkit().getImage("/home/joaog/eclipse-workspace/ListDemoJava/src/icon.png");
		frame.setIconImage(img);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(61, 56, 70));
		frame.setBackground(new Color(61, 56, 70));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(129, 61, 156));
		layeredPane.setBackground(new Color(61, 56, 70));
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);

		JTextArea textArea1 = new JTextArea();
		textArea1.setFont(new Font("Dialog", Font.BOLD, 14));
		textArea1.setEditable(false);
		textArea1.setBackground(new Color(246, 245, 244));
		textArea1.setForeground(new Color(129, 61, 156));
		
		JButton btnNewButton = new JButton("Query Now!");
		btnNewButton.setBackground(new Color(87, 227, 137));
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Waiting cursor depicting a loading thread
				btnNewButton.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				
				// Start thread to query data
				Thread t1 = new Thread(() -> {
					DataContext.DataQuery();
				});


				t1.start();


				textArea1.setText(DataContext.DataQuery().toString());
				textArea1.setEnabled(false);

				// Default cursor
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		btnNewButton.setBounds(12, 231, 117, 25);
		layeredPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		
		btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClear.setBackground(new Color(255, 163, 72));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textArea1.setText("");
				textArea1.setEnabled(false);
			}
		});
		btnClear.setBounds(311, 231, 117, 25);
		layeredPane.add(btnClear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 418, 211);
		layeredPane.add(scrollPane);

		scrollPane.setViewportView(textArea1);
	}
}
