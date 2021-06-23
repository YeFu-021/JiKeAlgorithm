package Unity1;

/*
    变长数组：当空间不够时，会申请2倍长度的数组连续空间，拷贝到新数组，释放旧空间
            若利用率不足25%，释放掉一半的空间
 */
public class ResizeableArray {
    int[] a =new int[5];
    int real_length=0;// 记录数组实际上用的长度
    // 当输入数组超出内含数组的长度时，进行扩容
    public ResizeableArray(int[] array) {
       while (a.length<array.length){
           this.a=bigger(a);
       }
       for(int i=0;i<array.length;i++){
           a[i]=array[i];
           real_length++;
       }
    }

    public void add(int i){
        if(real_length==a.length){
            this.a=bigger(a);
            a[real_length++]=i;
        }
        else a[real_length++]=i;
    }

    public void delete(int i){
//        for(int j=i;j<real_length;j++){
//            a[j-1]=a[j];
//        }
//        real_length--;
//        System.out.println("real_length = " + real_length);
//        if(a.length/real_length==4){
//            a=smaller(a,real_length);
//        }
    }

    /**
     * 扩容函数，若当前数组储存空间不够时，申请2倍长的数组连续空间
     * 拷贝数到新数组
     * @param array：操作数组
     */
    private static int[] bigger(int[] array){
        int length = array.length; // 获取当前旧数组的长度
        int[] b = new int[2*length];// 申请2倍长的数组连续空间
        // 拷贝
        for(int i=0;i<length;i++) {
            b[i] = array[i];
        }
        return b;
    }

    /**
     * 缩容函数，释放掉一半的空间
     * @param array：操作数组
     * @return
     */
    private static int[] smaller(int[] array,int real_length){
        int length=array.length;
        int[] b=new int[length/2];
        for(int i=0;i<real_length;i++){
            b[i]=array[i];
        }
        return b;
    }

    public void print(){
        System.out.println(a.length);
        for (int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
