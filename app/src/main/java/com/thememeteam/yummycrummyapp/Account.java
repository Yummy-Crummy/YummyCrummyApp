package com.thememeteam.yummycrummyapp;

/**
 * Created by Lauren on 11/9/2014.
 */
public class Account {
    private int acctid;
    private String name;
    private String password;
    private String email;
    private String bday;
    private String gender;

    public Account()
    {
        acctid = 1;
        name = null;
        password = null;
        email = null;
        bday = null;
        gender = null;
    }
    public int getAcctId()
    {
        return acctid;
    }
    public void setAcctId(int aid)
    {
        acctid = aid;
    }
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


