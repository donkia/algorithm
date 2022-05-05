package programmers;

// 100점
public class CodingTest_Q3_20220505 {

    public static void main(String[] args) {

    }
}


/***
 *
 * select name as id, sum(count) as count
 * from(
 *     SELECT id1 as name, count(*) as count
 *     from friends
 *     group by id1
 *
 *     union all
 *
 *     SELECT id2 as name, count(*) as count
 *     from friends
 *     group by id2
 * )
 * group by name
 * order by 1
 *
 *
 */
