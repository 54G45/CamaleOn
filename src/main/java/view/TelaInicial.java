package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import com.jgoodies.forms.layout.Sizes;

public class TelaInicial extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaInicial() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(229dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
			new RowSpec[] {
				RowSpec.decode("bottom:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(183dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:default:grow"),}));
		
		table = new JTable();
		add(table, "3, 3, fill, fill");

	}

}
