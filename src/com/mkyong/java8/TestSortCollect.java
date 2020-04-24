package com.mkyong.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestSortCollect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	        List<Hosting> list = new ArrayList<>();
	        list.add(new Hosting(1, "liquidweb.com", 80000));
	        list.add(new Hosting(2, "linode.com", 90000));
	        list.add(new Hosting(3, "digitalocean.com", 120000));
	        list.add(new Hosting(4, "aws.amazon.com", 200000));
	        list.add(new Hosting(5, "mkyong.com", 300000));
	        list.add(new Hosting(6, "linode.com", 100000));

	        //example 1 order by website code
	        Map result1 = list.stream()
	                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
	                .collect(
	                        Collectors.toMap(
	                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
	                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
	                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
	                        ));

	      //example 1 order by site name
	        Map result2 = list.stream()
	                .sorted(Comparator.comparing(Hosting::getName))
	                .collect(
	                        Collectors.toMap(
	                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
	                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
	                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
	                        ));

	        System.out.println("Result 1 : " + result1);
	        System.out.println("Result 2 : " + result2);

	    
	}

}
