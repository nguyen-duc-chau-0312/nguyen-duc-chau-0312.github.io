package com.company;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static void nhapTk(TaiKhoan account) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập số tài khoản: ");
        account.setSoTk(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Mời bạn nhập tên tài khoản: ");
        account.setTenTk(scanner.nextLine());
        account.setTienTk(50_000);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaiKhoan a[] = null;
        int cv, n = 0;
        long soTaiKhoanKH, account, taiKhoanNhan, tKNhan;
        boolean check = true;
        do {
            System.out.println("Ấn phím tương ứng để thực hiện công việc bạn muốn: ");
            System.out.println("1.Nhập thông tin của các khách hàng\n"
                    + "2.Xuất danh sách thông tin của các khách hàng\n" + "3.Nạp tiền\n" + "4.Rút tiền\n"
                    + "5.Lãi xuất \n" + "6.Chuyển khoản\n" + "7.Đáo hạn nợ\n" + "Số khác để thoát");
            System.out.print("Mời bạn chọn công việc: ");
            cv = sc.nextInt();
            switch (cv) {
                case 1:
                    System.out.print("Mời bạn nhập số lượng khách hàng cần mở thẻ: ");
                    n = sc.nextInt();
                    a = new TaiKhoan[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Khách hàng thứ: " + (i + 1));
                        a[i] = new TaiKhoan();
                        nhapTk(a[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-20s %-20s %-20s\n", "Số Tài Khoản", "Tên Tài Khoản", "Số tiền trong TK");
                    for (int i = 0; i < n; i++) {
                        a[i].inTK();
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Nhập số tài khoản khách hàng cần nạp tiền: ");
                    soTaiKhoanKH = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        account = a[i].getSoTk();
                        if (soTaiKhoanKH == account) {
                            System.out.println("Bạn chọn tài khoản: " + account);
                            a[i].napTien();
                            break;
                        } else {
                            System.out.print("Tài khoản bạn chông đúng!\n Mời bạn nhập lại số tài khoản: ");
                            soTaiKhoanKH = sc.nextLong();
                        }
                    }

                    break;
                case 4:
                    System.out.print("Nhập số tài khoản khách hàng cần rút tiền: ");
                    soTaiKhoanKH = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        account = a[i].getSoTk();
                        if (soTaiKhoanKH == account) {
                            System.out.println("Bạn chọn tài khoản: " + account);
                            a[i].rutTien();
                            break;
                        } else {
                            System.out.print("Số tài khoản bạn nhập không hợp lệ \n Mời bạn nhập lại số tài khoản: ");
                            soTaiKhoanKH = sc.nextInt();
                        }
                    }
                    break;
                case 5:
                    System.out.print("Nhập số tài khoản khách hàng nhận được lãi xuất: ");
                    soTaiKhoanKH = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        account = a[i].getSoTk();
                        if (soTaiKhoanKH == account) {
                            System.out.println("Bạn chọn tài khoản: " + account);
                            a[i].laiXuat();
                            break;
                        } else {
                            System.out.print("Tài khoản bạn chọn không hợp lệ \n Mời bạn nhập lại: ");
                            soTaiKhoanKH = sc.nextInt();
                        }
                    }
                    break;
                case 6:
                    double chuyen, nhan, tienChuyen;
                    System.out.print("Nhập số tài khoản khách hàng chuyển tiền: ");
                    soTaiKhoanKH = sc.nextLong();
                    System.out.print("Nhập số tài khoản khách hàng nhận tiền: ");
                    taiKhoanNhan = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        account = a[i].getSoTk();
                        if (soTaiKhoanKH == account) {
                            chuyen = a[i].getTienTk();
                            for (int j = 0; j < n; j++) {
                                tKNhan = a[j].getSoTk();
                                if (taiKhoanNhan == tKNhan) {
                                    nhan = a[j].getTienTk();
                                    System.out.print("Mời bạn nhập số tiền cần chuyển: ");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setTienTk(chuyen);
                                        a[j].setTienTk(nhan);
                                        Locale localeVN = new Locale("vi", "VN");
                                        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

                                        System.out.println(TaiKhoan.RED + "Tài khoản số " + account + " vừa chuyển: " + currencyVN.format(tienChuyen) + TaiKhoan.ANSI_RESET);
                                        System.out.println(TaiKhoan.RED + "Tài khoản số " + tKNhan + " vừa nhận: " + currencyVN.format(tienChuyen) + TaiKhoan.ANSI_RESET);
                                        System.out.println(TaiKhoan.RED + "Số dư " + a[j].getTenTk() + " là: " + currencyVN.format(a[j].getTienTk()) + TaiKhoan.ANSI_RESET);
                                    } else {
                                        System.out.println("Số tiền bạn muốn chuyển khô hợp lệ!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 7: {
                    System.out.print("Nhập số tài khoản khách hàng phải trả nợ: ");
                    soTaiKhoanKH = sc.nextInt();
                    for (int i = 0; i < n; i++){
                        account = a[i].getSoTk();
                        if(soTaiKhoanKH == account){
                            System.out.println("Mời bạn chọn tài khoản trả nợ: "+account);
                            a[i].daoHan();
                            break;
                        }else{
                            System.out.print("Tài khoản bạn chọn không hợp lệ \n Mời bạn nhập lại: ");
                            soTaiKhoanKH = sc.nextInt();
                        }
                    }
                    break;

                }
                default:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                    check = false;
                    break;
            }
        } while (check);
    }
}

