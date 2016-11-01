package norman.hackerrank;

import java.util.HashMap;
import java.util.Map;

import norman.template.template;

public class ReformatTheDate extends template {

	public ReformatTheDate() {
		super("ReformatTheDate", "ReformatTheDate", LINUX);
	}

	@Override
	public void doSomething() {
		Map<String, String> months = new HashMap<>();
		months.put("Jan", "01");
		months.put("Feb", "02");
		months.put("Mar", "03");
		months.put("Apr", "04");
		months.put("May", "05");
		months.put("Jun", "06");
		months.put("Jul", "07");
		months.put("Aug", "08");
		months.put("Sep", "09");
		months.put("Oct", "10");
		months.put("Nov", "11");
		months.put("Dec", "12");
		int numT = getInput().nextInt();
		String[] input = new String[numT];
		getInput().nextLine();// don't know why
		for(int i=0;i<numT;i++){
			input[i] = getInput().nextLine();
//			System.out.println(input[i]);
			int tanggal = 0, tanggalIndex = 2;
			tanggalIndex = input[i].indexOf("th");
			if(tanggalIndex < 0){
				tanggalIndex = input[i].indexOf("nd");
				if(tanggalIndex < 0){
					tanggalIndex = input[i].indexOf("rd");
					if(tanggalIndex < 0){
						tanggalIndex = input[i].indexOf("st");
					}
				}
			}
			String res = input[i].substring(0, tanggalIndex);
			tanggal = Integer.valueOf(res);
			String remain = input[i].substring(tanggalIndex+3, input[i].length());
			res = remain.substring(0, 3);
			remain = remain.substring(4);
			String bulan = months.get(res);
			String tanggalFormat = "";
			if(tanggal < 10){
				tanggalFormat += "0"+tanggal;
			}else{
				tanggalFormat += tanggal;
			}
			System.out.println(remain+"-"+bulan+"-"+tanggalFormat);
			
			
		}
	}

}
