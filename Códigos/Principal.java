import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import javax.swing.*;

public class Principal extends JFrame{
	//------------------TELAS-----------------------------//
	private JFrame Janela = new JFrame("CINEJAVA");
	private JPanel panelCont = new JPanel();
	private JPanel telalogin = new JPanel();
	private JPanel telacadastro = new JPanel();
	private JPanel telaredefinr = new JPanel();
	private JPanel telafunc = new JPanel();
	private JPanel telaclien = new JPanel();
	private CardLayout c1 = new CardLayout();
	private JButton botao_ingressos = new JButton("INGRESSOS");
	private JButton botao_voltar = new JButton("VOLTAR");	
	private JTextField texto;
	private JTextField texto2;
	private JTextField texto3;
	private JTextField texto4;
	private JTextField texto5;
	private JTextField texto6;
	private JPasswordField senha;
	private JPasswordField senha1;
	private JPasswordField senha2;
	private String nomeTemp;
	private String cpfTemp;
	private String senhaTemp;
	static ArrayList<String> arq = new ArrayList<String>();
	static ArrayList<String> arqtemp = new ArrayList<String>();
	private String Arquivo = "Filmes.txt";
	private JComboBox comboBox1 = new JComboBox(new Vector<String>(Principal.arq));
	private JComboBox comboBox = new JComboBox(new Vector<String>(Principal.arq));	
	String[] Aud = {"", "DUB", "LEG"};
	JComboBox comboBox_2 = new JComboBox(Aud);
	String[] tip = {"","INTEIRA", "MEIA"};
	JComboBox comboBox4 = new JComboBox(tip);
	String[] Qual = {"", "2D", "3D"};
	JComboBox comboBox_1 = new JComboBox(Qual);
	private static Cliente c = new Cliente();
	private static Funcionario f = new Funcionario();
	
