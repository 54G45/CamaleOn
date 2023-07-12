package view;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

import model.exception.BitShowException;
import model.valida.Valida;
import model.vo.Produto;

public class TelaLojaCadastro extends Painel {
	private JTextField textFPreco;
	private JTextField textFNomeProduto;
	private JButton btnAdicionar;
	private Produto p = new Produto();
	private JTextArea textADescricao;
	private JComboBox cBCategoria;
	private String[] categorias = { "cpu", "gpu", "placa-mãe", "RAM", "fonte", "SSD" };
	private JLabel lblNewLabel_4;

	/**
	 * Create the panel.
	 */
	public TelaLojaCadastro() {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(40dlu;min)"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(230dlu;min)"),
						FormSpecs.RELATED_GAP_COLSPEC,
						new ColumnSpec(ColumnSpec.FILL,
								Sizes.bounded(Sizes.DEFAULT, Sizes.constant("80dlu", true),
										Sizes.constant("120dlu", true)),
								0),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblNewLabel = new JLabel("Postar Venda");
		add(lblNewLabel, "4, 4, 5, 1, center, default");

		JLabel lblNewLabel_1 = new JLabel("Nome : ");
		add(lblNewLabel_1, "4, 6, left, default");

		textFNomeProduto = new JTextField();
		add(textFNomeProduto, "6, 6, 3, 1, fill, default");
		textFNomeProduto.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Descrição");
		add(lblNewLabel_3, "4, 8, left, default");

		cBCategoria = new JComboBox(categorias);
		add(cBCategoria, "8, 8, fill, default");

		textADescricao = new JTextArea();
		textADescricao.setLineWrap(true);
		add(textADescricao, "4, 10, 5, 1");
		
		lblNewLabel_4 = new JLabel("Formato de Preço aceito: 00.000.000,00 ");
		add(lblNewLabel_4, "6, 12");

		JLabel lblNewLabel_2 = new JLabel("Preço : R$");
		add(lblNewLabel_2, "4, 14, left, default");

		textFPreco = new JTextField();
		add(textFPreco, "6, 14, 3, 1, fill, default");
		textFPreco.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		add(btnAdicionar, "4, 16, 5, 1, center, default");
		
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	@Override
	public void atualizarCampos() {
		// TODO Auto-generated method stub

		textFNomeProduto.setText("");
		textADescricao.setText("");
		cBCategoria.setSelectedIndex(0);
		textFPreco.setText("");

	}

	public Produto cadastrarProduto() throws BitShowException {
		validarCampos();
		p.setNome(textFNomeProduto.getText());
		p.setDescricao(textADescricao.getText());
		p.setCategoria(cBCategoria.getSelectedItem().toString());
		p.setPreco(textFPreco.getText());

		return p;
	}

	public void validarCampos() throws BitShowException {

		String alerta = "";
		if (textFNomeProduto.getText().trim().isEmpty()) {
			alerta += "Insira um Nome para o Produto\n";
		}
		if (textADescricao.getText().trim().isEmpty()) {
			alerta += "Insira uma Descrição para o Produto\n";
		}
		if (cBCategoria.getSelectedIndex() == -1) {
			alerta += "Selecione uma Categoria para o Produto\n";
		}
		if (textFPreco.getText().trim().isEmpty()) {
			alerta += "Insira um Preço para o Produto";
		}
		if (!Valida.preco(textFPreco.getText())) {
			alerta += "Insira um Preço no Formato Válido '0.000,00'";
		}

		if (!alerta.isEmpty()) {
			alerta = "Causa : \n" + alerta;
			throw new BitShowException(alerta);
		}

	}

}
