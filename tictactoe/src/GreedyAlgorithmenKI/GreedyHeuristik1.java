package GreedyAlgorithmenKI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import Pack1.Gui;
import Pack1.Hilfsklasse;

//0==x 1==O

public class GreedyHeuristik1 implements ActionListener{
		
		public GreedyHeuristik1(){
		
			
		}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			while(Gui.gewinner==0 && Gui.player==0) {
				
				Gui.btn[BestMove(Gui.state)].doClick();
			}
			 
			
			
		}
		
		
		
		public int BestMove(int[] a) {
			
		//Spieler 1.
			
			
			//Randomisierter Anfang, damit man nicht immer dasselbe Spiel spielt:
			int counter=0;
			for(int i=0;i<a.length;i++) {
				if(a[i]==0) {
					counter++;
				}
			}
		
			if(counter==a.length) {
				while(true) {
					Random random = new Random();
					int Zufall = random.nextInt(9);
					if(Zufall !=1 && Zufall!=3 && Zufall!=5 && Zufall!=7) {
						System.out.print(Zufall);
						return Zufall;
					}
				}
				
			}
			
			//Wenn du gewinnen kannst in einem Zug, dann gewinne!
			for(int i=0;i<a.length;i++) {
				if(a[i]==0) {
			Hilfsklasse hilfsklasse = new Hilfsklasse(a);
			if(hilfsklasse.EinsGewonnen(i)) {
				return i;
			}
			}
			}
			
			//Wenn du das verlieren verhindern kannst in einem Zug, dann setze dort hin.
			for(int i=0;i<a.length;i++) {
				if(a[i]==0) {
				Hilfsklasse hilfsklasse = new Hilfsklasse(a);
				if(hilfsklasse.ZweiGewonnen(i)) {
					return i;
				}
				}
				}
			
			//Wähle das Feld welches dir am meisten Siegemöglichkeiten ermöglicht

			int k=0;
			int AnzahlderDifferenz=0;
			for(int i=0;i<a.length;i++) {
				if(a[i]==0) {
					Hilfsklasse hilfsklasse = new Hilfsklasse(a);
					if(hilfsklasse.DifferenzZwei(i)>AnzahlderDifferenz) {
						k=i;
						AnzahlderDifferenz=hilfsklasse.DifferenzZwei(i);
					}
				}
			}
			

			if(AnzahlderDifferenz==0) {
				Random random = new Random();
				return random.nextInt(9);	
			}else {
				return k;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public int getIndex(JButton a) {
			int index=0;
			for(int i=0;i<Gui.btn.length;i++) {
				if(Gui.btn[i].equals(a)) {
					index=i;
				}
			}
			return index;
		}
		
		
		
		
		
	}
