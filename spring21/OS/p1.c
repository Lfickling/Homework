#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>

int main()
{
	pid_t pid; //process ID variable
	printf("1\n");
	fork();
	printf("2 \n");
	fork();
	printf("3\n");
	pid = fork();
	printf("4 and pid is %d \n",pid); 
       	return 0;
}
