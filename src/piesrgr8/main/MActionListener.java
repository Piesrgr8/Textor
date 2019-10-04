package piesrgr8.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MActionListener implements ActionListener {

	String title = "";
	File f;

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		Main.txt.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				if (cmd.equals("Open"))
					return;

				Main.f.setTitle(title + " (Not Saved)");
				if (f.exists()) {
					BufferedWriter buf;
					try {
						buf = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
						buf.write(Main.txt.getText());
					} catch (IOException e) {
						Main.f.setTitle(title + " (ERROR SAVE)");
						e.printStackTrace();
					}
					Main.f.setTitle(title + " (Saved)");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				if (cmd.equals("Open"))
					return;

				Main.f.setTitle(title + " (Not Saved)");
				if (f.exists()) {
					BufferedWriter buf;
					try {
						buf = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
						buf.write(Main.txt.getText());
					} catch (IOException e) {
						Main.f.setTitle(title + " (ERROR SAVE)");
						e.printStackTrace();
					}
					Main.f.setTitle(title + " (Saved)");
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				if (cmd.equals("New"))
					return;

				Main.f.setTitle(title + " (Not Saved)");
				if (f.exists()) {
					BufferedWriter buf;
					try {
						buf = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
						buf.write(Main.txt.getText());
					} catch (IOException e) {
						Main.f.setTitle(title + " (ERROR SAVE)");
						e.printStackTrace();
					}
					Main.f.setTitle(title + " (Saved)");
				}
			}
		});

		if (cmd.equals("Save")) {
			JFileChooser ch = new JFileChooser();
			int option = ch.showSaveDialog(Main.f);
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					BufferedWriter buf = new BufferedWriter(new FileWriter(ch.getSelectedFile().getAbsoluteFile()));
					buf.write(Main.txt.getText());

					title = ch.getSelectedFile().getName() + " - Textor";
					Main.f.setTitle(ch.getSelectedFile().getName() + " - Textor");

					f = ch.getSelectedFile().getAbsoluteFile();
					buf.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (cmd.equals("Open")) {
			JFileChooser ch = new JFileChooser();
			ch.setFileFilter(new Filter());
			int option = ch.showOpenDialog(Main.f);
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					Scanner sc = new Scanner(ch.getSelectedFile());
					while (sc.hasNext()) {
						String data = sc.nextLine();
						Main.txt.setText(data);
					}

					title = ch.getSelectedFile().getName() + " - Textor";
					Main.f.setTitle(ch.getSelectedFile().getName() + " - Textor");

					f = ch.getSelectedFile().getAbsoluteFile();
					sc.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
