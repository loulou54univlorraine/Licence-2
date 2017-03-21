#!/bin/bash
if [[ -e "$1" ]]
then 
	echo  "$1 est un fichier"
else
	echo  "$1 n'existe pas"
fi
if [[ -e "$1" ]]
then 
	echo  "$1 est un fichier"
else
	echo  "$1 n'existe pas"
fi
if [[ "$1" -nt "$2" ]] 
then 
	echo  "$1 est le plus récent"
else
	echo  "$2 est le plus récent"
fi    