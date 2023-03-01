# HashSetScore

```java
public class HashSetScore {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("java");
        hashSet.add("xxx");
        hashSet.add("java");
        System.out.println(hashSet);
    }
}
```

## 1.初始化HashSet

看HashSet的源码，分析new HashSet()的时候，做了什么

```java
public HashSet(){
        map=new HashMap<>();
        }
```

HashSet的构造方法，调用了HashMap的构造方法

```java
public HashMap(){
        this.loadFactor=DEFAULT_LOAD_FACTOR; // all other fields defaulted
        }
```

DEFAULT_LOAD_FACTOR = 0.75f

> 到这里，我们就知道了，HashSet的底层是HashMap，而且默认的加载因子是0.75f
> 这个时候，set就已经创建好了，但是里面没有元素

## 2.Set的add方法

```java
    public boolean add(E e){
        return map.put(e,PRESENT)==null;
        }
```

HashSet的add方法，调用了HashMap的put方法

```java
    public V put(K key,V value){
        return putVal(hash(key),key,value,false,true);
        }
```

可以发现，HashSet的add方法，调用了HashMap的put方法，而且传入了两个参数，一个是key，一个是value

```java
    static final Object PRESENT=new Object();
```

key是我们要添加的元素，value是一个常量`PRESENT`，`PRESENT`是一个Object类型的常量，就是一个空对象,并且是一个静态的常量

进入hash方法

```java
    static final int hash(Object key){
        int h;
        return(key==null)?0:(h=key.hashCode())^(h>>>16);
        }
```

没什么好说的，就是计算key的hash值，如果key是null，那么就返回0，如果不是null，那么就返回key的hashCode值

## 3.计算hash之后,进入putVal方法

```java
    final V putVal(int hash,K key,V value,boolean onlyIfAbsent,boolean evict){
        Node<K,V>[] tab;Node<K,V>p;int n,i;//一些辅助变量
        //table就是HasnMap的一个数组,类型是Node<K,V>[]
        if((tab=table)==null||(n=tab.length)==0)
            n=(tab=resize()).length;
        if((p=tab[i=(n-1)&hash])==null)
            tab[i]=new Node<>(hash,key,value,null);
        else{
            Node<K,V> e;K k;
            if(p.hash==hash&&((k=p.key)==key||(key!=null&&key.equals(k))))
                e=p;
            else if(p instanceof TreeNode)
                e=((TreeNode<K,V>)p).putTreeVal(this,tab,hash,key,value);
            else{
                for(int binCount=0;;++binCount){
                    if((e=p.next)==null){
                        p.next=new Node<>(hash,key,value,null);
                        if(binCount>=TREEIFY_THRESHOLD-1) // -1 for 1st
                            treeifyBin(tab,hash);
                        break;
                        }
                    if(e.hash==hash&&((k=e.key)==key||(key!=null&&key.equals(k))))
                        break;
                    p=e;
                    }
                }
            if(e!=null){ // existing mapping for key
                V oldValue=e.value;
                if(!onlyIfAbsent||oldValue==null)
                    e.value=value;
                afterNodeAccess(e);
                return oldValue;
                }
            }
        ++modCount;
        if(++size>threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
        }
```

### 3.1.判断table是否为空

```java
if((tab=table)==null||(n=tab.length)==0)
    n=(tab=resize()).length;
```
table是HashMap的一个数组，类型是Node<K,V>[]
如果table为空，那么就调用resize方法，resize方法的作用是扩容，返回一个新的数组，然后把新的数组赋值给table

### 3.2.resize()方法

```java
        final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;//这里的table就是HashMap的数组
        //因为我们这是第一个add的元素 所以这个table就是一个null transient Node<K,V>[] table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;//oldCap就是数组的长度 此时是0
        int oldThr = threshold;//oldThr就是阈值 此时是0
        int newCap, newThr = 0;//newCap就是新的数组的长度 newThr就是新的阈值
        if (oldCap > 0) {//如果oldCap大于0 说明数组已经初始化过了 还是因为我们这是第一个add的元素 所以这个if不会执行
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold 初始容量被置于阈值
            newCap = oldThr; // 这个大概只有在new HashSet<>(0, 0.75f)这种情况下才会执行 也就是说我们自己指定了初始容量和加载因子的时候才会执行
        else {               // zero initial threshold signifies using defaults 0初始阈值表示使用默认值
            newCap = DEFAULT_INITIAL_CAPACITY;  //因为上面的if都不会执行 所以这里的newCap就是默认的16 DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);//因为上面的if都不会执行 所以这里的newThr就是默认的12
        }
        if (newThr == 0) { //只有手动指定了初始容量和加载因子 并且是第一个add/put的时候才会执行这里
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;//把新的阈值赋值给threshold      int threshold;
        //因为我们这里的newTab是一个Node<K,V>[]类型的数组 但是我们new出来的是一个Node[]类型的数组
        @SuppressWarnings({"rawtypes","unchecked"})//这里是抑制警告 rawtypes是原始类型 unchecked是未检查的
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap]; //这里的newTab就是我们的新数组
        table = newTab;//把新数组赋值给table 接下来就会返回这个新数组
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;//上面的代码就是把原来的数组里的元素重新分配到新的数组里
        //如果是第一个add/put的话 那么oldTab就是null 所以这里的for循环就不会执行
    }
```

> 简单来说的话上面的resize方法的作用就是把原来的数组里的元素重新分配到新的数组里
> 
> 但是如果是第一个add/put的话就是新建一个Node<K,V>[]类型的数组 默认情况下是16个元素 0.75f就是加载因子

## 4.添加元素(重新回到put方法)
put方法接下来的代码是这个
```java
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);//最后一个null就是next 也就是下一个元素为空的意思
```
首先第一个if判断是判断table是否为空，如果为空就调用resize方法,
resize方法的作用是扩容，返回一个新的数组，然后把新的数组赋值给table,
但是这里的resize的返回值就是table，所以这里的tab就是table,n也就是数组的长度(16),
然后判断数组的第i个元素是否为空，如果为空就把新建的Node<K,V>类型的对象赋值给数组的第i个元素

`(p = tab[i = (n - 1) & hash]) == null`这段代码首先给i赋值,这个值是hash值对数组长度取余的结果,`((n - 1) & hash)就等价于(hash % n)`,效率会高一些
然后把数组的第i个元素赋值给p,然后判断p是否为空,如果为空就把新建的Node<K,V>类型的对象赋值给数组的第i个元素

newNode方法
```java
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
        }
```

newNode之后的tab[i]其实就已经有值了,但是这个值是一个Node<K,V>类型的对象,这个对象里面有key,value,next,hash等属性

## 5.添加完成返回

putVal方法最后是return null;
这里对应上了add方法

```java
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;//put调用putVal返回的是null就是添加成功
        //如果put调用putVal返回的不是null(返回oldValue)就是添加失败
    }
```










