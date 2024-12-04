1. Plus one: https://leetcode.com/problems/plus-one/description/ <br>
Beats: 100% <br>
Algorithm:<br>
-> Start the loop from right to left<br>
-> if current number is less than nine, just increment the number by one and return the array<br>
-> if current number is greater than nine, that means a carry has to be propagated to next element<br>
-> if loop doesn't break in between, that means 1 has to be added infront of the existing array<br>
    -> create a new array with n+1 and update first element to 1 and return the new array<br>