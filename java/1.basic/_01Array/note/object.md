# object.md

## 访问修饰符

----

|    修饰符    | 类内部 | 同一个包 | 子类  | 其他包 |
|:---------:|:---:|:----:|:---:|:---:|
|  public   |  Y  |  Y   |  Y  |  Y  |
| protected |  Y  |  Y   |  Y  |  N  |
|  default  |  Y  |  Y   |  N  |  N  |
|  private  |  Y  |  N   |  N  |  N  |

其实一般情况下，我们只用到了public和private两种修饰符，protected和default修饰符很少用到。

protected修饰符的作用是，让子类可以访问父类的成员变量和成员方法

## 继承

1. 子类继承了所有父类的成员变量和成员方法，但是不能继承父类的构造方法
2. 子类在创造一个对象的时候一定会调用父类的构造方法，如果没有显式的调用父类的构造方法，那么编译器会自动调用父类的无参构造方法
3. 如果父类没有无参构造方法，那么子类必须显式的调用父类的有参构造方法，否则编译不会通过
4. super()和this()都必须放在构造方法的第一行，因为它们都是用来调用构造方法的，不能共存
5. Object类是所有类的父类，所有类都继承了Object类的方法，Object类的方法可以被所有类使用
6. 父类的调用不限于直接父类，可以是间接父类，只要是继承关系就会被调用，直到Object类
7. java是单继承的，一个类只能继承一个父类，但是可以多重继承，即一个子类可以继承多个父类的成员变量和成员方法

```java
class GrandFather {
    String name = "GrandFather";
}

class Father extends GrandFather {
    String name = "Father";
}

class Son extends Father {
    String name = "Son";
}
```

![img.png](img.png)
其实这里也就是一种作用域链的问题，当我们调用一个变量的时候，首先会在当前类中查找，如果没有找到，那么就会去父类中查找，如果还没有找到，那么就会去父类的父类中查找，直到Object类，如果还没有找到，那么就会报错。

### super关键字

super关键字可以用来调用父类的成员变量和成员方法，也可以用来调用父类的构造方法

|  super关键字  | 作用 |
|:---------:|:---:|
| super()   | 调用父类的构造方法 |
| super.成员变量 | 调用父类的成员变量 |
| super.成员方法 | 调用父类的成员方法 |

### this关键字

this关键字可以用来调用本类的成员变量和成员方法，也可以用来调用本类的构造方法

|  this关键字  | 作用 |
|:---------:|:---:|
| this()   | 调用本类的构造方法 |
| this.成员变量 | 调用本类的成员变量 |
| this.成员方法 | 调用本类的成员方法 |

### this和super的区别

| 区别点 | this |   super   | 
|:---:|:---:|:---------:|
| 访问属性 | 访问本类的属性，如果本类没有，就会去父类中查找 | 从父类开始查找方法 |
| 访问方法 | 访问本类的方法，如果本类没有，就会去父类中查找 | 从父类开始查找方法 |
| 访问构造方法 | 调用本类构造器，必须放在第一行 | 调用父类构造器，必须放在第一行 |
| 特殊 | 表示当前对象 | 表示父类对象 |

## 重写(override)

> 简单来说，就是子类重写了父类的方法，具有相同的返回值类型、方法名、参数列表，这就是重写

### 细节

1. 子类方法的返回值类型必须小于等于父类方法的返回值类型，也就是说子类方法的返回值类型可以是父类方法的返回值类型的子类
2. 子类方法的访问权限必须大于等于父类方法的访问权限，也就是说子类不能缩小父类的访问权限

## 重载

> 简单来说，就是在同一个类中，方法名相同，参数列表不同，这就是重载

### 重写和重载的区别

| 区别点 | 重写 | 重载 |
|:---:|:---:|:---:|
| 参数列表 | 参数列表必须相同 | 参数列表可以不同 |
| 返回值类型 | 返回值类型必须相同 | 返回值类型可以不同 |
| 访问权限 | 访问权限必须大于等于父类方法的访问权限 | 访问权限可以不同 |
| 作用 | 重写父类的方法 | 重载父类的方法 |

