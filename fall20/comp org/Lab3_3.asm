.data

Database: .word 1,2,3,4,5,6,7,8,9,10
welcome:  .asciiz "Check if a number is in the database!\n"
enter:    .asciiz "Enter the number to be checked: "
found:    .asciiz "Number found!\n"
notfound: .asciiz "No such number found in database!\n"
goodbye:  .asciiz "Goodbye!"

.text
         
main:
     	
     	la $a0, welcome      
	li $v0,4	#print()
        syscall
        
        la $a0, enter     
	li $v0,4	#print()
        syscall
        
     	li $v0, 5 	#read number
     	syscall
     	move $s0, $v0	#move int just read to $s0
     	
	li $t0, 0	#create an int to offset the location along the database array
loop:   beq $t0, 40, nomatch # if we have checked every entry ($t0=40) then we it isnt there. 
	lw $t1, Database($t0) #loads an integer from the database (location 0 + (St0/4)) into $t1
	beq $s0, $t1, match  #compares the entered number ($s0 with the entry in database. goes to found if number is found in database
	addi $t0, $t0, 4 #adds 4 to $t0 to shift the entry we are inspecting in database 1 to the right
	j loop #check the next entry
	
match:  la $a0, found      
	li $v0,4	#print()
        syscall
        j end
        
nomatch:la $a0, notfound      
	li $v0,4	#print()
        syscall
        
end:    la $a0, goodbye      
	li $v0,4	#print()
        syscall

        li $v0,10    # exit()
        syscall         
