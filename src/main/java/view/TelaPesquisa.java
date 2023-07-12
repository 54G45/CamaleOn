package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

import controller.BitShowController;
import model.exception.BitShowException;
import model.vo.Pesquisa;
import model.vo.Produto;
import java.awt.SystemColor;

public class TelaPesquisa extends Painel {
	private JTable table;
	private Pesquisa pesquisa;
	private JTextField textFNomeProduto;
	private ArrayList<Produto> produtos;
	private String[] categorias = {"CPU", "GPU", "Placa-mãe", "RAM", "Fonte", "SSD"};
	private String[] nomesColunas = {"Produto ", "Descrição", "Categoria", "Preço", "Vendedor",};
	private JComboBox cBCategoria;
	private JButton btnDetalhes;
	
	
	

	public TelaPesquisa() {
		setLayout(
				new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(40dlu;min)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(230dlu;min)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(80dlu;min)"),
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
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.MINIMUM, Sizes.constant("147dlu", false), Sizes.constant("175dlu", false)), 0),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblTituloTela = new JLabel("Buscar Produtos");
		lblTituloTela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblTituloTela, "4, 4, 5, 1, center, default");

		JLabel lblProduto = new JLabel("Produto :     ");
		add(lblProduto, "4, 6, left, default");

		textFNomeProduto = new JTextField();
		add(textFNomeProduto, "6, 6, fill, default");
		textFNomeProduto.setColumns(10);

		 cBCategoria = new JComboBox(categorias);
		 cBCategoria.setBackground(SystemColor.inactiveCaption);
		add(cBCategoria, "8, 6, fill, default");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "4, 8, 5, 1, fill, fill");

		table = new JTable();
		scrollPane.setViewportView(table);

		 btnDetalhes = new JButton("Detalhes");
		add(btnDetalhes, "4, 10, 2, 1, left, default");

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BitShowController cont = new BitShowController();
				preencherTabela(cont);
			}
		});
		add(btnBuscar, "8, 10, right, default");
		limparTabela();
	}
	
	public JButton getBtnDetalhes() {
		return btnDetalhes;
	}

	public void preencherTabela(BitShowController cont){
		
		produtos = new ArrayList<Produto>();
		produtos = this.pesquisar(cont);


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
	
	public ArrayList<Produto> pesquisar(BitShowController cont) {
		pesquisa = new Pesquisa();
		pesquisa.setNomeProduto(textFNomeProduto.getText());
		pesquisa.setCategoria(cBCategoria.getSelectedItem().toString());
		return cont.pesquisar(pesquisa);
		
	}
	
	private void limparTabela() {
		table.setModel(new DefaultTableModel(new Object[][] {,}, nomesColunas));
	}
	
	public Produto resgatarProduto() throws BitShowException {

		int linhaSelecionada = table.getSelectedRow();
		if (linhaSelecionada == -1) {
			throw new BitShowException("Selecione uma Pergunta");
		}
		Produto produto = produtos.get(linhaSelecionada);
		return produto;

	}

	@Override
	public void atualizarCampos() {
		
	}

}
