package tw.survival.util;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

public class SystemUtils {
	public static final String ENCODING = "BIG5";
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String HOST = "127.0.0.1";
	public static final String DB = "jdbcDB";
	public static final String USER = "root";
	public static final String PASSWORD = "password";
	public static final String URL = "jdbc:mysql://" + HOST + ":3306/" + SystemUtils.DB + "?user=" + SystemUtils.USER
			+ "&password=" + SystemUtils.PASSWORD + "&useSSL=true&useUnicode=yes&characterEncoding=UTF-8";

	// 本方法可以將SQL檔案組合成一個由SQL敘述組成的字串
	public static String readSQLFile(String filename) {
		try (FileInputStream fis = new FileInputStream(filename);
				InputStreamReader in = new InputStreamReader(fis, SystemUtils.ENCODING);
				BufferedReader br = new BufferedReader(in);) {
			String line = "";
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(line + " ");
			}
			return sb.toString();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// 若發生例外傳回null
		return null;
	}

	public static Clob fileToClob(String filename) {
		Clob clob = null;
		try (
			FileInputStream fis = new FileInputStream(filename);
			InputStreamReader in = new InputStreamReader(fis);
			CharArrayWriter caw = new CharArrayWriter();
		) {
			int len = 0;
			char[] ca = new char[8192];
			while ((len = in.read(ca)) != -1) {
				caw.write(ca, 0, len);
			}
			clob = new SerialClob(caw.toCharArray());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return clob;
	}

	
	public static Blob fileToBlob(String filename) {
		Blob blob = null;
		File f = new File(filename);
		int len = (int) f.length();
		byte[] b = new byte[len];
		try (
			FileInputStream fis = new FileInputStream(f);
		) {
			b = fis.readAllBytes();
			blob = new SerialBlob(b);
		} catch (Exception ex) {
			ex.getLocalizedMessage();
		}
		return blob;
	}
	
	public static void clobToFile(Clob comment, File file) {
		try (
		   Reader reader = comment.getCharacterStream();				
		   FileOutputStream fos = new FileOutputStream(file);
		   OutputStreamWriter osw = new OutputStreamWriter(fos);
		) {
			int len = 0 ;
			char[] c = new char[8192];
			while ((len=reader.read(c))!= -1){
				osw.write(c, 0, len);
			}
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public static void blobToFile(Blob picture, File file) {
		try (
		   InputStream is = picture.getBinaryStream();
		   OutputStream os = new FileOutputStream(file);
		) {
			byte[] b = new byte[81920];
			int len = 0 ;
			while ((len=is.read(b))!=-1){
				os.write(b, 0, len);
			}
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ================================================
	// 以下方法用處不大，考慮刪除
	// CLOB 公用程式: 將CLOB物件轉為字元陣列
	public static char[] clobToCharArray(Clob clob) {
		try (Reader rd = clob.getCharacterStream(); CharArrayWriter caw = new CharArrayWriter();) {
			char[] ca = new char[8192];
			int len = 0;
			while ((len = rd.read(ca)) != -1) {
				caw.write(ca, 0, len);
			}
			char[] output = caw.toCharArray();
			return output;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public static void saveCharsToFile(char[] comment, int placeId) {
		String folder = "D:\\_jdbc\\Java004";
		File dir = new File(folder);
		if (!dir.exists())
			dir.mkdirs();
		String filename = "comment" + placeId + ".txt";
		File file = new File(dir, filename);
		try (FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				PrintWriter pw = new PrintWriter(osw);) {
			pw.println(new String(comment));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public static void saveBytesToFile(byte[] picture, int placeId) {
		String folder = "D:\\_jdbc\\Java004";
		File dir = new File(folder);
		if (!dir.exists())
			dir.mkdirs();
		String filename = "picture" + placeId + ".png";
		File file = new File(dir, filename);
		try (FileOutputStream fos = new FileOutputStream(file);) {
			fos.write(picture);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static char[] fileToChars(String filename) {
		try (
			FileInputStream fis = new FileInputStream(filename);
			InputStreamReader in = new InputStreamReader(fis, "BIG5");
			CharArrayWriter caw = new CharArrayWriter();
		) {
			int len = 0;
			char[] ca = new char[8192];
			while ((len = in.read(ca)) != -1) {
				caw.write(ca, 0, len);
			}
			return caw.toCharArray();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static byte[] fileToBytes(String filename) {
	File f = new File(filename);
	int len = (int) f.length();
	byte[] b = new byte[len];
	try (FileInputStream fis = new FileInputStream(f);) {
		fis.read(b);
	} catch (Exception ex) {
		ex.getLocalizedMessage();
	}
	return b;
}	
	
}
