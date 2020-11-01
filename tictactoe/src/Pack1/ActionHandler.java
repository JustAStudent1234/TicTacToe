package Pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import GreedyAlgorithmenKI.GreedyHeuristik2;

public class ActionHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if(GreedyHeuristik2.WährendKINichtSetzen && Gui.GreedyAktiviert && Gui.player==1)return;
		if(Gui.KIAktiviert && Gui.player==0)return;

		if (Gui.gewinner == 0) {
			
			

			//Geht Reihe 1 durch
			
			if(e.getSource() == Gui.btn[0]){
				if(Gui.state[0] == 0 && Gui.player == 0){
					Gui.state[0] = 1;
					Gui.player = 1;
				}
				else if(Gui.state[0] == 0 && Gui.player == 1){
					Gui.state[0] = 2;
					Gui.player = 0;
				}
				
			}else if(e.getSource() == Gui.btn[1]){
				if(Gui.state[1] == 0 && Gui.player == 0){
					Gui.state[1] = 1;
					Gui.player = 1;
				}
				else if(Gui.state[1] == 0 && Gui.player == 1){
					Gui.state[1] = 2;
					Gui.player = 0;
				}
				
			}
			else if(e.getSource() == Gui.btn[2]){
				if(Gui.state[2] == 0 && Gui.player == 0){
					Gui.state[2] = 1;
					Gui.player = 1;
				}
				else if(Gui.state[2] == 0 && Gui.player == 1){
					Gui.state[2] = 2;
					Gui.player = 0;
				}
				
			}
			
			//Reihe 2
			
			else if(e.getSource() == Gui.btn[3]){
				if(Gui.state[3] == 0 && Gui.player == 0){
					Gui.state[3] = 1;
					Gui.player = 1;
				}
				else if(Gui.state[3] == 0 && Gui.player == 1){
					Gui.state[3] = 2;
					Gui.player = 0;
				}
				
			}
			else if(e.getSource() == Gui.btn[4]){
				if(Gui.state[4] == 0 && Gui.player == 0){
					Gui.state[4] = 1;
					Gui.player = 1;
				}else if(Gui.state[4] == 0 && Gui.player == 1){
					Gui.state[4] = 2;
					Gui.player = 0;
				}
				
			}
			else if(e.getSource() == Gui.btn[5]){
				if(Gui.state[5] == 0 && Gui.player == 0){
					Gui.state[5] = 1;
					Gui.player = 1;
				}
				else if(Gui.state[5] == 0 && Gui.player == 1){
					Gui.state[5] = 2;
					Gui.player = 0;
				}
				
			}
			
			//Reihe 3
			
			else if(e.getSource() == Gui.btn[6]){
				if(Gui.state[6] == 0 && Gui.player == 0){
					Gui.state[6] = 1;
					Gui.player = 1;
				}
				else if(Gui.state[6] == 0 && Gui.player == 1){
					Gui.state[6] = 2;
					Gui.player = 0;
				}
				
			}
			else if(e.getSource() == Gui.btn[7]){
				if(Gui.state[7] == 0 && Gui.player == 0){
					Gui.state[7] = 1;
					Gui.player = 1;
				}
				else if(Gui.state[7] == 0 && Gui.player == 1){
					Gui.state[7] = 2;
					Gui.player = 0;
				}
				
			}
			else if(e.getSource() == Gui.btn[8]){
				if(Gui.state[8] == 0 && Gui.player == 0){
					Gui.state[8] = 1;
					Gui.player = 1;
				}
				else if(Gui.state[8] == 0 && Gui.player == 1){
					Gui.state[8] = 2;
					Gui.player = 0;
				}
				
			}
			}
		
		//automatiesiert die Züge von player 2 mit 2 sekunden delay.(GreedyAlgorithmus)
		if(Gui.GreedyAktiviert) {
			Timer timer = new Timer(5000,new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					Gui.Greedy2.doClick();
					((Timer)e.getSource()).stop();	
				}
				
			});
			timer.setInitialDelay(2000);
			timer.start();
		}
		
		//automatisisert die Züge von player 1 mit minimmax-KI
		
	if(Gui.KIAktiviert) {	
		Timer timer1 = new Timer(5000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Gui.KI.doClick();
				((Timer)e.getSource()).stop();	
			}
			
		});
		timer1.setInitialDelay(2000);
		timer1.start();
	}
		}

	}


