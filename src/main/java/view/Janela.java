package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import controller.BitShowController;
import model.exception.BitShowException;
import model.vo.Produto;
import model.vo.Usuario;

public class Janela {

	private JFrame frame;
	private JMenuBar menuBar;
	private Usuario userLogado = new Usuario();
	private BitShowController cont = new BitShowController();
	private TelaCadastro telaCadastro = new TelaCadastro();
	private TelaCarrinho telaCarrinho = new TelaCarrinho();
	private TelaLogin telaLogin = new TelaLogin();
	private TelaLoja telaLoja = new TelaLoja();
	private TelaLojaCadastro telaLojaCadastro = new TelaLojaCadastro();
	private TelaPerfil telaPerfil = new TelaPerfil();
	private TelaPesquisa telaPesquisa = new TelaPesquisa();
	private TelaProduto telaProduto = new TelaProduto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setContentPane(telaLogin);

		telaLogin.getBtnLogin().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					userLogado = telaLogin.efetuarLogin();
					userLogado = cont.getUsuarioController().login(userLogado);
					if (userLogado.getId() == 0) {
						throw new BitShowException("user inexistente");
					}
					menuBar.setVisible(true);
					telaLogin.atualizarCampos();
					trocarPainel(telaPesquisa);
				} catch (BitShowException erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "Atenção!\n " + userLogado.getId(),
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		telaLogin.getBtnTrocarParaCadastro().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				telaCadastro.atualizarCampos();
				trocarPainel(telaCadastro);

			}
		});

		telaCadastro.getBtnCadastrar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					userLogado = telaCadastro.resgatarUser();
					cont.getUsuarioController().cadastrar(userLogado);
					JOptionPane.showMessageDialog(null, "Cadastro com sucesso");
					trocarPainel(telaLogin);
				} catch (BitShowException erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "Atenção!", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		telaCadastro.getBtnTrocarParaLogin().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				telaLogin.atualizarCampos();
				trocarPainel(telaLogin);

			}
		});

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		menuBar.setVisible(false);

		JMenuItem mntmMinhaLoja = new JMenuItem("Minha loja");
		mntmMinhaLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaLoja.atualizarCampos(userLogado);
				telaLoja.preencherTabela(cont);
				trocarPainel(telaLoja);

			}
		});
		menuBar.add(mntmMinhaLoja);

		telaLoja.getBtnAdicionar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				telaLojaCadastro.setVisible(true);
				frame.setContentPane(new JScrollPane(telaLojaCadastro));
				frame.revalidate();

			}
		});
		
		telaLoja.getBtnRemover().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					telaLoja.removerDaLoja(cont);
					telaLoja.preencherTabela(cont);
				} catch (BitShowException erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "Atenção!", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});

		telaLojaCadastro.getBtnAdicionar().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Produto produto = new Produto();
				try {
					produto = telaLojaCadastro.cadastrarProduto();
					produto.setVendedor(userLogado);
					cont.getProdutoCont().cadastrarProduto(produto);
					JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso");
					telaLojaCadastro.atualizarCampos();
				} catch (BitShowException erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "Atenção!", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		
		JMenuItem mntmPesquisa = new JMenuItem("Pesquisa");
		mntmPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaPesquisa.atualizarCampos();
				trocarPainel(telaPesquisa);

			}
		});
		menuBar.add(mntmPesquisa);

		telaPesquisa.getBtnDetalhes().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					telaProduto.atualizarCampos(telaPesquisa.resgatarProduto());
					trocarPainel(telaProduto);
				} catch (BitShowException erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "Atenção!", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		
		telaProduto.getBtnAdicionarAoCarrinho().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				telaProduto.adicionarAoCarrinho(cont, userLogado.getId());

			}
		});

		JMenuItem mntmCarrinho = new JMenuItem("Carrinho");
		mntmCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaCarrinho.atualizarCampos(cont, userLogado.getId());
				trocarPainel(telaCarrinho);

			}
		});
		menuBar.add(mntmCarrinho);

		telaCarrinho.getBtnRemover().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					telaCarrinho.removerDoCarrinho(cont);
					telaCarrinho.atualizarCampos(cont, userLogado.getId());
				} catch (BitShowException erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "Atenção!", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		JMenu mnConfig = new JMenu("Config");
		menuBar.add(mnConfig);

		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				telaPerfil.atualizarCampos(userLogado);
				trocarPainel(telaPerfil);

			}
		});
		mnConfig.add(mntmPerfil);
		
		telaPerfil.getBtnSalvar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					userLogado = telaPerfil.salvarAlterecoes(cont);
					telaPerfil.atualizarCampos(userLogado);
				} catch (BitShowException e1) {
					e1.printStackTrace();
				}
				
			}
		});

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userLogado.setEmail("");
				userLogado.setSenha("");
				telaLogin.atualizarCampos();
				trocarPainel(telaLogin);
				menuBar.setVisible(false);

			}
		});
		mnConfig.add(mntmSair);

	}

	public void trocarPainel(Painel tela) {
		tela.setVisible(true);
		frame.setContentPane(tela);
		frame.revalidate();
	}

}
