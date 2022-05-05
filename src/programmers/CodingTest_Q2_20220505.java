package programmers;


// 100점

public class CodingTest_Q2_20220505 {

    /**
     *
     * select name, count(name) as count
     * from cart_products
     * where cart_id in (
     *
     *         SELECT a.id
     *         from carts a, cart_products b
     *         where a.id = b.cart_id
     *         and a.user_id = 4
     *         group by a.id
     *     )
     * group by name
     * order by count desc, name asc
     *
     *
     *
     *
     * */


}
