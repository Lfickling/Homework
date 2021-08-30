.data
#none

.text
         
main:
             
        li $t1, 10 	#initialize register $t1 with a constant value 10
        addi $t2, $t1, 1     #$t2 = $t1 + 1
	addi $t3, $t1, 2 	#$t3 = $t1 + 2
	addi $t4, $t1, 3 	#$t4 = $t1 + 3
	add $t5, $t2, $t3       # #t1+ $t2
	add $t5, $t5, $t4	#$t5 = $t2 + $t3 + $t4 
	
	li $v0, 1       # print()
	la $a0, ($t5)
	syscall


        li $v0,10    # exit()
        syscall         # exit