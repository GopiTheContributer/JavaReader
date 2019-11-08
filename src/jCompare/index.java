package jCompare;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import javax.swing.*;

public class index {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Reader and comparer");
		frame.setSize(400, 500);
		frame.setLocation(50, 50);
		frame.setVisible(true);

		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int selected = fileChooser.showOpenDialog(frame);

				if (selected == JFileChooser.APPROVE_OPTION) {
					String path = fileChooser.getSelectedFile().getAbsolutePath();
					String[] extension = path.split("\\.");

					if (extension.length > 0) {
						if (extension[1].equalsIgnoreCase("docx")) {
							try {
								FileInputStream fsi = new FileInputStream(path);
								XWPFDocument docxContent = new XWPFDocument(fsi);
								List<XWPFParagraph> a = docxContent.getParagraphs();

								for (XWPFParagraph para : a) {
									System.out.println(para.getText());
								}

								docxContent.close();
							} catch (FileNotFoundException ex) {
								ex.printStackTrace();
							} catch (IOException ioexp) {
								ioexp.printStackTrace();
							}
						} else {
							try {
								File fileContent = new File(path);
								Scanner sc = new Scanner(fileContent);

								while (sc.hasNextLine()) {
									System.out.print(sc.nextLine());
								}
								sc.close();

							} catch (FileNotFoundException ex) {
								System.out.println(ex.getMessage());
								ex.printStackTrace();
							} catch (IOException ez1) {
								ez1.printStackTrace();
							}
						}
					}
				}
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}
