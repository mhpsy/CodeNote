Java中的Hashtable和HashMap都是用于存储key-value键值对的数据结构，它们的主要区别在于它们的线程安全性、null键值对的处理方式以及迭代器的遍历顺序。

线程安全性
Hashtable是线程安全的，因为它的所有方法都是同步的，可以在多线程环境下使用，但这也使得Hashtable的性能相对较低。而HashMap则不是线程安全的，如果在多线程环境下使用，需要进行额外的同步处理。

null键值对的处理方式
Hashtable不允许null作为键或值，如果尝试将null键或值放入Hashtable中，会抛出NullPointerException异常。而HashMap允许null作为键或值，但需要注意的是，如果将null作为键放入HashMap中，则只能使用get方法获取它，因为null无法计算hash值。

迭代器的遍历顺序
Hashtable的迭代器遍历元素的顺序是没有明确规定的，因此不可预测。而HashMap则保证迭代器遍历元素的顺序是以插入顺序或者某种其他的顺序进行的。

总的来说，如果不需要在多线程环境下使用，且可以接受null键值对时，推荐使用HashMap。如果需要线程安全性，或者不允许出现null键值对，可以选择使用Hashtable。