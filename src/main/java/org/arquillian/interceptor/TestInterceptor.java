package org.arquillian.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.arquillian.annotation.SampleInterceptor;

@Interceptor
@SampleInterceptor
public class TestInterceptor {
	@AroundInvoke
	public Object obj(InvocationContext ic) throws Exception {

		// メソッド実行前
		System.out.println("process start class :" + ic.getTarget().getClass().getSimpleName()
				+ " method:" + ic.getMethod().getName());

		// メソッド実行
		Object result = ic.proceed();

		// メソッドの実行後
		System.out.println("process end");

		return result;
	}
}
