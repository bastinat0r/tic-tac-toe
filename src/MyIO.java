/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class MyIO {

	// objects ...
	public static void writeToFile(ArrayList<String> str0, String fName) {
		OutputStream fos = null;
		try {
			fos = new FileOutputStream(fName);
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(str0);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<String> readFromFile(String fName) {
		InputStream fis = null;
		ArrayList<String> str = new ArrayList<String>();	
		try {
			fis = new FileInputStream(fName);
			ObjectInputStream o = new ObjectInputStream(fis);
			str = (ArrayList<String>) o.readObject();
		} catch (EOFException e) {
			System.out.println(str.size() + " Strings read from " + fName);
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
		return str;
	}
}
