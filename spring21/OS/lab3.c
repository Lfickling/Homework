#include<stdio.h>
#include<pthread.h>
#include<unistd.h>
#include<sys/types.h>
#include<stdlib.h>

static int input;

//thread function
//
void *collatz(int input) {
	printf("The Collatz conjecture: ");
	printf("%d",input);
	while(input != 1) { //if the number is not yet 1 perform operations on it
		if(input % 2 == 0) { //if the number is even
			input = input / 2;  // n/2
			printf(", %d",input);
		}
		else { //if the number is odd
			input = ((input * 3) +1); // (3xn+1)
			printf(", %d",input);
		}
	}
	printf(" \n");
	return NULL;
}

void *factorial(int input) {
	printf("Factorial of %d: ",input);
	long longInput = (long)input;
	long output = longInput;
	while (longInput>1) {
		longInput = longInput-1;
		output = output * longInput;
	}
	printf("%d\n",output);
	return NULL;
}

int main(int argc,char *argv[]){
	//printf("Main starts here\n\n");

	if(argc==2) {
		input = atoi(argv[1]);
		double inputDouble = atof(argv[1]);
		
		if(inputDouble-input !=0 || input<=0) {
			printf("the number entered was not a positive integer.\nPlease try again with a positive whole number.\n");
			return(0);
		}
		else {
			pthread_t t1,t2;
			
			pthread_create(&t1,NULL,collatz,input);
			pthread_create(&t2,NULL,factorial,input);

			pthread_join(t1,NULL);
			pthread_join(t2,NULL);
		}
	}
	else {
		printf("You entered the wrong number of arguments.\nPlease try again and enter exactly one number to be processed.\n");
		return(0);
	}

	printf("end of program");

	return(0);
}
