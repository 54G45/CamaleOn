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
	private JTextField textFiNome;
	private JTextField textFEMail;
	private JTextField textFSenha;
	private JTextField textFRepetSenha;
	private JTextField textFUsuario;

	/**
	 * Create the panel.
	 */
	public TelaCadastro() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNome = new JLabel("Nome :");
		add(lblNome, "3, 3");
		
		textFiNome = new JTextField();
		add(textFiNome, "7, 3");
		textFiNome.setColumns(20);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		add(lblUsuario, "3, 5");
		
		textFUsuario = new JTextField();
		textFUsuario.setColumns(20);
		add(textFUsuario, "7, 5");
		
		JLabel lblEmail = new JLabel("E-mail :");
		add(lblEmail, "3, 7");
		
		textFEMail = new JTextField();
		textFEMail.setColumns(20);
		add(textFEMail, "7, 7");
		
		JLabel lblSenha = new JLabel("Senha :");
		add(lblSenha, "3, 9");
		
		textFSenha = new JTextField();
		textFSenha.setColumns(20);
		add(textFSenha, "7, 9");
		
		JLabel lblRepSenha = new JLabel("Repet. Senha :");
		add(lblRepSenha, "3, 11");
		
		textFRepetSenha = new JTextField();
		textFRepetSenha.setColumns(20);
		add(textFRepetSenha, "7, 11");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "7, 13");

	}

}
