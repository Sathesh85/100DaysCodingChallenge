package com.challenge.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
	public static void main(String[] args) {
		RestoreIpAddress r = new RestoreIpAddress();
		System.out.println(r.restoreIpAddresses(""));
	}

	public List<String> restoreIpAddresses(String s) {

		List<String> resultList = new ArrayList<>();

		helper(s, 3, resultList, "");

		return resultList;

	}

	private void helper(String s, int pointCount, List<String> resultList, String res) {
		if (pointCount < 1) {
			if (isValid(s)) {
				resultList.add(res + s);
			}
			return;
		}
		
		for(int i=1; s.length()>i && i<=(s.charAt(0) == '0' ? 1 : 3);i++) {
			String l = s.substring(0,i);
			String r = s.substring(i);
			if(isValid(l)) {
				helper(r, pointCount-1, resultList, res + l + "." );
			}
		}

	}

	private boolean isValid(String s) {
		 if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
	            return false;
		return true;
	}

}
