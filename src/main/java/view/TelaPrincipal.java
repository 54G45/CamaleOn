package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;
	private TelaInicial tela = new TelaInicial();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pesquisar");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cadastrar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Login");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Sair");
		mnNewMenu.add(mntmNewMenuItem_6);
		frame.getContentPane().setLayout(null);
		frame.setContentPane(tela);
	}
}
