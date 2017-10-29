package test.IO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF 
{
	public static void main(String[] args) 
	{
		try 
		{
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("H:\\Data.txt")));
			while(in.available() != 0)
			{
				System.out.print((char)in.readByte());
			}
		}
		catch(IOException e) 
		{
			System.err.println("IOException");
		}
	}
}
