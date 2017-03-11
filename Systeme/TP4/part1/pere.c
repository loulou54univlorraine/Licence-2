#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>
int main(int argc,char ** argv){
  pid_t ret;
  pid_t ret2;
  int i;
  srand(time(NULL));
  char arg[4];
  char buffer;/*buffer d'(un seul caractère*/
  int descr_tube[2];
  pipe(descr_tube);
  sprintf(arg,"%d",descr_tube[0]);
  
  
  switch(ret=fork()){
  case(pid_t) -1: perror("creation impossible");
    exit(1);
  case(pid_t) 0:
    printf("on est dans le fils : %d (père: %d):Debut du programme\n",getpid(), getppid());
    close(descr_tube[1]);
    execl("./fils","fils",arg,NULL);
    fflush(stdout);
    break;
  default : printf("on est dans le père : %d (père: %d):Debut du programme\n",getpid(), getppid());
    fflush(stdout);
    break;
  }  
 
  switch(ret2=fork()){
  case(pid_t) -1: perror("creation impossible");
    exit(1);
  case(pid_t) 0: printf("on est dans le fils : %d (père: %d):Debut du programme\n",getpid(), getppid());
    close(descr_tube[1]);
    execl("./fils","fils",arg,NULL);
    fflush(stdout);
    exit(0);
  default : printf("on est dans le père : %d (père: %d):Debut du programme\n",getpid(), getppid());
    fflush(stdout);
    break;
  }
  
  /*processus ecrivain*/
  close(descr_tube[0]);/*fermeture de la lecture*/
  for(i=0;i<atoi(argv[1]);i++){
    int j=rand()%2;
    if(j==0){
      buffer='+';
    }else{
      buffer='-';
    }
    write(descr_tube[1],&buffer,sizeof(char));/*ecriture*/
  }
  close(descr_tube[1]);
  wait(NULL);
  wait(NULL);
  exit(0);
}