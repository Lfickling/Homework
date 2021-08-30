.data
array: .word 10, 10, 10, 10

.text
	addi $s0,$0,0 # s0 as index
	li $t1,7
	sw $t1,array
	sw $t1, array+4
	addi $s0,$0,4 # s0 as index
	lw $t2, array($0)
	lw $t3, array($s0)
	
	  
