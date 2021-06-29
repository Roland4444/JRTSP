package se.roland.client.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaisScales extends Scales{
    
    final byte message = 0x10;

    @Override
    public String parseWeight(String weight) {
        Pattern p = Pattern.compile("\\=.*[0-9.]{5,6}+\\$");
        Matcher m = p.matcher(weight);
        if(m.find()){
            return weight.substring(m.start(),m.end()).replaceAll("[^0-9]","");
        }
        return "";
    }

    @Override
    public byte getMessage() {
        return message;
    }
    
}
