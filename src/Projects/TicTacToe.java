package Projects;

import java.awt.BorderLayout;import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TicTacToe extends JFrame{
	
	
	int rodada = 0;
	
	ImageIcon iconBlue = new ImageIcon(getClass().getResource("blue.png"));
	ImageIcon iconYellow = new ImageIcon(getClass().getResource("yellow.png"));

	JPanel PlayerTela = new JPanel (new GridLayout(3, 3, 4, 4));
	
	Bloco[] blocos = new Bloco [9];
	
	
	
	final int JOGADOR_1 = 1;
	final int JOGADOR_2 = 2;
	
	int PlayerJoga = JOGADOR_1;
	
	JLabel lInformacao = new JLabel("Jogador "+ JOGADOR_1);

	
	public TicTacToe() 
	{
		configuracaoDeJanela();
		configuracaoDeTela();
	}
	
	public void configuracaoDeTela()
	{
		add(BorderLayout.CENTER,PlayerTela);
		add(BorderLayout.NORTH,lInformacao);
		PlayerTela.setBackground(Color.WHITE);
		lInformacao.setFont(new Font("Arial", Font.BOLD,30));
		lInformacao.setForeground(Color.RED);
		lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		for(int i=0; i<9; i++)
		{
			Bloco bloco = new Bloco();
			blocos[i] = bloco;
			PlayerTela.add(bloco);
		}
	}
	
	public void alterarVez() {
		if(PlayerJoga==1){
			PlayerJoga=2;
			lInformacao.setText("Jogador 2");
			lInformacao.setForeground(Color.BLUE);
		}else{
			PlayerJoga=1;
			lInformacao.setText("Jogador 1");
			lInformacao.setForeground(Color.RED);
		}
	}
	
	public boolean testVitoria(int jog) {
		if(blocos[0].quem==jog && blocos[1].quem==jog && blocos[2].quem==jog)
		{
			return true;
		}
		else if(blocos[3].quem==jog && blocos[4].quem==jog && blocos[5].quem==jog) 
		{
			return true;
		}
		else if(blocos[6].quem==jog && blocos[7].quem==jog && blocos[8].quem==jog)
		{
			return true;
		}
		else if(blocos[0].quem==jog && blocos[3].quem==jog && blocos[6].quem==jog) 
		{
			return true;
		}
		else if(blocos[1].quem==jog && blocos[4].quem==jog && blocos[7].quem==jog) 
		{
			return true;
		}
		else if(blocos[2].quem==jog && blocos[5].quem==jog && blocos[8].quem==jog)
		{
			return true;
		}
		else if(blocos[0].quem==jog && blocos[4].quem==jog && blocos[8].quem==jog) 
		{
			return true;
		}
		else if(blocos[2].quem==jog && blocos[4].quem==jog && blocos[6].quem==jog) 
		{
			return true;
		}
		return false;
	}
	
	
	public void configuracaoDeJanela() 
	{
		setTitle("Jogo da Velha - Mortal Kombat");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main (String[] Args) 
	{
		new TicTacToe();
	}
	
	public class Bloco extends JButton
	{
		int quem = 0;
		public Bloco()
		{
			setBackground(Color.BLACK);
			addActionListener(e->{
				if(quem == 0) 
				{
					if(PlayerJoga==JOGADOR_1) 
					{
						setIcon(iconBlue);
						quem = JOGADOR_1;
					}
					
					else
					{
						setIcon(iconYellow);
						quem = JOGADOR_2;

					}
					if (testVitoria(quem)) 
					{
						JOptionPane.showMessageDialog(null, "O Jogador " + quem + " Venceu!");
						//Adicionar função de jogar novamente			
						System.exit(0);
					}
					rodada++;
					if(rodada==9) {
						JOptionPane.showMessageDialog(null," Deu velha!");
						System.exit(0);
						//Adicionar função de jogar novamente							
					}
					alterarVez();
				}
			});
		}
	}
}

