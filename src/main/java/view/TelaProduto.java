package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

import controller.BitShowController;
import model.vo.Produto;

public class TelaProduto extends Painel {
	Produto produto;

	private JLabel lblNome;
	private JLabel lblCategoria;
	private JTextArea txtrDescricao;
	private JLabel lblVendedor;
	private JLabel lblPreco;
	private JLabel lblContato;
	private JButton btnAdicionarAoCarrinho;

	/**
	 * Create the panel.
	 */
	public TelaProduto() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(175dlu;min)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(175dlu;min)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
			new RowSpec[] {
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
				RowSpec.decode("top:default:grow"),}));

		JLabel lblTituloPagina = new JLabel("Vizualizando Produto");
		lblTituloPagina.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblTituloPagina, "4, 4, 3, 1, center, default");

		lblNome = new JLabel("Nome");
		add(lblNome, "4, 8");

		lblCategoria = new JLabel("Categoria");
		add(lblCategoria, "6, 8, right, default");
		
				txtrDescricao = new JTextArea();
				txtrDescricao.setLineWrap(true);
				add(txtrDescricao, "4, 10, 3, 1");
				txtrDescricao.setText("Descricao");

		lblVendedor = new JLabel("Vendido por");
		add(lblVendedor, "4, 12");

		lblPreco = new JLabel("Preco");
		add(lblPreco, "6, 12, right, default");

		lblContato = new JLabel("Contato");
		add(lblContato, "4, 14");
		
		btnAdicionarAoCarrinho = new JButton("Adicionar ao Carrinho");
		add(btnAdicionarAoCarrinho, "4, 16, 3, 1, center, default");

	}

	public JButton getBtnAdicionarAoCarrinho() {
		return btnAdicionarAoCarrinho;
	}

	public void atualizarCampos(Produto p) {
		produto = p;
		
		lblNome.setText("Nome : " + p.getNome());
		lblCategoria.setText("Categoria : " + p.getCategoria());
		txtrDescricao.setText(p.getDescricao());
		lblVendedor.setText("Vendedor : "+p.getVendedor().getUsuario());
		lblPreco.setText("Preço : "+p.getPreco()+" R$");
		lblContato.setText("Contato : "+p.getVendedor().getTelefone());
		
	}
	
	public void adicionarAoCarrinho(BitShowController cont, int idUsuario) {
		
		int chave = cont.getCarDAO().adicionarAoCarrinho(produto.getId(), idUsuario);
		if(chave >= 0) {
			JOptionPane.showMessageDialog(null, "Produto adicionado ao Carrinho com Sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "Falha ao adicionar Produto ao Carrinho");
		}
		
	}
	

	@Override
	public void atualizarCampos() {
		
	}

}
