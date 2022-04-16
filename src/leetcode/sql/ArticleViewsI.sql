/**
 * 문제 : https://leetcode.com/problems/article-views-i/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 696MS FASTER THAN 49.32%, MEMORY 0MB LESS THAN 100.00%)
 */

/* Write your PL/SQL query statement below */
select distinct author_id as id
from views
where author_id = viewer_id
order by author_id
