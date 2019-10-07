package de.rieckpil.blog.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@SecurePayment
public class BookPaymentInterceptor {

    @AroundInvoke
    public Object secureBookPayment(InvocationContext ctx) throws Exception {
        System.out.println("--- Intercepting: " + ctx.getMethod().getName());

        if (((String) ctx.getParameters()[0]).equalsIgnoreCase("Duke")) {
            ctx.setParameters(new Object[]{"Duke", 999});
        }

        return ctx.proceed();
    }
}
