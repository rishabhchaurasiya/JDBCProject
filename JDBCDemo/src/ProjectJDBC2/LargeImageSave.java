package ProjectJDBC2;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import JDBC.connectionProvider;

public class LargeImageSave {

	public static void main(String[] args) {

		try {
			
			Connection c = connectionProvider.getConnection();
			
			String q = "insert into images(pic) values(?)";
			
			java.sql.PreparedStatement pstmt = c.prepareStatement(q);
			
			JFileChooser jfc = new JFileChooser();
			
			jfc.showOpenDialog(null);
			
			File file = jfc.getSelectedFile();
			
			FileInputStream fis = new FileInputStream(file);
			
			pstmt.setBinaryStream(1, fis, fis.available());
			
			pstmt.executeUpdate();
			
//			System.out.println("done");

			JOptionPane.showMessageDialog(null, "success");
			
			c.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
