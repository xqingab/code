public class test1 {

    public static void  get(int[] k){
        for (int i = 0; i <k.length-1 ; i++) {
            for (int j = i+1; j <k.length ; j++) {
                if(k[i]<k[j]){
                    int temp = k[i];
                    k[i] = k[j];
                    k[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] m = {33,23,12,56,78,90,45,23};
        get(m);
        for (int i = 0; i <3 ; i++) {
            System.out.println(m[i]);
        }
    }
}
