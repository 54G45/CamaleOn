package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
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
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("50dlu", false), Sizes.constant("150dlu", false)), 1),
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
		add(lblCategoria, "6, 8");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "4, 10, 3, 1, fill, fill");

		txtrDescricao = new JTextArea();
		txtrDescricao.setText("Descricao");
		scrollPane.setViewportView(txtrDescricao);

		lblVendedor = new JLabel("Vendido por");
		add(lblVendedor, "4, 12");

		lblPreco = new JLabel("Preco");
		add(lblPreco, "6, 12");

		lblContato = new JLabel("Contato");
		add(lblContato, "4, 14");
		
		btnAdicionarAoCarrinho = new JButton("Adicionar ao Carrinho");
		add(btnAdicionarAoCarrinho, "4, 16, 3, 1, center, default");

	}

	public void atualizarCampos(Produto p) {
		
		lblNome.setText("Nome : " + p.getNome());
		lblCategoria.setText("Categoria : " + p.getCategoria());
		txtrDescricao.setText(p.getDescricao());
		lblVendedor.setText("Vendedor : "+p.getVendedor().getUsuario());
		lblPreco.setText("Preço : "+p.getPreco()+" R$");
		lblContato.setText("Contato : "+p.getVendedor().getTelefone());
		
	}
	
	public void adicionarAoCarrinho(BitShowController cont, int idProduto, int idUsuario) {
		
		
	}
	

	@Override
	public void atualizarCampos() {
		
	}

}
