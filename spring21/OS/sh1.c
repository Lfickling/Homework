#include<stdio.h>
#include<sys/ipc.h>
#include<sys/shm.h>

int main()
{
	int shmid,status;

	int *a,*b;
	int i;

	shmid=shmget(IPC_PRIVATE, 2*sizeof(int),0777|IPC_CREAT);
	if(fork()==0) {
		b=(int *)shmat(shmid,0,0);
	
		for (i=0;i<10;i++) {
		sleep(1);
		printf("\n Inside Child %d \t %d\n",b[0],b[1]);
		}
		shmdt(b);
	}
	else {
		wait(&status);
		a=(int *)shmat(shmid,0,0);
		a[0]=0;a[1]=1;
		for(i=0;i<10;i++) {
		a[0]=a[0]+a[1];
		a[1]=a[0]+a[1];	
		printf("\n Inside Parent  %d \t%d\n",a[0],a[1]); 
		}
		shmdt(a);
		//wait(&status);
	}
return 0;
}
