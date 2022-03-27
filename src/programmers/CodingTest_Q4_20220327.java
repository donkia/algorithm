package programmers;

// SQL 2번 문제 100점
public class CodingTest_Q4_20220327 {


    public static void main(String[] args) {

/*
        SELECT '0' AS "후기 수",COUNT(*) AS "공간 수"
        FROM (
                SELECT A.PLACE_ID, B.ID, NVL(COUNT(A.PLACE_ID), 0) AS CNT
                FROM PLACE_REVIEWS A, PLACES B
                WHERE B.ID = A.PLACE_ID(+)
                GROUP BY A.PLACE_ID, B.id
        )
        WHERE CNT = 0

        UNION ALL

        SELECT '< 50' AS "후기 수",COUNT(*) AS "공간 수"
        FROM (
                SELECT A.PLACE_ID, B.ID, NVL(COUNT(A.PLACE_ID), 0) AS CNT
                FROM PLACE_REVIEWS A, PLACES B
                WHERE B.ID = A.PLACE_ID(+)
                GROUP BY A.PLACE_ID, B.id
        )
        WHERE CNT > 0 AND CNT < 50

        UNION ALL

        SELECT '< 100' AS "후기 수",COUNT(*) AS "공간 수"
        FROM (
                SELECT A.PLACE_ID, B.ID, NVL(COUNT(A.PLACE_ID), 0) AS CNT
                FROM PLACE_REVIEWS A, PLACES B
                WHERE B.ID = A.PLACE_ID(+)
                GROUP BY A.PLACE_ID, B.id
        )
        WHERE CNT > 50 AND CNT < 100

        UNION ALL

        SELECT '>= 100' AS "후기 수",COUNT(*) AS "공간 수"
        FROM (
                SELECT A.PLACE_ID, B.ID, NVL(COUNT(A.PLACE_ID), 0) AS CNT
                FROM PLACE_REVIEWS A, PLACES B
                WHERE B.ID = A.PLACE_ID(+)
                GROUP BY A.PLACE_ID, B.id
        )
        WHERE CNT >= 100*/
    }
}
