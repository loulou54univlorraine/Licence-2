#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <string.h>
#include <time.h>
#include <fcntl.h>
#include <dirent.h>

int main(int argc, char *argv[]) {
    struct stat s;
    char ref[1024];
    char file_to_name[1024];
    strcpy(file_to_name, argv[2]);
    strcpy(ref, argv[1]);
    if (argc == 2) {
        strcpy(ref, argv[1]);
    } else {
        perror("erreur avec argument\n");
    }
    if (stat(ref, &s) == -1) {
        perror("le fichier/répertoire n'existe pas\n");
        exit(1);
    }
    if (S_ISREG(s.st_mode)) {
        printf("%s est un fichier  \n", ref);
        printf("Taille: %d bytes\n", (int) s.st_size);
        printf("Date: %s", ctime(&s.st_atime));
        printf("Date modif: %s", ctime(&s.st_mtime));
        int file_from, file_to;
        file_from = open(ref, O_RDONLY);

        if (file_from == -1) {
            perror("Le fichier n'a pas pu être lu");
        }
        char c;
        ssize_t nread;
        file_to = open(file_to_name, O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU);
        if (file_to < 0) {
            perror("Le fichier de copie n'a pas pu être crée/ouvert ");
        }
        int i = 0;
        while (nread = read(file_from, &c, 1), nread > 0) {
            char *out = &c;
            ssize_t nwritten;
            if (i == 0) {
                printf("%c",c);
                printf("\n");
                if (strcmp(out,"B")!=0){
                    perror("Le fichier n'est pas un bitmap 1");
                }
            }
             if(i == 1){
                 printf("%c",c);
                 printf("\n");
                 if(strcmp(out,"M")!=0){
                     perror("Le fichier n'est pas un bitmap 2");
                 }
             }
            i++;

            do {
                nwritten = write(file_to, out, nread);
                if (nwritten >= 0) {
                    nread -= nwritten;
                    out += nwritten;
                }
            } while (nread > 0);
        }
        if (nread == 0) {
            if (close(file_to) < 0) {
                file_to = -1;
                perror("erreur dans la copie");
            }
            close(file_from);
        }
        if (S_ISDIR(s.st_mode)) {
            printf("%s est un repertoire   inode %d \n", ref, (int) s.st_ino);

        }
    }

    return 0;
}