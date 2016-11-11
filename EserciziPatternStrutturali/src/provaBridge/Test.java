package provaBridge;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Test extends JFrame {
	JPanel p;
	TextArea t;
	JButton plsFileSystem;
	JButton plsDropBox;
	TextFile file;

	public Test() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(500, 220));
		p.setLayout(null);
		setContentPane(p);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		t = new TextArea();
		t.setBounds(10, 10, 300, 200);
		p.add(t);

		plsDropBox = new JButton("salva su dropbox");
		plsDropBox.setBounds(320, 40, 150, 20);
		plsDropBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				file = new TextFile(new DropBox());
				file.setContent(t.getText());
				file.saveFile();
				JOptionPane.showMessageDialog(p, "Fatto!");
			}
		});
		p.add(plsDropBox);

		plsFileSystem = new JButton("salva localmente");
		plsFileSystem.setBounds(320, 10, 150, 20);
		plsFileSystem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				file = new TextFile(new FileSystem());
				file.setContent(t.getText());
				file.saveFile();
				JOptionPane.showMessageDialog(p, "Fatto!");
			}
		});

		p.add(plsFileSystem);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Test t = new Test();
	}
}
