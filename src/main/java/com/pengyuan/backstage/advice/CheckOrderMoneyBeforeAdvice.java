package com.pengyuan.backstage.advice;

import com.pengyuan.backstage.bean.Order;
import com.pengyuan.backstage.exception.MoneyException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/7/22 - 18:53
 */
@Component
@Aspect
public class CheckOrderMoneyBeforeAdvice {

    @Pointcut("execution(* com.pengyuan.backstage.service.impl.OrderServiceImpl.insOrder(..))")
    public void insOrder(){}

    @Pointcut("execution(* com.pengyuan.backstage.service.impl.OrderServiceImpl.updOrder(..))")
    public void udpOrder(){}

    @Before("insOrder()")
    public void insOrderBefore(JoinPoint jp) throws MoneyException {

        Object[] args = jp.getArgs();

        if( args != null && args.length > 0 ){

            Order order = (Order) args[0];

            checkMoney(order);
        }
    }

    /**
     *      进行订单的  里面的   单价和数目  和金额的数据验证
     * @param order
     * @throws MoneyException
     */
    public void checkMoney(Order order) throws MoneyException {

        long price = order.getPrice();

        int number = order.getNumber();

        long money = order.getMoney();

        if( price*number != money ){
            throw new MoneyException("提交的订单里面的单价和数目与总金额不统一");
        }
    }

    @Before("udpOrder()")
    public void updOrderBefore(JoinPoint jp) throws MoneyException {

        Object[] args = jp.getArgs();

        if( args != null && args.length > 0 ){

            Order order = (Order) args[0];
            checkMoney(order);
        }
    }
}
