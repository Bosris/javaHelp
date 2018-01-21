package zooLogin;

/*
 * @author Anthony Nazzise
 */
import java.security.NoSuchAlgorithmException;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ZooLogin {

    static ArrayList<String> username = new ArrayList<>();
    static ArrayList<String> password = new ArrayList<>();
    static ArrayList<String> hash = new ArrayList<>();
    static ArrayList<String> role = new ArrayList<>();

    public static void userAuthenticators() {
        try {
            URL path = ZooLogin.class.getResource("credentials.txt");
            File f = new File(path.getFile());
            BufferedReader reader = new BufferedReader(new FileReader(f));
            //BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\a451459.DSDOM1\\Desktop\\ZooLoginIOFiles\\credentials.txt"));
            String line = null;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 0) {
                    // split line on tabs
                    String[] array = line.split("\\t");
                    // read in username
                    username.add(array[0]);
                    // read in md5
                    hash.add(array[1]);
                    // read in password
                    String trimpw = array[2].replace("\"", "");
                    password.add(trimpw);
                    // read in position
                    role.add(array[3]);
                }
            }
        } catch (IOException e) {
        }

    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Scanner scnr = new Scanner(System.in);
        userAuthenticators();
        String inputUsername = "";
        String inputPassword = "";
        FileOutputStream roleStatement = null;

        System.out.println("###############Log in###############");
        for (int i = 0; i < 3; ++i) {   //allow 3 login attempts
            System.out.print("username: ");// prompt for user name
            inputUsername = scnr.next();
            System.out.print("password: ");// prompt for password
            inputPassword = scnr.next();

            if (inputPassword.equals(ZooLogin.password) && inputUsername.equals(ZooLogin.username)) {  //users check = new users(username, password);
                System.out.println("You are logged in");
                {
                    if (role.equals("admin")) {
                        roleStatement = new FileOutputStream("C:\\Users\\a451459.DSDOM1\\Desktop\\ZooLoginIOFiles\\admin.txt");
                        System.out.print(roleStatement);
                    } else if {(role.equals("zookeeper"))
                        roleStatement = new FileOutputStream("C:\\Users\\a451459.DSDOM1\\Desktop\\ZooLoginIOFiles\\admin.txt");
                        System.out.print(roleStatement);
                    } else if {(role.equals("veterinarian"))
                        roleStatement = new FileOutputStream("C:\\Users\\a451459.DSDOM1\\Desktop\\ZooLoginIOFiles\\admin.txt");
                        System.out.print(roleStatement);
                    } else {
                        System.out.println("One or more of your entries is incorrect, please try again.");
                    }
                if (!inputPassword.equals(password)) { //after 3rd attempt exit program
                    System.out.println("access denied");
                    System.exit(0);
                }
            }
        }
    }
}
