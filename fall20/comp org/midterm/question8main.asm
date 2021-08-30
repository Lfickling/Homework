.data
str:  .asciiz "The value of z:"

.text
#.globl main
main:
addi $s0, $0,2 #x
addi $s1, $0,1 #y
addi $s2, $0,0 #z

move $a0, $s0
move $a1, $s1
jal subfunc
move $s2, $v0

la $a0, str
li $v0, 4
syscall 
move $a0, $s2 #print result
li $v0, 1
syscall

li $v0, 10 #exit
syscall
