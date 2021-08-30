#include<stdio.h>
#include<pthread.h>
#include<unistd.h>
#include<sys/types.h>
#include<stdlib.h>

void *sumOfArrayElements(int inputArray[]) {
	int sum = 0;
    for(i=0;i<sizeof(inputArray);i++){
        sum = sum+inputArray[i];
    }
	return sum;
}

int main(int argc,char *argv[]){
	//printf("Main starts here\n\n");
    if (sizeof(argv) != 40) {
        printf("please enter 40 numbers.\n");
			return(0);
    }
	//int array[sizeof(argv)];
    int mainArray[40]
    for (i=0;i<40);i++){
        mainArray[i] = atoi(argv[i]);
    }
	int array1[10]
    for (i=0;i<10);i++){
        array1[i] = mainArray[i]);
    }
    int array2[10]
    for (i=10;i<20);i++){
        array2[i] = mainArray[i]);
    }
    int array3[10]
    for (i=20;i<30);i++){
        array3[i] = mainArray[i]);
    }
    int array4[10]
    for (i=30;i<40);i++){
        array4[i] = mainArray[i]);
    }
    int sumArray[4];
    pthread_t t1,t2,t3,t4;
    
    sumArray[0] = pthread_create(&t1,NULL,sumOfArrayElements,array1);
    sumArray[1] = pthread_create(&t2,NULL,sumOfArrayElements,array2);
    sumArray[2] = pthread_create(&t3,NULL,sumOfArrayElements,array3);
    sumArray[3] = pthread_create(&t4,NULL,sumOfArrayElements,array4);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);
    pthread_join(t3,NULL);
    pthread_join(t4,NULL);
		
	int finalSum = sumOfArrayElements(sumArray);
	
    printf("The sum is %d \n",finalSum);
	printf("end of program");

	return(0);
}

