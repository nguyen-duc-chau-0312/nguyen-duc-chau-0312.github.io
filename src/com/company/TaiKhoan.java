package com.company;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class TaiKhoan implements CongViec {
    private final double LAI_XUAT = 0.01;
    private final double RATE1 = 0.015;
    private final double RATE2 = 0.02;
    private final double RATE3 = 0.03;
    private int soTk;
    private String tenTk;
    private double tienTk;
    private double tienVay;

    Scanner sc = new Scanner(System.in);
    public static final String RED = "\033[0;31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public TaiKhoan() {

    }

    public TaiKhoan(int soTk, String tenTk, double tienTk, double tienVay) {
        this.soTk = soTk;
        this.tenTk = tenTk;
        this.tienTk = tienTk;
        this.tienVay = tienVay;
    }

    public int getSoTk() {
        return soTk;
    }

    public String getTenTk() {
        return tenTk;
    }

    public double getTienTk() {
        return tienTk;
    }

    public double getTienVay() {
        return tienVay;
    }

    public void setTienTk(double tienTk) {
        this.tienTk = tienTk;
    }

    public void setSoTk(int soTk) {
        this.soTk = soTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public void setTienVay(double tienVay) {
        this.tienVay = tienVay;
    }


    @Override
    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str = currencyVN.format(tienTk);
        return soTk + "\t" + tenTk + "\t" + str;
    }

    @Override
    public void napTien() {
        double payIn;
        System.out.print("Mời bạn nhập số tiền cần nạp: ");
        payIn = sc.nextDouble();
        while (true) {
            if (payIn >= 0) {
                tienTk = payIn + tienTk;
                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                String str = currencyVN.format(payIn);
                System.out.println(RED + "Bạn vừa nạp " + str + " vào tài khoản " + tenTk + ANSI_RESET);
                System.out.println(RED + "Số dư hiện tại của tài khoản " + tenTk + " là " + currencyVN.format(tienTk) + ANSI_RESET);
                System.out.println();
                break;
            } else {
                System.out.print("số tiền bạn nạp không hợp lệ\n Mời bạn nhập lại số tiền nạp: ");
                payIn = sc.nextDouble();
            }
        }

    }

    @Override
    public void rutTien() {
        double phi = 1_000 + 1_000 * 0.1;
        double withDraw;
        System.out.print("Mời bạn nhập số tiền cần rút: ");
        withDraw = sc.nextDouble();
        while (true) {
//            if () {
//                System.out.println("Số dư tài khoản không đủ để bạn rút tiền!");
//            }
            if (tienTk >= 50000 && withDraw <= (tienTk - phi)) {
                tienTk = tienTk - (withDraw + phi);
                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                String str = currencyVN.format(withDraw);
                System.out.println(RED + "Bạn vừa rút " + withDraw + " từ tài khoản " + tenTk + ANSI_RESET);
                System.out.println(RED + "Số dư hiện tại của tài khoản " + tenTk + " là " + currencyVN.format(tienTk) + ANSI_RESET);
                System.out.println();
                break;
            } else {
                System.out.print("So tien ban muon rut khong hop le\n Mời bạn nhập lại số tiền rút: ");
                withDraw = sc.nextDouble();
            }
        }
    }

    @Override
    public void laiXuat() {
        tienTk = tienTk + tienTk * LAI_XUAT;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str = currencyVN.format(tienTk);
        System.out.println(RED + "Số dư hiện tại sau khi nhận lãi xuất 1 tháng của tài khoản " + tenTk + " là " + currencyVN.format(tienTk) + ANSI_RESET);
        System.out.println();
    }

    @Override
    public void daoHan() {
        System.out.print("Nhập số tiền cần vay: ");
        tienVay = sc.nextDouble();
        if (getTienVay() < 100000) {
            tienTk = tienTk - (tienVay + tienVay * RATE1);
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str = currencyVN.format(tienTk);
            System.out.println(RED + "Số dư hiện tại sau khi nhận lãi xuất 1 tháng của tài khoản " + tenTk + " là " + currencyVN.format(tienTk) + ANSI_RESET);
            System.out.println();
        } else if (100000 < getTienVay() && getTienVay() < 500000) {
            tienTk = tienTk - (tienVay + tienVay * RATE2);
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str = currencyVN.format(tienTk);
            System.out.println(RED + "Số dư hiện tại sau khi nhận lãi xuất 1 tháng của tài khoản " + tenTk + " là " + currencyVN.format(tienTk) + ANSI_RESET);
            System.out.println();
        }else {
            tienTk = tienTk - (tienVay + tienVay * RATE3);
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str = currencyVN.format(tienTk);
            System.out.println(RED + "Số dư hiện tại sau khi nhận lãi xuất 1 tháng của tài khoản " + tenTk + " là " + currencyVN.format(tienTk) + ANSI_RESET);
            System.out.println();
        }
    }

    void inTK() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str = currencyVN.format(tienTk);
        System.out.printf(RED + "  %-16d %-25s %-30s \n", soTk, tenTk, str + ANSI_RESET);
    }

}
