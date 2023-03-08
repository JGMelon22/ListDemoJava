package com.melon.maven_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(238, 238, 238));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(129, 61, 156));
		layeredPane.setBackground(new Color(153, 193, 241));
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);

		JTextArea textArea1 = new JTextArea();
		textArea1.setEnabled(false);
		textArea1.setForeground(new Color(129, 61, 156));

		JButton btnNewButton = new JButton("Query Now!");
		btnNewButton.setBackground(new Color(87, 227, 137));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Invocando thread para fazer query
				Thread t1 = new Thread(() -> {
					DataContext.DataQuery();
				});
				
				t1.setPriority(5);
				t1.start();
				
				DataContext dataContext = new DataContext();
				textArea1.setText(dataContext.DataQuery().toString());
				textArea1.setEnabled(false);
			}
		});

		btnNewButton.setBounds(12, 231, 117, 25);
		layeredPane.add(btnNewButton);

		JButton btnClear = new JButton("Clear");
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
