

/**
 * 문제 : https://leetcode.com/problems/find-customer-referee/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 801MS FASTER THAN 33.07%, MEMORY 0MB LESS THAN 100.00%)
 */

/* Write your PL/SQL query statement below */
select name
from customer
where referee_id != '2'or  referee_id is null