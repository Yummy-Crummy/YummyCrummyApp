package com.thememeteam.yummycrummyapp;

/**
 * Created by Lauren on 11/9/2014.
 */
public class Account  {
    private int id;
    private String name;
    private String password;
    private String confirmPassword;
    private String email;
    private String bday;
    private String gender;

    public Account(int aid,String aName, String aPassword,String aconfirmPassword, String aEmail, String aBday, String aGender)
    {
        id = aid;
        name = aName;
        password = aPassword;
        confirmPassword = aconfirmPassword;
        email = aEmail;
        bday = aBday;
        gender = aGender;
    }
    public int getAcctId() {return id; }
    public void setAcctId(int aid) {id = aid; }
    public String getAcctName()
    {
        return name;
    }
    public void setAcctName(String an)
    {
        name = an;
    }
    public String getAcctPW()
    {
        return password;
    }
    public void setAcctPW(String pw)
    {
        password = pw;
    }
    public String getAcctConPW()
    {
        return confirmPassword;
    }
    public void setAcctConPW(String pw)
    {
        confirmPassword = pw;
    }
    public String getAcctEmail()
    {
        return email;
    }
    public void setAcctEmail(String ae)
    {
        email = ae;
    }
    public String getAcctBday()
    {
        return bday;
    }
    public void setAcctBday(String ab)
    {
        bday = ab;
    }
    public String getAcctGender()
    {
        return gender;
    }
    public void setAcctGender(String ag)
    {
        gender = ag;
    }
}


