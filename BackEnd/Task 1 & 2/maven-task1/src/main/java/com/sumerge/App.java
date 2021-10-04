package com.sumerge;

import org.apache.commons.codec.binary.Base64;

public class App 
{
    public static void main( String[] args )
    {
        String value = "HelloWorld";
        byte[] bytesEncoded = Base64.encodeBase64(value.getBytes());
        String result = new String(bytesEncoded);

        System.out.println(result);
    }
}
