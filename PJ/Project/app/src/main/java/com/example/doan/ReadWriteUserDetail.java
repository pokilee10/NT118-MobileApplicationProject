package com.example.doan;

public class ReadWriteUserDetail {
    public String username, phonenumber, email, address, password, rank;

    public ReadWriteUserDetail(){}
    public ReadWriteUserDetail(String username, String email, String password)
    {
        this.username =username;
        this.email = email;
        this.password = password;
    }
    public ReadWriteUserDetail(String username, String email, String phonenumber, String address, String rank)
    {
        this.username =username;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.rank = rank;
    }
}
