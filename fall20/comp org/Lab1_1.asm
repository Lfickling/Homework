.data
hello:    .asciiz "Hello professor "
prof:	.asciiz "Feng!"

.text
         
main:
        la $a0,hello      # print()
        li $v0,4
        syscall

	li $v0, 4       # print()
	la $a0,prof
	syscall


        li $v0,10    # exit()
        syscall         # exit
