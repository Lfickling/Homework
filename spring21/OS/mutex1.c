// CS3600 Lab 4 : File: mutex1.c
//Objective to understand locks in threads
 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;

// See the output by commenting and uncommenting locks
int count=1;

/*      in class example
        void *incr()
        {
          pthread_mutex_lock(&mutex1);
            count++;
            sleep(1)
            printf("count is %d \n",count);
          pthread_mutex_unlock(&mutex1);
        }

        int main() {
          pthread_t t1,t2;
          pthread_create(&t1,NULL,incr,NULL);
          pthread_create(&t2,NULL,incr,NULL);

          pthread_join(t1,NULL);
          pthread_join(t2,NULL);
          exit(0); 
        } */

void myprint(char* a, char* b) {
  pthread_mutex_lock(&mutex1); // comment out
  printf("1: %s\n", a);
  sleep(1);
  printf("2: %s\n", b);
  pthread_mutex_unlock(&mutex1); // comment out
  
}


// These two functions will run concurrently.
void* print_i(void *ptr) {
  myprint("I am", " in i");
}

void* print_j(void *ptr) {
  myprint("I am", " in j");
}

int main() {
  pthread_t t1, t2;
 pthread_create(&t1, NULL, print_i, NULL);
 pthread_create(&t2, NULL, print_j, NULL);

pthread_join(t1,NULL);
pthread_join(t2,NULL);
  exit(0); 
}
