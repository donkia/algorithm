/**
 * 문제 : https://leetcode.com/problems/delete-duplicate-emails/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 919MS FASTER THAN 37.50%, MEMORY 0MB LESS THAN 100.00%)
 */

/*
 Please write a DELETE statement and DO NOT write a SELECT statement.
 Write your PL/SQL query statement below
 */


DELETE FROM Person
WHERE id not in (SELECT min(id) as mind
       	 	FROM Person
        	GROUP BY email)