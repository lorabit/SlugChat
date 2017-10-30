package main.java.com.lorabit;

import com.google.inject.Guice;
import com.lorabit.TestProto.*;

/**
 * Created by lorabit on 2017/7/26.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("Hello World!");
        ContactInfo contactInfo = ContactInfo.newBuilder().setName("asdf").build();
        System.out.println(contactInfo.getName());

    }
}