## 多态(polymorphism)

> 多态是指同一个对象在不同的情况下表现出不同的状态
> 多态的前提是继承或者实现，多态的表现形式有两种：重写和重载

### 方法的多态

1. 方法的多态是指子类重写了父类的方法，当我们调用子类的方法的时候，实际上是调用了子类重写的方法
2. 方法的多态是编译时多态，也就是说多态的表现形式是在编译的时候就确定下来了，而不是在运行的时候才确定下来的
3. 方法的多态是通过方法的重写实现的
4. 方法的多态是通过父类的引用指向子类的对象实现的

```java
class Animal {
    public void eat() {
        System.out.println("动物吃东西");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
    }
}
```

### 对象的多态

1. 对象的多态是指父类的引用指向子类的对象，这样的话，我们调用父类的方法的时候，实际上是调用了子类重写的方法
2. 对象的多态是运行时多态，也就是说多态的表现形式是在运行的时候才确定下来的
3. 对象的多态是通过方法的重写实现的
4. 对象的多态是通过父类的引用指向子类的对象实现的
5.

```java
class Animal {
    public void eat() {
        System.out.println("动物吃东西");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃肉");
    }
}

class Pig extends Animal {
    public void eat() {
        System.out.println("猪吃饲料");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();
        a = new Dog();
        a.eat();
        a = new Pig();
        a.eat();
    }
}
```

> 对象的多态基本就是java的核心了

1. 一个对象的编译类型和运行类型可以不一样
2. 编译类型在定义对象时，就确定了，不能改变
3. 运行类型是可以变化的
4. **编译类型看定义时 = 号左边，运行类型看 = 号右边**

### 向上转型

1. 本质：父类的引用指向子类的对象
2. 语法：父类类型 变量名 = new 子类类型();
3. 特点：编译类型看左边，运行类型看右边
4. 可以调用父类中的所有”东西“
5. 不能调用子类中特有的”东西“

### 向下转型

1. 本质：子类的引用指向父类的对象
2. 语法：子类类型 变量名 = (子类类型) 父类类型的变量名;
3. 只能强转父类的引用，不能强转父类的类型
4. 要求父类的引用必须指向的是当前目标类型的对象
5. 向下转型之后，可以调用子类中的所有”东西“

### instanceof

instance of 是一个二元操作符，左边是一个对象，右边是一个类，如果左边的对象是右边的类的实例，那么返回true，否则返回false
。具体是在判断对象的运行类型是不是XX类型或XX的子类型。

## 代码块

1. 普通代码块： 类中方法的方法体
2. 构造代码块： 构造块会在创建对象时被调用，每次创建时都会被调用，优先于类构造函数执行。
3. 静态代码块： 用static{}包裹起来的代码片段，只会执行一次。静态代码块优先于构造块执行。
4. 同步代码块： 使用synchronized（）{}包裹起来的代码块，在多线程环境下，对共享数据的读写操作是需要互斥进行的，否则会导致数据的不一致性。同步代码块需要写在方法中。

### 静态代码块和构造代码块的异同点

相同点：都是JVM加载类后且在构造函数执行之前执行，在类中可定义多个， 一般在代码块中对一些static变量进行赋值。
不同点：静态代码块在非静态代码块之前执行。静态代码块只在第一次new时执行一次，之后不在执行。而非静态代码块每new一次就执行一次。

## 抽象类

```java
abstract class 类名 {
    // 抽象方法
    public abstract void method();
}
```

### 抽象类的特点

1. 抽象类不能被实例化
2. 抽象类中可以有构造方法，但是不能被实例化
3. 抽象类中可以有非抽象方法
4. 抽象类中可以有抽象方法
5. 抽象类中的抽象方法必须被子类重写

### 抽象类的作用

1. 抽象类可以被继承，子类可以重写抽象类中的方法
2. 抽象类可以被继承，子类可以继承抽象类中的非抽象方法

