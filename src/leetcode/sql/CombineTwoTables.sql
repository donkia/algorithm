/**
 * 문제 : https://leetcode.com/problems/combine-two-tables/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 1458MS FASTER THAN 7.38%, MEMORY 0MB LESS THAN 100.00%)
 */


/* Write your PL/SQL query statement below */
select a.firstname, a.lastname, b.city, b.state
from person a, address b
where a.personId = b.personId(+)
