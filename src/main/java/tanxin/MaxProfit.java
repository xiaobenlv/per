package tanxin;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int total=0;
        for (int i=0;i<prices.length-1;i++){
//            注意数组越界的问题，因为取到了有i+1这个变量，所以 对应 i+1<prices.length i<prices.length-1;
            if (prices[i+1]>prices[i]){
                total+=prices[i+1]-prices[i];
            }
        }


        return total;

    }

    public static void main(String[] args) {
        int[] prices={1,2,3,4,5};
        MaxProfit maxProfit=new MaxProfit();
        int i=maxProfit.maxProfit(prices);
        System.out.println(i);

    }

}
