.text

.globl subfunc
subfunc:

	add  $v0, $a0, $a1  #t1=x+y
	addi  $v0, $v0, 100  #t1= t1 + 100
	
	jr $ra
	
	li $v0,10    # exit()
        syscall  