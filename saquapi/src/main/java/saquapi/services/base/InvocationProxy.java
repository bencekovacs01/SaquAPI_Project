package saquapi.services.base;

import saquapi.database.DatabaseConnection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationProxy implements InvocationHandler {

    private final Object instance;

    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new InvocationProxy(obj));
    }

    public InvocationProxy(Object instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            DatabaseConnection.establishConnection();
            result = method.invoke(instance, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            DatabaseConnection.closeConnection();
        }
        return result;
    }
}