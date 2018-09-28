package com.bf.main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator 测试写入数据库以及从数据库中读取
 */
public class ImageDemo {

    // 将图片插入数据库
    public static void readImage2DB() {
        String path = "C:\\Users\\bofei\\Desktop\\q4.png";
        String path2 = "C:\\Users\\bofei\\Desktop\\q9.png";
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in1 = null;
        FileInputStream in2 = null;
        try {
            in1 = ImageUtil.readImage(path);
            in2 = ImageUtil.readImage(path2);
            conn = DBUtil.getConn();
//            String sql = "insert into photo (id,name,photo)values(?,?,?)";
//            String sql = "INSERT INTO subjectphoto VALUES (?, ?, ?, ?)";
//            String sql = "INSERT INTO facecapture_temp(FacePhoto, BodyPhoto) VALUES(?, ?)";
//            String sql = "INSERT INTO facecapture_body(bid, BodyPhoto) VALUES (?, ?)";
//            String sql = "INSERT INTO facecapture(FacePhoto, BodyPhoto, CameraID) VALUES (?, ?, ?)";
            String sql = "INSERT INTO cameraconfig(VideoCut) VALUES (?)";
            ps = conn.prepareStatement(sql);
//            ps.setInt(1, 1);
//            ps.setInt(2, 1);
            ps.setBinaryStream(1, in1, in1.available());
//            ps.setBinaryStream(2, in2, in2.available());
//            ps.setBinaryStream(3, in2, in2.available());
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 读取数据库中图片
    public static void readDB2Image() {
        String targetPath = "D:/image/1.png";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from photo where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("photo");
                ImageUtil.readBin2Image(in, targetPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //测试
    public static void main(String[] args) {
        readImage2DB();
//        readDB2Image();
    }
}