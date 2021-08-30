.data

answer:	.asciiz "Value of z is: "

.text
         
main:
     	
     	li $a1,2  #x=2
     	
     	jal subfunc	#go to sunfunc()
     	
	la $a0, answer      
	li $v0,4	#print() answer message
        syscall
        
        la $a0, ($v1)     
	li $v0,1	#print() value of z
        syscall

        li $v0,10    # exit()
        syscall      
