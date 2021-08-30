.data
str:    .asciiz "The area of this triangle is "

.text
         
main:
     	li $s0, 6 	#initialize register $s0 with a constant value 6
     	li $s1, 10 	#initialize register $s1 with a constant value 10
     	mult $s0,$s1
     	mflo $s2
     	srl  $s2, $s2, 1
     	
        la $a0,str      
	li $v0,4	#print()
        syscall

	li $v0, 1	#print()
	move $a0, $s2
	syscall

        li $v0,10    # exit()
        syscall         # exit