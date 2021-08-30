.data

.text
.globl subfunc

subfunc:

	
	addi  $v1, $a1, 1 #z=x+1
	
	jr $ra
	
	li $v0,10    # exit()
        syscall   