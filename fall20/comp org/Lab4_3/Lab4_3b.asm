.data

str:	.asciiz "I am subroutine!\n"

.text
.globl subfunc

subfunc:
	la $a0, str      
	li $v0,4	#print()
        syscall
	
	jr $ra
	
	li $v0,10    # exit()
        syscall   