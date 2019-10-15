# poniewaz javac jest aliasem, to musimy dodac ponizsze komendy, aby skrypt mogl skorzystac z tego aliasu
shopt -s expand_aliases
source ~/.profile


javac -d wynik-kompilacji src/main/java/elzbietaglazar/saper/Saper.java
