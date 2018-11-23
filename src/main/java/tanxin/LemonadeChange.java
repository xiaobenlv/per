package tanxin;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count1=0;
        int count2=0;
        int count3=0;
        for (int i=0;i<bills.length;i++){
            if (bills[i]==5){
                count1++;
            }else if (bills[i]==10){
                count2++;
                if (count1<1){
                    return false;
                }
                count1--;
            }else {
//               分清楚一共多少中情况即可
                count3++;
                if (count2==0&&count1<3){
                    return false;
                }else if (count2>=1&&count1<1){
                    return false;
                }else if (count2==0&&count1>=3){
                    count1--;
                    count1--;
                    count1--;
                }else if (count2>=1&&count1>=1){
                    count1--;
                    count2--;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] bills={5,5,5,10,5,5,10,20,20,20};
        LemonadeChange lemonadeChange=new LemonadeChange();
        boolean b=lemonadeChange.lemonadeChange(bills);
        System.out.println(b);

    }

}
