package data;

import objects.Account;
import utils.Constants;
import utils.Utility;

import java.util.ArrayList;

public class Data {
    public static Account defaultAccount() {
        return new Account(Constants.USERNAME, Constants.PASSWORD);
    }

    /**
     * Get Account from CSV file
     * @param delimiter
     * @return
     */
    public static ArrayList<Account> getCSVAccount(String file, String delimiter) {
        ArrayList<String> arrayList = Utility.readCSV(file);
        ArrayList<Account> list_accounts = new ArrayList<>();

        for (Object string : arrayList) {
            String[] array = string.toString().split(delimiter);
            list_accounts.add(new Account(array[0], array[1]));
        }

        return list_accounts;
    }
}
