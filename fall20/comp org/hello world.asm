# this is a hello world program

.data

String_out: .asciiz "Hello, Mars world!\n"


.text

main:
	# will print String_out to the console
	li $v0, 4
	la $a0, String_out
	syscall
	
	#Will terminate program
	li $v0, 10
	syscall