## 接口

```java
interface 接口名 {
    // 常量
    public static final int NUM = 10;

    // 抽象方法
    public abstract void method();
}
```

> 类似于usb接口，鼠标，键盘，摄像头都可以插在usb接口上，但是鼠标，键盘，摄像头的功能不一样，所以鼠标，键盘，摄像头都要实现usb接口

### 接口的特点

1. 接口不能被实例化
2. 接口中可以有常量，但是必须是public static final的
3. 接口中可以有抽象方法，但是必须是public abstract的
4. 接口中可以有非抽象方法，但是必须是public static final的

## 匿名内部类

```java
new 类名或接口名(){
// 重写方法
public void method(){
        // 方法体
        }
        }
```

### 匿名内部类的特点

1. 匿名内部类必须继承一个类或者实现一个接口
2. 匿名内部类不能有构造方法
3. 匿名内部类不能有静态代码块和静态方法
4. 匿名内部类不能有访问修饰符(public, private, protected)

```java
Animal Anonymous=new Animal(){
@Override
public void eat(){
        System.out.println("eat");
        }
        };
        Anonymous.eat();
        System.out.println(Anonymous.getClass());
        System.out.println(Anonymous.getClass().getName());

//class top.mhpsy.anonymousInnerClass.anonymousInner1$1
//top.mhpsy.anonymousInnerClass.anonymousInner1$1
interface Animal {
    public void eat();
}
```

## 内部类

> 没什么好说的，就是一个类里面套一个类，这个类可以访问外部类的东西

### 成员内部类

```java
class Outer {
    private int num = 10;

    class Inner {
        public void show() {
            System.out.println(num);
        }
    }
}
```

## 枚举

```java
enum SEA2 {
    SPRING("春天", "春暖花开"), SUMMER("夏天", "夏日炎炎"), AUTUMN("秋天", "秋高气爽"), WINTER("冬天", "冰天雪地");

    private String name;
    private String desc;

    private SEA2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SEA2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
```

枚举反编译之后：

```java
final class top.mhpsy.enum_.SEA2 extends java.lang.Enum<top.mhpsy.enum_.SEA2>{
public static final top.mhpsy.enum_.SEA2 SPRING;
public static final top.mhpsy.enum_.SEA2 SUMMER;
public static final top.mhpsy.enum_.SEA2 AUTUMN;
public static final top.mhpsy.enum_.SEA2 WINTER;
public static top.mhpsy.enum_.SEA2[]values();
public static top.mhpsy.enum_.SEA2 valueOf(java.lang.String);
public java.lang.String getName();
public java.lang.String getDesc();
public java.lang.String toString();
static {};
        }
```

> 可以发现枚举实际也是一个类，只不过是一个特殊的类，它的子类只能有有限个，而且子类的实例在程序运行期间，只会创建一次。枚举类的构造方法只能使用private修饰。
> 跟自己实现的没有什么区别，只是多了一个values()和valueOf()方法，values()
> 方法返回的是一个数组，包含了所有的枚举实例，valueOf()方法返回的是指定名称的枚举实例。

> 简单来说就是使用enum关键字就会隐式的继承java.lang.Enum类
> java.lang.Enum类实现了java.lang.Serializable和java.lang.Comparable接口
> 所以枚举类默认是可序列化的，而且枚举类的实例是有序的，可以使用compareTo()方法进行比较。

枚举的toString：

```java
public String toString(){
        return name;
        }
```

### 使用枚举
```java
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
```

## 注解
三个基本的注解：@Override、@Deprecated、@SuppressWarnings
1. @Override：检测被该注解标注的方法是否是继承自父类(接口)的，只能用于方法
2. @Deprecated：表示已过时
3. @SuppressWarnings：抑制编译器警告

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
```

> 上面就是override的源码，可以看到它是一个接口，而且它的注解类型是METHOD，表示只能用于方法上，
> 而且它的注解保留策略是SOURCE，表示只在源码阶段保留，编译成class文件后就会被抛弃。



