package spstudio.com.tzolkin.core;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Tzolkin {
	
	public TzolkinDay cal(int year, int month, int day){
		int baseYear = -3114;
		LocalDate baseLineDate = new LocalDate(baseYear, 8, 13);
		LocalDate targetDate = new LocalDate(year, month, day);
		
		int diffDays = Math.abs(Days.daysBetween(baseLineDate, targetDate).getDays());

		int leapDays = 0;
		for (int i = 0; i <= (year - baseYear); i ++){
			int y = Math.abs(baseYear + i);
			if ((y % 4 == 0 && y % 100 != 0 ) || (y % 400 == 0)){
				leapDays ++;
			}
		}
		
		if (targetDate.year().isLeap()){
			if (targetDate.getMonthOfYear() < 3){
				leapDays --;
			}
		}
		
//		System.out.println("leap days = " + leapDays);
		
		int finalDiff = diffDays - leapDays;
//		System.out.println("final diff = " + finalDiff);
		int seal = (finalDiff + 7) % 260 % 20;
		int tone = (finalDiff + 8) % 260 % 13;
		
		int i = 0;
		while (true){
			if ((seal + 20 * i) % 13 == tone){
				break;
			}
			i ++;
		}

		int kin = seal + 20 * i;

		seal = (seal == 0 ? 20 : seal);
		tone = (tone == 0 ? 13 : tone);

		
		List<String> codes = new ArrayList<String>();

//		codes.add("SEAL: " + Dic.seals[seal - 1][0] + " TONE: " + Dic.tones[tone - 1][0]);
//		codes.add("KIN = " + kin);
		codes.add("I " + Dic.tones[tone - 1][1] + " in order to " + Dic.seals[seal - 1][1]);
		codes.add(Dic.tones[tone - 1][2] + " " + Dic.seals[seal - 1][2]);
		codes.add("I seal the " + Dic.seals[seal - 1][3] + " of " + Dic.seals[seal - 1][4]);
		codes.add("With the " + Dic.tones[tone - 1][3] + " tone of " + Dic.tones[tone - 1][4]);
		
		if (tone == 1 || tone == 6 || tone == 11){
			codes.add("I am guided by my own power doubled");
		}else{
			int index = Dic.guide[seal - 1][tone % 5 == 0 ? 5 : tone % 5];
			codes.add("I am guided by the power of " + Dic.seals[index - 1][4]);
		}
		if (Dic.ge.contains(kin)){
			codes.add("I am a galactic activation portal, enter me");
		}
		
		TzolkinDay td = new TzolkinDay();
		td.setSeal(seal);
		td.setTone(tone);
		td.setKin(kin);
		td.setSealName(Dic.seals[seal - 1][0]);
		td.setToneName(Dic.tones[tone - 1][0]);
		String[] array = new String[codes.size()];
		codes.toArray(array);
		td.setCodeArrays(array);
		
		return td;
	}
}
