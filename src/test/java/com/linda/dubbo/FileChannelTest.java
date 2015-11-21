package com.linda.dubbo;

import java.io.IOException;
import java.nio.ByteBuffer;

public class FileChannelTest {
	
	public static void main(String[] args) throws IOException {
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		ByteBuffer buf1 = ByteBuffer.allocate(256);
		ByteBuffer buf2 = ByteBuffer.allocate(256);
		ByteBuffer buf3 = ByteBuffer.allocate(256);
		ByteBuffer buf4 = ByteBuffer.allocate(256);
		buffer.put(buf1);
		buffer.put(buf2);
		buffer.put(buf3);
		buffer.put(buf4);
		
	}

}
