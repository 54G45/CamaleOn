package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.BitShowController;
import model.exception.BitShowException;
import model.vo.Pesquisa;
import model.vo.Produto;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCarrinho extends Painel {
	private JTable table;
	private JButton btnRemover;
	private ArrayList<Produto> produtos;
	private String[] nomesColunas = { "Produto ", "Descrição", "Categoria", "Preço", "Vendedor" };
	private JLabel lblSubTotal;
	private int idUseLogado;

	/**
	 * Create the panel.
	 */
	public TelaCarrinho() {
		setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(350dlu;min)"), FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"), },
				new RowSpec[] { RowSpec.decode("default:grow"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(168dlu;default):grow"),
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblNewLabel = new JLabel("Seu Carrinho");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel, "3, 3, center, default");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "3, 7, fill, fill");

		table = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		scrollPane.setViewportView(table);

		lblSubTotal = new JLabel("SubTotal : 00,0 R$");
		add(lblSubTotal, "3, 9, right, default");

		btnRemover = new JButton("Remover");
		add(btnRemover, "3, 11, center, default");

	}

	public JButton getBtnRemover() {
		return btnRemover;
	}

	@Override
	public void atualizarCampos() {
		// TODO Auto-generated method stub

	}

	private void limparTabela() {
		table.setModel(new DefaultTableModel(new Object[][] {,}, nomesColunas));
	}

	public void atualizarCampos(BitShowController cont, int idLogado) {
		idUseLogado = idLogado;
		produtos = new ArrayList<Produto>();
		produtos = cont.buscarCarrinho(idLogado);

		limparTabela();
		double subTotal = 0;

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (Produto p : produtos) {

			Object[] novaLinhaDaTabela = new Object[5];

			novaLinhaDaTabela[0] = p.getNome();
			novaLinhaDaTabela[1] = p.getDescricao();
			novaLinhaDaTabela[2] = p.getCategoria();
			novaLinhaDaTabela[3] = "R$ "+p.getPreco();
			novaLinhaDaTabela[4] = p.getVendedor().getUsuario();
			subTotal = subTotal + Double.parseDouble(p.getPreco());

			model.addRow(novaLinhaDaTabela);
		}
		lblSubTotal.setText("SubTotal : " + subTotal + " R$");
	}

	public void removerDoCarrinho(BitShowController cont) throws BitShowException {
		Produto produto = resgatarProduto();

		int chave = cont.getCarDAO().removerDoCarrinho(produto.getId(), idUseLogado);
		if (chave > 0) {
			JOptionPane.showMessageDialog(null, "Produto Removido do Carrinho com Sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Falha ao Remover Produto do Carrinho");
		}

	}

	public Produto resgatarProduto() throws BitShowException {

		int linhaSelecionada = table.getSelectedRow();
		if (linhaSelecionada == -1) {
			throw new BitShowException("Selecione um Produto!");
		}
		Produto produto = produtos.get(linhaSelecionada);
		return produto;

	}

}
