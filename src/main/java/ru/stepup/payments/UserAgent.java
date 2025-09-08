package ru.stepup.payments;

public class UserAgent {

    final String type_os, bro_name;

    public UserAgent(String userAgent) {
        String[] parts = userAgent.split(";");

        //System.out.println(parts[0]);
        //System.out.println(parts.length);
        //System.out.println(parts_new.length);
        //System.out.println(parts_new[1]);
        if (parts.length >= 2) {
            this.type_os = parts[1].substring(0, parts[1].length()-1);
            this.bro_name = parts[0].substring(1,parts[0].length()-1);
        }
        else {
            if (parts.length == 1) {
                this.bro_name = parts[0].replace(" ","");//.substring(1,parts_new.length);
                this.type_os=" ";
            }
            else {
                this.bro_name = " ";
                this.type_os=" ";
            }
        }


    }

    public String getType_os() {
        return type_os;
    }

    public String getBro_name() {
        return bro_name;
    }

    @Override
    public String toString() {
        return "UserAgent " + "{" + this.type_os + " " + this.bro_name + "}";
    }
}
