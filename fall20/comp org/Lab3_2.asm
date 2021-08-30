.data

welcome:  .asciiz "I'm thinking of a number between 1 and 100 ...\nCan you guess what number I'm thinking of? \n"
enter:    .asciiz "Enter your guess: "
right:    .asciiz "\nCorrect!"
wrong:    .asciiz "\nWrong, the answer is "
goodbye:  .asciiz "\n\nGoodbye!"

.text
         
main:
     	
    	li $t0, 10	#the number we're thinking of
     	
     	la $a0, welcome      
	li $v0,4	#print()
        syscall
        
        la $a0, enter     
	li $v0,4	#print()
        syscall
        
     	li $v0, 5 	#read number
     	syscall
     	move $s0, $v0	#move int just read to $s0
     	
	
        beq $t0, $s0, yes 	#if they guess right go to yes
	j no 	#if they guess wrong go to no
	
yes:    la $a0, right      
	li $v0,4	#print()
        syscall
        j end
        
no:	la $a0, wrong     
	li $v0,4	#print()
        syscall
        
        la $a0, ($t0)     
	li $v0,1	#print() the guess ($t0)
        syscall
        
end:    la $a0, goodbye      
	li $v0,4	#print()
        syscall

        li $v0,10    # exit()
        syscall         
