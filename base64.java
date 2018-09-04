package smartm2m;

import java.io.FileInputStream;
import java.io.IOException;

public class base64 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("data.bin");
		final char[] table = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+/".toCharArray();
		byte[] bs = new byte[3];
		String out = "";
		int num;
		while((num = fis.read(bs))>0){
			
			for(int i=0;i<num;i++)
				out += String.format("%08d", Integer.parseInt(Integer.toBinaryString(bs[i])));
			
			for(int i=0;i<3-num;i++)
				out += "00000000";
			
			for (int i = 0; i < num+1;i++)
				System.out.print(table[Integer.parseInt(out.substring(i*6, (i+1)*6),2)]);
			
			out="";
			if(num==2) System.out.println("=");
			if(num==1) System.out.println("==");
		}
		
		fis.close();
	}
}
