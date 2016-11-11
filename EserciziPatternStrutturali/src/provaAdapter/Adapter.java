package provaAdapter;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Adapter extends Target {
	JTree t;

	public Adapter(File f) {
		super(f);
	}

	public JTree drawTree() {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode();
		print(doc.getFirstChild(), node);

		t = new JTree(node);

		return t;
	}

	private void print(Node p, DefaultMutableTreeNode n) {
		NodeList c = p.getChildNodes();
		if (p.getNodeType() == Node.ELEMENT_NODE) {
			DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(p.getNodeName());
			n.add(newChild);
			for (int i = 0; i < c.getLength(); i++)
				print(c.item(i), newChild);
		}
	}

}
