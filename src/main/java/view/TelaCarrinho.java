package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class TelaCarrinho extends Painel {
	private JTable table;
	private JButton btnRemover;

	/**
	 * Create the panel.
	 */
	public TelaCarrinho() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(262dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(168dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "3, 5, fill, fill");
		
		table = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		
		JLabel lblSubTotal = new JLabel("SubTotal : 00,0 R$");
		add(lblSubTotal, "3, 7, right, default");
		
		btnRemover = new JButton("Remover");
		add(btnRemover, "3, 9, center, default");

	}
	
	@Override
	public void atualizarCampos() {
		// TODO Auto-generated method stub
		
	}
	
//	public void preenchertable() {
//		perguntas = perguntaController.busca(textFDuvida.getText());
//		
//		limparTabela();
//		
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//
//
//		for (Pergunta p : perguntas) {
//
//			Object[] novaLinhaDaTabela = new Object[5];
//
//			novaLinhaDaTabela[0] = p.getTitulo();
//			novaLinhaDaTabela[1] = p.getData();
//			novaLinhaDaTabela[2] = p.getDataResolucao() == null ? "Em Aberto" : "Resolvido";
//			novaLinhaDaTabela[3] = p.getUsuario().getNome();
//			novaLinhaDaTabela[4] = p.getCategoria().getNome();
//
//			model.addRow(novaLinhaDaTabela);
//		}
//
//	}
	
//	public Pergunta resgatarPergunta() throws DevPerguntarException {
//
//		int linhaSelecionada = table.getSelectedRow();
//		if (linhaSelecionada == -1) {
//			throw new DevPerguntarException("Selecione uma Pergunta");
//		}
//		Pergunta pergunta = perguntas.get(linhaSelecionada);
//		return pergunta;
//
//	}

}
