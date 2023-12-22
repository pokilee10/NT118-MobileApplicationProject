package com.example.doan;

public class ReadWriteUserDetail {
    public String username, phonenumber, email, address, password, rank;

    public ReadWriteUserDetail(){}
    public ReadWriteUserDetail(String email, String password, String username)
    {
        this.username =username;
        this.email = email;
        this.password = password;
    }

    public ReadWriteUserDetail(String username, String email)
    {
        this.username =username;
        this.email = email;
    }
    public ReadWriteUserDetail(String username, String email, String password, String phonenumber, String address, String rank)
    {
        this.username =username;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
        this.rank = rank;
    }
}
