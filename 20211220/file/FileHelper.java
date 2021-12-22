package loginpro.file;

import java.io.*;

public class FileHelper {
	// 主要负责文件的读写
	private static String address;
	private static FileInputStream fis = null;
	private static FileOutputStream fos = null;
	private static FileReader fr = null;
	private static FileWriter fw = null;
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;

	public static String getAddress() {
		return FileHelper.address;
	}

	public static void setAddress(String address) {
		FileHelper.address = address;
	}

	public static FileInputStream getFileInputStream() throws IOException {
		fis = new FileInputStream(address);
		return fis;
	}

	public static FileOutputStream getFileOutputStream() throws IOException {
		fos = new FileOutputStream(address);
		return fos;
	}

	public static void closeFileInputStream() throws IOException {
		if (fis != null) {
			fis.close();
		}
	}

	public static void closeFileOutputStream() throws IOException {
		if (fos != null) {
			fos.close();
		}
	}

	public static BufferedReader getBufferedReader() throws FileNotFoundException, IOException {
		File f = new File(address);
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		return br;
	}

	public static BufferedWriter getBufferedWriter() throws FileNotFoundException, IOException {
		File f = new File(address);
		fw = new FileWriter(f);
		bw = new BufferedWriter(fw);
		return bw;
	}

	public static void closeBufferedReader() throws IOException {
		if (br != null)
			br.close();
		if (fr != null) {
			fr.close();
		}
	}

	public static void closeBufferedWriter() throws IOException {
		if (bw != null)
			bw.close();
		if (fw != null)
			fw.close();
	}
}
