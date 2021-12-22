package system.file;
import java.io.*;
import system.bean.*;
public class FileHelper {
	//׼���ļ���ַ
	private static String address;
	//׼����
	private static FileInputStream fis = null;
	private static FileOutputStream fos = null;
	private static FileReader fr = null;
	private static FileWriter fw = null;
	private static BufferedReader br= null;
	private static BufferedWriter bw= null;
	
	//�ļ���ַ����������
	public static String getAddress() {
		return FileHelper.address;
	}
	public static void setAddress(String address) {
		FileHelper.address = address;
	}
	
	//�õ��ֽ���
	public static FileInputStream getFileInputStream() throws IOException {
		fis = new FileInputStream(address);
		return fis;
	}
	public static FileOutputStream getFileOutputStream() throws IOException {
		fos = new FileOutputStream(address);
		return fos;
	}
	//�ر��ֽ���
	public static void closeFileInputStream() throws IOException {
		if(fis != null) {
			fis.close();
		}
	}
	public static void closeFileOutputStream() throws IOException {
		if(fos != null) {
			fos.close();
		}
	}
	
	//�õ��ַ���
	public static BufferedReader getBufferedReader() throws FileNotFoundException,IOException {
		File f = new File(address);
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		return br;
	}
	public static BufferedWriter getBufferedWriter() throws FileNotFoundException,IOException {
		File f = new File(address);
		fw = new FileWriter(f);
		bw = new BufferedWriter(fw);
		return bw;
	}
	//�ر��ַ���
	public static void closeBufferedReader() throws IOException {
		if(br != null)
			br.close();
		if(fr != null) {
			fr.close();
		}
	}
	public static void closeBufferedWriter() throws IOException{
		if(bw != null)
			bw.close();
		if(fw != null) 
			fw.close();
	}
	public static void wt(Bean b){
		try{
        File f = new File("data.txt");  
        if (!f.exists()) {  
            f.createNewFile();// 不存在则创建  
        }
        BufferedWriter output = new BufferedWriter(new FileWriter(f,true));//true,则追加写入text文本
		output.write("\r\n");//换行
        output.write(b.getId()+" "+b.getItem()+" "+b.getType()+" "+b.getMoney()+" "+b.getName()+" "+b.getTime());
        output.write("\r\n");//换行
        output.flush();    
        output.close();
	}catch(Exception e){}
    } 
}
