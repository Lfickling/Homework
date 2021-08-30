#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<stdlib.h>

int main(int argc, char *argv[])
{
	pid_t pid; //process ID variable
	//int the_number;
	//printf( "Please enter a number: " );
	//scanf( "%d", &the_number );
	
	if(argc==2) {
		int the_number = atoi(argv[1]); //the_number is entered as a parameter
		double doubleNumber = atof(argv[1]); //take the string parameter and convert it to a double
		if (doubleNumber - the_number != 0) {
			printf("The number entered was not a positive integer. \nPlease try again with a positive whole number. \n");
			return 0; //exit the program
		}

		if (the_number > 0) { //check the number is positive

			pid = fork(); 
			if(pid==0){ //perform only in child
				printf("The Collatz conjecture: ");
				printf("%d",the_number);
				while(the_number != 1) { //if the number is not yet 1 perform operations on it
					if(the_number % 2 == 0) { //if the number is even
						the_number = the_number / 2;  // n/2
						printf(", %d",the_number);
					}
					else { //if the number is odd
						the_number = ((the_number * 3) +1); // (3xn+1)
						printf(", %d",the_number);
					}
				}
				printf(" \n");
				return 0;	
			}
			else {
				wait(NULL); //wait for child process to complete
				return 0; //exit the program
			}
		}
		else{ //the number entered isnt positive
			printf("The number entered was not positive. \nPlease try again with a positive integer. \n");
			return 0; //exit the program
		}
	}
	else {
		printf("You entered the wrong number of arguments. \nPlease enter exactly one number to be processed \n");
	}
}	

