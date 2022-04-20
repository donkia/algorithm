/**
 * 문제 : https://leetcode.com/problems/calculate-special-bonus/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 1040MS FASTER THAN 19.21%, MEMORY 0MB LESS THAN 100.00%)
 */


/* Write your PL/SQL query statement below */
select employee_id,
case when mod(employee_id,2) =0 then 0
when substr(name, 0, 1) = 'M' then 0
else salary end as bonus
from employees

order by employee_id