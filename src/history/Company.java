package history;

import main.ObjectPlus;

import java.io.Serializable;
import java.util.*;

public class Company extends ObjectPlus implements Serializable {
    String fullName;
    String shortName;
    List<String> emails;
    String city;
    String address;

    private Set<AssetOwnership> assetOwnerships = new HashSet<>();

    public Company(String fullName, String shortName, List<String> email, String city, String address) {
        super();

        setFullName(fullName);
        setShortName(shortName);
        setEmails(email);
        setCity(city);
        setAddress(address);
    }

    public Company(String fullName, String shortName, String city, String address) {
        this(fullName, shortName, new ArrayList<>(), city, address);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addAssetOwnership(AssetOwnership ownership) {
        if (!assetOwnerships.contains(ownership)) {
            assetOwnerships.add(ownership);
            ownership.setCompany(this);
        }
    }

    public void removeAssetOwnership(AssetOwnership ownership) {
        if (assetOwnerships.contains(ownership)) {
            assetOwnerships.remove(ownership);
        }
    }

    @Override
    public String toString() {
        String output = getFullName() + "\n" + getAddress() + "\n" + getCity();

        for(String email : getEmails()) {
            output += "\n" + email;
        }

        return output;
    }
}