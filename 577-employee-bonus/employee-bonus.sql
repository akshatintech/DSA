/* Write your PL/SQL query statement below */
SELECT  e.name ,b.bonus fROM  Employee e 
LEFT JOIN   Bonus b on e.empId = b.empId WHERE b.bonus < 1000 or b.bonus is NULL;