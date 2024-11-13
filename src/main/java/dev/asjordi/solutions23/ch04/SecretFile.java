package dev.asjordi.solutions23.ch04;

import java.util.LinkedHashMap;
import java.util.Map;

public class SecretFile {

    private final String name;
    private final String checksum;

    public SecretFile(String name, String checksum) {
        this.name = name;
        this.checksum = checksum;
    }

    public String getName() {
        return name;
    }

    public String getChecksum() {
        return checksum;
    }

    public boolean validate(){
        Map<Character, Integer> map = new LinkedHashMap<>();
        StringBuilder validCheckSum = new StringBuilder();

        for (char c : this.name.toCharArray()){
            if (!map.containsKey(c)) map.put(c, 1);
            else map.replace(c, map.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) validCheckSum.append(entry.getKey());
        }

        return validCheckSum.toString().equals(this.checksum);
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", checksum='" + checksum + '\'' +
                '}';
    }
}
