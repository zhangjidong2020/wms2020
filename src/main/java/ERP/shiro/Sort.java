package ERP.shiro;

public class Sort {
    public static void main(String[] args) {
//        /*int[] a = {9,15,2,6,5,4,22,30};
//        int temp = 0;
//        for(int i = 0;i<a.length-1;i++){
//            for(int j = 0;j<a.length-i-1;++j){
//                if(a[j+1]<a[j]){
//                    temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
//            }
//        }
//        for(int k = 0; k<a.length;k++){
//            System.out.println(a[k]);
//        }*/
        for (int i = 1; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < 10; j++) {
                    for (int l = 0; l < 10; l++) {
                        int x = i * 10 * 10 * 10 + k * 10 * 10 + j * 10 + l;
                        System.out.println(x);
                    }
                }
            }
        }
    }
}
