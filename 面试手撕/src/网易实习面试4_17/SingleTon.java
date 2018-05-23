package 网易实习面试4_17;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 有点紧张，单例模式都记忆模糊  花了很久写出来一个 还少了最重要的static
 * 所以虽然知道可以写个最好的线程安全的， 还是因为记不清了 写了个最简单的 重点是 还忘了static
 */
public class SingleTon {


    //1.私有化构造函数
    private SingleTon(){}

    //2.设置静态变量
    private static SingleTon instance;

    //3.定义一个静态的方法（调用时再初始化SingletonTest，但是多线程访问时，可能造成重复初始化问题）
    private static SingleTon getInstance()
    {
        if (instance == null)
            return new SingleTon();
        return instance;
    }
}

class SingleTonBest{

    //1.私有化构造函数
    private SingleTonBest(){}

    //2.设置静态变量，此时因为要保证线程安全，需要使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用
    private static volatile SingleTonBest instance;

    //3.定义一个静态的方法  双重检测
    private static SingleTonBest getInstance()
    {
        if (instance == null)
        {
            synchronized (SingleTonBest.class)
            {
                if (instance == null)
                    instance = new SingleTonBest();
            }
        }
        return instance;
    }

}


class StaticSingleton{

    //定义初始化构造函数
    private StaticSingleton(){

    }

    //内部类，类初始化时，生成实例，且类初始化只发生一次
    //用private 声明，保证外部无法访问，并初始化它
    private static class SingleHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingleHolder.instance;
    }
}


