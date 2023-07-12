package view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.BitShowController;
import model.exception.BitShowException;
import model.vo.Produto;
import model.vo.Usuario;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class TelaLoja extends Painel {
	private JTable table;
	private JButton btnAdicionar;
	private Usuario userLogadoLoja = new Usuario();
	private JButton btnRemover;
	private ArrayList<Produto> produtos;
	private String[] nomesColunas = {"Produto ", "Descrição", "Categoria", "Preço"};
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	
	/**
	 * Create the panel.
	 */
	public TelaLoja() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(175dlu;min):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(175dlu;min)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(13dlu;min)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(150dlu;min)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblNewLabel = new JLabel("Minha Loja");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel, "3, 3, 3, 1, center, default");
		
		scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "3, 7, 3, 1, fill, fill");
		
		table = new JTable();
		scrollPane_1.setViewportView(table);

		btnRemover = new JButton("Remover");
		add(btnRemover, "3, 9, left, default");

		btnAdicionar = new JButton("Adicionar");
		add(btnAdicionar, "5, 9, right, default");
		limparTabela();
	}

	public JButton getBtnRemover() {
		return btnRemover;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public void preencherTabela(BitShowController cont) {

		produtos = new ArrayList<Produto>();
		produtos = cont.getProdutoCont().meusProdutos(userLogadoLoja.getId());

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (Produto p : produtos) {

			Object[] novaLinhaDaTabela = new Object[5];

			novaLinhaDaTabela[0] = p.getNome();
			novaLinhaDaTabela[1] = p.getDescricao();
			novaLinhaDaTabela[2] = p.getCategoria();
			novaLinhaDaTabela[3] = "R$ "+p.getPreco();
			novaLinhaDaTabela[4] = p.getVendedor().getUsuario();

			model.addRow(novaLinhaDaTabela);
		}

	}

	private void limparTabela() {
		table.setModel(new DefaultTableModel(new Object[][] {,}, nomesColunas));
	}
	
	public Produto resgatarProduto() throws BitShowException {

		int linhaSelecionada = table.getSelectedRow();
		if (linhaSelecionada == -1) {
			throw new BitShowException("Selecione um Produto!");
		}
		Produto produto = produtos.get(linhaSelecionada);
		return produto;

	}
	
	public void removerDaLoja(BitShowController cont) throws BitShowException {
		Produto produto = resgatarProduto();

		int chave = cont.removerDaLoja(produto.getId());
		if (chave > 0) {
			JOptionPane.showMessageDialog(null, "Produto Removido da Loja com Sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Falha ao Remover Produto da Loja");
		}

	}

	public void atualizarCampos(Usuario userLogado) {
		userLogadoLoja = userLogado;
	}

	@Override
	public void atualizarCampos() {
		// TODO Auto-generated method stub
		
	}

}
