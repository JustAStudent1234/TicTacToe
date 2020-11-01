package GreedyAlgorithmenKI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import Pack1.Gui;
import Pack1.Hilfsklasse;

//0==x 1==O

public class GreedyHeuristik2 implements ActionListener{
		
	// wenn true darf nicht während der greedy KI gesetzt werden. 
	public static boolean WährendKINichtSetzen=true;
		public GreedyHeuristik2(){
		
			
		}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		WährendKINichtSetzen=false;
			while(Gui.gewinner==0 && Gui.player==1) {
				
				Gui.btn[BestMove(Gui.state)].doClick();
			}
			 WährendKINichtSetzen=true;
			
			
		}
		
		
		
		public int BestMove(int[] a) {
			
		//Spieler 1.
			
			
			
			
			//Wenn du gewinnen kannst in einem Zug, dann gewinne!
			for(int i=0;i<a.length;i++) {
				if(a[i]==0) {
			Hilfsklasse hilfsklasse = new Hilfsklasse(a);
			if(hilfsklasse.ZweiGewonnen(i)) {
				System.out.print(true);
				return i;
			}
			}
			}
			
			//Wenn du das verlieren verhindern kannst in einem Zug, dann setze dort hin.
			for(int i=0;i<a.length;i++) {
				if(a[i]==0) {
				Hilfsklasse hilfsklasse = new Hilfsklasse(a);
				if(hilfsklasse.EinsGewonnen(i)) {
					return i;
				}
				}
				}
			
			
			//Konkrete Fehler des Algorithmus:
			//X setzt zweimal in die Ecke
			int[] Beispiel1 = {0,0,1,0,2,0,1,0,0};
			int[] Beispiel2 = {1,0,0,0,2,0,0,0,1};
			if(gleich(a,Beispiel1) || gleich(Beispiel2,a)) {
				return 1;
			}
			
			//
			int[] Beispiel3 = {0,0,0,0,2,1,0,1,0};
			if(gleich(a,Beispiel3)) {
				return 2;
			}
			

			
			
			
			
			//Wähle das Feld, welches die meisten Siege von spieler zwei verhindert
			
			int k=0;
			int AnzahlderDifferenz=0;
			for(int i=0;i<a.length;i++) {
				if(a[i]==0) {
					Hilfsklasse hilfsklasse = new Hilfsklasse(a);
					if(hilfsklasse.DifferenzEins(i)>AnzahlderDifferenz) {
						k=i;
						AnzahlderDifferenz=hilfsklasse.DifferenzEins(i);
					}
				}
			}
			
			//Diagonalregel
			
			
		

			if(AnzahlderDifferenz==0) {
				Random random = new Random();
				return random.nextInt(9);	
			}else {
				return k;
			}
		}
		
		
		
		
		public boolean gleich(int[] a,int[] b) {
			for(int i=0;i<a.length;i++) {
				if(a[i]==b[i])continue;return false;
			}
			return true;
		}
		
	}

