// CS3600 Lab 4 : File: mutex2.c
//Objective to understad locks in threads
 
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
//lines 4-7 declare the libraries

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;
//initializes a pthread mutex lock called mutex1
int arr[5];
//initializes a 5 element array called arr

int main() { 
  pthread_t t1, t2; //declare two threads
  //first we add values to the array arr and print what they are
  printf("To begin with the array is: "); 
  for(int i=0;i<5;i++) //iterate through arr
  {
    arr[i]=1; //all values should be 1
    printf("%d ", arr[i]); //print the values of arr
  }
  printf("\n"); //go to next line

  //call thread t1 to method incr with input 2 should change values from 1 to 3
  pthread_create(&t1, NULL, incr, 2);
  //call thread t2 to method incr with input 3 should change values from 3 to 6
  pthread_create(&t2, NULL, incr, 3);

  pthread_join(t1,NULL); //close the thread t1
  pthread_join(t2,NULL); //close the thread t2
  exit(0); //exit the program
}

void *incr(int n) { //the method that increments the array arr by amount n.
  //lock the mutex for the following critical section
  pthread_mutex_lock(&mutex1); 

  printf("After being incremented by %d the array is: ", n); //prints statement
  for(int i=0;i<5;i++) //iterate through array arr
  {
   arr[i]= arr[i]+ n; //increment arr[i] by n
   printf("%d ", arr[i]); //print the new value
   sleep(2); 
   /*sleep for 2 to ensure the first thread executes incrementing 
   the array before the second thread does so that we increment in the correct 
   order and can show how the mutex works */
  }
  printf("\n"); //after printing out the full array go to next line

  pthread_mutex_unlock(&mutex1); //unlock the mutex
 
}


