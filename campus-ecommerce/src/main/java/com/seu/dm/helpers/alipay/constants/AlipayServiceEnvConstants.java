

/**

 * Alipay.com Inc.

 * Copyright (c) 2004-2014 All Rights Reserved.

 */

package com.seu.dm.helpers.alipay.constants;


/**
 * 支付宝服务窗环境常量（demo中常量只是参考，需要修改成自己的常量值）
 * 
 * @author taixu.zqq
 * @version $Id: AlipayServiceConstants.java, v 0.1 2014年7月24日 下午4:33:49 taixu.zqq Exp $
 */
public class AlipayServiceEnvConstants {

    /**支付宝公钥-从支付宝生活号详情页面获取*/
	public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2zSvNzeRnEI1rJzb8fjwPu9qQpkTYoMpad1YOm5r5FcGv7JH9/qEnmr3xldcFDARw6iIdWMDMSwjz6NmxVLqqRK70q3OdoZi9ZkGfVMLseciTws6enhyFgdjJeP9R9koKoSqQrZ4prJ0JPAYJF5TID/5UYFhlH5ksMjwBylo6zadLAA9Al9e1cmZ6DJVKKE9d2IQVn1kfFcZzZBeMkV438o45VAVp1QXz+uHZizbgCjophA6S4xmcRujCWyc6+PWGjGM8vsBPazTygwEdaX6ov5Fl+jeoHqhsOpHBf26AJwCFTz8R1/39EeZFMY9GhUoyIabmEUJOqfI3LoOtnM38wIDAQAB";
    
    /**签名编码-视支付宝服务窗要求*/
    public static final String SIGN_CHARSET      = "GBK";

    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "GBK";

    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA2";
    
    /**开发者账号PID*/
    public static final String PARTNER           = "";

    /** 服务窗appId  */
    //TODO !!!! 注：该appId必须设为开发者自己的生活号id  
    public static final String APP_ID            = "2016080300158329";

    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患 
    public static final String PRIVATE_KEY       = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDDjWv/ePRa68vsxmaJUFBX7PiqELmsdFcRRY8P/lhpGXaFcL0jyFWRJEYL0AfUCQ3B5LSC1qFmdc4KhLcwIhsbNYhLVXp54vv2hTi6WuAFE9OLxf5ULS6XS18kCBrQIr+PzVnCUrwGbwj9vQFjeFDThHkxf3ItHtGjV1xpyQeyaEX833+b1hh+D2oaeGxL59Zlp5TZ577Sm55zQmORw+zZPWhke4PrZeXpildRwlsIwILSUlBtCfSZvLOl/uVEpInOYkmUMUqAuVVyYelxrPkO3ef6XD31v9MlRV6VmDdSTYbG2pDyke9RppRVAiteF0TZE+8nXjOuc2OX+M2rTplzAgMBAAECggEAX+v4BMm8+vhdAFjVpRdrQaXw1+L6YNh0ePlo0oyNq4gc9hm1/V5gcqCbZ2H05RJH2EsqLF/BrfOtTMWK4iZoq3EX2PQl7rHjrCnvCKJY7sSp6Q8G0R2UlAwZsB/1nxDcbFprZAGXT4SZoXVbwAIdi5OYqyn7xJwwcvIAV7ePefgFaYy/K0CqEmon/FXT4akOo0165SQzP0O/PVVs1ehYkuPAPo0wZOpbmJReKFe9J00w0QEpGgVQacOsG55pKQwsxDD4jf/J+S9H649IZdwg3XL7Gg8peGY+AOq6sxaX823ijz9kmcSFOBlbpJqlP9JTxK3kCzVqLniJaCp9qeAzQQKBgQD4AjLEbqVDQSi6bRjKfMNNdxImpDwaMpB4ztDNlUGWMC4bOk+/RhGDCtbFqp8wod26djEjLaPZmIGyyfsYNVWEtQ3/3fvAZiyO3YlC8WEGmvd1y3ZPGCQ0S6u8ccBr3XA4bYILRIC8WtVhfSpLXkxzcWVT8pQk+ptikqx+xZ3o4QKBgQDJ2oRmEELP0G35Oz5LpB3qN9qrvO+0C+6WEbp1MLtWOn47E9BvpsPYmgJghVlyw+FCvXl/iD6w6l/yWQdGWtzn1qNBVaBF/B6iAbh0YuAoDMZvyS/y5g0o4vmmvovCfVCh4ltVoJ2yoPN1k66cF2YyDIsfnPiVpsk3hlJ7L9So0wKBgQDqMjE8m3uGIf7S5PjXJa/L9Bf403hKCNuyqSI2MK7po3+2iH8MEZ+xzkd4C6Id64yVas0F+jBS55f6fI+Xka27Dro0l6wHSLTlCEB5LbVA5o+t9b83+4UcuSRoZEaf1VEGiCqYd0zWETSUxfxthZPOJBPajSTmMp0PHZC0eeqfIQKBgDAVugyGOyQ+RrRkhIaIZgfxnknjDEcbwI5HUt+v6DC2ZnO0WKcAVw82QPK1UYWhW/wGHvdegXCrpIea5bzA0Hb6DpH1z+RcFwAI4OP42eUwheUDTETUwLXIvCgYpDqEl7y4q4FObcKrzNNphuLwQAwUKOAzCJS90plDikqGLma5AoGBALymLMfGJC9qYvrDi21G56tM1hjECC9Y3Wcr+z63pYhTMgJFO50MfnCG8wNCSTPR3w2RKDr7WPhjisc4QihzUyGRHQSJOqXGXpjIT7xylgexoAcptwXmAyhxSTrcnGM4TROGRFpAseCq6jC6KVpSyn/RvI6+VpwM9DmEB7n4oyaK";
    
    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw41r/3j0WuvL7MZmiVBQV+z4qhC5rHRXEUWPD/5YaRl2hXC9I8hVkSRGC9AH1AkNweS0gtahZnXOCoS3MCIbGzWIS1V6eeL79oU4ulrgBRPTi8X+VC0ul0tfJAga0CK/j81ZwlK8Bm8I/b0BY3hQ04R5MX9yLR7Ro1dcackHsmhF/N9/m9YYfg9qGnhsS+fWZaeU2ee+0puec0JjkcPs2T1oZHuD62Xl6YpXUcJbCMCC0lJQbQn0mbyzpf7lRKSJzmJJlDFKgLlVcmHpcaz5Dt3n+lw99b/TJUVelZg3Uk2GxtqQ8pHvUaaUVQIrXhdE2RPvJ14zrnNjl/jNq06ZcwIDAQAB";
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipaydev.com/gateway.do";

    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";
}