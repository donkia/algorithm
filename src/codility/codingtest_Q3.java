package codility;

public class codingtest_Q3 {

    /** 3. sql 문제
     * test case 정답 후 제출
     * */

    /**
     * [제출]
     select a.name, a.cnt as all_test_cases, 
     b.cnt as  passed_test_cases,
     c.sum as total_value

     from (select a.name, coalesce(b.cnt, 0) as cnt

     from test_groups a left outer join( select group_name, count(*) as cnt
     from  test_cases
     group by group_name) b

     on a.name = b.group_name
     ) a,
     (select a.name, coalesce(b.cnt, 0) as cnt

     from test_groups a left outer join( select group_name, count(*) as cnt
     from  test_cases
     where status = 'OK'
     group by group_name) b

     on a.name = b.group_name
     ) b,
     (select a.name, coalesce(a.test_value * b.cnt, 0) as sum
     --a.name, coalesce(b.cnt, 0) as cnt

     from test_groups a left outer join( select group_name, count(*) as cnt
     from  test_cases
     where status = 'OK'
     group by group_name) b on a.name = b.group_name

     )c 
     where a.name = b.name
     and b.name = c.name

     order by total_value desc, name asc
     *
     *
     *
     * */


}
