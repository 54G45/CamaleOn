package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.exception.BitShowException;
import model.valida.Valida;
import model.vo.Usuario;

public class TelaCadastro extends Painel {
	private JTextField textFEMail;
	private JTextField textFUsuario;
	private JButton btnCadastrar;
	private JButton btnTrocarParaLogin;
	private Usuario user = new Usuario();
	private JPasswordField pFSenhaComfirm;
	private JPasswordField pfSenha;
	private JFormattedTextField fTxtTelefone;
	private MaskFormatter mascaraTelefoneMovel;

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
				FormSpecs.DEFAULT_ROWSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblTitulo = new JLabel("Criar Uma Nova Conta");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblTitulo, "3, 3");

		JLabel lblUsuario = new JLabel("Usuario :");
		add(lblUsuario, "3, 5");

		textFUsuario = new JTextField();
		textFUsuario.setColumns(20);
		add(textFUsuario, "3, 7, fill, default");

		JLabel lblEmail = new JLabel("E-mail :");
		add(lblEmail, "3, 9");

		textFEMail = new JTextField();
		textFEMail.setColumns(20);
		add(textFEMail, "3, 11, fill, default");

		JLabel lblTelefone = new JLabel("Telefone:");
		add(lblTelefone, "3, 13");
		try {
			mascaraTelefoneMovel = new MaskFormatter("(##)9####-####");
		} catch (ParseException e) {
		}
		mascaraTelefoneMovel.setValueContainsLiteralCharacters(false);
		fTxtTelefone = new JFormattedTextField(mascaraTelefoneMovel);
		add(fTxtTelefone, "3, 15, fill, default");

		JLabel lblSenha = new JLabel("Senha :");
		add(lblSenha, "3, 17");

		pfSenha = new JPasswordField();
		add(pfSenha, "3, 19, fill, default");

		JLabel lblRepSenha = new JLabel("Comfirmar Senha :");
		add(lblRepSenha, "3, 21");

		pFSenhaComfirm = new JPasswordField();
		add(pFSenhaComfirm, "3, 23, fill, default");

		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "3, 27");

		btnTrocarParaLogin = new JButton("Ja Tenho Uma Conta");
		add(btnTrocarParaLogin, "3, 29");

	}

	@Override
	public void atualizarCampos() {

		textFEMail.setText("");
		pFSenhaComfirm.setText("");
		pfSenha.setText("");
		fTxtTelefone.setText("");
		textFUsuario.setText("");

	}

	public Usuario resgatarUser() throws BitShowException {

		user.setUsuario(textFUsuario.getText());
		user.setEmail(textFEMail.getText());
		try {
			user.setTelefone((String )mascaraTelefoneMovel.stringToValue(fTxtTelefone.getText()));
		} catch (ParseException e) {
		}
		user.setSenha(new String(pfSenha.getPassword()));
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
		}else {
			if (!Valida.eMail(user.getEmail())) {
				alerta += "Insira um E-mail Válido\n";
			}
		}
		if (user.getTelefone() == null || user.getTelefone().trim().isEmpty()) {
			alerta += "Insira um Telefone\n";
		}
		if (user.getSenha() == null || user.getSenha().trim().isEmpty()) {
			alerta += "Insira uma Senha\n";
		}
		if (pFSenhaComfirm.getPassword().toString().isBlank()) {
			alerta += "Comfirme a Senha\n";
		}
		if (!new String(pFSenhaComfirm.getPassword()).equals(user.getSenha())) {
			alerta += "Senhas inseridas não Coincidem\n";
		}
		if(!Valida.forcaSenha(new String(pFSenhaComfirm.getPassword()))) {
			alerta += "Senha de ter no mínimo 6 Caracteres e\n1 caractere maiúsculo\n1 caractere minusculo\n1 caractere numérico";
		}

		if (!alerta.isEmpty()) {
			alerta = "Causa : \n" + alerta;
			throw new BitShowException(alerta);
		}

	}

}
