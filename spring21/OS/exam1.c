// CS3600 Take Home Portion Exam 1
 
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
#include<unistd.h>
#include<sys/types.h>

//lines 4-7 declare the libraries

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;
//initializes a pthread mutex lock called mutex1

int mainArr[20] = {1,3,4,1,5,6,2,7,1,8,9,1,2,3,1,3,1,4,6,7}; //array to be searched
//int mainArr[20]; //if allowing input
int searchNumber = 1;
int finalCount = 0;

void *searchCount(int a) { //the method that searches and counts the array for the search variable
    int count = 0;
    for(int i=0;i<4;i++){
        if (mainArr[a+i] == searchNumber) {
            count++;
        }
        sleep(4);
    }
  
  //lock the mutex for the following critical section
  pthread_mutex_lock(&mutex1); 
	finalCount += count;
  pthread_mutex_unlock(&mutex1); //unlock the mutex
} 


int main() {
/*int main(int argc,char *argv[]){ //if allowing the user to input the array values as arguments
	
    if (sizeof(argv) != 20) {
        printf("please enter 20 numbers.\n");
			return(0);
    }
    for (i=0;i<20);i++){
        mainArr[i] = atoi(argv[i]);
    } */ 
  
    pthread_t t1, t2, t3, t4, t5; //declare 5 threads

    pthread_create(&t1, NULL, searchCount, 0);
    pthread_create(&t2, NULL, searchCount, 4);
    pthread_create(&t3, NULL, searchCount, 8);
    pthread_create(&t4, NULL, searchCount, 12);
    pthread_create(&t5, NULL, searchCount, 16);

    pthread_join(t1,NULL); //close the thread t1
    pthread_join(t2,NULL); //close the thread t2
    pthread_join(t3,NULL); //close the thread t3
    pthread_join(t4,NULL); //close the thread t4
    pthread_join(t5,NULL); //close the thread t5

    printf("%d %d's in the array \n", finalCount, searchNumber);

    exit(0); //exit the program
}




