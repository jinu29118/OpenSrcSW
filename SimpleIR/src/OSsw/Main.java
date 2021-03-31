package OSsw;

import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb= new StringBuilder();
		String[] food= {"라면","초밥","아이스크림","떡","파스타"};
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document docu = docBuilder.newDocument();
		
		Element docs = docu.createElement("docs");
		docu.appendChild(docs);
		
		for (int i =0; i<food.length; i++) {
			File file = new File("C:/Users/xkg12/OneDrive/문서/21학년도 1학기/오픈소스SW입문/2주차 실습 html/"+food[i]+".html");
			try {
				if(checkBeforeFile(file)) {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String str = br.readLine();

					Element doc = docu.createElement("doc");
					docs.appendChild(doc);
					String num = Integer.toString(i);
					doc.setAttribute("id", num);
					
					Element title = docu.createElement("title");
					title.appendChild(docu.createTextNode(food[i]));
					doc.appendChild(title);
					Element body = docu.createElement("body");
					doc.appendChild(body);
					System.out.println(str);
					while(str !=null) {
						sb.append(removeTag(str));
						sb.append("\n");
						body.appendChild(docu.createTextNode(removeTag(str)));
						//String bodies= sb.toString();
						str = br.readLine();

					}
					br.close();
				}
				else {
					System.out.println("XXX");
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
		
		DOMSource source = new DOMSource(docu);
		StreamResult result = new StreamResult(new FileOutputStream(new File("collection.xml")));
		
		transformer.transform(source, result);

		
	}
	static boolean checkBeforeFile(File file) {
		if(file.exists()) {
			if(file.isFile() && file.canRead()) {
				return true;
			}
		}
		return false;
	}
	static String removeTag(String html) {
		
		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

	}
	


}
