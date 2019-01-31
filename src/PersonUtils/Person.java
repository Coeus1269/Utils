package PersonUtils;

import java.util.Date;

import StringUtils.StringUtils;

// import net.wg.address.US_Address;


public class Person 
{
	// TODO: maybe an attributes class for hair color, eye color etc.?
	// TODO: when returning enum variables, should it return the string?
	private int personID;					// unique ID for this person
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	private String userName = "";
	private String email = "";
	private boolean internationalAddress = false;
	private String SSN = "";				// Social Security Number
	
	//optional
	private Date dOB;
	private Integer weight;
	private Integer heightInInches;
	private Races race = Races.NA;
	private Genders gender = Genders.NA;
	private EyeColors eyeColor = EyeColors.NA;
	private HairColors hairColor = HairColors.NA;
	
	enum Genders
		{ Male, Female, NA;
		}
	
	enum Races
		{ Caucasion, Latino, AfricanAmerican, NA;
		}
	
	enum EyeColors
		{
		Green, Blue, Hazel, Brown, NA;
		}
	
	enum HairColors
		{
		Brown, Blond, Red, NA;	
		}
	
	public String Version_str = "1.230";

	public static void main( String...args )
		{
		Person person = new Person("Will", "A", "Givans", "", "");
		System.out.println(person.toString());
		
		person = new Person("Will", "", "Givans", "", "");
		System.out.println(person.toString());;
		}
	

	public Person(String FirstName, String MiddleName, String LastName, String UserName, String Email)
	{
		if(!StringUtils.isEmptyString(FirstName))
			firstName = FirstName;
		
		if(!StringUtils.isEmptyString(MiddleName))
			middleName = MiddleName;
		
		if(!StringUtils.isEmptyString(LastName))
			lastName = LastName;
		
		if(!StringUtils.isEmptyString(UserName))
			userName = UserName;
		
		if(!StringUtils.isEmptyString(Email))
			email = Email;

	}
	
	
	// TODO use enum or the like to restrict gender and race
	
	@Override
	public String toString()
		{ return GetFullName();		}



	/* ------------------------------ Getters & Setters  ------------------------------ */

	public String GetFullName()
		{
			if(middleName.length() < 1)
				return getFirstName() + " " + getLastName();
			else
				return getFirstName() + " " + middleName + " " + getLastName();
		}

	public int getPersonID( )
		{ return personID;	}

	public void setPersonID(int personID)
		{ this.personID = personID;	}

	public String getFirstName( )
		{ return firstName;	}

	public void setFirstName(String firstName)
		{ this.firstName = firstName;	}

	public String getMiddleName( )
		{ return middleName;	}

	public void setMiddleName(String middleName)
		{ this.middleName = middleName;	}

	public String getLastName( )
		{ return lastName;	}

	public void setLastName(String lastName)
		{ this.lastName = lastName;	}

	public String getUserName( )
		{ return userName;	}

	public void setUserName(String userName)
		{ this.userName = userName;	}

	public String getEmail( )
		{ return email;	}

	public void setEmail(String email)
		{ this.email = email;	}

	public boolean isInternationalAddress( )
		{ return internationalAddress;	}

	public void setInternationalAddress(boolean internationalAddress)
		{ this.internationalAddress = internationalAddress;	}

	public String getSSN( )
		{ return SSN;	}

	public void setSSN(String sSN)
		{ SSN = sSN;	}

	public Date getdOB( )
		{ return dOB;	}

	public void setdOB(Date dOB)
		{ this.dOB = dOB;	}

	public Integer getWeight( )
		{ return weight;	}

	public void setWeight(Integer weight)
		{ this.weight = weight;	}

	public Integer getHeightInInches( )
		{ return heightInInches; }

	public void setHeightInInches(Integer heightInInches)
		{ this.heightInInches = heightInInches;	}

	public Races getRace( )
		{ return race;	}

	public void setRace(Races race)
		{ this.race = race;	}

	public Genders getGender( )
		{ return gender; }

	public void setGender(Genders gender)
		{ this.gender = gender; }

	public EyeColors getEyeColor() 
		{ return eyeColor; }

	public void setEyeColor(EyeColors eyeColor) 
		{ this.eyeColor = eyeColor;	}

	public HairColors getHairColor() 
		{ return hairColor;	}

	public void setHairColor(HairColors hairColor) 
		{ this.hairColor = hairColor; }
	

/* ------------------------------ End Getters & Setters  ------------------------------ */
	
}
