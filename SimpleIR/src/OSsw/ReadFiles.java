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
		String path = "C:\\Users\\xkg12\\OneDrive\\����\\21�г⵵ 1�б�\\���¼ҽ�SW�Թ�\\2���� �ǽ� html";
		File Filedir = new File(path);
		File files[]=Filedir.listFiles();
		for (int i =0; i<files.length;i++) {
			System.out.println(files[i]);
			// ���� �� ���ϸ���Ʈ���� �� �̾Ƴ� �� ����. files[i]�� �� ��ΰ� �����.
			FileReader fr = new FileReader(files[i]);
			BufferedReader br= new BufferedReader(fr);
			String line = "";
			while((line=br.readLine())!=null) {
				System.out.println(line);
				File file = new File("C:\\Users\\xkg12\\OneDrive\\����\\21�г⵵ 1�б�\\���¼ҽ�SW�Թ�\\SimpleIR\\collection.xml");
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
	            if(file.isFile() && file.canWrite()){
	                //����
	            	
	                bufferedWriter.write(i+line);
	                //���๮�ھ���
	                bufferedWriter.newLine();
	                bufferedWriter.write("���ڿ� �߰�2");
	                
	                bufferedWriter.close();}

			}
			br.close();


			}
		
		}
}
