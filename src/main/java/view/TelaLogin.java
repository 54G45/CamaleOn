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
	private JTextField textFUsuario;
	private JTextField textFSenha;

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
		
		JLabel lblUsuario = new JLabel("Usuario :");
		add(lblUsuario, "4, 4");
		
		textFUsuario = new JTextField();
		add(textFUsuario, "8, 4");
		textFUsuario.setColumns(20);
		
		JLabel lblSenha = new JLabel("Senha :");
		add(lblSenha, "4, 6");
		
		textFSenha = new JTextField();
		add(textFSenha, "8, 6");
		textFSenha.setColumns(20);
		
		JButton btnLogin = new JButton("Login");
		add(btnLogin, "8, 8");

	}

}
