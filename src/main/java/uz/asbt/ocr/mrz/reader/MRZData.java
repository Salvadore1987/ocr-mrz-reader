package uz.asbt.ocr.mrz.reader;

public class MRZData {

    private String country;
    private String lastName;
    private String name;
    private String docNumber;
    private String nationality;
    private String birthDate;
    private String expDate;
    private String sex;
    private String personalNumber;
    private String docType;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Override
    public String toString() {
        return "MRZData{" +
                "country='" + country + '\'' +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", sex='" + sex + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", docType='" + docType + '\'' +
                '}';
    }
}
