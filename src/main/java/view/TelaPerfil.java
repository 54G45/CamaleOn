package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.BitShowController;
import model.exception.BitShowException;
import model.vo.Usuario;

public class TelaPerfil extends Painel {
	
	Usuario user = new Usuario();
	private JTextField txtUsuario;
	private JTextField txtEmail;
	private JFormattedTextField txtTelefone;
	private MaskFormatter mascaraTelefoneMovel;
	private JPasswordField pFSenha;
	private JButton btnSalvar;
	

	/**
	 * Create the panel.
	 */
	public TelaPerfil() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(125dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
		
		JLabel lblNewLabel = new JLabel("Perfil");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel, "3, 3, center, default");
		
		JLabel lblUsuario = new JLabel("Usuario");
		add(lblUsuario, "3, 7, center, default");
		
		txtUsuario = new JTextField();
		add(txtUsuario, "3, 9, fill, default");
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("E-Mail");
		add(lblNewLabel_2, "3, 11, center, default");
		
		txtEmail = new JTextField();
		add(txtEmail, "3, 13, fill, default");
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		add(lblNewLabel_3, "3, 15, center, default");
		try {
			mascaraTelefoneMovel = new MaskFormatter("(##)9####-####");
		} catch (ParseException e) {
		}
		mascaraTelefoneMovel.setValueContainsLiteralCharacters(false);
		txtTelefone = new JFormattedTextField(mascaraTelefoneMovel);
		add(txtTelefone, "3, 17, fill, default");
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		add(lblNewLabel_4, "3, 19, center, default");
		
		pFSenha = new JPasswordField();
		add(pFSenha, "3, 21, fill, default");
		pFSenha.setColumns(10);
		
		 btnSalvar = new JButton("Salvar Alterações");
		add(btnSalvar, "3, 23, center, default");

	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void atualizarCampos(Usuario u) {
		user = u;
		txtUsuario.setText(u.getUsuario());
		txtEmail.setText(u.getEmail());
		txtTelefone.setText(u.getTelefone());
		pFSenha.setText(u.getSenha());
		
		
		
	}
	
	public Usuario salvarAlterecoes(BitShowController cont) throws BitShowException {
		
		user.setUsuario(txtUsuario.getText());
		user.setEmail(txtEmail.getText());
		try {
			user.setTelefone((String )mascaraTelefoneMovel.stringToValue(txtTelefone.getText()));
		} catch (ParseException e) {
		}
		user.setSenha(new String(pFSenha.getPassword()));
		int linhasafetadas = cont.getUsuarioController().editarUsuario(user);
		if(linhasafetadas > 0) {
			JOptionPane.showMessageDialog(null, "Alteração Feita Com Sucesso");
		}else {
			throw new BitShowException("Falha ao Alterar Usuario");
		}
		
		return user;
		
	}







	@Override
	public void atualizarCampos() {
		// TODO Auto-generated method stub
		
	}
}
