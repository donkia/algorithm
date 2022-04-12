/**
 * 문제 : https://leetcode.com/problems/group-sold-products-by-the-date/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 665MS FASTER THAN 80.00%, MEMORY 0MB LESS THAN 100.00%)
 */


/* Write your PL/SQL query statement below */
select to_char(sell_date, 'yyyy-mm-dd') as sell_date, count(distinct product) as num_sold, LISTAGG(product, ',')  WITHIN GROUP(ORDER BY product) as products
from (select sell_date, product from Activities group by sell_date, product)
group by to_char(sell_date, 'yyyy-mm-dd')
order by 1