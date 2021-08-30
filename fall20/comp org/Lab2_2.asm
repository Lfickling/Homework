.data
str:    .asciiz "The area of this triangle is "
str1:    .asciiz "Enter the height of the triangle: "
str2:    .asciiz "Enter the length of the triangle: "

.text
         
main:
     	
     	la $a0,str1      
	li $v0,4	#print()
        syscall
        
     	li $v0, 5 	#read int
     	syscall
     	move $t0, $v0	#move int just read to $t0
     	
     	la $a0,str2      
	li $v0,4	#print()
        syscall
     	
     	li $v0, 5 	#read int
     	syscall
     	move $t1, $v0	#move int just read to $t1
     	
     	mult $t0,$t1
     	mflo $t2
     	srl  $t2, $t2, 1
     	
        la $a0,str      
	li $v0,4	#print()
        syscall

	li $v0, 1	#print()
	move $a0, $t2
	syscall

        li $v0,10    # exit()
        syscall         # exit