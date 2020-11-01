package Pack1;


public class Hilfsklasse {

	int[] array;
	int[] arrayKopie = new int[9];
	
	public Hilfsklasse(int[] array) {
		this.array=array;
		for(int i=0; i<array.length;i++) {
			arrayKopie[i]=array[i];
		}
	}
	
	
	//gibt Spieler wieder der gewonnen hat, 3 bei unentschieden und 0 wenn es noch mitten im Spiel ist.
	public int Gewinner() {
		
		
		//player1 gewinnt
		
		//Zeile
		if(array[0]==array[1] && array[1]==array[2] && array[2]==1) {
			return 1;
		}
		if(array[3]==array[4] && array[4]==array[5] && array[5]==1) {
			return 1;
		}
		if(array[6]==array[7] && array[7]==array[8] && array[8]==1) {
			return 1;
		}
		
		//Reihen		
		if(array[0]==array[3] && array[3]==array[6] && array[6]==1) {
			return 1;
		}
		if(array[1]==array[4] && array[4]==array[7] && array[7]==1) {
			return 1;
		}
		if(array[2]==array[5] && array[5]==array[8] && array[8]==1) {
			return 1;
		}
		
		//Diagonal
		if(array[0]==array[4] && array[4]==array[8] && array[8]==1) {
			return 1;
		}
		if(array[2]==array[4] && array[4]==array[6] && array[6]==1) {
			return 1;
		}
		
		
		//player2 gewinnt
		
		//Reihe
		if(array[0]==array[3] && array[3]==array[6] && array[6]==2) {
			return 2;
		}
		if(array[1]==array[4] && array[4]==array[7] && array[7]==2) {
			return 2;
		}
		if(array[2]==array[5] && array[5]==array[8] && array[8]==2) {
			return 2;
		}
		
		//Zeile
		if(array[0]==array[1] && array[1]==array[2] && array[2]==2) {
			return 2;
		}
		if(array[3]==array[4] && array[4]==array[5] && array[5]==2) {
			return 2;
		}
		if(array[6]==array[7] && array[7]==array[8] && array[8]==2) {
			return 2;
		}
		
		//Diagonale		
		if(array[0]==array[4] && array[4]==array[8] && array[8]==2) {
			return 2;
		}
		if(array[2]==array[4] && array[4]==array[6] && array[6]==2) {
			return 2;
		}
		
		//Unentschieden
		
		int counter=0;
		for(int i=0;i<array.length;i++) {
		if(array[i]==0) {
			counter++;
		}
		}
		if(counter==0) {
			return 3;				
		}
		
		// Spiel l�uft noch
		return 0;
	}
	

//gibt abh�ngig von der eingegebenen Position i zur�ck ob 1 gewonnen hat.	
	public boolean EinsGewonnen(int i) {

		array[i]=1;
		if(this.Gewinner()==1) {
			for(int j=0; j<array.length;j++) {
				array[j]=arrayKopie[j];
			}
			return true;
		}
		for(int j=0; j<array.length;j++) {
			array[j]=arrayKopie[j];
		}

		return false;
	}
	
	//gibt abh�ngig von der Position i zur�ck ob Spieler zwei gewonnen hat.
	public boolean ZweiGewonnen(int i) {

		array[i]=2;
		if(this.Gewinner()==2) {
			for(int j=0; j<array.length;j++) {
				array[j]=arrayKopie[j];
			}
			return true;
		}
		for(int j=0; j<array.length;j++) {
			array[j]=arrayKopie[j];
		}
		return false;
	}
	
	//gibt die Anzahl aller Kombinationen zur�ck wie Spieler zwei gewonnen h�tte, wenn alle verbleibenden Felder mit Kreis bedeckt werden.
	public int AnzahlM�glicherDreierF�rZwei(int[] a){
		
		int counter=0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				a[i]=2;
			}
		}
		
		//Zeilen
		
		if(array[0]==array[1] && array[1]==array[2] && array[2]==2) {
			counter++;
		}
		if(array[3]==array[4] && array[4]==array[5] && array[5]==2) {
			counter++;
		}
		if(array[6]==array[7] && array[7]==array[8] && array[8]==2) {
			counter++;
		}
		
		//Reihen		
		if(array[0]==array[3] && array[3]==array[6] && array[6]==2) {
			counter++;
		}
		if(array[1]==array[4] && array[4]==array[7] && array[7]==2) {
			counter++;
		}
		if(array[2]==array[5] && array[5]==array[8] && array[8]==2) {
			counter++;
		}
		
		//Diagonal
		if(array[0]==array[4] && array[4]==array[8] && array[8]==2) {
			counter++;
		}
		if(array[2]==array[4] && array[4]==array[6] && array[6]==2) {
			counter++;
		}
		
		return counter;
	}
	
	//gibt die Differenz der M�glichen Dreier von Spieler zwei zur�ck, 
	//zwischen der Anzahl der m�glichen Dreier mit allen freien Feldern==Kreis und 
	//der Anzahl der m�glichen Dreier mit allen freien Feldern==Kreis und das Feld an Position i==X 
	public int DifferenzZwei(int i) {
		
		
	
		int Ergebnis =this.AnzahlM�glicherDreierF�rZwei(array);
		array[i]=1;
		int Ergebnis2 = this.AnzahlM�glicherDreierF�rZwei(array);	
		int Diff = Ergebnis-Ergebnis2;	
		for(int j=0; j<array.length;j++) {
			array[j]=arrayKopie[j];
		}	
		

		return Diff;
	}
	
	
	
public int AnzahlM�glicherDreierF�rEins(int[] a){
		
		int counter=0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				a[i]=1;
			}
		}
		
		//Zeilen
		
		if(array[0]==array[1] && array[1]==array[2] && array[2]==1) {
			counter++;
		}
		if(array[3]==array[4] && array[4]==array[5] && array[5]==1) {
			counter++;
		}
		if(array[6]==array[7] && array[7]==array[8] && array[8]==1) {
			counter++;
		}
		
		//Reihen		
		if(array[0]==array[3] && array[3]==array[6] && array[6]==1) {
			counter++;
		}
		if(array[1]==array[4] && array[4]==array[7] && array[7]==1) {
			counter++;
		}
		if(array[2]==array[5] && array[5]==array[8] && array[8]==1) {
			counter++;
		}
		
		//Diagonal
		if(array[0]==array[4] && array[4]==array[8] && array[8]==1) {
			counter++;
		}
		if(array[2]==array[4] && array[4]==array[6] && array[6]==1) {
			counter++;
		}
		
		return counter;
	}

//siehe DifferenzZwei
public int DifferenzEins(int i) {
	
	
	
	int Ergebnis =this.AnzahlM�glicherDreierF�rEins(array);
	array[i]=2;
	int Ergebnis2 = this.AnzahlM�glicherDreierF�rEins(array);	
	int Diff = Ergebnis-Ergebnis2;	
	for(int j=0; j<array.length;j++) {
		array[j]=arrayKopie[j];
	}	
	

	return Diff;
}

//true wenn Spiel vorbei
public static boolean SpielVorbei(int[] a) {
	
	Hilfsklasse hilfsklasse = new Hilfsklasse(a);
	if(hilfsklasse.Gewinner()==0)
	return false;
	return true;
}


		

	
}
