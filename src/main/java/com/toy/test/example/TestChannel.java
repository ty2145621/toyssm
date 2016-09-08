package com.toy.test.example;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by toy on 2016/8/31.
 */
public class TestChannel {
    public void xiaxie() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("d:/text.ini", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        int byteRead = inChannel.read(buf);

        while(byteRead != -1) {
            buf.flip();
            while(buf.hasRemaining()) {
                System.out.println((char) buf.get());
            }

            buf.clear();
            byteRead = inChannel.read(buf);
        }
        aFile.close();

    }

    @Test
    public void testSocketChannel() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        /*while(! socketChannel.finishConnect() ) {
            //wait, or do something else...
        }*/
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buf);

        buf.flip();
        while(buf.hasRemaining()) {
            System.out.println((char) buf.get());
        }
    }
}
