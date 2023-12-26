package com.example.doan;
import androidx.annotation.Nullable;

import java.util.List;
public class ReadWriteUserDetail {
    public String username, phonenumber, email, address, password, rank, score;

    public ReadWriteUserDetail(){}

    public String getUsername() {
        return username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getRank() {
        return rank;
    }

    public String getScore() {
        return score;
    }

    public ReadWriteUserDetail(String username, String score, String rank)
    {
        this.username =username;
        this.score = score;
        this.rank = rank;
    }

    public ReadWriteUserDetail(String username, String email)
    {
        this.username =username;
        this.email = email;
    }

    public ReadWriteUserDetail(String username, String phonenumber, String address, int a)
    {
        this.username =username;
        this.phonenumber = phonenumber;
        this.address = address;
        a = 1;
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

    public void setRank(String rank) {
        this.rank = rank;
    }
}
