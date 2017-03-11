#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <string.h>
#include <time.h>
#include <fcntl.h>
#include <dirent.h>


int main(int argc, char *argv[])
{
  struct stat s;
  char ref[1024];
  strcpy(ref, argv[1]);
  char * chaine;
  if(argc==2){
    strcpy(ref,argv[1]);
  }else{
    perror("erreur avec argument\n");
  }
  if(stat(ref,&s)==-1){
    perror("le fichier/répertoire n'existe pas\n");
    exit(1);
  }
  if(S_ISREG(s.st_mode)){
    printf("%s est un fichier\ninode %d\n",ref,(int)s.st_ino);
  }
  if(S_ISDIR(s.st_mode)){
    printf("%s est un repertoire\ninode %d \n",ref,(int)s.st_ino);
    DIR * desc= opendir(ref);
    if(desc==NULL){    
      perror("Repertoire non trouve");
    }
    struct dirent * fichier=readdir(desc);

    while(fichier!=NULL){
      sprintf(chaine,"%s/%s",ref,fichier->d_name);
      printf("inode: %d\n",(int)fichier->d_ino);
      stat(chaine,&s);
      if(S_ISREG(s.st_mode)){
	  printf("%s est un fichier",s);
      }
      if(S_ISDIR(s.st_mode)){
	  printf("%s est un repertoire",s);
      }
       
      fichier=readdir(desc);
      printf("\n");
    }
  }
  return 0;
}