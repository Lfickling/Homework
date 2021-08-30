.data

.text
         
main:
     	li $s0,0 #x=0
     	li $t1,1
     	
     	la $a0, ($s0)     
	li $v0,1	#print()  ($s0)
        syscall
     	
     	jal subfunc	#go to sunfunc()
     	add  $s0, $s0, $t1 #x=x+1
     	
     	la $a0, ($s0)     
	li $v0,1	#print()  ($s0)
        syscall

        li $v0,10    # exit()
        syscall      
