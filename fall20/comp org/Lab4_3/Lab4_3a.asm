.data

str1:	.asciiz "before subroutine!\n"
str2:	.asciiz "after subroutine!\n"

.text
         
main:
     	
     	la $a0, str1      
	li $v0,4	#print()
        syscall
     	
     	jal subfunc	#go to sunfunc()
     	
     	la $a0, str2      
	li $v0,4	#print()
        syscall

        li $v0,10    # exit()
        syscall      
