package view;

import java.awt.Font;
import java.time.format.TextStyle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.exception.BitShowException;
import model.vo.Usuario;

public class TelaCadastro extends Painel {
	private JTextField textFTelefone;
	private JTextField textFEMail;
	private JTextField textFSenha;
	private JTextField textFRepetSenha;
	private JTextField textFUsuario;
	private JButton btnCadastrar;
	private JButton btnTrocarParaLogin;
	private Usuario user = new Usuario();

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnTrocarParaLogin() {
		return btnTrocarParaLogin;
	}

	/**
	 * Create the panel.
	 */
	public TelaCadastro() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:max(138dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(22dlu;default)"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));

		JLabel lblTitulo = new JLabel("Criar Uma Nova Conta");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblTitulo, "3, 3");

		JLabel lblUsuario = new JLabel("Usuario :");
		add(lblUsuario, "3, 5");

		textFUsuario = new JTextField();
		textFUsuario.setColumns(20);
		add(textFUsuario, "3, 7");

		JLabel lblEmail = new JLabel("E-mail :");
		add(lblEmail, "3, 9");

		textFEMail = new JTextField();
		textFEMail.setColumns(20);
		add(textFEMail, "3, 11");
				
						JLabel lblTelefone = new JLabel("Nome :");
						add(lblTelefone, "3, 13");
		
				textFTelefone = new JTextField();
				add(textFTelefone, "3, 15");
				textFTelefone.setColumns(20);

		JLabel lblSenha = new JLabel("Senha :");
		add(lblSenha, "3, 17");

		textFSenha = new JTextField();
		textFSenha.setColumns(20);
		add(textFSenha, "3, 19");

		JLabel lblRepSenha = new JLabel("Comfirmar Senha :");
		add(lblRepSenha, "3, 21");

		textFRepetSenha = new JTextField();
		textFRepetSenha.setColumns(20);
		add(textFRepetSenha, "3, 23");

		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "3, 27");

		btnTrocarParaLogin = new JButton("Ja Tenho Uma Conta");
		add(btnTrocarParaLogin, "3, 29");

	}

	@Override
	public void atualizarCampos() {
		// TODO Auto-generated method stub

	}

	public Usuario resgatarUser() throws BitShowException {

			
		
		user.setUsuario(textFUsuario.getText());
		user.setEmail(textFEMail.getText());
		user.setTelefone(textFTelefone.getText());
		user.setSenha(textFSenha.getText());
		validarCampos();

		return user;
	}

	public void validarCampos() throws BitShowException {

		String alerta = "";
		if (user.getUsuario() == null || user.getUsuario().trim().isEmpty()) {
			alerta += "Insira um Usuario\n";
		}
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			alerta += "Insira um E-mail\n";
		}
		if (user.getTelefone() == null || user.getTelefone().trim().isEmpty()) {
			alerta += "Insira um Telefone\n";
		}
		if (user.getSenha() == null || user.getSenha().trim().isEmpty()) {
			alerta += "Insira uma Senha\n";
		}
		if (textFRepetSenha.getText().trim().isEmpty()) {
			alerta += "Comfirme a Senha\n";
		}
		if (!textFRepetSenha.getText().equals(user.getSenha())) {
			alerta += "Senhas inseridas não Coincidem";
		}

		if (!alerta.isEmpty()) {
			alerta = "Causa : \n" + alerta;
			throw new BitShowException(alerta);
		}

	}

}
