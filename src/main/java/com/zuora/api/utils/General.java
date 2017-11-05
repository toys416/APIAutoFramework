package com.zuora.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

public class General {

	public static String MESSAGE;
	FileInputStream inStream = null;
	FileOutputStream outStream = null;

	// Get system time
	public static String getDatetime() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date.format(new Date());
	}

	// Copy Directory
	public static boolean copyDirectory(String srcDirName, String destDirName, boolean overlay) {
		// 判断源目录是否存在
		File srcDir = new File(srcDirName);
		if (!srcDir.exists()) {
			MESSAGE = "复制目录失败：源目录" + srcDirName + "不存在！";
			JOptionPane.showMessageDialog(null, MESSAGE);
			return false;
		} else if (!srcDir.isDirectory()) {
			MESSAGE = "复制目录失败：" + srcDirName + "不是目录！";
			JOptionPane.showMessageDialog(null, MESSAGE);
			return false;
		}

		// 如果目标目录名不是以文件分隔符结尾，则加上文件分隔符
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		File destDir = new File(destDirName);
		// 如果目标文件夹存在
		if (destDir.exists()) {
			// 如果允许覆盖则删除已存在的目标目录
			if (overlay) {
				new File(destDirName).delete();
			} else {
				MESSAGE = "复制目录失败：目的目录" + destDirName + "已存在！";
				JOptionPane.showMessageDialog(null, MESSAGE);
				return false;
			}
		} else {
			// 创建目的目录
			LogHelper.debug(destDirName + "does not exist, start to create...");
			if (!destDir.mkdirs()) {
				System.out.println("复制目录失败：创建目的目录失败！");
				return false;
			}
		}

		boolean flag = true;
		File[] files = srcDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 复制文件
			if (files[i].isFile()) {
				flag = copyFile(files[i].getAbsolutePath(), destDirName + files[i].getName(), overlay);
				if (!flag)
					break;
			} else if (files[i].isDirectory()) {
				flag = copyDirectory(files[i].getAbsolutePath(), destDirName + files[i].getName(), overlay);
				if (!flag)
					break;
			}
		}
		if (!flag) {
			MESSAGE = "复制目录" + srcDirName + "至" + destDirName + "失败！";
			JOptionPane.showMessageDialog(null, MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	public static boolean copyFile(String srcFileName, String destFileName, boolean overlay) {
		File srcFile = new File(srcFileName);

		// 判断源文件是否存在
		if (!srcFile.exists()) {
			MESSAGE = "源文件：" + srcFileName + "不存在！";
			JOptionPane.showMessageDialog(null, MESSAGE);
			return false;
		} else if (!srcFile.isFile()) {
			MESSAGE = "复制文件失败，源文件：" + srcFileName + "不是一个文件！";
			JOptionPane.showMessageDialog(null, MESSAGE);
			return false;
		}

		// 判断目标文件是否存在
		File destFile = new File(destFileName);
		if (destFile.exists()) {
			// 如果目标文件存在并允许覆盖
			if (overlay) {
				// 删除已经存在的目标文件，无论目标文件是目录还是单个文件
				new File(destFileName).delete();
			}
		} else {
			// 如果目标文件所在目录不存在，则创建目录
			if (!destFile.getParentFile().exists()) {
				// 目标文件所在目录不存在
				if (!destFile.getParentFile().mkdirs()) {
					// 复制文件失败：创建目标文件所在目录失败
					return false;
				}
			}
		}

		// 复制文件
		int byteread = 0; // 读取的字节数
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];

			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void mkDir(String dirName, Boolean overlay) {
		File dir = new File(dirName);
		// if dir exist
		if (dir.exists()) {
			// If overlay, then delete previous folder
			if (overlay) {
				dir.delete();
				if (!dir.mkdirs()) {
					LogHelper.error("Failed to create folder: " + dirName);
				}
			} else {
				MESSAGE = "Faile to create directory: Directoy " + dirName + " already exist!";
				LogHelper.error(MESSAGE);
			}
		} else {
			// Create direcoty
			MESSAGE = "Create dir:" + dirName;
			LogHelper.debug(MESSAGE);
			if (!dir.mkdirs()) {
				LogHelper.error("Failed to create folder: " + dirName);
			}
		}
	}

	public static void cleanDir(String dirName) {
		// If Directory exist
		File dir = new File(dirName);
		if (!dir.exists()) {
			MESSAGE = "Faile to clean directory: Directoy " + dirName + " does not exist!";
			LogHelper.debug(MESSAGE);
			return;
		}
		if (dir.isFile()) {
			LogHelper.debug("Deleting " + dirName.toString());
			dir.delete();
			return;
		}
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			cleanDir(files[i].toString());
		}
	}

	public static void deleteAllFilesOfDir(String dirName) {
		File path = new File(dirName);
		if (!path.exists()) {
			return;
		}
		if (path.isFile()) {
			LogHelper.debug("Deleting " + path.toString());
			path.delete();
			return;
		}
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			deleteAllFilesOfDir(files[i].toString());
		}
	}

	public static String getRandomString(int length) { //length表示生成字符串的长度  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 } 
	
	
}
