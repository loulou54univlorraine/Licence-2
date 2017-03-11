#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
int main(int argc,char ** argv){
    int moins=0;
    int plus=0;
    char buffer;
    
    
  while(read(atoi(argv[1]),&buffer,sizeof(char))){
    if(buffer=='-'){
      moins++;
    }else{
      plus++;
    }
  }
  close(atoi(argv[1]));
    printf("nombre de plus: %d\n",plus);
    printf("nombre de moins: %d\n",moins);

    exit(0);

}