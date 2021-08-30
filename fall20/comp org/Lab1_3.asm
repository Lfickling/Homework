.data
Array: .word 4, 3, 2, 1

.text
         
main:
        lw $t0, Array  #load Array[0] into $t0
        lw $t1, Array+4   #load Array[1] into $t1
        sw $t1, Array	#save $t1 into Array[0]
        sw $t0, Array+4	#save $t0 into Array[1]

        li $v0,10    # exit()
        syscall         # exit
