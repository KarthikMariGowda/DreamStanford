package com.dreamorbit.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.dreamorbit.generic.BaseTest;

public class Reader extends BaseTest
{
	
	public String latestDownloads;
		@Test(priority = 31, enabled = true)
		
		public void readingJSON()  throws InterruptedException, IOException, ParseException
		{
			BaseTest baseTest = new BaseTest();
		  JsonDownloadValidSkey jsonDownloadValidSkey= new JsonDownloadValidSkey();
		  jsonDownloadValidSkey.jsonDownloadCheck(); 
		  
			
			Path dir = Paths.get("C://Users/karthik.m/Downloads/");  // specify your directory

			Optional<Path> lastFilePath = Files.list(dir)    // here we get the stream with full directory listing
			    .filter(f -> !Files.isDirectory(f))  // exclude subdirectories from listing
			    .max(Comparator.comparingLong(f -> f.toFile().lastModified()));  // finally get the last file using simple comparator by lastModified field

			if ( lastFilePath.isPresent()) // your folder may be empty
			{

				System.out.println("lastFilePath >> "+lastFilePath.toString());
			
				System.out.println(lastFilePath.toString());
				String str = lastFilePath.toString().replaceAll("[\\[\\]]", "");
				str = str.replaceAll("Optional", "");
			
			 System.out.println(str);
			 latestDownloads= "C://Users/karthik.m/Downloads/latestdownload";
			 
			 //Unzip
			 unzip(str, latestDownloads);
			
			  File folder = new File(latestDownloads);

			  System.out.println("File folder >> "+folder.toString());
			  for (File file : folder.listFiles()) 
			  { 
				//  System.out.println("json files >>> "+file.toString() );
				 continue;
			 
			  }
			  final List<File> fileList=Arrays.asList(folder.listFiles());
			  
			  System.out.println("List of json files >>> "+fileList.toString() );
			  
			  int rowCount = baseTest.xl_RowCount(XL_DATA_PATH,"EjsonFiles");
			  System.out.println(rowCount);
			  
			  for (int i = 1; i <= rowCount; i++) {
			  String checkFile = baseTest.read_XL_Data(XL_DATA_PATH,"EjsonFiles", i, 0);
			  boolean fileCheck = checkFileExists(checkFile);
			  System.out.println("fileCheck json files >>> "+fileCheck);
			/*
			 * String str2 = fileList.toString().replaceAll("[\\[\\]]", ""); str2 =
			 * str2.replaceAll(latestDownloads, ""); System.out.println("str2 >>> "+str2 );
			 */	 
			}
			
			}
		  
	/*	JSONParser jsonParser = new JSONParser();// to read
		
			FileReader sfileReader = new FileReader(sjsonPath);//to read json C://Users/karthik.m/Downloads/json_6MWT_vijeth.k_2019-11-08T16%3A56%3A30%3A721/Pedometer.json
			Object aobj = jsonParser.parse(sfileReader);
			JSONObject jsonObject= (JSONObject)obj;

			String time = (String)jsonObject.get("currentTime");
			System.out.println(time);
			
			
			
			
			FileReader afileReader = new FileReader(ajsonPath);//to read json C://Users/karthik.m/Downloads/json_6MWT_vijeth.k_2019-11-08T16%3A56%3A30%3A721/Pedometer.json
			Object sobj = jsonParser.parse(afileReader);
			JSONObject jsonObject= (JSONObject)sobj;
			
			String time = (String)jsonObject.get("currentTime");
			System.out.println(time);
			*/
			
		
		}
		
		public boolean checkFileExists(String checkFile) {
			String dirName=latestDownloads;
		    File dir2 = new File(dirName);
		    File[] dir_contents = dir2.listFiles();
		    String temp = dirName+"/"+checkFile;
		    boolean check = new File(temp).exists();
		    System.out.println("Check" + check); // -->always says false

		    for (int i = 0; i < dir_contents.length; i++) {
		        if (dir_contents[i].getName().equals(checkFile))
		            return true;
		            }

		    return false; 
		}
		
		 private static void unzip(String zipFilePath, String destDir) {
		        File dir = new File(destDir);
		        // create output directory if it doesn't exist
		        if(!dir.exists()) dir.mkdirs();
		        FileInputStream fis;
		        //buffer for read and write data to file
		        byte[] buffer = new byte[1024];
		        try {
		            fis = new FileInputStream(zipFilePath);
		            ZipInputStream zis = new ZipInputStream(fis);
		            ZipEntry ze = zis.getNextEntry();
		            while(ze != null){
		                String fileName = ze.getName();
		                File newFile = new File(destDir + File.separator + fileName);
		                System.out.println("Unzipping to "+newFile.getAbsolutePath());
		                //create directories for sub directories in zip
		                new File(newFile.getParent()).mkdirs();
		                FileOutputStream fos = new FileOutputStream(newFile);
		                int len;
		                while ((len = zis.read(buffer)) > 0) {
		                fos.write(buffer, 0, len);
		                }
		                //System.out.println("FIS >> "+fos.toString());
		                fos.close();
		                //close this ZipEntry
		                zis.closeEntry();
		                ze = zis.getNextEntry();
		            }
		            //close last ZipEntry
		            zis.closeEntry();
		            zis.close();
		            fis.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		    }
		}

