package se.roland.client.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValScales extends Scales {

    @Override
    public String parseWeight(String weight) {
        Pattern p = Pattern.compile(".*GS.*[0-9]{1,5}.*kg.*");//find strings with weight
        Matcher m = p.matcher(weight);
        if (m.find()) {
            p = Pattern.compile(" ([0-9]{1,5}) ");
            m = p.matcher(weight);
            if (m.find()) {
                return weight.substring(m.start() + 1, m.end() - 1);
            }
        }
        return "";
    }

    @Override
    public byte getMessage() {
        return 0;
    }

}
