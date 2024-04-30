class Problem1 extends ConsoleProgram {

  /**
  * Description: creates a password using user
  * @author: Steve Lin
  */
  
  public void run() {
    // print initial formatting 
    System.out.println("***** Student Account Registration *****");

    // ask for first name
    String FirstName = readLine("Enter your first name: ");

    // ask for last name
    String LastName = readLine("Enter your last name: ");

    // ask for student number
    String StudentNumber = readLine("Enter your student number: ");

    // ask for username
    String Username = readLine("Enter a new username: ");

    // formating
    System.out.println("");
    System.out.println("");

    // print whether the username is valid or not using the validateUsername method
    System.out.println("Valid username: " + validateUsername(Username));

    // print new password using paramaters given to the createPassword method
    System.out.println("Your password is: " + createPassword(FirstName, LastName, StudentNumber));

  }

  /**
   * Validates or invalidates the password
   * 
   * @param strUsername the username the user inputs
   * @return true if the password meets all criteria
   * @return false if password does not meet all criteria
   */

  public boolean validateUsername(String strUsername)
  {

    // for search through the letters of the username
    for (int i = 0; i < strUsername.length() - 1; i++){

      char cur = strUsername.charAt(i);
      
      // if statment if the the username length is greater than 7 and if it is a letter or digit 
      if ((Character.isLetterOrDigit(cur)) && (strUsername.length() > 7)) {
        
        // if statment if the character is a digit
        if (Character.isDigit(cur)){
          
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Creates a new password with the parameters given by the user
   * 
   * @param strFirstName The user's first name
   * @param strLastName The user's last name
   * @param strStudentNumber The user's student number
   * @return created password 
   */

  public String createPassword(String strFirstName, String strLastName, String strStudentNumber)
  {
    // get the lowercase first 4 characters of last name
    String strFourCharacters;

    // if statement if the last name length is less than 4
    if (strLastName.length() < 4){

      strFourCharacters = strLastName;

    }
    else{

      String strLowerCase = strLastName.toLowerCase();

      strFourCharacters = strLowerCase.substring(0, 4);
    }

    // get the uppercase initial of first name
    String strUppercase = strFirstName.toUpperCase();
    
    // get the middle 3 numbers of the student number 
    char chrFirstInitial = strUppercase.charAt(0);

    String strMiddleStudentNumber = strStudentNumber.substring(3, 6);

    // concatenate strings together
    String strFinalPassword = strFourCharacters + chrFirstInitial + strMiddleStudentNumber;
    
    // return the final password
    return strFinalPassword;

  }

  
}