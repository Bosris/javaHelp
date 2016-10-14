package zoo;

//As a security-minded professional, it is important that only the appropriate people gain access to data in your computer system. This is called authentication. Once users gain entry, it is also important that they only see data related to their role in the zoo. This is called authorization. You have been given a file of users and their credentials. Create an authentication system that does all of the following:
//-Asks a user for a username
//-Asks a user for a password
//-Converts the password using a message digest five (MD5) hash
//--It is not required that you write the MD5 from scratch. Use the code located in this document and follow the comments in it to perform this operation.
//-Checks the credentials against the valid credentials provided in the file (use the hashed passwords in the second column; the third column contains the actual passwords for testing)
//-Limits failed attempts to three before notifying the user and exiting
//-After successful authentication, uses the role in the credential file to display the correct system information loaded from the specific role file
//-Allows a user to log out
//-Stays on the credential screen until either a successful attempt has been made, three unsuccessful attempts have been made, or a user chooses to exit
//You are allowed to add extra roles if you would like to see another type of user added to the system, but you may not remove any of the existing roles.
import java.util.*;
import java.io.*;
import java.net.URL;
import java.security.*;

class authenticationSystem {
	public static ArrayList<String> username = new ArrayList<String>();
	public static ArrayList<String> md5 = new ArrayList<String>();
	public static ArrayList<String> password = new ArrayList<String>();
	public static ArrayList<String> position = new ArrayList<String>();

	public static void main(String[] args) throws IOException,
			NoSuchAlgorithmException {
		readCredFile();
		prompts();
	}

	public static boolean passwordCheck() throws NoSuchAlgorithmException {
		if (username.contains(userCreds.getName())) {
			int slot = username.indexOf(userCreds.getName());
			String pwhash = md5.get(slot).toString();

			if (pwhash.equals(userCreds.getMD5())) {
				return true;
			} else {
				System.out.println("passwords do not match");
				return false;
			}
		} else {
			System.out.println("username does not exist");
			return false;
		}
	}

	public static void readCredFile() throws IOException {
		URL path = authenticationSystem.class.getResource("credentials.txt");
		File f = new File(path.getFile());
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line = null;

		while ((line = reader.readLine()) != null) {
			if (line.length() > 0) {
				// split line on tabs
				String[] array = line.split("\\t");
				// read in username
				username.add(array[0]);
				// read in md5
				md5.add(array[1]);
				// read in password
				String trimpw = array[2].replace("\"", "");
				password.add(trimpw);
				// read in position
				position.add(array[3]);
			}
		}
		reader.close();
	}

	public static void logout() {
		System.out.println("Thank you for using the computer. Good bye.");
		System.exit(0);
	}

	public static void displayPosition() throws IOException {
		int slot = username.indexOf(userCreds.getName());
		String positionFile = position.get(slot).toString();

		URL path = authenticationSystem.class.getResource("credentials.txt");
		File f = new File(path.getFile());
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line;

		if (positionFile.equals("admin")) {
			path = authenticationSystem.class.getResource("admin.txt");
			f = new File(path.getFile());
			reader = new BufferedReader(new FileReader(f));
			line = null;
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0) {
					System.out.println(line);
				}
			}
		}
		if (positionFile.equals("zookeeper")) {
			path = authenticationSystem.class.getResource("zookeeper.txt");
			f = new File(path.getFile());
			reader = new BufferedReader(new FileReader(f));
			line = null;
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0) {
					System.out.println(line);
				}
			}
		}
		if (positionFile.equals("veterinarian")) {
			path = authenticationSystem.class.getResource("veterinarian.txt");
			f = new File(path.getFile());
			reader = new BufferedReader(new FileReader(f));
			line = null;
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0) {
					System.out.println(line);
				}
			}
		}
		reader.close();
	}

	public static void prompts() throws NoSuchAlgorithmException, IOException {
		// prompt and accept user name and password
		Scanner scnr = new Scanner(System.in);
		while (true) {
			int logChoice = 0;
			while (true) {
				try {
					System.out
							.print("\nWhat would you like to do?\n1) Log in\n2) log out\nEntry: ");
					logChoice = Integer.parseInt(scnr.nextLine());
					break;
				} catch (NumberFormatException ne) {
					System.out.println("Input is not a number, try again");
				}
			}
			if (logChoice == 1) {
				int count = 0;
				// does password work
				while (count < 3) {
					System.out.print("Username: ");
					userCreds.setName(scnr.nextLine().trim());
					System.out.print("password: ");
					userCreds.setPasswd(scnr.nextLine().trim());
					if (passwordCheck() == true) {
						displayPosition();
						break;
					} else {
						count++;
					}
				}
				if (count == 3) {
					System.out.println("you are the weakest link. goodbye");
					System.exit(0);
				}
			} else if (logChoice == 2) {
				logout();
			} else {
				System.out.println("invalid Option. Try again.");
			}
		}
	}

}
