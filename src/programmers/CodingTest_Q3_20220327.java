package programmers;

//SQL 1번 문제(100점) & 객관식 1번문제
public class CodingTest_Q3_20220327 {

    interface I1{
        void m1();
    }

    interface I2 extends I1{
        void m2();
    }
    interface I3{
        void m3();
    }
    static class A implements I3{
        @Override
        public void m3() {

        }
    }
    static class B extends A implements I2{
        @Override
        public void m2() {

        }

        @Override
        public void m1() {

        }
    }

    public static void main(String[] args) {
        A a= new A();
        B b = new B();

        I1 i1 = b;
        I2 i2 = (I2) a;
        I3 i3 = b;
        a= b;


/*
        -- 코드를 입력하세요
        SELECT a.id as USER_ID, count(c.PURCHASE_DATE) as PURCHASE_COUNT, nvl(sum(b.price), 0) as TOTAL_PRICE
        from game_users a, characters b, purchases c
        where a.id = c.user_id(+)
        and c.item = b.name(+)
        group by a.id
        order by a.id
*/

    }

}
