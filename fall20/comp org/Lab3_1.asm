.data

answer:   .asciiz "The value of b is: "

.text
         
main:
     	
	li $t0, 2	# int a=2
	li $t1, 2	# int b=2
	
        blt $t0, $t1, else	#if a<b go to else 
	addi $t0, $t0, -1	#a=a+1
	j next
	
else:	addi $t0, $t0, 1 	#a=a-1
	
next:	add $t1, $t1, $t0    	#b=b+a
        
	la $a0, answer      
	li $v0,4	#print() answer message
        syscall
        
        la $a0, ($t1)     
	li $v0,1	#print() value of b ($t1)
        syscall

        li $v0,10    # exit()
        syscall      