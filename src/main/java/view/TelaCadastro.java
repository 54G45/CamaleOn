package view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.Sizes;

public class TelaCadastro extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public TelaCadastro() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("Nome de Usuario :");
		add(lblNewLabel, "3, 3");
		
		textField = new JTextField();
		add(textField, "7, 3");
		textField.setColumns(20);
		
		JLabel lblEmail = new JLabel("E-mail :");
		add(lblEmail, "3, 5");
		
		textField_1 = new JTextField();
		textField_1.setColumns(20);
		add(textField_1, "7, 5");
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha :");
		add(lblNewLabel_1_1, "3, 7");
		
		textField_2 = new JTextField();
		textField_2.setColumns(20);
		add(textField_2, "7, 7");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Repet. Senha :");
		add(lblNewLabel_1_1_1, "3, 9");
		
		textField_3 = new JTextField();
		textField_3.setColumns(20);
		add(textField_3, "7, 9");
		
		JButton btnNewButton = new JButton("Cadastrar");
		add(btnNewButton, "7, 11");

	}

}
