package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.exception.BitShowException;
import model.vo.Usuario;

public class TelaLogin extends Painel {
	private JTextField textFEmail;
	private JTextField textFSenha;
	private JButton btnLogin;
	private JButton btnTrocarParaCadastro;
	private Usuario user = new Usuario();

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnTrocarParaCadastro() {
		return btnTrocarParaCadastro;
	}

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("bottom:default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
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
				RowSpec.decode("top:default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("ENTRAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel, "4, 4");
		
		JLabel lblUsuario = new JLabel("Email :");
		add(lblUsuario, "4, 6");
		
		textFEmail = new JTextField();
		textFEmail.setForeground(Color.BLACK);
		add(textFEmail, "4, 8");
		textFEmail.setColumns(20);
		
		JLabel lblSenha = new JLabel("Senha :");
		add(lblSenha, "4, 10");
		
		textFSenha = new JTextField();
		add(textFSenha, "4, 12");
		textFSenha.setColumns(20);
		
		 btnLogin = new JButton("Login");
		add(btnLogin, "4, 16");
		
		 btnTrocarParaCadastro = new JButton("Ainda Não Tenho Conta");
		add(btnTrocarParaCadastro, "4, 18");

	}
	
	public Usuario efetuarLogin() throws BitShowException {
		
		user.setEmail(textFEmail.getText());
		user.setSenha(textFSenha.getText());
		validarCampos();
		
		
		return user;
	}
	
	public void validarCampos() throws BitShowException {

		String alerta = "";
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			alerta += "Insira um Email\n";
		}
		if (user.getSenha() == null || user.getSenha().trim().isEmpty()) {
			alerta += "Insira uma Senha\n";
		}

		if (!alerta.isEmpty()) {
			alerta = "Causa : \n" + alerta;
			throw new BitShowException(alerta);
		}
	}

	
	@Override
	public void atualizarCampos() {
		// TODO Auto-generated method stub
		
	}
}
