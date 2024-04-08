# TicTacToe
Ein TicTacToe-Spiel mit Fokus auf die KI per minimax-Algorithmus und zwei weiteren KIs mit einem GreedyAlgorithmus.

**Minimax Alogrithmus in TicTacToe:** 

![image](https://github.com/LorenzWenzel/TicTacToe/assets/73563833/316de4bb-3f37-44c1-8cf7-1a7e9806660d)



Ein einfaches 3x3 TicTacToe Interface mit zwei Spielern die jeweils abwechselnd ihr 'X' oder 'O' setzen. 
Zu Beginn der GUI wird man gefragt, welche modi man spielen will. Man hat die Auswahl gegen die KI zu spielen, die auf dem Minimax Algorithmus basiert, also einem Algorithmus der den gesamten Baum der Verläufe durchgeht und rekursiv die Pfade bewertet und dadurch immer die beste Entscheidung für Spieler 1, also 'X' trifft, wobei er davon ausgeht, dass Spieler zwei immer die besten Entscheidung trifft. 
Als zweite Auswahl hat man das freie Spiel, das normale TicTacToe wo zwei Spieler abwechselnd die Zeichen setzen.
Die dritte Möglichkeit wählt eine KI als Spieler zwei aus, welche nun auf einem Greedy-Algorithmus basiert. Dieser trifft in dem Sinne lokal immer die beste Entscheidung, als dass er ein Gewinn im nächsten Zug immer realisiert oder den Sieg des Gegners verhindert, sofern dies möglich ist. Abgesehen von dieser Situation trifft der Algorithmus immer die Entscheidung, die die größte Anzahl an Gewinnmöglichkeiten von 'X' unterbindet, er versucht in gewissem Sinne also einfach nur nicht zu verlieren. Zwei offensichtliche Fehlentscheidungen des Algorithmus wurden verändert, wodurch es kein purer GreedyAlgorithmus ist. 

Ein weiteres Ziel dieses Projektes ist das Etablieren eines Multiplayers, was ich bislang noch nicht zufriedenstellend umsetzen konnte.
