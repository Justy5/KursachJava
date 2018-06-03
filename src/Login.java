import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

public class Login {
    int status = 0;
    Start start;
    JPanel loginPanel, loginBtnPanel;
    JLabel loginLbl;
    JFrame f;
    JPanel forRegPanel;
    Login(){
        f = new JFrame();
        UIManager.put("Panel.background", new Color(5,157, 219));
        JPanel inner = new JPanel();
        f.setSize(new Dimension(500,500));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(screenSize.width/2-250, screenSize.height/2-250);
        inner.setPreferredSize(new Dimension(500,450));
        inner.setLayout(new BoxLayout(inner, BoxLayout.PAGE_AXIS));
        f.add(inner);
        JPanel lblPanel = new JPanel();
        loginLbl = new JLabel("Авторизація");
        inner.add(Box.createVerticalGlue());
        lblPanel.add(loginLbl);
        inner.add(lblPanel);
        loginLbl.setFont(new Font("Arial", Font.BOLD, 30));
        inner.add(Box.createVerticalGlue());
        JPanel autorizationPanel = new JPanel();
        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));

        JPanel loginP = new JPanel();
        loginP.setLayout(new BoxLayout(loginP, BoxLayout.PAGE_AXIS));
        JTextField login = new JTextField();
        login.setPreferredSize(new Dimension(250,30));
        login.setMaximumSize(new Dimension(250,30));
        login.setMinimumSize(new Dimension(250,30));
        JLabel overloginLbl = new JLabel("Логін");
        overloginLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        login.setAlignmentX(Label.LEFT_ALIGNMENT);
        loginP.add(overloginLbl);
        loginP.add(login);
        login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        JPanel password = new JPanel();
        password.setLayout(new BoxLayout(password, BoxLayout.PAGE_AXIS));
        JLabel overpassLbl = new JLabel("Пароль");
        password.add(overpassLbl);
        JPasswordField pass = new JPasswordField();
        overpassLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        pass.setAlignmentX(Label.LEFT_ALIGNMENT);
        pass.setPreferredSize(new Dimension(250,30));
        pass.setMaximumSize(new Dimension(250,30));
        pass.setMinimumSize(new Dimension(250,30));
        password.add(pass);
        loginPanel.add(loginP);
        loginPanel.add(Box.createRigidArea(new Dimension(10,30)));
        loginPanel.add(password);
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.PAGE_AXIS));
        loginBtnPanel = new JPanel();
        JButton loginBtn = new JButton("Ввійти");
        loginBtnPanel.add(Box.createHorizontalGlue());
        loginBtnPanel.add(loginBtn);
        loginBtnPanel.add(Box.createHorizontalGlue());
        loginBtn.addActionListener(e -> {
            try {
                Statement statement = DB.getConnection().createStatement();
                ResultSet res = statement.executeQuery("SELECT * FROM menegers WHERE login = '" + login.getText() + "' and password = '" + new String(Base64.getEncoder().encode(pass.getText().getBytes())) + "'");


                if(res.next()){
                    status = 1;
                    Session.setSession (res.getInt("id"), res.getString("manager_name"), res.getString("status"));
                }
                else{
                    JOptionPane.showMessageDialog(inner, "Користувача з таким логіном і паролем не існує!");

                    byte[] bytesEncoded = Base64.getEncoder().encode("654321".getBytes());

                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

       /* JLabel forgotPass = new JLabel("Забули пароль?");*/
        JLabel registerLbl = new JLabel("Реєстрація");


        Thread a = new Thread(){
          @Override
          public void run(){
                  try {
                      while (true) {
                          if (status == 1) {
                              f.hide();
                              UIManager.put("Panel.background", new Color(255,255, 255));
                              start = new Start();
                              this.interrupt();
                          }
                          Thread.sleep(200);
                      }
                  } catch (Exception e) {

                  }
              }
          };

        registerLbl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterForm register = new RegisterForm();
                register.callReg(f);
                f.hide();
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

    /*    forgotPass.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               try {
                   Statement state = DB.getConnection().createStatement();
                   ResultSet res = state.executeQuery("SELECT password, email FROM menegers WHERE login = '" + login.getText() + "'");
                   if(res.next()) {
                       SendEmail sendEmail = new SendEmail();
                       sendEmail.SendMessage(res.getString("email"), "Відновлення паролю!", "Ваш пароль: " + Base64.getDecoder().decode(res.getString("password")).toString());
                       JOptionPane.showMessageDialog(loginPanel, "Повідомлення відправлено на пошту!");
                   }else
                       JOptionPane.showMessageDialog(loginPanel, "Введіть корректний логін для відновлення!");

               }catch (Exception ex){
                   ex.printStackTrace();
               }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
*/

        a.start();
        btnPanel.add(loginBtnPanel);
        forRegPanel = new JPanel();
        forRegPanel.add(Box.createHorizontalGlue());
       /* forRegPanel.add(forgotPass);*/
        forRegPanel.add(Box.createRigidArea(new Dimension(5,3)));
        forRegPanel.add(registerLbl);
        forRegPanel.add(Box.createRigidArea(new Dimension(15,3)));
        forRegPanel.add(Box.createHorizontalGlue());
        btnPanel.add(forRegPanel);

        autorizationPanel.add(Box.createHorizontalGlue());
        autorizationPanel.add(loginPanel);
        autorizationPanel.add(Box.createHorizontalGlue());
        inner.add(autorizationPanel);
        inner.add(Box.createVerticalGlue());
        inner.add(btnPanel);
        inner.add(Box.createVerticalGlue());
        f.show();

    }
}