	public Principal() {
		
		Janela.setSize(600, 370);
		panelCont.setLayout(c1);
		panelCont.add(telalogin, "1");
		panelCont.add(telafunc, "2");
		panelCont.add(telacadastro, "5");
		panelCont.add(telaclien, "4");
		panelCont.add(telaredefinr, "6");

		
		//-------------------------------TELA LOGIN-----------------------------------//
		
		telalogin.setLayout(null);
		telalogin.setBackground(Color.ORANGE);
		
		JLabel L_ogin = new JLabel("LOGIN");
		L_ogin.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		L_ogin.setForeground(new Color(0, 0, 0));
		L_ogin.setBounds(26, 45, 77, 26);
		telalogin.add(L_ogin);
		
		JLabel Se_nha = new JLabel("SENHA");
		Se_nha.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		Se_nha.setBounds(26, 119, 77, 35);
		telalogin.add(Se_nha);
						
		JButton botao_refefinir = new JButton("REDEFINIR SENHA");
		botao_refefinir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panelCont, "6");
				texto5.setText("");
				senha2.setText("");
			}
		});
		botao_refefinir.setForeground(Color.RED);
		botao_refefinir.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_refefinir.setBounds(26, 202, 219, 30);
		telalogin.add(botao_refefinir);
		
		texto4 = new JTextField();
		texto4.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texto4.setBounds(26, 82, 514, 26);
		telalogin.add(texto4);
		texto4.setColumns(10);
		
		senha = new JPasswordField();
		senha.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		senha.setBounds(26, 165, 514, 26);
		telalogin.add(senha);
		
		JButton botao_cadastrar = new JButton("CADASTRAR");
		botao_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panelCont, "5");
				texto.setText("");
				texto2.setText("");
				senha1.setText("");
			}
		});
		botao_cadastrar.setForeground(new Color(0, 128, 0));
		botao_cadastrar.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_cadastrar.setBounds(369, 268, 171, 30);
		telalogin.add(botao_cadastrar);
		
		JLabel Possui_cadastro = new JLabel("N\u00C3O POSSUI CADASTRO?");
		Possui_cadastro.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		Possui_cadastro.setBounds(26, 270, 260, 26);
		telalogin.add(Possui_cadastro);
		
		JButton botao_en_trar = new JButton("ENTRAR");
		botao_en_trar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ArrayList<String> clien = new ArrayList<String>();
				ArrayList<String> func = new ArrayList<String>();
				clien = ManipularArquivos.Param("Clientes.txt");
				func = ManipularArquivos.Param("Funcionarios.txt");
				arq = ManipularArquivos.Param("Filmes.txt");
				comboBox.setModel(new DefaultComboBoxModel(getLista()));
				comboBox1.setModel(new DefaultComboBoxModel(getLista()));
				int j = 2;
				int trava=0;
				for(int i=0; i<clien.size(); i = i+3) {
					if(texto4.getText().equals(clien.get(i))){ 
						if(senha.getText().equals(clien.get(j))) {
							trava = 1;
							break;
						}else{
							trava = 2;
						}
					}
					j = j + 3;
				}
				j = 2;
				int trava2 = 0;
				for(int i=0; i<func.size(); i = i+3) {
					if(texto4.getText().equals(func.get(i))){ 
						if(senha.getText().equals(func.get(j))) {
							trava2 = 1;
							break;
						}else{
							trava2 = 2;
						}
					}
					j = j + 3;
				}
				int trava3 = 0;
				if(trava == 1 && trava2 != 1 && trava3 == 0) { 
					c1.show(panelCont, "4");
					trava3 = 1;
				}if(trava == 2 && (trava2 == 0 || trava2 != 1) && trava3 == 0) {
					JOptionPane.showMessageDialog(null, "SENHA INVALIDA", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					trava3 = 1;
				}if(trava == 0 && (trava2 == 0 || trava2 != 1) && trava3 == 0) {
					JOptionPane.showMessageDialog(null, "VOCÊ NÂO POSSUI CADASTRO", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					trava3 = 1;
				}if(trava2 == 1 && trava != 1 && trava3 == 0) { 
					c1.show(panelCont, "2");
					trava3 = 1;
				}if(trava2 == 2 && (trava == 0 || trava != 1) && trava3 == 0) {
					JOptionPane.showMessageDialog(null, "SENHA INVALIDA", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					trava3 = 1;
				}if(trava2 == 0 && (trava == 0 || trava != 1) && trava3 == 0) {
					JOptionPane.showMessageDialog(null, "VOCÊ NÂO POSSUI CADASTRO", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					trava3 = 1;
				}
			}
		});
		botao_en_trar.setForeground(Color.BLUE);
		botao_en_trar.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_en_trar.setBounds(426, 202, 114, 30);
		telalogin.add(botao_en_trar);
		
		//---------------------------TELA REDEFINIR-----------------------------------//
	
		telaredefinr.setBackground(Color.ORANGE);
		telaredefinr.setLayout(null);

		JLabel L_ogi_n = new JLabel("LOGIN");
		L_ogi_n.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		L_ogi_n.setForeground(new Color(0, 0, 0));
		L_ogi_n.setBounds(26, 45, 77, 26);
		telaredefinr.add(L_ogi_n);
		
		JLabel nova_senha = new JLabel("NOVA SENHA");
		nova_senha.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		nova_senha.setBounds(26, 119, 149, 35);
		telaredefinr.add(nova_senha);
		
		texto5 = new JTextField();
		texto5.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texto5.setBounds(26, 82, 514, 26);
		telaredefinr.add(texto5);
		texto5.setColumns(10);
		
		senha2 = new JPasswordField();
		senha2.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		senha2.setBounds(26, 165, 514, 26);
		telaredefinr.add(senha2);
		
		String [] contas = {"CLIENTE", "FUNCIONÁRIO"};
		JComboBox comboBox_7 = new JComboBox(contas);
		comboBox_7.setBounds(227, 225, 313, 35);
		telaredefinr.add(comboBox_7);
		
		JButton botao_redefinir = new JButton("REDEFINIR");
		botao_redefinir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pos=0, i=0, trava=0;
				if(comboBox_7.getSelectedIndex() == 0) {
					ArrayList<String> cli = new ArrayList<String>();
					cli = ManipularArquivos.Param("Clientes.txt");
					for(i= 0; i<cli.size(); i++) {
						if(texto5.getText().equals(cli.get(i))) {
							pos = i + 2;
							trava = 1;
							break;
						}						
					}
					if(trava == 1) {
						String gravar1 = "";
						for(i = 0; i<cli.size(); i++) {
							if(i!=pos) {
								if(i != (cli.size()-1))
									gravar1 += cli.get(i) + "\n";
								else
									gravar1 += cli.get(i);
							}else{
								
								if(i != (cli.size()-1))
									gravar1 += senha2.getText() + "\n";
								else
									gravar1 += senha2.getText();
							}
						}
							ManipularArquivos.Write("Clientes.txt", gravar1);
							Cliente c = new Cliente();
							c.setSenha(senha2.getText());
					}
				}else {
					ArrayList<String> func = new ArrayList<String>();
					func = ManipularArquivos.Param("Funcionarios.txt");
					for(i= 0; i<func.size(); i++) {
						if(texto5.getText().equals(func.get(i))) {
							pos = i + 2;
							trava = 1;
							break;
						}						
					}
						if(trava == 1) {
						String gravar1 = "";
						for(i = 0; i<func.size(); i++) {
							if(i!=pos) {
								if(i != (func.size()-1))
									gravar1 += func.get(i) + "\n";
								else
									gravar1 += func.get(i);
							}else{
								
								if(i != (func.size()-1))
									gravar1 += senha2.getText() + "\n";
								else
									gravar1 += senha2.getText();
							}
						}
							ManipularArquivos.Write("Funcionarios.txt", gravar1);
							Funcionario f = new Funcionario();
							f.setSenha(senha2.getText());
					}
				}
				if(trava == 0) {
					JOptionPane.showMessageDialog(null, "LOGIN NÃO ENCONTRADO", "ERRO", JOptionPane.INFORMATION_MESSAGE);
				}else {
					c1.show(panelCont, "1");
					texto4.setText("");
					senha.setText("");
				}
			}
		});
		botao_redefinir.setForeground(new Color(0, 128, 0));
		botao_redefinir.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_redefinir.setBounds(369, 273, 171, 30);
		telaredefinr.add(botao_redefinir);
		
		JButton botaovoltar = new JButton("VOLTAR");
		botaovoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arq = ManipularArquivos.Param(Arquivo);
				comboBox.setModel(new DefaultComboBoxModel(getLista()));
				c1.show(panelCont, "1");
				texto4.setText("");
				senha.setText("");
			}
		});
		botaovoltar.setForeground(Color.RED);
		botaovoltar.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botaovoltar.setBounds(23, 271, 111, 33);
		telaredefinr.add(botaovoltar);
		
		JLabel tipo_conta = new JLabel("TIPO DE CONTA");
		tipo_conta.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		tipo_conta.setBounds(26, 225, 171, 35);
		telaredefinr.add(tipo_conta);
		
		//----------------------------TELA CADASTRO-----------------------------------//
		
		telacadastro.setLayout(null);
		telacadastro.setBackground(Color.ORANGE);
		
		JLabel L_o_gin = new JLabel("LOGIN");
		L_o_gin.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		L_o_gin.setForeground(new Color(0, 0, 0));
		L_o_gin.setBounds(26, 25, 77, 26);
		telacadastro.add(L_o_gin);
		
		JLabel Se_n_ha = new JLabel("SENHA");
		Se_n_ha.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		Se_n_ha.setBounds(26, 155, 77, 35);
		telacadastro.add(Se_n_ha);
						
		JButton botao_v_o_ltar = new JButton("VOLTAR");
		botao_v_o_ltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panelCont, "1");
				texto4.setText("");
				senha.setText("");
			}
		});
		botao_v_o_ltar.setForeground(Color.RED);
		botao_v_o_ltar.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_v_o_ltar.setBounds(26, 268, 119, 30);
		telacadastro.add(botao_v_o_ltar);
		
		texto = new JTextField();
		texto.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texto.setBounds(26, 58, 514, 26);
		telacadastro.add(texto);
		texto.setColumns(10);
				
		senha1 = new JPasswordField();
		senha1.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		senha1.setBounds(26, 184, 514, 26);
		telacadastro.add(senha1);
		
		JLabel C_P_F = new JLabel("CPF");
		C_P_F.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		C_P_F.setBounds(26, 95, 46, 26);
		telacadastro.add(C_P_F);
		
		texto2 = new JTextField();
		texto2.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texto2.setBounds(26, 119, 153, 35);
		telacadastro.add(texto2);
		texto2.setColumns(10);
		
		JLabel tipo_usuario = new JLabel("TIPO DE USU\u00C1RIO");
		tipo_usuario.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		tipo_usuario.setBounds(26, 222, 184, 26);
		telacadastro.add(tipo_usuario);
		
		String[] usu = {"CLIENTE", "FUNCIONÁRIO"};
		JComboBox combo_Box5 = new JComboBox(usu);
		combo_Box5.setBounds(266, 221, 274, 36);
		telacadastro.add(combo_Box5);
		
		JButton botaocadas_trar = new JButton("CADASTRAR");
		botaocadas_trar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chamada = combo_Box5.getSelectedIndex();
				if(chamada == 0) {
					c = new Cliente(texto.getText(), texto2.getText(), senha1.getText());
				}else {
					String valor = JOptionPane.showInputDialog(null, "DIGITE A SENHA DO SISTEMA", "CONFIRMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
					if(valor.equals("1234")) {
						f = new Funcionario(texto.getText(), texto2.getText(), senha1.getText());
					}else {
						JOptionPane.showMessageDialog(null, "SENHA INVÁLIDA", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				c1.show(panelCont, "1");
				texto4.setText("");
				senha.setText("");
			}
		});
		botaocadas_trar.setForeground(new Color(0, 128, 0));
		botaocadas_trar.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botaocadas_trar.setBounds(369, 268, 171, 30);
		telacadastro.add(botaocadas_trar);
		//-------------------------------TELA FUNCIONARIOS----------------------------//
		
		telafunc.setLayout(null);
		telafunc.setBackground(Color.ORANGE);
		JLabel Filme = new JLabel("FILME");
		Filme.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		Filme.setBounds(23, 25, 80, 20);
		telafunc.add(Filme);
		texto3 = new JTextField();
		texto3.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texto3.setBounds(23, 56, 529, 30);
		telafunc.add(texto3);
		texto3.setColumns(10);
		
		comboBox.setBounds(22, 161, 530, 35);
		telafunc.add(comboBox);	
		
		JButton botao_adicionar = new JButton("ADICIONAR");
		botao_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = texto3.getText();
				File file = new File("Temporario.txt");
				ManipularArquivos.Write_semSubs("Temporario.txt", Arquivo, temp);
				ManipularArquivos.Write_semSubs(Arquivo, "Temporario.txt");
				file.delete();
				arq = ManipularArquivos.Param(Arquivo);
				comboBox.setModel(new DefaultComboBoxModel(getLista()));
			}
		});
		botao_adicionar.setForeground(Color.BLUE);
		botao_adicionar.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_adicionar.setBounds(406, 97, 146, 33);
		telafunc.add(botao_adicionar);
		
		JLabel Em_Cartaz = new JLabel("EM CARTAZ");
		Em_Cartaz.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		Em_Cartaz.setBounds(23, 123, 124, 30);
		telafunc.add(Em_Cartaz);
				
		JButton botao_remover = new JButton("REMOVER");
		botao_remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = comboBox.getSelectedIndex();
				String gravar = "";
				arq = ManipularArquivos.Param(Arquivo);
				arq = atualiza_Lista(n);
				for(int i=0; i<arq.size(); i++) {
					if(i != (arq.size()-1))
						gravar += arq.get(i) + "\r\n";
					else
						gravar += arq.get(i);
					
				}
				ManipularArquivos.Write(Arquivo, gravar);
				comboBox.setModel(new DefaultComboBoxModel(getLista()));
			}
		});
		botao_remover.setForeground(Color.MAGENTA);
		botao_remover.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		botao_remover.setBounds(22, 207, 143, 33);
		telafunc.add(botao_remover);
		
		JButton botao_sair1 = new JButton("VOLTAR");
		botao_sair1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arq = ManipularArquivos.Param(Arquivo);
				comboBox.setModel(new DefaultComboBoxModel(getLista()));
				c1.show(panelCont, "1");
				texto4.setText("");
				senha.setText("");
			}
		});
		botao_sair1.setForeground(Color.RED);
		botao_sair1.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_sair1.setBounds(23, 271, 111, 33);
		telafunc.add(botao_sair1);
		
		JButton botao_comprar = new JButton("COMPRAR");
		botao_comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arq = ManipularArquivos.Param(Arquivo);
				comboBox1.setModel(new DefaultComboBoxModel(getLista()));
				c1.show(panelCont, "4");
			}
		});
		botao_comprar.setForeground(new Color(0, 128, 0));
		botao_comprar.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_comprar.setBounds(397, 271, 155, 33);
		telafunc.add(botao_comprar);
		
		//-------------------------------TELA CLIENTE---------------------------------//
		
		telaclien.setLayout(null);
		telaclien.setBackground(Color.ORANGE);
		JLabel F_ilme = new JLabel("FILME");
		F_ilme.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		//F_ilme.setForeground(new Color(0, 0, 0));
		F_ilme.setBounds(26, 22, 62, 26);
		telaclien.add(F_ilme);
		
		comboBox1.setBounds(26, 54, 525, 41);
		telaclien.add(comboBox1);
		
		JLabel Quali_l = new JLabel("QUALIDADE");
		Quali_l.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		Quali_l.setBounds(26, 106, 123, 35);
		telaclien.add(Quali_l);
		comboBox_1.setBounds(152, 106, 53, 35);
		telaclien.add(comboBox_1);
		
		JLabel A_udio = new JLabel("\u00C1UDIO");
		A_udio.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		A_udio.setBounds(314, 106, 72, 35);
		telaclien.add(A_udio);

		comboBox_2.setBounds(402, 106, 54, 35);
		telaclien.add(comboBox_2);
		
		Object [][] cl = {
				{"F1", "F2", "F3", "F4", "F5"},
				{"E1", "E2", "E3", "E4", "E5"},
				{"D1", "D2", " ", "D4", "D5"},
				{"C1", "C2", " ", "C4", "C5"},
				{"B1", "B2", " ", "B4", "B5"},
				{"A1", "A2", " ", "A4", "A5"},
		};
		String[] cll = {"", "", "", "", ""};
		JTable table = new JTable(cl, cll);
		table.setBounds(26, 217, 162, 98);
		telaclien.add(table);
		JLabel Ass_entos = new JLabel("ASSENTOS");
		Ass_entos.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		Ass_entos.setBounds(26, 180, 117, 26);
		telaclien.add(Ass_entos);
		String[] ass1 = {"", "A1", "A2", "A4", "A5", "B1", "B2", "B4", "B5", "C1", "C2", "C4", "C5", "D1", "D2", "D4", "D5", "E1", "E2", "E3", "E4", "E5", "F1", "F2", "F3", "F4", "F5"};
		JComboBox comboBox_3 = new JComboBox(ass1);
		comboBox_3.setBounds(152, 165, 53, 41);
		telaclien.add(comboBox_3);
		
		JLabel Ti_po = new JLabel("TIPO");
		Ti_po.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		Ti_po.setBounds(333, 182, 53, 23);
		telaclien.add(Ti_po);
		comboBox4.setBounds(402, 179, 86, 35);
		telaclien.add(comboBox4);
		
		JLabel teste = new JLabel("VALOR:");
		teste.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		teste.setBounds(228, 220, 119, 30);
		telaclien.add(teste);
		texto6 = new JTextField();
		texto6.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		texto6.setBounds(402, 220, 119, 30);
		telaclien.add(texto6);
		texto6.setColumns(10);
		
		JButton botao_sair = new JButton("VOLTAR");
		botao_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panelCont, "1");
				texto4.setText("");
				senha.setText("");
			}
		});
		botao_sair.setForeground(Color.RED);
		botao_sair.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_sair.setBounds(228, 268, 119, 30);
		telaclien.add(botao_sair);
		
		JButton botao_att = new JButton("ATUALIZAR VALOR");
		botao_att.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texto6.setText(gerarValor());
			}
		});
		botao_att.setForeground(Color.BLUE);
		botao_att.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_att.setBounds(314, 22, 237, 30);
		telaclien.add(botao_att);
		
		JButton botao_finalizar = new JButton("FINALIZAR");
		botao_finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gravar = "";
				String intt = "R$ 30,00";
				String meia = "R$ 15,00";
				if(comboBox4.getSelectedItem().equals("INTEIRA")) {
					gravar += "CINEJAVA\r\n" + "NOME: " + texto4.getText() + " " + "CPF: " + obtem_cpf(texto4.getText(), senha.getText()) + "\r\n" + "FILME: " + comboBox1.getSelectedItem() + " " +  comboBox_1.getSelectedItem() + " " + comboBox_2.getSelectedItem() + "\r\n" +
							"LUGAR: " + comboBox_3.getSelectedItem() + " " +"INGRESSO: " + comboBox4.getSelectedItem() + " " + intt + "\r\n";
				}else {
					gravar += "CINEJAVA\r\n" + "NOME: " + texto4.getText() + " " + "CPF: " + obtem_cpf(texto4.getText(), senha.getText()) + "\r\n" + "FILME: " + comboBox1.getSelectedItem() + " " +  comboBox_1.getSelectedItem() + " " + comboBox_2.getSelectedItem() + "\r\n" +
							"LUGAR: " + comboBox_3.getSelectedItem() +  " " +"INGRESSO: " + comboBox4.getSelectedItem() + " " + meia + "\r\n";
				}
				ManipularArquivos.Write("Ingresso.txt", gravar);
				JOptionPane.showMessageDialog(null, "OBRIGADO POR PREFERIR O CINEJAVA", "RETIRE SEU BILHETE PESSOALMENTE", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		botao_finalizar.setForeground(Color.BLUE);
		botao_finalizar.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		botao_finalizar.setBounds(389, 268, 162, 30);
		telaclien.add(botao_finalizar);
		
		//----------------------------------------------------------------------------//
		
		Janela.getContentPane().add(panelCont);
		Janela.setDefaultCloseOperation(Janela.EXIT_ON_CLOSE);
		Janela.setLocationRelativeTo(null);
		Janela.setResizable(false);
		Janela.setVisible(true);
	}	
	public ArrayList<String> atualiza_Lista(int n) {
		ArrayList<String> ret = new ArrayList<String>();
		for(int i=0; i<arq.size(); i++) {
			if(i!=n) ret.add(arq.get(i));
		}
		return ret;
	}
   private String[] getLista() {
        String[] stringFilme = new String[arq.size()];
        for (int i = 0; i < arq.size(); i++) {
            stringFilme[i] = arq.get(i);
        }
        return stringFilme;
    }
   private String obtem_cpf(String x, String y) {
	   String cpf = "";
	   int trava=0;
	   ArrayList<String> cli = new ArrayList<String>();
	   cli = ManipularArquivos.Param("Clientes.txt");
		for(int i=0; i<cli.size(); i = i+3) {
			if(x.equals(cli.get(i)) && y.equals(cli.get(i+2))){ 
				cpf = cli.get(i+1);
				trava = 1;
				break;
			}
		}
	   ArrayList<String> fu = new ArrayList<String>();
	   fu = ManipularArquivos.Param("Funcionarios.txt");
		for(int i=0; i<fu.size(); i = i+3) {
			if(x.equals(fu.get(i)) && y.equals(fu.get(i+2))){ 
				cpf = fu.get(i+1);
				break;
			}
		}
	   return cpf;
   }
   public String gerarValor() {
	   String valor = "R$ ";
	   
	   if(comboBox4.getSelectedItem().equals("INTEIRA")) {
			if(comboBox_1.getSelectedItem().equals("2D")) {
				
				if(comboBox_2.getSelectedItem().equals("DUB")) {
					valor = "R$ 30,00";
				}
				
				if(comboBox_2.getSelectedItem().equals("LEG")) {
					valor = "R$ 30,00";
				}
			}
			if(comboBox_1.getSelectedItem().equals("3D")) {
				
				if(comboBox_2.getSelectedItem().equals("DUB")) {
					valor = "R$ 40,00";
				}
				
				if(comboBox_2.getSelectedItem().equals("LEG")) {
					valor = "R$ 40,00";
				}
				
			}
	   }else {
			if(comboBox_1.getSelectedItem().equals("2D")) {
				
				if(comboBox_2.getSelectedItem().equals("DUB")) {
					valor = "R$ 15,00";
				}
				
				if(comboBox_2.getSelectedItem().equals("LEG")) {
					valor = "R$ 15,00";
				}
			}
			if(comboBox_1.getSelectedItem().equals("3D")) {
				
				if(comboBox_2.getSelectedItem().equals("DUB")) {
					valor = "R$ 20,00";
				}
				
				if(comboBox_2.getSelectedItem().equals("LEG")) {
					valor = "R$ 20,00";
				}
				
			}
	   }
	   
	   return valor;
   }
	//--------------------------------------------------------------------------------//
   
	public static void main(String[] args){	
		
		Principal frame = new Principal();
		frame.setVisible(true);
		
	}
}
	
//--------------------------------FIM-------------------------------------------------//