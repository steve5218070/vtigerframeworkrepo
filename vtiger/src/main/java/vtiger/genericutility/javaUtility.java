package vtiger.genericutility;

import java.util.Date;
import java.util.Random;

public class javaUtility {
public String generateSystemDateTime() {
	Date date=new Date(0);
	return date.toString();
}

	public int generateRandomNo(int limit) {
		Random random=new Random();
		return random.nextInt(limit);
}
}