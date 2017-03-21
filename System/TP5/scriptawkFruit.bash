awk -v produit="fruit" 'BEGIN{nb=0;} 
{if($3 == produit ){printf("%s\n", $2);nb+=$1;}}
END{printf("Soit %d %s(s).\n",nb,produit)}' memo.txt