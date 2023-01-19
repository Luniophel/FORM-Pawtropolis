# PAWTROPOLIS
## (Prototipo di gioco in stile dungeon crawler testuale)

## Indice dei contenuti
* [Informazioni Generali](#Informazioni-Generali)
* [Tecnologie utilizzate](#Tecnologie-utilizzate)
* [Setup](#Setup)
* [Avvio](#Avvio)


## Informazioni Generali
Pawtropolis è la versione di base e giocabile di un'avventura testuale ambientata in un luogo immaginario chiamato Pawtropolis.
Il giocatore può:
* interagire col sistema tramite comandi testuali e ricevere feedback da esso nello stesso modo;
* spostarsi tra le stanze di Pawtropolis;
* raccogliere e lasciare degli oggetti nelle stanze;


## Tecnologie utilizzate
Il progetto è stato implementato utilizzando il linguaggio di programmazione JAVA.
Nello specifico è richiesta una versione uguale o superiore a Java 8.

## Setup
Per aggiungere un nuovo comando in eventuali sviluppi futuri, eseguire i seguenti passi: 
* aggiungere una nuova classe nel package src/pawtropolis/command/domain che implementi l'interfaccia Command
* inserire in src/pawtropolis/game/domain/Action.java un nuovo valore di enumerazione che corrisponda al comando da inserire 
* inserire nel costruttore della classe src/pawtropolis/command/CommandFactory.java una nuova entry nella mappa commands che sia composta da Key = Valore della nuova enumerazione e Value = un'istanza della classe associata al comando aggiunta nel primo passo

## Avvio
Per avviare il gioco, basta compilare ed avviare il file Application.java
