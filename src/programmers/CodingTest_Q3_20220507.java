package programmers;

// 100점
public class CodingTest_Q3_20220507 {

    /**
     *
     * -- 코드를 입력하세요
     * select date_format(created_at, '%H') as '시간대', count(*) as '결제 건수'
     * from CARD_USAGES
     * where category = 0
     * and date_format(created_at, '%H') between '10' and '15'
     * group by date_format(created_at, '%H')
     * order by date_format(created_at, '%H')
     *
     *
     *
     * */
}
