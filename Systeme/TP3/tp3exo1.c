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
    printf("%s est un fichier   inode %d\n",ref,(int)s.st_ino);
    printf("Taille: %d bytes\n",(int)s.st_size);
    printf("Date: %s",ctime(&s.st_atime));
    printf("Date modif: %s",ctime(&s.st_mtime));
    int descripteur=open(ref,O_RDONLY);
    if(descripteur==-1){
      perror("Le fichier n'a aps pu être lu");
    }
    char c;
    int i=0;
    while(read(descripteur,&c,1)!=0 &&i<100){
    printf("%c",c);
    i++;
    }
    printf("\n");
    close(descripteur);
  }
  if(S_ISDIR(s.st_mode)){
    printf("%s est un repertoire   inode %d \n",ref,(int)s.st_ino);
    
  }
  return 0;
}