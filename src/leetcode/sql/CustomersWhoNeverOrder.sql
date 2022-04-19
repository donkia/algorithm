/* Write your PL/SQL query statement below */
/**
 * 문제 : https://leetcode.com/problems/customers-who-never-order/
 * 레벨 : EASY
 * 결과 : 참고 후 해결(RUNTIME 750MS FASTER THAN 72.88%, MEMORY 0MB LESS THAN 100.00%)
 */


select a.name as Customers
from customers a, orders b
where a.id = b.customerId(+)
and b.id is null
