package saquapi.services.base;

import saquapi.database.DatabaseConnection;
import saquapi.services.dashboard.DashboardService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationProxy implements InvocationHandler {

    private final DashboardService instance;

    public static DashboardService newInstance(DashboardService obj) {
        return (DashboardService) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new InvocationProxy(obj));
    }

    public InvocationProxy(DashboardService instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            DatabaseConnection.estabilishConnection();
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