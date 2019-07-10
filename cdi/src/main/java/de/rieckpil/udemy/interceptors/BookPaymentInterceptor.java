package de.rieckpil.udemy.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@SecurePayment
public class BookPaymentInterceptor {

    @AroundInvoke
    public Object secureBookPayment(InvocationContext ctx) throws Exception {

        Object[] paymentParameters = ctx.getParameters();

        if ((paymentParameters[1]).equals("duke")) {
            throw new IllegalArgumentException("Duke is not allowed to buy our books");
        }

        return ctx.proceed();
    }
}
