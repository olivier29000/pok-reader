package pokreader.ol.utils;

import java.util.List;

import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;

public class UtilsStringSimilarity {
	
	public  static  double ckeckSimilarity(String source,String target) {

		SimilarityStrategy strategy = new JaroWinklerStrategy();
		StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
		double score = service.score(source, target); // Score is 0.90
		//System.out.println("score : " +score);
		
		return score;
		
		
	}
	
	public static int maxIndex(List<Double> listeScores) {
		int i = 0;
		int maxIndex = -1;
		Double max = null;
		for (Double x : listeScores) {
			if ((x != null) && ((max == null) || (x > max))) {
				max = x;
				maxIndex = i;
			}
			i++;
		}
		return maxIndex;
	}

}
