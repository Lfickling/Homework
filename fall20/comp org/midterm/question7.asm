.data

message: .asciiz "Please enter a random number:"
right_str: .asciiz "Correct!\n"
wrong_str: .asciiz "Game over! \n"

.text
	li $t0,8  # true answer
	li $t1,0 #counter, two chances	 
loopcheck:   
	la $a0, message  # ask user type in 
	li $v0, 4
	syscall 
		
	li $v0, 5
	syscall
	move $s1, $v0 	 # s1 is the user input
        # your answer here
        
	
	beq $s1, $t0, printright
	add $t1,$t1,1
	beq,$t1,1, loopcheck #if there has only been one wrong attempt, try again
	

       # your answer here

printGameOver:
	la $a0, wrong_str
	li $v0, 4
	syscall  
	j done
printright:
	la $a0, right_str
	li $v0, 4
	syscall  	
done: #exit
li $v0, 10
syscall	 
