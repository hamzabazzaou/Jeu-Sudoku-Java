### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Main.class : Main.java MenuController.class MenuView.class ChargerSauvegardeController.class SudokuGrid.class SudokuController.class SudokuView.class VerifierController.class VerifierModel.class VerifierView.class SauvegardeController.class
	${JC} ${JCFLAGS} Main.java

MenuController.class : MenuController.java
	${JC} ${JCFLAGS} MenuController.java

MenuView.class : MenuView.java
	${JC} ${JCFLAGS} MenuView.java

ChargerSauvegardeController.class : ChargerSauvegardeController.java
	${JC} ${JCFLAGS} ChargerSauvegardeController.java

SudokuGrid.class : SudokuGrid.java
	${JC} ${JCFLAGS} SudokuGrid.java

SudokuController.class : SudokuController.java
	${JC} ${JCFLAGS} SudokuController.java

SudokuView.class : SudokuView.java
	${JC} ${JCFLAGS} SudokuView.java

VerifierController.class : VerifierController.java
	${JC} ${JCFLAGS} VerifierController.java

VerifierModel.class : VerifierModel.java
	${JC} ${JCFLAGS} VerifierModel.java

VerifierView.class : VerifierView.java
	${JC} ${JCFLAGS} VerifierView.java

SauvegardeController.class : SauvegardeController.java
	${JC} ${JCFLAGS} SauvegardeController.java

### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###
