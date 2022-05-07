package programmers;


//100점
public class CodingTest_Q4_20220507 {

    /**
     *
     * -- 코드를 입력하세요
     * SELECT b.id, b.name, b.address, count(*) as count
     * from EMPLOYEES a, BRANCHES b, SELLINGS c
     * where a.branch_id = b.id
     * and a.id = c.employee_id
     * and b.address like '서울특별시%'
     * group by b.id, b.name, b.address
     * order by b.id
     *
     *
     *
     * */
}
