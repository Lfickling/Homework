.data

str1:    .asciiz "Enter the value of i: "
str2:    .asciiz "Enter the value of j: "
str3:    .asciiz "x="

.text
         
main:
     	
     	la $a0,str1      
	li $v0,4	#print()
        syscall
        
     	li $v0, 5 	#read int
     	syscall
     	move $s1, $v0	#move int just read to $t0
     	
     	la $a0,str2      
	li $v0,4	#print()
        syscall
     	
     	li $v0, 5 	#read int
     	syscall
     	move $s2, $v0	#move int just read to $t1
     	
     	li $s0, 0 	#initialize register $t1 with a constant value 0
     	bne $s1,$s2, Miss
     	li $s0, 1
Miss:	li $s0, 2
     	
        la $a0,str3      
	li $v0,4	#print()
        syscall

	li $v0, 1	#print()
	move $a0, $s0
	syscall

        li $v0,10    # exit()
        syscall         # exit