package leetcode;
/** 문제 : https://leetcode.com/problems/first-bad-version/
 *  레벨 : easy
 *  결과 : 해결(runtime faster than 66.23%, memory less than 5.45%)
 * */
public class firstBadVersion {

    public static boolean isBadVersion(int version){
        if(version >= 1702766719)
            return true;
        return false;
    }

    public static int firstBadVersion(int n) {

        long start = 0;
        long end = n;
        long bad = 0;

        while(start <= end){
            long mid = (start + end) / 2;

            if(isBadVersion((int)mid)){
                bad = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;

            }
        }
        return (int)bad;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
}
