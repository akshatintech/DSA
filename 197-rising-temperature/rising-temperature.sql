/* Write your PL/SQL query statement below */
SELECT today.id
FROM Weather today
CROSS JOIN   Weather yestterday
WHERE today.recorddate - yestterday.recorddate      =  1
AND today.temperature > yestterday.temperature;

