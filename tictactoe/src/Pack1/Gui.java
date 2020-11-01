package Pack1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GreedyAlgorithmenKI.GreedyHeuristik1;
import GreedyAlgorithmenKI.GreedyHeuristik2;


public class Gui {
	
	public JFrame jf;
	public Draw draw;
	public static JButton btnReset;
	public static JButton KI;
	public static JButton Greedy1;
	public static JButton Greedy2;
	
	public static JButton btn[] = new JButton[9];
	public static int state[] = new int[9];
	public static int player = 0;
	public static int gewinner = 0;
	public static boolean KIAktiviert;
	public static boolean GreedyAktiviert;
	
	public Gui() {
		
		KIAktiviert=false;
		GreedyAktiviert=false;
		jf = new JFrame();
		jf.setSize(800, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setTitle("Tic Tac Toe");
		
		for(int i = 0; i<btn.length; i++){
			btn[i] = new JButton();
			btn[i].setVisible(true);
			btn[i].addActionListener(new ActionHandler());
			btn[i].setFocusPainted(false);
			btn[i].setContentAreaFilled(false);
			btn[i].setBorder(null);
			jf.add(btn[i]);
		}
		
		ButtonPlacement.place();
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(675, 500, 100, 40);
		btnReset.setVisible(true);
		btnReset.setBackground(new Color(51, 102, 153));
		btnReset.setForeground(Color.WHITE);
		btnReset.setFocusPainted(false);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				for(int i = 0; i<Gui.state.length; i++){
					Gui.state[i] = 0;
				}
				Gui.player = 0;
				Gui.gewinner = 0;
//				KIAktiviert=false;
				if(Gui.KIAktiviert)bestmove();
					
				
				
			}
		});
		
		KI = new JButton("KI: X");
		KI.setBounds(675, 450, 100, 40);
		KI.setVisible(true);
		KI.setBackground(new Color(51, 102, 153));
		KI.setForeground(Color.WHITE);
		KI.setFocusPainted(false);
		KI.addActionListener(new ActionListener() {
	
		

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(player==0)
				bestmove();
				
			}
			
		});
		
		
		
		Greedy1 = new JButton("GREEDY:X");
		Greedy1.setBounds(675, 400, 100, 40);
		Greedy1.setVisible(true);
		Greedy1.setBackground(new Color(51, 102, 153));
		Greedy1.setForeground(Color.WHITE);
		Greedy1.setFocusPainted(false);
		Greedy1.addActionListener(new GreedyHeuristik1());
		
		Greedy2 = new JButton("GREEDY:O");
		Greedy2.setBounds(675, 350, 100, 40);
		Greedy2.setVisible(true);
		Greedy2.setBackground(new Color(51, 102, 153));
		Greedy2.setForeground(Color.WHITE);
		Greedy2.setFocusPainted(false);
		Greedy2.addActionListener(new GreedyHeuristik2());
		 
		Object[] options = {"Minimax-KI: X", "freies Spiel", "Greedy-Algo: O"};
		int selected = JOptionPane.showOptionDialog(null, "Wähle deine KI", "Alternativen", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if(selected==0) {
			bestmove();
			KIAktiviert=true;
		}
		if(selected==2) {
			GreedyAktiviert=true;
		}

		
		jf.add(btnReset);
//		jf.add(KI);
		jf.add(Greedy1);
		jf.add(Greedy2);
	
		
		draw = new Draw();
		draw.setBounds(0,0,800,600);
		draw.setVisible(true);
		jf.add(draw);
		
		jf.setVisible(true);
	
	}
	
	
	
	//besten Zug ermitteln per minimax Algorithmus
	//durchgehen aller möglichkeiten per Rekursion
	
	public void bestmove() {
		int bestScore=Integer.MIN_VALUE;
		int BestMove = 0;
		for(int i=0;i<state.length;i++) {
			if(state[i]==0) {
				state[i]=1;
				int score = minimax(state,0,false);
				state[i]=0;
				if(score>bestScore) {
					bestScore=score;
					BestMove=i;
				}
			}
		}
		
		state[BestMove]=1;
		//player 2 ist dran.
		player=1;
		
	}



	private int minimax(int[] state2, int depth,boolean ismaximizing) {
		Hilfsklasse hilfsklasse = new Hilfsklasse(state2);
		int result = hilfsklasse.Gewinner();
		if(result!=0) {
			int score=0;
			if(result==1){
				score=1;
			}
			if(result==2) {
				score=-1;
			}
			if(result==3) {
				score=0;
			}
			
			return score;
		}
		if(ismaximizing) {
			int bestScore=Integer.MIN_VALUE;
			for(int i=0;i<state2.length;i++) {
				if(state2[i]==0){
					state2[i]=2;
					int score=minimax(state2,depth+1,false);
					state2[i]=0;
					if(score>bestScore) {
						bestScore=score;
					}
				}
			}
			return bestScore;
			
		}else {
			
			int bestScore=Integer.MAX_VALUE;
			for(int i=0;i<state2.length;i++) {
				if(state2[i]==0){
					state2[i]=1;
					int score=minimax(state2,depth+1,true);
					state2[i]=0;
					if(score<bestScore) {
						bestScore=score;
					}
				}
			}
			return bestScore;
			
		}
	}

	

}