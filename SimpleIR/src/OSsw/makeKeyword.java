package OSsw;
import org.snu.ids.kkma.index.Keyword;
import org.snu.ids.kkma.index.KeywordExtractor;
import org.snu.ids.kkma.index.KeywordList;
public class makeKeyword {

	public static void main(String[] args) {
		String testString="���������¼Һм��⸦�׽�Ʈ�ϰ��־��.�׽�Ʈ��������Կ�.";
		KeywordExtractor ke=new KeywordExtractor();
		KeywordList kl=ke.extractKeyword(testString, true);
		for(int i=0; i<kl.size();i++){
			Keyword kwrd=kl.get(i);
			System.out.println(kwrd.getString()+"\t"+kwrd.getCnt());
		}
	}

}
