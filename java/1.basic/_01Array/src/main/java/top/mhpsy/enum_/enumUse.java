package top.mhpsy.enum_;

public class enumUse {
    public static void main(String[] args) {
        SEA2 autumn = SEA2.AUTUMN;
        System.out.println(autumn);
        System.out.println(autumn.name());//AUTUMN
        System.out.println(autumn.ordinal());//2 从0开始 可以用来比较
        System.out.println(autumn.getDesc());//秋高气爽
        System.out.println(autumn.getName());//秋天
        System.out.println(autumn.values());//[Ltop.mhpsy.enum_.SEA2;@7cc355be
        System.out.println(autumn.values()[0]);//SPRING
        System.out.println(SEA2.values() == autumn.values());
        for (SEA2 value : autumn.values()) {
            System.out.println(value);
            /**
             * SEA2{name='春天', desc='春暖花开'}
             * SEA2{name='春天', desc='春暖花开'}
             * SEA2{name='夏天', desc='夏日炎炎'}
             * SEA2{name='秋天', desc='秋高气爽'}
             * SEA2{name='冬天', desc='冰天雪地'}
             */
        }
        SEA2 autumn1 = SEA2.valueOf("AUTUMN");//根据名字(字符串)获取枚举对象，没有会报错
        System.out.println(autumn1 == autumn);//true
        System.out.println(autumn1.name());//AUTUMN
        System.out.println(autumn1);//SEA2{name='秋天', desc='秋高气爽'}
        System.out.println(autumn1.compareTo(SEA2.SUMMER));//1 源码就是 return self.ordinal - other.ordinal;
    }
}
