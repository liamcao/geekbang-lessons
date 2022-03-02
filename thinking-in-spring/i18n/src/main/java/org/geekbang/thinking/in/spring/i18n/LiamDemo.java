package org.geekbang.thinking.in.spring.i18n;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.function.Supplier;

public class LiamDemo {
    public static void main(String[] args) {
//        testAssignable();
        String gensalt = BCrypt.gensalt(10);
        System.out.println(gensalt);
        System.out.println(BCrypt.gensalt(30));
        String hashpw = BCrypt.hashpw("123abc", gensalt);
        System.out.println(hashpw);
        System.out.println(BCrypt.hashpw("123abc", hashpw));
        System.out.println("=====");
        boolean checkpw = BCrypt.checkpw("123abc", hashpw);
        System.out.println(checkpw);


        BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123abc");
        System.out.println(encode);
        boolean matches = passwordEncoder.matches("123abc", encode);
        System.out.println(matches);

//        ArrayList<?> objects = new ArrayList<>();
//        Object o = objects.get(1);
//        System.out.println(o);

        
    }

    private static void testAssignable() {
        A a = new A();
        B b = new B();
        A ba = new B();
        System.out.println("1-------------");
        System.out.println(A.class.isAssignableFrom(a.getClass()));
        System.out.println(B.class.isAssignableFrom(b.getClass()));
        System.out.println(A.class.isAssignableFrom(b.getClass()));
        System.out.println(B.class.isAssignableFrom(a.getClass()));
        System.out.println(A.class.isAssignableFrom(ba.getClass()));
        System.out.println(B.class.isAssignableFrom(ba.getClass()));
        System.out.println("2-------------");
        System.out.println(a.getClass().isAssignableFrom(A.class));

        System.out.println(a.getClass().isAssignableFrom(B.class));
        System.out.println(b.getClass().isAssignableFrom(A.class));
        System.out.println(ba.getClass().isAssignableFrom(A.class));
        System.out.println(ba.getClass().isAssignableFrom(B.class));
        System.out.println("3-------------");
        System.out.println(Object.class.isAssignableFrom(b.getClass()));
        System.out.println(Object.class.isAssignableFrom("abc".getClass()));
        System.out.println("4-------------");
        System.out.println("a".getClass().isAssignableFrom(Object.class));
        System.out.println("abc".getClass().isAssignableFrom(Object.class));
    }


    static class A {
    }

    static class B extends A {
    }
}
