#!/bin/bash
for fichier in `ls ./`
do
echo -n "$fichier"
if [[ -d "$fichier" ]]
then
echo "n'est pas un fichier"
else
echo "est un fichier"
fi
done