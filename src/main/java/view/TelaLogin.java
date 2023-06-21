package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaLogin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:max(34dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("bottom:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		add(lblNewLabel, "4, 4");
		
		textField = new JTextField();
		add(textField, "8, 4");
		textField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Senha :");
		add(lblNewLabel_1, "4, 6");
		
		textField_1 = new JTextField();
		add(textField_1, "8, 6");
		textField_1.setColumns(20);
		
		JButton btnNewButton = new JButton("Login");
		add(btnNewButton, "8, 8");

	}

}
