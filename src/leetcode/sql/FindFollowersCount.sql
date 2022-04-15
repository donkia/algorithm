/* Write your PL/SQL query statement below */

/**
 * 문제 : https://leetcode.com/problems/find-followers-count/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 740MS FASTER THAN 61.29%, MEMORY 0MB LESS THAN 100.00%)
 */

select user_id, count(*) as followers_count
from followers
group by user_id
order by 1