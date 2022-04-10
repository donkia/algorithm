/**
 * 문제 : HTTPS://LEETCODE.COM/PROBLEMS/recyclable-and-low-fat-products/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 681MS FASTER THAN 93.12%, MEMORY 0MB LESS THAN 100.00%)
 */

/* Write your PL/SQL query statement below */
select product_id
from products
where low_fats = 'Y' and recyclable  = 'Y'
