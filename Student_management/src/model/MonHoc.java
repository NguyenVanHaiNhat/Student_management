package model;

public class MonHoc extends Student implements PointCaculate {
    private String tenMonHoc;
    private String maMonHoc;
    private double diemChuyenCan;
    private double diemBaiTap;
    private double diemGiuaKi;
    private double diemCuoiKi;
    public MonHoc(){

    }

    public MonHoc(String tenMonHoc, String maMonHoc, double diemChuyenCan, double diemBaiTap, double diemGiuaKi, double diemCuoiKi) {
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;
        this.diemChuyenCan = diemChuyenCan;
        this.diemBaiTap = diemBaiTap;
        this.diemGiuaKi = diemGiuaKi;
        this.diemCuoiKi = diemCuoiKi;
    }

    public MonHoc(String studentCode, String firstName, String lastName, String gender, String dayOfBirth, String phone, String tenMonHoc, String maMonHoc, double diemChuyenCan, double diemBaiTap, double diemGiuaKi, double diemCuoiKi) {
        super(studentCode, firstName, lastName, gender, dayOfBirth, phone);
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;
        this.diemChuyenCan = diemChuyenCan;
        this.diemBaiTap = diemBaiTap;
        this.diemGiuaKi = diemGiuaKi;
        this.diemCuoiKi = diemCuoiKi;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public double getDiemChuyenCan() {
        return diemChuyenCan;
    }

    public void setDiemChuyenCan(double diemChuyenCan) {
        this.diemChuyenCan = diemChuyenCan;
    }

    public double getDiemBaiTap() {
        return diemBaiTap;
    }

    public void setDiemBaiTap(double diemBaiTap) {
        this.diemBaiTap = diemBaiTap;
    }

    public double getDiemGiuaKi() {
        return diemGiuaKi;
    }

    public void setDiemGiuaKi(double diemGiuaKi) {
        this.diemGiuaKi = diemGiuaKi;
    }

    public double getDiemCuoiKi() {
        return diemCuoiKi;
    }

    public void setDiemCuoiKi(double diemCuoiKi) {
        this.diemCuoiKi = diemCuoiKi;
    }

    @Override
    public double getDiemTong() {
        return (diemChuyenCan + diemBaiTap + diemGiuaKi*2 + diemCuoiKi*3);
    }

    @Override
    public double getDiemTrungBinh() {
        return (diemChuyenCan + diemBaiTap + diemGiuaKi*2 + diemCuoiKi*3) / 7;
    }
}
