package OSsw;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadTest2 {
	public static void main(String[] args) {
		String path = "C:\\Users\\xkg12\\OneDrive\\����\\21�г⵵ 1�б�\\���¼ҽ�SW�Թ�\\2���� �ǽ� html";
		File dirFile = new File(path);
		//File[] fileList = dirFile.listFiles();
		String files[]=dirFile.list();
		System.out.println(files);
		FileReader fileReader = null;
		BufferedReader bufReader = null;
		
		File newFile = null;
		BufferedWriter bufferedWriter = null;
		
		for (File tempFile : fileList) {
			if (tempFile.isFile()) {
				String tempPath = tempFile.getParent();
				String tempFileName = tempFile.getName();
				//System.out.println("Path=" + tempPath+", FileName="+tempFileName);
				
				try {
					fileReader = new FileReader(tempFile);
					bufReader = new BufferedReader(fileReader);
					String line="";
					
					// output ���� ���� 
					/*String newFileDirPath = path + File.separator + "output";
					File dir = new File(newFileDirPath);
					if(!dir.exists()){
						dir.mkdirs(); //���丮 ���� �޼���
			        }*/
					
					// ���� ������ ����
					newFile = new File(path+File.separator + tempFileName + ".xml");
					
					bufferedWriter = new BufferedWriter(new FileWriter(newFile));
					bufferedWriter.write( "#!/bin/sh" );
					//bufferedWriter.newLine(); // ���ư��� OS�� ���� �ٸ� ���ڰ� �����⶧���� ���������� ������ ����� �Ѵ�.
					bufferedWriter.write("\n"); // �������� \n ���� �ٹٲ�
					
					System.out.println("fileName="+newFile.getName());
					
					while((line = bufReader.readLine()) != null ){
						
						if(line.indexOf("cmdStr:rm") > -1){
							//System.out.println(">> "+line.substring( line.indexOf("rm")) );
							
							//bufferedWriter.newLine(); // ������ -> \r\n
							bufferedWriter.write("\n"); // ������ -> \n
							bufferedWriter.write( line.substring( line.indexOf("rm")) );
							
						}
						else{
							//System.out.println(">> "+line);
						}
						
					}
					
					bufReader.close();
					fileReader.close();
					bufferedWriter.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		}
	}



}



//System.out.println(dirFile);
File files[] = dirFile.listFiles();
System.out.println(files);
BufferedReader br= null;
PrintWriter pw=null;
for (File tempFile : fileList) {
	if (tempFile.isFile()) {
		String tempPath = tempFile.getParent();
		String tempFileName = tempFile.getName();
	try {
		br=new BufferedReader(new FileReader(path));
		pw=new PrintWriter(new FileWriter("collection.xml"));
		String line = null;
		while((line=br.readLine())!=null) {
			pw.println(line);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		pw.close();
		try {
			br.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
}

