package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrame extends javax.swing.JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JFrame frame = new JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public JFrame() {	
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Aluno");
		EntityManager manager = factory.createEntityManager();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 363);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem menuCadastrar = new JMenuItem("Cadastrar");
		menuCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 setContentPane(new TelaCadastro(manager));
			     setVisible(true);
			}
		});
		menuBar.add(menuCadastrar);
		
		JMenuItem menuEditar = new JMenuItem("Editar/Remover");
		menuEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setContentPane(new TelaEditarRemover(manager));
			    setVisible(true);
			}
		});
		menuBar.add(menuEditar);
		
		JMenuItem menuListar = new JMenuItem("Listar");
		menuListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setContentPane(new TelaListar(manager));
				setVisible(true);
			}
		});
		menuBar.add(menuListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	
	}
	
	

}
