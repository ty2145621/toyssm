package com.toy.test.example;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by toy on 2016/8/28.
 */
public class Miao {
    private int age = 20;
    private String name = "toy";

    public Miao(){}
    public Miao(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "age = " + age + "name = " + name;
    }

}