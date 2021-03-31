package OSsw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;


public class ReadFiles {

	public static void main(String[] args)throws IOException {
		String path = "C:\\Users\\xkg12\\OneDrive\\문서\\21학년도 1학기\\오픈소스SW입문\\2주차 실습 html";
		File Filedir = new File(path);
		File files[]=Filedir.listFiles();
		for (int i =0; i<files.length;i++) {
			System.out.println(files[i]);
			// 폴더 내 파일리스트들을 쭉 뽑아낼 수 있음. files[i]에 그 경로가 저장됨.
			FileReader fr = new FileReader(files[i]);
			BufferedReader br= new BufferedReader(fr);
			String line = "";
			while((line=br.readLine())!=null) {
				System.out.println(line);
				File file = new File("C:\\Users\\xkg12\\OneDrive\\문서\\21학년도 1학기\\오픈소스SW입문\\SimpleIR\\collection.xml");
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
	            if(file.isFile() && file.canWrite()){
	                //쓰기
	            	
	                bufferedWriter.write(i+line);
	                //개행문자쓰기
	                bufferedWriter.newLine();
	                bufferedWriter.write("문자열 추가2");
	                
	                bufferedWriter.close();}

			}
			br.close();


			}
		
		}
}
