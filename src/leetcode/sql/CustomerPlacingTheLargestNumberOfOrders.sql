/**
 * 문제 : https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/
 * 레벨 : EASY
 * 결과 : 해결(RUNTIME 804MS FASTER THAN 30.37%, MEMORY 0MB LESS THAN 100.00%)
 */

select
 customer_number
from
 (select customer_number, count(order_number) order_count
  from orders group by customer_number order by order_count desc) a
  where rownum = 1
