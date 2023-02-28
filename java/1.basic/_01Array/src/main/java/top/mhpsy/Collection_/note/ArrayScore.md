# ArrayScore

看ArrayList的源码首先看一下new ArrayList()的时候做了什么

```java
List<Integer> list=new ArrayList<>();
```

-----------------------
**1.new ArrayList()的时候，会调用无参构造函数**

```java
public ArrayList(){
        this.elementData=DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }
```

其中的`DEFAULTCAPACITY_EMPTY_ELEMENTDATA`是一个空数组，长度为0

```java
private static final Object[]DEFAULTCAPACITY_EMPTY_ELEMENTDATA={};
```

**2.调用AbstractList的构造函数**

```java
protected AbstractList(){
        }
```

这里实际上什么都没做，就是new的时候常规运行了父类的构造方法，提一下，这里的`AbstractList`是`List`的一个抽象类，`ArrayList`
是`List`的一个实现类

```java
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
}
```

**3.调用AbstractCollection的构造函数**

```java
public abstract class AbstractCollection<E> implements Collection<E> {
    protected AbstractCollection() {
    }
}
```

这里实际上什么都没做，就是new的时候常规运行了父类的构造方法，提一下，这里的`AbstractCollection`是`Collection`的一个抽象类,
`ArrayList`是`Collection`的一个实现类

**4.调用Object的构造函数**

```java
public Object(){
        }
```

没什么好说的

**5.初始化modCount**

```java
protected transient int modCount=0;
```

这个是用来记录修改次数的

> 到这里，我们就可以知道，new ArrayList()的时候，实际上是new了一个空数组(elementData)，长度为0，然后初始化了一个modCount

-----------------------
**6.调用add()方法**

```java
        for(int i=0;i< 10;i++){
        list.add(i);
        }
```

这里调用了add()方法，看一下add()方法做了什么

_这里跳过Integer的构造函数，直接看ArrayList的add()方法_

```java
    public boolean add(E e){
        modCount++;//记录修改次数++
        add(e,elementData,size);//调用真正的add()方法
        return true;
        }
```

**7.调用真正的add()方法**

```java
    private void add(E e,Object[]elementData,int s){
        if(s==elementData.length)
        elementData=grow();
        elementData[s]=e;
        size=s+1;
        }
```

`add(E e, Object[] elementData, int s)`先说着三个参数

1. e:要添加的元素
2. elementData:ArrayList的数组
3. s:数组的长度

因为这个时候很明显`s=0`，这里的`elementData.length`也是0，所以会调用`grow()`方法

**8.调用grow()方法**

```java
    private Object[]grow(){
        return grow(size+1);
        }
```

这里的`size+1`就是1，所以会调用`grow(int minCapacity)`方法

**9.调用grow(int minCapacity)方法**

```java
    private Object[]grow(int minCapacity){
        int oldCapacity=elementData.length;
        if(oldCapacity>0||elementData!=DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
        int newCapacity=ArraysSupport.newLength(oldCapacity,
        minCapacity-oldCapacity, /* minimum growth */
        oldCapacity>>1           /* preferred growth */);
        return elementData=Arrays.copyOf(elementData,newCapacity);
        }else{
        return elementData=new Object[Math.max(DEFAULT_CAPACITY,minCapacity)];
        }
        }
```

`minCapacity`就是最小的容量，上面传入的是`size+1`，也就是1，`oldCapacity`就是原来的容量，这里是0，所以会执行else

因为这里的`minCapacity`是1，`oldCapacity`是0，所以会执行`else`语句
也就是`return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];`

**10.扩容成功，回到add()方法**

```java
    private void add(E e,Object[]elementData,int s){
        if(s==elementData.length)
        elementData=grow();//此时的elementData已经是扩容后的数组了，也就是十个空数组
        elementData[s]=e;//s=0，赋值第一个元素
        size=s+1;
        }
```

**11.赋值成功，回到add()方法**

```java
    public boolean add(E e){
        modCount++;//记录修改次数++
        add(e,elementData,size);//调用真正的add()方法
        return true;
        }
```

最后`return true`，`add()`方法结束

-----------------------

上面说的初始化第一个元素的时候做了什么，其实扩容的时候也做了一些事情，具体就是看`grow()`方法

```java
    private Object[]grow(int minCapacity){
        int oldCapacity=elementData.length;
        if(oldCapacity>0||elementData!=DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
        int newCapacity=ArraysSupport.newLength(oldCapacity,
        minCapacity-oldCapacity, /* minimum growth */
        oldCapacity>>1           /* preferred growth */);
        return elementData=Arrays.copyOf(elementData,newCapacity);
        }else{
        return elementData=new Object[Math.max(DEFAULT_CAPACITY,minCapacity)];
        }
        }
```

扩容的时候这个会为真`if(oldCapacity>0||elementData!=DEFAULTCAPACITY_EMPTY_ELEMENTDATA)`

所以会通过`ArraysSupport.newLength`计算新的容量

```java
    public static int newLength(int oldLength,int minGrowth,int prefGrowth){
        // preconditions not checked because of inlining
        // assert oldLength >= 0
        // assert minGrowth > 0

        int prefLength=oldLength+Math.max(minGrowth,prefGrowth); // might overflow
        if(0<prefLength &&prefLength<=SOFT_MAX_ARRAY_LENGTH){
        return prefLength;
        }else{
        // put code cold in a separate method
        return hugeLength(oldLength,minGrowth);
        }
        }
```

int oldLength, int minGrowth, int prefGrowth这三个参数分别是旧的长度，最小增长，首选增长。
如果`prefLength`小于`SOFT_MAX_ARRAY_LENGTH`，就返回`prefLength`，否则就调用`hugeLength`方法，
并且传入`oldLength`和`minGrowth`两个参数。

一般情况下都是`return oldLength+Math.max(minGrowth,prefGrowth)`
这里的prefGrowth是`oldCapacity>>1`，也就是`oldCapacity/2`,
所以默认情况下就是扩容1.5倍
