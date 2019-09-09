package com.vcc.recipe.util;


import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

public class SecretUtil {
    
    /*md5 一次加密*/
    public static String md5(String value){
        String md5DigestAsHex = DigestUtils.md5DigestAsHex( value.getBytes() );
        return md5DigestAsHex ;
    }
    
    /*value+盐 一次加密*/
    public static String md5AtSalt(String value,String salt){
        String result = value + salt;
        return md5( result );
    }
    
    public static String base64Encode(String value){
        byte[] encode = new byte[0];
        try {
            encode = Base64.getEncoder().encode( value.getBytes("UTF-8") );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new String( encode );
    }
    
    public static List<String> lengthOnStr(Integer length, String value){
        StringBuffer stringBuffer = new StringBuffer(value);
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < length-1; i++) {
            int anInt = random.nextInt( stringBuffer.length() - (length - i) );
            String substring = stringBuffer.substring( 0, anInt );
            buffer.append( (char)(anInt+96) );
            arrayList.add( substring );
            stringBuffer.delete( 0,anInt );
        }
        stringBuffer.append( buffer.toString() );
        arrayList.add( stringBuffer.toString() );
        return arrayList ;
    }
    
    private static String createToken(String identifier,String value){
        String md5 = md5( value );
        List<String> stringList = lengthOnStr( identifier.length(), md5 );
        String string = new String();
        for (int i = 0; i < identifier.length(); i++) {
            String substring = identifier.substring( i, i + 1 );
            String s = stringList.get( i );
            string = string+substring+s ;
        }
        String base64Encode = base64Encode( string );
        Integer length = base64Encode.length() ;
        Integer number = length/3 ;
        String substring1 = base64Encode.substring( 0, number+1);
        String substring2 = base64Encode.substring( number + 1, number * 2 + 1 );
        String substring3 = base64Encode.substring( number * 2 + 1, length );
        return substring3+substring1+substring2 ;
        
    }
    
    public static String setIdentifier(String identifier){
        String value = "RC"+System.currentTimeMillis();
        String md5 = md5( value );
        String token = createToken( identifier, md5 );
        return token ;
    }
    
    public static String getIdentifier(String token){
        try {
            int number = token.length()/3;
            String substring2 = token.substring( token.length() - number-1, token.length() );
            String substring1 = token.substring( token.length()-number*2-1,token.length() - number-1 );
            String substring3 = token.substring( 0, token.length() - number * 2-1 );
            String res = substring1+substring2+substring3 ;
            String base64Decode = base64Decode( res );
            int length = (base64Decode.length() - 31) / 2;
            String substring = base64Decode.substring( base64Decode.length() - length+1, base64Decode.length() );
            String result = base64Decode.substring( 0  ,base64Decode.length()-length+1);
            StringBuilder builder = new StringBuilder( result );
            String string = new String(  );
            for (int i = 0; i <length-1 ; i++) {
                char b = substring.charAt( i );
                Integer integer = (int)b ;
                Integer index = integer-96 ;
                string = string+builder.substring(0,1) ;
                builder.delete( 0 ,index+1 );
            }
            string = string+builder.substring( 0,1);
            return string;
        }catch (Exception exception){
            return null ;
        }
    }
    
    public static String base64Decode(String value){
        byte[] decode = Base64.getDecoder().decode( value );
        return new String( decode );
    }
    
    
    
    
    
    
    public static void main(String[] args){

//        long currentTimeMillis = System.currentTimeMillis();
//        Integer i = 0 ;
//        String setIdentifier = setIdentifier( "1548" );
//        while (i<1000000){
//            String identifier = getIdentifier( setIdentifier );
//            i++;
//        }
//        long timeMillis = System.currentTimeMillis();
//        System.out.println(timeMillis-currentTimeMillis);
    }
    
    
    
}
