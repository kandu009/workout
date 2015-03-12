package fraction;



public class TestMain {

	public enum Sex {
		Female,
		Male;
	}
	
	public enum SexualActivityGroup {
		None,
		Low,
		Moderate,
		High;
	}
	
	public static void main(String[] args) {

		int age =10;
		Sex sex = Sex.Male;
		SexualActivityGroup sexualActivityGroup = SexualActivityGroup.None;
		
		double i = getRateOfHpvInfection(age, sex, sexualActivityGroup);
		System.out.println(i);
		
	}

	/*
	 * (age < 16 ? 0 : (
	(age >= 16 && age <= 19) ? 0.0855 : (
		(age >= 20 && age <= 24) ? 0.25 : (
			(age >= 25 && age <= 29) ? 0.15 : (
				(age >= 30 && age <= 34) ? 0.0576 : (
					(age >= 35 && age <= 49) ? 0.0333 : (
						(age >= 50) ? 0.0222 : 0
					)
				)
			)
		)
	)
))
	 */
	
	private static double getRateOfHpvInfection(int age, Sex sex,
			SexualActivityGroup sexualActivityGroup) {

		double ret = 0;
		switch(sexualActivityGroup) {
			case None: 
			{
				switch(sex) {
					case Female:
					{
						if(age < 16) {
							ret = 0;
						} else if(age >= 16 && age <= 19) {
							ret = 0.0855;
						} else if(age >= 20 && age <= 24) {
							ret = 0.25;
						} else if(age >= 25 && age <= 29) {
							ret = 0.15;
						} else if(age >= 30 && age <= 34) {
							ret = 0.0576;
						} else if(age >= 35 && age <= 49) {
							ret = 0.0333;
						} else if(age >= 50) {
							ret = 0.0222;
						} else {
							ret = 0;
						} 
						break;
					}
					case Male:
					{
						if(age < 16) {
							ret = 0;
						} else if(age >= 16 && age <= 19) {
							ret = 0.0855;
						} else if(age >= 20 && age <= 24) {
							ret = 0.25;
						} else if(age >= 25 && age <= 29) {
							ret = 0.15;
						} else if(age >= 30 && age <= 34) {
							ret = 0.0576;
						} else if(age >= 35 && age <= 49) {
							ret = 0.0333;
						} else if(age >= 50) {
							ret = 0.0222;
						} else {
							ret = 0;
						} 
						break;
					}
					default:
					{
						ret = 0;
						break;
					}
				}
				break;
			}
			case Low:
			{
				switch(sex) {
					case Female:
					{
						if(age < 16) {
							ret = 0;
						} else if(age >= 16 && age <= 19) {
							ret = 0.0855;
						} else if(age >= 20 && age <= 24) {
							ret = 0.25;
						} else if(age >= 25 && age <= 29) {
							ret = 0.15;
						} else if(age >= 30 && age <= 34) {
							ret = 0.0576;
						} else if(age >= 35 && age <= 49) {
							ret = 0.0333;
						} else if(age >= 50) {
							ret = 0.0222;
						} else {
							ret = 0;
						} 
						break;
					}
					case Male:
					{
						if(age < 16) {
							ret = 0;
						} else if(age >= 16 && age <= 19) {
							ret = 0.0855;
						} else if(age >= 20 && age <= 24) {
							ret = 0.25;
						} else if(age >= 25 && age <= 29) {
							ret = 0.15;
						} else if(age >= 30 && age <= 34) {
							ret = 0.0576;
						} else if(age >= 35 && age <= 49) {
							ret = 0.0333;
						} else if(age >= 50) {
							ret = 0.0222;
						} else {
							ret = 0;
						} 
						break;
					}
					default:
					{
						ret = 0;
						break;
					}
				}
				break;
			}
			case Moderate:
			{
				switch(sex) {
					case Female:
					{
						if(age < 16) {
							ret = 0;
						} else if(age >= 16 && age <= 19) {
							ret = 0.0855;
						} else if(age >= 20 && age <= 24) {
							ret = 0.25;
						} else if(age >= 25 && age <= 29) {
							ret = 0.15;
						} else if(age >= 30 && age <= 34) {
							ret = 0.0576;
						} else if(age >= 35 && age <= 49) {
							ret = 0.0333;
						} else if(age >= 50) {
							ret = 0.0222;
						} else {
							ret = 0;
						} 
						break;
					}
					case Male:
					{
						if(age < 16) {
							ret = 0;
						} else if(age >= 16 && age <= 19) {
							ret = 0.0855;
						} else if(age >= 20 && age <= 24) {
							ret = 0.25;
						} else if(age >= 25 && age <= 29) {
							ret = 0.15;
						} else if(age >= 30 && age <= 34) {
							ret = 0.0576;
						} else if(age >= 35 && age <= 49) {
							ret = 0.0333;
						} else if(age >= 50) {
							ret = 0.0222;
						} else {
							ret = 0;
						} 
						break;
					}
					default:
					{
						ret = 0;
						break;
					}
				}
				break;
			}
			case High:
			{
				switch(sex) {
					case Female:
					{
						if(age < 16) {
							ret = 0;
						} else if(age >= 16 && age <= 19) {
							ret = 0.0855;
						} else if(age >= 20 && age <= 24) {
							ret = 0.25;
						} else if(age >= 25 && age <= 29) {
							ret = 0.15;
						} else if(age >= 30 && age <= 34) {
							ret = 0.0576;
						} else if(age >= 35 && age <= 49) {
							ret = 0.0333;
						} else if(age >= 50) {
							ret = 0.0222;
						} else {
							ret = 0;
						} 
						break;
					}
					case Male:
					{
						if(age < 16) {
							ret = 0;
						} else if(age >= 16 && age <= 19) {
							ret = 0.0855;
						} else if(age >= 20 && age <= 24) {
							ret = 0.25;
						} else if(age >= 25 && age <= 29) {
							ret = 0.15;
						} else if(age >= 30 && age <= 34) {
							ret = 0.0576;
						} else if(age >= 35 && age <= 49) {
							ret = 0.0333;
						} else if(age >= 50) {
							ret = 0.0222;
						} else {
							ret = 0;
						} 
						break;
					}
					default:
					{
						ret = 0;
						break;
					}
				}
				break;
			}
			default:
			{
				ret = 0;
				break;
			}
		}
		
		return ret;
	}

}
