package easyProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsMatchingRule {

	public static void main(String[] args) {
		
		List<List<String>> items = new ArrayList<List<String>>();

		items.add(Arrays.asList("phone","blue","pixel"));
		items.add(Arrays.asList("computer","silver","lenovo"));
		items.add(Arrays.asList("phone","gold","iphone"));
		
		System.out.println(countMatches(items, "color", "silver"));
		
	}
	
	static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        /*
        Here we have elements which have 3 values each
        
        And as a check we have a key and a value
        */
        
        int indexToCheck = 0;
        
        switch(ruleKey){
            case "type" : indexToCheck = 0; break;
            case "color" : indexToCheck = 1; break;
            case "name" : indexToCheck = 2; break;
        }
        
        int counter = 0;
        for(int i = 0; i < items.size(); i ++){
            
            if(items.get(i).get(indexToCheck).equals(ruleValue)){
                counter++;
            }
        }
        
        return counter;

    }

}
